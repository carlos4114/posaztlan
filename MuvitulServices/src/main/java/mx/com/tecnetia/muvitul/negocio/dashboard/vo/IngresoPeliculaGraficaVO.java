package mx.com.tecnetia.muvitul.negocio.dashboard.vo;

import java.util.List;

public class IngresoPeliculaGraficaVO {
	private List<String> peliculas;
	private List<IngresoPeliculaVO> ingresosPeliculaVO;
	
	public List<String> getPeliculas() {
		return peliculas;
	}
	public void setPeliculas(List<String> peliculas) {
		this.peliculas = peliculas;
	}
	public List<IngresoPeliculaVO> getIngresosPeliculaVO() {
		return ingresosPeliculaVO;
	}
	public void setIngresosPeliculaVO(List<IngresoPeliculaVO> ingresosPeliculaVO) {
		this.ingresosPeliculaVO = ingresosPeliculaVO;
	}

}
