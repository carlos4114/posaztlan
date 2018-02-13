package mx.com.tecnetia.muvitul.infraservices.negocio.muvitul.vo;

import java.io.Serializable;

public class AsistenciaVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idAsiento;
	private boolean existente;
	private String fila;
	private Integer numeroAsiento;
	private Integer idEstatusAsiento;
	private Integer posicion;
	private Integer idUsuario;
	
	public Integer getIdAsiento() {
		return idAsiento;
	}
	public void setIdAsiento(Integer idAsiento) {
		this.idAsiento = idAsiento;
	}
	public boolean isExistente() {
		return existente;
	}
	public void setExistente(boolean existente) {
		this.existente = existente;
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
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	

	
	
}
