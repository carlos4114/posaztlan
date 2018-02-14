package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Articulo;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.vo.ArticuloExistenciaVO;

public interface ArticuloDAOI extends GlobalHibernateDAOI<Articulo>{

	List<ArticuloExistenciaVO> getDisponible(Integer idPuntoVenta);

}
