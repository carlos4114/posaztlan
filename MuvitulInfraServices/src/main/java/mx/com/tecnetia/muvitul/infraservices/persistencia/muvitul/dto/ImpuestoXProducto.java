package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto;
// Generated 14-abr-2017 14:25:39 by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ImpuestoXProducto generated by hbm2java
 */
@Entity
@Table(name = "impuesto_x_producto", catalog = "muvitul")
public class ImpuestoXProducto implements java.io.Serializable {

	private Integer idImpuestoXProducto;
	private Cine cine;
	private Producto producto;
	private String nombre;
	private BigDecimal porcentaje;
	private boolean activo;
	private Set<ImpuestosXTicketProducto> impuestosXTicketProductos = new HashSet<ImpuestosXTicketProducto>(0);

	public ImpuestoXProducto() {
	}

	public ImpuestoXProducto(Cine cine, Producto producto, String nombre, BigDecimal porcentaje, boolean activo) {
		this.cine = cine;
		this.producto = producto;
		this.nombre = nombre;
		this.porcentaje = porcentaje;
		this.activo = activo;
	}

	public ImpuestoXProducto(Cine cine, Producto producto, String nombre, BigDecimal porcentaje, boolean activo,
			Set<ImpuestosXTicketProducto> impuestosXTicketProductos) {
		this.cine = cine;
		this.producto = producto;
		this.nombre = nombre;
		this.porcentaje = porcentaje;
		this.activo = activo;
		this.impuestosXTicketProductos = impuestosXTicketProductos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_impuesto_x_producto", unique = true, nullable = false)
	public Integer getIdImpuestoXProducto() {
		return this.idImpuestoXProducto;
	}

	public void setIdImpuestoXProducto(Integer idImpuestoXProducto) {
		this.idImpuestoXProducto = idImpuestoXProducto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cine", nullable = false)
	public Cine getCine() {
		return this.cine;
	}

	public void setCine(Cine cine) {
		this.cine = cine;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_producto", nullable = false)
	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Column(name = "nombre", nullable = false, length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "porcentaje", nullable = false, precision = 15)
	public BigDecimal getPorcentaje() {
		return this.porcentaje;
	}

	public void setPorcentaje(BigDecimal porcentaje) {
		this.porcentaje = porcentaje;
	}

	@Column(name = "activo", nullable = false)
	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "impuestoXProducto")
	public Set<ImpuestosXTicketProducto> getImpuestosXTicketProductos() {
		return this.impuestosXTicketProductos;
	}

	public void setImpuestosXTicketProductos(Set<ImpuestosXTicketProducto> impuestosXTicketProductos) {
		this.impuestosXTicketProductos = impuestosXTicketProductos;
	}

}
