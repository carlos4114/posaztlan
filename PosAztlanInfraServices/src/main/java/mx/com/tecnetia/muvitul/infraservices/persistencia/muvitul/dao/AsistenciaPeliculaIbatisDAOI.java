package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;


import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import mx.com.tecnetia.muvitul.infraservices.negocio.muvitul.vo.AsistenciaVO;

public interface AsistenciaPeliculaIbatisDAOI {

	@Select("select "
			+ "	asie.id_asientos_x_sala,asie.existente,asie.fila,asie.posicion,asie.numero_asiento,asis.id_estatus_asiento,asis.id_usuario "
			+ " from asientos_x_sala asie "
			+ " left join asistencia_x_sala asis on asis.id_asientos_x_sala=asie.id_asientos_x_sala "
			+ "			and asis.id_programacion=#{idProgramacion} "
			+ "			and asis.fecha_exhibicion=#{fechaExhibicion} "
			+ " inner join programacion p on p.id_programacion=#{idProgramacion} "
			+ "			and asie.id_sala=p.id_sala "
			+ "	where "
			+ "	asie.activo=1 "			
			+ " order by asie.fila, asie.posicion ")
	@Results(value = {
			@Result(property="idAsiento", column="id_asientos_x_sala"),	
			@Result(property="existente", column="existente"),
			@Result(property="fila", column="fila"),
			@Result(property="posicion", column="posicion"),
			@Result(property="numeroAsiento", column="numero_asiento"),
			@Result(property="idEstatusAsiento", column="id_estatus_asiento"),
			@Result(property="idUsuario", column="id_usuario")			
			})
	List<AsistenciaVO> getAsistencia(@Param("idProgramacion")Integer idProgramacion,@Param("fechaExhibicion")Date fechaExhibicion);


}
