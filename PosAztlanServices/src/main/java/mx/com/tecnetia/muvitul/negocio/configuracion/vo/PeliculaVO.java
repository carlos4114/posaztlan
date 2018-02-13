package mx.com.tecnetia.muvitul.negocio.configuracion.vo;

import java.util.ArrayList;
import java.util.List;

import mx.com.tecnetia.muvitul.negocio.taquilla.vo.DistribuidoraVO;

public class PeliculaVO {
	private Integer idPelicula;
	private CineVO cineVO;
	private DistribuidoraVO distribuidora;
//	private Pais pais;
	private String titulo;
	private String clasificacion;
	private int duracion;
	private String sinopsis;
	private boolean activo;
	private byte[] icono;
	private List<ProgramacionVO> programacionesVO= new ArrayList<ProgramacionVO>();


	public void addProgramacionVO(ProgramacionVO programacionVO) {
		programacionesVO.add(programacionVO);
	}
	
	
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

	public List<ProgramacionVO> getProgramacionesVO() {
		return programacionesVO;
	}
	public void setProgramacionesVO(List<ProgramacionVO> programacionesVO) {
		this.programacionesVO = programacionesVO;
	}
	public DistribuidoraVO getDistribuidora() {
		return distribuidora;
	}
	public void setDistribuidora(DistribuidoraVO distribuidora) {
		this.distribuidora = distribuidora;
	}
	
}
