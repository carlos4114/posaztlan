package mx.com.aztlan.pos.negocio.configuracion.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.PaqueteDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ProductoDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Paquete;
import mx.com.aztlan.pos.negocio.configuracion.assembler.PaqueteAssembler;
import mx.com.aztlan.pos.negocio.configuracion.assembler.ProductoAssembler;
import mx.com.aztlan.pos.negocio.configuracion.vo.PaqueteVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ProductoVO;

@Service
@Transactional
public class PaqueteBO {
	
	@Autowired
	private ProductoDAOI productoDAO;

	@Autowired
	private PaqueteDAOI paqueteDAO;
	
	public List<ProductoVO> findProductosByCine(Integer idCine) {
		return ProductoAssembler.getProductos(productoDAO.findByCine(idCine));
	}

	public List<PaqueteVO> findPaquetesByCine(Integer idCine) {
		return PaqueteAssembler.getPaquetes(paqueteDAO.findByCine(idCine));
	}
	
	public PaqueteVO save(PaqueteVO paqueteVO) {
		Paquete paquete = PaqueteAssembler.getPaquete(paqueteVO);
		return PaqueteAssembler.getPaqueteVO(paqueteDAO.save(paquete));
	}

	public void delete(Integer idPaquete) {
		Paquete paquete = paqueteDAO.findById(idPaquete);
		paquete.setActivo(false);
		paqueteDAO.update(paquete);
	}


}