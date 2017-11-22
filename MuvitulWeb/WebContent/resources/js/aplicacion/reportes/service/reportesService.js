'use strict';

angular.module('indexModule').service('reportesService', ['$http','GlobalFactory','config', function($http,GlobalFactory,config) {
	
	 
    this.consultarReportes = function(reporteVO){
		 console.log(reporteVO);
		 return $http({     
		        method: 'GET',
		        url: config.baseUrl + "/reportes/ventas",
		        params: {"codigoReporte" : reporteVO.tipoReporte.codigo, "fechaInicio" : reporteVO.fechaInicio , "fechaFin" : reporteVO.fechaFin}
		    });
	 }
}]);

