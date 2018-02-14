package mx.com.aztlan.pos.negocio.configuracion.vo;

import java.util.List;


public class ConfigProgramacionVO {
	private List<SalaVO> salasVO;
	private List<String> dias;
	private List<PeliculaVO> peliculasVO;
	private List<FormatoVO> formatosVO;
	private List<VersionVO> versionesVO;
	
	public List<SalaVO> getSalasVO() {
		return salasVO;
	}
	public void setSalasVO(List<SalaVO> salasVO) {
		this.salasVO = salasVO;
	}
	public List<String> getDias() {
		return dias;
	}
	public void setDias(List<String> dias) {
		this.dias = dias;
	}
	public List<PeliculaVO> getPeliculasVO() {
		return peliculasVO;
	}
	public void setPeliculasVO(List<PeliculaVO> peliculasVO) {
		this.peliculasVO = peliculasVO;
	}
	public List<FormatoVO> getFormatosVO() {
		return formatosVO;
	}
	public void setFormatosVO(List<FormatoVO> formatosVO) {
		this.formatosVO = formatosVO;
	}
	public List<VersionVO> getVersionesVO() {
		return versionesVO;
	}
	public void setVersionesVO(List<VersionVO> versionesVO) {
		this.versionesVO = versionesVO;
	}
	
}
