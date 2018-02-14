package mx.com.aztlan.pos.negocio.inventarios.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Proveedor;
import mx.com.aztlan.pos.negocio.inventarios.vo.ProveedorVO;
import mx.com.aztlan.pos.negocio.taquilla.assembler.CineAssembler;

public class ProveedorAssembler {

	public static Proveedor getPuntoVenta(Integer idProveedor){

		if(idProveedor==null )
			return null;

		Proveedor proveedor= new Proveedor();
		proveedor.setIdProveedor(idProveedor);
		
		return proveedor;
	}

	public static Proveedor getProveedor(ProveedorVO proveedorVO) {
		if(proveedorVO == null )
			return null;
		
		Proveedor proveedor= new Proveedor();
		proveedor.setIdProveedor(proveedorVO.getIdProveedor());
		//proveedor.setCineVO(CineAssembler.getCine(proveedorVO.getCineVO()));
		proveedor.setNombre(proveedorVO.getNombre());
		proveedor.setRazonSocial(proveedorVO.getRazonSocial());
		proveedor.setRfc(proveedorVO.getRfc());
		
		return proveedor;
	}
	
	public static ProveedorVO getProveedorVO(Proveedor proveedor) {
		if(proveedor == null )
			return null;
		
		ProveedorVO proveedorVO= new ProveedorVO();
		proveedorVO.setIdProveedor(proveedor.getIdProveedor());
		proveedorVO.setCineVO(CineAssembler.getCineVO(proveedor.getCine()));
		proveedorVO.setNombre(proveedor.getNombre());
		proveedorVO.setRazonSocial(proveedor.getRazonSocial());
		proveedorVO.setRfc(proveedor.getRfc());
		
		
		return proveedorVO;
	}
	
	public static List<ProveedorVO> getProveedoresVO(List<Proveedor> proveedores){

		if(proveedores==null || proveedores.isEmpty())
			return null;
		
		List<ProveedorVO> porveedoresVO = new ArrayList<ProveedorVO>();
		
		for (Proveedor proveedor : proveedores) {
			porveedoresVO.add(ProveedorAssembler.getProveedorVO(proveedor));
		}

		return porveedoresVO;
	}	
	
}
