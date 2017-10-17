package mx.com.tecnetia.muvitul.negocio.configuracion.assembler;

import java.util.Date;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Autorizacion;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.EstatusAutorizacionVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.RequestAutorizacionVO;

public class AutorizacionAssembler {
	
	public static EstatusAutorizacionVO getEstatusAutorizacionVO(int status, String descripcion, Integer idAutorizacion){
		
		if(descripcion==null)
			return null;
		
		EstatusAutorizacionVO estatusAutorizacionVO = new EstatusAutorizacionVO();
		estatusAutorizacionVO.setIdAutorizacion(idAutorizacion);
		estatusAutorizacionVO.setStatus(status);
		estatusAutorizacionVO.setDescripcion(descripcion);
		return estatusAutorizacionVO;
		
	}
	
	public static Autorizacion getAutorizacion(Integer idUsuario, RequestAutorizacionVO requestAutorizacionVO){
		
		if(requestAutorizacionVO ==null || idUsuario==null )
			return null;
		
		Autorizacion autorizacion = new Autorizacion();
		autorizacion.setTipoAutorizacion(TipoAutorizacionAssembler.getTipoAutorizacion(requestAutorizacionVO.getIdTipoAutorizacion()));
		autorizacion.setUsuario(UsuarioAssembler.getUsuario(idUsuario));
		autorizacion.setFecha(new Date());
		autorizacion.setComentarios(requestAutorizacionVO.getComentarios());
		
		return autorizacion;
		
	}
	
}
