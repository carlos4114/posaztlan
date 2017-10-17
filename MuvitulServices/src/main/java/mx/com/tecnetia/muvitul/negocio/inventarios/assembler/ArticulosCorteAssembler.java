package mx.com.tecnetia.muvitul.negocio.inventarios.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ArticulosCorte;
import mx.com.tecnetia.muvitul.negocio.devolucion.assembler.ArticuloAssembler;
import mx.com.tecnetia.muvitul.negocio.dulceria.assembler.MovimientoInventarioAssembler;
import mx.com.tecnetia.muvitul.negocio.dulceria.assembler.PuntoVentaAssembler;
import mx.com.tecnetia.muvitul.negocio.dulceria.assembler.UsuarioAssembler;
import mx.com.tecnetia.muvitul.negocio.inventarios.vo.ArticulosCorteVO;

public class ArticulosCorteAssembler {

	public static ArticulosCorte getArticulosCorte(Integer idArticuloCorte){

		if(idArticuloCorte==null )
			return null;

		ArticulosCorte articulosCorte= new ArticulosCorte();
		articulosCorte.setIdArticuloCorte(idArticuloCorte);
		
		return articulosCorte;
	}
	
	public static ArticulosCorte getArticulosCorte(ArticulosCorteVO articulosCorteVO){

		if(articulosCorteVO==null )
			return null;

		ArticulosCorte articulosCorte= new ArticulosCorte();
		articulosCorte.setIdArticuloCorte(articulosCorteVO.getIdArticuloCorte());
		articulosCorte.setArticulo(ArticuloAssembler.getArticulo(articulosCorteVO.getArticulo().getIdArticulo()));
		articulosCorte.setUsuario(UsuarioAssembler.getUsuario(articulosCorteVO.getUsuario().getIdUsuario()));
		articulosCorte.setExistenciaFisica(articulosCorteVO.getExistenciaFisica());
		articulosCorte.setExistenciaSistema(articulosCorteVO.getExistenciaSistema());
		articulosCorte.setEstatusConteo(articulosCorteVO.getEstatusConteo());
		articulosCorte.setFecha(articulosCorteVO.getFecha());
		articulosCorte.setUltimaModificacion(articulosCorteVO.getUltimaModificacion());
		articulosCorte.setUsuarioModificacion(UsuarioAssembler.getUsuario(articulosCorteVO.getUsuario().getIdUsuario()));
		articulosCorte.setPuntoVenta(PuntoVentaAssembler.getPuntoVenta(articulosCorteVO.getPuntoVenta().getIdPuntoVenta()));
		
		return articulosCorte;
	}
	
	public static ArticulosCorteVO getArticulosCorteVO(ArticulosCorte articulosCorte) {
		if(articulosCorte == null )
			return null;
		
		ArticulosCorteVO articulosCorteVO = new ArticulosCorteVO();
		
		articulosCorteVO.setIdArticuloCorte(articulosCorte.getIdArticuloCorte());
		articulosCorteVO.setArticulo(ArticuloAssembler.getArticuloVO(articulosCorte.getArticulo()));
		articulosCorteVO.setUsuario(UsuarioAssembler.getUsuarioVO(articulosCorte.getUsuario().getIdUsuario()));
		articulosCorteVO.setExistenciaFisica(articulosCorte.getExistenciaFisica());
		articulosCorteVO.setExistenciaSistema(articulosCorte.getExistenciaSistema());
		articulosCorteVO.setEstatusConteo(articulosCorte.getEstatusConteo());
		articulosCorteVO.setFecha(articulosCorte.getFecha());
		articulosCorteVO.setUltimaModificacion(articulosCorte.getUltimaModificacion());
		articulosCorteVO.setUsuarioModificacion(UsuarioAssembler.getUsuarioVO(articulosCorteVO.getUsuario().getIdUsuario()));
		articulosCorteVO.setPuntoVenta(PuntoVentaAssembler.getPuntoVentaVO(articulosCorte.getPuntoVenta()));
		
		return articulosCorteVO;
	}
	
	public static List<ArticulosCorteVO> getArticulosCorteVO(List<ArticulosCorte> articulosCortes){

		if(articulosCortes==null || articulosCortes.isEmpty())
			return null;
		
		List<ArticulosCorteVO> articulosCortesVO = new ArrayList<ArticulosCorteVO>();
		
		for (ArticulosCorte articulosCorte : articulosCortes) {
			articulosCortesVO.add(ArticulosCorteAssembler.getArticulosCorteVO(articulosCorte));
		}

		return articulosCortesVO;
	}	

}
