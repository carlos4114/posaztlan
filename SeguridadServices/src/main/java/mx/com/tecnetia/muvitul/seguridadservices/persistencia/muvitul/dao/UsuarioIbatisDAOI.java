package mx.com.tecnetia.muvitul.seguridadservices.persistencia.muvitul.dao;

import java.util.List;

import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Usuario;

public interface UsuarioIbatisDAOI {
	
	
	
	@Select("SELECT * FROM usuario order by nombre")	
	@Results(value = {
	@Result(property="correo", column="CORREO"),	
	@Result(property="contrasenia", column="CONTRASENIA")
	})
	List<Usuario> obtenerListaUsuarios();
		
}
