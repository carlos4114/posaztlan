package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.vo;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Articulo;

public class ArticuloExistenciaVO {
	private Articulo articulo;
	private long existencia;
	
	public Articulo getArticulo() {
		return articulo;
	}
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	public long getExistencia() {
		return existencia;
	}
	public void setExistencia(long existencia) {
		this.existencia = existencia;
	}

}
