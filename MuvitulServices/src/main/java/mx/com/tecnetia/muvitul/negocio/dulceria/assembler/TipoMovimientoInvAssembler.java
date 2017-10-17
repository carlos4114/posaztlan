package mx.com.tecnetia.muvitul.negocio.dulceria.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TipoMovimientoInv;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.TipoMovimientoInvVO;

public class TipoMovimientoInvAssembler {

	public static TipoMovimientoInv getTipoMovimientoInv(Integer idTipoMovimientoInv){

		if(idTipoMovimientoInv==null )
			return null;

		TipoMovimientoInv tipoMovimientoInv= new TipoMovimientoInv();
		tipoMovimientoInv.setIdTipoMovimientoInv(idTipoMovimientoInv);
		
		return tipoMovimientoInv;
	}

	public static TipoMovimientoInvVO getTipoMovimientoInvVO(TipoMovimientoInv tipoMovimientoInv) {
		if(tipoMovimientoInv == null )
			return null;
		
		TipoMovimientoInvVO tipoMovimientoInvVO= new TipoMovimientoInvVO();
		tipoMovimientoInvVO.setIdTipoMovimientoInv(tipoMovimientoInv.getIdTipoMovimientoInv());
		tipoMovimientoInvVO.setNombre(tipoMovimientoInv.getNombre());
		tipoMovimientoInvVO.setClave(tipoMovimientoInv.getClave());
		tipoMovimientoInvVO.setCatalogo(tipoMovimientoInv.getCatalogo());
		tipoMovimientoInvVO.setEsEntrada(tipoMovimientoInv.isEsEntrada());		
		
		return tipoMovimientoInvVO;
	}
	
	public static TipoMovimientoInv getTipoMovimientoInv(TipoMovimientoInvVO tipoMovimientoInvVO) {
		if(tipoMovimientoInvVO == null )
			return null;
		
		TipoMovimientoInv tipoMovimientoInv= new TipoMovimientoInv();
		tipoMovimientoInv.setIdTipoMovimientoInv(tipoMovimientoInvVO.getIdTipoMovimientoInv());
		tipoMovimientoInv.setNombre(tipoMovimientoInvVO.getNombre());
		tipoMovimientoInv.setClave(tipoMovimientoInvVO.getClave());
		tipoMovimientoInv.setCatalogo(tipoMovimientoInvVO.getCatalogo());
		tipoMovimientoInv.setEsEntrada(tipoMovimientoInvVO.isEsEntrada());		
		
		return tipoMovimientoInv;
	}
	
	public static List<TipoMovimientoInvVO> getTiposMovimientoInvVO(List<TipoMovimientoInv> tipoMovimientoInvs){

		if(tipoMovimientoInvs==null || tipoMovimientoInvs.isEmpty())
			return null;
		
		List<TipoMovimientoInvVO> tipoMovimientoInvVO = new ArrayList<TipoMovimientoInvVO>();
		
		for (TipoMovimientoInv tipoMovimientoInv : tipoMovimientoInvs) {
			tipoMovimientoInvVO.add(TipoMovimientoInvAssembler.getTipoMovimientoInvVO(tipoMovimientoInv));
		}

		return tipoMovimientoInvVO;
	}	
	
}
