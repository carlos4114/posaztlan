package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.MovimientoInventario;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.vo.IngresoVO;

@Repository 
public class MovimientoInventarioDAO extends GlobalHibernateDAO<MovimientoInventario> implements MovimientoInventarioDAOI {

	@Override
	public MovimientoInventario getLastMovement(Integer idCine, Integer idArticulo) {
		StringBuilder hql = new StringBuilder();
		hql.append("select moi  from MovimientoInventario moi join moi.usuario.cine cne join moi.articulo art join moi.tipoMovimientoInv tdm ");
		hql.append("where cne.idCine=:idCine and art.idArticulo=:idArticulo " );
		hql.append("order by moi.idMovimiento desc ");

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idCine", idCine);
		query.setParameter("idArticulo", idArticulo);
		
		List<MovimientoInventario>  movimientosInventario = query.list();
		
		if (movimientosInventario!= null && !movimientosInventario.isEmpty()){
			return movimientosInventario.get(0);
		}
		
		return null;
		
	}

	@Override
	public List<IngresoVO> findAvgPrecioArticulo(Integer idCine, Date fechaActual, int dias) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("select  art.nombre as agrupador, sum(mi.importe)/sum(mi.cantidad) as total ");
		sql.append("from movimiento_inventario mi inner join articulo art ON art.id_articulo = mi.id_articulo ");
		sql.append("inner join punto_venta pv ON pv.id_punto_venta = mi.id_punto_venta ");
		sql.append("where pv.id_cine=:idCine and mi.fecha between DATE_ADD( :fechaActual , INTERVAL - :dias DAY) and  DATE_ADD(:fechaActual , INTERVAL +1 DAY) ");
		sql.append("and mi.id_tipo_movimiento=7 ");
		sql.append("group by agrupador ");

		return getSession().createSQLQuery(sql.toString()).setInteger("idCine", idCine)
				.setDate("fechaActual", fechaActual)
				.setInteger("dias", dias)
				.setResultTransformer(Transformers.aliasToBean(IngresoVO.class)).list();
	}

	@Override
	public List<IngresoVO> findAvgPrecioDiario(Integer idCine, Date fechaActual, int dias) {
		StringBuilder sql = new StringBuilder();
		sql.append("select sum(mi.importe) as total, DATE_FORMAT( DATE(mi.fecha), '%Y%m%d') as agrupador  ");
		sql.append("from movimiento_inventario mi inner join punto_venta pv ON pv.id_punto_venta = mi.id_punto_venta  ");
		sql.append("where pv.id_cine=:idCine  ");
		sql.append("and mi.fecha between DATE_ADD( :fechaActual , INTERVAL - :dias DAY) and  DATE_ADD( :fechaActual , INTERVAL +1 DAY)   ");
		sql.append("and mi.id_tipo_movimiento=7  ");
		sql.append("group by agrupador  ");
		
		return getSession().createSQLQuery(sql.toString()).setInteger("idCine", idCine)
				.setDate("fechaActual", fechaActual)
				.setInteger("dias", dias)
				.setResultTransformer(Transformers.aliasToBean(IngresoVO.class)).list();
	}

}
