'use strict';

angular.module('indexModule').service('promocionesTaquillaService', ['$http','GlobalFactory','config', function($http,GlobalFactory,config) {

	this.consultarConfigPromociones = function(){
		return $http.get(config.baseUrl+"/configuracion/configPromociones");
	}
	
	
	this.consultarPromociones = function(fechaExhibicion){
		 return $http.get(config.baseUrl+"/configuracion/promociones", {
			 params : {
				 "fechaExhibicion":fechaExhibicion
				}
		 });
	}
	
	 this.crearPromocion = function(promocionVO ) {
		 return $http.post(config.baseUrl + "/configuracion/promociones", promocionVO );
	 }
	
	this.eliminarPromocion = function( id ) {
 	 		return $http.delete(config.baseUrl + "/configuracion/promociones", {
	 				params : {	"id" : id	}
	 			}
	 		);
	 }
 
}]);

