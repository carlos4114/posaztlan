'use strict';

angular.module('indexModule').service('programacionesTaquillaService', ['$http','GlobalFactory','config', function($http,GlobalFactory,config) {

	this.consultarConfigProgramacion = function(){
 		return $http.get(config.baseUrl+"/configuracion/configProgramaciones");
	}

	 this.crearProgramacion = function( programacionVo ) {
		 return $http.post(config.baseUrl + "/configuracion/programaciones", programacionVo );
	 }
	
	this.consultarProgramaciones = function(fechaExhibicion){
 
		 return $http.get(config.baseUrl+"/configuracion/programaciones", {
			 params : {
				 "fechaExhibicion":fechaExhibicion
				}
		 });
		 
	}
	this.eliminarProgramaciones = function( id ) {
			return $http.delete(config.baseUrl + "/configuracion/programaciones", {
	 				params : {
	 	 				"id" : id
	 	 			}
	 			}
	 				
	 		);
	 }
 
}]);
