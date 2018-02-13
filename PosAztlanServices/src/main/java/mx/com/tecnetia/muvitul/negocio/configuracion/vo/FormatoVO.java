package mx.com.tecnetia.muvitul.negocio.configuracion.vo;

public class FormatoVO {
	private Integer idFormato;
	private CineVO cineVO;
	private String nombre;
	private boolean activo;

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
