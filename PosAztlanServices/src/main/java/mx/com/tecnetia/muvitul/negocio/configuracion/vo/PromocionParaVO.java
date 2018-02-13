package mx.com.tecnetia.muvitul.negocio.configuracion.vo;

public class PromocionParaVO {
	private Integer idPromocionPara;
	private String nombre;
	private String clave;
	//private Set<Promocion> promocions = new HashSet<Promocion>(0);
	
	public Integer getIdPromocionPara() {
		return idPromocionPara;
	}
	public void setIdPromocionPara(Integer idPromocionPara) {
		this.idPromocionPara = idPromocionPara;
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
}
