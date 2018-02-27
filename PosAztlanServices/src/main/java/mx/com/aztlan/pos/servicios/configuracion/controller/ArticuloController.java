package mx.com.aztlan.pos.servicios.configuracion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.HttpResponseVO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ArticuloDAOI;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.negocio.configuracion.business.ArticuloBO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ArticuloVO;

@Service
public class ArticuloController {

	@Autowired
	ArticuloDAOI articuloDAO;	

	@Autowired
	ArticuloBO articuloBO;	
	
	@Transactional(readOnly = false)
	public HttpResponseVO guardar(ArticuloVO articuloVO) throws BusinessGlobalException, Exception{
		if (articuloVO == null) 
            throw new BusinessGlobalException("Error al guardar el articulo. El articulo no puede ser nulo.");
		
		return articuloBO.guardar(articuloVO);
	}
	
	@Transactional(readOnly = false)
	public HttpResponseVO actualizar(ArticuloVO articuloVO) throws BusinessGlobalException, Exception{
		if (articuloVO == null) 
            throw new BusinessGlobalException("Error al guardar el articulo. El articulo no puede ser nulo.");
		
		return articuloBO.actualizar(articuloVO);
	}
	
	@Transactional(readOnly = true)
	public List<ArticuloVO> obtener(Integer idCine)  throws BusinessGlobalException{
		return articuloBO.findByCine(idCine);
	}
}
