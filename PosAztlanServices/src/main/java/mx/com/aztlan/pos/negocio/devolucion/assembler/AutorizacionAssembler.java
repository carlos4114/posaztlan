package mx.com.aztlan.pos.negocio.devolucion.assembler;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Autorizacion;
import mx.com.aztlan.pos.negocio.devolucion.vo.AutorizacionVO;

public class AutorizacionAssembler {
	
	public static Autorizacion getAutorizacion(Integer idAutorizacion){

		if(idAutorizacion==null)
			return null;
		
		Autorizacion autorizacion = new Autorizacion();
		autorizacion.setIdAutorizacion(idAutorizacion);
		
		return autorizacion;
	}
	
	public static AutorizacionVO getAutorizacionVO(Autorizacion autorizacion){

		if(autorizacion==null)
			return null;
		
		AutorizacionVO autorizacionVO = new AutorizacionVO();
		autorizacionVO.setIdAutorizacion(autorizacion.getIdAutorizacion());
		autorizacionVO.setTipoAutorizacionVO(TipoAutorizacionAssembler.getTipoAutorizacionVO(autorizacion.getTipoAutorizacion()));
		autorizacionVO.setUsuarioVO(UsuarioAssembler.getUsuarioVO(autorizacion.getUsuario().getIdUsuario()));
		autorizacionVO.setFecha(autorizacion.getFecha());
		autorizacionVO.setComentarios(autorizacion.getComentarios());
		
		return autorizacionVO;
	}
	
}