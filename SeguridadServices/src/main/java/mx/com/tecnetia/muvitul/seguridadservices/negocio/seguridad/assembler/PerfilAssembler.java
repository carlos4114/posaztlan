package mx.com.tecnetia.muvitul.seguridadservices.negocio.seguridad.assembler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.PerfilVO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Perfil;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PerfilesXUsuario;

public class PerfilAssembler {

	public static List<PerfilVO> getPerfilesVO(Set<PerfilesXUsuario> perfilesXUsuario) {

		if(perfilesXUsuario==null)
			return null;

		List<PerfilVO> perfilesVO = new ArrayList<PerfilVO>();
		for(PerfilesXUsuario perfilXUsuario : perfilesXUsuario){
			perfilesVO.add(getPerfilVO(perfilXUsuario.getPerfil()));
		}
		
		return perfilesVO;
	}
	
	public static List<Integer> getPerfilesId(Set<PerfilesXUsuario> perfilesXUsuario) {

		if(perfilesXUsuario==null)
			return null;

		List<Integer> perfilesInt = new ArrayList<Integer>();
		for(PerfilesXUsuario perfileXUsuario : perfilesXUsuario){
			perfilesInt.add(perfileXUsuario.getPerfil().getIdPerfil());
		}
		
		return perfilesInt;
	}
	


	public static PerfilVO getPerfilVO(Perfil perfil) {

		if(perfil==null)
			return null;

		PerfilVO perfilVO =  new PerfilVO();

		perfilVO.setIdPerfil(perfil.getIdPerfil());
		perfilVO.setNombre(perfil.getNombre()==null?"":perfil.getNombre());

		return perfilVO;
	}

}
