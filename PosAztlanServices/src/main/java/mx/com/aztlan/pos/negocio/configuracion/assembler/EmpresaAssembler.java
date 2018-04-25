package mx.com.aztlan.pos.negocio.configuracion.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Empresa;
import mx.com.aztlan.pos.negocio.configuracion.vo.CatalogoVO;

public class EmpresaAssembler {

	public static CatalogoVO getCatalogoVO(Empresa empresa){
		if(empresa==null)
			return null;
		
		CatalogoVO catalogoVO = new CatalogoVO();
		catalogoVO.setId(empresa.getIdEmpresa());
		catalogoVO.setNombre(empresa.getNombre());
		
		return catalogoVO;
	}
	
	
	public static List<CatalogoVO> getCatalogoEmpresas(List<Empresa> empresas){
		
		if(empresas==null || empresas.isEmpty())
			return null;
		
		List<CatalogoVO> empresasVO = new ArrayList<CatalogoVO>();
		
		for (Empresa empresa: empresas) {
			empresasVO.add(EmpresaAssembler.getCatalogoVO(empresa));
		}

		return empresasVO;
		
	}

	
}
