package mx.com.aztlan.pos.infraservices.negocio.seguridad.vo;

import java.io.Serializable;

public class LoginResponseVO implements Serializable{
        private static final long serialVersionUID = 1L;

        private String token;
        private String nombreCompletoUsuario;        
        private Integer errorCode;
        private Integer idEmpresa;
        private Integer idCanal;
        private Integer idAlmacen;
        private byte[] logoEmpresa;        
        private byte[] fotoUsuario;
        private boolean isAdminGral;
        private boolean isAdminGralEmpresa;
        private boolean isAdminCanal;        

        public LoginResponseVO(Integer idEmpresa,Integer idCanal, Integer idAlmacen, String nombreCompletoUsuario, String token, 
        		byte[] logoEmpresa, boolean isAdminGral, 
        		boolean isAdminGralEmpresa, boolean isAdminCanal){
        	this.idCanal = idCanal;
        	this.idAlmacen = idAlmacen;
        	this.idEmpresa = idEmpresa;
        	this.logoEmpresa =  logoEmpresa;
        	this.token = token;
        	this.nombreCompletoUsuario = nombreCompletoUsuario;
        	this.isAdminGral = isAdminGral;
        	this.isAdminGralEmpresa = isAdminGralEmpresa;
        	this.isAdminCanal = isAdminCanal;        	
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

		public boolean isAdminGral() {
			return isAdminGral;
		}

		public void setAdminGral(boolean isAdminGral) {
			this.isAdminGral = isAdminGral;
		}

		public boolean isAdminGralEmpresa() {
			return isAdminGralEmpresa;
		}

		public void setAdminGralEmpresa(boolean isAdminGralEmpresa) {
			this.isAdminGralEmpresa = isAdminGralEmpresa;
		}

		public boolean isAdminCanal() {
			return isAdminCanal;
		}

		public void setAdminCanal(boolean isAdminCanal) {
			this.isAdminCanal = isAdminCanal;
		}

		public Integer getIdCanal() {
			return idCanal;
		}

		public void setIdCanal(Integer idCanal) {
			this.idCanal = idCanal;
		}

		public Integer getIdAlmacen() {
			return idAlmacen;
		}

		public void setIdAlmacen(Integer idAlmacen) {
			this.idAlmacen = idAlmacen;
		}
		
		
         
}
