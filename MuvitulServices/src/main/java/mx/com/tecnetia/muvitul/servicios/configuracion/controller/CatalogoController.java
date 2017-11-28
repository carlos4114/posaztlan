package mx.com.tecnetia.muvitul.servicios.configuracion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.configuracion.business.CatalogoBO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.ArticuloVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.CineVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.EstadoProductoVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.FormaPagoVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.MotivoCancelacionVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.MotivoDevolucionVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.PuntoVentaVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.TipoDevolucionVO;
import mx.com.tecnetia.muvitul.negocio.inventarios.business.CatalogoProveedorBO;
import mx.com.tecnetia.muvitul.negocio.inventarios.vo.ProveedorVO;

@Service
public class CatalogoController {

	@Autowired
	private CatalogoBO catalogoBO;
	
	@Autowired
	private CatalogoProveedorBO catalogoProveedorBO;
	
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


}
