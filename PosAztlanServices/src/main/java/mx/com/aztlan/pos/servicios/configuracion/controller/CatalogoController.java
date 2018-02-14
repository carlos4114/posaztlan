package mx.com.aztlan.pos.servicios.configuracion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.CajaDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.CargoAjusteDAOI;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.negocio.caja.assembler.CajaAssembler;
import mx.com.aztlan.pos.negocio.caja.assembler.CargoAjusteAssembler;
import mx.com.aztlan.pos.negocio.configuracion.business.CatalogoBO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ArticuloVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.CatalogoVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.CineVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.EstadoProductoVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.FormaPagoVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.MotivoCancelacionVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.MotivoDevolucionVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.PuntoVentaVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.TipoDevolucionVO;
import mx.com.aztlan.pos.negocio.inventarios.business.CatalogoProveedorBO;
import mx.com.aztlan.pos.negocio.inventarios.vo.ProveedorVO;

@Service
public class CatalogoController {

	@Autowired
	private CatalogoBO catalogoBO;
	@Autowired
	private CargoAjusteDAOI cargoAjusteDAO;
	@Autowired
	private CajaDAOI cajaDAO;
	
	
	@Autowired
	private CatalogoProveedorBO catalogoProveedorBO;		
	
	/**
     * Servicio para obtener catalogo de cajas
     */
	@Transactional (readOnly = true)
	public List<CatalogoVO> getCajas(Integer idPuntoVenta) throws BusinessGlobalException{
	
		 return CajaAssembler.getListaVO(this.cajaDAO.getActivos(idPuntoVenta));
	}
	
	/**
     * Servicio para obtener catalogo de cargos de ajuste
     */
	@Transactional (readOnly = true)
	public List<CatalogoVO> getCargoAjuste() throws BusinessGlobalException{
		 return CargoAjusteAssembler.getListaVO(this.cargoAjusteDAO.getActivos());
	}

	
	public List<FormaPagoVO> getFormasPagos() throws BusinessGlobalException {
		return catalogoBO.getFormasPagos();
	}
	
	public List<ArticuloVO> getArticulos( Integer idCine, Integer idPuntoVenta) throws BusinessGlobalException {
		return catalogoBO.getArticulos( idCine, idPuntoVenta);
	}

	public List<PuntoVentaVO> getPuntosVenta(Integer idCine)  throws BusinessGlobalException{
		return catalogoBO.findByCinePuntosVenta(idCine);
	}
	
	public List<ProveedorVO> getProveedor(Integer idCine)  throws BusinessGlobalException{
		return catalogoProveedorBO.findByCine(idCine);
	}
	
	public List<MotivoDevolucionVO> getMotivosDevolucion(Integer idPuntoVenta)  throws BusinessGlobalException{
		return catalogoBO.getMotivosDevolucion(idPuntoVenta);
	}
	
	public List<TipoDevolucionVO> getTiposDevolucion(Integer idTipoPuntoVenta)  throws BusinessGlobalException{
		return catalogoBO.getTiposDevolucion(idTipoPuntoVenta);
	}

	public List<EstadoProductoVO> getEstadosProducto()  throws BusinessGlobalException{
		return catalogoBO.getEstadosProducto();
	}

	public List<MotivoCancelacionVO> getMotivosCancelacion()  throws BusinessGlobalException{
		return catalogoBO.getMotivosCancelacion();
	}

	public List<CineVO> getCinesEmpresa(Integer idCine) throws BusinessGlobalException {
		return catalogoBO.getCinesEmpresa(idCine);
	}
	
	public List<CineVO> getCines(Integer idEmpresa) throws BusinessGlobalException {
		return catalogoBO.getCinesEmpresa(idEmpresa);
	}

}
