package mx.com.aztlan.pos.negocio.devolucion.assembler;

import java.math.BigDecimal;
import java.util.Date;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.MovimientoInventario;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Proveedor;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TipoMovimientoInv;
import mx.com.aztlan.pos.negocio.configuracion.assembler.AlmacenAssembler;

public class MovimientoInventarioAssembler {

	public static MovimientoInventario getMovimientoInventario(Integer idProducto, Proveedor provedor,
			TipoMovimientoInv tipoMovimientoInv, Integer idUsuario ,  long cantidad,
			BigDecimal importe, long existenciaActual,Integer idAlmacen,Integer idAlmacenConsigna ) {
		
		if(idProducto==null  || provedor == null || tipoMovimientoInv==null || idUsuario==null  )
			return null;

		MovimientoInventario movimientoInventario= new MovimientoInventario();
		movimientoInventario.setProducto(ProductoAssembler.getProducto(idProducto));
		movimientoInventario.setProveedor(provedor);
		movimientoInventario.setTipoMovimientoInv(tipoMovimientoInv);
		movimientoInventario.setUsuario(UsuarioAssembler.getUsuario(idUsuario));
		movimientoInventario.setCantidad(cantidad);
		movimientoInventario.setFecha(new Date());
		movimientoInventario.setImporte(importe);
		movimientoInventario.setDocumentoRespaldo(null);
		movimientoInventario.setExistenciaActual(existenciaActual);
		//movimientoInventario.setAlmacen(AlmacenAssembler.getAlmacen(idAlmacen));		
		//movimientoInventario.setAlmacenConsigna(AlmacenAssembler.getAlmacen(idAlmacenConsigna));		

		return movimientoInventario;
	}

	
}
