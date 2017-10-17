'use strict';

angular.module('indexModule').service('devolucionDulceriaService', ['$http','GlobalFactory','config', function($http,GlobalFactory,config) {
 
	 this.consultarTicketProductos = function(idTicket){
		 console.log("consultar tickets");
		 return $http.get(config.baseUrl+"/devolucion/productos", {
			 params : {"idTicket" : idTicket}
		 });
	 }
	 
	 this.consultarMotivosDevoluciones = function(idPuntoVenta){
 		 
		 return $http.get(config.baseUrl+"/catalogo/motivosDevolucion", {
			 params : {"idPuntoVenta" : idPuntoVenta}
		 });
		 
	 }
	 
	 this.consultarTiposDevoluciones = function(idTipoPuntoVenta){
		 return $http.get(config.baseUrl+"/catalogo/tiposDevolucion", {
			 params : {"idTipoPuntoVenta" : idTipoPuntoVenta }
		 });
	 }
	 
	 this.crearDevolucion = function(devolucionProductoVO){
 		 return $http.post(config.baseUrl + "/devolucion/productos",devolucionProductoVO);
	 }
	 
}]);