package mx.com.aztlan.pos.servicios.configuracion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.HttpResponseVO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Paquete;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.negocio.configuracion.business.PaqueteBO;
import mx.com.aztlan.pos.negocio.configuracion.vo.PaqueteVO;

@Service
public class PaqueteController {
	
	@Autowired
	PaqueteBO paqueteBO;	
	
	@Transactional(readOnly = false)
	public HttpResponseVO guardar(PaqueteVO paqueteVO) throws BusinessGlobalException, Exception{
		
		HttpResponseVO responseVO = new HttpResponseVO();
		
		responseVO = paqueteBO.ValidarPaquete(paqueteVO);
		
		if(responseVO.getMessage() != null){
			return responseVO;
		}
		
		Paquete paquete = paqueteBO.guardarPaquete(paqueteVO);
		
		paqueteBO.guardarProductosXPaquete(paqueteVO, paquete);
		
		paqueteBO.guardarPaquetesXPuntoVenta(paqueteVO, paquete);
		
		return responseVO;
	}
	
	@Transactional(readOnly = false)
	public HttpResponseVO actualizar(PaqueteVO paqueteVO) throws BusinessGlobalException, Exception{
		HttpResponseVO responseVO = new HttpResponseVO();
		
		paqueteBO.actualizar(paqueteVO);
		
		if(paqueteVO.isActivo()){

			Paquete paquete = paqueteBO.guardarPaquete(paqueteVO);
			
			paqueteBO.guardarProductosXPaquete(paqueteVO, paquete);
			
			paqueteBO.guardarPaquetesXPuntoVenta(paqueteVO, paquete);
		} 

		return responseVO;
	}
	
	@Transactional(readOnly = true)
	public List<PaqueteVO> obtener(Integer idCine)  throws BusinessGlobalException{

		return paqueteBO.obtener(idCine);
	}
	
}
