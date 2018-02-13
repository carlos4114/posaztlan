package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.AsientosXSala;
import mx.com.tecnetia.muvitul.infraservices.persistencia.utileria.business.FechasUtilsBO;

@Repository 
public class AsientosXSalaDAO extends GlobalHibernateDAO<AsientosXSala> implements AsientosXSalaDAOI {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AsientosXSala> getActivos(Integer idSala) {

		Criteria criteria = getSession().createCriteria(AsientosXSala.class);
		
		criteria.add(Restrictions.eq("activo", true));
		criteria.add(Restrictions.eq("sala.idSala", idSala));
		criteria.addOrder(Order.asc("fila"));
		criteria.addOrder(Order.asc("posicion"));
		
		return criteria.list();

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String getMaxFila(Integer idSala) {

		Query query = getSession().createQuery("select max(fila) from AsientosXSala where sala.idSala = :idSala ");
		query.setParameter("idSala", idSala);
		List<String> filas = query.list();
				
		return filas.size()<=0?null:filas.get(0);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Integer getMaxNoAsientos(Integer idSala) {

		Query query = getSession().createQuery("select max(numeroAsiento) from AsientosXSala where sala.idSala = :idSala ");
		query.setParameter("idSala", idSala);
		List<Integer> filas = query.list();
				
		return filas.size()<=0?null:filas.get(0);
	}

	
	@Override
	public void actualizarEstatus(Integer idSala, boolean activo) {
		Query query = getSession().createQuery("update AsientosXSala "
				+ " set activo = :activo " +
				" ,ultimaActualizacion = :ultimaActualizacion " +				
				" where sala.idSala = :idSala");
		query.setParameter("activo", activo);
		query.setParameter("ultimaActualizacion", FechasUtilsBO.getCurrentDate());
		query.setParameter("idSala", idSala);
		int result = query.executeUpdate();
	}	
	
}
