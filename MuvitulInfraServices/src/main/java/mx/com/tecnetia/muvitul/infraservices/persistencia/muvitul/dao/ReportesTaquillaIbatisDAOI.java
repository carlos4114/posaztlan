package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;


import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import mx.com.tecnetia.muvitul.infraservices.negocio.muvitul.vo.IngresosDiariosTaquillaVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.muvitul.vo.IngresosTaquillaVO;

public interface ReportesTaquillaIbatisDAOI {

	@Select("select "
			+ " sum(ifnull(b.cantidad,0)) as cantidad, "
			+ " sum(ifnull(b.importe,0)) as importe, "
			+ " sum(ifnull(b.importe,0))*sum(ifnull(b.cantidad,0)) as total, "
			+ " sum(ifnull(b.descuento,0)) as descuentos,"
			+ " sum(ifnull(b.cantidad_promocion,0)) as promociones"
		 + " from 	boletos_x_ticket as b "
			+ " inner join tipo_cliente as t "
			+ " on b.id_tipo_cliente = t.id_tipo_cliente"
			+ " and	date(b.fecha_exhibicion) = date(#{fecha}) "
			+ " and t.id_tipo_cliente=#{idTipoCliente}"
			+ " inner join programacion as p "
			+ " on b.id_programacion = p.id_programacion  "
			+ " and p.id_programacion=#{idProgramacion}"
			+ " inner join pelicula as pe "
			+ " on p.id_pelicula = pe.id_pelicula"
			+ " and pe.id_cine = #{idCine}")
	@Results(value = {
			@Result(property="cantidad", column="cantidad"),	
			@Result(property="importe", column="importe"),
			@Result(property="descuentos", column="descuentos"),
			@Result(property="promociones", column="promociones")
			})
	IngresosDiariosTaquillaVO getIngresosDiarios(@Param("idCine")Integer idCine,@Param("idProgramacion")Integer idProgramacion ,@Param("idTipoCliente")Integer idTipoCliente,@Param("fecha")Date fecha);

	@Select("select "
			+ " pe.titulo as titulo, "
			+ " ifnull(sum(b.importe)/sum(b.cantidad),0) as precio, "
			+ " ifnull(sum(b.cantidad),0) as cantidad, "
			+ " ifnull(sum(b.importe),0) as total,"
			+ " ifnull("
				+ " (select floor(datediff("
						+ " date_add(#{fechaInicio}, "
						+ " interval -1*DAYOFWEEK(#{fechaInicio})"
						+ " +if(DAYOFWEEK(#{fechaInicio})<=5,-1,6) day),"
						+ " date_add(min(p2.fecha_inicio), "
						+ " interval 6-if(DAYOFWEEK(min(p2.fecha_inicio))=1,8,"
						+ " DAYOFWEEK(min(p2.fecha_inicio))) day))/7)+1 "
				+ " from 	programacion p2 "
				+ " where p2.id_pelicula = pe.id_pelicula),0) as semana "
		+ " from "
			+ " boletos_x_ticket as b "
			+ " inner join programacion as p "
				+ " on b.id_programacion = p.id_programacion "
				+ " and date(b.fecha_exhibicion) between date(#{fechaInicio}) and date(#{fechaFin})"
				+ " and WEEKDAY(b.fecha_exhibicion) + 1 = #{noDiaSemana} "
			+ " right join pelicula as pe "
				+ " on p.id_pelicula = pe.id_pelicula "
			+ " where pe.id_cine = #{idCine} "
			+ " group by pe.titulo")
	@Results(value = {
			@Result(property="titulo", column="titulo"),	
			@Result(property="precio", column="precio"),
			@Result(property="cantidad", column="cantidad"),
			@Result(property="total", column="total"),
			@Result(property="semana", column="semana")
			})
	List<IngresosTaquillaVO> getIngresosSemanales(@Param("idCine")Integer idCine,@Param("noDiaSemana")Integer noDiaSemana,@Param("fechaInicio")Date fechaInicio,@Param("fechaFin")Date fechaFin);


	@Select("select "
			+ " pe.titulo, "
			+ " ifnull(sum(b.importe)/sum(b.cantidad),0) as precio, "
			+ " ifnull(sum(b.cantidad),0) as cantidad, "
			+ " ifnull(sum(b.importe),0) as total, "
			+ " ifnull("
				+ " (select floor(datediff( "
					+ " date_add(#{fechaFin}, "
					+ " interval -1*DAYOFWEEK(#{fechaFin}) "
					+ " +if(DAYOFWEEK(#{fechaFin})<=5,-1,6) day), "
					+ " date_add(min(p2.fecha_inicio), "
					+ " interval 6-if(DAYOFWEEK(min(p2.fecha_inicio))=1,8, "
					+ " DAYOFWEEK(min(p2.fecha_inicio))) day))/7)+1 "
				+ " from 	programacion p2 "
				+ " where p2.id_pelicula = pe.id_pelicula),0) as semana "
		+ " from "
			+ " boletos_x_ticket as b "
			+ " inner join programacion as p "
				+ " on b.id_programacion = p.id_programacion "
				+ " and date(b.fecha_exhibicion) "
					+ " between "
						+ " ( "
							+ " if( "
								+ " date_add(#{fechaInicio},"
								+ " interval "
								+ " (-DAYOFWEEK(#{fechaInicio})+if(DAYOFWEEK(#{fechaInicio})<=5,-1,6))+(7*(#{noSemana}-1)) "
								+ " day) < date(#{fechaInicio}), "
								+ " date(#{fechaInicio})"
								+ " , "
								+ " date_add(#{fechaInicio}, "
								+ " interval "
								+ " (-DAYOFWEEK(#{fechaInicio})+if(DAYOFWEEK(#{fechaInicio})<=5,-1,6))+(7*(#{noSemana}-1)) "
								+ " day) "
							+ " ) "
						+ " ) "
					+ " and "
						+ " ( "
							+ " if( date_add(#{fechaInicio}, "
								+ " interval "
								+ " if(DAYOFWEEK(#{fechaInicio})<=5,5,12)-DAYOFWEEK(#{fechaInicio})+(7*(#{noSemana}-1)) "
								+ " day) > date(#{fechaFin}), "
								+ " date(#{fechaFin}) "
								+ " , "
								+ " date_add(#{fechaInicio}, "
								+ " interval "
								+ " if(DAYOFWEEK(#{fechaInicio})<=5,5,12)-DAYOFWEEK(#{fechaInicio})+(7*(#{noSemana}-1)) "
								+ " day) "
							+ " ) "
						+ " ) "
			+ " right join pelicula as pe "
				+ " on p.id_pelicula = pe.id_pelicula "
			+ " where pe.id_cine = #{idCine} "
			+ " group by pe.titulo")
	@Results(value = {
			@Result(property="titulo", column="titulo"),	
			@Result(property="precio", column="precio"),
			@Result(property="cantidad", column="cantidad"),
			@Result(property="total", column="total"),
			@Result(property="semana", column="semana")
			})
	List<IngresosTaquillaVO> getIngresosMensuales(@Param("idCine")Integer idCine,@Param("noSemana")Integer noSemana,@Param("fechaInicio")Date fechaInicio,@Param("fechaFin")Date fechaFin);

}
