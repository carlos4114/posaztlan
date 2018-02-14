package mx.com.aztlan.pos.negocio.devolucion.assembler;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.EstadoProducto;

public class EstadoProductoAssembler {
	
	public static EstadoProducto getEstadoProducto(Integer idEstadoProducto){

		if(idEstadoProducto==null )
			return null;
		
		EstadoProducto estadoProducto = new EstadoProducto();
		estadoProducto.setIdEstadoProducto(idEstadoProducto);
		return estadoProducto;
	}
	

}
