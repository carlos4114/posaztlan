package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Perfil;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TipoAutorizacionXPerfil;

@Repository 
public class TipoAutorizacionXPerfilDAO extends GlobalHibernateDAO<TipoAutorizacionXPerfil> implements TipoAutorizacionXPerfilDAOI {

	@Override
	public List<TipoAutorizacionXPerfil> findByTipoAndPerfiles(Integer idTipoAutorizacion, List<Perfil> perfiles) {
		StringBuilder hql = new StringBuilder();
		hql.append("select taxp from TipoAutorizacionXPerfil taxp join taxp.tipoAutorizacion ta ");
		hql.append("where ta.idTipoAutorizacion=:idTipoAutorizacion and taxp.perfil in (:perfiles) " );

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idTipoAutorizacion", idTipoAutorizacion);
		query.setParameterList("perfiles", perfiles);
		
		List<TipoAutorizacionXPerfil> result=query.list();
		
		return result;
		
	}



}
