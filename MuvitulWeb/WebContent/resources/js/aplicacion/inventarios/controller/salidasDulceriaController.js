'use strict';

var SalidasDulceriaController = angular.module('indexModule').controller("SalidasDulceriaController", function($scope,$controller,$filter,ModalService,dulceriaService,inventarioService,PropertiesFactory){

	$controller('modalController',{$scope : $scope });
	$scope.parametroBusqueda = {articulo: ""};	
	$scope.tipoSalida = {};
	$scope.listaArticulos = [];
	$scope.inventario = {};
	$scope.listaArticulosExistencia = [];
	$scope.listaTiposMovimientosSalida = [] ;	
	$scope.listaPuntosVenta = [];
	$scope.movimientoInventario;
	$scope.resultado = "";
	$scope.existenciaArticulo = 0;
	
	$scope.activeForm = false;
	$scope.activeProveedor = false;
	$scope.activePuntoVentaDestino = false;
	
	$scope.parametrosInventario = {};
	
	$scope.limpiarParametrosMovimientoSalida = function() {
			$scope.tipoSalida = {};				
			$scope.movimientoInventario = {};
			$scope.parametrosInventario = {};
			$scope.inventario = {};
			$scope.listaArticulosExistencia = [];
			$scope.activePuntoVentaDestino = false;
			$scope.resultado = "";			
			$scope.activeForm = false;
			$scope.activeProveedor = false;
			$scope.existenciaArticulo = 0;
	}
	
	$scope.consultarTiposMovimientoSalida = function() {		
		inventarioService.consultarTiposMovimientosSalida().success(function(data) {
			$scope.listaTiposMovimientosSalida = data;
		}).error(function(data) {

			
		});
	}
	
	$scope.consultarPuntoVenta = function() {
		inventarioService.consultarPuntosVenta().success(function(data) {
			 $scope.listaPuntosVenta = data;
			 $scope.activeForm = false;
		}).error(function(data) {

		});
	}
	
	$scope.buscarArticulos = function() {
		inventarioService.busquedaArticulosInventario($scope.parametroBusqueda.articulo).success(function(data) {
			$scope.listaArticulos = data;		
		}).error(function(data) {

		});
	}	
	
	$scope.setDatosDeArticulo = function(movimientoInventarioVO){
		$scope.movimientoInventario = movimientoInventarioVO;
		$scope.parametrosInventario.idArticulo = movimientoInventarioVO.articulo.idArticulo;
		$scope.existenciaArticulo = movimientoInventarioVO.existenciaActual;
		$scope.activeForm = true;		
	}
	
	$scope.buscarArticulosExistencia = function(idArticulo) {
		inventarioService.busquedaArticulosExistencia(idArticulo).success(function(data) {
			$scope.listaArticulosExistencia = data;			
		}).error(function(data) {

		});
	}
	
	$scope.actualizaExistencia = function(inventarioProveedor){
		if(inventarioProveedor!=undefined){
			$scope.movimientoInventario.existenciaActual = inventarioProveedor.existenciaActual;
			$scope.parametrosInventario.idProveedor = inventarioProveedor.proveedor.idProveedor;			
		}
	}
	
	
	$scope.guardarSalida= function(autorizacion) {
		$scope.parametrosInventario.idTipoMovimiento = $scope.tipoSalida.idTipoMovimientoInv;
		$scope.parametrosInventario.claveTipoMovimiento = $scope.tipoSalida.clave;
		$scope.parametrosInventario.idAutorizacion = autorizacion.idAutorizacion;
		if(autorizacion.status==1){
				inventarioService.registrarSalida($scope.parametrosInventario).success(function(data) {					
								$scope.resultado = data;
								if($scope.resultado!=0){
									$scope.activeForm = false;
									$scope.limpiarParametrosMovimientoSalida();
									$scope.formSalidas.$setPristine();								
									$scope.showAviso("El movimiento se realizo correctamente.");
								}else{
									$scope.showAviso("No fue posible realizar movimiento.");
								}
								
				}).error(function(data) {
					$scope.showAviso("No fue posible realizar movimiento.");
				});
		}else{
			if(autorizacion.descripcion != undefined){
				$scope.showAviso(autorizacion.descripcion);
			}
		}
	}
	
	$scope.validateTipoMovimiento = function(){
		
		$scope.activePuntoVentaDestino = false;
		$scope.activeProveedor = false;
		$scope.movimientoInventario.existenciaActual = $scope.existenciaArticulo;
		if($scope.tipoSalida != null && $scope.tipoSalida.catalogo=='salidaTraspaso'){		
			$scope.activePuntoVentaDestino = true;
		}else if($scope.tipoSalida != null && $scope.tipoSalida.catalogo=='salidaProveedor'){
			$scope.buscarArticulosExistencia($scope.parametrosInventario.idArticulo);
			$scope.activeProveedor = true;
		}
		
	}
			
	$scope.validaFormSalidas = function(){		
		if ($scope.formSalidas.$invalid) {            
            angular.forEach($scope.formSalidas.$error, function (field) {
              angular.forEach(field, function(errorField){
            	  errorField.$setDirty();
              })
            });                        
            return false;
        }else if($scope.tipoSalida.idTipoMovimientoInv == undefined ){        	
			 	return false;
		}else if($scope.activeProveedor){
			if($scope.inventario.proveedor.idProveedor == undefined){
				return false;
			}else{
				return true;
			}
		}else if($scope.activePuntoVentaDestino){		
			if($scope.parametrosInventario.idPuntoVentaConsigna == undefined){
				return false;
			}else{
				return true;
			}
		}else{
			return true;
		}
				
		
	}
	
	 $scope.confirmacionSalida = function(){
		 /* Modal Confirmacion */
			$scope.showConfirmacion = function(messageTo){
				ModalService.showModal({
			    	templateUrl: 'vistas/templatemodal/templateModalConfirmacion.html',
			        controller: 'mensajeModalController',
			        	inputs:{ message: messageTo}
			    }).then(function(modal) {
			        modal.element.modal();
			        modal.close.then(function(result) {
			        	if(result){
			        		$scope.showAuthorization($scope.tipoSalida.catalogo);			     				        	
			        	}
			        }); 
			    });
			};
			
			if($scope.validaFormSalidas()){
				if($scope.movimientoInventario.existenciaActual < $scope.parametrosInventario.cantidad){
					$scope.showAviso("La cantidada solicitada no puede ser procesada");
				}else{
					$scope.showConfirmacion ("Est\u00e1 seguro de realizar la salida de inventario?");
				}
			}else{
				$scope.showAviso("Es necesario llenar los campos obligatorios ");
			}
	};
	
	 $scope.showAuthorization = function(tipo){
		 
			ModalService.showModal({
		    	templateUrl: 'vistas/templatemodal/templateModalAutorizacion.html',
	        	controller: 'authorizationModalController',
	        	inputs:{ tipoAutorizacion: PropertiesFactory.getTipoAutorizacion(tipo)}
		      }).then(function(modal) {
		        modal.element.modal();
		        modal.close.then(function(result) {
		        	$scope.guardarSalida(result);		    		
		        }); 
	 	      });
				 
	 }

	$scope.cerrar = function(){
		$('.modal').hide();
		$('.modal-backdrop').remove();
	};  
	
	$scope.init =function(){
		 $scope.consultarTiposMovimientoSalida();
		 $scope.consultarPuntoVenta();
	 }
	 
	 $scope.init();
	
});

