package mx.com.aztlan.pos.servicios.configuracion.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.aztlan.pos.negocio.configuracion.business.ConfigProgramacionBO;
import mx.com.aztlan.pos.negocio.configuracion.business.ConfigPromocionBO;
import mx.com.aztlan.pos.negocio.configuracion.business.PaqueteBO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ConfigProgramacionVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ConfigPromocionVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.PaqueteVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ProductoVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ProgramacionVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.PromocionVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.SalaProgramacionVO;

@Service
public class ConfiguracionController {

	@Autowired
	private PaqueteBO paqueteBO;
	
	@Autowired
	private ConfigProgramacionBO configProgramacionBO;
	
	@Autowired
	private ConfigPromocionBO configPromocionBO;

	public List<ProductoVO> findProductosByCine(Integer idCine) {
		return paqueteBO.findProductosByCine(idCine);
	}

	public List<PaqueteVO> findPaquetesByCine(Integer idCine) {
		return paqueteBO.findPaquetesByCine(idCine);
	}

	public ConfigProgramacionVO findConfigProgramacionByCine(Integer idCine) {
		return configProgramacionBO.findConfigByCine(idCine);
	}

	public List<SalaProgramacionVO> findProgramacionOfSala(Integer idCine, Date fecha) {
		return configProgramacionBO.findProgramacionOfSala(idCine,fecha);
	}

	public ProgramacionVO createProgramacion(ProgramacionVO programacionVO) {
		return configProgramacionBO.save(programacionVO);
	}

	public void deleteProgramacion(Integer id) {
		configProgramacionBO.delete(id);
	}

	public ConfigPromocionVO findConfigPromocionByCine(Integer idCine) {
		return configPromocionBO.findConfigByCine(idCine);
	}

	public List<PromocionVO> findPromocionByCineAndDate(Integer idCine, Date fecha) {
		return configPromocionBO.findByCineAndDate(idCine, fecha);
	}

	public PromocionVO createPromocion(PromocionVO promocionVO) {
		return configPromocionBO.save(promocionVO);
	}

	public void deletePromocion(Integer idPromocion) {
		configPromocionBO.delete(idPromocion);
	}

	public PaqueteVO createPaquete(PaqueteVO paqueteVO) {
		return paqueteBO.save(paqueteVO);
	}

	public void deletePaquete(Integer id) {
		paqueteBO.delete(id);
	}



}
