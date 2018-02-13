package mx.com.tecnetia.muvitul.negocio.reportes.business;

import java.util.ArrayList;

public class SalaVO {
	private Integer idSala;
	private String nombreSala;
	private ArrayList<Data> datos;

	public SalaVO(Integer idSala, String nombreSala, ArrayList<Data> datos) {
		super();
		this.idSala = idSala;
		this.nombreSala = nombreSala;
		this.datos = datos;
	}

	public Integer getIdSala() {
		return idSala;
	}

	public void setIdSala(Integer idSala) {
		this.idSala = idSala;
	}

	public String getNombreSala() {
		return nombreSala;
	}

	public void setNombreSala(String nombreSala) {
		this.nombreSala = nombreSala;
	}

	public ArrayList<Data> getDatos() {
		return datos;
	}

	public void setDatos(ArrayList<Data> datos) {
		this.datos = datos;
	}

}
