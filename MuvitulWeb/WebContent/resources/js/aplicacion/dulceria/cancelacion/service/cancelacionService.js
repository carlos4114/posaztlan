'use strict';

angular.module('indexModule').service('cancelacionDulceriaService', ['$http','GlobalFactory','config', function($http,GlobalFactory,config) {
 
	 this.consultarTicketProductos = function(idTicket){
			console.log("consultar tickets");
		return $http.get(config.baseUrl+"/cancelacion/ticketsVenta", {
			params : {"idTicket" : idTicket,  "clavePuntoVenta": 'DUL-001' }
		});
	 }
	 
	 
	 this.consultarMotivosCancelaciones = function(){
		 return $http.get(config.baseUrl+"/catalogo/motivosCancelacion");
	 }

	 this.crearCancelacion = function(cancelacionPagoVO ){
		 return $http.post(config.baseUrl + "/cancelacion/pagos",cancelacionPagoVO  );
	 }
	 
}]);