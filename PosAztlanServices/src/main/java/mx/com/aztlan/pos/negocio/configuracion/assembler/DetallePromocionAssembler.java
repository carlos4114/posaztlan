package mx.com.aztlan.pos.negocio.configuracion.assembler;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.DetallePromocion;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Producto;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Regalo;
import mx.com.aztlan.pos.negocio.configuracion.vo.DetallePromocionVO;

public class DetallePromocionAssembler {

	public static DetallePromocionVO getDetallePromocionVO(DetallePromocion detallePromocion){

		if(detallePromocion==null )
			return null;
		
		DetallePromocionVO detallePromocionVO = new DetallePromocionVO();
		detallePromocionVO.setIdDetallePromocion(detallePromocion.getIdDetallePromocion());
		detallePromocionVO.setProductoVO(ProductoAssembler.getProductoVO(detallePromocion.getProducto()));
		detallePromocionVO.setRegaloVO(RegaloAssembler.getRegaloVO(detallePromocion.getRegalo()));
		detallePromocionVO.setVarN(detallePromocion.getVarN());
		detallePromocionVO.setVarM(detallePromocion.getVarM());
		detallePromocionVO.setPrecio(detallePromocion.getPrecio());
		detallePromocionVO.setPorcentaje(detallePromocion.getPorcentaje());
		
		return detallePromocionVO;
	}
	
	
//	public static List<DetallePromocionVO> getDetallePromocionesVO(Set<DetallePromoXPromo> detallesPromoXPromo){
//
//		if(detallesPromoXPromo==null || detallesPromoXPromo.isEmpty())
//			return null;
//		
//		List<DetallePromocionVO> detallePromocionesVO = new ArrayList<DetallePromocionVO>();
//		
//		for (DetallePromoXPromo detallePromoXPromo : detallesPromoXPromo) {
//			detallePromocionesVO.add(DetallePromocionAssembler.getDetallePromocionVO(detallePromoXPromo.getDetallePromocion()));
//		}
//
//		return detallePromocionesVO;
//	}
//	

	public static DetallePromocion getDetallePromocion(DetallePromocionVO detallePromocionVO){

		if(detallePromocionVO==null )
			return null;
		
		DetallePromocion detallePromocion = new DetallePromocion();
		Producto producto=(detallePromocionVO.getProductoVO()!=null)?ProductoAssembler.getProducto(detallePromocionVO.getProductoVO().getIdProducto()):null;
		Regalo regalo=(detallePromocionVO.getRegaloVO()!=null)?RegaloAssembler.getRegalo(detallePromocionVO.getRegaloVO().getIdRegalo()):null;
		detallePromocion.setProducto(producto);
		detallePromocion.setRegalo(regalo);
		detallePromocion.setVarN(detallePromocionVO.getVarN());
		detallePromocion.setVarM(detallePromocionVO.getVarM());
		detallePromocion.setPrecio(detallePromocionVO.getPrecio());
		detallePromocion.setPorcentaje(detallePromocionVO.getPorcentaje());
		
		return detallePromocion;
	}
	
	
	public static Set<DetallePromocion> getDetallePromociones(List<DetallePromocionVO> detallePromocionesVO){

		if(detallePromocionesVO==null || detallePromocionesVO.isEmpty())
			return null;
		
		Set<DetallePromocion> detallePromociones = new HashSet<DetallePromocion>();
		
		for (DetallePromocionVO detallePromocionVO : detallePromocionesVO) {
			detallePromociones.add(DetallePromocionAssembler.getDetallePromocion(detallePromocionVO));
		}

		return detallePromociones;
	}
	
	
}
