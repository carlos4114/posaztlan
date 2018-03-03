package mx.com.aztlan.pos.negocio.administracion.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.OrdenCompraDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.OrdenCompraDetalleDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ProductoDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.OrdenCompra;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.OrdenCompraDetalle;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.negocio.administracion.assembler.OrdenCompraAssembler;
import mx.com.aztlan.pos.negocio.administracion.vo.FiltrosVO;
import mx.com.aztlan.pos.negocio.administracion.vo.OrdenCompraVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ProductoVO;

@Service
@Transactional
public class OrdenCompraBO {

	@Autowired
	ProductoDAOI productoDAO;
	
	@Autowired
	OrdenCompraDAOI ordenCompraDAO;
	
	@Autowired
	OrdenCompraDetalleDAOI ordenCompraDetalleDAO;
	
	@Transactional(readOnly = true)
	public List<ProductoVO> findByFiltros(FiltrosVO filtrosVO) throws BusinessGlobalException  {
		 
		return OrdenCompraAssembler.getProductosVO(productoDAO.findByFiltros(filtrosVO.getIdEmpresa(), 
				filtrosVO.getIdFamilia()==null?0:filtrosVO.getIdFamilia(), 
				filtrosVO.getIdMarca()==null?0:filtrosVO.getIdMarca(), 
				filtrosVO.getIdTipoProducto()==null?0:filtrosVO.getIdTipoProducto(),
				filtrosVO.getIdMedida()==null?0:filtrosVO.getIdMedida(), 
				filtrosVO.getNombre()==null?"":filtrosVO.getNombre())); 
		
	}
	
	@Transactional(readOnly = true)
	public OrdenCompra guardar(OrdenCompraVO ordenCompraVO) throws BusinessGlobalException  {
		OrdenCompra ordenCompra = ordenCompraDAO.save(OrdenCompraAssembler.getOrdenCompra(ordenCompraVO));
		
		return ordenCompra;
	}
	
	@Transactional(readOnly = true)
	public OrdenCompra guardarDetalle(OrdenCompra ordenCompra, OrdenCompraVO ordenCompraVO) throws BusinessGlobalException  {
		
		List<ProductoVO> productos = ordenCompraVO.getProductos();
		
		for(ProductoVO productoVO : productos) {
			ordenCompraDetalleDAO.save(OrdenCompraAssembler.getOrdenCompraDetalle(ordenCompra, productoVO));
		}
		
		return ordenCompra;
	}
}
