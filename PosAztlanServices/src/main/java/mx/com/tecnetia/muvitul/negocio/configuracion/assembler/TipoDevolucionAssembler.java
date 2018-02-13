package mx.com.tecnetia.muvitul.negocio.configuracion.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TipoDevolucion;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.TipoDevolucionVO;

public class TipoDevolucionAssembler {
	
	public static TipoDevolucionVO getTipoDevolucionVO(TipoDevolucion tipoDevolucion){

		if(tipoDevolucion==null )
			return null;
		
		TipoDevolucionVO tipoDevolucionVO = new TipoDevolucionVO();
		tipoDevolucionVO.setIdTipoDevolucion(tipoDevolucion.getIdTipoDevolucion());
		tipoDevolucionVO.setTipoPuntoVentaVO(TipoPuntoVentaAssembler.getTipoPuntoVentaVO(tipoDevolucion.getTipoPuntoVenta()));
		tipoDevolucionVO.setNombre(tipoDevolucion.getNombre());
		tipoDevolucionVO.setClave(tipoDevolucion.getClave());
		tipoDevolucionVO.setActivo(tipoDevolucion.isActivo());

		return tipoDevolucionVO;
	}
	
	public static List<TipoDevolucionVO> getTiposDevolucionVO(List<TipoDevolucion> tiposDevolucion){

		if(tiposDevolucion==null || tiposDevolucion.isEmpty())
			return null;
		
		List<TipoDevolucionVO> tiposDevolucionVO = new ArrayList<TipoDevolucionVO>();
		
		for (TipoDevolucion tipoDevolucion : tiposDevolucion) {
			tiposDevolucionVO.add(TipoDevolucionAssembler.getTipoDevolucionVO(tipoDevolucion));
		}

		return tiposDevolucionVO;
	}
}
