
package mx.com.aztlan.pos.infraservices.negocio.seguridad.vo;

import java.io.File;
import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class UsuarioVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer idUsuario;
	private String correo;
	private String correoConfirma;
	private String contrasenia;
	private String nombre;
	private String paterno;
	private String materno;
	private Integer idEstatus;
	private String estatus;
	private Integer idPerfil;
	private String perfil;
	private Integer idPuntoVenta;
	private String puntoVenta;
	private Integer idCine;
	private Integer idCaja;
	private File foto;
	
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPaterno() {
		return paterno;
	}
	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}
	public String getMaterno() {
		return materno;
	}
	public void setMaterno(String materno) {
		this.materno = materno;
	}
	public Integer getIdEstatus() {
		return idEstatus;
	}
	public void setIdEstatus(Integer idEstatus) {
		this.idEstatus = idEstatus;
	}
	public String getCorreoConfirma() {
		return correoConfirma;
	}
	public void setCorreoConfirma(String correoConfirma) {
		this.correoConfirma = correoConfirma;
	}
	public Integer getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}
	public Integer getIdPuntoVenta() {
		return idPuntoVenta;
	}
	public void setIdPuntoVenta(Integer idPuntoVenta) {
		this.idPuntoVenta = idPuntoVenta;
	}
	public File getFoto() {
		return foto;
	}
	public void setFoto(File foto) {
		this.foto = foto;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Integer getIdCine() {
		return idCine;
	}
	public void setIdCine(Integer idCine) {
		this.idCine = idCine;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public String getPuntoVenta() {
		return puntoVenta;
	}
	public void setPuntoVenta(String puntoVenta) {
		this.puntoVenta = puntoVenta;
	}
	public Integer getIdCaja() {
		return idCaja;
	}
	public void setIdCaja(Integer idCaja) {
		this.idCaja = idCaja;
	}
	
	
	
	
}
