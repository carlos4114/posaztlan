package mx.com.aztlan.pos.infraservices.persistencia;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class BasicDAO<T> implements BasicDAOI
{
    @Autowired
    protected SessionFactory sessionFactory;
	protected final Log log = LogFactory.getLog(getClass().getName());

    public BasicDAO()
    {
    }

    public void rollback()
    {
        getSession().getTransaction().rollback();
    }

    public void commit()
    {
        getSession().getTransaction().commit();
    }

    public void beginTransaction()
    {
    	 if (getSession().getTransaction() != null && getSession().getTransaction().isActive()) {
    	        getSession().getTransaction();
    	    } else {
    	    	getSession().beginTransaction();
    	    }
    }


    protected Query getNamedQuery(String queryName)
    {
        return getSession().getNamedQuery(queryName);
    }

    public void clear()
    {
        getSession().clear();
    }

    public void flush()
    {
        getSession().flush();
    }

    public void closeSession()
    {
    	try{
    		getSession().close();
    	}catch(Exception e){

    	}
    }


    public Session getSession()
    {
        return getSessionFactory().getCurrentSession();
    }

    public SessionFactory getSessionFactory()
    {
    	  return this.sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }
}
