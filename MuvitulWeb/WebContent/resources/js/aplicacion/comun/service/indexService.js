'use strict';
 
angular.module('indexModule').service("IndexService", ['$http', '$q','GlobalFactory', function($http, $q, GlobalFactory) {
		
		var URI_SERVICIO = GlobalFactory.getProperty('securityPath');
		var URI_SERVICIO_MENU = URI_SERVICIO + 'seguridad/obtenerMenu';
	 	
	    var factory = {
	        obtenerMenu: obtenerMenu
	    };
	 
	    return factory;
	 
	    function obtenerMenu() {	    	
	        var deferred = $q.defer();
	        
	        $http.get(URI_SERVICIO_MENU)
	            .then(
	            function (response) {
	                deferred.resolve(response.data);
	            },
	            function(errResponse){
	                console.error('Error al obtener el menú: ',errResponse);
	                deferred.reject(errResponse);
	            }
	        );
	        return deferred.promise;
	    }
	
}]);
