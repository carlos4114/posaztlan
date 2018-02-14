package mx.com.aztlan.pos.seguridadservices.persistencia.posaztlanbd.dao;

import org.apache.ibatis.annotations.Results;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.MenuVO;

public interface MenuIbatisDAOI {
		
	@Select("select distinct m.* from "+
    		  " Menu m inner join Recursos_x_perfil rxp on rxp.id_recurso=m.id_recurso "+
    			" inner join Perfiles_x_usuario pxu on pxu.id_perfil=rxp.id_perfil "+
    			" inner join Usuario u on u.id_usuario=pxu.id_usuario "+
    			" where "+ 
    			" u.correo=#{correo} and "+
    			" m.id_recurso_padre is null "+
    			" order by m.id_Menu ")
	@Results(value = {
	@Result(property="idMenu", column="id_menu"),	
	@Result(property="idRecurso", column="id_recurso"),
	@Result(property="idRecursoPadre", column="id_recurso_padre"),
	@Result(property="icono", column="icono")
	})
	List<MenuVO> getMenuForUsuario(@Param("correo")String correo);
		
}
