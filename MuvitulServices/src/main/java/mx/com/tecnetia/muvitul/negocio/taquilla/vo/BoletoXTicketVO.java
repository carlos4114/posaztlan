package mx.com.tecnetia.muvitul.negocio.taquilla.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import mx.com.tecnetia.muvitul.servicios.util.DateStringToDateDeserializer;
import mx.com.tecnetia.muvitul.servicios.util.DateToDateStringSerializer;

public class BoletoXTicketVO {
	private ProgramacionVO programacionVO;
	private TipoClienteVO tipoClienteVO;
	private int cantidad;
	private BigDecimal importe;
	@JsonDeserialize(using = DateStringToDateDeserializer.class)
	@JsonSerialize(using = DateToDateStringSerializer.class)
	private Date fechaExhibicion;
	
	public ProgramacionVO getProgramacionVO() {
		return programacionVO;
	}
	public void setProgramacionVO(ProgramacionVO programacionVO) {
		this.programacionVO = programacionVO;
	}
	public TipoClienteVO getTipoClienteVO() {
		return tipoClienteVO;
	}
	public void setTipoClienteVO(TipoClienteVO tipoClienteVO) {
		this.tipoClienteVO = tipoClienteVO;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getImporte() {
		return importe;
	}
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	public Date getFechaExhibicion() {
		return fechaExhibicion;
	}
	public void setFechaExhibicion(Date fechaExhibicion) {
		this.fechaExhibicion = fechaExhibicion;
	}
	
}
