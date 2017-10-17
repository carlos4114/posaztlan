package mx.com.tecnetia.muvitul.negocio.devolucion.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.EstadoProducto;

public class EstadoProductoAssembler {
	
	public static EstadoProducto getEstadoProducto(Integer idEstadoProducto){

		if(idEstadoProducto==null )
			return null;
		
		EstadoProducto estadoProducto = new EstadoProducto();
		estadoProducto.setIdEstadoProducto(idEstadoProducto);
		return estadoProducto;
	}
	

}
