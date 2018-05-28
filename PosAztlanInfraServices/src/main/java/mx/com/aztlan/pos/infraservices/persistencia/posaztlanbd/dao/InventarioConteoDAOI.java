package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.math.BigDecimal;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.InventarioConteo;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.InventarioConteoDetalle;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.OrdenCompra;

public interface InventarioConteoDAOI extends GlobalHibernateDAOI<InventarioConteo>{
		
	List<InventarioConteo> getByFolio(Integer idEmpresa, Integer folio);
}
