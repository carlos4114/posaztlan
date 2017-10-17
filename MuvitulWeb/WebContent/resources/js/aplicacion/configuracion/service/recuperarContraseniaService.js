'use strict';
 
angular.module('recuperarContraseniaModule').service("RecuperarContraseniaService", ['$http', '$q','GlobalFactory', function($http, $q, GlobalFactory) {
		
		var URI_SERVICIO = GlobalFactory.getProperty('securityPath');
		var URI_RECUPERAR_CONTRASENIA = URI_SERVICIO + 'seguridad/recuperarContrasenia';
	 	
	    var factory = {
	        recuperarContrasenia: recuperarContrasenia
	    };
	 
	    return factory;
	 
	    function recuperarContrasenia(usuarioLoginVO) {
	    	
	        var deferred = $q.defer();
	        
	        $http.post(URI_RECUPERAR_CONTRASENIA,usuarioLoginVO)
	            .then(
	            function (response) {
	                deferred.resolve(response.data);
	            },
	            function(errResponse){
	                console.error('Error al recuperar la contraseña: ',errResponse);
	                deferred.reject(errResponse);
	            }
	        );
	        return deferred.promise;
	    }
	
}]);
