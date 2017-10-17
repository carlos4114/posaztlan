package mx.com.tecnetia.muvitul.negocio.dulceria.vo;

public class PuntoVentaVO {
	private Integer idPuntoVenta;
	private CineVO cineVO;
	private TipoPuntoVentaVO tipoPuntoVentaVO;
	private String nombre;
	
	public Integer getIdPuntoVenta() {
		return idPuntoVenta;
	}
	public void setIdPuntoVenta(Integer idPuntoVenta) {
		this.idPuntoVenta = idPuntoVenta;
	}
	public CineVO getCineVO() {
		return cineVO;
	}
	public void setCineVO(CineVO cineVO) {
		this.cineVO = cineVO;
	}
	public TipoPuntoVentaVO getTipoPuntoVentaVO() {
		return tipoPuntoVentaVO;
	}
	public void setTipoPuntoVentaVO(TipoPuntoVentaVO tipoPuntoVentaVO) {
		this.tipoPuntoVentaVO = tipoPuntoVentaVO;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
