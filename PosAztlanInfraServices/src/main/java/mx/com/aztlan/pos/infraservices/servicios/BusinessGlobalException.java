package mx.com.aztlan.pos.infraservices.servicios;

public class BusinessGlobalException extends Exception{
	/**
	 * MANEJO DE EXCEPCIONES PROCEDENTES DE LA CAPA DE NEGOCIO
	 */
	private static final long serialVersionUID = 1L;

	public BusinessGlobalException(String exception){
		super(exception);
	}

}
