package mx.com.tecnetia.muvitul.negocio.configuracion.vo;

public class ClasificacionArtVO{
	private Integer idClasificacionArt;
	private String nombre;
	private boolean activo;

	public ClasificacionArtVO() {
	}
	
	public Integer getIdClasificacionArt() {
		return idClasificacionArt;
	}

	public void setIdClasificacionArt(Integer idClasificacionArt) {
		this.idClasificacionArt = idClasificacionArt;
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
