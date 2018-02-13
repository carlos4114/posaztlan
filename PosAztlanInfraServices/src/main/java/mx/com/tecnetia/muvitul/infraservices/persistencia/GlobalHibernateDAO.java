package mx.com.tecnetia.muvitul.infraservices.persistencia;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.*;

import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.stereotype.Component;

@Component
public abstract class GlobalHibernateDAO<T> extends BasicDAO<T> implements GlobalHibernateDAOI<T>
{
    private Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public GlobalHibernateDAO()
    {
        persistentClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected ClassMetadata getClassMetadata()
    {
        return getSessionFactory().getClassMetadata(getPersistentClass());
    }

    public T findById(Serializable id)
    {
        return findById(id, false);
    }

    @SuppressWarnings("unchecked")
	public T findById(Serializable id, boolean lock)
    {
        T entity;
        if(lock)
            entity = (T) getSession().load(getPersistentClass(), id, LockOptions.UPGRADE);
        else
            entity = (T) getSession().load(getPersistentClass(), id);
        return entity;
    }

    @SuppressWarnings("unchecked")
	public T getById(Serializable id)
    {
        return (T) getSession().get(getPersistentClass(), id);
    }

	public List<T> findAll()
    {
        return (List<T>) findByCriteria(new Criterion[0]);
    }

    @SuppressWarnings("unchecked")
	protected List<T> findByCriteria(Criterion criterion[])
    {
        Criteria criteria = createCriteria();
        Criterion acriterion[];
        int j = (acriterion = criterion).length;
        for(int i = 0; i < j; i++)
        {
            Criterion c = acriterion[i];
            if(c != null)
                criteria.add(c);
        }

        return (List<T>) criteria.list();
    }

    @SuppressWarnings("unchecked")
	protected List<T> findByCriteria(Criterion criterion[], List<Order> orders)
    {
        Criteria criteria = createCriteria();
        Criterion acriterion[];
        int j = (acriterion = criterion).length;
        for(int i = 0; i < j; i++)
        {
            Criterion c = acriterion[i];
            if(c != null)
                criteria.add(c);
        }

        for(Iterator<Order> iterator = orders.iterator(); iterator.hasNext();)
        {
            Order o = iterator.next();
            if(o != null)
                criteria.addOrder(o);
        }

        return (List<T>) criteria.list();
    }

    @SuppressWarnings("unchecked")
	public List<T> findByExample(T exampleInstance, String excludeProperty[])
    {
        Criteria criteria = createCriteria();
        Example example = Example.create(exampleInstance);
        String as[];
        int j = (as = excludeProperty).length;
        for(int i = 0; i < j; i++)
        {
            String exclude = as[i];
            example.excludeProperty(exclude);
        }

        criteria.add(example);
        return (List<T>) criteria.list();
    }


    public Class<T> getPersistentClass()
    {
        return persistentClass;
    }

    public T saveOrUpdate(T entity)
    {
        getSession().saveOrUpdate(entity);
        return entity;
    }

    public T merge(T entity)
    {
        getSession().merge(entity);
        return entity;
    }

    public T update(T entity)
    {
        getSession().update(entity);
        return entity;
    }

    public T save(T entity)
    {
        getSession().save(entity);
        return entity;
    }

    public void delete(T entity)
    {
        getSession().delete(entity);
    }

    public Criteria createCriteria()
    {
        return getSession().createCriteria(getPersistentClass());
    }


}
