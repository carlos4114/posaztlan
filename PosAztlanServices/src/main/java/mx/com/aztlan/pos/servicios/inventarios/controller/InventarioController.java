package mx.com.aztlan.pos.servicios.inventarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Inventario;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.MovimientoInventario;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.vo.ProductoExistenciaVO;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.negocio.administracion.business.OrdenCompraBO;
import mx.com.aztlan.pos.negocio.administracion.vo.FiltrosVO;
import mx.com.aztlan.pos.negocio.administracion.vo.OrdenCompraVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ProductoVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.TipoMovimientoInvVO;
import mx.com.aztlan.pos.negocio.inventarios.business.CatalogoTipoMovimientoInvBO;
import mx.com.aztlan.pos.negocio.inventarios.business.InventarioBO;
import mx.com.aztlan.pos.negocio.inventarios.business.ProductosCorteBO;
import mx.com.aztlan.pos.negocio.inventarios.vo.ArticulosCorteVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.ArticulosXPuntoVentaVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.ConteoVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.InventarioVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.ParametrosBusquedaVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.ParametrosInventarioVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.ProductosCorteVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.SalidaVO;
import mx.com.aztlan.pos.servicios.util.Constantes;

@Service
public class InventarioController {

	@Autowired
	private InventarioBO inventarioBO;
	
	@Autowired
	private OrdenCompraBO ordenCompraBO;
	
	@Autowired
	private ProductosCorteBO productosCorteBO;
	
	@Autowired
	private CatalogoTipoMovimientoInvBO catalogoTipoMovimientoInvBO;
	
	//@Scheduled(fixedDelayString = "${fixedDelay.notifica.punto.reorden}")
	public void notificarPuntosReordenInventario() throws BusinessGlobalException, Exception{
    	this.inventarioBO.enviarNotificacionesPuntoReorden();
	}
	
	public List<ProductoExistenciaVO> getProductosConteo(ParametrosBusquedaVO parametrosBusquedaVO) throws BusinessGlobalException {
		
		return inventarioBO.getProductosConteo(parametrosBusquedaVO);
	}
	
	public List<ProductoVO> getProductos(String nombre, Integer idEmpresa) throws BusinessGlobalException {
		return inventarioBO.getProductos(nombre, idEmpresa);
	}
	
	public List<ProductoVO> getProductosXsku(String sku, Integer idEmpresa) throws BusinessGlobalException {
		return inventarioBO.getProductosXsku(sku, idEmpresa);
	}
	
	public List<InventarioVO> getProductosInventario(Integer idAlmacen, String nombreProducto) throws BusinessGlobalException {
		return inventarioBO.getProductosInventario(idAlmacen,nombreProducto);
	}
	

	public List<InventarioVO> getExistenciaProductoPorProveedores(Integer idAlmacen, Integer idProducto) throws BusinessGlobalException {
		return inventarioBO.getExistenciaProductoPorProveedores(idAlmacen,idAlmacen);
	}
	
	public Integer createSalida(ParametrosInventarioVO movimientoInventarioVO,Integer idCanal,Integer idAlmacen,Integer idUsuario) throws BusinessGlobalException {
		List<MovimientoInventario> movimientosInventario = inventarioBO.createSalida(movimientoInventarioVO,idCanal,idAlmacen,idUsuario);
		if(movimientosInventario!=null && !movimientosInventario.isEmpty()){
			return movimientosInventario.size();
		}else{
			return 0;
		}
		 
	}
	
	public void createSalidas(SalidaVO salidaVO,Integer idUsuario) throws BusinessGlobalException {
		
		inventarioBO.createSalidas(salidaVO,idUsuario);
		 
	}
	
	public void createTraspaso(SalidaVO salidaVO,Integer idUsuario) throws BusinessGlobalException {
		
		salidaVO.setClaveTipoMovimiento(Constantes.SALIDA_X_TRASPASO);
		inventarioBO.createSalidas(salidaVO,idUsuario);
	}
	

	public Integer createEntrada(ParametrosInventarioVO movimientoInventarioVO, Integer idUsuario) throws BusinessGlobalException {
			
		Inventario movimientoInventario = inventarioBO.createEntrada(movimientoInventarioVO,idUsuario);
			
		if(movimientoInventario!=null){
			return movimientoInventario.getIdInventario();
			
		}else{
			return 0;
		}
	}
	
	public void createEntradaOrdenCompra(OrdenCompraVO ordenCompraVO, Integer idUsuario) throws BusinessGlobalException {
		
		if(ordenCompraVO.getParcial()) {
			ordenCompraBO.guardarParcial(ordenCompraVO);
		}else
		{
			ordenCompraBO.cerrarOrdenCompra(ordenCompraVO);
		}
		
		inventarioBO.createEntradaOrdenCompra(ordenCompraVO, idUsuario);
	}
	
	public  List<TipoMovimientoInvVO> getTiposMovimientoByIsEntrada(Boolean isEntrada) throws BusinessGlobalException {
		return catalogoTipoMovimientoInvBO.findByIsEntrada(isEntrada);
	}
	
	public  List<TipoMovimientoInvVO> getTiposMovimientoByClave(String clave) throws BusinessGlobalException {
		return catalogoTipoMovimientoInvBO.findByClave(clave);
	}
	
	public List<InventarioVO> getProductosInventarioSinConteo(Integer idCanal, String nombreProducto) throws BusinessGlobalException {
		return inventarioBO.getProductosInventarioSinConteo(idCanal,nombreProducto);
	}
	
	public Integer createProductosCorte(ProductosCorteVO productosCorteVO,Integer idCanal,Integer idAlmacen,Integer idUsuario) throws BusinessGlobalException {
		return productosCorteBO.createProductosCorte(productosCorteVO,idCanal,idAlmacen,idUsuario);
	}
	
	public Integer updateProductosCorte(ProductosCorteVO productosCorteVO,Integer idCanal,Integer idAlmacen,Integer idUsuario) throws BusinessGlobalException {
		return productosCorteBO.updateProductosCorte(productosCorteVO,idCanal,idAlmacen,idUsuario);
	}
	
	public Integer updateProductosCorteMovimiento(ProductosCorteVO productosCorteVO,Integer idCanal,Integer idAlmacen,Integer idUsuario) throws BusinessGlobalException {
		List<MovimientoInventario> listMovimientosAjuste = null;
		ProductosCorteVO productosCorte = productosCorteVO;
		ParametrosInventarioVO inventarioVO = new ParametrosInventarioVO();	
		TipoMovimientoInvVO tipoMovimientoInvVO = new TipoMovimientoInvVO();
		
		int idProductosCorte = 0;
		long existenciaSistemaInicial = productosCorte.getExistenciaSistema();
		boolean isEntrada = false;
		inventarioVO.setIdProducto(productosCorte.getProducto().getIdProducto());
		inventarioVO.setIdAutorizacion(productosCorte.getAutorizacion().getIdAutorizacion());
		
		long cantidad = 0;
		
		if(productosCorte.getExistenciaSistema() < productosCorte.getExistenciaFisica() ){
			//Realiza ajuste de entrada
			isEntrada  = true;
			cantidad = productosCorte.getExistenciaFisica() - productosCorte.getExistenciaSistema();
			inventarioVO.setCantidad(Integer.valueOf(cantidad+""));
			productosCorte.setExistenciaSistema(productosCorte.getExistenciaSistema() + cantidad);
			//Obtiene el tipo de movimiento
			tipoMovimientoInvVO = inventarioBO.geTipoMovimientoPorClave(Constantes.ENTRADA_X_AJUSTE_MANUAL);
			inventarioVO.setIdTipoMovimiento(tipoMovimientoInvVO.getIdTipoMovimientoInv());
			inventarioVO.setClaveTipoMovimiento(tipoMovimientoInvVO.getClave());
			listMovimientosAjuste  = inventarioBO.createEntradaAjuste(inventarioVO,idCanal,idAlmacen,idUsuario);
		}else if( productosCorte.getExistenciaSistema() > productosCorte.getExistenciaFisica()){
			//Realiza ajuste de salida
			isEntrada  = false;
			cantidad = productosCorte.getExistenciaSistema() - productosCorte.getExistenciaFisica();
			inventarioVO.setCantidad(Integer.valueOf(cantidad+""));
			productosCorte.setExistenciaSistema(productosCorte.getExistenciaSistema() - cantidad);
			//Obtiene el tipo de movimiento
			tipoMovimientoInvVO = inventarioBO.geTipoMovimientoPorClave(Constantes.SALIDA_X_AJUSTE_MANUAL);
			inventarioVO.setIdTipoMovimiento(tipoMovimientoInvVO.getIdTipoMovimientoInv());
			inventarioVO.setClaveTipoMovimiento(tipoMovimientoInvVO.getClave());
		//	listMovimientosAjuste  = inventarioBO.createSalida(inventarioVO,idCine,idPuntoVenta,idUsuario);
		}
		
		int numAjuste = 0; 
		cantidad = 0;
		
		if (listMovimientosAjuste !=null && !listMovimientosAjuste.isEmpty()){
			
			for(MovimientoInventario movimiento : listMovimientosAjuste){				
				cantidad = cantidad + movimiento.getCantidad();
			}
			//cantidad actualizada
			if(isEntrada){
				productosCorte.setExistenciaSistema(existenciaSistemaInicial + cantidad);
			}else{
				productosCorte.setExistenciaSistema(existenciaSistemaInicial - cantidad);
			}
			//Realiza relacion del corte de articulo con los movimientos de ajuste
			numAjuste = productosCorteBO.createProductosCorteAjuste(productosCorte, listMovimientosAjuste, idUsuario);
			//Actualiza el corte de articulo
			idProductosCorte = productosCorteBO.updateProductosCorte(productosCorte,idCanal,idAlmacen,idUsuario);
		}
		return idProductosCorte;
	}
	
	public Integer removeProductosCorte(Integer idProductoCorte,Integer idCanal,Integer idAlmacen,Integer idUsuario) throws BusinessGlobalException {
		return productosCorteBO.removeProductosCorte(idProductoCorte,idCanal,idAlmacen,idUsuario);
	}
	
	 public List<ProductosCorteVO> getProductosCorteEnConteo(Integer idAlmacen){
		return productosCorteBO.getProductosCorteEnConteo(idAlmacen);
	}
	 
	 public Integer finalizarConteo(Integer idCanal,Integer idAlmacen,Integer idUsuario){
		 return productosCorteBO.finalizarConteo(idCanal, idAlmacen, idUsuario);
	 }
	 
	 public ConteoVO obtenerConteo(ParametrosBusquedaVO parametrosBusquedaVO) throws BusinessGlobalException {
		 return inventarioBO.obtenerConteo(parametrosBusquedaVO.getIdEmpresa(), parametrosBusquedaVO.getFolio());
	 }
	 
	 public Integer guardarConteo(ConteoVO conteoVO) throws BusinessGlobalException {
		 return inventarioBO.guardarConteo(conteoVO);
	 }
	 
	 public Integer autorizarConteo(ConteoVO conteoVO) throws BusinessGlobalException {
		 Integer folio = 0;
		 
		 this.inventarioBO.autorizarConteo(conteoVO);
		 
		 folio = this.inventarioBO.actualizarConteo(conteoVO);
		 
		 return folio;
	 }
}
