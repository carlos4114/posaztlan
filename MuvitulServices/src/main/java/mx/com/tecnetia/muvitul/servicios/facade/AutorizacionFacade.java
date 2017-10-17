package mx.com.tecnetia.muvitul.servicios.facade;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import io.jsonwebtoken.Claims;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.enumeration.ClaimsEnum;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.infraservices.servicios.NotFoundException;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.EstatusAutorizacionVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.RequestAutorizacionVO;
import mx.com.tecnetia.muvitul.servicios.configuracion.controller.AutorizacionController;

@Service
public class AutorizacionFacade implements AutorizacionFacadeI {
	private static final Logger logger = LoggerFactory.getLogger(AutorizacionFacade.class);

	@Autowired
	private AutorizacionController autorizacionController;

	@Override
	public ResponseEntity<EstatusAutorizacionVO>  createAutorizacion (HttpServletRequest request,
			@RequestBody RequestAutorizacionVO requestAutorizacionVO) throws BusinessGlobalException, NotFoundException {

		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		
		logger.info("GetAutorizacionMovimiento:::IdUsuario[{}]:::IdCine[{}]", idUsuario, idCine);

		EstatusAutorizacionVO estatusAutorizacionVO = autorizacionController.createAutorizacion(requestAutorizacionVO);
		
		if (estatusAutorizacionVO == null ) {
			throw new NotFoundException("No encontrado");
		}
		
		return new ResponseEntity<EstatusAutorizacionVO>(estatusAutorizacionVO, HttpStatus.OK);
		
	}

}
