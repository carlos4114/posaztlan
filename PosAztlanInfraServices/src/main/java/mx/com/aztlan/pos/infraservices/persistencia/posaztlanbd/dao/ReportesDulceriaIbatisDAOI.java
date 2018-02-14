package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;


import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import mx.com.aztlan.pos.infraservices.negocio.posaztlanbd.vo.IngresosDulceriaVO;

public interface ReportesDulceriaIbatisDAOI {

	@Select("select "+	      
				  " pv.nombre as punto_venta, "+
				  " p.nombre as producto, "+
				  " p.precio,  "+
				  " ifnull(sum(pt.cantidad),0) as cantidad, "+
				  " ifnull(sum(pt.importe),0) as total, "+
			      " '1'  as es_producto "+
			" from producto as p "+
			  	 " inner join productos_x_ticket as pt "+
				   " on p.id_producto = pt.id_producto "+
				 " inner join ticket_venta as t "+
					" on t.id_ticket = pt.id_ticket "+
				  " inner join punto_venta as pv "+
				   " on pv.id_punto_venta = t.id_punto_venta "+
		   " where "+
				 " pv.id_cine = #{idCine} and "+
			      " date(t.fecha) between date(#{fechaInicio}) and date(#{fechaFin}) and "+
			     " WEEKDAY(t.fecha) + 1 = #{noDiaSemana} "+
		   " group by "+
			     " pv.nombre, "+
			     " p.nombre, "+
			  	 " p.precio "+
			" union "+
			" select "+	  	
				 " pv.nombre as punto_venta, "+ 
				 " p.nombre as producto, "+
				 " p.precio, "+
				 " ifnull(sum(pt.cantidad),0) as cantidad, "+ 
				 " ifnull(sum(pt.importe),0) as total, "+
			     " '0'  as es_producto "+
			" from paquete as p "+
			  	 " inner join paquetes_x_ticket as pt "+
					" on p.id_paquete = pt.id_paquete "+
				 " inner join ticket_venta as t "+
					" on t.id_ticket = pt.id_ticket "+
				 " inner join punto_venta as pv "+
					" on pv.id_punto_venta = t.id_punto_venta "+
			" where "+
			 	 " pv.id_cine = #{idCine} and "+
				 " date(t.fecha) between date(#{fechaInicio}) and date(#{fechaFin}) "+
			     " and "+
			     " WEEKDAY(t.fecha) + 1 = #{noDiaSemana} "+
		  " group by "+	 
				  " pv.nombre, "+
			      " p.nombre, "+
			  	  " p.precio")
	@Results(value = {
			@Result(property="puntoVenta", column="punto_venta"),	
			@Result(property="producto", column="producto"),
			@Result(property="precio", column="precio"),
			@Result(property="cantidad", column="cantidad"),
			@Result(property="total", column="total")		
			})
	List<IngresosDulceriaVO> getIngresosSemanales(@Param("idCine")Integer idCine,@Param("noDiaSemana")Integer noDiaSemana,@Param("fechaInicio")Date fechaInicio,@Param("fechaFin")Date fechaFin);


	@Select("select "+	     
				  " pv.nombre as punto_venta, "+
				  " p.nombre as producto, "+
				  " p.precio,  "+
				  " ifnull(sum(pt.cantidad),0) as cantidad, "+
				  " ifnull(sum(pt.importe),0) as total, "+
			      " '1'  as es_producto "+
			" from 	  producto as p "+
			  	  " inner join productos_x_ticket as pt "+
					" on p.id_producto = pt.id_producto "+
				  " inner join ticket_venta as t "+
					" on t.id_ticket = pt.id_ticket "+
			        " and date(t.fecha) "+
					   " between "+
						" ( "+
							" if( "+
								" date_add(#{fechaInicio}, "+
											" interval "+
											  " (-DAYOFWEEK(#{fechaInicio})+if(DAYOFWEEK(#{fechaInicio})<=5,-1,6))+(7*(#{noSemana}-1)) "+
											" day) < date(#{fechaInicio}), "+
								  " date(#{fechaInicio}) "+         
								 " , "+
								 " date_add(#{fechaInicio}, "+
											" interval "+ 
											  " (-DAYOFWEEK(#{fechaInicio})+if(DAYOFWEEK(#{fechaInicio})<=5,-1,6))+(7*(#{noSemana}-1)) "+
											" day) "+
							" ) "+
						 " ) "+
					   " and "+
						 " ( "+
							 " if( date_add(#{fechaInicio}, "+ 
										" interval "+
										  " if(DAYOFWEEK(#{fechaInicio})<=5,5,12)-DAYOFWEEK(#{fechaInicio})+(7*(#{noSemana}-1)) "+
										" day) > date(#{fechaFin}), "+
									 " date(#{fechaFin}) "+          
									" , "+
									" date_add(#{fechaInicio}, "+
												" interval "+
												   " if(DAYOFWEEK(#{fechaInicio})<=5,5,12)-DAYOFWEEK(#{fechaInicio})+(7*(#{noSemana}-1)) "+
												" day) "+
								" ) "+
						  " ) "+
				  " inner join punto_venta as pv "+
					" on pv.id_punto_venta = t.id_punto_venta "+
			" where "+ 
				  " pv.id_cine = #{idCine} "+
			" group by "+
			      " pv.nombre, "+
			      " p.nombre, "+
			  	  " p.precio "+
			" union "+     
			" select "+	  	
				  " pv.nombre as punto_venta, "+
				  " p.nombre  as producto, "+
				  " p.precio, "+ 
				  " ifnull(sum(pt.cantidad),0) as cantidad, "+
				  " ifnull(sum(pt.importe),0) as total, "+
			      " '0'  as es_producto "+
			" from   paquete as p "+
			  	  " inner join paquetes_x_ticket as pt "+
					" on p.id_paquete = pt.id_paquete "+
				  " inner join ticket_venta as t "+
					" on t.id_ticket = pt.id_ticket "+
			        " and date(t.fecha) "+
					   " between "+
						 " ( "+
							" if( "+
								" date_add(#{fechaInicio}, "+
											" interval "+
											  " (-DAYOFWEEK(#{fechaInicio})+if(DAYOFWEEK(#{fechaInicio})<=5,-1,6))+(7*(#{noSemana}-1)) "+
											" day) < date(#{fechaInicio}), "+
								 " date(#{fechaInicio}) "+         
								" , "+
								 " date_add(#{fechaInicio}, "+
											" interval "+
											  " (-DAYOFWEEK(#{fechaInicio})+if(DAYOFWEEK(#{fechaInicio})<=5,-1,6))+(7*(#{noSemana}-1)) "+
											" day) "+
							" ) "+
						" ) "+
					  " and "+
						" ( "+
							 " if( date_add(#{fechaInicio}, "+
										" interval "+ 
										  " if(DAYOFWEEK(#{fechaInicio})<=5,5,12)-DAYOFWEEK(#{fechaInicio})+(7*(#{noSemana}-1)) "+
										" day) > date(#{fechaFin}), "+
									" date(#{fechaFin}) "+          
									" , "+
									" date_add(#{fechaInicio}, "+
												" interval "+
												  " if(DAYOFWEEK(#{fechaInicio})<=5,5,12)-DAYOFWEEK(#{fechaInicio})+(7*(#{noSemana}-1)) "+
												" day) "+
								" ) "+
						  " ) "+
				  " inner join punto_venta as pv "+
					" on pv.id_punto_venta = t.id_punto_venta "+
			" where "+
				 " pv.id_cine = #{idCine} "+
			" group by "+	 
			      " pv.nombre, "+
			      " p.nombre, "+
			  	  " p.precio") 
	@Results(value = {
			@Result(property="puntoVenta", column="punto_venta"),	
			@Result(property="producto", column="producto"),
			@Result(property="precio", column="precio"),
			@Result(property="cantidad", column="cantidad"),
			@Result(property="total", column="total")
			})
	List<IngresosDulceriaVO> getIngresosMensuales(@Param("idCine")Integer idCine,@Param("noSemana")Integer noSemana,@Param("fechaInicio")Date fechaInicio,@Param("fechaFin")Date fechaFin);

}
