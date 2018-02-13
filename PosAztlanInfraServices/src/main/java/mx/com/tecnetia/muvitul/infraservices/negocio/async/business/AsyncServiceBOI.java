package mx.com.tecnetia.muvitul.infraservices.negocio.async.business;

import java.io.Serializable;

import mx.com.tecnetia.muvitul.infraservices.negocio.async.vo.AsyncServiceVO;

public interface AsyncServiceBOI
    extends Serializable
{

    public abstract void executeService(AsyncServiceVO asyncserviceparameters);
}
