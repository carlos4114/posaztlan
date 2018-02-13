package mx.com.tecnetia.muvitul.negocio.configuracion.business;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.DetallePromocionDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ProductoDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.PromocionDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.PromocionParaDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.RegaloDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.TipoPromocionDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Producto;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Promocion;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PromocionPara;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Regalo;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TipoPromocion;
import mx.com.tecnetia.muvitul.negocio.configuracion.assembler.ConfigPromocionAssembler;
import mx.com.tecnetia.muvitul.negocio.configuracion.assembler.PromocionAssembler;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.ConfigPromocionVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.PromocionVO;

@Service
@Transactional
public class ConfigPromocionBO {
	
	@Autowired
	private TipoPromocionDAOI tipoPromocionDAO;
	
	@Autowired
	private PromocionParaDAOI promocionParaDAO;
	
	@Autowired
	private ProductoDAOI productoDAO;
	
	@Autowired
	private RegaloDAOI regaloDAO;
	
	@Autowired
	private PromocionDAOI promocionDAO;
	
	@Autowired
	private DetallePromocionDAOI detallePromocionDAO;
	
	public ConfigPromocionVO findConfigByCine(Integer idCine) {
		
		List<TipoPromocion> tiposPromocion = tipoPromocionDAO.findAll();
		List<PromocionPara> promocionesPara = promocionParaDAO.findAll();
		List<Producto> productos = productoDAO.findByCine(idCine);
		List<Regalo> regalos = regaloDAO.findByIdCine(idCine);
		
		return ConfigPromocionAssembler.getConfigPromocionVO(tiposPromocion, promocionesPara, productos, regalos );
	}
	
	
	public List<PromocionVO> findByCineAndDate(Integer idCine, Date fecha) {
		List<Promocion> promociones= promocionDAO.findByCineAndExhibicion(idCine, fecha);
		return PromocionAssembler.getPromocionesVO(promociones);
		
	}
	
	public PromocionVO save(PromocionVO promocionVO) {
		Promocion promocion = PromocionAssembler.getPromocion(promocionVO);
		
		detallePromocionDAO.save(promocion.getDetallePromocion());
		promocionDAO.save(promocion);
		
		promocionVO.setIdPromocion(promocion.getIdPromocion());
		return promocionVO;
	}
	
	public void delete(Integer idPromocion) {
		Promocion promocion= promocionDAO.findById(idPromocion);
		promocion.setActivo(false);
		promocionDAO.update(promocion);
	}
	
}