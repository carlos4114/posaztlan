package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ProductosXTicket;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.vo.ProductoCostoVO;

@Repository 
public class ProductoXTicketDAO extends GlobalHibernateDAO<ProductosXTicket> implements ProductoXTicketDAOI {

	@Override
	public List<ProductosXTicket> findByTicket(Integer idTicket, Integer idTipoPuntoVenta) {
		StringBuilder hql = new StringBuilder();
		hql.append("select pxt from ProductosXTicket pxt join pxt.ticketVenta tv join pxt.producto pdt ");
		hql.append("where tv.idTicket=:idTicket ");
		hql.append("order by pdt.idProducto asc ");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idTicket", idTicket);
		return 	query.list();
	}

	@Override
	public List<ProductoCostoVO> getPrecioPromedio(Integer idCine,Date startDate, Date endDate, int dias) {
		StringBuilder hql = new StringBuilder();
		
		hql.append("select pxt.producto as producto, cast( sum(pxt.cantidad) as int ) as cantidad, ");
		hql.append("cast (sum(pxt.importe) / sum(pxt.cantidad) as big_decimal) as importe, ");
		hql.append("cast (sum(pxt.cantidad) / count(tv.idTicket) as big_decimal)  as unidadXTicket ");
		hql.append("from ProductosXTicket  pxt join pxt.producto ");
		hql.append("join pxt.ticketVenta tv ");
		hql.append("join tv.puntoVenta pv ");
		//hql.append("join pv.tipoPuntoVenta tpv ");
		hql.append("join pv.cine cne ");
		hql.append("where cne.idCine=:idCine ");
		hql.append("and tv.fecha between :startDate and :endDate ");
		//hql.append("and tpv.clave='DUL-001' ");
		hql.append("group by pxt.producto ");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idCine", idCine);
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);
		return  query.setResultTransformer(Transformers.aliasToBean(ProductoCostoVO.class)).list();

	}


}
