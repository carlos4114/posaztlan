package mx.com.aztlan.pos.infraservices.negocio.seguridad.vo;

import java.io.Serializable;

public class LoginResponseVO implements Serializable{
        private static final long serialVersionUID = 1L;

        private String token;
        private String nombreCompletoUsuario;        
        private Integer errorCode;
        private Integer idEmpresa;
        private byte[] logoEmpresa;        
        private byte[] fotoUsuario;

        public LoginResponseVO(Integer idEmpresa, String nombreCompletoUsuario, String token, byte[] logoEmpresa){
        	this.idEmpresa = idEmpresa;
        	this.logoEmpresa =  logoEmpresa;
        	this.token = token;
        	this.nombreCompletoUsuario = nombreCompletoUsuario;
        }
        
        public LoginResponseVO(String nombreCompletoUsuario, String token, byte[] logoEmpresa, byte[] fotoUsuario){
        	this.logoEmpresa =  logoEmpresa;
        	this.fotoUsuario = fotoUsuario;
        	this.token = token;
        	this.nombreCompletoUsuario = nombreCompletoUsuario;
        }
        
        public LoginResponseVO(String nombreCompletoUsuario, String token){
        	this.token = token;
        	this.nombreCompletoUsuario = nombreCompletoUsuario;
        }
        
        public LoginResponseVO(String token){
        	this.token = token;
        }
        public LoginResponseVO(Integer errorCode){
        	this.errorCode = errorCode;
        }
        
        
		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public Integer getErrorCode() {
			return errorCode;
		}

		public void setErrorCode(Integer errorCode) {
			this.errorCode = errorCode;
		}

		public String getNombreCompletoUsuario() {
			return nombreCompletoUsuario;
		}

		public void setNombreCompletoUsuario(String nombreCompletoUsuario) {
			this.nombreCompletoUsuario = nombreCompletoUsuario;
		}

		public byte[] getLogoEmpresa() {
			return logoEmpresa;
		}

		public void setLogoEmpresa(byte[] logoEmpresa) {
			this.logoEmpresa = logoEmpresa;
		}

		public byte[] getFotoUsuario() {
			return fotoUsuario;
		}

		public void setFotoUsuario(byte[] fotoUsuario) {
			this.fotoUsuario = fotoUsuario;
		}

		public Integer getIdEmpresa() {
			return idEmpresa;
		}

		public void setIdEmpresa(Integer idEmpresa) {
			this.idEmpresa = idEmpresa;
		}
		
		
         
}
