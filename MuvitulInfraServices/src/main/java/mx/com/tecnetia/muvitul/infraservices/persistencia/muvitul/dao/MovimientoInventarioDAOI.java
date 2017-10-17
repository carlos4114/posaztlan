package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.Date;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.MovimientoInventario;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.vo.IngresoVO;

public interface MovimientoInventarioDAOI extends GlobalHibernateDAOI<MovimientoInventario>{
	MovimientoInventario getLastMovement(Integer idCine, Integer idArticulo);
	List<IngresoVO> findAvgPrecioArticulo(Integer idCine,Date fechaActual, int dias);
	List<IngresoVO> findAvgPrecioDiario(Integer idCine,Date fechaActual, int dias);
}
