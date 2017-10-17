'use strict';
var cancelacionDulceriaController = angular.module('indexModule').controller('cancelacionDulceriaController', function($controller,$scope,statusFactory,PropertiesFactory,ModalService, cancelacionDulceriaService ){

	$scope.status = { paso1	:"selected", paso2 :"", paso3	:"", paso4	:"",  paso5  :"", numeroPaso:1	}
	$scope.ticket = null;
	$controller('cancelacionDulceriaControllerPaso2',{$scope : $scope });
	$controller('cancelacionDulceriaControllerPaso3',{$scope : $scope });
    $controller('modalController',{$scope : $scope });

	$scope.montoCancelado=0;
	
	$scope.asignarPaso = function( paso){
		if( $scope.fin == true || $scope.listaPagosCancelados.length == 0)
			return;
		$scope.status= statusFactory.statusPaso(paso);
		$scope.status.numeroPaso = paso;
	}
		
	$scope.consultarTicket = function(idTicket ) {
		
		if(idTicket == undefined){
            $scope.showError("Es necesario introducir un número de ticket");
			$scope.ticket		= null;

            return;
		}
		cancelacionDulceriaService.consultarTicketProductos(idTicket).success(function(data) {
			$scope.ticket = data;
 			$scope.listaPagos= $scope.ticket.pagosVO;
			$scope.asignarStatusPagos($scope.listaPagos); 
			$scope.cargarCatalogos();
		}).error(function(data) {
	 		$scope.ticket = null;
	         $scope.showError("No se encontró Información para el no. de ticket: " +  $scope.idTicket);

		});
	}
	
	$scope.cancelarPago = function(pago ) {
		pago.status=0;
		pago.statusPagoColor="btn-warning";	
		pago.label ='CACELANDO...';
		$scope.listaPagosCancelados.push(angular.copy(pago));
		$scope.pago.montoCancelado += pago.importe;
	    $scope.calcularTotalPagado($scope.listaPagosActuales);
	}
	
	$scope.descancelar = function(pago ) {
 		angular.forEach($scope.listaPagosCancelados, function (item) {
			 if(pago.idPago ==item.idPago){ 
		 			var index = $scope.listaPagosCancelados.indexOf(item);
				    $scope.listaPagosCancelados.splice(index, 1);
			  }
		 });
		 
 		pago.status=1;
		pago.label=pago.estatusPagoVO.nombre;
		pago.statusPagoColor="btn-success";	 
		$scope.pago.montoCancelado -= pago.importe;
		$scope.calcularTotalPagado($scope.listaPagosActuales);
	}
	
	
	$scope.asignarStatusPagos = function(listaPagos ) {
		
		 angular.forEach(listaPagos, function (field) {
			 if(field.estatusPagoVO.clave == 'PAG-001'){
				 field.status=1;
				 field.label=field.estatusPagoVO.nombre;
			 	 field.statusPagoColor="btn-success";	 
			 }
			 if(field.estatusPagoVO.clave == 'CAN-003'){
				 field.status=0;
			 	 field.statusPagoColor="btn-danger";	
			 	 field.label=field.estatusPagoVO.nombre;
			 }
		});
	}
	 
 });
 