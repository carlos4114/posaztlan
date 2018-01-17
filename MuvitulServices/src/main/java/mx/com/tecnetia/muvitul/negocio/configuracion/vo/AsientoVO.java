package mx.com.tecnetia.muvitul.negocio.configuracion.vo;

public class AsientoVO {
	private Integer idAsiento;
	private Integer idSala;
	private String fila;
	private Integer numeroAsiento;
	private boolean existente;
	private boolean activo;
	
	public Integer getIdAsiento() {
		return idAsiento;
	}
	public void setIdAisento(Integer idAsiento) {
		this.idAsiento = idAsiento;
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
	
	
}
