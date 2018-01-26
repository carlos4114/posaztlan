package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Articulo;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.vo.ArticuloExistenciaVO;

@Repository 
public class ArticuloDAO extends GlobalHibernateDAO<Articulo> implements ArticuloDAOI {

	@Override
	public List<ArticuloExistenciaVO> getDisponible(Integer idPuntoVenta) {

		StringBuilder hql = new StringBuilder();
		hql.append("select art as articulo, inv.existenciaActual as existencia ");
		hql.append("from Inventario inv join inv.articulo art join inv.puntoVenta pv ");
		hql.append("where pv.idPuntoVenta =:idPuntoVenta ");
		hql.append("and inv.existenciaActual >= 1 ");
		hql.append("group by inv.articulo ");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idPuntoVenta", idPuntoVenta);
		
		return query.setResultTransformer(Transformers.aliasToBean(ArticuloExistenciaVO.class)).list();

	}
	
}