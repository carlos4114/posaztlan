package mx.com.tecnetia.muvitul.servicios.facade;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.infraservices.servicios.NotFoundException;
import mx.com.tecnetia.muvitul.negocio.reportes.vo.ReporteJasperVO;
import mx.com.tecnetia.muvitul.servicios.reportes.controller.ReporteJasperController;

@Service
public class ReporteVentaFacade implements ReporteVentaFacadeI {
	private static final Logger logger = LoggerFactory.getLogger(ReporteVentaFacade.class);

	@Autowired
	private ReporteJasperController reporteJasperController;

	@Override
	public ResponseEntity<Integer> reporteVentaDulceriaTaquilla(HttpServletRequest request, ReporteJasperVO reporteVO) throws Exception {
		ResourceBundle cfg = ResourceBundle.getBundle("config");
		String rutaVentasJasper = cfg.getString("reporte.ventas.taquilla-dulceria.jasper");
		int response = 1;
		ReporteJasperVO reporte  = new ReporteJasperVO();
		reporte.setRutaXls("WEB-INF/jasper/ventas");
		reporte.setRutaReporte(rutaVentasJasper);
		this.reporteJasperController.crearReporteXls(reporte);

		return new ResponseEntity<Integer>(response, HttpStatus.OK);
	}

}
