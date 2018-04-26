package mx.com.aztlan.pos.negocio.configuracion.assembler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ArticulosXProducto;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Canal;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Empresa;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Familia;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ImpuestoXProducto;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Marca;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Medida;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PrecioXCanal;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PrecioXCanalId;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Producto;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ProductosXPuntoVenta;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ProductosXPuntoVentaId;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PuntoVenta;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TipoProducto;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.UnidadMedida;
import mx.com.aztlan.pos.negocio.configuracion.vo.ArticulosXProductoVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ImpuestoVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.PreciosXCanalVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ProductoVO;

public class ProductoAssembler {

	public static ProductoVO getProductoVO(Producto producto){
		if(producto==null)
			return null;
		
		ProductoVO productoVO = new ProductoVO();
		productoVO.setIdProducto(producto.getIdProducto());
		productoVO.setNombre(producto.getNombre());
		productoVO.setDescripcion(producto.getDescripcion());
		productoVO.setIcono(producto.getIcono());
		productoVO.setActivo(producto.isActivo());
		productoVO.setIdEmpresa(producto.getEmpresa().getIdEmpresa());
		productoVO.setIdFamilia(producto.getFamilia().getIdFamilia());
		productoVO.setIdMarca(producto.getMarca().getIdMarca());
		productoVO.setIdTipoProducto(producto.getTipoProducto().getIdTipoProducto());
		productoVO.setIdMedida(producto.getMedida().getIdMedida());
		productoVO.setIdUnidadMedida(producto.getUnidadMedida().getIdUnidadMedida());
		productoVO.setPrecioUnico(producto.getPrecioUnico());
		productoVO.setNacional(producto.isNacional());
		productoVO.setImpuestosList(getImpuestos(producto.getImpuestoXProductos()));
		productoVO.setPreciosXCanalList(getPreciosXCanalVO(producto.getPrecioXCanal()));
		productoVO.setSku(producto.getSku());
		
		return productoVO;
	}
	
	
	public static List<ProductoVO> getProductos(List<Producto> productos){

		if(productos==null)
			return null;
		
		List<ProductoVO> productosVO = new ArrayList<ProductoVO>();
		
		for (Producto producto : productos) {
			productosVO.add(ProductoAssembler.getProductoVO(producto));
		}

		return productosVO;
	}
	
	public static Producto getProducto(Integer idProducto){
		
		if(idProducto==null)
			return null;
		
		Producto producto = new Producto();
		producto.setIdProducto(idProducto);
		
		return producto;
	}
	
	public static Set<ProductosXPuntoVenta> getPuntosVentaProducto(List<Integer> puntosVenta, Producto producto) {
		Set<ProductosXPuntoVenta> listaPuntosVenta = new HashSet<ProductosXPuntoVenta>();
		for(Integer idPuntoVenta:puntosVenta){
			ProductosXPuntoVenta productoPV = new ProductosXPuntoVenta(
					new ProductosXPuntoVentaId(idPuntoVenta,producto.getIdProducto())
					,producto,
					new PuntoVenta(idPuntoVenta)
					);
			listaPuntosVenta.add(productoPV);
		}
		
		return listaPuntosVenta;
	}
	
	public static List<PreciosXCanalVO> getPreciosXCanalVO(Set<PrecioXCanal> preciosXCanal) {
		List<PreciosXCanalVO> listaPreciosXCanal = new ArrayList<PreciosXCanalVO>();
		
		for(PrecioXCanal precioXCanal: preciosXCanal) {
			PreciosXCanalVO precio = new PreciosXCanalVO();
			precio.setIdCanal(precioXCanal.getCanal().getIdCanal());
			precio.setPrecio(precioXCanal.getPrecio());
			precio.setNombre(precioXCanal.getCanal().getNombre());
			listaPreciosXCanal.add(precio);
		}
		
		
		return listaPreciosXCanal;
	}
	
	public static Set<PrecioXCanal> getPreciosXCanal(List<PreciosXCanalVO> preciosXCanal, Producto producto){
		Set<PrecioXCanal> listaPreciosXCanal = new HashSet<PrecioXCanal>();
		
		for(PreciosXCanalVO precio : preciosXCanal) {
			PrecioXCanal precioXC = new PrecioXCanal(
					new PrecioXCanalId(precio.getIdCanal(), producto.getIdProducto()),
					producto, 
					new Canal(precio.getIdCanal()), precio.getPrecio());
			listaPreciosXCanal.add(precioXC);
		}
	
		return listaPreciosXCanal;
	}
	
	public static List<ArticulosXProductoVO> getArticulosSeleccionados(Set<ArticulosXProducto> articulosPVList) {
		List<ArticulosXProductoVO> articulos = new ArrayList<ArticulosXProductoVO>();
		
		
		for(ArticulosXProducto articulo : articulosPVList){
			ArticulosXProductoVO art = new ArticulosXProductoVO();
			art.setIdArticulo(articulo.getArticulo().getIdArticulo());
			art.setCantidad(articulo.getCantidad());
			art.setNombre(articulo.getArticulo().getNombre());
			articulos.add(art);
		}
		
		return articulos;
	}
	
	public static List<ImpuestoVO> getImpuestos(Set<ImpuestoXProducto> impuestosList) {
		List<ImpuestoVO> impuestos = new ArrayList<ImpuestoVO>();
		
		for(ImpuestoXProducto impuesto : impuestosList){
			if(impuesto.isActivo()){
				ImpuestoVO impuestoVO = new ImpuestoVO();
				impuestoVO.setIdImpuesto(impuesto.getIdImpuestoXProducto());
				impuestoVO.setNombre(impuesto.getNombre());
				impuestoVO.setPorcentaje(impuesto.getPorcentaje());
				
				impuestos.add(impuestoVO);
			}
		}
		
		return impuestos;
	}
	
	public static List<Integer> getPuntosVentaList(Set<ProductosXPuntoVenta> productosPVList) {
		List<Integer> puntosVenta = new ArrayList<Integer>();
		
		for(ProductosXPuntoVenta puntoVenta : productosPVList){
			puntosVenta.add(puntoVenta.getPuntoVenta().getIdPuntoVenta());
		}
		
		return puntosVenta;
	}
	
	public static Producto getProducto(ProductoVO productoVO) {

		if(productoVO==null)
			return null;

		Producto producto = new Producto();
		producto.setIdProducto(productoVO.getIdProducto());
		producto.setNombre(productoVO.getNombre());
		producto.setDescripcion(productoVO.getDescripcion());
		producto.setIcono(productoVO.getIcono());
		producto.setActivo(productoVO.isActivo());
		producto.setEmpresa(new Empresa(productoVO.getIdEmpresa()));
		producto.setFamilia(new Familia(productoVO.getIdFamilia()));
		producto.setMarca(new Marca(productoVO.getIdMarca()));
		producto.setTipoProducto(new TipoProducto(productoVO.getIdTipoProducto()));
		producto.setMedida(new Medida(productoVO.getIdMedida()));
		producto.setUnidadMedida(new UnidadMedida(productoVO.getIdUnidadMedida()));
		producto.setPrecioUnico(productoVO.getPrecioUnico());
		producto.setNacional(productoVO.isNacional());
		//producto.setPrecioXCanal(getPreciosXCanal(productoVO.getPreciosXCanalList(), producto));
		
		return producto;
	}
	
	public static Producto getProducto(ProductoVO productoVO, Producto producto) {

		if(productoVO==null)
			return null;

		producto.setNombre(productoVO.getNombre());
		producto.setDescripcion(productoVO.getDescripcion());
		producto.setIcono(productoVO.getIcono());
		producto.setActivo(productoVO.isActivo());
		producto.setEmpresa(new Empresa(productoVO.getIdEmpresa()));
		producto.setFamilia(new Familia(productoVO.getIdFamilia()));
		producto.setMarca(new Marca(productoVO.getIdMarca()));
		producto.setTipoProducto(new TipoProducto(productoVO.getIdTipoProducto()));
		producto.setMedida(new Medida(productoVO.getIdMedida()));
		producto.setUnidadMedida(new UnidadMedida(productoVO.getIdUnidadMedida()));
		producto.setPrecioUnico(productoVO.getPrecioUnico());
		producto.setNacional(productoVO.isNacional());
		producto.setPrecioXCanal(getPreciosXCanal(productoVO.getPreciosXCanalList(), producto));
		
		
		return producto;
	}
}