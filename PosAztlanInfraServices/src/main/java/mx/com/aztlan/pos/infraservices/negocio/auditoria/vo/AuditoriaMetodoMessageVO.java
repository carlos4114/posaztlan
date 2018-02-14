package mx.com.aztlan.pos.infraservices.negocio.auditoria.vo;

import java.io.Serializable;

public class AuditoriaMetodoMessageVO
    implements Serializable
{

	private static final long serialVersionUID = 1L;
    private Integer idUsuario;
    private Integer idClase;
    private Serializable atributos[];
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Integer getIdClase() {
		return idClase;
	}
	public void setIdClase(Integer idClase) {
		this.idClase = idClase;
	}
	public Serializable[] getAtributos() {
		return atributos;
	}
	public void setAtributos(Serializable[] atributos) {
		this.atributos = atributos;
	}
    
}
