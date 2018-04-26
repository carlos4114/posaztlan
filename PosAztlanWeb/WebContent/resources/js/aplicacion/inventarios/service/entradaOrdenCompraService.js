'use strict';
 
angular.module('indexModule').service("EntradaOrdenCompraService", ['$http', '$q','GlobalFactory','config', 
   function($http, $q, GlobalFactory, config) {
		
		var URI_SERVICIO = config.baseUrl;		
		var URI_OBTENER_ORDEN_COMPRA = URI_SERVICIO + "/ordenesCompra/obtenerOrdenCompra";
		var URI_GUARDAR_ENTRADA_ORDEN_COMPRA = URI_SERVICIO + "/inventario/entradaOrdenCompra";
		
	    var factory = {
	    	obtenerOrdenCompra: obtenerOrdenCompra,
	    	registrarEntradaOrdenCompra:registrarEntradaOrdenCompra
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


	    function obtenerOrdenCompra(filtrosVO) {
	    	
	        return invocarServicioPost(URI_OBTENER_ORDEN_COMPRA, filtrosVO);	    				 	        
	    }
	    
	  	   
	    function registrarEntradaOrdenCompra(ordenCompraVO) {	    	
	        return invocarServicioPost(URI_GUARDAR_ENTRADA_ORDEN_COMPRA,ordenCompraVO);	    				 	        
	    }
	    
}]);
