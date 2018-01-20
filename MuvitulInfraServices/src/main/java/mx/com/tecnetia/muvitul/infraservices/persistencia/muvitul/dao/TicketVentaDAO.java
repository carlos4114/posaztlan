package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TicketVenta;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.vo.IngresoVO;

@Repository
public class TicketVentaDAO extends GlobalHibernateDAO<TicketVenta> implements TicketVentaDAOI {

//	@Override
//	public TicketVenta findByTickedAndTipoVenta(Integer idTicket, Integer idTipoPuntoVenta) {
//		StringBuilder hql = new StringBuilder();
//		hql.append("select tdv  from TicketVenta tdv join tdv.puntoVenta pdv join pdv.tipoPuntoVenta tpv ");
//		hql.append("where tdv.idTicket=:idTicket and tpv.idTipoPuntoVenta=:idTipoPuntoVenta ");
//		hql.append("order by tdv.idTicket desc ");
//
//		Query query = getSession().createQuery(hql.toString());
//		query.setParameter("idTicket", idTicket);
//		query.setParameter("idTipoPuntoVenta", idTipoPuntoVenta);
//		List<TicketVenta> result = query.list();
//
//		if (!result.isEmpty()) {
//			return result.get(0);
//		}
//
//		return null;
//	}

	@Override
	public TicketVenta findByCineAndTipoVenta2(Integer idCine, Integer idTicket, Integer idTipoPuntoVenta) {
		StringBuilder hql = new StringBuilder();
		hql.append("select tdv  from TicketVenta tdv join tdv.puntoVenta pdv join pdv.tipoPuntoVenta tpv ");
		hql.append("join pdv.cine cne ");
		hql.append("where tdv.idTicket=:idTicket and cne.idCine=:idCine and tpv.idTipoPuntoVenta=:idTipoPuntoVenta ");
		hql.append("order by tdv.idTicket desc ");

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idTicket", idTicket);
		query.setParameter("idCine", idCine);
		query.setParameter("idTipoPuntoVenta", idTipoPuntoVenta);
		List<TicketVenta> result = query.list();

		if (!result.isEmpty()) {
			return result.get(0);
		}

		return null;
	}

	
	@Override
	public TicketVenta findByCineOfTaquilla(Integer idCine, Integer idTicket) {
		StringBuilder hql = new StringBuilder();
		hql.append("select tdv  from TicketVenta tdv join tdv.puntoVenta pdv ");
		hql.append("join pdv.cine cne ");				
		hql.append("where tdv.idTicket=:idTicket and cne.idCine=:idCine ");
		hql.append("and exists (from BoletosXTicket as bt where bt.ticketVenta=tdv) ");
		hql.append("order by tdv.idTicket desc ");

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idTicket", idTicket);
		query.setParameter("idCine", idCine);
		List<TicketVenta> result = query.list();

		if (!result.isEmpty()) {
			return result.get(0);
		}

		return null;
	}
	
	@Override
	public TicketVenta findByCineOfDulceria(Integer idCine, Integer idTicket) {
		StringBuilder hql = new StringBuilder();
		hql.append("select tdv  from TicketVenta tdv join tdv.puntoVenta pdv ");
		hql.append("join pdv.cine cne ");
		hql.append("where tdv.idTicket=:idTicket and cne.idCine=:idCine ");
		hql.append("and (exists (from PaquetesXTicket as pa where pa.ticketVenta=tdv) or exists (from ProductosXTicket as pr where pr.ticketVenta=tdv)) ");
			hql.append("order by tdv.idTicket desc ");

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idTicket", idTicket);
		query.setParameter("idCine", idCine);
		List<TicketVenta> result = query.list();

		if (!result.isEmpty()) {
			return result.get(0);
		}

		return null;
	}
	
	
	@Override
	public List<IngresoVO> getIngresosDiarios2(Integer idCine, Date fechaActual, int dias, String clavePuntoVenta) {
		StringBuilder sql = new StringBuilder();
		sql.append("select SUM(tv.total)-SUM(tv.descuento) as total, DATE_FORMAT( DATE(tv.fecha), '%Y%m%d') as agrupador ");
		sql.append("from ticket_venta tv inner join punto_venta pv ON pv.id_punto_venta = tv.id_punto_venta ");
		sql.append("inner join tipo_punto_venta tpv ON tpv.id_tipo_punto_venta = pv.id_tipo_punto_venta ");
		sql.append("where pv.id_cine=:idCine ");
		sql.append("and tv.fecha between DATE_ADD( :fechaActual , INTERVAL - :dias DAY) and  DATE_ADD( :fechaActual , INTERVAL +1 DAY) ");
		sql.append("and tpv.clave=:clavePuntoVenta ");
		sql.append("group by agrupador ");

		return getSession().createSQLQuery(sql.toString()).setInteger("idCine", idCine)
				.setDate("fechaActual", fechaActual).setInteger("dias", dias)
				.setString("clavePuntoVenta", clavePuntoVenta)
				.setResultTransformer(Transformers.aliasToBean(IngresoVO.class)).list();
	}
	
	@Override
	public List<IngresoVO> getIngresosDiariosDeDulceria(Integer idCine, Date fechaActual, int dias) {
		StringBuilder sql = new StringBuilder();
		sql.append("select SUM(tv.total)-SUM(tv.descuento) as total, DATE_FORMAT( DATE(tv.fecha), '%Y%m%d') as agrupador ");
		sql.append("from ticket_venta tv inner join punto_venta pv ON pv.id_punto_venta = tv.id_punto_venta ");
		sql.append("where pv.id_cine=:idCine ");
		sql.append("and ( ");
		sql.append("EXISTS (SELECT 1 "); 
		sql.append("FROM   productos_x_ticket prxt ");
		sql.append("WHERE  prxt.id_ticket = tv.id_ticket) ");
		sql.append("or EXISTS (SELECT 1 ");
		sql.append("FROM   paquetes_x_ticket paxt ");
		sql.append("WHERE  paxt.id_ticket = tv.id_ticket) ");
		sql.append(") ");
		sql.append("and tv.fecha between DATE_ADD( :fechaActual , INTERVAL - :dias DAY) and  DATE_ADD( :fechaActual , INTERVAL +1 DAY) ");
		sql.append("group by agrupador ");

		return getSession().createSQLQuery(sql.toString()).setInteger("idCine", idCine)
				.setDate("fechaActual", fechaActual).setInteger("dias", dias)
				.setResultTransformer(Transformers.aliasToBean(IngresoVO.class)).list();
	}
	
	@Override
	public List<IngresoVO> getIngresosDiariosDeTaquilla(Integer idCine, Date fechaActual, int dias) {
		StringBuilder sql = new StringBuilder();
		sql.append("select SUM(tv.total)-SUM(tv.descuento) as total, DATE_FORMAT( DATE(tv.fecha), '%Y%m%d') as agrupador ");
		sql.append("from ticket_venta tv inner join punto_venta pv ON pv.id_punto_venta = tv.id_punto_venta ");
		sql.append("where pv.id_cine=:idCine ");
		sql.append("and  EXISTS (SELECT 1 ");		
		sql.append("FROM   boletos_x_ticket bxt ");
		sql.append("WHERE  bxt.id_ticket = tv.id_ticket) ");
		sql.append("and tv.fecha between DATE_ADD( :fechaActual , INTERVAL - :dias DAY) and  DATE_ADD( :fechaActual , INTERVAL +1 DAY) ");
		sql.append("group by agrupador ");

		return getSession().createSQLQuery(sql.toString()).setInteger("idCine", idCine)
				.setDate("fechaActual", fechaActual).setInteger("dias", dias)
				.setResultTransformer(Transformers.aliasToBean(IngresoVO.class)).list();
	}

	@Override
	public List<IngresoVO> getIngresosPeliculas(Integer idCine, int noSemana) {
		StringBuilder sql = new StringBuilder();
		sql.append("select plc.titulo as agrupador, SUM(bxt.importe)- SUM(bxt.descuento) as total ");
		sql.append("from boletos_x_ticket bxt inner join ticket_venta tv ON tv.id_ticket = bxt.id_ticket ");
		sql.append("inner join punto_venta pv ON pv.id_punto_venta = tv.id_punto_venta ");
		sql.append("inner join programacion pgr ON pgr.id_programacion = bxt.id_programacion ");
		sql.append("inner join pelicula plc  ON plc.id_pelicula = pgr.id_pelicula ");
		sql.append("where pv.id_cine=:idCine and tv.fecha and WEEK(tv.fecha)=:noSemana ");
		sql.append("group by plc.titulo ");
		sql.append("order by plc.titulo asc ");

		return getSession().createSQLQuery(sql.toString()).setInteger("idCine", idCine).setInteger("noSemana", noSemana)
				.setResultTransformer(Transformers.aliasToBean(IngresoVO.class)).list();
	}

	
	@Override
	public List<IngresoVO> getIngresosPeliculas(Integer idCine) {
		StringBuilder sql = new StringBuilder();
		sql.append("select plc.titulo as agrupador, SUM(bxt.importe) as total ");
		sql.append("from boletos_x_ticket bxt inner join ticket_venta tv ON tv.id_ticket = bxt.id_ticket ");
		sql.append("inner join punto_venta pv ON pv.id_punto_venta = tv.id_punto_venta ");
		sql.append("inner join programacion pgr ON pgr.id_programacion = bxt.id_programacion ");
		sql.append("inner join pelicula plc  ON plc.id_pelicula = pgr.id_pelicula ");
		sql.append("where pv.id_cine=:idCine and tv.fecha and WEEK(tv.fecha) in (WEEK (now()),WEEK (now())-1) ");
		sql.append("group by plc.titulo ");
		sql.append("order by plc.titulo asc ");

		return getSession().createSQLQuery(sql.toString()).setInteger("idCine", idCine)
				.setResultTransformer(Transformers.aliasToBean(IngresoVO.class)).list();
	}
	
	@Override
	public List<IngresoVO> getAsistencia(Integer idCine, Date fechaActual, int semanas) {
		StringBuilder sql = new StringBuilder();
		sql.append("select  SUM(bxt.cantidad) as total, pgr.dia_semana as agrupador ");
		sql.append("from boletos_x_ticket bxt inner join ticket_venta tv ON tv.id_ticket = bxt.id_ticket  ");
		sql.append("inner join punto_venta pv ON pv.id_punto_venta = tv.id_punto_venta ");
		sql.append("inner join programacion pgr ON pgr.id_programacion = bxt.id_programacion  ");
		sql.append("where pv.id_cine=:idCine ");
		sql.append("and tv.fecha between DATE_ADD(:fechaActual , INTERVAL - :semanas * 7 DAY) and  DATE_ADD(:fechaActual , INTERVAL +1 DAY) ");
		sql.append("group by pgr.dia_semana ");
		sql.append("order by pgr.dia_semana asc ");

		return getSession().createSQLQuery(sql.toString()).setInteger("idCine", idCine)
				.setDate("fechaActual", fechaActual).setInteger("semanas", semanas)
				.setResultTransformer(Transformers.aliasToBean(IngresoVO.class)).list();
	}


}
