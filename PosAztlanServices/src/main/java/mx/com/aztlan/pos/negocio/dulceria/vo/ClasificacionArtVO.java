package mx.com.aztlan.pos.negocio.dulceria.vo;

public class ClasificacionArtVO {
	private Integer idClasificacionArt;
	private CineVO cineVO;
	private String nombre;
	private boolean activo;
	
	public Integer getIdClasificacionArt() {
		return idClasificacionArt;
	}
	public void setIdClasificacionArt(Integer idClasificacionArt) {
		this.idClasificacionArt = idClasificacionArt;
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

}
