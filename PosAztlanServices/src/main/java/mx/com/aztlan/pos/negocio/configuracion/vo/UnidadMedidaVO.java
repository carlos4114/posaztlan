package mx.com.aztlan.pos.negocio.configuracion.vo;

public class UnidadMedidaVO{
	private Integer idUnidadMedida;
	private String nombre;
	private boolean activo;
	
	public UnidadMedidaVO() {
	}

	public Integer getIdUnidadMedida() {
		return idUnidadMedida;
	}

	public void setIdUnidadMedida(Integer idUnidadMedida) {
		this.idUnidadMedida = idUnidadMedida;
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
