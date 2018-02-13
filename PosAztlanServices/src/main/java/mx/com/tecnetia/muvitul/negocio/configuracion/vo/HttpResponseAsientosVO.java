package mx.com.tecnetia.muvitul.negocio.configuracion.vo;

import java.io.Serializable;
import java.util.List;

public class HttpResponseAsientosVO implements Serializable{
        private static final long serialVersionUID = 1L;
        
        private Integer errorCode;
        private String message;
        private List<List<AsientoVO>> mapaAsientos;
        
        public HttpResponseAsientosVO(){
        }
        public HttpResponseAsientosVO(Integer errorCode){
        	this.errorCode = errorCode;
        }
        public HttpResponseAsientosVO(Integer errorCode, String message){
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
		public List<List<AsientoVO>> getMapaAsientos() {
			return mapaAsientos;
		}
		public void setMapaAsientos(List<List<AsientoVO>> mapaAsientos) {
			this.mapaAsientos = mapaAsientos;
		}

         
}
