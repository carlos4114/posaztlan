package mx.com.aztlan.pos.negocio.reportes.vo;

public class ReportesDistribuidoraVO {

	private Integer idReporteDistribuidora;
	private String nombre;
	private String rutaReporteJasper;
	private String rutaReporteXls;
	private String rutaPlantillaVm;
	private String rutaPlantillaVmError;
	
	public Integer getIdReporteDistribuidora() {
		return idReporteDistribuidora;
	}
	public void setIdReporteDistribuidora(Integer idReporteDistribuidora) {
		this.idReporteDistribuidora = idReporteDistribuidora;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRutaReporteJasper() {
		return rutaReporteJasper;
	}
	public void setRutaReporteJasper(String rutaReporteJasper) {
		this.rutaReporteJasper = rutaReporteJasper;
	}
	public String getRutaReporteXls() {
		return rutaReporteXls;
	}
	public void setRutaReporteXls(String rutaReporteXls) {
		this.rutaReporteXls = rutaReporteXls;
	}
	public String getRutaPlantillaVm() {
		return rutaPlantillaVm;
	}
	public void setRutaPlantillaVm(String rutaPlantillaVm) {
		this.rutaPlantillaVm = rutaPlantillaVm;
	}
	public String getRutaPlantillaVmError() {
		return rutaPlantillaVmError;
	}
	public void setRutaPlantillaVmError(String rutaPlantillaVmError) {
		this.rutaPlantillaVmError = rutaPlantillaVmError;
	}
	
}
