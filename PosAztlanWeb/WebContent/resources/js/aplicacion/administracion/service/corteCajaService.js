'use strict';
 
angular.module('indexModule').service("CorteCajaService", ['$http', '$q','GlobalFactory','config', 
   function($http, $q, GlobalFactory, config) {
		
		var URI_SERVICIO = config.baseUrl;
		var URI_GUARDA_CORTE = URI_SERVICIO + '/caja/guardarCorte';
		var URI_OBTENER_EFECTIVO = URI_SERVICIO  + '/caja/obtenerEfectivo';
		var URI_OBTENER_ULTIMOS_CORTES = URI_SERVICIO  + '/caja/obtenerUltimosCortes';
		var URI_CARGO_AJUSTE = URI_SERVICIO  + '/catalogo/cargoAjuste';
				 	
	    var factory = {
	        guardarCorte: guardarCorte,
	        obtenerEfectivo: obtenerEfectivo,
	        obtenerUltimosCortes: obtenerUltimosCortes,
	        obtenerCatCargoAjuste: obtenerCatCargoAjuste	    
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

	 
	    function guardarCorte(cajaVO) {	    	
	        return invocarServicioPost(URI_GUARDA_CORTE,cajaVO);	    				 	        
	    }
	    
	    function obtenerEfectivo() {
	        return invocarServicioGet(URI_OBTENER_EFECTIVO);	    				 	        
	    }
	    
	    function obtenerUltimosCortes() {
	    	var d = new Date();
	    	var n = d.getTime();
	        return invocarServicioGet(URI_OBTENER_ULTIMOS_CORTES);	    				 	        
	    }
	    
	    function obtenerCatCargoAjuste() {
	    	
	        return invocarServicioGet(URI_CARGO_AJUSTE);
	    }	   
	    
}]);
