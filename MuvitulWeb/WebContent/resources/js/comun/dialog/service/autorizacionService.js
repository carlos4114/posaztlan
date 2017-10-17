'use strict';

angular.module('indexModule').service('athorizationService', ['$http','config', function($http,config) {

	this.consultarAutorizacion = function(athorization){
 	 return $http.post(config.baseUrl + "/autorizacion/movimientos",athorization );
 }

	 
}]);