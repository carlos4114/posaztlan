package mx.com.aztlan.pos.negocio.inventarios.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.TipoMovimientoInvDAOI;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.negocio.dulceria.assembler.TipoMovimientoInvAssembler;
import mx.com.aztlan.pos.negocio.dulceria.vo.TipoMovimientoInvVO;

@Service
@Transactional
public class CatalogoTipoMovimientoInvBO {

	@Autowired
	private TipoMovimientoInvDAOI tipoMovimientoInvDAO;
	
	public List<TipoMovimientoInvVO> findAll() throws BusinessGlobalException {
		return TipoMovimientoInvAssembler.getTiposMovimientoInvVO(tipoMovimientoInvDAO.findAll());
	}

	public List<TipoMovimientoInvVO> findByIsEntrada(Boolean isEntrada) throws BusinessGlobalException  {
		return TipoMovimientoInvAssembler.getTiposMovimientoInvVO(tipoMovimientoInvDAO.findByIsEntrada(isEntrada));
	}
	
	public List<TipoMovimientoInvVO> findByClave(String clave) throws BusinessGlobalException  {
		return TipoMovimientoInvAssembler.getTiposMovimientoInvVO(tipoMovimientoInvDAO.findByTypeClave(clave));
	}
}
