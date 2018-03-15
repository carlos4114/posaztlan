package mx.com.aztlan.pos.negocio.administracion.business;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.FolioSecuenciaDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.OrdenCompraDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.OrdenCompraDetalleDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.OrdenCompraIbatisDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ProductoDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.FolioSecuencia;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.OrdenCompra;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Producto;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.enumeration.EstatusOrdenCompraEnum;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.infraservices.servicios.NotFoundException;
import mx.com.aztlan.pos.negocio.administracion.assembler.OrdenCompraAssembler;
import mx.com.aztlan.pos.negocio.administracion.vo.FiltrosVO;
import mx.com.aztlan.pos.negocio.administracion.vo.OrdenCompraVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ProductoVO;
import mx.com.aztlan.pos.negocio.reportes.business.ReporteJasperBO;
import mx.com.aztlan.pos.negocio.reportes.vo.ArchivoExcelVO;
import mx.com.aztlan.pos.negocio.reportes.vo.ReporteJasperVO;
import net.sf.jasperreports.engine.JRException;

@Service
@Transactional
public class OrdenCompraBO {
	
	@Autowired
	ServletContext context;

	@Autowired
	ProductoDAOI productoDAO;
	
	@Autowired
	OrdenCompraDAOI ordenCompraDAO;
	
	@Autowired
	OrdenCompraDetalleDAOI ordenCompraDetalleDAO;
	
	@Autowired
	OrdenCompraIbatisDAOI ordenCompraIbatisDAO;
	
	@Autowired
	FolioSecuenciaDAOI folioSecuenciaDAO;
	
	@Autowired
	private ReporteJasperBO reporteJasperBO;
	
	@Transactional(readOnly = true)
	public List<ProductoVO> findByFiltros(FiltrosVO filtrosVO) throws BusinessGlobalException  {
		 
		List<ProductoVO> productosVO = new ArrayList<ProductoVO>();
		
		List<Producto> productos = productoDAO.findByFiltros(filtrosVO.getIdEmpresa(), 
															filtrosVO.getIdFamilia()==null?0:filtrosVO.getIdFamilia(), 
															filtrosVO.getIdMarca()==null?0:filtrosVO.getIdMarca(), 
															filtrosVO.getIdTipoProducto()==null?0:filtrosVO.getIdTipoProducto(),
															filtrosVO.getIdMedida()==null?0:filtrosVO.getIdMedida(), 
															filtrosVO.getNombre()==null?"":filtrosVO.getNombre());

		for (Producto producto : productos) {
			
			BigDecimal precio = null;
			if(filtrosVO.getIdProveedor()!=null)
				precio = this.ordenCompraIbatisDAO.obtenerPrecioUltimaOrdenCompra(producto.getIdProducto(), filtrosVO.getIdProveedor());
			
			productosVO.add(OrdenCompraAssembler.getProductoVO(producto,precio));
		}
		
		return productosVO; 
		
	}
	
	@Transactional(readOnly = false, isolation = Isolation.SERIALIZABLE)
	public OrdenCompra guardar(OrdenCompraVO ordenCompraVO, Integer idUsuario) throws BusinessGlobalException  {
		ordenCompraVO.setIdEstatusOrdenCompra(EstatusOrdenCompraEnum.NUEVA);
		FolioSecuencia folioSecuencia = this.folioSecuenciaDAO.getById(ordenCompraVO.getIdEmpresa());
		Integer folio = null;
		if(folioSecuencia==null){
			folio = 1;
			this.folioSecuenciaDAO.save(new FolioSecuencia(ordenCompraVO.getIdEmpresa(),1));
		}else{
			folio = folioSecuencia.getUltimoFolioOc()+1;
			folioSecuencia.setUltimoFolioOc(folio);
			this.folioSecuenciaDAO.update(folioSecuencia);
		}
		
		OrdenCompra ordenCompra = ordenCompraDAO.save(OrdenCompraAssembler.getOrdenCompra(ordenCompraVO,idUsuario,folio));
		
		return ordenCompra;
	}
	
	@Transactional(readOnly = false)
	public OrdenCompra guardarDetalle(OrdenCompra ordenCompra, OrdenCompraVO ordenCompraVO) throws BusinessGlobalException  {
		
		List<ProductoVO> productos = ordenCompraVO.getProductos();
		
		for(ProductoVO productoVO : productos) {
			ordenCompraDetalleDAO.save(OrdenCompraAssembler.getOrdenCompraDetalle(ordenCompra, productoVO));
		}
		
		return ordenCompra;
	}
	
	@Transactional(readOnly = true)
	public ArchivoExcelVO crearXlsOc(Integer idOrdenCompra) throws BusinessGlobalException  {
		ArchivoExcelVO archivoExcelVO = new ArchivoExcelVO("OrdenCompraNueva");
		
		ResourceBundle cfg = ResourceBundle.getBundle("config");
		String rutaJasper = cfg.getString("reporte.ordencompra.nueva.jasper");
		String rutaReporteXls = context.getRealPath(cfg.getString("reporte.ordencompra.nueva.xls"));
			  	 
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("ID_OC", idOrdenCompra);
 
		ReporteJasperVO reporteJasperVO = new ReporteJasperVO();
		reporteJasperVO.setRutaReporte(rutaJasper);
		reporteJasperVO.setRutaPdf(rutaReporteXls);
		reporteJasperVO.setParametros(params);
		 
		try {
			archivoExcelVO.setArchivo(reporteJasperBO.getReporteXls(reporteJasperVO));
		} catch (HibernateException | BusinessGlobalException | NotFoundException | IOException | JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return archivoExcelVO;
	}
}
