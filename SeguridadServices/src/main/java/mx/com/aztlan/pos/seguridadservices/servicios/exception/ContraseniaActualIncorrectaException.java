package mx.com.aztlan.pos.seguridadservices.servicios.exception;

import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;

public class ContraseniaActualIncorrectaException extends BusinessGlobalException{
	
	
	private static final long serialVersionUID = 1L;

	public ContraseniaActualIncorrectaException(String exception){
		super(exception);
	}

}
