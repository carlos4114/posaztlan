package mx.com.tecnetia.muvitul.infraservices.persistencia;

public interface BasicDAOI
{
    public abstract void clear();
    public abstract void flush();
    public abstract void rollback();
    public abstract void commit();
    public abstract void closeSession();
    public abstract void beginTransaction();
}
