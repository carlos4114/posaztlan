package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface FolioIbatisDAOI {

	@Select("select ifnull(max(folio)+1,1) from folio_boleto where id_cine=#{idCine}")
	Integer obtenerSiguienteFolio(@Param("idCine")Integer idCine);
}
