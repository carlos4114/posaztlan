package mx.com.aztlan.pos.negocio.devolucion.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Paquete;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PaquetesXPuntoVenta;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Producto;
import mx.com.aztlan.pos.negocio.devolucion.vo.PaqueteVO;

public class PaqueteAssembler {

	
	public static PaqueteVO getPaqueteVO(Paquete paquete){

		if(paquete==null )
			return null;
		
		PaqueteVO paqueteVO = new PaqueteVO();
		paqueteVO.setIdPaquete(paquete.getIdPaquete());
		paqueteVO.setPaquete(true);
		paqueteVO.setCineVO(CineAssembler.getCineVO(paquete.getCine()));
		paqueteVO.setNombre(paquete.getNombre());
		paqueteVO.setIcono(paquete.getIcono());
		paqueteVO.setActivo(paquete.isActivo());
		paqueteVO.setPrecio(paquete.getPrecio());
		paqueteVO.setProductosXPaqueteVO(ProductoXPaqueteAssembler.getProductoXPaqueteVO(paquete.getProductosXPaquetes()));
		//paqueteVO.setPreciosXPaqueteVO(PrecioXPaqueteAssembler.getPreciosXPaqueteVO(paquete.getPrecioXPaquetes()));

		return paqueteVO;
	}
	
	
	public static List<PaqueteVO> getPaquetesVO(List<PaquetesXPuntoVenta> paquetesXPuntoVenta){

		if(paquetesXPuntoVenta==null || paquetesXPuntoVenta.isEmpty())
			return null;
		
		List<PaqueteVO> paquetesVO = new ArrayList<PaqueteVO>();
		
		for (PaquetesXPuntoVenta paqueteXPuntoVenta : paquetesXPuntoVenta) {
			paquetesVO.add(PaqueteAssembler.getPaqueteVO(paqueteXPuntoVenta.getPaquete()));
		}

		return paquetesVO;
	}
	
	
	public static Paquete getPaquete(Integer idPaquete){

		if(idPaquete==null )
			return null;
		
		Paquete paquete = new Paquete();
		paquete.setIdPaquete(idPaquete);

		return paquete;
	}


	public static PaqueteVO getPaqueteProductoVO(Producto producto) {

		if(producto==null )
			return null;
		
		PaqueteVO paqueteVO = new PaqueteVO();
		paqueteVO.setIdPaquete(producto.getIdProducto());
		paqueteVO.setCineVO(CineAssembler.getCineVO(producto.getCine()));
		paqueteVO.setNombre(producto.getNombre());
		paqueteVO.setIcono(producto.getIcono());
		paqueteVO.setActivo(producto.isActivo());
		paqueteVO.setPrecio(producto.getPrecio());
		paqueteVO.setProductosXPaqueteVO(ProductoXPaqueteAssembler.getProductosXPaqueteVO(producto));
		//paqueteVO.setPreciosXPaqueteVO(PrecioXPaqueteAssembler.getPreciosXPaqueteVO(paquete.getPrecioXPaquetes()));

		return paqueteVO;
	}
	
	
}
