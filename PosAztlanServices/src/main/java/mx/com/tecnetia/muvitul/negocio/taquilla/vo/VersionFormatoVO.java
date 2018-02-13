package mx.com.tecnetia.muvitul.negocio.taquilla.vo;

import java.util.ArrayList;
import java.util.List;

public class VersionFormatoVO {
	private String nombre;
	private List<ProgramacionVO> programaciones = new ArrayList<ProgramacionVO>();
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<ProgramacionVO> getProgramaciones() {
		return programaciones;
	}
	public void setProgramaciones(List<ProgramacionVO> programaciones) {
		this.programaciones = programaciones;
	}
	
}
