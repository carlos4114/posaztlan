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
import mx.com.aztlan.pos.negocio.configuracion.vo.ArticuloVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ProductoVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.PuntosVentaListVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.UnidadMedidaVO;
import mx.com.aztlan.pos.servicios.configuracion.controller.ProductoController;



@Service
public class ProductoFacade implements ProductoFacadeI {

	@Autowired
	ProductoController productoController;
		
	@Override
	@Transactional(readOnly = false)
	public HttpResponseVO guardar(@RequestBody ProductoVO productoVO) throws BusinessGlobalException, Exception{
		 return this.productoController.guardar(productoVO);
	}
	
	@Override
	@Transactional(readOnly = false)
	public HttpResponseVO actualizar(@RequestBody ProductoVO productoVO) throws BusinessGlobalException, Exception{
		 return this.productoController.actualizar(productoVO);
	}
	
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<List<ProductoVO>> obtener(@PathVariable("idEmpresa") Integer idEmpresa) throws BusinessGlobalException, NotFoundException {
		return new ResponseEntity<List<ProductoVO>>(this.productoController.obtener(idEmpresa), HttpStatus.OK);		
	}
	
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<UnidadMedidaVO> consultaUnidadMedida(@PathVariable("idArticulo") Integer idArticulo) throws BusinessGlobalException, NotFoundException {
		return new ResponseEntity<UnidadMedidaVO>(this.productoController.consultaUnidadMedida(idArticulo), HttpStatus.OK);		
	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<BigDecimal> consultaPrecioUnitario(@PathVariable("idArticulo") Integer idArticulo) throws BusinessGlobalException, Exception {
		return new ResponseEntity<BigDecimal>(this.productoController.consultaPrecioUnitario(idArticulo), HttpStatus.OK);		
	}
	
}

