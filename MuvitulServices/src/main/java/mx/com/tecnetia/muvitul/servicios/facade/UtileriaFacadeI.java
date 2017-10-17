package mx.com.tecnetia.muvitul.servicios.facade;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.tecnetia.muvitul.negocio.reportes.vo.ReporteJasperVO;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/utileria")
public interface UtileriaFacadeI {

	@RequestMapping(value = "/crearReporteXls/", method = RequestMethod.POST)
    ResponseEntity<Integer> crearReporteXls(HttpServletRequest request,@RequestBody ReporteJasperVO reporteVO) throws Exception;

}
