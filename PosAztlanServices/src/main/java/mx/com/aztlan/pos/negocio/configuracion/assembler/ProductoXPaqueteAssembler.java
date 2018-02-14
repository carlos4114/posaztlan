package mx.com.aztlan.pos.negocio.configuracion.assembler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ProductosXPaquete;
import mx.com.aztlan.pos.negocio.configuracion.vo.ProductoXPaqueteVO;

public class ProductoXPaqueteAssembler {

	
	public static ProductoXPaqueteVO getProductoXPaqueteVO(ProductosXPaquete productoXPaquete){
		
		if(productoXPaquete==null)
			return null;
		
		ProductoXPaqueteVO productoXPaqueteVO = new ProductoXPaqueteVO();
		productoXPaqueteVO.setProductoVO(ProductoAssembler.getProductoVO(productoXPaquete.getProducto()));
		productoXPaqueteVO.setCantidad(productoXPaquete.getCantidad());
		
		return productoXPaqueteVO;
	}
	
	
	public static List<ProductoXPaqueteVO> getProductosXPaqueteVO(Set<ProductosXPaquete> productosPaquete) {

		if (productosPaquete == null || productosPaquete.isEmpty())
			return null;

		List<ProductoXPaqueteVO>  productosPaqueteVO = new ArrayList<ProductoXPaqueteVO>();

		for (ProductosXPaquete productoPaquete : productosPaquete) {
			productosPaqueteVO.add(ProductoXPaqueteAssembler.getProductoXPaqueteVO(productoPaquete));
		}

		return productosPaqueteVO;
	}
	
	
}
