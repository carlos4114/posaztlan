'use strict';
 
angular.module('indexModule').service("VentaManualService", ['$http', '$q','GlobalFactory','config', 
   function($http, $q, GlobalFactory, config) {
		
		var URI_SERVICIO = config.baseUrl;		
		var URI_CONSULTA_EMPRESAS = URI_SERVICIO + "/catalogo/empresas";
		var URI_CONSULTA_CANALES = URI_SERVICIO + "/catalogo/canalesEmpresa";
		var URI_CONSULTA_ALMACENES = URI_SERVICIO + "/catalogo/subalmacenes";
		var URI_BUSCAR = URI_SERVICIO + "/productos/obtenerExistencia";
		var URI_GUARDAR_VENTA = URI_SERVICIO + "/ventaProducto/ventaManual";
		
	    var factory = {
	        consultaEmpresas: consultaEmpresas,
	        consultaCanales: consultaCanales,
	        consultaAlmacenes: consultaAlmacenes,
	        buscar: buscar,
	        guardar:guardar
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


	    function buscar(filtrosVO) {
	    	
	        return invocarServicioPost(URI_BUSCAR, filtrosVO);	    				 	        
	    }
	    	    
	    
	    function consultaEmpresas(){		    	    		        
	        return invocarServicioGet(URI_CONSULTA_EMPRESAS);
	    }
	    
	    function consultaCanales(idEmpresa){		    	    		        
	        return invocarServicioGet(URI_CONSULTA_CANALES+"/"+idEmpresa);
	    }
	    
	    function consultaAlmacenes(idCanal){		    	    		        
	        return invocarServicioGet(URI_CONSULTA_ALMACENES+"/"+idCanal);
	    }
	    
	    function guardar(ventaManualVO) {	    	
	        return invocarServicioPost(URI_GUARDAR_VENTA,ventaManualVO);	    				 	        
	    }
}]);
