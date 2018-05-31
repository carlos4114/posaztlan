package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TipoAutorizacion;

@Repository 
public class TipoAutorizacionDAO extends GlobalHibernateDAO<TipoAutorizacion> implements TipoAutorizacionDAOI {

	@Override
	public long getAutorizacionMovimiento(String correo, String contrasenia, Integer idTipoAutorizacion) {
		StringBuilder hql = new StringBuilder();
		hql.append("select count(*)  from TipoAutorizacion ta join ta.tipoAutorizacionXPerfils taxp ");
		hql.append("join taxp.perfil  prf join prf.perfilesXUsuarios pxu join pxu.usuario usr ");
		hql.append("where ta.idTipoAutorizacion=:idTipoAutorizacion and usr.correo=:correo and usr.contrasenia=:contrasenia " );

		
		/**
		select count(*) from tipo_autorizacion ta 
		join tipo_autorizacion_x_perfil tap on ta.id_tipo_autorizacion = tap.id_tipo_autorizacion
		join perfil p on tap.id_perfil = p.id_perfil join Perfiles_x_usuario pxu on p.id_perfil = pxu.id_perfil
		join usuario u on u.id_usuario = pxu.id_usuario
		where ta.id_tipo_autorizacion=2 
		and u.correo='carlos@tecnetia.com.mx' 
		and u.contrasenia='8a785a7b9ed08f73f91fbc3a658510b79969ef95'
		group by u.correo;**/
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("correo", correo);
		query.setParameter("contrasenia", contrasenia);
		query.setParameter("idTipoAutorizacion", idTipoAutorizacion);
		Long result=(Long) query.uniqueResult();
		
		if (result==null){
			return 0;
		}
		return result ;
	}
	
	@Override
	public long countAutorizacionUsrPorTipo(Integer idUsuario, Integer idTipoAutorizacion) {
		StringBuilder hql = new StringBuilder();
		hql.append("select count(*)  from TipoAutorizacion ta join ta.tipoAutorizacionXPerfils taxp ");
		hql.append("join taxp.perfil  prf join prf.perfilesXUsuarios pxu join pxu.usuario usr ");
		hql.append("where ta.idTipoAutorizacion=:idTipoAutorizacion and usr.idUsuario=:idUsuario " );

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idUsuario", idUsuario);
		query.setParameter("idTipoAutorizacion", idTipoAutorizacion);
		Long result=(Long) query.uniqueResult();
		
		if (result==null){
			return 0;
		}
		return result ;
	}


}
