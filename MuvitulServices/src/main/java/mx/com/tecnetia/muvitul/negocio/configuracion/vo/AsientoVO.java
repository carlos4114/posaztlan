package mx.com.tecnetia.muvitul.negocio.configuracion.vo;

public class AsientoVO {
	private String fechaExhibicion;
	private Integer idAsiento;
	private Integer idSala;
	private String fila;
	private Integer numeroAsiento;
	private boolean existente;
	private boolean activo;
	private Integer idProgramacion;
	private Integer idEstatusAsiento;
	private Integer posicion;
	
	
	
	public String getFechaExhibicion() {
		return fechaExhibicion;
	}
	public void setFechaExhibicion(String fechaExhibicion) {
		this.fechaExhibicion = fechaExhibicion;
	}
	public void setIdAsiento(Integer idAsiento) {
		this.idAsiento = idAsiento;
	}
	public Integer getIdAsiento() {
		return idAsiento;
	}
	public Integer getIdSala() {
		return idSala;
	}
	public void setIdSala(Integer idSala) {
		this.idSala = idSala;
	}
	public String getFila() {
		return fila;
	}
	public void setFila(String fila) {
		this.fila = fila;
	}
	public Integer getNumeroAsiento() {
		return numeroAsiento;
	}
	public void setNumeroAsiento(Integer numeroAsiento) {
		this.numeroAsiento = numeroAsiento;
	}
	public boolean isExistente() {
		return existente;
	}
	public void setExistente(boolean existente) {
		this.existente = existente;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public Integer getIdProgramacion() {
		return idProgramacion;
	}
	public void setIdProgramacion(Integer idProgramacion) {
		this.idProgramacion = idProgramacion;
	}
	public Integer getIdEstatusAsiento() {
		return idEstatusAsiento;
	}
	public void setIdEstatusAsiento(Integer idEstatusAsiento) {
		this.idEstatusAsiento = idEstatusAsiento;
	}
	public Integer getPosicion() {
		return posicion;
	}
	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
	}
	
	
}
