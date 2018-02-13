'use strict';

angular.module('indexModule').service('dashboardTaquillaService', ['$http', 'GlobalFactory', 'config', function($http, GlobalFactory, config) {

    this.consultarIngresosXTaquilla = function(idCine,fechaActual, semanas, clavePuntoVenta) {

        return $http({
            method: 'GET',
            url: config.baseUrl + "/dashboard/ingresos/semanales",
            params: {
            	"idCine": idCine,"fechaActual": fechaActual,"semanas": semanas,"clavePuntoVenta":clavePuntoVenta
            }
        });
    }

    this.consultarIngresosXPelicula = function(idCine) {
		 return $http({     
		        method: 'GET',
		        url: config.baseUrl + "/dashboard/ingresos/peliculas",
		        params: {"idCine": idCine}
		    });
    }
    
    this.consultarAsistenciaPromedio = function(idCine,fechaActual, semanas){
		 
		 return $http({     
		        method: 'GET',
		        url: config.baseUrl + "/dashboard/asistencias",
		        params: {"idCine": idCine,"fechaActual" : fechaActual, "semanas" : semanas}
		    });
	 }
    
    this.consultarCinesEmpresa = function(){
		 
		 return $http.get(config.baseUrl+"/catalogo/cinesEmpresa");
		 
	 }
 
}]);