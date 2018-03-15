package mx.com.aztlan.pos.negocio.reportes.vo;

import java.io.Serializable;

public class HttpResponseOcVO implements Serializable{
        private static final long serialVersionUID = 1L;
        
        private Integer errorCode;
        private String message;
        private ArchivoExcelVO archivoExcelVO;

        public HttpResponseOcVO(){
        }
        public HttpResponseOcVO(Integer errorCode){
        	this.errorCode = errorCode;
        }
        public HttpResponseOcVO(Integer errorCode, String message){
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
		public ArchivoExcelVO getArchivoExcelVO() {
			return archivoExcelVO;
		}
		public void setArchivoExcelVO(ArchivoExcelVO archivoExcelVO) {
			this.archivoExcelVO = archivoExcelVO;
		}
		
		

         
}
