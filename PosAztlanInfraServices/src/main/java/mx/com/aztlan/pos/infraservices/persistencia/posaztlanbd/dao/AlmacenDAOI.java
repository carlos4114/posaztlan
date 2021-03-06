package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Almacen;

public interface AlmacenDAOI extends GlobalHibernateDAOI<Almacen>{
	List<Almacen> findByIdCanal(Integer idCanal);
	List<Almacen> findSubAlmacenesByIdCanal(Integer idCanal);
	Integer getAlmacenCentral(Integer idEmpresa);
	List<Almacen> findByAlmacenPadre(Integer idAlmacen);
	List<Almacen> findByIdEmpresa(Integer idEmpresa);
}
