package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ImpuestoXProducto;

public interface ImpuestoXProductoDAOI extends GlobalHibernateDAOI<ImpuestoXProducto>{
	List<ImpuestoXProducto> findByIdEmpresaAndIdProducto(Integer idEmpresa, Integer IdProducto);
	
	List<ImpuestoXProducto> findByIdEmpresa(Integer idEmpresa);
	
    List<ImpuestoXProducto> findByIdProducto(Integer idProducto);
}
