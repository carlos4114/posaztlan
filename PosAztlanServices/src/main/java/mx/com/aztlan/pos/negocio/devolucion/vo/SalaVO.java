package mx.com.aztlan.pos.negocio.devolucion.vo;

public class SalaVO {
	private Integer idSala;
	private CineVO cineVO;
	private String nombre;
	private boolean activo;
//	private Set<Programacion> programacions = new HashSet<Programacion>(0);
//	private Set<CupoXSala> cupoXSalas = new HashSet<CupoXSala>(0);
	
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
}
