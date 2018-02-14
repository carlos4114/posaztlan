package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ArticuloIbatisDAOI {

	@Select("select concat('<li>',a.nombre,' - Existencia: ',sum(i.existencia_actual),' ',u.nombre,'</li>') as articulo "
			+ " from articulo a "
			+ " inner join unidad_medida u on u.id_unidad_medida=a.id_unidad_medida "
			+ "       and a.id_cine=#{idCine} and a.activo=1 "
			+ " inner join inventario i on i.id_articulo=a.id_articulo "
			+ " group by a.id_articulo,a.nombre,u.nombre,punto_reorden "
			+ " having sum(i.existencia_actual)<=punto_reorden"
			+ " order by a.nombre")
	List<String> obtenerArticulosParaPuntoReorden(@Param("idCine")Integer idCine);
}
