package mx.com.aztlan.pos.negocio.inventarios.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Autorizacion;
import mx.com.aztlan.pos.negocio.inventarios.vo.AutorizacionVO;

public class AutorizacionAssembler {

	public static Autorizacion getAutorizacion(Integer idAutorizacion){

		if(idAutorizacion==null )
			return null;

		Autorizacion autorizacion= new Autorizacion();
		autorizacion.setIdAutorizacion(idAutorizacion);
		
		return autorizacion;
	}
	
	public static AutorizacionVO getAutorizacionVO(Autorizacion autorizacion) {
		if(autorizacion == null )
			return null;
		
		AutorizacionVO autorizacionVO = new AutorizacionVO();
		autorizacionVO.setIdAutorizacionMovimiento(autorizacion.getIdAutorizacion());
		autorizacionVO.setUsuario(autorizacion.getUsuario());
		autorizacionVO.setFecha(autorizacion.getFecha());
		autorizacionVO.setComentarios(autorizacion.getComentarios());	
		
		return autorizacionVO;
	}
	
	public static List<AutorizacionVO> getProveedoresVO(List<Autorizacion> autorizaciones){

		if(autorizaciones==null || autorizaciones.isEmpty())
			return null;
		
		List<AutorizacionVO> autorizacionesVO = new ArrayList<AutorizacionVO>();
		
		for (Autorizacion autorizacion : autorizaciones) {
			autorizacionesVO.add(AutorizacionAssembler.getAutorizacionVO(autorizacion));
		}

		return autorizacionesVO;
	}	
	
}
