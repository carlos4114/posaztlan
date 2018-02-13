package mx.com.tecnetia.muvitul.negocio.inventarios.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.AutorizacionMovimiento;
import mx.com.tecnetia.muvitul.negocio.dulceria.assembler.MovimientoInventarioAssembler;
import mx.com.tecnetia.muvitul.negocio.inventarios.vo.AutorizacionMovimientoVO;

public class AutorizacionMovimientoAssembler {

	public static AutorizacionMovimiento getAutorizacionMovimiento(Integer idAutorizacionMovimiento){

		if(idAutorizacionMovimiento==null )
			return null;

		AutorizacionMovimiento autorizacionMovimiento= new AutorizacionMovimiento();
		//autorizacionMovimiento.setIdAutorizacionMovimiento(idAutorizacionMovimiento);
		
		return autorizacionMovimiento;
	}
	
	public static AutorizacionMovimientoVO getAutorizacionMovimientoVO(AutorizacionMovimiento autorizacionMovimiento) {
		if(autorizacionMovimiento == null )
			return null;
		
		AutorizacionMovimientoVO autorizacionMovimientoVO = new AutorizacionMovimientoVO();
//		autorizacionMovimientoVO.setIdAutorizacionMovimiento(autorizacionMovimiento.getIdAutorizacionMovimiento());
//		autorizacionMovimientoVO.setMovimientoInventarioVO(MovimientoInventarioAssembler.getMovimientoInventarioVO(autorizacionMovimiento.getMovimientoInventario()));
//		autorizacionMovimientoVO.setUsuario(autorizacionMovimiento.getUsuario());
//		autorizacionMovimientoVO.setFecha(autorizacionMovimiento.getFecha());
//		autorizacionMovimientoVO.setComentarios(autorizacionMovimiento.getComentarios());	
		
		return autorizacionMovimientoVO;
	}
	
	public static List<AutorizacionMovimientoVO> getProveedoresVO(List<AutorizacionMovimiento> autorizacionesMovimiento){

		if(autorizacionesMovimiento==null || autorizacionesMovimiento.isEmpty())
			return null;
		
		List<AutorizacionMovimientoVO> autorizacionesMovimientoVO = new ArrayList<AutorizacionMovimientoVO>();
		
		for (AutorizacionMovimiento autorizacionMovimiento : autorizacionesMovimiento) {
			autorizacionesMovimientoVO.add(AutorizacionMovimientoAssembler.getAutorizacionMovimientoVO(autorizacionMovimiento));
		}

		return autorizacionesMovimientoVO;
	}	
	
}
