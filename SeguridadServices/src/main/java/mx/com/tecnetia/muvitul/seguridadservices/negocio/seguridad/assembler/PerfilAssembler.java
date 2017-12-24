package mx.com.tecnetia.muvitul.seguridadservices.negocio.seguridad.assembler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.PerfilVO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Perfil;

public class PerfilAssembler {


	public static List<PerfilVO> getPerfilesVO(Set<Perfil> perfiles) {

		if(perfiles==null)
			return null;

		List<PerfilVO> perfilesVO = new ArrayList<PerfilVO>();
		for(Perfil perfil : perfiles){
			perfilesVO.add(getPerfilVO(perfil));
		}
		
		return perfilesVO;
	}
	
	public static List<Integer> getPerfilesId(Set<Perfil> perfiles) {

		if(perfiles==null)
			return null;

		List<Integer> perfilesInt = new ArrayList<Integer>();
		for(Perfil perfil : perfiles){
			perfilesInt.add(perfil.getIdPerfil());
		}
		
		return perfilesInt;
	}
	
	public static List<PerfilVO> getPerfilesVO(List<Perfil> perfiles) {

		if(perfiles==null)
			return null;

		List<PerfilVO> perfilesVO = new ArrayList<PerfilVO>();
		for(Perfil perfil : perfiles){
			perfilesVO.add(getPerfilVO(perfil));
		}
		
		return perfilesVO;
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
