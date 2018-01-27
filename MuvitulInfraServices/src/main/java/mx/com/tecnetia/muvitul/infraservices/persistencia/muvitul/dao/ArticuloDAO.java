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
		hql.append("select art as articulo, (select sum(inv2.existenciaActual) from Inventario inv2 join inv2.articulo art2 join inv2.puntoVenta pv2 join inv2.tipoMovimientoInv tmi2 where art2.idArticulo= art.idArticulo and pv2.idPuntoVenta =:idPuntoVenta and tmi2.esEntrada = 1  ) as existencia  ");
		hql.append("from Inventario inv join inv.articulo art join inv.puntoVenta pv join inv.tipoMovimientoInv tmi ");
		hql.append("where pv.idPuntoVenta =:idPuntoVenta ");
		hql.append("and tmi.esEntrada = 1 ");
		hql.append("and inv.existenciaActual >= 1 ");
		hql.append("group by inv.articulo ");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idPuntoVenta", idPuntoVenta);
		
		return query.setResultTransformer(Transformers.aliasToBean(ArticuloExistenciaVO.class)).list();

	}
	
}