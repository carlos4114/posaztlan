'use strict';

angular.module('indexModule').service('dashboardDulceriaService', ['$http','GlobalFactory','config', function($http,GlobalFactory,config) {
	
	this.ingresosSemanales = function(idCine, fechaActual, semanas, clavePuntoVenta){
		 
		 return $http({     
		        method: 'GET',
		        url: config.baseUrl + "/dashboard/ingresos/semanales",
		        params: {"idCine":idCine, "fechaActual" : fechaActual, "semanas" : semanas, "clavePuntoVenta" : clavePuntoVenta}
		    });
	 }
	  
 
	 this.consultarCinesEmpresa = function(){
		 
		 return $http.get(config.baseUrl+"/catalogo/cinesEmpresa");
		 
	 }
	 
	 
	 this.consultarRentables = function(idCine, fechaActual, dias, isDesc, limit){
		 
		 return $http({     
		        method: 'GET',
		        url: config.baseUrl + "/dashboard/productos/rentables",
		        params: {"idCine": idCine,"fechaActual": fechaActual, "dias": dias,  "isDesc" : isDesc,"limit" : limit }
		    });
		 
	 }
	 
	 
	 this.consultarVendidos = function(idCine, fechaActual, dias, isDesc, limit){
		 
		 return $http({     
		        method: 'GET',
		        url: config.baseUrl + "/dashboard/productos/vendidos",
		        params: {"idCine": idCine,"fechaActual": fechaActual, "dias": dias,  "isDesc" : isDesc,"limit" : limit }
		    });
		 
	 }
	 
	 this.consultarRentabilidad = function(idCine, fechaActual, dias){
		 
		 return $http({     
		        method: 'GET',
		        url: config.baseUrl + "/dashboard/rentabilidades",
		        params: {"idCine": idCine, "fechaActual" : fechaActual, "dias" : dias}
		    });
	 }
	  
	 
}]);

