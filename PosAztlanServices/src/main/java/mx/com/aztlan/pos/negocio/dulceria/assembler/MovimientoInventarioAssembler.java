package mx.com.aztlan.pos.negocio.dulceria.assembler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Almacen;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.MovimientoInventario;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Proveedor;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TipoMovimientoInv;
import mx.com.aztlan.pos.negocio.dulceria.vo.MovimientoInventarioVO;
import mx.com.aztlan.pos.negocio.inventarios.assembler.AlmacenAssembler;
import mx.com.aztlan.pos.negocio.inventarios.assembler.InventarioAssembler;
import mx.com.aztlan.pos.negocio.inventarios.assembler.ProveedorAssembler;

public class MovimientoInventarioAssembler {

	public static MovimientoInventario getMovimientoInventario(Integer idProducto, Proveedor provedor,
			TipoMovimientoInv tipoMovimientoInv, Integer idUsuario ,  long cantidad, BigDecimal importe, long existenciaActual,Integer idAlmacen,Integer idAlmacenConsigna,Integer idInventario ) {
		
		if(idProducto==null  || tipoMovimientoInv==null || idUsuario==null || idAlmacen==null )
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
		movimientoInventario.setAlmacen(new Almacen(idAlmacen));
		movimientoInventario.setAlmacenConsigna(idAlmacenConsigna == null || idAlmacenConsigna == 0 ? null : new Almacen(idAlmacenConsigna));		
		movimientoInventario.setInventario(InventarioAssembler.getInventario(idInventario));
		return movimientoInventario;
	}

	public static MovimientoInventario getMovimientoInventario(MovimientoInventarioVO movimientoInventarioVO) {
		if(movimientoInventarioVO == null )
			return null;
		
		MovimientoInventario movimientoInventario = new MovimientoInventario();
		
		movimientoInventario.setIdMovimiento(movimientoInventarioVO.getIdMovimiento());
		movimientoInventario.setProducto(ProductoAssembler.getProducto(movimientoInventarioVO.getProducto().getIdProducto()));
		movimientoInventario.setProveedor(ProveedorAssembler.getProveedor(movimientoInventarioVO.getProveedor()));
		movimientoInventario.setTipoMovimientoInv(TipoMovimientoInvAssembler.getTipoMovimientoInv(movimientoInventarioVO.getTipoMovimientoInvVO()));
		movimientoInventario.setUsuario(UsuarioAssembler.getUsuario(movimientoInventarioVO.getUsuario().getIdUsuario()));
		movimientoInventario.setCantidad(movimientoInventarioVO.getCantidad());
		movimientoInventario.setFecha(movimientoInventarioVO.getFecha());
		movimientoInventario.setImporte(movimientoInventarioVO.getImporte());
		movimientoInventario.setDocumentoRespaldo(movimientoInventarioVO.getDocumentoRespaldo());
		movimientoInventario.setExistenciaActual(movimientoInventarioVO.getExistenciaActual());
		movimientoInventario.setAlmacen(AlmacenAssembler.getAlmacen(movimientoInventarioVO.getAlmacenVO()));
		movimientoInventario.setAlmacenConsigna(AlmacenAssembler.getAlmacen(movimientoInventarioVO.getDestinoAlmacenVO()));
		movimientoInventario.setInventario(InventarioAssembler.getInventario(movimientoInventarioVO.getInventario()));
		
		return movimientoInventario;
	}
	
	public static MovimientoInventarioVO getMovimientoInventarioVO(MovimientoInventario movimientoInventario) {
		if(movimientoInventario == null )
			return null;
		
		MovimientoInventarioVO movimientoInventarioVO = new MovimientoInventarioVO();
		
		movimientoInventarioVO.setIdMovimiento(movimientoInventario.getIdMovimiento());
		movimientoInventarioVO.setProducto(ProductoAssembler.getProductoVO(movimientoInventario.getProducto()));
		movimientoInventarioVO.setProveedor(ProveedorAssembler.getProveedorVO(movimientoInventario.getProveedor()));
		movimientoInventarioVO.setTipoMovimientoInvVO(TipoMovimientoInvAssembler.getTipoMovimientoInvVO(movimientoInventario.getTipoMovimientoInv()));
		movimientoInventarioVO.setUsuario(UsuarioAssembler.getUsuarioVO(movimientoInventario.getUsuario().getIdUsuario()));
		movimientoInventarioVO.setCantidad(movimientoInventario.getCantidad());
		movimientoInventarioVO.setFecha(movimientoInventario.getFecha());
		movimientoInventarioVO.setImporte(movimientoInventario.getImporte());
		movimientoInventarioVO.setDocumentoRespaldo(movimientoInventario.getDocumentoRespaldo());
		movimientoInventarioVO.setExistenciaActual(movimientoInventario.getExistenciaActual());
		movimientoInventarioVO.setAlmacenVO(AlmacenAssembler.getAlmacenVO(movimientoInventario.getAlmacen()));
		movimientoInventarioVO.setDestinoAlmacenVO(AlmacenAssembler.getAlmacenVO(movimientoInventario.getAlmacenConsigna()));
		movimientoInventarioVO.setInventario(InventarioAssembler.getInventarioVO(movimientoInventario.getInventario()));
		
		return movimientoInventarioVO;
	}
	
	public static List<MovimientoInventarioVO> getMovimientosInventarioVO(List<MovimientoInventario> movimientosInventario){

		if(movimientosInventario==null || movimientosInventario.isEmpty())
			return null;
		
		List<MovimientoInventarioVO> movimientosInventarioVO = new ArrayList<MovimientoInventarioVO>();
		
		for (MovimientoInventario movimientoInventario : movimientosInventario) {
			movimientosInventarioVO.add(MovimientoInventarioAssembler.getMovimientoInventarioVO(movimientoInventario));
		}

		return movimientosInventarioVO;
	}	

	
}
