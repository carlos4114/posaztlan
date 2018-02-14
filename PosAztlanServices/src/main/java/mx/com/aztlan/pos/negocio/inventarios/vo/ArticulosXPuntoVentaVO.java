package mx.com.aztlan.pos.negocio.inventarios.vo;

import mx.com.aztlan.pos.negocio.dulceria.vo.ArticuloVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.PuntoVentaVO;

public class ArticulosXPuntoVentaVO {

	private ArticuloVO articulo;
	private PuntoVentaVO puntoVenta;
	
	public ArticuloVO getArticulo() {
		return articulo;
	}
	public void setArticulo(ArticuloVO articulo) {
		this.articulo = articulo;
	}
	public PuntoVentaVO getPuntoVenta() {
		return puntoVenta;
	}
	public void setPuntoVenta(PuntoVentaVO puntoVenta) {
		this.puntoVenta = puntoVenta;
	}	
	
}
