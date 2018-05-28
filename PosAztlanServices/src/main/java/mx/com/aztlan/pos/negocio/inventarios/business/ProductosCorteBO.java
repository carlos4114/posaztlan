package mx.com.aztlan.pos.negocio.inventarios.business;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ProductosCorteAjusteDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ProductosCorteDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.MovimientoInventario;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ProductosCorte;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ProductosCorteAjuste;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.negocio.dulceria.assembler.UsuarioAssembler;
import mx.com.aztlan.pos.negocio.dulceria.vo.UsuarioVO;
import mx.com.aztlan.pos.negocio.inventarios.assembler.ProductosCorteAssembler;
import mx.com.aztlan.pos.negocio.inventarios.vo.ProductosCorteVO;
import mx.com.aztlan.pos.servicios.util.Constantes;

@Service
@Transactional
public class ProductosCorteBO {
	final static Log log = LogFactory.getLog(ProductosCorteBO.class);
	
	@Autowired
	private ProductosCorteDAO productosCorteDAO;
	
	@Autowired
	private ProductosCorteAjusteDAOI productosCorteAjusteDAO;
	
	public Integer createProductosCorte(ProductosCorteVO ProductosCorteVO,Integer idCanal,Integer idAlmacen,Integer idUsuario) throws BusinessGlobalException {	
		UsuarioVO usuario = new UsuarioVO();
		usuario.setIdUsuario(idUsuario);
		ProductosCorteVO.setUsuario(usuario);
		ProductosCorte productosCorte = ProductosCorteAssembler.getProductosCorte(ProductosCorteVO);
		productosCorte.setEstatusConteo(Constantes.PRODUCTO_EN_CONTEO);
		productosCorte.setFecha(new Date());
		productosCorte.setUsuarioModificacion(UsuarioAssembler.getUsuario(ProductosCorteVO.getUsuario().getIdUsuario()));
		productosCorte.setUltimaModificacion(new Date());
		productosCorte = productosCorteDAO.save(productosCorte);
		
		if(productosCorte.getIdProductoCorte() >= 0){
			return productosCorte.getIdProductoCorte();
		}
		return 0;
	}
	
	public Integer updateProductosCorte(ProductosCorteVO productosCorteVO,Integer idCanal,Integer idAlmacen,Integer idUsuario) throws BusinessGlobalException {		
		ProductosCorte productosCorte = productosCorteDAO.getById(productosCorteVO.getIdProductoCorte());
		productosCorte.setExistenciaSistema(productosCorteVO.getExistenciaSistema());
		productosCorte.setExistenciaFisica(productosCorteVO.getExistenciaFisica());
		productosCorte.setUsuarioModificacion(UsuarioAssembler.getUsuario(productosCorteVO.getUsuario().getIdUsuario()));
		productosCorte.setUltimaModificacion(new Date());		
		productosCorte = productosCorteDAO.update(productosCorte);		
		if(productosCorte.getIdProductoCorte() >= 0){
			return productosCorte.getIdProductoCorte();
		}
		return 0;
	}
	
	public Integer createProductosCorteAjuste(ProductosCorteVO productosCorteVO, List<MovimientoInventario> movimientosInventario,Integer idUsuario){
		int count = 0;
		ProductosCorteAjuste productosCorteAjuste;
		
		//Crea ajuste de corte de Productos
		for (MovimientoInventario movimientoInventario: movimientosInventario){			
			productosCorteAjuste = new ProductosCorteAjuste(null, ProductosCorteAssembler.getProductosCorte(productosCorteVO),
								UsuarioAssembler.getUsuario(idUsuario), new Date(), movimientoInventario);
			productosCorteAjuste = productosCorteAjusteDAO.save(productosCorteAjuste);
			count++;
		}	
			 
		return count;
	}
	
	public Integer removeProductosCorte(Integer idProductoCorte,Integer idCanal,Integer idAlmacen,Integer idUsuario) throws BusinessGlobalException {
		ProductosCorte productosCorte = productosCorteDAO.getById(idProductoCorte);		
		productosCorteDAO.delete(productosCorte);
		return 1;
	}
	
	public List<ProductosCorteVO> getProductosCorteEnConteo(Integer idAlmacen){		
		List<ProductosCorteVO> listProductosCorteVO = ProductosCorteAssembler.getProductosCorteVO(productosCorteDAO.getProductosCorte(idAlmacen, Constantes.PRODUCTO_EN_CONTEO));
		return listProductosCorteVO;
	}
	
	public Integer finalizarConteo(Integer idCanal,Integer idAlmacen,Integer idUsuario){
		return productosCorteDAO.updateEstatusConteoByEstatus(idAlmacen, Constantes.PRODUCTO_EN_CONTEO, Constantes.PRODUCTO_EN_CONTEO_FINALIZADO,idUsuario);
	}
	
}
