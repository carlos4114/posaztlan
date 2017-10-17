'use strict';

angular.module('indexModule').service('reportesService', ['$http','GlobalFactory','config', function($http,GlobalFactory,config) {
	
	this.consultarReportes = function(reporteVO ){
		return $http.post(config.baseUrl + "/reportes/ventas",reporteVO  );
	  }
	 
}]);

