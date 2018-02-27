package mx.com.aztlan.pos.negocio.configuracion.business;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.HttpResponseVO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ArticuloDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ArticulosXPuntoVentaDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.PuntoVentaDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Articulo;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ArticulosXPuntoVenta;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ArticulosXPuntoVentaId;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PuntoVenta;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.negocio.configuracion.assembler.ArticuloAssembler;
import mx.com.aztlan.pos.negocio.configuracion.vo.ArticuloVO;

@Service
@Transactional
public class ArticuloBO {

	@Autowired
	ArticuloDAOI articuloDAO;		
	
	@Autowired
	PuntoVentaDAOI puntoVentaDAO;
	
	@Autowired
	ArticulosXPuntoVentaDAOI articulosXPuntoVentaDAO;
	
	@Transactional(readOnly = false)
	public HttpResponseVO guardar(ArticuloVO articuloVO) throws BusinessGlobalException, Exception{
		if (articuloVO == null) 
            throw new BusinessGlobalException("Error al guardar articulo. El articulo no puede ser nulo.");
		
		HttpResponseVO responseVO = new HttpResponseVO();
		
		//validar que el articulo no exista por nombre
		List<Articulo> articulos = this.articuloDAO.getArticulosByName(articuloVO.getIdCine(), articuloVO.getNombre()); 
				
		if(articulos.size() > 0){
	            	responseVO.setErrorCode(1);
	            	responseVO.setMessage("El articulo ya existe.");
	
	            	return responseVO;
		}
		
		Articulo articulo = ArticuloAssembler.getArticulo(articuloVO);
		articulo = articuloDAO.save(articulo);

		for(Integer idPuntoVenta : articuloVO.getPuntosVentaList()){
			
			ArticulosXPuntoVenta articuloPV = new ArticulosXPuntoVenta(
					new ArticulosXPuntoVentaId(idPuntoVenta, articulo.getIdArticulo()),
					articulo, new PuntoVenta(idPuntoVenta));
			
			articulosXPuntoVentaDAO.save(articuloPV);
		}

		return responseVO;

	}
	

	@Transactional(readOnly = false)
	public HttpResponseVO actualizar(ArticuloVO articuloVO) throws BusinessGlobalException, Exception{
		if (articuloVO == null) 
            throw new BusinessGlobalException("Error al guardar articulo. El articulo no puede ser nulo.");
		
		HttpResponseVO responseVO = new HttpResponseVO();
		
		Articulo articulo = articuloDAO.findById(articuloVO.getIdArticulo());
		articulo = ArticuloAssembler.getArticulo(articuloVO, articulo);
		articulo = articuloDAO.update(articulo);
		
		
		Iterator<ArticulosXPuntoVenta> articulosPVIterator = articulo.getArticulosXPuntoVentas().iterator();
		while(articulosPVIterator.hasNext()){
			ArticulosXPuntoVenta articuloPV = articulosPVIterator.next();
			articulosXPuntoVentaDAO.delete(articuloPV);
		}
		
		
		for(Integer idPuntoVenta:articuloVO.getPuntosVentaList()){
			ArticulosXPuntoVenta articuloPV = new ArticulosXPuntoVenta(
					new ArticulosXPuntoVentaId(idPuntoVenta,articulo.getIdArticulo())
					,articulo,
					new PuntoVenta(idPuntoVenta)
					);
			articulosXPuntoVentaDAO.save(articuloPV);
		}
		
		return responseVO;
	}

	@Transactional(readOnly = false)
	public List<ArticuloVO> findByCine(Integer idCine) throws BusinessGlobalException  {
		
		List<ArticuloVO> articulos = ArticuloAssembler.getArticulos(articuloDAO.findByIdCine(idCine));
		
		return articulos;
		
	}
}
