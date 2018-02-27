package mx.com.aztlan.pos.negocio.configuracion.vo;

public class AlmacenVO {
	private Integer idAlmacen;
	private CanalVO canalVO;
	private TipoAlmacenVO tipoAlmacenVO;
	private String nombre;
	
	public Integer getIdAlmacen() {
		return idAlmacen;
	}
	public void setIdAlmacen(Integer idAlmacen) {
		this.idAlmacen = idAlmacen;
	}
	public CanalVO getCanalVO() {
		return canalVO;
	}
	public void setCanalVO(CanalVO canalVO) {
		this.canalVO = canalVO;
	}
	public TipoAlmacenVO getTipoAlmacenVO() {
		return tipoAlmacenVO;
	}
	public void setTipoAlmacenVO(TipoAlmacenVO tipoAlmacenVO) {
		this.tipoAlmacenVO = tipoAlmacenVO;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
