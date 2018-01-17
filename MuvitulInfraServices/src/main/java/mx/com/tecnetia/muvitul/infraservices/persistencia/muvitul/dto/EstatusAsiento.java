package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * EstatusEmpresa generated by hbm2java
 */
@Entity
@Table(name = "estatus_asiento", catalog = "muvitul")
public class EstatusAsiento implements java.io.Serializable {

	private Integer idEstatusAsiento;
	private String nombre;
	private Set<AsistenciaXSala> asistenciaXSalas = new HashSet<AsistenciaXSala>(0);

	public EstatusAsiento() {
	}

	public EstatusAsiento(String nombre) {
		this.nombre = nombre;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_estatus_asiento", unique = true, nullable = false)
	public Integer getIdEstatusAsiento() {
		return this.idEstatusAsiento;
	}

	public void setIdEstatusAsiento(Integer idEstatusAsiento) {
		this.idEstatusAsiento = idEstatusAsiento;
	}

	@Column(name = "nombre", nullable = false, length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estatusAsiento")
	public Set<AsistenciaXSala> getAsistenciaXSalas() {
		return this.asistenciaXSalas;
	}

	public void setAsistenciaXSalas(Set<AsistenciaXSala> asistenciaXSalas) {
		this.asistenciaXSalas = asistenciaXSalas;
	}

}
