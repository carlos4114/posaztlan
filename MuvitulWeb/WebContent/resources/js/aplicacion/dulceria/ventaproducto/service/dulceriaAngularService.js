'use strict';

angular.module('indexModule').service('dulceriaService', ['$http','GlobalFactory','config', function($http,GlobalFactory,config) {
	
	this.consultarPaquetes = function(){
		console.log("consultar paquetes");
		return $http.get(config.baseUrl+"/ventaProducto/paquetes");
	}
 
	 this.consultarFormasPago = function(){
			console.log("consultar formas pago");
		 return $http.get(config.baseUrl+"/catalogo/formaspago");
	 }
	 
	 
	 this.consultarArticulos = function(){
			console.log("consultar Articulos");
		 return $http.get(config.baseUrl+"/catalogo/articulos");
	 }
	 
	 
	 this.procesarVenta = function(ventaVO ){
		 return $http.post(config.baseUrl + "/ventaProducto/ventas",ventaVO  );
	 }
	 
	 this.imprimirTicket = function(idTicket, pagoCon, cambio){
		 
		 return $http({     
		        method: 'GET',
		        url: config.baseUrl + "/ventaProducto/tickets",
		        params: {"idTicket" : idTicket, "pagoCon" : pagoCon , "cambio" : cambio}
		    });
	 }
	 
	 this.validarPaquetes = function(paquetesVO ){
		 return $http.post(config.baseUrl + "/ventaProducto/existencias",paquetesVO  );
	 }
	 
	  
	 /**************************************/
	 
	 this.consultarTicketBoletos = function(idTicket){
			console.log("consultar tickets");
		return $http.get(config.baseUrl+"/devolucion/boletos", {
			params : {"idTicket" : idTicket }
		});
		
	 }
	 
	 this.requestAutorizar = function(requestAutorizacionVO){
			console.log("consultar tickets");
		 return $http.post(config.baseUrl + "/autorizacion/movimientos",requestAutorizacionVO  );
	 }

	 this.imprimirCortesia = function(idDevolucion, importe ){
		 
		 return $http({     
		        method: 'GET',
		        url: config.baseUrl + "/devolucion/cortesias",
		        params: {"idDevolucion" : idDevolucion, "importe" : importe}
		    });
	 }
	 
	 
	 
	 this.consultar = function(idCine, fechaActual, semanas, clavePuntoVenta){
		 
		 return $http({     
		        method: 'GET',
		        url: config.baseUrl + "/dashboard/ingresos/semanales",
		        params: {"idCine": idCine, "fechaActual" : fechaActual, "semanas" : semanas, "clavePuntoVenta" : clavePuntoVenta}
		    });
	 }
	  
	 this.consultarIngresoPelicula = function(idCine){
		 
		 return $http({     
		        method: 'GET',
		        url: config.baseUrl + "/dashboard/ingresos/peliculas",
		        params: {"idCine": idCine}
		    });
		 
		 
	 }
	 
	 this.consultarAsistencia = function(idCine, fechaActual, semanas){
		 
		 return $http({     
		        method: 'GET',
		        url: config.baseUrl + "/dashboard/asistencias",
		        params: {"idCine": idCine, "fechaActual" : fechaActual, "semanas" : semanas}
		    });
	 }
	  
	 
	 
	 this.consultarCinesEmpresa = function(){
		 
		 return $http.get(config.baseUrl+"/catalogo/cinesEmpresa");
		 
	 }
	 
	 this.consultarRentables = function(idCine, fechaActual, dias, isDesc, limit){
		 
		 return $http({     
		        method: 'GET',
		        url: config.baseUrl + "/dashboard/productos/rentables",
		        params: {"idCine": idCine,"fechaActual": fechaActual, "dias": dias,  "isDesc" : isDesc,"limit" : limit }
		    });
		 
	 }
	 
	 
	 this.consultarVendidos = function(idCine, fechaActual, dias, isDesc, limit){
		 
		 return $http({     
		        method: 'GET',
		        url: config.baseUrl + "/dashboard/productos/vendidos",
		        params: {"idCine": idCine,"fechaActual": fechaActual, "dias": dias,  "isDesc" : isDesc,"limit" : limit }
		    });
		 
	 }
	 
	 this.consultarRentabilidad = function(idCine, fechaActual, dias){
		 
		 return $http({     
		        method: 'GET',
		        url: config.baseUrl + "/dashboard/rentabilidades",
		        params: {"idCine": idCine, "fechaActual" : fechaActual, "dias" : dias}
		    });
	 }
	  
	 
	 
}]);

