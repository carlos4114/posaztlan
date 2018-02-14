package mx.com.aztlan.pos.servicios.facade;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.com.aztlan.pos.negocio.reportes.vo.ArchivoExcelVO;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/reportes")
public interface ReporteVentaFacadeI {
	@RequestMapping(value = "/ventas", method = RequestMethod.GET)
	public ResponseEntity<ArchivoExcelVO> reporteVentaDulceriaTaquilla(HttpServletRequest request,@RequestParam(value = "codigoReporte")String codigoReporte,@RequestParam(value = "fechaInicio")String fechaInicio,@RequestParam(value = "fechaFin")String fechaFin, @RequestParam(value = "idArticulo")String idArticulo) throws  Exception;

}
