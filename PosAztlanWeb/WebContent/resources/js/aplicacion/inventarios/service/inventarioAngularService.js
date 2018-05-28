'use strict';

angular.module('indexModule').service('inventarioService', ['$http','GlobalFactory','config', function($http,GlobalFactory,config) {
 	
	this.busquedaProductos = function(parametrosBusquedaVO){		 
		 return $http.post(config.baseUrl+"/inventario/buscarProducto", parametrosBusquedaVO);
	 }
	
	this.busquedaProductosXsku = function(parametrosBusquedaVO){		 
		 return $http.post(config.baseUrl+"/inventario/buscarProductoXsku", parametrosBusquedaVO);
	 }
	
	 this.busquedaProductosInventario = function(nombreProducto){		 
		 return $http.get(config.baseUrl+"/inventario/producto", {
			 params : {
				 "nombreProducto" : nombreProducto
			 }
		});
	 }
	 
	 this.busquedaProductosExistencia = function(idProducto){		 
		 return $http.get(config.baseUrl+"/inventario/producto/existencia", {
			 params : {
				 "idProducto" : idProducto
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
		 if (parametrosInventario.idAlmacenConsigna == null){parametrosInventario.idAlmacenConsigna = 0}
		 return $http.post(config.baseUrl + "/inventario/producto/salida",parametrosInventario);
	}

	this.registrarEntrada = function(parametrosInventario){
			 return $http.post(config.baseUrl + "/inventario/producto/entrada",parametrosInventario);
	}
	
	this.registrarConteo = function(conteoProducto){
		 return $http.post(config.baseUrl + "/inventario/productosCorte",conteoProducto);
	}
	
	this.actualizarConteo = function(conteoProducto ){
		 return $http.put(config.baseUrl + "/inventario/productosCorte",conteoProducto);
	}
	
	this.actualizarConteoMovimiento = function(conteoProducto){
		 return $http.put(config.baseUrl + "/inventario/productosCorteMovimiento",conteoProducto);
	}
	
	this.eliminarConteo = function(idConteoProducto){
		 return $http.delete(config.baseUrl + "/inventario/productosCorte",idConteoProducto);
	}	 
	
	this.busquedaProductosSinConteo = function(nombreProducto){		 
		 return $http.get(config.baseUrl+"/inventario/productosSinConteo", {
			 params : {
				 "nombreProducto" : nombreProducto
			 }
		});
	 }
	
	this.finalizarConteoInventario = function(){		 
		 return $http.put(config.baseUrl+"/inventario/productosFinConteo", {
			 params : {
				 "estatusConteo" : 1
			 }
		});
	 }
	
	this.busquedaConteoProductos = function(fecha){		 
		 return $http.get(config.baseUrl+"/inventario/productosCorte", {
			 params : {
				 "fecha" : fecha
			 }
		});
	 }
	
	this.consultarAlmacenes = function(){		
		return $http.get(config.baseUrl+"/catalogo/almacenes");
	}

	this.consultarProveedores = function(idEmpresa){
		return $http.get(config.baseUrl+"/catalogo/proveedores/" + idEmpresa)
		}
}]);

