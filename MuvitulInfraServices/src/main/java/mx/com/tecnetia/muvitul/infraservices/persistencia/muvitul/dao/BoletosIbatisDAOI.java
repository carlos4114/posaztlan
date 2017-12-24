package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;


import org.apache.ibatis.annotations.Select;

public interface BoletosIbatisDAOI {

	@Select("delete from "
			+ " existencia_boletos "
			+ " where fecha_reserva < (now() - "
			+ " INTERVAL (select CONVERT(valor,UNSIGNED INTEGER) AS num "
			+ " from propiedad_config where id_propiedad_config=4) MINUTE)")
	void borrarBoletosReservados();
}
