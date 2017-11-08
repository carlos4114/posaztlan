'use strict';

var ConteoInventarioController = angular.module('indexModule').controller("ConteoInventarioController", function($scope,$controller,$filter,ModalService,dulceriaService,inventarioService,PropertiesFactory){

	$controller('modalController',{$scope : $scope });
	$scope.parametroBusqueda = {articulo: ""};	
	$scope.tipoSalida = {};
	$scope.listaArticulos = [];
	$scope.listaConteoArticulos = [];
	$scope.listaTiposMovimientosAjuste = [] ;	
	$scope.listaPuntosVenta = [];
	$scope.movimientoInventario = {};
	$scope.conteoArticuloTmp = {};
	$scope.nombreArticulo = "";
	$scope.unidadMedida = "";
	$scope.resultado = "";		
	$scope.isNew = false;
	$scope.parametrosInventario = {};
	$scope.showFormConteoArticuloCreate = false;
	
	$scope.limpiarParametrosMovimiento = function() {
			$scope.tipoSalida = {};				
			$scope.movimientoInventario = {};
			$scope.nombreArticulo = "";
			$scope.unidadMedida = "";
			$scope.resultado = "";
			$scope.conteoArticuloTmp = {};
			$scope.isNew = false;
			$scope.showFormConteoArticuloCreate = false;
	}
	
	$scope.consultarTiposMovimiento = function() {
		inventarioService.consultarTiposMovimientosAjuste().success(function(data) {
			$scope.listaTiposMovimientosAjuste = data;
		}).error(function(data) {

			
		});
	}
		
	$scope.buscarArticulos = function() {
		inventarioService.busquedaArticulosSinConteo($scope.parametroBusqueda.articulo).success(function(data) {
			$scope.listaArticulos = data;
			$scope.showFormConteoArticuloCreate = false;
		}).error(function(data) {

		});
	}	
	
	$scope.buscarConteoArticulos = function() {
		$scope.fecha = moment(new Date()).format('DD/MM/YYYY');
		inventarioService.busquedaConteoArticulos($scope.fecha).success(function(data) {
			$scope.listaConteoArticulos = data;		
		}).error(function(data) {

		});
	}	
	
	$scope.setDatosConteoArticuloCreate = function(movimientoInventarioVO){
		$scope.movimientoInventario = movimientoInventarioVO;
		$scope.nombreArticulo = $scope.movimientoInventario.articulo.nombre;
		$scope.unidadMedida =  $scope.movimientoInventario.articulo.unidadMedidaVO.nombre;
		$scope.parametrosInventario.idArticulo = movimientoInventarioVO.articulo.idArticulo;
		$scope.parametrosInventario.existenciaFisica = null;
		$scope.isNew = true;
		$scope.showFormConteoArticuloCreate = true;
		$scope.formConteo.$setPristine();		
	}
	
	$scope.setDatosConteoArticuloUpdate = function(conteoArticulo){
		$scope.parametrosInventario.existenciaFisica = conteoArticulo.existenciaFisica;
		$scope.conteoArticuloTmp = conteoArticulo;
		$scope.nombreArticulo = conteoArticulo.articulo.nombre;
		$scope.unidadMedida =  conteoArticulo.articulo.unidadMedidaVO.nombre;
		$scope.showFormConteoArticuloCreate = true;
		$scope.isNew = false;
	}
	
	$scope.confirmacionMovimiento = function(conteoArticulo){
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
			        		$scope.showAuthorization(conteoArticulo);			     				        	
			        	}
			        }); 
			    });
			};			
						
			$scope.showConfirmacion ("Est\u00e1 seguro de realizar el movimiento de inventario?");
			
	};
	
	 $scope.showAuthorization = function(conteoArticulo){
		 var tipoMovimiento;
		 
		 if (conteoArticulo.existenciaSistema > conteoArticulo.existenciaFisica){
			 tipoMovimiento = "ajusteSalidaManual";
		 }else if (conteoArticulo.existenciaSistema < conteoArticulo.existenciaFisica){
			 tipoMovimiento = "ajusteEntradaManual";
		 }
  			  
			ModalService.showModal({
		    	templateUrl: 'vistas/templatemodal/templateModalAutorizacion.html',
	        	controller: 'authorizationModalController',
	        	inputs:{ tipoAutorizacion: PropertiesFactory.getTipoAutorizacion(tipoMovimiento)}
		      }).then(function(modal) {
		        modal.element.modal();
		        modal.close.then(function(result) {
		        	conteoArticulo.autorizacion = result;
		        	$scope.guardarMovimiento(conteoArticulo);
		        }); 
	 	      });
				 
	 }

	$scope.guardarMovimiento= function(conteoArticulo) {
		
		if(conteoArticulo.autorizacion.status==1){
			conteoArticulo.fecha = new Date();
				inventarioService.actualizarConteoMovimiento(conteoArticulo).success(function(data) {		
							if(data>0){
								$scope.resultado = data;																
								$scope.showAviso("El movimiento se realizo correctamente.");
								$scope.limpiarParametrosMovimiento();
								$scope.buscarConteoArticulos();
							}else if(data == 0){
								$scope.showAviso("La cantidad del movimiento es invalida");
							}
				}).error(function(data) {
					$scope.showAviso("No fue posible realizar movimiento.");
				});
		}else{
			$scope.showAviso(conteoArticulo.autorizacion.descripcion);
		}
	}
	
	$scope.guardaConteoArticulo = function(){
		if($scope.isNew){
			$scope.creaConteoArticulo();
		}else{
			$scope.actualizaConteoArticulo();
		}		
	}
	
	$scope.creaConteoArticulo = function(){
		var conteoArticulo = {articulo: $scope.movimientoInventario.articulo,
				  existenciaFisica: $scope.parametrosInventario.existenciaFisica,
				  existenciaSistema: $scope.movimientoInventario.existenciaActual, 
				  fecha: new Date(), puntoVenta: $scope.movimientoInventario.puntoVentaVO,
				  movimientoInventario: $scope.movimientoInventario
				 };

			if($scope.validaFormConteo()){
				inventarioService.registrarConteo(conteoArticulo).success(function(data) {					
					$scope.resultado = data;
						if($scope.resultado > 0){
							$scope.buscarConteoArticulos();							
						}else{
							$scope.showAviso("No fue posible guardar la información.");							
						}
				}).error(function(data) {
						$scope.showAviso("Error, no fue posible guardar la información.");
				});
			}
	}
	
	$scope.actualizaConteoArticulo = function(){
		$scope.conteoArticuloTmp.existenciaFisica = $scope.parametrosInventario.existenciaFisica;
		if($scope.validaFormConteo()){
				inventarioService.actualizarConteo($scope.conteoArticuloTmp).success(function(data) {					
					$scope.resultado = data;
						if($scope.resultado > 0){
							$scope.buscarConteoArticulos();							
						}else{
							$scope.showAviso("No fue posible guardar la información.");							
						}
				}).error(function(data) {
						$scope.showAviso("Error, no fue posible guardar la información.");
				});			
		}
		
	}
	
	$scope.finalizaConteoArticulo = function(){
		
				inventarioService.finalizarConteoInventario().success(function(data) {					
					$scope.resultado = data;
						if($scope.resultado > 0){
							$scope.buscarConteoArticulos();
							$scope.cerrar();
						}else{
							$scope.showAviso("No fue posible actualizar la información.");							
						}
				}).error(function(data) {
						$scope.showAviso("Error, no fue posible actualizar la información.");
				});			
		
		
	}
	
	$scope.confirmacionFinalizaConteoArticulo = function(){
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
			        		$scope.finalizaConteoArticulo();			     				        	
			        	}
			        }); 
			    });
			};			
			
			$scope.showConfirmacion ("Est\u00e1 seguro de finalizar el conteo de inventario?");
			
	};
	
	$scope.validaFormConteo = function(){		
		if ($scope.formConteo.$invalid) {            
            angular.forEach($scope.formConteo.$error, function (field) {
              angular.forEach(field, function(errorField){
            	  errorField.$setDirty();
              })
            });                        
            return false;
        }else{
			return true;
		}
	}
	
	$scope.validaFormMovimiento = function(conteoArticulo){
		$(".type-mov").removeClass("has-error");
		conteoArticulo.error = false;
		if(conteoArticulo.tipoMovimiento == null){
			 $("#tipoMovimiento_"+conteoArticulo.idArticuloCorte).attr("class","type-mov form-group has-error");		          
			   conteoArticulo.error = true;
			   return false;
		}else{
			return true;
		}
	}

	$scope.cerrar = function(){
		$('.modal').hide();
		$('.modal-backdrop').remove();
	};  
    
	$scope.init =function(){
		 $scope.consultarTiposMovimiento();		 
		 $scope.buscarConteoArticulos();
	 }
	 
	 $scope.init();
	
});

