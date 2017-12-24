'use strict';
 
angular.module('indexModule').service("UsuariosService", ['$http', '$q','GlobalFactory','config', 
   function($http, $q, GlobalFactory, config) {
		
		var URI_SERVICIO = config.baseUrl;
		var URI_SERVICIO_SEGURIDAD = config.baseSeguridadUrl;
		var URI_NUEVO_USUARIO = URI_SERVICIO_SEGURIDAD + '/seguridad/guardarUsuarioNuevo';
		var URI_ACTUALIZAR_USUARIO = URI_SERVICIO_SEGURIDAD + '/seguridad/actualizarUsuario';
		var URI_OBTENER_USUARIOS = URI_SERVICIO_SEGURIDAD + '/seguridad/obtenerUsuarios';
		var URI_OBTENER_PERFILES = URI_SERVICIO_SEGURIDAD + '/seguridad/obtenerPerfiles';
		var URI_OBTENER_CINES = URI_SERVICIO + "/catalogo/cinesEmpresa"
		var URI_OBTENER_PUNTOS_VENTA = URI_SERVICIO + "/catalogo/puntosVenta"
				 	
	    var factory = {
	        guardarUsuarioNuevo: guardarUsuarioNuevo,
	        actualizarUsuario: actualizarUsuario,
	        obtenerUsuarios: obtenerUsuarios,
	        consultaCinesXEmpresa: consultaCinesXEmpresa,
	        consultaPerfilesXEmpresa: consultaPerfilesXEmpresa,
	        consultaPuntosVentaXCine: consultaPuntosVentaXCine
	    };
	 
	    return factory;
	    
	    function invocarServicioGet(URI){
		    
	    	var deferred = $q.defer();
	        
	        $http.get(URI)
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


	    function invocarServicioPost(URI,jsonVO){
		    
	    	var deferred = $q.defer();
	        
	    	$http.post(URI,jsonVO)
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

	 
	    function guardarUsuarioNuevo(usuarioVO) {	    	
	        return invocarServicioPost(URI_NUEVO_USUARIO,usuarioVO);	    				 	        
	    }
	    
	    function actualizarUsuario(usuarioVO) {
	        return invocarServicioPost(URI_ACTUALIZAR_USUARIO,usuarioVO);	    				 	        
	    }
	    
	    function obtenerUsuarios(idCine) {
	    	
	        return invocarServicioGet(URI_OBTENER_USUARIOS+"/"+idCine);	    				 	        
	    }
	    
	    function consultaCinesXEmpresa(idEmpresa){
	        return invocarServicioGet(URI_OBTENER_CINES+"/"+idEmpresa);	    				 
		 }

	    function consultaPerfilesXEmpresa(idEmpresa){		    	    		        
	        return invocarServicioGet(URI_OBTENER_PERFILES+"/"+idEmpresa);
		 }
	    
	    function consultaPuntosVentaXCine(idCine){		    	    		        
	        return invocarServicioGet(URI_OBTENER_PUNTOS_VENTA+"/"+idCine);
		 }
	    
	   
	    
}]);
