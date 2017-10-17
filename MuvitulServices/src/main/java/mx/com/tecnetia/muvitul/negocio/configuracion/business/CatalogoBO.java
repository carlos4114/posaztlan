package mx.com.tecnetia.muvitul.negocio.configuracion.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.CineDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.EstadoProductoDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.FormaPagoDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.MotivoCancelacionDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.MotivoDevolucionDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.PuntoVentaDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.TipoDevolucionDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Cine;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.configuracion.assembler.CineAssembler;
import mx.com.tecnetia.muvitul.negocio.configuracion.assembler.EstadoProductoAssembler;
import mx.com.tecnetia.muvitul.negocio.configuracion.assembler.FormaPagoAssembler;
import mx.com.tecnetia.muvitul.negocio.configuracion.assembler.MotivoCancelacionAssembler;
import mx.com.tecnetia.muvitul.negocio.configuracion.assembler.MotivoDevolucionAssembler;
import mx.com.tecnetia.muvitul.negocio.configuracion.assembler.PuntoVentaAssembler;
import mx.com.tecnetia.muvitul.negocio.configuracion.assembler.TipoDevolucionAssembler;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.CineVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.EstadoProductoVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.FormaPagoVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.MotivoCancelacionVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.MotivoDevolucionVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.PuntoVentaVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.TipoDevolucionVO;

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
	private CineDAOI cineDAO;
	
	public List<FormaPagoVO> getFormasPagos() throws BusinessGlobalException {
		return FormaPagoAssembler.getFormasPagosVO(formaPagoDAO.findAll());
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
}
