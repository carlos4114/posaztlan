package mx.com.aztlan.pos.negocio.reportes.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ReportesDistribuidora;
import mx.com.aztlan.pos.negocio.reportes.vo.ReportesDistribuidoraVO;

public class ReportesDistribuidoraAssembler {

	public static ReportesDistribuidoraVO getReportesDistribuidoraVO(ReportesDistribuidora reportesDistribuidoraDTO){
		if(reportesDistribuidoraDTO==null)
			return null;
		
		ReportesDistribuidoraVO reportesDistribuidoraVO = new ReportesDistribuidoraVO();
		reportesDistribuidoraVO.setIdReporteDistribuidora(reportesDistribuidoraDTO.getIdReporteDistribuidora());
		reportesDistribuidoraVO.setNombre(reportesDistribuidoraDTO.getNombre());
		reportesDistribuidoraVO.setRutaPlantillaVm(reportesDistribuidoraDTO.getRutaPlantillaVm());
		reportesDistribuidoraVO.setRutaPlantillaVmError(reportesDistribuidoraDTO.getRutaPlantillaVmError());
		reportesDistribuidoraVO.setRutaReporteJasper(reportesDistribuidoraDTO.getRutaReporteJasper());
		reportesDistribuidoraVO.setRutaReporteXls(reportesDistribuidoraDTO.getRutaReporteXls());
				
		return reportesDistribuidoraVO;
	}
	
	public static ReportesDistribuidora getReportesDistribuidora(ReportesDistribuidoraVO reportesDistribuidoraVO){
		if(reportesDistribuidoraVO==null)
			return null;
		
		ReportesDistribuidora reportesDistribuidoraDTO = new ReportesDistribuidora();
		
		reportesDistribuidoraDTO.setIdReporteDistribuidora(reportesDistribuidoraVO.getIdReporteDistribuidora());
		reportesDistribuidoraDTO.setNombre(reportesDistribuidoraVO.getNombre());
		reportesDistribuidoraDTO.setRutaPlantillaVm(reportesDistribuidoraVO.getRutaPlantillaVm());
		reportesDistribuidoraDTO.setRutaPlantillaVmError(reportesDistribuidoraVO.getRutaPlantillaVmError());
		reportesDistribuidoraDTO.setRutaReporteJasper(reportesDistribuidoraVO.getRutaReporteJasper());
		reportesDistribuidoraDTO.setRutaReporteXls(reportesDistribuidoraVO.getRutaReporteXls());
		
		return reportesDistribuidoraDTO;
	}
	
	
	public static List<ReportesDistribuidoraVO> getReportesDistribuidoraVO(List<ReportesDistribuidora> reportesDistribuidora){
		
		if(reportesDistribuidora==null || reportesDistribuidora.isEmpty())
			return null;
		
		List<ReportesDistribuidoraVO> reportesDistribuidoraVO = new ArrayList<ReportesDistribuidoraVO>();
		
		for (ReportesDistribuidora reporte : reportesDistribuidora) {
			reportesDistribuidoraVO.add(ReportesDistribuidoraAssembler.getReportesDistribuidoraVO(reporte));
		}

		return reportesDistribuidoraVO;
		
	}
}
