'use strict';

angular.module('indexModule').service('taquillaService', ['$http','$q','GlobalFactory','config', function($http,$q,GlobalFactory,config) {
 
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
	
	this.borrarReservadosUsuario = function(){
		
		var deferred = $q.defer();
		
		$http.get(config.baseUrl+"/sala/borrarReservados").then(
		            function (response) {
		                deferred.resolve(response.data);
		            },
		            function(errResponse){	                
		                deferred.reject(errResponse);
		            }
		 );
		 
		 return deferred.promise; 
	 }
	
	this.consultarMapaConAsistencia = function(idProgramacion,fechaExhibicion){
		
		var deferred = $q.defer();
		
		$http.get(config.baseUrl+"/sala/mapaConAsistencia",{
				params : {"fechaExhibicion" : fechaExhibicion,
						 "idProgramacion" : idProgramacion							 
				}
		 }).then(
		            function (response) {
		                deferred.resolve(response.data);
		            },
		            function(errResponse){	                
		                deferred.reject(errResponse);
		            }
		 );
		 
		 return deferred.promise; 
	 }
	
	
	this.consultarPeliculas = function(fechaExhibicion){
		 return $http.get(config.baseUrl+"/ventaBoleto/peliculas", {
				params : {"fechaExhibicion" : fechaExhibicion }
		  });
	 }
	 
	 this.consultarPromociones = function(fechaExhibicion){

 		return $http.get(config.baseUrl+"/ventaBoleto/promociones", {
			params : {"fechaExhibicion" : fechaExhibicion }
		  });
	 }
 
	 this.consultarPreciosFormato = function(idFormato){
		 return $http.get(config.baseUrl+"/ventaBoleto/precios", {
				params : {"idFormato" : idFormato }
		  });
	 }
	 this.consultarFormasPago = function(){
 		 return $http.get(config.baseUrl+"/catalogo/formaspago");
	 }
	 
	 this.consultarExistenciaBoletos = function(paramsExistenciaBoleto){

		 return $http.get(config.baseUrl+"/ventaBoleto/existencias", {
				params : {
						"idProgramacion" : paramsExistenciaBoleto.idProgramacion ,
						"idSala" : paramsExistenciaBoleto.idSala ,
						"fechaExhibicion" : paramsExistenciaBoleto.fechaExhibicion 
					}
		  });
	 }
	 
	 this.updateExistenciaBoleto = function(existenciaBoletoVO){
 		 return $http.put(config.baseUrl+"/ventaBoleto/existencias",existenciaBoletoVO);
	 }
	 
	 this.updateExistenciaAsiento = function(fechaExhibicion,asientoVO){
		 asientoVO.fechaExhibicion = fechaExhibicion;
 		 return $http.post(config.baseUrl+"/ventaBoleto/existenciaAsiento",asientoVO);
	 }
	 
	 this.consultarDescuentos = function(promocionBoletoVO ){
		 return $http.post(config.baseUrl + "/ventaBoleto/descuentos",promocionBoletoVO  );
	 }
	 
	 this.procesarVenta = function(ventaVO ){
		 return $http.post(config.baseUrl + "/ventaBoleto/ventas",ventaVO  );
	 }
//	 this.imprimirTickets = function(idTicket){
//		 
//		 return $http({     
//		        method: 'GET',
//		        url: config.baseUrl + "/ventaBoleto/tickets",
//		        params: {"idTicket" : idTicket},
//		        dataType: "json",
//		        header :{ "Content-type": "application/json",
//		        			"Accept"    : "pdf"
//		        },
//		        responseType: 'arraybuffer'
//		    });
//	 }
	 
	 this.imprimirTickets = function(idTicket, pagoCon, cambio){
		 
		 return $http({     
		        method: 'GET',
		        url: config.baseUrl + "/ventaBoleto/tickets",
		        params: {"idTicket" : idTicket, "pagoCon" : pagoCon , "cambio" : cambio}
		    });
	 }
	  
	 /*UTILITIES*/
//		this.downloadfile = function(file, fileName) {
//			var url = window.URL || window.webkitURL;
//			var blobUrl = url.createObjectURL(file);
//			var a = document.createElement('a');
//			a.href = blobUrl;
//			a.target = '_blank';
//			a.download = fileName;
//			document.body.appendChild(a);
//			a.click();
//		}
}]);