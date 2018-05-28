'use strict';
 
angular.module('indexModule').service("ConteoInventarioService", ['$http', '$q','GlobalFactory','config', 
   function($http, $q, GlobalFactory, config) {
		
		var URI_SERVICIO = config.baseUrl;		
		var URI_CONSULTA_EMPRESAS = URI_SERVICIO + "/catalogo/empresas";
		var URI_CONSULTA_CANALES = URI_SERVICIO + "/catalogo/canalesEmpresa";
		var URI_CONSULTA_ALMACENES = URI_SERVICIO + "/catalogo/subalmacenes";
		var URI_OBTENER_PRODUCTOS_CONTEO = URI_SERVICIO + "/inventario/productosConteo";
		var URI_OBTENER_CONTEO = URI_SERVICIO + "/inventario/obtenerConteo";
		var URI_GUARDAR_CONTEO = URI_SERVICIO + "/inventario/guardarConteo";
		var URI_AUTORIZAR_CONTEO = URI_SERVICIO + "/inventario/autorizarConteo";
		
	    var factory = {
	        consultaEmpresas: consultaEmpresas,
	        consultaCanales: consultaCanales,
	        consultaAlmacenes: consultaAlmacenes,
	        obtenerProductosConteo: obtenerProductosConteo,
	        guardar:guardar,
	        autorizarConteo:autorizarConteo,
	        obtenerConteo: obtenerConteo
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


	    function obtenerProductosConteo(parametrosBusquedaVO) {
	    	
	        return invocarServicioPost(URI_OBTENER_PRODUCTOS_CONTEO, parametrosBusquedaVO);	    				 	        
	    }
	    

	    function obtenerConteo(parametrosBusquedaVO) {
	    	
	        return invocarServicioPost(URI_OBTENER_CONTEO, parametrosBusquedaVO);	    				 	        
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
	    
	    function consultaTiposMovimientoInv(){		    	    		  
	        return invocarServicioGet(URI_CONSULTA_TIPOS_MOV_INV +"/"+ false);
	    }
	    
	    function guardar(conteoVO) {	    	
	        return invocarServicioPost(URI_GUARDAR_CONTEO,conteoVO);	    				 	        
	    }
	    
	    function autorizarConteo(conteoVO) {	    	
	        return invocarServicioPost(URI_AUTORIZAR_CONTEO,conteoVO);	    				 	        
	    }
}]);
