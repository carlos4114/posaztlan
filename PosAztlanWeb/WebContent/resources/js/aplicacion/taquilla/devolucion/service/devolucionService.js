'use strict';

angular.module('indexModule').service('devolucionBoletoService', ['$http','GlobalFactory','config', function($http,GlobalFactory,config) {
 
	 this.consultarTicket = function(idTicket){
 		return $http.get(config.baseUrl+"/devolucion/boletos", {			params : {"idTicket" : idTicket}		});
	 }

	 this.consultarMotivosDevoluciones = function(idPuntoVenta){
			return $http.get(config.baseUrl+"/catalogo/motivosDevolucion", {
				params : {"idPuntoVenta" : idPuntoVenta }
			});
			
	 }
	 
	 this.consultarTiposDevoluciones = function(idTipoPuntoVenta){
 			return $http.get(config.baseUrl+"/catalogo/tiposDevolucion", {
				params : {"idTipoPuntoVenta" : idTipoPuntoVenta }
			});
	 }
	 
	 this.crearDevolucion = function(devolucionBoletoVO){
 		 return $http.post(config.baseUrl + "/devolucion/boletos",devolucionBoletoVO  );
	 }
	 
	 this.imprimirCortesia = function(idTicket, idDevolucion ){
		 
		 return $http({     
		        method: 'GET',
		        url: config.baseUrl + "/devolucion/cortesias",
		        params: {"idDevolucion" : idDevolucion, "idTicket" : idTicket}
		    });
	 }
	 
}]);