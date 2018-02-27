package mx.com.aztlan.pos.negocio.configuracion.assembler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Articulo;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ArticulosXPuntoVenta;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ArticulosXPuntoVentaId;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Cine;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ClasificacionArt;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PuntoVenta;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.UnidadMedida;
import mx.com.aztlan.pos.negocio.configuracion.vo.ArticuloVO;

public class ArticuloAssembler {

	public static ArticuloVO getArticuloVO(ArticulosXPuntoVenta articuloXPuntoVenta){
		
		if(articuloXPuntoVenta==null)
			return null;
		
		ArticuloVO articuloVO = new ArticuloVO();
		articuloVO.setIdArticulo(articuloXPuntoVenta.getArticulo().getIdArticulo());
		articuloVO.setCineVO(CineAssembler.getCineVO(articuloXPuntoVenta.getArticulo().getCine()));
		articuloVO.setClasificacionArtVO(ClasificacionArtAssembler.getClasificacionArtVO(articuloXPuntoVenta.getArticulo().getClasificacionArt()));
		articuloVO.setUnidadMedidaVO(UnidadMedidaAssembler.getUnidadMedidaVO(articuloXPuntoVenta.getArticulo().getUnidadMedida()));
		articuloVO.setNombre(articuloXPuntoVenta.getArticulo().getNombre());
		articuloVO.setActivo(articuloXPuntoVenta.getArticulo().isActivo());
		articuloVO.setPuntoReorden(articuloXPuntoVenta.getArticulo().getPuntoReorden());
		
		return articuloVO;
	}
	

	
	public static List<ArticuloVO> getArticulosVO(List<ArticulosXPuntoVenta> articulosXPuntoVenta){
		
		if(articulosXPuntoVenta==null || articulosXPuntoVenta.isEmpty())
			return null;
		
		List<ArticuloVO> articulosVO = new ArrayList<ArticuloVO>();
		
		for (ArticulosXPuntoVenta articuloXPuntoVenta : articulosXPuntoVenta) {
			articulosVO.add(ArticuloAssembler.getArticuloVO(articuloXPuntoVenta));
		}

		return articulosVO;
		
	}
	
	public static List<Integer> getPuntosVentaList(Set<ArticulosXPuntoVenta> articulosPVList) {
		List<Integer> puntosVenta = new ArrayList<Integer>();
		
		for(ArticulosXPuntoVenta puntoVenta : articulosPVList){
			puntosVenta.add(puntoVenta.getPuntoVenta().getIdPuntoVenta());
		}
		
		return puntosVenta;
	}
	
	public static ArticuloVO getArticulo(Articulo articulo) {
		if(articulo == null )
			return null;
		
		ArticuloVO articuloVO = new ArticuloVO();
		articuloVO.setIdArticulo(articulo.getIdArticulo());
		articuloVO.setNombre(articulo.getNombre());
		articuloVO.setUnidadMedidaVO(UnidadMedidaAssembler.getUnidadMedidaVO(articulo.getUnidadMedida()));
		articuloVO.setPuntoReorden(articulo.getPuntoReorden());
		articuloVO.setActivo(articulo.isActivo());
		articuloVO.setCineVO(CineAssembler.getCineVO(articulo.getCine()));
		articuloVO.setClasificacionArtVO(ClasificacionArtAssembler.getClasificacionArtVO(articulo.getClasificacionArt()));
		articuloVO.setPuntosVentaList(getPuntosVentaList(articulo.getArticulosXPuntoVentas()));
		articuloVO.setIdClasificacionArt(articulo.getClasificacionArt().getIdClasificacionArt());
		articuloVO.setIdUnidadMedida(articulo.getUnidadMedida().getIdUnidadMedida());
		articuloVO.setIdCine(CineAssembler.getCineVO(articulo.getCine()).getIdCine());
		return articuloVO;
	}
	
	public static Set<ArticulosXPuntoVenta> getPuntosVentaArticulo(List<Integer> puntosVenta, Articulo articulo) {
		Set<ArticulosXPuntoVenta> listaPuntosVenta = new HashSet<ArticulosXPuntoVenta>();
		for(Integer idPuntoVenta:puntosVenta){
			ArticulosXPuntoVenta articuloPV = new ArticulosXPuntoVenta(
					new ArticulosXPuntoVentaId(idPuntoVenta,articulo.getIdArticulo())
					,articulo,
					new PuntoVenta(idPuntoVenta)
					);
			listaPuntosVenta.add(articuloPV);
		}
		
		return listaPuntosVenta;
	}

	public static Articulo getArticulo(ArticuloVO articuloVO) {

		if(articuloVO==null)
			return null;

		Articulo articulo = new Articulo();
		articulo.setIdArticulo(articuloVO.getIdArticulo());
		articulo.setNombre(articuloVO.getNombre());
		articulo.setUnidadMedida(new UnidadMedida(articuloVO.getIdUnidadMedida()));
		articulo.setActivo(articuloVO.isActivo());
		articulo.setCine(new Cine(articuloVO.getIdCine()));
		articulo.setClasificacionArt(new ClasificacionArt(articuloVO.getIdClasificacionArt()));
		articulo.setPuntoReorden(articuloVO.getPuntoReorden());
		
		
		return articulo;
	}
	
	
	public static Articulo getArticulo(ArticuloVO articuloVO, Articulo articulo) {

		if(articuloVO==null)
			return null;

		articulo.setNombre(articuloVO.getNombre());
		articulo.setUnidadMedida(new UnidadMedida(articuloVO.getIdUnidadMedida()));
		articulo.setActivo(articuloVO.isActivo());
		articulo.setCine(new Cine(articuloVO.getCineVO().getIdCine()));
		articulo.setClasificacionArt(new ClasificacionArt(articuloVO.getIdClasificacionArt()));
		articulo.setPuntoReorden(articuloVO.getPuntoReorden());
		
		
		return articulo;
	}
	
	public static List<ArticuloVO> getArticulos(List<Articulo> articulos){

		if(articulos==null || articulos.isEmpty())
			return null;
		
		List<ArticuloVO> articuloVO = new ArrayList<ArticuloVO>();
		
		for (Articulo articulo : articulos) {
			articuloVO.add(ArticuloAssembler.getArticulo(articulo));
		}

		return articuloVO;
	}
	
}
