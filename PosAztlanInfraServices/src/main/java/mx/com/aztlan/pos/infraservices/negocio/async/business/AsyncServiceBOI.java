package mx.com.aztlan.pos.infraservices.negocio.async.business;

import java.io.Serializable;

import mx.com.aztlan.pos.infraservices.negocio.async.vo.AsyncServiceVO;

public interface AsyncServiceBOI
    extends Serializable
{

    public abstract void executeService(AsyncServiceVO asyncserviceparameters);
}
