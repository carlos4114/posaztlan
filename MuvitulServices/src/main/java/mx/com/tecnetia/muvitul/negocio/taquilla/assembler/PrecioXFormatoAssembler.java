package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PrecioXFormato;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PrecioXFormatoVO;

public class PrecioXFormatoAssembler {

	public static PrecioXFormatoVO getPrecioXFormatoVO(PrecioXFormato precioXFormato){

		if(precioXFormato==null )
			return null;
		
		PrecioXFormatoVO precioXFormatoVO = new PrecioXFormatoVO();
		precioXFormatoVO.setIdPrecioXFormato(precioXFormato.getIdPrecioXFormato());
		precioXFormatoVO.setFormatoVO(FormatoAssembler.getFormatoVO(precioXFormato.getFormato()));
		precioXFormatoVO.setTipoClienteVO(TipoClienteAssembler.getTipoClienteVO(precioXFormato.getTipoCliente()));
		precioXFormatoVO.setPrecio(precioXFormato.getPrecio());
		precioXFormatoVO.setActivo(precioXFormato.isActivo());

		return precioXFormatoVO;
	}
	
	
	public static List<PrecioXFormatoVO> getPreciosXFormatoVO(List<PrecioXFormato> preciosXFormato){

		if(preciosXFormato==null || preciosXFormato.isEmpty())
			return null;
		
		List<PrecioXFormatoVO> preciosXFormatoVO = new ArrayList<PrecioXFormatoVO>();
		
		for (PrecioXFormato precioXFormato : preciosXFormato) {
			preciosXFormatoVO.add(PrecioXFormatoAssembler.getPrecioXFormatoVO(precioXFormato));
		}

		return preciosXFormatoVO;
	}
	
}
