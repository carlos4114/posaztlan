package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto;
// Generated 09-may-2017 15:35:30 by Hibernate Tools 4.3.1.Final

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
 * DetallePromocion generated by hbm2java
 */
@Entity
@Table(name = "detalle_promocion", catalog = "muvitul")
public class DetallePromocion implements java.io.Serializable {

	private Integer idDetallePromocion;
	private Producto producto;
	private Regalo regalo;
	private Integer varN;
	private Integer varM;
	private BigDecimal precio;
	private BigDecimal porcentaje;
	private Set<Promocion> promocions = new HashSet<Promocion>(0);

	public DetallePromocion() {
	}

	public DetallePromocion(Producto producto, Regalo regalo, Integer varN, Integer varM, BigDecimal precio,
			BigDecimal porcentaje, Set<Promocion> promocions) {
		this.producto = producto;
		this.regalo = regalo;
		this.varN = varN;
		this.varM = varM;
		this.precio = precio;
		this.porcentaje = porcentaje;
		this.promocions = promocions;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_detalle_promocion", unique = true, nullable = false)
	public Integer getIdDetallePromocion() {
		return this.idDetallePromocion;
	}

	public void setIdDetallePromocion(Integer idDetallePromocion) {
		this.idDetallePromocion = idDetallePromocion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_producto")
	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_regalo")
	public Regalo getRegalo() {
		return this.regalo;
	}

	public void setRegalo(Regalo regalo) {
		this.regalo = regalo;
	}

	@Column(name = "var_n")
	public Integer getVarN() {
		return this.varN;
	}

	public void setVarN(Integer varN) {
		this.varN = varN;
	}

	@Column(name = "var_m")
	public Integer getVarM() {
		return this.varM;
	}

	public void setVarM(Integer varM) {
		this.varM = varM;
	}

	@Column(name = "precio", precision = 15)
	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	@Column(name = "porcentaje", precision = 4)
	public BigDecimal getPorcentaje() {
		return this.porcentaje;
	}

	public void setPorcentaje(BigDecimal porcentaje) {
		this.porcentaje = porcentaje;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "detallePromocion")
	public Set<Promocion> getPromocions() {
		return this.promocions;
	}

	public void setPromocions(Set<Promocion> promocions) {
		this.promocions = promocions;
	}

}