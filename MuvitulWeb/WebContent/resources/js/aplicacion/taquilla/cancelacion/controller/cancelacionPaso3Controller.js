'use strict';

var cancelacionBoletoControllerPaso3 = angular.module('indexModule').controller('cancelacionBoletoControllerPaso3', function($controller,$scope,statusFactory,cancelacionBoletoService,PropertiesFactory){
	
	$scope.pagosVO  		= [];
	$scope.cancelacionTicket = {};
	
	$scope.crearCancelacion = function(cancelacion) {
		$scope.complementacionCancelacion(cancelacion);
		cancelacionBoletoService.crearCancelacion(cancelacion).success(function(data) {
			$scope.cancelacionTicket =data;
			$scope.asignarPaso(3);
 		}).error(function(data) {
		});
	}
	
	$scope.complementacionCancelacion = function(cancelacion) {
		 	cancelacion.idTicketVenta =$scope.ticket.idTicket
			$scope.generaListaPagos($scope.listaPagosActuales);
			$scope.generaListaPagos($scope.listaPagosCancelados)
			cancelacion.pagosVO =$scope.pagosVO ;
	}

	$scope.generaListaPagos = function (listaPagos){
		 angular.forEach(listaPagos, function (pago) {
			 if(pago.estatusPagoVO.idEstatus != ''){
				 pago.estatusPagoVO.clave='CAN-003';
				 pago.estatusPagoVO.nombre='CANCELADO';
			 }
			$scope.pagosVO.push(pago)  
           }); 
	}
	
	
 	$scope.validaForm = function(form){
		if (form.$invalid) {            
            angular.forEach(form.$error, function (field) {
              angular.forEach(field, function(errorField){
            	  errorField.$setDirty();
              })
            });                        
            return false;
        }else{
			return true;
		}
	}
	
	$scope.resetDatos = function (){
		$scope.pagosVO  				= [];
		$scope.cancelacionTicket 		= {};
		$scope.listaMotivosCancelacion	= {};
		$scope.cancelacion 				= {};
		$scope.listaPagos  				= [];
		$scope.listaPagosActuales  		= [];
		$scope.listaPagosCancelados 	= [];
	 	$scope.pago	 					= { porPagar:0, pagado:0, montoCancelado:0};
		$scope.montoCancelado			= 0;
		$scope.status 					= { paso1	:"selected", paso2 :"", paso3	:"", paso4	:"",  paso5  :"", numeroPaso:1	}
		$scope.ticket 					= null;
		$scope.idTicket 				= null;
		$scope.formCancelacion.$setPristine();
		$scope.formPagos.$setPristine();
	}
 	
	  
 });
 