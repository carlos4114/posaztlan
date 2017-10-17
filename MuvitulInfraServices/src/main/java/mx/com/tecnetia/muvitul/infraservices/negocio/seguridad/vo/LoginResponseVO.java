package mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo;

import java.io.Serializable;

public class LoginResponseVO implements Serializable{
        private static final long serialVersionUID = 1L;

        private String token;
        private Integer errorCode;

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

         
}
