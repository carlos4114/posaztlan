package mx.com.tecnetia.muvitul.negocio.reportes.business;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ReportesCineXDistribuidoraDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ReportesCineXDistribuidora;
import mx.com.tecnetia.muvitul.negocio.reportes.assembler.ReportesCineXDistribuidoraAssembler;
import mx.com.tecnetia.muvitul.negocio.reportes.vo.ReportesCineXDistribuidoraVO;
import mx.com.tecnetia.muvitul.servicios.util.Fecha;

@Service
@Transactional
public class ReporteDistribuidoraBO {
	
	private static final Logger logger = LoggerFactory.getLogger(ReporteDistribuidoraBO.class);
	@Autowired
	private ServletContext context;
	@Autowired
	private ReportesCineXDistribuidoraDAO reportesCineXDistribuidoraDAO;
	
	private HashMap<String, Object> parametros;
	private String rutaReporteJasper;
	private String rutaReporteXls;
	private String rutaPlantillaVm;
	private String[] rutasArchivoAjuntos;
	private String[] destinatarios;	
	private String asunto;
	private String cuerpo;
	private final String MSG_ERROR="Error al envíar ";
	
	public void generarParametros(ReportesCineXDistribuidoraVO reporte){
		ResourceBundle cfg = ResourceBundle.getBundle("config");
		HashMap<String, Object> parametros = new HashMap<String, Object>();
		String rutaReporteJasper,rutaReporteXls,rutaPlantillaVm,asunto,cuerpo;
		SimpleDateFormat fecha = new SimpleDateFormat("yyyy/MM/dd");
		
		parametros.put("fechaInicial",fecha.format(reporte.getFechaInicio()));
		parametros.put("fechaFinal",fecha.format(reporte.getFechaFin()));
		parametros.put("idCine", reporte.getCine().getIdCine());
		parametros.put("idPelicula",reporte.getPelicula().getIdPelicula());
		parametros.put("idDistribuidora",reporte.getPelicula().getDistribuidora().getIdDistribuidora());
				
		rutaReporteJasper = cfg.getString(reporte.getReportesDistribuidora().getRutaReporteJasper());	
		rutaReporteXls = context.getRealPath(cfg.getString(reporte.getReportesDistribuidora().getRutaReporteXls()));
		 rutaPlantillaVm = cfg.getString(reporte.getReportesDistribuidora().getRutaPlantillaVm());
		String[] rutasArchivoAjuntos = {rutaReporteXls};
		String[] destinatarios = reporte.getDestinatarios().split(",");		
		asunto = reporte.getAsunto() + " - " +  reporte.getCine().getNombre();
		
		if(!reporte.getReportesDistribuidora().getRutaReporteJasper().contains("comscore")){
			asunto = asunto + " - " + reporte.getPelicula().getTitulo();
		}
		
		cuerpo = "";
		
		this.parametros = parametros;
		this.rutaReporteJasper = rutaReporteJasper;
		this.rutaReporteXls = rutaReporteXls;
		this.rutaPlantillaVm = rutaPlantillaVm;
		this.rutasArchivoAjuntos = rutasArchivoAjuntos;
		this.destinatarios = destinatarios;
		this.asunto = asunto;
		this.cuerpo = cuerpo;
	}
	
	public void generarParametrosError(ReportesCineXDistribuidoraVO reporte){
		ResourceBundle cfg = ResourceBundle.getBundle("config");
		SimpleDateFormat fecha = new SimpleDateFormat("yyyy/MM/dd");
	
		rutaPlantillaVm = cfg.getString(reporte.getReportesDistribuidora().getRutaPlantillaVmError());
		String[] rutasArchivoAjuntos = {};
		String[] destinatarios = reporte.getEmailError().split(",");
		asunto = MSG_ERROR+" "+reporte.getAsunto()+" - Fecha de envío: "+ fecha.format(reporte.getFechaEnvio()) + " - " +  reporte.getCine().getNombre();
		
		if(!reporte.getReportesDistribuidora().getRutaReporteJasper().contains("comscore")){
			asunto = asunto + " - " + reporte.getPelicula().getTitulo();
		}
		
		cuerpo = "";
		
		this.rutaPlantillaVm = rutaPlantillaVm;
		this.rutasArchivoAjuntos = rutasArchivoAjuntos;
		this.destinatarios = destinatarios;
		this.asunto = asunto;
		this.cuerpo = cuerpo;
	}

	@Transactional(readOnly=true)
	public List<ReportesCineXDistribuidoraVO> obtenerReportesActivos(){
		return ReportesCineXDistribuidoraAssembler.
				getReportesCineXDistribuidoraVO(reportesCineXDistribuidoraDAO.findActivos());
	}

	public Integer actulizarFechas(ReportesCineXDistribuidoraVO reporte){
		ReportesCineXDistribuidora reporteDTO = reportesCineXDistribuidoraDAO.getById(reporte.getIdReporte());
		
		reporteDTO.setFechaInicio(Fecha.sumarRestarDiasFecha(reporteDTO.getFechaInicio(),reporteDTO.getDiasPeriodo()));        
		reporteDTO.setFechaFin(Fecha.sumarRestarDiasFecha(reporteDTO.getFechaFin(),reporteDTO.getDiasPeriodo()));
		reporteDTO.setFechaEnvio(Fecha.sumarRestarDiasFecha(reporteDTO.getFechaEnvio(),reporteDTO.getDiasEnvio()));
		reportesCineXDistribuidoraDAO.update(reporteDTO);
		
		return reporteDTO.getIdReporte();
	}
	
	public HashMap<String, Object> getParametros() {
		return parametros;
	}

	public void setParametros(HashMap<String, Object> parametros) {
		this.parametros = parametros;
	}

	public String getRutaReporteJasper() {
		return rutaReporteJasper;
	}

	public void setRutaReporteJasper(String rutaReporteJasper) {
		this.rutaReporteJasper = rutaReporteJasper;
	}

	public String getRutaReporteXls() {
		return rutaReporteXls;
	}

	public void setRutaReporteXls(String rutaReporteXls) {
		this.rutaReporteXls = rutaReporteXls;
	}

	public String getRutaPlantillaVm() {
		return rutaPlantillaVm;
	}

	public void setRutaPlantillaVm(String rutaPlantillaVm) {
		this.rutaPlantillaVm = rutaPlantillaVm;
	}

	public String[] getRutasArchivoAjuntos() {
		return rutasArchivoAjuntos;
	}

	public void setRutasArchivoAjuntos(String[] rutasArchivoAjuntos) {
		this.rutasArchivoAjuntos = rutasArchivoAjuntos;
	}

	public String[] getDestinatarios() {
		return destinatarios;
	}

	public void setDestinatarios(String[] destinatarios) {
		this.destinatarios = destinatarios;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

}
