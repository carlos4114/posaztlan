package mx.com.aztlan.pos.negocio.reportes.vo;

import java.io.Serializable;
import java.util.List;

import mx.com.aztlan.pos.negocio.configuracion.vo.EmpresaVO;
import mx.com.aztlan.pos.negocio.taquilla.vo.CineVO;

public class TaquillaVentaVO implements Serializable {
	 private EmpresaVO empresaVO;
	 private CineVO cineVO;
	 private List<SalaVO> listaSalaVO;
	 
	 
	public TaquillaVentaVO() {
		super();
	}
	public TaquillaVentaVO(EmpresaVO empresaVO, CineVO cineVO, List<SalaVO> listaSalaVO) {
		super();
		this.empresaVO = empresaVO;
		this.cineVO = cineVO;
		this.listaSalaVO = listaSalaVO;
	}
	public EmpresaVO getEmpresaVO() {
		return empresaVO;
	}
	public void setEmpresaVO(EmpresaVO empresaVO) {
		this.empresaVO = empresaVO;
	}
	public CineVO getCineVO() {
		return cineVO;
	}
	public void setCineVO(CineVO cineVO) {
		this.cineVO = cineVO;
	}
	public List<SalaVO> getListaSalaVO() {
		return listaSalaVO;
	}
	public void setListaSalaVO(List<SalaVO> listaSalaVO) {
		this.listaSalaVO = listaSalaVO;
	}
 
	 
	 
	 
}
