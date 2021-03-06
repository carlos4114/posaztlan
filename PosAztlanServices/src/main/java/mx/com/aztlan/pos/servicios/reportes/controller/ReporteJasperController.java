package mx.com.aztlan.pos.servicios.reportes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.aztlan.pos.negocio.reportes.business.ReporteJasperBO;
import mx.com.aztlan.pos.negocio.reportes.vo.ReporteJasperVO;

@Service
public class ReporteJasperController {
	@Autowired
	ReporteJasperBO reporteJasperBO;

	public void crearReporteXls(ReporteJasperVO reporteJasperVO) throws Exception {
		this.reporteJasperBO.crearReporteXls(reporteJasperVO);
	}

	public void setReporteJasperBO(ReporteJasperBO reporteJasperBO) {
		this.reporteJasperBO = reporteJasperBO;
	}

}
