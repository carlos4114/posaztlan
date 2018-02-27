package mx.com.aztlan.pos.negocio.configuracion.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ImpuestoVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer idImpuesto;
	private String nombre;	
	private BigDecimal porcentaje;
	private boolean activo;
	
	public Integer getIdImpuesto() {
		return idImpuesto;
	}
	public void setIdImpuesto(Integer idImpuesto) {
		this.idImpuesto = idImpuesto;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public BigDecimal getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(BigDecimal porcentaje) {
		this.porcentaje = porcentaje;
	}
	
}
