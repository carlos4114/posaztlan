package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface SkuIbatisDAOI {

	@Select("select  max(cast(substring(sku,length(sku)-2) as UNSIGNED)) "
			+ " from producto where substring(sku,1,length(sku)-3)=#{prefijoSku} "
			+ " and id_empresa=#{idEmpresa} ")
	Integer getUltimoFolio(@Param("prefijoSku")String prefijoSku,@Param("idEmpresa")Integer idEmpresa);

}
