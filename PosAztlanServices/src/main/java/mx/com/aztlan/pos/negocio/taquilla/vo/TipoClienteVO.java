package mx.com.aztlan.pos.negocio.taquilla.vo;

public class TipoClienteVO {
	private Integer idTipoCliente;
	private String nombre;
	private boolean activo;
	private byte[] icono;
//	private Set<PrecioXFormato> precioXFormatos = new HashSet<PrecioXFormato>(0);
//	private Set<BoletosXTicket> boletosXTickets = new HashSet<BoletosXTicket>(0);
	
	public Integer getIdTipoCliente() {
		return idTipoCliente;
	}
	public void setIdTipoCliente(Integer idTipoCliente) {
		this.idTipoCliente = idTipoCliente;
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
	public byte[] getIcono() {
		return icono;
	}
	public void setIcono(byte[] icono) {
		this.icono = icono;
	}
	
}
