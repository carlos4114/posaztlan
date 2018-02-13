package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.enumeration;

 
public class ErroresSeguridadEnum implements java.io.Serializable {		

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int USUARIO_NO_EXISTE = 1;
	public static int CONTRASENIA_INCORRECTA = 2;
	public static int USUARIO_INACTIVO = 3;
	public static int CONTRASENIA_ACTUAL_INCORRECTA = 4;
	public static int EMPRESA_EN_DEUDA = 5;
	public static int EMPRESA_INACTIVA = 6;
	
}