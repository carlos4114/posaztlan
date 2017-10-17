package mx.com.tecnetia.muvitul.negocio.dashboard.vo;

import java.util.List;

public class IngresoSemanalGraficaVO {
	private List<String> dias;
	private List<IngresoSemanalVO> ingresoSemanalVO;
	
	public List<String> getDias() {
		return dias;
	}

	public void setDias(List<String> dias) {
		this.dias = dias;
	}

	public List<IngresoSemanalVO> getIngresoSemanalVO() {
		return ingresoSemanalVO;
	}

	public void setIngresoSemanalVO(List<IngresoSemanalVO> ingresoSemanalVO) {
		this.ingresoSemanalVO = ingresoSemanalVO;
	}
}
