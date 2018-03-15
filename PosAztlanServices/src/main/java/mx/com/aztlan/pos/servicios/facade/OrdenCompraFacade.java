package mx.com.aztlan.pos.servicios.facade;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import io.jsonwebtoken.Claims;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.enumeration.ClaimsEnum;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.infraservices.servicios.NotFoundException;
import mx.com.aztlan.pos.negocio.administracion.vo.FiltrosVO;
import mx.com.aztlan.pos.negocio.administracion.vo.OrdenCompraVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ProductoVO;
import mx.com.aztlan.pos.negocio.reportes.vo.HttpResponseOcVO;
import mx.com.aztlan.pos.servicios.administracion.controller.OrdenCompraController;



@Service
public class OrdenCompraFacade implements OrdenCompraFacadeI {


	@Autowired
	OrdenCompraController ordenCompraController; 

	
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<List<ProductoVO>> buscar(@RequestBody FiltrosVO filtrosVO) throws BusinessGlobalException, NotFoundException {
		return new ResponseEntity<List<ProductoVO>>(this.ordenCompraController.buscar(filtrosVO), HttpStatus.OK);		
	}
	
	@Override
	@Transactional(readOnly = false)
	public ResponseEntity<HttpResponseOcVO> guardar(@RequestBody OrdenCompraVO ordenCompraVO, HttpServletRequest request) throws BusinessGlobalException, Exception{
		 Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		 Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		 
		 return new ResponseEntity<HttpResponseOcVO>(this.ordenCompraController.guardar(ordenCompraVO, idUsuario), HttpStatus.OK);
	}
}

