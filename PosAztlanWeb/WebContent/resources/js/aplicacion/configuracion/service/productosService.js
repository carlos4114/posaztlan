'use strict';
 
angular.module('indexModule').service("ProductosService", ['$http', '$q','GlobalFactory','config', 
   function($http, $q, GlobalFactory, config) {
		
		var URI_SERVICIO = config.baseUrl;
		var URI_OBTENER_CANALES = URI_SERVICIO + "/catalogo/canalesEmpresa";
		var URI_OBTENER_PRODUCTOS = URI_SERVICIO + "/productos/obtener";
		var URI_ACTUALIZAR_PRODUCTO = URI_SERVICIO + "/productos/actualizar";
		var URI_GUARDAR_PRODUCTO = URI_SERVICIO + "/productos/guardar";
		var URI_CONSULTA_UNIDADES_MEDIDA = URI_SERVICIO + "/catalogo/unidadesMedida";
		var URI_CONSULTA_FAMILIAS = URI_SERVICIO + "/catalogo/familias";
		var URI_CONSULTA_MARCAS = URI_SERVICIO + "/catalogo/marcas";
		var URI_CONSULTA_TIPOS = URI_SERVICIO + "/catalogo/tipos";
		var URI_CONSULTA_MEDIDAS = URI_SERVICIO + "/catalogo/medidas";
				
	    var factory = {
	    	consultaCanalesXEmpresa: consultaCanalesXEmpresa,  
	        obtenerProductos: obtenerProductos,
	        actualizarProducto: actualizarProducto,
	        guardarProducto: guardarProducto,
	        consultaUnidadesMedida: consultaUnidadesMedida,
	        consultaFamilias: consultaFamilias,
	        consultaMarcas: consultaMarcas,
	        consultaTipos: consultaTipos,
	        consultaMedidas: consultaMedidas
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

	 
	    function guardarProducto(productoVO) {	    	
	        return invocarServicioPost(URI_GUARDAR_PRODUCTO,productoVO);	    				 	        
	    }
	    
	    function actualizarProducto(productoVO) {
	        return invocarServicioPost(URI_ACTUALIZAR_PRODUCTO,productoVO);	    				 	        
	    }
	    
	    function obtenerProductos(idEmpresa) {
	    	
	        return invocarServicioGet(URI_OBTENER_PRODUCTOS+"/"+idEmpresa);	    				 	        
	    }
	    
	    function consultaCanalesXEmpresa(idEmpresa){
	        return invocarServicioGet(URI_OBTENER_CANALES+"/"+idEmpresa);	    				 
		}
	    
	    function consultaUnidadesMedida(idEmpresa){		    	    		        
	        return invocarServicioGet(URI_CONSULTA_UNIDADES_MEDIDA+"/"+idEmpresa);
	    }
	    
	    function consultaFamilias(idEmpresa){		    	    		        
	        return invocarServicioGet(URI_CONSULTA_FAMILIAS+"/"+idEmpresa);
	    }
	    
	    function consultaMarcas(idEmpresa){		    	    		        
	        return invocarServicioGet(URI_CONSULTA_MARCAS+"/"+idEmpresa);
	    }
	    
	    function consultaTipos(idEmpresa){		    	    		        
	        return invocarServicioGet(URI_CONSULTA_TIPOS+"/"+idEmpresa);
	    }
	    
	    function consultaMedidas(idEmpresa){		    	    		        
	        return invocarServicioGet(URI_CONSULTA_MEDIDAS+"/"+idEmpresa);
	    }
}]);
