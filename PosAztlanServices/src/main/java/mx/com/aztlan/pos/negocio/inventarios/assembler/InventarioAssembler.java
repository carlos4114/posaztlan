package mx.com.aztlan.pos.negocio.inventarios.assembler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Almacen;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Canal;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.EstatusConteo;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Inventario;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.InventarioConteo;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.InventarioConteoDetalle;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.InventarioConteoDetalleId;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.OrdenCompra;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.OrdenCompraDetalle;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Producto;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Proveedor;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TipoMovimientoInv;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Usuario;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.enumeration.EstatusConteoEnum;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.vo.ProductoExistenciaVO;
import mx.com.aztlan.pos.negocio.configuracion.assembler.ProductoAssembler;
import mx.com.aztlan.pos.negocio.configuracion.vo.ProductoVO;
import mx.com.aztlan.pos.negocio.dulceria.assembler.TipoMovimientoInvAssembler;
import mx.com.aztlan.pos.negocio.dulceria.assembler.UsuarioAssembler;
import mx.com.aztlan.pos.negocio.inventarios.vo.ConteoVO;
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
			TipoMovimientoInv tipoMovimientoInv, Integer idUsuario ,  long cantidad, BigDecimal importe, 
			long existenciaActual,Integer idAlmacen, Integer idOrdenCompra ) {
		
		if(idProducto==null  || tipoMovimientoInv==null || idUsuario==null || idAlmacen==null )
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
		inventario.setAlmacen(AlmacenAssembler.getAlmacen(idAlmacen));
		inventario.setUsuarioUltimoMovimiento(UsuarioAssembler.getUsuario(idUsuario));
		inventario.setUltimoMovimiento(new Date());
		inventario.setOrdenCompra(idOrdenCompra==null?null:new OrdenCompra(idOrdenCompra));
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
		inventario.setAlmacen(AlmacenAssembler.getAlmacen(inventarioVO.getAlmacenVO()));
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
		inventarioVO.setAlmacenVO(inventario.getAlmacen() == null ? null :AlmacenAssembler.getAlmacenVO((inventario.getAlmacen())));
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


	public static ConteoVO getConteoVO(InventarioConteo conteo,List<InventarioConteoDetalle> detalle){

		if(conteo==null)
			return null;
		
		ConteoVO conteoVO = new ConteoVO();
		
		conteoVO.setIdConteo(conteo.getIdConteo());
		conteoVO.setFolio(conteo.getFolio());
		//conteoVO.setIdAlmacen(conteo.getAlmacen().getIdAlmacen());
		conteoVO.setIdCanal(conteo.getCanal().getIdCanal());
		conteoVO.setIdEstatusConteo(conteo.getEstatusConteo().getIdEstatusConteo());
		conteoVO.setIdUsuarioAutorizador(conteo.getUsuarioCreador().getIdUsuario());
		conteoVO.setIdUsuarioCreador(conteo.getUsuarioCreador().getIdUsuario());
		conteoVO.setProductos(getProductos(detalle));
		conteoVO.setNombreEstatus(conteo.getEstatusConteo().getNombre());

		return conteoVO;
		
	}	

	public static List<ProductoExistenciaVO> getProductos(List<InventarioConteoDetalle> detalle) {
		List<ProductoExistenciaVO> productos = new ArrayList<ProductoExistenciaVO>();
		
		for(InventarioConteoDetalle producto : detalle) {
			ProductoExistenciaVO productoVO = new ProductoExistenciaVO();
			productoVO.setIdProducto(producto.getId().getIdProducto());
			productoVO.setNombre(producto.getProducto().getNombre());
			productoVO.setFamilia(producto.getProducto().getFamilia().getNombre());
			productoVO.setMarca(producto.getProducto().getMarca().getNombre());
			productoVO.setMedida(producto.getProducto().getMedida().getNombre());
			productoVO.setTipoProducto(producto.getProducto().getTipoProducto().getNombre());
			productoVO.setUnidadMedida(producto.getProducto().getUnidadMedida().getNombre());
			productoVO.setExistencia(producto.getExistenciaSistema());
			productoVO.setExistenciaFisica(producto.getExistenciaFisica());			
			productoVO.setSku(producto.getSku());
			productoVO.setIdAlmacen(producto.getAlmacen().getIdAlmacen());
			productoVO.setDiferencia(producto.getDiferencia());
			productoVO.setNombreAlmacen(producto.getAlmacen().getNombre());
			productos.add(productoVO);
		}
		
		return productos;
	}


	public static InventarioConteo getInventarioConteo(ConteoVO conteoVO, Integer folio){

		if(conteoVO==null)
			return null;
		
		if(conteoVO.getEsParcial()) {
			conteoVO.setIdEstatusConteo(EstatusConteoEnum.PARCIAL);
		}else {
			conteoVO.setIdEstatusConteo(EstatusConteoEnum.CERRADO);
		}
		
		InventarioConteo inventarioConteo = new InventarioConteo();
		inventarioConteo.setAlmacen(conteoVO.getIdAlmacen() == null?null:new Almacen(conteoVO.getIdAlmacen()));
		inventarioConteo.setCanal(new Canal(conteoVO.getIdCanal()));
		inventarioConteo.setEstatusConteo(new EstatusConteo(conteoVO.getIdEstatusConteo()));
		inventarioConteo.setUsuarioCreador(new Usuario(conteoVO.getIdUsuarioCreador()));
		inventarioConteo.setIdConteo(conteoVO.getIdConteo());
		inventarioConteo.setFolio(folio);
		inventarioConteo.setFechaHora(new Date());
		
		return inventarioConteo;
		
	}	
	
	public static InventarioConteoDetalle getInventarioConteoDetalle(ProductoExistenciaVO producto, ConteoVO conteoVO, Integer idConteo){

		if(conteoVO==null)
			return null;
		
		InventarioConteoDetalle inventarioConteoDetalle = new InventarioConteoDetalle();
	
		inventarioConteoDetalle.setId(new InventarioConteoDetalleId(idConteo, producto.getIdProducto(), producto.getIdAlmacen()));
		inventarioConteoDetalle.setProducto(new Producto(producto.getIdProducto()));
		inventarioConteoDetalle.setExistenciaSistema(producto.getExistencia());
		inventarioConteoDetalle.setExistenciaFisica(producto.getExistenciaFisica());
		inventarioConteoDetalle.setSku(producto.getSku());
		inventarioConteoDetalle.setAlmacen(new Almacen(producto.getIdAlmacen()));
		inventarioConteoDetalle.setDiferencia(producto.getDiferencia());
		
		return inventarioConteoDetalle;
	}	
}

