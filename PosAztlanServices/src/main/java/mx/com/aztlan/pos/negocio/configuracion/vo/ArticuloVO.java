package mx.com.aztlan.pos.negocio.configuracion.vo;

import java.util.List;

public class ArticuloVO {
	private Integer idArticulo;
	private CineVO cineVO;
	private ClasificacionArtVO clasificacionArtVO;
	private UnidadMedidaVO unidadMedidaVO;
	private String nombre;
	private boolean activo;
	private long puntoReorden;
	private List<Integer> puntosVentaList;
	private Integer idCine;
	private Integer idClasificacionArt;
	private Integer idUnidadMedida;
	
	public ArticuloVO() {
	}

	public Integer getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(Integer idArticulo) {
		this.idArticulo = idArticulo;
	}

	public CineVO getCineVO() {
		return cineVO;
	}

	public void setCineVO(CineVO cineVO) {
		this.cineVO = cineVO;
	}

	public ClasificacionArtVO getClasificacionArtVO() {
		return clasificacionArtVO;
	}

	public void setClasificacionArtVO(ClasificacionArtVO clasificacionArtVO) {
		this.clasificacionArtVO = clasificacionArtVO;
	}

	public UnidadMedidaVO getUnidadMedidaVO() {
		return unidadMedidaVO;
	}

	public void setUnidadMedidaVO(UnidadMedidaVO unidadMedidaVO) {
		this.unidadMedidaVO = unidadMedidaVO;
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

	public long getPuntoReorden() {
		return puntoReorden;
	}

	public void setPuntoReorden(long puntoReorden) {
		this.puntoReorden = puntoReorden;
	}

	public List<Integer> getPuntosVentaList() {
		return puntosVentaList;
	}

	public void setPuntosVentaList(List<Integer> puntosVentaList) {
		this.puntosVentaList = puntosVentaList;
	}

	public Integer getIdCine() {
		return idCine;
	}

	public void setIdCine(Integer idCine) {
		this.idCine = idCine;
	}

	public Integer getIdClasificacionArt() {
		return idClasificacionArt;
	}

	public void setIdClasificacionArt(Integer idClasificacionArt) {
		this.idClasificacionArt = idClasificacionArt;
	}

	public Integer getIdUnidadMedida() {
		return idUnidadMedida;
	}

	public void setIdUnidadMedida(Integer idUnidadMedida) {
		this.idUnidadMedida = idUnidadMedida;
	}
	
	

}
