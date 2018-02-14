package mx.com.aztlan.pos.negocio.dulceria.vo;

public class TipoMovimientoInvVO {

	private Integer idTipoMovimientoInv;
	private String nombre;
	private String clave;
	private String catalogo;
	private boolean esEntrada;
	private boolean activo;	
	
	public Integer getIdTipoMovimientoInv() {
		return idTipoMovimientoInv;
	}
	public void setIdTipoMovimientoInv(Integer idTipoMovimientoInv) {
		this.idTipoMovimientoInv = idTipoMovimientoInv;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getCatalogo() {
		return catalogo;
	}
	public void setCatalogo(String catalogo) {
		this.catalogo = catalogo;
	}
	public boolean isEsEntrada() {
		return esEntrada;
	}
	public void setEsEntrada(boolean esEntrada) {
		this.esEntrada = esEntrada;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
}
