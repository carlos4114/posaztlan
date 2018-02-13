'use strict';
 
angular.module('indexModule').service("CambiarContraseniaService", ['$http', '$q','GlobalFactory', function($http, $q, GlobalFactory) {
		
		var URI_SERVICIO = GlobalFactory.getProperty('securityPath');
		var URI_CAMBIAR_CONTRASENIA = URI_SERVICIO + 'seguridad/cambiarContrasenia';
	 	
	    var factory = {
	        cambiarContrasenia: cambiarContrasenia
	    };
	 
	    return factory;
	 
	    function cambiarContrasenia(cambioContraseniaVO) {
	    	
	        var deferred = $q.defer();
	        
	        $http.post(URI_CAMBIAR_CONTRASENIA,cambioContraseniaVO)
	            .then(
	            function (response) {
	                deferred.resolve(response.data);
	            },
	            function(errResponse){	                
	                deferred.reject(errResponse);
	            }
	        );
	        return deferred.promise;
	    }
	
}]);
