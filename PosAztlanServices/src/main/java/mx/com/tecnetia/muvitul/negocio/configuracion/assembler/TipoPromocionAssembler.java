package mx.com.tecnetia.muvitul.negocio.configuracion.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TipoPromocion;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.TipoPromocionVO;

public class TipoPromocionAssembler {

	public static TipoPromocionVO getTipoPromocionVO(TipoPromocion tipoPromocion){

		if(tipoPromocion==null)
			return null;
		
		TipoPromocionVO tipoPromocionVO = new TipoPromocionVO();
		tipoPromocionVO.setIdTipoPromocion(tipoPromocion.getIdTipoPromocion());
		tipoPromocionVO.setNombre(tipoPromocion.getNombre());
		tipoPromocionVO.setDescripcion(tipoPromocion.getDescripcion());
		tipoPromocionVO.setClave(tipoPromocion.getClave());
		
		return tipoPromocionVO;
	}
	
	
	public static List<TipoPromocionVO> getTiposPromocionVO(List<TipoPromocion> tiposPromocion) {

		if (tiposPromocion == null || tiposPromocion.isEmpty())
			return null;

		List<TipoPromocionVO> tiposPromocionVO = new ArrayList<TipoPromocionVO>();

		for (TipoPromocion tipoPromocion : tiposPromocion) {
			tiposPromocionVO.add(TipoPromocionAssembler.getTipoPromocionVO(tipoPromocion));
		}

		return tiposPromocionVO;
	}
	
	public static TipoPromocion getTipoPromocion(Integer idTipoPromocion){

		if(idTipoPromocion==null)
			return null;
		
		TipoPromocion tipoPromocion = new TipoPromocion();
		tipoPromocion.setIdTipoPromocion(idTipoPromocion);

		return tipoPromocion;
	}
	
}
