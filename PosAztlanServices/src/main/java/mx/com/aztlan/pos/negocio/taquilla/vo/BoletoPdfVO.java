package mx.com.aztlan.pos.negocio.taquilla.vo;

public class BoletoPdfVO {
	
 	private String fecha;
 	private String nombreCine;
 	private String tituloPelicula;
 	private String horarioFuncion;
 	private String numSala;
 	private String tipoBoleto;
 	private String asiento;
 	private String clasificacion;
 	private String butaca;
 	private Integer folio;

 	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getNombreCine() {
		return nombreCine;
	}
	public void setNombreCine(String nombreCine) {
		this.nombreCine = nombreCine;
	}
	public String getTituloPelicula() {
		return tituloPelicula;
	}
	public void setTituloPelicula(String tituloPelicula) {
		this.tituloPelicula = tituloPelicula;
	}
	public String getHorarioFuncion() {
		return horarioFuncion;
	}
	public void setHorarioFuncion(String horarioFuncion) {
		this.horarioFuncion = horarioFuncion;
	}
	public String getNumSala() {
		return numSala;
	}
	public void setNumSala(String numSala) {
		this.numSala = numSala;
	}
	public String getTipoBoleto() {
		return tipoBoleto;
	}
	public void setTipoBoleto(String tipoBoleto) {
		this.tipoBoleto = tipoBoleto;
	}
	public String getAsiento() {
		return asiento;
	}
	public void setAsiento(String asiento) {
		this.asiento = asiento;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	public String getButaca() {
		return butaca;
	}
	public void setButaca(String butaca) {
		this.butaca = butaca;
	}
	public Integer getFolio() {
		return folio;
	}
	public void setFolio(Integer folio) {
		this.folio = folio;
	}
	
	 
}
