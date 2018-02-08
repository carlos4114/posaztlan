'use strict';
 
angular.module('indexModule').service("SalasService", ['$http', '$q','GlobalFactory','config', 
   function($http, $q, GlobalFactory, config) {
		
		var URI_SERVICIO = config.baseUrl;		
		var URI_OBTENER_SALAS = URI_SERVICIO + '/sala/obtenerLista';
		var URI_OBTENER_CINES = URI_SERVICIO + "/catalogo/cinesEmpresa"
		var URI_ACTUALIZAR = URI_SERVICIO + '/sala/actualizar';
		var URI_GUARDAR = URI_SERVICIO + '/sala/guardarNueva';
		var URI_OBTENER_MAPA_NUEVO = URI_SERVICIO + '/sala/obtenerMapaNuevo';
	    var URI_ACTUALIZA_ASIENTO = URI_SERVICIO + '/sala/actualizaAsiento';

	    var factory = {
	        guardar: guardar,
	        actualizar: actualizar,
	        obtenerSalas: obtenerSalas,
	        consultaCinesXEmpresa: consultaCinesXEmpresa,
	        actualizaAsiento: actualizaAsiento,
	        obtenerMapaNuevo: obtenerMapaNuevo
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
	    
	    function actualizaAsiento(asientosVOList,asientoVO){
			var actualizaAsientoVO = {asientosVOList:asientosVOList, asientoVO:asientoVO};
	        return invocarServicioPost(URI_ACTUALIZA_ASIENTO,actualizaAsientoVO);	    				 	        
	    }

	 
	    function guardar(salaVO) {	    	
	        return invocarServicioPost(URI_GUARDAR,salaVO);	    				 	        
	    }
	    
	    function actualizar(salaVO) {
	        return invocarServicioPost(URI_ACTUALIZAR,salaVO);	    				 	        
	    }
	    
	    function obtenerSalas(idCine) {
	    	
	        return invocarServicioGet(URI_OBTENER_SALAS+"/"+idCine);	    				 	        
	    }
	    
	    function consultaCinesXEmpresa(idEmpresa){
	        return invocarServicioGet(URI_OBTENER_CINES+"/"+idEmpresa);	    				 
		 }

	    
	    function obtenerMapaNuevo(filas,maxNoAsientos){
	        return invocarServicioGet(URI_OBTENER_MAPA_NUEVO+"/"+filas+"/"+maxNoAsientos);	    				 
	    }
	    
	    
}]);
