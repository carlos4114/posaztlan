package mx.com.tecnetia.muvitul.infraservices.negocio.async.vo;

import java.io.Serializable;

public class AsyncServiceVO
    implements Serializable
{
    private static final long serialVersionUID = 1L;
    private Serializable objeto;

    public Serializable getObjeto() {
		return objeto;
	}
	public void setObjeto(Serializable objeto) {
		this.objeto = objeto;
	}    
}
