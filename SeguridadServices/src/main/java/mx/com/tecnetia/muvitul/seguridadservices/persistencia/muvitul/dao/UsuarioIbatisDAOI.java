package mx.com.tecnetia.muvitul.seguridadservices.persistencia.muvitul.dao;

import java.util.List;

import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Param;
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
		
	@Select("select count(u.id_usuario) as noUsuarios from "+
			 " usuario u inner join perfiles_x_usuario pxu on pxu.id_usuario=u.id_usuario "+
             " inner join recursos_x_perfil rxp on pxu.id_perfil=rxp.id_perfil "
             + " and rxp.id_recurso=#{idRecurso} "+
             " and u.correo = #{correo}")
	Integer existeRecursoParaUsuario(@Param("correo")String correo, @Param("idRecurso")Integer idRecurso);
}
