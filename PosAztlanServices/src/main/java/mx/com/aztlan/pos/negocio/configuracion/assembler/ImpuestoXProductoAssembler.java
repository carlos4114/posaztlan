package mx.com.aztlan.pos.negocio.configuracion.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ImpuestoXProducto;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Producto;
import mx.com.aztlan.pos.negocio.configuracion.vo.CatalogoVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ImpuestoVO;


public class ImpuestoXProductoAssembler {

	
	public static ImpuestoXProducto getImpuestoXProducto(ImpuestoVO impuestoVO, Producto producto){
		if(impuestoVO==null)
			return null;
		
		ImpuestoXProducto impuestoXProducto = new ImpuestoXProducto();
		impuestoXProducto.setIdImpuestoXProducto(impuestoVO.getIdImpuesto());
		impuestoXProducto.setEmpresa(producto.getEmpresa());
		impuestoXProducto.setActivo(impuestoVO.isActivo());
		impuestoXProducto.setNombre(impuestoVO.getNombre());
		impuestoXProducto.setPorcentaje(impuestoVO.getPorcentaje());
		impuestoXProducto.setProducto(producto);
		
		return impuestoXProducto;
	}
	
	public static CatalogoVO getImpuestoXProducto(ImpuestoXProducto impuestoXProducto){
		if(impuestoXProducto==null)
			return null;
		
		CatalogoVO catalogoVO = new CatalogoVO();
		catalogoVO.setId(impuestoXProducto.getIdImpuestoXProducto());
		catalogoVO.setNombre(impuestoXProducto.getNombre());

		return catalogoVO;
	}
	
	public static List<CatalogoVO> geImpuestosXProducto(List<ImpuestoXProducto> impuestos){

		List<CatalogoVO> catalogoVO = new ArrayList<CatalogoVO>();
		
		for (ImpuestoXProducto impuesto : impuestos) {
			catalogoVO.add(ImpuestoXProductoAssembler.getImpuestoXProducto(impuesto));
		}

		return catalogoVO;

	}

	
}
