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
	private String nombreProducto;
	private String medida;
	private String tipo;
	private Integer invCantidad;
	private Double invTotal;

	private List<DetalleInventarioKardexVO> listDetalleInventarioKardexVO;



	public ReportesKardexVO(CineVO cineVO, EmpresaVO empresaVO, String emision, String periodo,
			Double valorInventarioInicial, Double valorInventarioFinal, String nombreProducto, String medida,
			String tipo, Integer invCantidad, Double invTotal,
			List<DetalleInventarioKardexVO> listDetalleInventarioKardexVO) {
		super();
		this.cineVO = cineVO;
		this.empresaVO = empresaVO;
		this.emision = emision;
		this.periodo = periodo;
		this.valorInventarioInicial = valorInventarioInicial;
		this.valorInventarioFinal = valorInventarioFinal;
		this.nombreProducto = nombreProducto;
		this.medida = medida;
		this.tipo = tipo;
		this.invCantidad = invCantidad;
		this.invTotal = invTotal;
		this.listDetalleInventarioKardexVO = listDetalleInventarioKardexVO;
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

	public Double getValorInventarioInicial() {
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

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getMedida() {
		return medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<DetalleInventarioKardexVO> getListDetalleInventarioKardexVO() {
		return listDetalleInventarioKardexVO;
	}

	public void setListDetalleInventarioKardexVO(List<DetalleInventarioKardexVO> listDetalleInventarioKardexVO) {
		this.listDetalleInventarioKardexVO = listDetalleInventarioKardexVO;
	}

	public Integer getInvCantidad() {
		return invCantidad;
	}

	public void setInvCantidad(Integer invCantidad) {
		this.invCantidad = invCantidad;
	}

	public Double getInvTotal() {
		return invTotal;
	}

	public void setInvTotal(Double invTotal) {
		this.invTotal = invTotal;
	}

}
