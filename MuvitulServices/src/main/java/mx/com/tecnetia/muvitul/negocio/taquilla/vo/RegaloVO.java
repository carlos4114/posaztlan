package mx.com.tecnetia.muvitul.negocio.taquilla.vo;

public class RegaloVO {
	private Integer idRegalo;
	private CineVO cineVO;
	private String nombre;
	private String descripcion;
//	private Set<DetallePromocion> detallePromocions = new HashSet<DetallePromocion>(0);
	
	public Integer getIdRegalo() {
		return idRegalo;
	}
	public void setIdRegalo(Integer idRegalo) {
		this.idRegalo = idRegalo;
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
