package mx.com.tecnetia.muvitul.servicios.configuracion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.infraservices.servicios.NotFoundException;
import mx.com.tecnetia.muvitul.negocio.configuracion.business.AutorizacionBO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.EstatusAutorizacionVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.RequestAutorizacionVO;

@Service
public class AutorizacionController {
	@Autowired
	private AutorizacionBO autorizacionBO;
	
	public EstatusAutorizacionVO createAutorizacion(RequestAutorizacionVO requestAutorizacionVO) throws BusinessGlobalException {
		return autorizacionBO.createAutorizacion(requestAutorizacionVO);
	}

}
