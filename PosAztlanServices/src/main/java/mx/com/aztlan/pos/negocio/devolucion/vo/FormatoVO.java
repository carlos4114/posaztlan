package mx.com.aztlan.pos.negocio.devolucion.vo;

public class FormatoVO {
	private Integer idFormato;
	private CineVO cineVO;
	private String nombre;
	private boolean activo;
//	private Set<PrecioXFormato> precioXFormatos = new HashSet<PrecioXFormato>(0);
//	private Set<Programacion> programacions = new HashSet<Programacion>(0);
	
	public Integer getIdFormato() {
		return idFormato;
	}
	public void setIdFormato(Integer idFormato) {
		this.idFormato = idFormato;
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
