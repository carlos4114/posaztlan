package mx.com.aztlan.pos.servicios.administracion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.HttpResponseVO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.OrdenCompra;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.negocio.administracion.business.OrdenCompraBO;
import mx.com.aztlan.pos.negocio.administracion.vo.FiltrosVO;
import mx.com.aztlan.pos.negocio.administracion.vo.OrdenCompraVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ProductoVO;
import mx.com.aztlan.pos.negocio.reportes.vo.HttpResponseOcVO;


@Service
public class OrdenCompraController {
	
	@Autowired
	OrdenCompraBO ordenCompraBO;	
	
	@Transactional(readOnly = true)
	public List<ProductoVO> buscar(FiltrosVO filtrosVO)  throws BusinessGlobalException{
		return ordenCompraBO.findByFiltros(filtrosVO);
	}
	
	@Transactional(readOnly = false, isolation = Isolation.SERIALIZABLE)
	public HttpResponseOcVO guardar(OrdenCompraVO ordenCompraVO, Integer idUsuario) throws BusinessGlobalException, Exception{
		if (ordenCompraVO == null) 
            throw new BusinessGlobalException("Error al guardar la orden de compra. La orden de compra no puede ser nula.");
		
		HttpResponseOcVO responseVO = new HttpResponseOcVO();
		
		OrdenCompra ordenCompra = this.ordenCompraBO.guardar(ordenCompraVO,idUsuario);
		
		this.ordenCompraBO.guardarDetalle(ordenCompra, ordenCompraVO);
		
		responseVO.setArchivoExcelVO(this.ordenCompraBO.crearXlsOc(ordenCompra.getIdOrdenCompra()));
		
		return responseVO;
	}
	
	@Transactional(readOnly = true)
	public OrdenCompraVO obtenerOrdenCompra(FiltrosVO filtrosVO)  throws BusinessGlobalException{
		return ordenCompraBO.obtenerOrdenCompra(filtrosVO);
	}
	
	@Transactional(readOnly = false)
	public HttpResponseVO cerrarOrdenCompra(OrdenCompraVO ordenCompraVO)  throws BusinessGlobalException{
		return ordenCompraBO.cerrarOrdenCompra(ordenCompraVO);
	}
	
	@Transactional(readOnly = false)
	public HttpResponseVO guardarEntrada(OrdenCompraVO ordenCompraVO)  throws BusinessGlobalException{
		if(ordenCompraVO.getParcial()) {
			return ordenCompraBO.guardarParcial(ordenCompraVO);
		}else
		{
			return ordenCompraBO.cerrarOrdenCompra(ordenCompraVO);
		}
		
	}
}
