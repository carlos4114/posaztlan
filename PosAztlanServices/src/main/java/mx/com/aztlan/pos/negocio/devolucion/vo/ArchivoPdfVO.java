package mx.com.aztlan.pos.negocio.devolucion.vo;

public class ArchivoPdfVO {
 	private String nombre;
 	private byte[] archivo;
 	
	public ArchivoPdfVO(String nombre) {
		this.nombre=nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public byte[] getArchivo() {
		return archivo;
	}
	public void setArchivo(byte[] archivo) {
		this.archivo = archivo;
	}
	
	 
}
