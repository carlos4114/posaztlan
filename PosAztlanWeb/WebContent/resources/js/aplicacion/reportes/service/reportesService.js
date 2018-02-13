'use strict';

angular.module('indexModule').service('reportesService', ['$http','GlobalFactory','config', function($http,GlobalFactory,config) {
	
	 this.consultarArticulos = function(){
		 return $http.get(config.baseUrl+"/catalogo/articulos");
	 }
	 
    this.consultarReportes = function(reporteVO){
		 return $http({     
		        method: 'GET',
		        url: config.baseUrl + "/reportes/ventas",
		        params: {"codigoReporte" : reporteVO.tipoReporte.codigo,
		        		"fechaInicio" : reporteVO.fechaInicio , 
		        		"fechaFin" : reporteVO.fechaFin,
		        		"idArticulo":3 }
		    });
	 }
}]);

