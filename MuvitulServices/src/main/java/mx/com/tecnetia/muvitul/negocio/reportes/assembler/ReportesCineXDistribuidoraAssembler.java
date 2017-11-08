package mx.com.tecnetia.muvitul.negocio.reportes.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ReportesCineXDistribuidora;
import mx.com.tecnetia.muvitul.negocio.configuracion.assembler.CineAssembler;
import mx.com.tecnetia.muvitul.negocio.configuracion.assembler.PeliculaAssembler;
import mx.com.tecnetia.muvitul.negocio.reportes.vo.ReportesCineXDistribuidoraVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.assembler.DistribuidoraAssembler;

public class ReportesCineXDistribuidoraAssembler {

	public static ReportesCineXDistribuidoraVO getReportesCineXDistribuidoraVO(ReportesCineXDistribuidora reportesCineXDistribuidoraDTO){
		if(reportesCineXDistribuidoraDTO==null)
			return null;
		
		ReportesCineXDistribuidoraVO reportesCineXDistribuidoraVO = new ReportesCineXDistribuidoraVO();
		reportesCineXDistribuidoraVO.setIdReporte(reportesCineXDistribuidoraDTO.getIdReporte());
		reportesCineXDistribuidoraVO.setCine(CineAssembler.getCineVO(reportesCineXDistribuidoraDTO.getCine()));
		reportesCineXDistribuidoraVO.setPelicula(PeliculaAssembler.getPeliculaVO(reportesCineXDistribuidoraDTO.getPelicula()));
		reportesCineXDistribuidoraVO.setDistribuidora(DistribuidoraAssembler.getDistribuidoraVO(reportesCineXDistribuidoraDTO.getDistribuidora()));
		reportesCineXDistribuidoraVO.setFechaInicio(reportesCineXDistribuidoraDTO.getFechaInicio());
		reportesCineXDistribuidoraVO.setFechaFin(reportesCineXDistribuidoraDTO.getFechaFin());	
		reportesCineXDistribuidoraVO.setRutaPlantillaVm(reportesCineXDistribuidoraDTO.getRutaPlantillaVm());
		reportesCineXDistribuidoraVO.setRutaPlantillaVmError(reportesCineXDistribuidoraDTO.getRutaPlantillaVmError());
		reportesCineXDistribuidoraVO.setRutaReporteJasper(reportesCineXDistribuidoraDTO.getRutaReporteJasper());
		reportesCineXDistribuidoraVO.setRutaReporteXls(reportesCineXDistribuidoraDTO.getRutaReporteXls());
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
		reportesCineXDistribuidoraDTO.setDistribuidora(DistribuidoraAssembler.getDistribuidora(reportesCineXDistribuidoraVO.getDistribuidora().getIdDistribuidora()));
		reportesCineXDistribuidoraDTO.setFechaInicio(reportesCineXDistribuidoraVO.getFechaInicio());
		reportesCineXDistribuidoraDTO.setFechaFin(reportesCineXDistribuidoraVO.getFechaFin());
		reportesCineXDistribuidoraDTO.setRutaPlantillaVm(reportesCineXDistribuidoraVO.getRutaPlantillaVm());
		reportesCineXDistribuidoraDTO.setRutaPlantillaVmError(reportesCineXDistribuidoraVO.getRutaPlantillaVmError());
		reportesCineXDistribuidoraDTO.setRutaReporteJasper(reportesCineXDistribuidoraVO.getRutaReporteJasper());
		reportesCineXDistribuidoraDTO.setRutaReporteXls(reportesCineXDistribuidoraVO.getRutaReporteXls());
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
