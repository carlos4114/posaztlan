package mx.com.aztlan.pos.negocio.configuracion.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Almacen;
import mx.com.aztlan.pos.negocio.configuracion.vo.AlmacenVO;

public class AlmacenAssembler {


	public static AlmacenVO getAlmacenVO(Almacen almacen) {
		if(almacen == null )
			return null;
		
		AlmacenVO almacenVO= new AlmacenVO();
		
		almacenVO.setIdAlmacen(almacen.getIdAlmacen());
		almacenVO.setCanalVO(CanalAssembler.getCanalVO(almacen.getCanal()));
		almacenVO.setTipoAlmacenVO(TipoAlmacenAssembler.getTipoAlmacenVO(almacen.getTipoAlmacen()));
		almacenVO.setNombre(almacen.getNombre());
		
		return almacenVO;
	}
	
	
	public static List<AlmacenVO> getAlmacenesVO(List<Almacen> almacenes){

		if(almacenes==null || almacenes.isEmpty())
			return null;
		
		List<AlmacenVO> almacenesVO = new ArrayList<AlmacenVO>();
		
		for (Almacen almacen : almacenes) {
			almacenesVO.add(AlmacenAssembler.getAlmacenVO(almacen));
		}

		return almacenesVO;
	}
	
	public static List<AlmacenVO> getAlmacenesXEmpresaVO(List<Almacen> almacenes){

		if(almacenes==null || almacenes.isEmpty())
			return null;
		
		List<AlmacenVO> almacenesVO = new ArrayList<AlmacenVO>();
		
		for (Almacen almacen : almacenes) {
			almacenesVO.add(AlmacenAssembler.getAlmacenXEmpresaVO(almacen));
		}

		return almacenesVO;
	}

	public static AlmacenVO getAlmacenXEmpresaVO(Almacen almacen) {
		if(almacen == null )
			return null;
		
		AlmacenVO almacenVO= new AlmacenVO();
		
		almacenVO.setIdAlmacen(almacen.getIdAlmacen());
		almacenVO.setCanalVO(CanalAssembler.getCanalVO(almacen.getCanal()));
		almacenVO.setTipoAlmacenVO(TipoAlmacenAssembler.getTipoAlmacenVO(almacen.getTipoAlmacen()));
		almacenVO.setNombre(almacen.getCanal() ==null?almacen.getNombre():almacen.getCanal().getNombre().concat(" - ").concat(almacen.getNombre()));
		
		
		return almacenVO;
	}
	
}
