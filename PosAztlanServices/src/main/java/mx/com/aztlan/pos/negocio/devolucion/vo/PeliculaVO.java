package mx.com.aztlan.pos.negocio.devolucion.vo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PeliculaVO {
	private Integer idPelicula;
	private CineVO cineVO;
	private DistribuidoraVO distribuidoraVO;
	private PaisVO paisVO;
	private String titulo;
	private String clasificacion;
	private int duracion;
	private String sinopsis;
	private boolean activo;
	private byte[] icono;

	public Integer getIdPelicula() {
		return idPelicula;
	}
	public void setIdPelicula(Integer idPelicula) {
		this.idPelicula = idPelicula;
	}
	public CineVO getCineVO() {
		return cineVO;
	}
	public void setCineVO(CineVO cineVO) {
		this.cineVO = cineVO;
	}
	public DistribuidoraVO getDistribuidoraVO() {
		return distribuidoraVO;
	}
	public void setDistribuidoraVO(DistribuidoraVO distribuidoraVO) {
		this.distribuidoraVO = distribuidoraVO;
	}
	public PaisVO getPaisVO() {
		return paisVO;
	}
	public void setPaisVO(PaisVO paisVO) {
		this.paisVO = paisVO;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public byte[] getIcono() {
		return icono;
	}
	public void setIcono(byte[] icono) {
		this.icono = icono;
	}
	
}
