package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.Date;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.MovimientoInventario;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.vo.IngresoVO;

public interface MovimientoInventarioDAOI extends GlobalHibernateDAOI<MovimientoInventario>{
	MovimientoInventario getLastMovement(Integer idCine, Integer idArticulo);
	List<IngresoVO> findAvgPrecioArticulo(Integer idCine,Date fechaActual, int dias);
	List<IngresoVO> findAvgPrecioDiario(Integer idCine,Date fechaActual, int dias);
}
