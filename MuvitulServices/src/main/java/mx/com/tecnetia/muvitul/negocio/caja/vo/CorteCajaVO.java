
package mx.com.tecnetia.muvitul.negocio.caja.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import mx.com.tecnetia.muvitul.negocio.configuracion.vo.RequestAutorizacionVO;

@Component
@Scope("prototype")
public class CorteCajaVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer idCorteCaja;
	private Date fecha;
	private BigDecimal efectivoReal;
	private BigDecimal efectivoSistema;
	private String comentarios;
	private String cajero;
	private Integer idAutorizacion;
	private RequestAutorizacionVO autorizacionVO;
	private String caja;
	private BigDecimal entradaCaja;
	private Integer idCargoAjuste;
	private String cargoAjuste;
	private String usuarioAutorizador;
	
	public Integer getIdCorteCaja() {
		return idCorteCaja;
	}
	public void setIdCorteCaja(Integer idCorteCaja) {
		this.idCorteCaja = idCorteCaja;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public BigDecimal getEfectivoReal() {
		return efectivoReal;
	}
	public void setEfectivoReal(BigDecimal efectivoReal) {
		this.efectivoReal = efectivoReal;
	}
	public BigDecimal getEfectivoSistema() {
		return efectivoSistema;
	}
	public void setEfectivoSistema(BigDecimal efectivoSistema) {
		this.efectivoSistema = efectivoSistema;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public RequestAutorizacionVO getAutorizacionVO() {
		return autorizacionVO;
	}
	public void setAutorizacionVO(RequestAutorizacionVO autorizacionVO) {
		this.autorizacionVO = autorizacionVO;
	}
	public String getCaja() {
		return caja;
	}
	public void setCaja(String caja) {
		this.caja = caja;
	}
	public BigDecimal getEntradaCaja() {
		return entradaCaja;
	}
	public void setEntradaCaja(BigDecimal entradaCaja) {
		this.entradaCaja = entradaCaja;
	}
	public String getCargoAjuste() {
		return cargoAjuste;
	}
	public void setCargoAjuste(String cargoAjuste) {
		this.cargoAjuste = cargoAjuste;
	}
	public Integer getIdCargoAjuste() {
		return idCargoAjuste;
	}
	public void setIdCargoAjuste(Integer idCargoAjuste) {
		this.idCargoAjuste = idCargoAjuste;
	}
	public String getCajero() {
		return cajero;
	}
	public void setCajero(String cajero) {
		this.cajero = cajero;
	}
	public String getUsuarioAutorizador() {
		return usuarioAutorizador;
	}
	public void setUsuarioAutorizador(String usuarioAutorizador) {
		this.usuarioAutorizador = usuarioAutorizador;
	}
	public Integer getIdAutorizacion() {
		return idAutorizacion;
	}
	public void setIdAutorizacion(Integer idAutorizacion) {
		this.idAutorizacion = idAutorizacion;
	}
	
	
}
