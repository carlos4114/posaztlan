package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ImpuestoXProducto;

public interface ImpuestoXProductoDAOI extends GlobalHibernateDAOI<ImpuestoXProducto>{
	List<ImpuestoXProducto> findByIdCineAndIdProducto(Integer idCine, Integer IdProducto);
}
