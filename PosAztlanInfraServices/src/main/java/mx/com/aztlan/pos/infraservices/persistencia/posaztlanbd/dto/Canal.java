package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "canal", catalog = "posAztlanbd")
public class Canal implements java.io.Serializable {

	private Integer idCanal;
	private Empresa empresa;
	private String nombre;
	private Contacto contacto;
	private boolean activo;
	private String telefono;
	private boolean cobro;
	//private Set<Usuario> usuarios = new HashSet<Usuario>(0);
	
	public Canal() {
	}

	public Canal(Integer idCanal) {
		this.idCanal = idCanal;
	}
	
	public Canal(Empresa empresa, String nombre, boolean activo, boolean cobro) {
		this.empresa = empresa;
		this.nombre = nombre;
		this.activo = activo;
		this.cobro = cobro;
	}

	public Canal(Empresa empresa, String nombre, Contacto contacto, boolean activo, String telefono, boolean cobro) {
		this.empresa = empresa;
		this.nombre = nombre;
		this.contacto = contacto;
		this.activo = activo;
		this.telefono = telefono;
		this.cobro = cobro;
		//this.usuarios = usuarios;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_canal", unique = true, nullable = false)
	public Integer getIdCanal() {
		return this.idCanal;
	}

	public void setIdCanal(Integer idCanal) {
		this.idCanal = idCanal;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_contacto", nullable = false)
	public Contacto getContacto() {
		return this.contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empresa", nullable = false)
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Column(name = "nombre", nullable = false, length = 100)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "activo", nullable = false)
	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Column(name = "telefono", length = 20)
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Column(name = "cobro", nullable = false)
	public boolean isCobro() {
		return this.cobro;
	}

	public void setCobro(boolean cobro) {
		this.cobro = cobro;
	}
	
	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "cine")
	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}*/

}
