package mx.com.aztlan.pos.negocio.taquilla.assembler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.DetallePromoXPromo;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.DetallePromocion;
import mx.com.aztlan.pos.negocio.taquilla.vo.DetallePromocionVO;

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
		detallePromocion.setPorcentaje(detallePromocion.getPorcentaje());
		
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
	
}
