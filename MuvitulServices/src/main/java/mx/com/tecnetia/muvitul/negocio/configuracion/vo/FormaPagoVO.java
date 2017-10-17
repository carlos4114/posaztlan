package mx.com.tecnetia.muvitul.negocio.configuracion.vo;

public class FormaPagoVO {
	private Integer idFormaPago;
	private String nombre;
	private boolean requiereNumCuenta;
	private boolean activo;
//	private Set<Pago> pagos = new HashSet<Pago>(0);
	
	public Integer getIdFormaPago() {
		return idFormaPago;
	}
	public void setIdFormaPago(Integer idFormaPago) {
		this.idFormaPago = idFormaPago;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isRequiereNumCuenta() {
		return requiereNumCuenta;
	}
	public void setRequiereNumCuenta(boolean requiereNumCuenta) {
		this.requiereNumCuenta = requiereNumCuenta;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
