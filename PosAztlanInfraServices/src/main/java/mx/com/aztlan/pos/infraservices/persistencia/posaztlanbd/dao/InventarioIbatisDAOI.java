package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.vo.ProductoExistenciaVO;

public interface InventarioIbatisDAOI {

	@Select("select p.id_producto, p.sku,p.nombre, f.nombre as familia, m.nombre as marca, t.nombre as tipo_producto, "+ 
			" me.nombre as medida, um.nombre as unidad_medida,  ifnull(sum(i.existencia_actual),0) as existencia, "+
       " ifnull((select pxc.precio "+
         " from precio_x_canal pxc inner join almacen al on pxc.id_canal=al.id_Canal "+
		 " where pxc.id_producto = p.id_producto and al.id_almacen = i.id_almacen) "+
         " ,p.precio_unico) as precio "+
        " from producto p "+
        		   " left outer join  inventario i on i.id_producto=p.id_producto and i.existencia_actual>0 "+
        		   " left outer join almacen a on a.id_almacen = i.id_almacen and a.id_canal = #{idCanal} " +
        		   " inner join familia f on f.id_familia=p.id_familia "+
        		   " inner join marca m on m.id_marca=p.id_marca "+
        		   " inner join tipo_producto t on t.id_tipo_producto=p.id_tipo_producto "+
        		   " inner join medida me on me.id_medida = p.id_medida "+
        		   " inner join unidad_medida um on um.id_unidad_medida = p.id_unidad_medida "+
        " group by p.id_producto")
	@Results(value = {
			@Result(property="idProducto", column="id_producto"),	
			@Result(property="sku", column="sku"),
			@Result(property="nombre", column="nombre"),
			@Result(property="familia", column="familia"),
			@Result(property="marca", column="marca"),	
			@Result(property="tipoProducto", column="tipo_producto"),
			@Result(property="medida", column="medida"),
			@Result(property="unidadMedida", column="unidad_medida"),
			@Result(property="existencia", column="existencia"),
			@Result(property="precio", column="precio")
			})
	List<ProductoExistenciaVO> getProductosPorCanal(@Param("idCanal")Integer idCanal);
	
	@Select("select p.id_producto, p.sku,p.nombre, f.nombre as familia, m.nombre as marca, t.nombre as tipo_producto, "+ 
			" me.nombre as medida, um.nombre as unidad_medida,  ifnull(sum(i.existencia_actual),0) as existencia, "+
       " ifnull((select pxc.precio "+
         " from precio_x_canal pxc inner join almacen al on pxc.id_canal=al.id_Canal "+
		 " where pxc.id_producto = p.id_producto and al.id_almacen = i.id_almacen) "+
         " ,p.precio_unico) as precio "+
        " from producto p "+
        		   " left outer join  inventario i on i.id_producto=p.id_producto and i.existencia_actual>0 and i.id_almacen=#{idAlmacen} "+ 
        		   " inner join familia f on f.id_familia=p.id_familia "+
        		   " inner join marca m on m.id_marca=p.id_marca "+
        		   " inner join tipo_producto t on t.id_tipo_producto=p.id_tipo_producto "+
        		   " inner join medida me on me.id_medida = p.id_medida "+
        		   " inner join unidad_medida um on um.id_unidad_medida = p.id_unidad_medida "+
        " group by p.id_producto")
	@Results(value = {
			@Result(property="idProducto", column="id_producto"),	
			@Result(property="sku", column="sku"),
			@Result(property="nombre", column="nombre"),
			@Result(property="familia", column="familia"),
			@Result(property="marca", column="marca"),	
			@Result(property="tipoProducto", column="tipo_producto"),
			@Result(property="medida", column="medida"),
			@Result(property="unidadMedida", column="unidad_medida"),
			@Result(property="existencia", column="existencia"),
			@Result(property="precio", column="precio")
			})
	List<ProductoExistenciaVO> getProductosPorAlmacen(@Param("idAlmacen")Integer idAlmacen);
	
	@Select("select p.id_producto, p.sku,p.nombre, f.nombre as familia, m.nombre as marca, t.nombre as tipo_producto, "+ 
			" me.nombre as medida, um.nombre as unidad_medida,  ifnull(sum(i.existencia_actual),0) as existencia, "+
       " ifnull((select pxc.precio "+
         " from precio_x_canal pxc inner join almacen al on pxc.id_canal=al.id_Canal "+
		 " where pxc.id_producto = p.id_producto and al.id_almacen = i.id_almacen) "+
         " ,p.precio_unico) as precio, ifnull(prop.validar_existencia_inv, false) as validar_existencia "+
        " from producto p "+
        		   " left outer join  inventario i on i.id_producto=p.id_producto and i.existencia_actual>0 and i.id_almacen=#{idAlmacen} "+ 
        		   " inner join familia f on f.id_familia=p.id_familia "+
        		   " inner join marca m on m.id_marca=p.id_marca "+
        		   " inner join tipo_producto t on t.id_tipo_producto=p.id_tipo_producto "+
        		   " inner join medida me on me.id_medida = p.id_medida "+
        		   " inner join unidad_medida um on um.id_unidad_medida = p.id_unidad_medida "
        		   + "left outer join propiedad_config_empresa prop on prop.id_empresa = p.id_empresa "+
        " where "+       
        " p.sku = #{sku} "+
        " group by p.id_producto")
	@Results(value = {
			@Result(property="idProducto", column="id_producto"),	
			@Result(property="sku", column="sku"),
			@Result(property="nombre", column="nombre"),
			@Result(property="familia", column="familia"),
			@Result(property="marca", column="marca"),	
			@Result(property="tipoProducto", column="tipo_producto"),
			@Result(property="medida", column="medida"),
			@Result(property="unidadMedida", column="unidad_medida"),
			@Result(property="existencia", column="existencia"),
			@Result(property="precio", column="precio"),
			@Result(property="validarExistencia", column="validar_existencia")
			})
	List<ProductoExistenciaVO> getProductosPorSku(@Param("idAlmacen")Integer idAlmacen,@Param("sku")String sku);

	
	@Select("select p.id_producto, p.sku,p.nombre, f.nombre as familia, m.nombre as marca, t.nombre as tipo_producto, "+ 
			" me.nombre as medida, um.nombre as unidad_medida,  ifnull(sum(i.existencia_actual),0) as existencia, "+
       " ifnull((select pxc.precio "+
         " from precio_x_canal pxc inner join almacen al on pxc.id_canal=al.id_Canal "+
		 " where pxc.id_producto = p.id_producto and al.id_almacen = i.id_almacen) "+
         " ,p.precio_unico) as precio, ifnull(prop.validar_existencia_inv, false) as validar_existencia "+
        " from producto p "+
        		   " left outer join  inventario i on i.id_producto=p.id_producto and i.existencia_actual>0 and i.id_almacen=#{idAlmacen} "+ 
        		   " inner join familia f on f.id_familia=p.id_familia "+
        		   " inner join marca m on m.id_marca=p.id_marca "+
        		   " inner join tipo_producto t on t.id_tipo_producto=p.id_tipo_producto "+
        		   " inner join medida me on me.id_medida = p.id_medida "+
        		   " inner join unidad_medida um on um.id_unidad_medida = p.id_unidad_medida "
        		   + " left outer join propiedad_config_empresa prop on prop.id_empresa = p.id_empresa "+
        " where "+
        " ucase(p.nombre) LIKE #{nombreProducto} "+            
        " group by p.id_producto")
	@Results(value = {
			@Result(property="idProducto", column="id_producto"),	
			@Result(property="sku", column="sku"),
			@Result(property="nombre", column="nombre"),
			@Result(property="familia", column="familia"),
			@Result(property="marca", column="marca"),	
			@Result(property="tipoProducto", column="tipo_producto"),
			@Result(property="medida", column="medida"),
			@Result(property="unidadMedida", column="unidad_medida"),
			@Result(property="existencia", column="existencia"),
			@Result(property="precio", column="precio"),
			@Result(property="validarExistencia", column="validar_existencia")
			})
	List<ProductoExistenciaVO> getProductosPorNombre(@Param("idAlmacen")Integer idAlmacen, @Param("nombreProducto")String nombreProducto);

}
