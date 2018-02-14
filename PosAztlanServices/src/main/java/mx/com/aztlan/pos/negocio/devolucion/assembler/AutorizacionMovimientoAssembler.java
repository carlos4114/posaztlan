package mx.com.aztlan.pos.negocio.devolucion.assembler;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Autorizacion;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.AutorizacionMovimiento;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.AutorizacionMovimientoId;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.MovimientoInventario;

public class AutorizacionMovimientoAssembler {

	public static AutorizacionMovimiento getAutorizacionMovimiento(MovimientoInventario movimientoInventario, Autorizacion autorizacion) {
		
		if(movimientoInventario==null  || autorizacion==null )
			return null;

		AutorizacionMovimiento autorizacionMovimiento = new AutorizacionMovimiento();
		AutorizacionMovimientoId id = new AutorizacionMovimientoId();
		id.setIdAutorizacion(autorizacion.getIdAutorizacion());
		id.setIdMovimientoInventario(movimientoInventario.getIdMovimiento());
		autorizacionMovimiento.setId(id);
		autorizacionMovimiento.setMovimientoInventario(movimientoInventario);
		autorizacionMovimiento.setAutorizacion(autorizacion);	
		
		return autorizacionMovimiento;
	}

	
}
