package mx.com.aztlan.pos.negocio.configuracion.vo;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Producto;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ProductosXPuntoVentaId;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PuntoVenta;

public class ProductosXPuntoVentaVO {

		private ProductosXPuntoVentaId id;
		private Producto producto;
		private PuntoVenta puntoVenta;
		public ProductosXPuntoVentaId getId() {
			return id;
		}
		public void setId(ProductosXPuntoVentaId id) {
			this.id = id;
		}
		public Producto getProducto() {
			return producto;
		}
		public void setProducto(Producto producto) {
			this.producto = producto;
		}
		public PuntoVenta getPuntoVenta() {
			return puntoVenta;
		}
		public void setPuntoVenta(PuntoVenta puntoVenta) {
			this.puntoVenta = puntoVenta;
		}
				
}
