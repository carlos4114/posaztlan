package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;


import java.math.BigDecimal;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface OrdenCompraIbatisDAOI {

	@Select("select ocd.precio_unitario "
			+ " from orden_compra_detalle ocd inner join orden_compra oc on oc.id_orden_compra=ocd.id_orden_compra "
			+ " where ocd.id_producto =#{idProducto} and oc.id_proveedor=#{idProveedor} "
			+ " having max(oc.fecha_hora) limit 1")
	BigDecimal obtenerPrecioUltimaOrdenCompra(@Param("idProducto")Integer idProducto, @Param("idProveedor")Integer idProveedor);
}
