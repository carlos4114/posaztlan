package mx.com.tecnetia.muvitul.negocio.configuracion.vo;

public class ArticuloVO {
	private Integer idArticulo;
	private CineVO cineVO;
	private ClasificacionArtVO clasificacionArtVO;
	private UnidadMedidaVO unidadMedidaVO;
	private String nombre;
	private boolean activo;
	private long puntoReorden;

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

}
