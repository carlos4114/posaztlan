package mx.com.tecnetia.muvitul.servicios.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.HttpResponseVO;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.AsientoVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.SalaCupoVO;
import mx.com.tecnetia.muvitul.servicios.configuracion.controller.SalaController;

@Service
public class SalaFacade implements SalaFacadeI {

	@Autowired
	SalaController salaController;
	
	@Override
	@Transactional(readOnly = false)
	public HttpResponseVO actualizarSala(@RequestBody SalaCupoVO salaVO) throws BusinessGlobalException{				
		return this.salaController.actualizarSala(salaVO);
	}
	
	@Override
	@Transactional(readOnly = false)
	public HttpResponseVO guardarSalaNueva(@RequestBody SalaCupoVO salaVO) throws BusinessGlobalException{				
		return this.salaController.guardarSalaNueva(salaVO);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<List<AsientoVO>> getMapaNuevo(@PathVariable("filas") Integer filas,@PathVariable("maxAsientos") Integer maxAsientos) throws BusinessGlobalException{
		return this.salaController.crearMapaNuevo(filas, maxAsientos);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<SalaCupoVO> getSalas(@PathVariable("idCine") Integer idCine) throws BusinessGlobalException{
		return this.salaController.obtenerSalas(idCine);
	}
	
}
