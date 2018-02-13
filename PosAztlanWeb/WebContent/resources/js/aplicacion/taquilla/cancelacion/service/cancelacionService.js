'use strict';

angular.module('indexModule').service('cancelacionBoletoService', ['$http','GlobalFactory','config', function($http,GlobalFactory,config) {
 
	 this.consultarTicket = function(idTicket){
	 	return $http.get(config.baseUrl+"/devolucion/boletos", {	params : {"idTicket" : idTicket} });
	 }
	 
	 this.consultarMotivosCancelaciones = function(){
 		return $http.get(config.baseUrl+"/catalogo/motivosCancelacion");
	  }

	  this.crearCancelacion = function(cancelacionPagoVO ){
		return $http.post(config.baseUrl + "/cancelacion/pagos",cancelacionPagoVO  );
	  }
	
	 
}]);