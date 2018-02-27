package mx.com.aztlan.pos.negocio.configuracion.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.AlmacenDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ArticulosXPuntoVentaDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.CanalDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ClasificacionArtDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.EstadoProductoDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.FamiliaDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.FormaPagoDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.MarcaDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.MedidaDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.MotivoCancelacionDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.MotivoDevolucionDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.PuntoVentaDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.TipoDevolucionDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.TipoProductoDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.UnidadMedidaDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Canal;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Familia;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Marca;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Medida;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TipoProducto;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.UnidadMedida;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.negocio.configuracion.assembler.AlmacenAssembler;
import mx.com.aztlan.pos.negocio.configuracion.assembler.ArticuloAssembler;
import mx.com.aztlan.pos.negocio.configuracion.assembler.ArticuloXPuntoVentaAssembler;
import mx.com.aztlan.pos.negocio.configuracion.assembler.CanalAssembler;
import mx.com.aztlan.pos.negocio.configuracion.assembler.ClasificacionArtAssembler;
import mx.com.aztlan.pos.negocio.configuracion.assembler.EstadoProductoAssembler;
import mx.com.aztlan.pos.negocio.configuracion.assembler.FormaPagoAssembler;
import mx.com.aztlan.pos.negocio.configuracion.assembler.MotivoCancelacionAssembler;
import mx.com.aztlan.pos.negocio.configuracion.assembler.MotivoDevolucionAssembler;
import mx.com.aztlan.pos.negocio.configuracion.assembler.PuntoVentaAssembler;
import mx.com.aztlan.pos.negocio.configuracion.assembler.TipoDevolucionAssembler;
import mx.com.aztlan.pos.negocio.configuracion.vo.AlmacenVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ArticuloVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ArticulosXPuntoVentaVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.CanalVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.CatalogoVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ClasificacionArtVO;
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
	private AlmacenDAOI almacenDAO;
	
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
	private CanalDAOI canalDAO;
	
	@Autowired
	private ClasificacionArtDAOI clasificacionArtDAO;
	
	@Autowired
	private UnidadMedidaDAOI unidadMedidaDAO;
	
	@Autowired
	private PuntoVentaDAOI puntoVentaDAO;
	
	@Autowired 
	private FamiliaDAOI familiaDAO;
	
	@Autowired 
	private MarcaDAOI marcaDAO;
	
	@Autowired
	TipoProductoDAOI tipoProductoDAO;
	
	@Autowired
	MedidaDAOI medidaDAO;
	
	public List<FormaPagoVO> getFormasPagos() throws BusinessGlobalException {
		return FormaPagoAssembler.getFormasPagosVO(formaPagoDAO.findAll());
	}

	public List<ArticuloVO> getArticulos(Integer idCine, Integer idPuntoVenta) throws BusinessGlobalException {
		return ArticuloAssembler.getArticulosVO(articulosXPuntoVentaDAO.findByIdCineAndIdPuntoVenta(idCine, idPuntoVenta));
	}
	
	public List<AlmacenVO> findByCanalAlmacenes(Integer idCanal) throws BusinessGlobalException  {
		return AlmacenAssembler.getAlmacenesVO(almacenDAO.findByIdCanal(idCanal));
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

	public List<CanalVO> getCanalesEmpresa(Integer idCanal) throws BusinessGlobalException {
		Canal canal= canalDAO.getById(idCanal);
		 List<CanalVO> canalesVO= CanalAssembler.getCanalesVO(canalDAO.findByEmpresa(canal.getEmpresa().getIdEmpresa()));
		for (CanalVO canalEmpresa : canalesVO) {
			if (canal.getIdCanal().equals(canalEmpresa.getIdCanal())){
				canalEmpresa.setCanalUsuario(true);
			}
		}
		return canalesVO;
	}

	public List<CanalVO> getCanales(Integer idEmpresa) throws BusinessGlobalException {
		 List<CanalVO> canalVO= CanalAssembler.getCanalesVO(canalDAO.findByEmpresa(idEmpresa));
		return canalVO;
	}
	
	public List<ClasificacionArtVO> getClasificacionesArt(Integer idCine) throws BusinessGlobalException  {
		return ClasificacionArtAssembler.getClasificacionesArt(clasificacionArtDAO.findByIdCine(idCine));
	}
	
	public List<ArticulosXPuntoVentaVO> findByArticuloPuntosVenta(Integer idArticulo) throws BusinessGlobalException  {
		return ArticuloXPuntoVentaAssembler.getArticulosXPuntosVentaVO(articulosXPuntoVentaDAO.findByIdArticulo(idArticulo));
	}

	public List<PuntoVentaVO> findByIdPuntosVenta(Integer idPuntoVenta) throws BusinessGlobalException  {
		return PuntoVentaAssembler.getPuntosVentaVO(puntoVentaDAO.findByIdPuntoVenta(idPuntoVenta));
	}
	
	@Transactional(readOnly = true)
	public List<CatalogoVO> getFamilias(Integer idEmpresa) throws BusinessGlobalException  {
		List<CatalogoVO> catalogos = new ArrayList<CatalogoVO>();
		
		List<Familia> familias = familiaDAO.findByIdEmpresa(idEmpresa);
		
		for(Familia familia : familias) {
			CatalogoVO catalogoVO = new CatalogoVO();
			catalogoVO.setId(familia.getIdFamilia());
			catalogoVO.setNombre(familia.getNombre());
			
			catalogos.add(catalogoVO);
		}
		
		return catalogos;
	}
	
	@Transactional(readOnly = true)
	public List<CatalogoVO> getMarcas(Integer idEmpresa) throws BusinessGlobalException  {
		List<CatalogoVO> catalogos = new ArrayList<CatalogoVO>();
		
		List<Marca> marcas = marcaDAO.findByIdEmpresa(idEmpresa);
		
		for(Marca marca: marcas) {
			CatalogoVO catalogoVO = new CatalogoVO();
			catalogoVO.setId(marca.getIdMarca());
			catalogoVO.setNombre(marca.getNombre());

			catalogos.add(catalogoVO);
		}
		
		return catalogos;
	}
	
	@Transactional(readOnly = true)
	public List<CatalogoVO> getTipos(Integer idEmpresa) throws BusinessGlobalException  {
		List<CatalogoVO> catalogos = new ArrayList<CatalogoVO>();
		
		List<TipoProducto> tipos = tipoProductoDAO.findByIdEmpresa(idEmpresa);
		
		for(TipoProducto tipo: tipos) {
			CatalogoVO catalogoVO = new CatalogoVO();
			catalogoVO.setId(tipo.getIdTipoProducto());
			catalogoVO.setNombre(tipo.getNombre());

			catalogos.add(catalogoVO);
		}
		
		return catalogos;
	}
	
	@Transactional(readOnly = true)
	public List<CatalogoVO> getMedidas(Integer idEmpresa) throws BusinessGlobalException  {
		List<CatalogoVO> catalogos = new ArrayList<CatalogoVO>();
		
		List<Medida> medidas = medidaDAO.findByIdEmpresa(idEmpresa);
		
		for(Medida medida: medidas) {
			CatalogoVO catalogoVO = new CatalogoVO();
			catalogoVO.setId(medida.getIdMedida());
			catalogoVO.setNombre(medida.getNombre());

			catalogos.add(catalogoVO);
		}
		
		return catalogos;
	}
	
	@Transactional(readOnly = true)
	public List<CatalogoVO> getUnidadesMedida(Integer idEmpresa) throws BusinessGlobalException  {
		List<CatalogoVO> catalogos = new ArrayList<CatalogoVO>();
		
		List<UnidadMedida> unidadesM = unidadMedidaDAO.findByIdEmpresa(idEmpresa);
		
		for(UnidadMedida unidad: unidadesM) {
			CatalogoVO catalogoVO = new CatalogoVO();
			catalogoVO.setId(unidad.getIdUnidadMedida());
			catalogoVO.setNombre(unidad.getNombre());

			catalogos.add(catalogoVO);
		}
		
		return catalogos;
	}
}
