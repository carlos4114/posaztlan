'use strict';

angular.module('loginModule').service('LoginService', ['$http','GlobalFactory', function($http, GlobalFactory) {
	
	var URI_SERVICIO = GlobalFactory.getProperty('securityPath');
 	var URI_SERVICIO_LOGIN = URI_SERVICIO + 'seguridad/autenticar';
 	
 	var factory = {
 	        login: login        
 	    };
	
   	 return factory;
   	 
   	 
     function login(username,pwd) {
        	
            return $http.post(URI_SERVICIO_LOGIN, {usuario: username, contrasenia: pwd}).then(function(response) {
                return response.data;
            });
     }
    
}]);
