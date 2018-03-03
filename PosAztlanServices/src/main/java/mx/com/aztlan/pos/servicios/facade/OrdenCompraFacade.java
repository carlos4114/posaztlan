package mx.com.aztlan.pos.servicios.facade;

import java.math.BigDecimal;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.HttpResponseVO;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.infraservices.servicios.NotFoundException;
import mx.com.aztlan.pos.negocio.administracion.vo.FiltrosVO;
import mx.com.aztlan.pos.negocio.administracion.vo.OrdenCompraVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ArticuloVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ProductoVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.PuntosVentaListVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.UnidadMedidaVO;
import mx.com.aztlan.pos.servicios.administracion.controller.OrdenCompraController;
import mx.com.aztlan.pos.servicios.configuracion.controller.ProductoController;



@Service
public class OrdenCompraFacade implements OrdenCompraFacadeI {


	@Autowired
	OrdenCompraController ordenCompraController; 

	
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<List<ProductoVO>> buscar(@RequestBody FiltrosVO filtrosVO) throws BusinessGlobalException, NotFoundException {
		return new ResponseEntity<List<ProductoVO>>(this.ordenCompraController.buscar(filtrosVO), HttpStatus.OK);		
	}
}

