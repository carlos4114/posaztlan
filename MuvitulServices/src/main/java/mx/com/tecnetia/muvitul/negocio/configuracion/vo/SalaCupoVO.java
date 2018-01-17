package mx.com.tecnetia.muvitul.negocio.configuracion.vo;

import java.util.List;

public class SalaCupoVO {
	private Integer idSala;
	private Integer idCine;
	private String nombre;
	private boolean activo;
	private Integer cupo;
	private boolean tieneNumerado;	
	private boolean cupoActivo;
	private Integer idCupoSala;
	private Integer filas;
	private Integer maxAsientos;
	
	private List<List<AsientoVO>> asientosListVO;
	
	public Integer getIdSala() {
		return idSala;
	}
	public void setIdSala(Integer idSala) {
		this.idSala = idSala;
	}
	public Integer getIdCine() {
		return idCine;
	}
	public void setIdCine(Integer idCine) {
		this.idCine = idCine;
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
	
	public List<List<AsientoVO>> getAsientosListVO() {
		return asientosListVO;
	}
	public void setAsientosListVO(List<List<AsientoVO>> asientosListVO) {
		this.asientosListVO = asientosListVO;
	}
	public Integer getCupo() {
		return cupo;
	}
	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}
	public boolean isTieneNumerado() {
		return tieneNumerado;
	}
	public void setTieneNumerado(boolean tieneNumerado) {
		this.tieneNumerado = tieneNumerado;
	}
	public boolean isCupoActivo() {
		return cupoActivo;
	}
	public void setCupoActivo(boolean cupoActivo) {
		this.cupoActivo = cupoActivo;
	}
	public Integer getIdCupoSala() {
		return idCupoSala;
	}
	public void setIdCupoSala(Integer idCupoSala) {
		this.idCupoSala = idCupoSala;
	}
	public Integer getFilas() {
		return filas;
	}
	public void setFilas(Integer filas) {
		this.filas = filas;
	}
	public Integer getMaxAsientos() {
		return maxAsientos;
	}
	public void setMaxAsientos(Integer maxAsientos) {
		this.maxAsientos = maxAsientos;
	}
	
}
