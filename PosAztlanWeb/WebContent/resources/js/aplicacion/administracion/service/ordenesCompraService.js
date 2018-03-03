'use strict';
 
angular.module('indexModule').service("OrdenesCompraService", ['$http', '$q','GlobalFactory','config', 
   function($http, $q, GlobalFactory, config) {
		
		var URI_SERVICIO = config.baseUrl;		
		var URI_OBTENER_PRODUCTOS = URI_SERVICIO + "/ordenesCompra/obtenerProductos";
		var URI_CONSULTA_FAMILIAS = URI_SERVICIO + "/catalogo/familias";
		var URI_CONSULTA_MARCAS = URI_SERVICIO + "/catalogo/marcas";
		var URI_CONSULTA_TIPOS = URI_SERVICIO + "/catalogo/tipos";
		var URI_CONSULTA_MEDIDAS = URI_SERVICIO + "/catalogo/medidas";
		var URI_CONSULTA_PROVEEDORES = URI_SERVICIO + "/catalogo/proveedores";
		var URI_BUSCAR = URI_SERVICIO + "/ordenesCompra/buscar";
		var URI_GUARDAR_ORDEN_COMPRA = URI_SERVICIO + "/ordenesCompra/guardar";
		
	    var factory = {
	        obtenerProductos: obtenerProductos,
	        consultaFamilias: consultaFamilias,
	        consultaMarcas: consultaMarcas,
	        consultaTipos: consultaTipos,
	        consultaMedidas: consultaMedidas,
	        buscar: buscar,
	        guardar:guardar,
	        consultaProveedores: consultaProveedores
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
	    
	    function obtenerProductos(idEmpresa) {
	    	
	        return invocarServicioGet(URI_OBTENER_PRODUCTOS+"/"+idEmpresa);	    				 	        
	    }
	    
	    function consultaFamilias(idEmpresa){		    	    		        
	        return invocarServicioGet(URI_CONSULTA_FAMILIAS+"/"+idEmpresa);
	    }
	    
	    function consultaMarcas(idEmpresa){		    	    		        
	        return invocarServicioGet(URI_CONSULTA_MARCAS+"/"+idEmpresa);
	    }
	    
	    function consultaProveedores(idEmpresa){		    	    		        
	        return invocarServicioGet(URI_CONSULTA_PROVEEDORES+"/"+idEmpresa);
	    }
	    
	    function consultaTipos(idEmpresa){		    	    		        
	        return invocarServicioGet(URI_CONSULTA_TIPOS+"/"+idEmpresa);
	    }
	    
	    function consultaMedidas(idEmpresa){		    	    		        
	        return invocarServicioGet(URI_CONSULTA_MEDIDAS+"/"+idEmpresa);
	    }
	    
	    function guardar(ordenCompraVO) {	    	
	        return invocarServicioPost(URI_GUARDAR_ORDEN_COMPRA,ordenCompraVO);	    				 	        
	    }
}]);
