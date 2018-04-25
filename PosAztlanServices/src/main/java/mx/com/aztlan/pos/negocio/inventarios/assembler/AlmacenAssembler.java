package mx.com.aztlan.pos.negocio.inventarios.assembler;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Almacen;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PuntoVenta;
import mx.com.aztlan.pos.negocio.configuracion.vo.AlmacenVO;
import mx.com.aztlan.pos.negocio.dulceria.assembler.CineAssembler;
import mx.com.aztlan.pos.negocio.dulceria.vo.PuntoVentaVO;

public class AlmacenAssembler {

	public static Almacen getAlmacen(Integer idAlmacen){

		if(idAlmacen==null )
			return null;

		Almacen almacen= new Almacen();
		almacen.setIdAlmacen(idAlmacen);
		
		return almacen;
	}
	
	public static Almacen getAlmacen(AlmacenVO almacenVO) {
		if(almacenVO == null )
			return null;
		
		Almacen almacen= new Almacen();
		almacen.setIdAlmacen(almacenVO.getIdAlmacen());
		almacen.setNombre(almacenVO.getNombre());
		
		return almacen;
	}
	
	public static AlmacenVO getAlmacenVO(Almacen almacen) {
		if(almacen == null )
			return null;
		
		AlmacenVO almacenVO= new AlmacenVO();
		almacenVO.setIdAlmacen(almacen.getIdAlmacen());
		almacenVO.setNombre(almacen.getNombre());
		
		return almacenVO;
	}
	
}
