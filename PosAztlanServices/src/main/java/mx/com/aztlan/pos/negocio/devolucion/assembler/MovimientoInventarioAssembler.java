package mx.com.aztlan.pos.negocio.devolucion.assembler;

import java.math.BigDecimal;
import java.util.Date;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.MovimientoInventario;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Proveedor;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TipoMovimientoInv;

public class MovimientoInventarioAssembler {

	public static MovimientoInventario getMovimientoInventario(Integer idArticulo, Proveedor provedor,
			TipoMovimientoInv tipoMovimientoInv, Integer idUsuario ,  long cantidad,
			BigDecimal importe, long existenciaActual,Integer idPuntoVenta,Integer idPuntoVentaConsigna ) {
		
		if(idArticulo==null  || provedor == null || tipoMovimientoInv==null || idUsuario==null  )
			return null;

		MovimientoInventario movimientoInventario= new MovimientoInventario();
		movimientoInventario.setArticulo(ArticuloAssembler.getArticulo(idArticulo));
		movimientoInventario.setProveedor(provedor);
		movimientoInventario.setTipoMovimientoInv(tipoMovimientoInv);
		movimientoInventario.setUsuario(UsuarioAssembler.getUsuario(idUsuario));
		movimientoInventario.setCantidad(cantidad);
		movimientoInventario.setFecha(new Date());
		movimientoInventario.setImporte(importe);
		movimientoInventario.setDocumentoRespaldo(null);
		movimientoInventario.setExistenciaActual(existenciaActual);
		movimientoInventario.setPuntoVenta(PuntoVentaAssembler.getPuntoVenta(idPuntoVenta));		
		movimientoInventario.setPuntoVentaConsigna(PuntoVentaAssembler.getPuntoVenta(idPuntoVentaConsigna));		

		return movimientoInventario;
	}

	
}
