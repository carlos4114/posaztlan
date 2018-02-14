package mx.com.aztlan.pos.servicios.facade;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import mx.com.aztlan.pos.negocio.reportes.vo.ReporteJasperVO;
import mx.com.aztlan.pos.servicios.reportes.controller.ReporteJasperController;

@Service
public class UtileriaFacade implements UtileriaFacadeI{      
  		
	@Autowired
	ReporteJasperController reporteJasperController;
		
	@Override
	public ResponseEntity<Integer> crearReporteXls(HttpServletRequest request,@RequestBody ReporteJasperVO reporteVO)
			throws Exception {
		int response = 1;
		
		this.reporteJasperController.crearReporteXls(reporteVO);
		return new ResponseEntity<Integer>(response, HttpStatus.OK);
	}   
	
	
}
