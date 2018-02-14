package mx.com.aztlan.pos.negocio.inventarios.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ProveedorDAOI;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.negocio.inventarios.assembler.ProveedorAssembler;
import mx.com.aztlan.pos.negocio.inventarios.vo.ProveedorVO;

@Service
@Transactional
public class CatalogoProveedorBO {
	
	@Autowired
	private ProveedorDAOI proveedorDAO;

	public List<ProveedorVO> findAll() throws BusinessGlobalException {
		return ProveedorAssembler.getProveedoresVO(proveedorDAO.findAll());
	}

	public List<ProveedorVO> findByCine(Integer idCine) throws BusinessGlobalException  {
		return ProveedorAssembler.getProveedoresVO(proveedorDAO.findByIdCine(idCine));
	}
	
}
