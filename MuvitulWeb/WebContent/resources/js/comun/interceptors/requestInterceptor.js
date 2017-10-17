 
angular.module("indexModule").factory("requestInterceptor", function ($q, $location,blockUI) {
	return {
		request : function(config) {
			if (config.url.match("devolucion/boletos")) {
	           // blockUI.stop();
		    }
	        
 
			return config;
		} 
	}
});
