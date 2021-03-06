'use strict';
 
angular.module('indexModule').service("UsuariosService", ['$http', '$q','GlobalFactory','config', 
   function($http, $q, GlobalFactory, config) {
		
		var URI_SERVICIO = config.baseUrl;
		var URI_SERVICIO_SEGURIDAD = config.baseSeguridadUrl;
		var URI_NUEVO_USUARIO = URI_SERVICIO_SEGURIDAD + '/seguridad/guardarUsuarioNuevo';
		var URI_ACTUALIZAR_USUARIO = URI_SERVICIO_SEGURIDAD + '/seguridad/actualizarUsuario';
		var URI_OBTENER_USUARIOS = URI_SERVICIO_SEGURIDAD + '/seguridad/obtenerUsuarios';
		var URI_OBTENER_PERFILES = URI_SERVICIO_SEGURIDAD + '/seguridad/obtenerPerfiles';
		var URI_OBTENER_CAJAS = URI_SERVICIO + '/catalogo/cajas';
		var URI_OBTENER_CANALES = URI_SERVICIO + '/catalogo/canalesEmpresa';
		var URI_OBTENER_ALMACENES = URI_SERVICIO + "/catalogo/almacenes"
		var URI_OBTENER_ESTATUS_USUARIO = URI_SERVICIO_SEGURIDAD + "/seguridad/estatusUsuario"
				 	
	    var factory = {
	        guardarUsuarioNuevo: guardarUsuarioNuevo,
	        actualizarUsuario: actualizarUsuario,
	        obtenerUsuarios: obtenerUsuarios,
	        //consultaCinesXEmpresa: consultaCinesXEmpresa,
	        consultaPerfilesXEmpresa: consultaPerfilesXEmpresa,
	        consultaCajasXAlmacen: consultaCajasXAlmacen,
	        consultaEstatusUsuario: consultaEstatusUsuario,
	        consultaCanalesXEmpresa: consultaCanalesXEmpresa,
	        consultaAlmacenesXCanal : consultaAlmacenesXCanal
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
	    
	    function consultaCanalesXEmpresa(idEmpresa){
	        return invocarServicioGet(URI_OBTENER_CANALES+"/"+idEmpresa);	    				 
		 }

	    
	    function consultaCajasXAlmacen(idAlmacen){
	        return invocarServicioGet(URI_OBTENER_CAJAS+"/"+idAlmacen);	    				 
		 }
		 
	    function consultaAlmacenesXCanal(idCanal){		    	    		        
	        return invocarServicioGet(URI_OBTENER_ALMACENES+"/"+idCanal);
		 }
	    
	    function consultaPerfilesXEmpresa(idEmpresa){		    	    		        
	        return invocarServicioGet(URI_OBTENER_PERFILES+"/"+idEmpresa);
		 }   
	    
	    function consultaEstatusUsuario(){		    	    		        
	        return invocarServicioGet(URI_OBTENER_ESTATUS_USUARIO);
		 }
	    
	    
}]);
