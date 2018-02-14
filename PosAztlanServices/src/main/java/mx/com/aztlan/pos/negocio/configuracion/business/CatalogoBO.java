package mx.com.aztlan.pos.negocio.configuracion.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ArticulosXPuntoVentaDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.CineDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.EstadoProductoDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.FormaPagoDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.MotivoCancelacionDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.MotivoDevolucionDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.PuntoVentaDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.TipoDevolucionDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Cine;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.negocio.configuracion.assembler.ArticuloAssembler;
import mx.com.aztlan.pos.negocio.configuracion.assembler.CineAssembler;
import mx.com.aztlan.pos.negocio.configuracion.assembler.EstadoProductoAssembler;
import mx.com.aztlan.pos.negocio.configuracion.assembler.FormaPagoAssembler;
import mx.com.aztlan.pos.negocio.configuracion.assembler.MotivoCancelacionAssembler;
import mx.com.aztlan.pos.negocio.configuracion.assembler.MotivoDevolucionAssembler;
import mx.com.aztlan.pos.negocio.configuracion.assembler.PuntoVentaAssembler;
import mx.com.aztlan.pos.negocio.configuracion.assembler.TipoDevolucionAssembler;
import mx.com.aztlan.pos.negocio.configuracion.vo.ArticuloVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.CineVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.EstadoProductoVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.FormaPagoVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.MotivoCancelacionVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.MotivoDevolucionVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.PuntoVentaVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.TipoDevolucionVO;

@Service
@Transactional
public class CatalogoBO {
	@Autowired
	private FormaPagoDAOI formaPagoDAO;

	@Autowired
	private PuntoVentaDAOI puntoVentaDAO;
	
	@Autowired
	private MotivoDevolucionDAOI motivoDevolucionDAO;
	
	@Autowired
	private TipoDevolucionDAOI tipoDevolucionDAO;
	
	@Autowired
	private EstadoProductoDAOI estadoProductoDAO;
	
	@Autowired
	private MotivoCancelacionDAOI motivoCancelacionDAO;
	
	@Autowired
	private ArticulosXPuntoVentaDAOI articulosXPuntoVentaDAO;
	
	@Autowired
	private CineDAOI cineDAO;
	
	public List<FormaPagoVO> getFormasPagos() throws BusinessGlobalException {
		return FormaPagoAssembler.getFormasPagosVO(formaPagoDAO.findAll());
	}

	public List<ArticuloVO> getArticulos(Integer idCine, Integer idPuntoVenta) throws BusinessGlobalException {
		return ArticuloAssembler.getArticulosVO(articulosXPuntoVentaDAO.findByIdCineAndIdPuntoVenta(idCine, idPuntoVenta));
	}
	
	public List<PuntoVentaVO> findByCinePuntosVenta(Integer idCine) throws BusinessGlobalException  {
		return PuntoVentaAssembler.getPuntosVentaVO(puntoVentaDAO.findByIdCine(idCine));
	}

	public List<MotivoDevolucionVO> getMotivosDevolucion(Integer idPuntoVenta) throws BusinessGlobalException {
		return MotivoDevolucionAssembler.getMotivosDevolucionVO(motivoDevolucionDAO.findByPuntoVenta(idPuntoVenta));
	}

	public List<TipoDevolucionVO> getTiposDevolucion(Integer idTipoPuntoVenta) throws BusinessGlobalException {
		return TipoDevolucionAssembler.getTiposDevolucionVO(tipoDevolucionDAO.findByTipoPuntoVenta(idTipoPuntoVenta));
	}

	public List<EstadoProductoVO> getEstadosProducto() throws BusinessGlobalException {
		return EstadoProductoAssembler.getEstadosProductoVO(estadoProductoDAO.findAll());
	}

	public List<MotivoCancelacionVO> getMotivosCancelacion() throws BusinessGlobalException {
		return MotivoCancelacionAssembler.getMotivosCancelacionVO(motivoCancelacionDAO.findAll());
	}

	public List<CineVO> getCinesEmpresa(Integer idCine) throws BusinessGlobalException {
		Cine cine= cineDAO.getById(idCine);
		 List<CineVO> cinesVO= CineAssembler.getCinesVO(cineDAO.findByEmpresa(cine.getEmpresa().getIdEmpresa()));
		for (CineVO cineEmpresa : cinesVO) {
			if (cine.getIdCine().equals(cineEmpresa.getIdCine())){
				cineEmpresa.setCineUsuario(true);
			}
		}
		return cinesVO;
	}
	
	public List<CineVO> getCines(Integer idEmpresa) throws BusinessGlobalException {
		 List<CineVO> cinesVO= CineAssembler.getCinesVO(cineDAO.findByEmpresa(idEmpresa));
		return cinesVO;
	}
}
