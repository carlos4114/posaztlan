package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;


import org.apache.ibatis.annotations.Select;

public interface BoletosIbatisDAOI {

	@Select("delete from "
			+ " existencia_boletos "
			+ " where fecha_reserva < (now() - "
			+ " INTERVAL (select CONVERT(valor,UNSIGNED INTEGER) AS num "
			+ " from propiedad_config where id_propiedad_config=4) MINUTE)")
	void borrarBoletosReservados();
	
	@Select("delete from asistencia_x_sala where (id_estatus_asiento=1 or id_estatus_asiento=3) "
			+ "	and fecha_reserva < (now() -INTERVAL (select CONVERT(valor,UNSIGNED INTEGER) AS num "
			+ "	from propiedad_config where id_propiedad_config=4) MINUTE) ")
	void borrarAsientosReservados();
}
