'use strict';
 
angular.module('indexModule').service("ArticulosService", ['$http', '$q','GlobalFactory','config', 
   function($http, $q, GlobalFactory, config) {
		
		var URI_SERVICIO = config.baseUrl;
		var URI_CONSULTA_CLASIFICACIONES = URI_SERVICIO + '/catalogo/clasificaciones';
		var URI_CONSULTA_UNIDADES_MEDIDA = URI_SERVICIO + '/catalogo/unidadesMedida';
		var URI_OBTENER_CINES = URI_SERVICIO + "/catalogo/cinesEmpresa";
		var URI_OBTENER_PUNTOS_VENTA = URI_SERVICIO + "/catalogo/puntosVentaDulceria";
		var URI_OBTENER_ARTICULOS = URI_SERVICIO + "/articulos/obtener";
		var URI_ACTUALIZAR_ARTICULO = URI_SERVICIO + "/articulos/actualizar";
		var URI_GUARDAR_ARTICULO = URI_SERVICIO + "/articulos/guardar"
		var URI_OBTENER_PUNTOS_VENTA_X_ARTICULO = URI_SERVICIO + "/catalogo/puntosVentaXArticulo";
		
	    var factory = {
	        consultaClasificaciones: consultaClasificaciones,
	        consultaUnidadesMedida: consultaUnidadesMedida,  
	        consultaCinesXEmpresa: consultaCinesXEmpresa,
	        consultaPuntosVentaXCine: consultaPuntosVentaXCine,
	        obtenerArticulos: obtenerArticulos,
	        actualizarArticulo: actualizarArticulo,
	        guardarArticulo: guardarArticulo,
	        consultaPuntosVentaXArticulo: consultaPuntosVentaXArticulo
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

	 
	    function guardarArticulo(articuloVO) {	    	
	        return invocarServicioPost(URI_GUARDAR_ARTICULO,articuloVO);	    				 	        
	    }
	    
	    function actualizarArticulo(articuloVO) {
	        return invocarServicioPost(URI_ACTUALIZAR_ARTICULO,articuloVO);	    				 	        
	    }
	    
	    function obtenerArticulos(idCine) {
	    	
	        return invocarServicioGet(URI_OBTENER_ARTICULOS+"/"+idCine);	    				 	        
	    }
	    
	    function consultaCinesXEmpresa(idEmpresa){
	        return invocarServicioGet(URI_OBTENER_CINES+"/"+idEmpresa);	    				 
		 }

	    
	    function consultaUnidadesMedida(){
	        return invocarServicioGet(URI_CONSULTA_UNIDADES_MEDIDA);	    				 
		 }

	    function consultaClasificaciones(idCine){		    	    		        
	        return invocarServicioGet(URI_CONSULTA_CLASIFICACIONES+"/"+ idCine);
		 }
	    
	    function consultaPuntosVentaXCine(idCine){		    	    		        
	        return invocarServicioGet(URI_OBTENER_PUNTOS_VENTA+"/"+idCine);
		 }
	    
	    function consultaPuntosVentaXArticulo(idArticulo){		    	    		        
	        return invocarServicioGet(URI_OBTENER_PUNTOS_VENTA_X_ARTICULO+"/"+idArticulo);
		 }
	   
}]);
