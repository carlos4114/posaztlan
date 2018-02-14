package mx.com.aztlan.pos.negocio.reportes.vo;

import java.util.List;

public class SalaVO {
 	 private List<ProgramacionVO> listaProgramacionVO;
	 private String nombreSala;
	 
	 
	public SalaVO() {
		super();
	}
	public SalaVO(List<ProgramacionVO> listaProgramacionVO, String nombreSala) {
		super();
		this.listaProgramacionVO = listaProgramacionVO;
		this.nombreSala = nombreSala;
	}
	public List<ProgramacionVO> getListaProgramacionVO() {
		return listaProgramacionVO;
	}
	public void setListaProgramacionVO(List<ProgramacionVO> listaProgramacionVO) {
		this.listaProgramacionVO = listaProgramacionVO;
	}
	public String getNombreSala() {
		return nombreSala;
	}
	public void setNombreSala(String nombreSala) {
		this.nombreSala = nombreSala;
	}
 
	  
 
 	
}
