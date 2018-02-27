package mx.com.aztlan.pos.negocio.configuracion.vo;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Articulo;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ArticulosXPuntoVentaId;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PuntoVenta;

public class ArticulosXPuntoVentaVO {
		private ArticulosXPuntoVentaId id;
		private Articulo articulo;
		private PuntoVenta puntoVenta;
		public Articulo getArticulo() {
			return articulo;
		}
		public void setArticulo(Articulo articulo) {
			this.articulo = articulo;
		}
		public PuntoVenta getPuntoVenta() {
			return puntoVenta;
		}
		public void setPuntoVenta(PuntoVenta puntoVenta) {
			this.puntoVenta = puntoVenta;
		}
		public ArticulosXPuntoVentaId getId() {
			return id;
		}
		public void setId(ArticulosXPuntoVentaId id) {
			this.id = id;
		}
			
}
