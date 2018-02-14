package mx.com.aztlan.pos.servicios.configuracion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.infraservices.servicios.NotFoundException;
import mx.com.aztlan.pos.negocio.configuracion.business.AutorizacionBO;
import mx.com.aztlan.pos.negocio.configuracion.vo.EstatusAutorizacionVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.RequestAutorizacionVO;

@Service
public class AutorizacionController {
	@Autowired
	private AutorizacionBO autorizacionBO;
	
	public EstatusAutorizacionVO createAutorizacion(RequestAutorizacionVO requestAutorizacionVO) throws BusinessGlobalException {
		return autorizacionBO.createAutorizacion(requestAutorizacionVO);
	}

}
