package mx.com.tecnetia.muvitul.negocio.inventarios.business;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ArticulosCorteAjusteDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ArticulosCorteDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ArticulosCorte;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ArticulosCorteAjuste;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.MovimientoInventario;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.dulceria.assembler.UsuarioAssembler;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.UsuarioVO;
import mx.com.tecnetia.muvitul.negocio.inventarios.assembler.ArticulosCorteAssembler;
import mx.com.tecnetia.muvitul.negocio.inventarios.vo.ArticulosCorteVO;
import mx.com.tecnetia.muvitul.servicios.util.Constantes;

@Service
@Transactional
public class ArticulosCorteBO {
	final static Log log = LogFactory.getLog(ArticulosCorteBO.class);
	
	@Autowired
	private ArticulosCorteDAO articulosCorteDAO;
	
	@Autowired
	private ArticulosCorteAjusteDAOI articulosCorteAjusteDAO;
	
	public Integer createArticulosCorte(ArticulosCorteVO articulosCorteVO,Integer idCine,Integer idPuntoVenta,Integer idUsuario) throws BusinessGlobalException {	
		UsuarioVO usuario = new UsuarioVO();
		usuario.setIdUsuario(idUsuario);
		articulosCorteVO.setUsuario(usuario);
		ArticulosCorte articulosCorte = ArticulosCorteAssembler.getArticulosCorte(articulosCorteVO);
		articulosCorte.setEstatusConteo(Constantes.ARTICULO_EN_CONTEO);
		articulosCorte.setFecha(new Date());
		articulosCorte.setUsuarioModificacion(UsuarioAssembler.getUsuario(articulosCorteVO.getUsuario().getIdUsuario()));
		articulosCorte.setUltimaModificacion(new Date());
		articulosCorte = articulosCorteDAO.save(articulosCorte);
		
		if(articulosCorte.getIdArticuloCorte() >= 0){
			return articulosCorte.getIdArticuloCorte();
		}
		return 0;
	}
	
	public Integer updateArticulosCorte(ArticulosCorteVO articulosCorteVO,Integer idCine,Integer idPuntoVenta,Integer idUsuario) throws BusinessGlobalException {		
		ArticulosCorte articulosCorte = articulosCorteDAO.getById(articulosCorteVO.getIdArticuloCorte());
		articulosCorte.setExistenciaSistema(articulosCorteVO.getExistenciaSistema());
		articulosCorte.setExistenciaFisica(articulosCorteVO.getExistenciaFisica());
		articulosCorte.setUsuarioModificacion(UsuarioAssembler.getUsuario(articulosCorteVO.getUsuario().getIdUsuario()));
		articulosCorte.setUltimaModificacion(new Date());		
		articulosCorte = articulosCorteDAO.update(articulosCorte);		
		if(articulosCorte.getIdArticuloCorte() >= 0){
			return articulosCorte.getIdArticuloCorte();
		}
		return 0;
	}
	
	public Integer createArticulosCorteAjuste(ArticulosCorteVO articulosCorteVO, List<MovimientoInventario> movimientosInventario,Integer idUsuario){
		int count = 0;
		ArticulosCorteAjuste articulosCorteAjuste;
		
		//Crea ajuste de corte de articulos
		for (MovimientoInventario movimientoInventario: movimientosInventario){			
			articulosCorteAjuste = new ArticulosCorteAjuste(null, ArticulosCorteAssembler.getArticulosCorte(articulosCorteVO),
								UsuarioAssembler.getUsuario(idUsuario), new Date(), movimientoInventario);
			articulosCorteAjuste = articulosCorteAjusteDAO.save(articulosCorteAjuste);
			count++;
		}	
			 
		return count;
	}
	
	public Integer removeArticulosCorte(Integer idArticuloCorte,Integer idCine,Integer idPuntoVenta,Integer idUsuario) throws BusinessGlobalException {
		ArticulosCorte articulosCorte = articulosCorteDAO.getById(idArticuloCorte);		
		articulosCorteDAO.delete(articulosCorte);
		return 1;
	}
	
	public List<ArticulosCorteVO> getArticulosCorteEnConteo(Integer idPuntoVenta){		
		List<ArticulosCorteVO> listarticulosCorteVO = ArticulosCorteAssembler.getArticulosCorteVO(articulosCorteDAO.getArticulosCorte(idPuntoVenta, Constantes.ARTICULO_EN_CONTEO));
		return listarticulosCorteVO;
	}
	
	public Integer finalizarConteo(Integer idCine,Integer idPuntoVenta,Integer idUsuario){
		return articulosCorteDAO.updateEstatusConteoByEstatus(idPuntoVenta, Constantes.ARTICULO_EN_CONTEO, Constantes.ARTICULO_EN_CONTEO_FINALIZADO,idUsuario);
	}
	
}
