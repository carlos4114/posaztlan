package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto;
// Generated 29-may-2017 22:51:46 by Hibernate Tools 4.3.1.Final

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Empresa generated by hbm2java
 */
@Entity
@Table(name = "documento", catalog = "posaztlanbd")
public class Documento implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -36504834906358618L;
	private Integer idDocumento;
	private String nombre;
	private byte[] archivo;
	private String contentType;
	private Integer size;
	private String comentarios;
	private boolean activo;
	
	public Documento() {
	}

	public Documento(Integer idDocumento, String nombre,byte[] archivo, String contentType,Integer size, String comentarios, boolean activo) {
		super();
		this.idDocumento = idDocumento;
		this.archivo = archivo;
		this.nombre = nombre;
		this.contentType = contentType;
		this.size = size;
		this.comentarios = comentarios;
		this.activo = activo;		
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_documento", unique = true, nullable = false)
	public Integer getIdDocumento() {
		return this.idDocumento;
	}

	public void setIdDocumento(Integer idDocumento) {
		this.idDocumento = idDocumento;
	}
	
	@Column(name = "nombre", nullable = false, length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name = "content_type", nullable = false, length = 45)
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	@Column(name = "tamanio", nullable = false)
	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	@Column(name = "comentarios", nullable = false, length = 45)
	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	@Column(name = "activo", nullable = false)
	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Column(name = "archivo", nullable = false)
	public byte[] getArchivo() {
		return this.archivo;
	}

	public void setArchivo(byte[] archivo) {
		this.archivo = archivo;
	}


}