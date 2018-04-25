package mx.com.aztlan.pos.negocio.inventarios.assembler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Inventario;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Proveedor;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TipoMovimientoInv;
import mx.com.aztlan.pos.negocio.configuracion.assembler.AlmacenAssembler;
import mx.com.aztlan.pos.negocio.configuracion.assembler.ProductoAssembler;
import mx.com.aztlan.pos.negocio.dulceria.assembler.TipoMovimientoInvAssembler;
import mx.com.aztlan.pos.negocio.dulceria.assembler.UsuarioAssembler;
import mx.com.aztlan.pos.negocio.inventarios.vo.InventarioVO;

public class InventarioAssembler {

	public static Inventario getInventario(Integer idInventario){

		if(idInventario==null )
			return null;

		Inventario inventario= new Inventario();
		inventario.setIdInventario(idInventario);
		
		return inventario;
	}
	
	public static Inventario getInventario(Integer idProducto, Proveedor provedor, String lote,
			TipoMovimientoInv tipoMovimientoInv, Integer idUsuario ,  long cantidad, BigDecimal importe, long existenciaActual,Integer idAlmacen ) {
		
		if(idProducto==null  || provedor == null || tipoMovimientoInv==null || idUsuario==null || idAlmacen==null )
			return null;

		Inventario inventario= new Inventario();
		inventario.setProducto(ProductoAssembler.getProducto(idProducto));
		inventario.setProveedor(provedor);
		inventario.setLote(lote);
		inventario.setTipoMovimientoInv(tipoMovimientoInv);
		inventario.setUsuario(UsuarioAssembler.getUsuario(idUsuario));
		inventario.setCantidad(cantidad);
		inventario.setFecha(new Date());
		inventario.setImporte(importe);
		inventario.setExistenciaActual(existenciaActual);
		//inventario.setAlmacen(AlmacenAssembler.getAlmacen(idAlmacen));
		inventario.setUsuarioUltimoMovimiento(UsuarioAssembler.getUsuario(idUsuario));
		inventario.setUltimoMovimiento(new Date());

		return inventario;
	}

	public static Inventario getInventario(InventarioVO inventarioVO) {
		if(inventarioVO == null )
			return null;
		
		Inventario inventario = new Inventario();
		
		inventario.setIdInventario(inventarioVO.getIdInventario());
		inventario.setProducto(ProductoAssembler.getProducto(inventarioVO.getProducto().getIdProducto()));
		inventario.setProveedor(ProveedorAssembler.getProveedor(inventarioVO.getProveedor()));
		inventario.setTipoMovimientoInv(TipoMovimientoInvAssembler.getTipoMovimientoInv(inventarioVO.getTipoMovimientoInvVO()));
		inventario.setUsuario(UsuarioAssembler.getUsuario(inventarioVO.getUsuario().getIdUsuario()));
		inventario.setLote(inventarioVO.getLote());
		inventario.setCantidad(inventarioVO.getCantidad());
		inventario.setFecha(inventarioVO.getFecha());
		inventario.setImporte(inventarioVO.getImporte());
		inventario.setExistenciaActual(inventarioVO.getExistenciaActual());
		//inventario.setAlmacen(AlmacenAssembler.getAlmacen(inventarioVO.getAlmacenVO()));
		inventario.setUltimoMovimiento(inventario.getUltimoMovimiento());
		inventario.setUsuarioUltimoMovimiento(UsuarioAssembler.getUsuario(inventario.getUsuario().getIdUsuario()));
		
		return inventario;
	}
	
	public static InventarioVO getInventarioVO(Inventario inventario) {
		if(inventario == null )
			return null;
		
		InventarioVO inventarioVO = new InventarioVO();
		
		inventarioVO.setIdInventario(inventario.getIdInventario());
		inventarioVO.setProducto(ProductoAssembler.getProductoVO(inventario.getProducto()));
		inventarioVO.setProveedor(inventario.getProveedor() == null ? null : ProveedorAssembler.getProveedorVO(inventario.getProveedor()));
		inventarioVO.setTipoMovimientoInvVO(inventario.getTipoMovimientoInv() == null ? null :TipoMovimientoInvAssembler.getTipoMovimientoInvVO(inventario.getTipoMovimientoInv()));
		inventarioVO.setUsuario(inventario.getUsuario() == null ? null : UsuarioAssembler.getUsuarioVO(inventario.getUsuario().getIdUsuario()));
		inventarioVO.setCantidad(inventario.getCantidad());
		inventarioVO.setLote(inventario.getLote());
		inventarioVO.setFecha(inventario.getFecha());
		inventarioVO.setImporte(inventario.getImporte());
		inventarioVO.setExistenciaActual(inventario.getExistenciaActual());
		inventarioVO.setAlmacenVO(inventario.getAlmacen() == null ? null :AlmacenAssembler.getAlmacenVO(inventario.getAlmacen()));
		inventarioVO.setUltimoMovimiento(inventario.getUltimoMovimiento());
		inventarioVO.setUsuarioUltimoMovimiento(inventario.getUsuario() == null ? null : UsuarioAssembler.getUsuarioVO(inventario.getUsuario().getIdUsuario()));
		
		return inventarioVO;
	}
	
	public static List<InventarioVO> getInventariosVO(List<Inventario> inventarios){

		if(inventarios==null || inventarios.isEmpty())
			return null;
		
		List<InventarioVO> movimientosInventarioVO = new ArrayList<InventarioVO>();
		
		for (Inventario inventario : inventarios) {
			movimientosInventarioVO.add(InventarioAssembler.getInventarioVO(inventario));
		}

		return movimientosInventarioVO;
	}	

	
}
