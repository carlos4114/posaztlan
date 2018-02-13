package mx.com.tecnetia.muvitul.negocio.reportes.vo;

import java.io.Serializable;
import java.util.List;

import mx.com.tecnetia.muvitul.negocio.configuracion.vo.EmpresaVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.CineVO;

public class ReportesKardexVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private CineVO cineVO;
	private EmpresaVO empresaVO;
	private String emision;
	private String periodo;
	private Double valorInventarioInicial;
	private Double valorInventarioFinal;

	private List<ProductoVO> listProductosVO;

	public ReportesKardexVO() {
		super();
	}

	public ReportesKardexVO(CineVO cineVO, EmpresaVO empresaVO, String emision, String periodo,
			Double valorInventarioInicial, Double valorInventarioFinal ) {
		super();
		this.cineVO = cineVO;
		this.empresaVO = empresaVO;
		this.emision = emision;
		this.periodo = periodo;
		this.valorInventarioInicial = valorInventarioInicial;
		this.valorInventarioFinal = valorInventarioFinal;
 	}

	public CineVO getCineVO() {
		return cineVO;
	}

	public void setCineVO(CineVO cineVO) {
		this.cineVO = cineVO;
	}

	public EmpresaVO getEmpresaVO() {
		return empresaVO;
	}

	public void setEmpresaVO(EmpresaVO empresaVO) {
		this.empresaVO = empresaVO;
	}

	public String getEmision() {
		return emision;
	}

	public void setEmision(String emision) {
		this.emision = emision;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public Double rutaKardex() {
		return valorInventarioInicial;
	}

	public void setValorInventarioInicial(Double valorInventarioInicial) {
		this.valorInventarioInicial = valorInventarioInicial;
	}

	public Double getValorInventarioFinal() {
		return valorInventarioFinal;
	}

	public void setValorInventarioFinal(Double valorInventarioFinal) {
		this.valorInventarioFinal = valorInventarioFinal;
	}

	public List<ProductoVO> getListProductosVO() {
		return listProductosVO;
	}

	public void setListProductosVO(List<ProductoVO> listProductosVO) {
		this.listProductosVO = listProductosVO;
	}

}
