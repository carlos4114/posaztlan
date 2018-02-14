package mx.com.aztlan.pos.negocio.taquilla.vo;

import java.math.BigDecimal;

public class PrecioXFormatoVO {
	private Integer idPrecioXFormato;
	private FormatoVO formatoVO;
	private TipoClienteVO tipoClienteVO;
	private BigDecimal precio;
	private boolean activo;

	public Integer getIdPrecioXFormato() {
		return idPrecioXFormato;
	}
	public void setIdPrecioXFormato(Integer idPrecioXFormato) {
		this.idPrecioXFormato = idPrecioXFormato;
	}
	public FormatoVO getFormatoVO() {
		return formatoVO;
	}
	public void setFormatoVO(FormatoVO formatoVO) {
		this.formatoVO = formatoVO;
	}
	public TipoClienteVO getTipoClienteVO() {
		return tipoClienteVO;
	}
	public void setTipoClienteVO(TipoClienteVO tipoClienteVO) {
		this.tipoClienteVO = tipoClienteVO;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
