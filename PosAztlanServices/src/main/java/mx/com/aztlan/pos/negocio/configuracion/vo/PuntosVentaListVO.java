package mx.com.aztlan.pos.negocio.configuracion.vo;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PuntosVentaListVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer idCine;
	private List<Integer> puntosVentaList;
	public Integer getIdCine() {
		return idCine;
	}
	public void setIdCine(Integer idCine) {
		this.idCine = idCine;
	}
	public List<Integer> getPuntosVentaList() {
		return puntosVentaList;
	}
	public void setPuntosVentaList(List<Integer> puntosVentaList) {
		this.puntosVentaList = puntosVentaList;
	}
	
	
	
}
