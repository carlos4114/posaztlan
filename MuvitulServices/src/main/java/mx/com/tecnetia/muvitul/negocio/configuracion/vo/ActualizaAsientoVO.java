package mx.com.tecnetia.muvitul.negocio.configuracion.vo;

import java.util.List;

public class ActualizaAsientoVO {
	private List<List<AsientoVO>> asientosVOList;
	private AsientoVO asientoVO;
	public List<List<AsientoVO>> getAsientosVOList() {
		return asientosVOList;
	}
	public void setAsientosVOList(List<List<AsientoVO>> asientosVOList) {
		this.asientosVOList = asientosVOList;
	}
	public AsientoVO getAsientoVO() {
		return asientoVO;
	}
	public void setAsientoVO(AsientoVO asientoVO) {
		this.asientoVO = asientoVO;
	}	
	
	
}
