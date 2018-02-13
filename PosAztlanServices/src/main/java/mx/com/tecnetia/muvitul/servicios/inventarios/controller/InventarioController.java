package mx.com.tecnetia.muvitul.servicios.inventarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Inventario;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.MovimientoInventario;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.TipoMovimientoInvVO;
import mx.com.tecnetia.muvitul.negocio.inventarios.business.ArticulosCorteBO;
import mx.com.tecnetia.muvitul.negocio.inventarios.business.CatalogoTipoMovimientoInvBO;
import mx.com.tecnetia.muvitul.negocio.inventarios.business.InventarioBO;
import mx.com.tecnetia.muvitul.negocio.inventarios.vo.ArticulosCorteVO;
import mx.com.tecnetia.muvitul.negocio.inventarios.vo.ArticulosXPuntoVentaVO;
import mx.com.tecnetia.muvitul.negocio.inventarios.vo.InventarioVO;
import mx.com.tecnetia.muvitul.negocio.inventarios.vo.ParametrosInventarioVO;
import mx.com.tecnetia.muvitul.servicios.util.Constantes;

@Service
public class InventarioController {

	@Autowired
	private InventarioBO inventarioBO;
	
	@Autowired
	private ArticulosCorteBO articulosCorteBO;
	
	@Autowired
	private CatalogoTipoMovimientoInvBO catalogoTipoMovimientoInvBO;
	
	@Scheduled(fixedDelayString = "${fixedDelay.notifica.punto.reorden}")
	public void notificarPuntosReordenInventario() throws BusinessGlobalException, Exception{
    	this.inventarioBO.enviarNotificacionesPuntoReorden();
	}
	
	public List<ArticulosXPuntoVentaVO> getArticulosPuntoVenta(Integer idPuntoVenta, String nombreArticulo) throws BusinessGlobalException {
		return inventarioBO.getArticulosPuntoVenta(idPuntoVenta,nombreArticulo);
	}
	
	public List<InventarioVO> getArticulosInventario(Integer idPuntoVenta, String nombreArticulo) throws BusinessGlobalException {
		return inventarioBO.getArticulosInventario(idPuntoVenta,nombreArticulo);
	}

	public List<InventarioVO> getExistenciaArticuloPorProveedores(Integer idPuntoVenta, Integer idArticulo) throws BusinessGlobalException {
		return inventarioBO.getExistenciaArticuloPorProveedores(idPuntoVenta,idArticulo);
	}
	
	public Integer createSalida(ParametrosInventarioVO movimientoInventarioVO,Integer idCine,Integer idPuntoVenta,Integer idUsuario) throws BusinessGlobalException {
		List<MovimientoInventario> movimientosInventario = inventarioBO.createSalida(movimientoInventarioVO,idCine,idPuntoVenta,idUsuario);
		if(movimientosInventario!=null && !movimientosInventario.isEmpty()){
			return movimientosInventario.size();
		}else{
			return 0;
		}
		 
	}
	
	public Integer createEntrada(ParametrosInventarioVO movimientoInventarioVO,Integer idCine,Integer idPuntoVenta,Integer idUsuario) throws BusinessGlobalException {
		Inventario movimientoInventario = inventarioBO.createEntrada(movimientoInventarioVO,idCine,idPuntoVenta,idUsuario);
		if(movimientoInventario!=null){
			return movimientoInventario.getIdInventario();
		}else{
			return 0;
		}
	}
	
	public  List<TipoMovimientoInvVO> getTiposMovimientoByIsEntrada(Boolean isEntrada) throws BusinessGlobalException {
		return catalogoTipoMovimientoInvBO.findByIsEntrada(isEntrada);
	}
	
	public  List<TipoMovimientoInvVO> getTiposMovimientoByClave(String clave) throws BusinessGlobalException {
		return catalogoTipoMovimientoInvBO.findByClave(clave);
	}
	
	public List<InventarioVO> getArticulosInventarioSinConteo(Integer idCine, String nombreArticulo) throws BusinessGlobalException {
		return inventarioBO.getArticulosInventarioSinConteo(idCine,nombreArticulo);
	}
	
	public Integer createArticulosCorte(ArticulosCorteVO articulosCorteVO,Integer idCine,Integer idPuntoVenta,Integer idUsuario) throws BusinessGlobalException {
		return articulosCorteBO.createArticulosCorte(articulosCorteVO,idCine,idPuntoVenta,idUsuario);
	}
	
	public Integer updateArticulosCorte(ArticulosCorteVO articulosCorteVO,Integer idCine,Integer idPuntoVenta,Integer idUsuario) throws BusinessGlobalException {
		return articulosCorteBO.updateArticulosCorte(articulosCorteVO,idCine,idPuntoVenta,idUsuario);
	}
	
	public Integer updateArticulosCorteMovimiento(ArticulosCorteVO articulosCorteVO,Integer idCine,Integer idPuntoVenta,Integer idUsuario) throws BusinessGlobalException {
		List<MovimientoInventario> listMovimientosAjuste = null;
		ArticulosCorteVO articulosCorte = articulosCorteVO;
		ParametrosInventarioVO inventarioVO = new ParametrosInventarioVO();	
		TipoMovimientoInvVO tipoMovimientoInvVO = new TipoMovimientoInvVO();
		
		int idArticulosCorte = 0;
		long existenciaSistemaInicial = articulosCorte.getExistenciaSistema();
		boolean isEntrada = false;
		inventarioVO.setIdArticulo(articulosCorte.getArticulo().getIdArticulo());
		inventarioVO.setIdAutorizacion(articulosCorte.getAutorizacion().getIdAutorizacion());
		
		long cantidad = 0;
		
		if(articulosCorte.getExistenciaSistema() < articulosCorte.getExistenciaFisica() ){
			//Realiza ajuste de entrada
			isEntrada  = true;
			cantidad = articulosCorte.getExistenciaFisica() - articulosCorte.getExistenciaSistema();
			inventarioVO.setCantidad(Integer.valueOf(cantidad+""));
			articulosCorte.setExistenciaSistema(articulosCorte.getExistenciaSistema() + cantidad);
			//Obtiene el tipo de movimiento
			tipoMovimientoInvVO = inventarioBO.geTipoMovimientoPorClave(Constantes.ENTRADA_X_AJUSTE_MANUAL);
			inventarioVO.setIdTipoMovimiento(tipoMovimientoInvVO.getIdTipoMovimientoInv());
			inventarioVO.setClaveTipoMovimiento(tipoMovimientoInvVO.getClave());
			listMovimientosAjuste  = inventarioBO.createEntradaAjuste(inventarioVO,idCine,idPuntoVenta,idUsuario);
		}else if( articulosCorte.getExistenciaSistema() > articulosCorte.getExistenciaFisica()){
			//Realiza ajuste de salida
			isEntrada  = false;
			cantidad = articulosCorte.getExistenciaSistema() - articulosCorte.getExistenciaFisica();
			inventarioVO.setCantidad(Integer.valueOf(cantidad+""));
			articulosCorte.setExistenciaSistema(articulosCorte.getExistenciaSistema() - cantidad);
			//Obtiene el tipo de movimiento
			tipoMovimientoInvVO = inventarioBO.geTipoMovimientoPorClave(Constantes.SALIDA_X_AJUSTE_MANUAL);
			inventarioVO.setIdTipoMovimiento(tipoMovimientoInvVO.getIdTipoMovimientoInv());
			inventarioVO.setClaveTipoMovimiento(tipoMovimientoInvVO.getClave());
			listMovimientosAjuste  = inventarioBO.createSalida(inventarioVO,idCine,idPuntoVenta,idUsuario);
		}
		
		int numAjuste = 0; 
		cantidad = 0;
		
		if (listMovimientosAjuste !=null && !listMovimientosAjuste.isEmpty()){
			
			for(MovimientoInventario movimiento : listMovimientosAjuste){				
				cantidad = cantidad + movimiento.getCantidad();
			}
			//cantidad actualizada
			if(isEntrada){
				articulosCorte.setExistenciaSistema(existenciaSistemaInicial + cantidad);
			}else{
				articulosCorte.setExistenciaSistema(existenciaSistemaInicial - cantidad);
			}
			//Realiza relacion del corte de articulo con los movimientos de ajuste
			numAjuste = articulosCorteBO.createArticulosCorteAjuste(articulosCorte, listMovimientosAjuste, idUsuario);
			//Actualiza el corte de articulo
			idArticulosCorte = articulosCorteBO.updateArticulosCorte(articulosCorte,idCine,idPuntoVenta,idUsuario);
		}
		return idArticulosCorte;
	}
	
	public Integer removeArticulosCorte(Integer idArticuloCorte,Integer idCine,Integer idPuntoVenta,Integer idUsuario) throws BusinessGlobalException {
		return articulosCorteBO.removeArticulosCorte(idArticuloCorte,idCine,idPuntoVenta,idUsuario);
	}
	
	 public List<ArticulosCorteVO> getArticulosCorteEnConteo(Integer idPuntoVenta){
		return articulosCorteBO.getArticulosCorteEnConteo(idPuntoVenta);
	}
	 
	 public Integer finalizarConteo(Integer idCine,Integer idPuntoVenta,Integer idUsuario){
		 return articulosCorteBO.finalizarConteo(idCine, idPuntoVenta, idUsuario);
	 }
}
