'use strict';
 
angular.module('indexModule').service("UsuariosService", ['$http', '$q','GlobalFactory', function($http, $q, GlobalFactory) {
		
		var URI_SERVICIO = GlobalFactory.getProperty('securityPath');
		var URI_NUEVO_USUARIO = URI_SERVICIO + 'seguridad/guardarUsuarioNuevo';
		var URI_ACTUALIZAR_USUARIO = URI_SERVICIO + 'seguridad/actualizarUsuario';
		var URI_OBTENER_USUARIOS = URI_SERVICIO + 'seguridad/obtenerUsuarios';
				 	
	    var factory = {
	        guardarUsuarioNuevo: guardarUsuarioNuevo,
	        actualizarUsuario: actualizarUsuario,
	        obtenerUsuarios: obtenerUsuarios
	    };
	 
	    return factory;
	 
	    function guardarUsuarioNuevo(usuarioVO) {
	    	
	        var deferred = $q.defer();
	        
	        $http.post(URI_NUEVO_USUARIO,usuarioVO)
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
	    
	    function actualizarUsuario(usuarioVO) {
	    	
	        var deferred = $q.defer();
	        
	        $http.post(URI_ACTUALIZAR_USUARIO,usuarioVO)
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
	    
	    function obtenerUsuarios(idCine) {
	    	
	        var deferred = $q.defer();
	        
	        $http.get(URI_OBTENER_USUARIOS+"/"+idCine)
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
