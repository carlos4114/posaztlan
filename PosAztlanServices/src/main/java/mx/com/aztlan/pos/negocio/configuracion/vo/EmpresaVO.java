package mx.com.aztlan.pos.negocio.configuracion.vo;

public class EmpresaVO {
	
	private Integer idEmpresa;
	private ContactoVO contactoVO;
	private EstatusEmpresaVO estatusEmpresaVO;
	private String nombre;
	private String rfc;
	private String slogan;
	private byte[] icono;
	
	public Integer getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public ContactoVO getContactoVO() {
		return contactoVO;
	}
	public void setContactoVO(ContactoVO contactoVO) {
		this.contactoVO = contactoVO;
	}
	public EstatusEmpresaVO getEstatusEmpresaVO() {
		return estatusEmpresaVO;
	}
	public void setEstatusEmpresaVO(EstatusEmpresaVO estatusEmpresaVO) {
		this.estatusEmpresaVO = estatusEmpresaVO;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getSlogan() {
		return slogan;
	}
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	public byte[] getIcono() {
		return icono;
	}
	public void setIcono(byte[] icono) {
		this.icono = icono;
	}
	
	
}

