package mx.com.tecnetia.muvitul.negocio.configuracion.vo;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class DetallePromocionVO {
	private Integer idDetallePromocion;
	private ProductoVO productoVO;
	private RegaloVO regaloVO;
	private Integer varN;
	private Integer varM;
	private BigDecimal precio;
	private BigDecimal porcentaje;

	public Integer getIdDetallePromocion() {
		return idDetallePromocion;
	}
	public void setIdDetallePromocion(Integer idDetallePromocion) {
		this.idDetallePromocion = idDetallePromocion;
	}
	public ProductoVO getProductoVO() {
		return productoVO;
	}
	public void setProductoVO(ProductoVO productoVO) {
		this.productoVO = productoVO;
	}
	public RegaloVO getRegaloVO() {
		return regaloVO;
	}
	public void setRegaloVO(RegaloVO regaloVO) {
		this.regaloVO = regaloVO;
	}
	public Integer getVarN() {
		return varN;
	}
	public void setVarN(Integer varN) {
		this.varN = varN;
	}
	public Integer getVarM() {
		return varM;
	}
	public void setVarM(Integer varM) {
		this.varM = varM;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public BigDecimal getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(BigDecimal porcentaje) {
		this.porcentaje = porcentaje;
	}

}
