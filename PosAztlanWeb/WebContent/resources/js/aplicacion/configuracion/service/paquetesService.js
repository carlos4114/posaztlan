'use strict';
 
angular.module('indexModule').service("PaquetesService", ['$http', '$q','GlobalFactory','config', 
   function($http, $q, GlobalFactory, config) {
		
		var URI_SERVICIO = config.baseUrl;
		var URI_OBTENER_CINES = URI_SERVICIO + "/catalogo/cinesEmpresa";
		var URI_OBTENER_PUNTOS_VENTA = URI_SERVICIO + "/catalogo/puntosVentaDulceria";
		var URI_OBTENER_PAQUETES = URI_SERVICIO + "/paquetes/obtener";
		var URI_OBTENER_PRODUCTOS = URI_SERVICIO + "/productos/obtener";
		var URI_ACTUALIZAR_PAQUETE = URI_SERVICIO + "/paquetes/actualizar";
		var URI_GUARDAR_PAQUETE = URI_SERVICIO + "/paquetes/guardar";
		
	    var factory = {
	        consultaCinesXEmpresa: consultaCinesXEmpresa,
	        consultaPuntosVentaXCine: consultaPuntosVentaXCine,
	        obtenerProductos: obtenerProductos,
	        obtenerPaquetes: obtenerPaquetes,
	        actualizarPaquete: actualizarPaquete,
	        guardarPaquete: guardarPaquete
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

	 
	    function guardarPaquete(paqueteVO) {	    	
	        return invocarServicioPost(URI_GUARDAR_PAQUETE,paqueteVO);	    				 	        
	    }
	    
	    function actualizarPaquete(paqueteVO) {
	        return invocarServicioPost(URI_ACTUALIZAR_PAQUETE,paqueteVO);	    				 	        
	    }
	    
	    function obtenerProductos(idCine) {
	    	
	        return invocarServicioGet(URI_OBTENER_PRODUCTOS+"/"+idCine);	    				 	        
	    }
	    
	    function obtenerPaquetes(idCine) {
	    	
	        return invocarServicioGet(URI_OBTENER_PAQUETES+"/"+idCine);	    				 	        
	    }

	    function consultaCinesXEmpresa(idEmpresa){
	        return invocarServicioGet(URI_OBTENER_CINES+"/"+idEmpresa);	    				 
		 }
	    
	    function consultaPuntosVentaXCine(idCine){		    	    		        
	        return invocarServicioGet(URI_OBTENER_PUNTOS_VENTA+"/"+idCine);
		 }
	    
}]);
