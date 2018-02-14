package mx.com.aztlan.pos.infraservices.persistencia;

import java.io.Serializable;
import java.util.List;

public interface GlobalHibernateDAOI<T> extends BasicDAOI
{

    public abstract Class<T> getPersistentClass();

    public abstract T merge( T obj ) ;

    public abstract T findById(Serializable serializable);

    public abstract T getById(Serializable serializable);

    public abstract T findById(Serializable serializable, boolean flag);

    public abstract T saveOrUpdate(T obj);

    public abstract T update(T obj);

    public abstract T save(T obj);

    public abstract void delete(T obj);

    public abstract List<T> findAll();
    
}
