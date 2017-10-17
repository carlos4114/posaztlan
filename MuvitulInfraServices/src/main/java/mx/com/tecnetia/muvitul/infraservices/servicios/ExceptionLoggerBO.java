package mx.com.tecnetia.muvitul.infraservices.servicios;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ExceptionLoggerBO {
	private static final Log logger = LogFactory.getLog(ExceptionLoggerBO.class);
	
	private CorreroElectronicoBO correoElectronicoLoggerBO;

	public void handleException(Throwable throwable) {
		if (!(throwable instanceof BusinessGlobalException)) {
			logger.error("*********** Interceptando excepción dentro de la aplicación: -------> " + new java.util.Date());
			logger.error("\n*********** ERROR **************: ---->" + throwable.getMessage());

			StringBuffer body = new StringBuffer("");
			try {
				body.append("<br>Surgió un error en la aplicación: ").append(new java.util.Date());
				body.append("<br><br>********  ERROR ************** ");
				body.append("<br><br>").append("Mensaje --> ").append(throwable.getMessage());
				body.append("<br><br>").append("Causa --> ");
				logger.error("*********** CAUSA **************: ---->");
				for (int i = 0; i < throwable.getStackTrace().length; i++) {
					body.append("<br>").append(throwable.getStackTrace()[i]);
					logger.error("\n" + throwable.getStackTrace()[i]);
				}

				//correoElectronicoLoggerBO.setSubject(".:: PROBLEMA EN EL SISTEMA ::.");
				correoElectronicoLoggerBO.setBody(body.toString());
				correoElectronicoLoggerBO.sendMail();

			} catch (Exception e) {
				logger.error("*********** Error al mandar Correo Electrónico de la falla: -------> " + new java.util.Date());
				logger.error("\n*********** ERROR **************: ---->" + e.getMessage());
				for (int i = 0; i < e.getStackTrace().length; i++) {
					logger.error(e.getStackTrace()[i] + "\n");
				}
			}
		}
	}

	public void setCorreoElectronicoLoggerBO(CorreroElectronicoBO correoElectronicoLoggerBO) {
		this.correoElectronicoLoggerBO = correoElectronicoLoggerBO;
	}
	
	
}
