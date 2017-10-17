package mx.com.tecnetia.muvitul.negocio.configuracion.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.EstadoProducto;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.EstadoProductoVO;

public class EstadoProductoAssembler {
	
	public static EstadoProductoVO getEstadoProductoVO(EstadoProducto estadoProducto){

		if(estadoProducto==null )
			return null;
		
		EstadoProductoVO estadoProductoVO = new EstadoProductoVO();
		estadoProductoVO.setIdEstadoProducto(estadoProducto.getIdEstadoProducto());
		estadoProductoVO.setNombre(estadoProducto.getNombre());
		estadoProductoVO.setActivo(estadoProducto.isActivo());
		estadoProductoVO.setClave(estadoProducto.getClave());

		return estadoProductoVO;
	}
	
	public static List<EstadoProductoVO> getEstadosProductoVO(List<EstadoProducto> estadosProducto){

		if(estadosProducto==null || estadosProducto.isEmpty())
			return null;
		
		List<EstadoProductoVO> estadosProductoVO = new ArrayList<EstadoProductoVO>();
		
		for (EstadoProducto estadoProducto : estadosProducto) {
			estadosProductoVO.add(EstadoProductoAssembler.getEstadoProductoVO(estadoProducto));
		}

		return estadosProductoVO;
	}
	
}
