package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TipoMovimientoInv;

@Repository 
public class TipoMovimientoInvDAO extends GlobalHibernateDAO<TipoMovimientoInv> implements TipoMovimientoInvDAOI {

	@Override
	public TipoMovimientoInv findById(Integer id){
		StringBuilder hql = new StringBuilder();
		hql.append("select tmi from TipoMovimientoInv tmi  ");
		hql.append("where tmi.idTipoMovimientoInv=:id and tmi.activo=1 ");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("id", id);
		
		List<TipoMovimientoInv>  tipoMovimientosInv = query.list();
		
		if (tipoMovimientosInv!= null && !tipoMovimientosInv.isEmpty()){
			return tipoMovimientosInv.get(0);
		}
		
		return null;
	}
	
	@Override
	public TipoMovimientoInv findByClave(String clave) {
		StringBuilder hql = new StringBuilder();
		hql.append("select tmi from TipoMovimientoInv tmi  ");
		hql.append("where tmi.clave=:clave and tmi.activo=1 ");
		hql.append("order by tmi.idTipoMovimientoInv desc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("clave", clave);
		
		List<TipoMovimientoInv>  tipoMovimientosInv = query.list();
		
		if (tipoMovimientosInv!= null && !tipoMovimientosInv.isEmpty()){
			return tipoMovimientosInv.get(0);
		}
		
		return null;
		
	}
	
	@Override
	public TipoMovimientoInv findByClaveIsEntrada(String clave,Boolean esEntrada) {
		StringBuilder hql = new StringBuilder();
		hql.append("select tmi from TipoMovimientoInv tmi  ");
		hql.append("where tmi.clave=:clave and tmi.esEntrada=:esEntrada and tmi.activo=1 ");
		hql.append("order by tmi.idTipoMovimientoInv desc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("clave", clave);
		query.setParameter("esEntrada", esEntrada);
		
		List<TipoMovimientoInv>  tipoMovimientosInv = query.list();
		
		if (tipoMovimientosInv!= null && !tipoMovimientosInv.isEmpty()){
			return tipoMovimientosInv.get(0);
		}
		
		return null;
		
	}
	
	@Override
	public List<TipoMovimientoInv> findByIsEntrada(Boolean esEntrada) {
		StringBuilder hql = new StringBuilder();
		hql.append("select tmi from TipoMovimientoInv tmi  ");
		hql.append("where tmi.esEntrada=:esEntrada and tmi.activo=1 ");
		hql.append("order by tmi.idTipoMovimientoInv desc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("esEntrada", esEntrada);
		
		List<TipoMovimientoInv>  tipoMovimientosInv = query.list();
		
		return tipoMovimientosInv;
		
	}

	@Override
	public List<TipoMovimientoInv> findByTypeClave(String clave) {
		StringBuilder hql = new StringBuilder();
		hql.append("select tmi from TipoMovimientoInv tmi  ");
		hql.append("where tmi.catalogo like :clave and tmi.activo=1 ");
		hql.append("order by tmi.idTipoMovimientoInv desc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("clave", clave+"%");
		
		List<TipoMovimientoInv>  tipoMovimientosInv = query.list();
		
		return tipoMovimientosInv;
		
	}
	
}
