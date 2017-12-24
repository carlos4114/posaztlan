package mx.com.tecnetia.muvitul.seguridadservices.servicios.exception;

import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;

public class ContraseniaActualIncorrectaException extends BusinessGlobalException{
	
	
	private static final long serialVersionUID = 1L;

	public ContraseniaActualIncorrectaException(String exception){
		super(exception);
	}

}
