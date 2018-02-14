package mx.com.aztlan.pos.negocio.devolucion.assembler;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Promocion;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TipoCliente;
import mx.com.aztlan.pos.negocio.devolucion.vo.TipoClienteVO;


public class TipoClienteAssembler {

	public static TipoClienteVO getTipoClienteVO(TipoCliente tipoCliente){

		if(tipoCliente==null )
			return null;
		
		TipoClienteVO tipoClienteVO = new TipoClienteVO();
		tipoClienteVO.setIdTipoCliente(tipoCliente.getIdTipoCliente());
		tipoClienteVO.setNombre(tipoCliente.getNombre());
		tipoClienteVO.setActivo(tipoCliente.isActivo());
		tipoClienteVO.setIcono(tipoCliente.getIcono());

		return tipoClienteVO;
	}
	
	public static TipoCliente getTipoCliente(Integer idTipoCliente){

		if(idTipoCliente==null )
			return null;
		
		TipoCliente tipoCliente = new TipoCliente();
		tipoCliente.setIdTipoCliente(idTipoCliente);

		return tipoCliente;
	}
	
	public static TipoClienteVO getTipoClientePromocionVO(Promocion promocion ){

		TipoClienteVO tipoClienteVO = new TipoClienteVO();
		tipoClienteVO.setIdTipoCliente(promocion.getIdPromocion());
		tipoClienteVO.setNombre(promocion.getNombre());
		tipoClienteVO.setActivo(promocion.isActivo());

		return tipoClienteVO;
	}
	
}
