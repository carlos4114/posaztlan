'use strict';

angular.module('indexModule').service('inventarioService', ['$http','GlobalFactory','config', function($http,GlobalFactory,config) {
 	
	this.busquedaArticulosPuntoVenta = function(nombre){		 
		 return $http.get(config.baseUrl+"/inventario/puntoVenta/articulo", {
			 params : {
				 "nombre" : nombre
			 }
		});
	 }
	
	 this.busquedaArticulosInventario = function(nombreArticulo){		 
		 return $http.get(config.baseUrl+"/inventario/articulo", {
			 params : {
				 "nombreArticulo" : nombreArticulo
			 }
		});
	 }
	 
	 this.busquedaArticulosExistencia = function(idArticulo){		 
		 return $http.get(config.baseUrl+"/inventario/articulo/existencia", {
			 params : {
				 "idArticulo" : idArticulo
			 }
		});
	 }	 
	 
	 this.consultarTiposMovimientosIsEntrada = function(){		 
		 return $http.get(config.baseUrl+"/inventario/tipoMovimientoInv/entrada", {
			 params : {
				 "isEntrada" : true
			 }
		});
	 }
	 
	 this.consultarTiposMovimientosEntrada = function(){		 
		 return $http.get(config.baseUrl+"/inventario/tipoMovimientoInv/clave", {
			 params : {
				 "clave" : "entrada"
			 }
		});
	 }
	 
	 this.consultarTiposMovimientosSalida = function(){		 
		 return $http.get(config.baseUrl+"/inventario/tipoMovimientoInv/clave", {
			 params : {
				 "clave" : "salida"
			 }
		});
	 }
	 
	 this.consultarTiposMovimientosAjuste = function(){		 
		 return $http.get(config.baseUrl+"/inventario/tipoMovimientoInv/clave", {
			 params : {
				 "clave" : "ajuste"
			 }
		});
	 }
	 
	this.registrarSalida = function(parametrosInventario){		 
		 if (parametrosInventario.idPuntoVentaConsigna == null){parametrosInventario.idPuntoVentaConsigna = 0}
		 return $http.post(config.baseUrl + "/inventario/articulo/salida",parametrosInventario);
	}

	this.registrarEntrada = function(parametrosInventario){
			 return $http.post(config.baseUrl + "/inventario/articulo/entrada",parametrosInventario);
	}
	
	this.registrarConteo = function(conteoArticulo){
		 return $http.post(config.baseUrl + "/inventario/articulosCorte",conteoArticulo);
	}
	
	this.actualizarConteo = function(conteoArticulo ){
		 return $http.put(config.baseUrl + "/inventario/articulosCorte",conteoArticulo);
	}
	
	this.actualizarConteoMovimiento = function(conteoArticulo ){
		 return $http.put(config.baseUrl + "/inventario/articulosCorteMovimiento",conteoArticulo);
	}
	
	this.eliminarConteo = function(idConteoArticulo){
		 return $http.delete(config.baseUrl + "/inventario/articulosCorte",idConteoArticulo);
	}	 
	
	this.busquedaArticulosSinConteo = function(nombreArticulo){		 
		 return $http.get(config.baseUrl+"/inventario/articulosSinConteo", {
			 params : {
				 "nombreArticulo" : nombreArticulo
			 }
		});
	 }
	
	this.finalizarConteoInventario = function(){		 
		 return $http.put(config.baseUrl+"/inventario/articulosFinConteo", {
			 params : {
				 "estatusConteo" : 1
			 }
		});
	 }
	
	this.busquedaConteoArticulos = function(fecha){		 
		 return $http.get(config.baseUrl+"/inventario/articulosCorte", {
			 params : {
				 "fecha" : fecha
			 }
		});
	 }
	
	this.consultarPuntosVenta = function(){		
		return $http.get(config.baseUrl+"/catalogo/puntosVenta");
	}

	this.consultarProveedores = function(){
		return $http.get(config.baseUrl+"/catalogo/proveedor");
	}
	 
}]);

