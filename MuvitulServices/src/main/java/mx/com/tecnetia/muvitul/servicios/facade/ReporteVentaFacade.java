package mx.com.tecnetia.muvitul.servicios.facade;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.enumeration.ClaimsEnum;
import mx.com.tecnetia.muvitul.infraservices.servicios.NotFoundException;
import mx.com.tecnetia.muvitul.negocio.reportes.vo.ArchivoExcelVO;
import mx.com.tecnetia.muvitul.servicios.reportes.controller.ReporteVentasTaquillaController;

@Service
public class ReporteVentaFacade implements ReporteVentaFacadeI {
	private static final Logger logger = LoggerFactory.getLogger(ReporteVentaFacade.class);

	@Autowired
	private ReporteVentasTaquillaController reporteJasperController;

	@Override
	public ResponseEntity<ArchivoExcelVO> reporteVentaDulceriaTaquilla(HttpServletRequest request,String codigoReporte,String fechaInicio,String fechaFin,String idArticulo) throws Exception {
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		Integer idPuntoVenta = (Integer) claims.get(ClaimsEnum.PUNTO_VENTA);

		ArchivoExcelVO archivoExcelVO=null;
		if (codigoReporte.equals("KARDEX"))
			archivoExcelVO= reporteJasperController.crearReporteXls(idCine,idUsuario,idPuntoVenta,  fechaInicio,  fechaFin,  idArticulo);
		else if(codigoReporte.equals("VENTAS-DIA"))
			archivoExcelVO= reporteJasperController.generarReporteVentas(idCine,idUsuario,idPuntoVenta,  fechaInicio,  fechaFin);
		else if(codigoReporte.equals("VENTAS-SEMANA"))
			archivoExcelVO= reporteJasperController.generarReporteVentasSemanal(idCine,idUsuario,idPuntoVenta,  fechaInicio,  fechaFin);
		else if(codigoReporte.equals("VENTAS-MENSUAL"))
			archivoExcelVO= reporteJasperController.generarReporteVentasMensual(idCine,idUsuario, idPuntoVenta, fechaInicio,  fechaFin);

		if (archivoExcelVO == null ) {
			throw new NotFoundException("No encontrado");
		}
		return new ResponseEntity<ArchivoExcelVO>(archivoExcelVO, HttpStatus.OK);
	}

}
