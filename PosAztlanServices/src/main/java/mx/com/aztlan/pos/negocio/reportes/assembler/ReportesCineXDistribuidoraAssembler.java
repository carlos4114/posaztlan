package mx.com.aztlan.pos.negocio.reportes.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ReportesCineXDistribuidora;
import mx.com.aztlan.pos.negocio.configuracion.assembler.CineAssembler;
import mx.com.aztlan.pos.negocio.configuracion.assembler.PeliculaAssembler;
import mx.com.aztlan.pos.negocio.reportes.vo.ReportesCineXDistribuidoraVO;
import mx.com.aztlan.pos.negocio.taquilla.assembler.DistribuidoraAssembler;

public class ReportesCineXDistribuidoraAssembler {

	public static ReportesCineXDistribuidoraVO getReportesCineXDistribuidoraVO(ReportesCineXDistribuidora reportesCineXDistribuidoraDTO){
		if(reportesCineXDistribuidoraDTO==null)
			return null;
		
		ReportesCineXDistribuidoraVO reportesCineXDistribuidoraVO = new ReportesCineXDistribuidoraVO();
		reportesCineXDistribuidoraVO.setIdReporte(reportesCineXDistribuidoraDTO.getIdReporte());
		reportesCineXDistribuidoraVO.setCine(CineAssembler.getCineVO(reportesCineXDistribuidoraDTO.getCine()));
		reportesCineXDistribuidoraVO.setPelicula(PeliculaAssembler.getPeliculaVO(reportesCineXDistribuidoraDTO.getPelicula()));
		reportesCineXDistribuidoraVO.setFechaInicio(reportesCineXDistribuidoraDTO.getFechaInicio());
		reportesCineXDistribuidoraVO.setFechaFin(reportesCineXDistribuidoraDTO.getFechaFin());	
		reportesCineXDistribuidoraVO.setReportesDistribuidora(ReportesDistribuidoraAssembler.getReportesDistribuidoraVO(reportesCineXDistribuidoraDTO.getReporteDistribuidora()));
		reportesCineXDistribuidoraVO.setDestinatarios(reportesCineXDistribuidoraDTO.getDestinatarios());
		reportesCineXDistribuidoraVO.setAsunto(reportesCineXDistribuidoraDTO.getAsunto());
		reportesCineXDistribuidoraVO.setDiasPeriodo(reportesCineXDistribuidoraDTO.getDiasPeriodo());
		reportesCineXDistribuidoraVO.setDiasEnvio(reportesCineXDistribuidoraDTO.getDiasEnvio());
		reportesCineXDistribuidoraVO.setFechaEnvio(reportesCineXDistribuidoraDTO.getFechaEnvio());	
		reportesCineXDistribuidoraVO.setEmailError(reportesCineXDistribuidoraDTO.getEmailError());
		reportesCineXDistribuidoraVO.setActivo(reportesCineXDistribuidoraDTO.isActivo());
		
		return reportesCineXDistribuidoraVO;
	}
	
	public static ReportesCineXDistribuidora getReportesCineXDistribuidora(ReportesCineXDistribuidoraVO reportesCineXDistribuidoraVO){
		if(reportesCineXDistribuidoraVO==null)
			return null;
		
		ReportesCineXDistribuidora reportesCineXDistribuidoraDTO = new ReportesCineXDistribuidora();
		
		reportesCineXDistribuidoraDTO.setIdReporte(reportesCineXDistribuidoraVO.getIdReporte());
		reportesCineXDistribuidoraDTO.setCine(CineAssembler.getCine(reportesCineXDistribuidoraVO.getCine().getIdCine()));
		reportesCineXDistribuidoraDTO.setPelicula(PeliculaAssembler.getPelicula(reportesCineXDistribuidoraVO.getPelicula().getIdPelicula()));
		reportesCineXDistribuidoraDTO.setFechaInicio(reportesCineXDistribuidoraVO.getFechaInicio());
		reportesCineXDistribuidoraDTO.setFechaFin(reportesCineXDistribuidoraVO.getFechaFin());
		reportesCineXDistribuidoraDTO.setReporteDistribuidora(ReportesDistribuidoraAssembler.getReportesDistribuidora(reportesCineXDistribuidoraVO.getReportesDistribuidora()));
		reportesCineXDistribuidoraDTO.setDestinatarios(reportesCineXDistribuidoraVO.getDestinatarios());
		reportesCineXDistribuidoraDTO.setAsunto(reportesCineXDistribuidoraVO.getAsunto());
		reportesCineXDistribuidoraDTO.setDiasPeriodo(reportesCineXDistribuidoraVO.getDiasPeriodo());
		reportesCineXDistribuidoraDTO.setDiasEnvio(reportesCineXDistribuidoraVO.getDiasEnvio());
		reportesCineXDistribuidoraDTO.setFechaEnvio(reportesCineXDistribuidoraVO.getFechaEnvio());
		reportesCineXDistribuidoraDTO.setEmailError(reportesCineXDistribuidoraVO.getEmailError());
		reportesCineXDistribuidoraDTO.setActivo(reportesCineXDistribuidoraVO.isActivo());
		
		return reportesCineXDistribuidoraDTO;
	}
	
	
	public static List<ReportesCineXDistribuidoraVO> getReportesCineXDistribuidoraVO(List<ReportesCineXDistribuidora> reportesCineXDistribuidora){
		
		if(reportesCineXDistribuidora==null || reportesCineXDistribuidora.isEmpty())
			return null;
		
		List<ReportesCineXDistribuidoraVO> reportesCineXDistribuidoraVO = new ArrayList<ReportesCineXDistribuidoraVO>();
		
		for (ReportesCineXDistribuidora reporte : reportesCineXDistribuidora) {
			reportesCineXDistribuidoraVO.add(ReportesCineXDistribuidoraAssembler.getReportesCineXDistribuidoraVO(reporte));
		}

		return reportesCineXDistribuidoraVO;
		
	}
}
