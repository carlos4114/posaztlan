package mx.com.aztlan.pos.servicios.administracion.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.HttpResponseVO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Producto;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.negocio.administracion.business.OrdenCompraBO;
import mx.com.aztlan.pos.negocio.administracion.vo.FiltrosVO;
import mx.com.aztlan.pos.negocio.administracion.vo.OrdenCompraVO;
import mx.com.aztlan.pos.negocio.configuracion.business.ProductoBO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ArticuloVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ProductoVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.PuntosVentaListVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.UnidadMedidaVO;


@Service
public class OrdenCompraController {
	
	@Autowired
	OrdenCompraBO ordenCompraBO;	
	
	@Transactional(readOnly = true)
	public List<ProductoVO> buscar(FiltrosVO filtrosVO)  throws BusinessGlobalException{
		return ordenCompraBO.findByFiltros(filtrosVO);
	}
}
