package mx.com.tecnetia.muvitul.negocio.configuracion.vo;

import java.util.List;

public class SalaProgramacionVO {
	private Integer idSala;
	private CineVO cineVO;
	private String nombre;
	private boolean activo;
	private List<PeliculaVO> peliculasVO;

	
	public Integer getIdSala() {
		return idSala;
	}
	public void setIdSala(Integer idSala) {
		this.idSala = idSala;
	}
	public CineVO getCineVO() {
		return cineVO;
	}
	public void setCineVO(CineVO cineVO) {
		this.cineVO = cineVO;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public List<PeliculaVO> getPeliculasVO() {
		return peliculasVO;
	}
	public void setPeliculasVO(List<PeliculaVO> peliculasVO) {
		this.peliculasVO = peliculasVO;
	}

}
