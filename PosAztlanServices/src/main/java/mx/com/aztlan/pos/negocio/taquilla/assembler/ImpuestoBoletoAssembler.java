package mx.com.aztlan.pos.negocio.taquilla.assembler;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ImpuestoBoleto;

public class ImpuestoBoletoAssembler {
	
	
	public static ImpuestoBoleto getImpuestoBoleto( Integer idImpuestoBoleto){

		if(idImpuestoBoleto==null )
			return null;
		
		ImpuestoBoleto impuestoBoleto = new ImpuestoBoleto();
		impuestoBoleto.setIdImpuestoBoleto(idImpuestoBoleto);

		return impuestoBoleto;
	}
}
