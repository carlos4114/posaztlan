package mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo;

import java.io.Serializable;
import java.util.List;

public class HttpResponseVO implements Serializable{
        private static final long serialVersionUID = 1L;
        
        private Integer errorCode;
        private String message;

        public HttpResponseVO(){
        }
        public HttpResponseVO(Integer errorCode){
        	this.errorCode = errorCode;
        }
        public HttpResponseVO(Integer errorCode, String message){
        	this.message = message;
        	this.errorCode = errorCode;
        }       

		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public Integer getErrorCode() {
			return errorCode;
		}

		public void setErrorCode(Integer errorCode) {
			this.errorCode = errorCode;
		}

         
}
