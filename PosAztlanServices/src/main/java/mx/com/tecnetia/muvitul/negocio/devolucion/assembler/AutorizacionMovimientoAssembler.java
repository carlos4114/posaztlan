package mx.com.tecnetia.muvitul.negocio.devolucion.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Autorizacion;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.AutorizacionMovimiento;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.AutorizacionMovimientoId;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.MovimientoInventario;

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
