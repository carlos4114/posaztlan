package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.AsistenciaXSala;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.enumeration.EstatusAsientoEnum;

@Repository 
public class AsistenciaXSalaDAO extends GlobalHibernateDAO<AsistenciaXSala> implements AsistenciaXSalaDAOI {

	@Override
	public void borrarPorTicket(Integer idTicket) {
		Query query = getSession().createQuery("delete AsistenciaXSala "+
				" where ticketVenta.idTicket = :idTicket ");
		query.setParameter("idTicket", idTicket);	
		
		query.executeUpdate();
	}	
	
	@Override
	public void borrarReservadosUsuario(Integer idUsuario) {
		Query query = getSession().createQuery("delete AsistenciaXSala "+
				" where usuario.idUsuario = :idUsuario and estatusAsiento.idEstatusAsiento=:idEstatusAsiento ");
		query.setParameter("idUsuario", idUsuario);	
		query.setParameter("idEstatusAsiento", EstatusAsientoEnum.RESERVADO);	
		
		query.executeUpdate();
	}	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AsistenciaXSala> getByTicket(Integer idTicket){
		Criteria criteria = getSession().createCriteria(AsistenciaXSala.class);
		
		criteria.add(Restrictions.eq("ticketVenta.idTicket", idTicket));
		
		return criteria.list();
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AsistenciaXSala> getActivos(Integer idProgramacion, Date fechaExhibicion) {

		Criteria criteria = getSession().createCriteria(AsistenciaXSala.class);
		
		criteria.add(Restrictions.eq("fechaExhibicion", fechaExhibicion));
		criteria.add(Restrictions.eq("programacion.idProgramacion", idProgramacion));
		criteria.add(Restrictions.eq("asientosXSala.activo", true));
		criteria.addOrder(Order.asc("asientosXSala.fila"));
		criteria.addOrder(Order.asc("asientosXSala.numeroAsiento"));
		
		return criteria.list();

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AsistenciaXSala> getWithEstatus(Integer idProgramacion, Date fechaExhibicion, Integer idUsuario, Integer idEstatusAsiento) {

		Criteria criteria = getSession().createCriteria(AsistenciaXSala.class);
		
		criteria.add(Restrictions.eq("fechaExhibicion", fechaExhibicion));
		criteria.add(Restrictions.eq("programacion.idProgramacion", idProgramacion));
		criteria.add(Restrictions.eq("usuario.idUsuario", idUsuario));
		criteria.add(Restrictions.eq("estatusAsiento.idEstatusAsiento", idEstatusAsiento));
		
		return criteria.list();

	}
}
