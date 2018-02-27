package mx.com.aztlan.pos.negocio.configuracion.assembler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Paquete;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PaquetesXPuntoVenta;
import mx.com.aztlan.pos.negocio.configuracion.vo.PaqueteVO;

public class PaqueteAssembler {

	public static PaqueteVO getPaqueteVO(Paquete paquete){
		
		if(paquete==null)
			return null;
		
		PaqueteVO paqueteVO = new PaqueteVO();
		paqueteVO.setIdPaquete(paquete.getIdPaquete());
		paqueteVO.setCineVO(CineAssembler.getCineVO(paquete.getCine()));
		paqueteVO.setNombre(paquete.getNombre());
		paqueteVO.setIcono(paquete.getIcono());
		paqueteVO.setActivo(paquete.isActivo());
		paquete.setPrecio(paqueteVO.getPrecio());
		paqueteVO.setProductosXPaqueteVO(ProductoXPaqueteAssembler.getProductosXPaqueteVO(paquete.getProductosXPaquetes()));
		paqueteVO.setPuntosVentaList(getPuntosVentaList(paquete.getPaquetesXPuntoVentas()));
		
		return paqueteVO;
	}
	
	public static List<PaqueteVO> getPaquetes(List<Paquete> paquetes){

		if(paquetes==null)
			return null;
		
		List<PaqueteVO> paquetesVO = new ArrayList<PaqueteVO>();
		
		for (Paquete paquete : paquetes) {
			paquetesVO.add(PaqueteAssembler.getPaqueteVO(paquete));
		}

		return paquetesVO;
	}

	public static Paquete getPaquete(PaqueteVO paqueteVO) {
		
		if(paqueteVO==null)
			return null;
		
		Paquete paquete = new Paquete();
		paquete.setIdPaquete(paqueteVO.getIdPaquete());
		paquete.setCine(CineAssembler.getCine(paqueteVO.getCineVO().getIdCine()));
		paquete.setNombre(paqueteVO.getNombre());
		paquete.setIcono(paqueteVO.getIcono());
		paquete.setPrecio(paqueteVO.getPrecio());
		paquete.setActivo(paqueteVO.isActivo());

		return paquete;
	}

	public static List<Integer> getPuntosVentaList(Set<PaquetesXPuntoVenta> paquetesPVList) {
		List<Integer> puntosVenta = new ArrayList<Integer>();
		
		for(PaquetesXPuntoVenta puntoVenta : paquetesPVList){
			puntosVenta.add(puntoVenta.getPuntoVenta().getIdPuntoVenta());
		}
		
		return puntosVenta;
	}
	
}