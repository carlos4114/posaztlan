package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ImpuestoBoleto;

public class ImpuestoBoletoAssembler {
	
	
	public static ImpuestoBoleto getImpuestoBoleto( Integer idImpuestoBoleto){

		if(idImpuestoBoleto==null )
			return null;
		
		ImpuestoBoleto impuestoBoleto = new ImpuestoBoleto();
		impuestoBoleto.setIdImpuestoBoleto(idImpuestoBoleto);

		return impuestoBoleto;
	}
}
