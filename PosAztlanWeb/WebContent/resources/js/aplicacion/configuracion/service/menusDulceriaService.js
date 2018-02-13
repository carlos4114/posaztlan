'use strict';

angular.module('indexModule').service('menusDulceriaService', ['$http','GlobalFactory','config', function($http,GlobalFactory,config,$q) {
 
	 this.consultarProductos = function(){  
		 return $http.get(config.baseUrl+"/configuracion/productos");	
	 }
	 
	 this.consultarPaquetes = function(){
		return $http.get(config.baseUrl+"/configuracion/paquetes" );
	 }
	 
	 
	 this.eliminarPaquete= function( id ) {
 	 		return $http.delete(config.baseUrl + "/configuracion/paquetes", {
	 				params : {
	 	 				"id" : id
	 	 			}
	 			}
	 				
	 		);
	 }
 
}]);

