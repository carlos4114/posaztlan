package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;


import java.math.BigDecimal;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CajaIbatisDAOI {

	@Select("select ifnull(sum(p.importe),0) "
			+ "	+ "
			+ " ifnull(("
			+ "	  select cc2.entrada_caja from corte_caja cc2 where cc2.id_caja=#{idCaja} "
			+ "	  and fecha=(select max(fecha) from corte_caja cc3 where cc3.id_caja=#{idCaja})"
			+ "	),0) as en_caja "
			+ " from ticket_venta tv "
			+ " inner join pago p "
			+ " on p.id_ticket=tv.id_ticket "
			+ " 	and p.id_forma_pago=1 "
			+ " 	and p.id_estatus_pago=1 "
			+ " where "
			+ " 	tv.id_caja=#{idCaja} "
			+ " 	and tv.fecha "
			+ " between "
			+ "    ifnull((select max(cc.fecha) from corte_caja cc where cc.id_caja=#{idCaja}),'1900-01-01 00:00:00')"
			+ "    and now();")
	BigDecimal getEfectivoEnCaja(@Param("idCaja")Integer idCaja);
}
