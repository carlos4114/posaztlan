package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Articulo;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.vo.ArticuloExistenciaVO;

public interface ArticuloDAOI extends GlobalHibernateDAOI<Articulo>{

	List<ArticuloExistenciaVO> getDisponible(Integer idPuntoVenta);

}
