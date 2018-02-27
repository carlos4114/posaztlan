package mx.com.aztlan.pos.negocio.configuracion.vo;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Paquete;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PaquetesXPuntoVentaId;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PuntoVenta;

public class PaquetesXPuntoVentaVO {

		private PaquetesXPuntoVentaId id;
		private Paquete paquete;
		private PuntoVenta puntoVenta;
		public PaquetesXPuntoVentaId getId() {
			return id;
		}
		public void setId(PaquetesXPuntoVentaId id) {
			this.id = id;
		}
		public Paquete getPaquete() {
			return paquete;
		}
		public void setPaquete(Paquete paquete) {
			this.paquete = paquete;
		}
		public PuntoVenta getPuntoVenta() {
			return puntoVenta;
		}
		public void setPuntoVenta(PuntoVenta puntoVenta) {
			this.puntoVenta = puntoVenta;
		}
		
		
}
