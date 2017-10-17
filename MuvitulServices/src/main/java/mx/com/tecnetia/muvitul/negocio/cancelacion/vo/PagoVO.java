package mx.com.tecnetia.muvitul.negocio.cancelacion.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import mx.com.tecnetia.muvitul.servicios.util.DateStringToDateDeserializer;
import mx.com.tecnetia.muvitul.servicios.util.DateToDateStringSerializer;

public class PagoVO {
	private Integer idPago;
	private FormaPagoVO formaPagoVO;
	private String noCuenta;
	private BigDecimal importe;
	private EstatusPagoVO estatusPagoVO;
	@JsonDeserialize(using = DateStringToDateDeserializer.class)
	@JsonSerialize(using = DateToDateStringSerializer.class)
	private Date fecha;
	
	public Integer getIdPago() {
		return idPago;
	}
	public void setIdPago(Integer idPago) {
		this.idPago = idPago;
	}
	public FormaPagoVO getFormaPagoVO() {
		return formaPagoVO;
	}
	public void setFormaPagoVO(FormaPagoVO formaPagoVO) {
		this.formaPagoVO = formaPagoVO;
	}
	public String getNoCuenta() {
		return noCuenta;
	}
	public void setNoCuenta(String noCuenta) {
		this.noCuenta = noCuenta;
	}
	public BigDecimal getImporte() {
		return importe;
	}
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	public EstatusPagoVO getEstatusPagoVO() {
		return estatusPagoVO;
	}
	public void setEstatusPagoVO(EstatusPagoVO estatusPagoVO) {
		this.estatusPagoVO = estatusPagoVO;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
		
}
