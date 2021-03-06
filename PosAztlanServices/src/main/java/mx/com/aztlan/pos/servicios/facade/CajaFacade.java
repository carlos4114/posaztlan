package mx.com.aztlan.pos.servicios.facade;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import io.jsonwebtoken.Claims;
import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.HttpResponseVO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.enumeration.ClaimsEnum;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.negocio.caja.vo.CorteCajaVO;
import mx.com.aztlan.pos.servicios.caja.controller.CajaController;

@Service
public class CajaFacade implements CajaFacadeI {
	@Autowired
	private CajaController cajaController;
	
	@Override
	@Transactional(readOnly = false)
	public HttpResponseVO guardarCorte(@RequestBody CorteCajaVO corteCajaVO,HttpServletRequest request) throws BusinessGlobalException{	
			return this.cajaController.guardarCorteCaja(corteCajaVO, (Claims)request.getAttribute(ClaimsEnum.CLAIMS_ID));		
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public BigDecimal obtenerEfectivo(HttpServletRequest request) throws BusinessGlobalException, Exception{
		return this.cajaController.obtenerEfectivoEnCaja((Claims)request.getAttribute(ClaimsEnum.CLAIMS_ID));
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<CorteCajaVO> obtenerUltimosCortes(HttpServletRequest request) throws BusinessGlobalException, Exception{
		return this.cajaController.obtenerCortesCaja((Claims)request.getAttribute(ClaimsEnum.CLAIMS_ID));
	}
	
}
