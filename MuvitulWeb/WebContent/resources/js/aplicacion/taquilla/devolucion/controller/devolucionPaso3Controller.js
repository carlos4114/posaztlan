'use strict';

var devolucionBoletoControllerPaso3 = angular.module('indexModule').controller('devolucionBoletoControllerPaso3', function($controller,$scope,$filter,ModalService,statusFactory,devolucionBoletoService){
    $controller('modalController',{$scope : $scope });

    $scope.modalPrinter = function() {
        ModalService.showModal({
          templateUrl: 'vistas/templatemodal/templatePrintTicket.html',
          controller: 'modalControllerPrintTicket',
    	    scope: $scope
        }).then(function(modal) {
          modal.element.modal();
        });
  	};
 	
	$scope.crearDevolucion = function(devolucion) {
 		devolucionBoletoService.crearDevolucion(devolucion).success(function(data) {
 			
 			$scope.devolucion = data;
 			$scope.devolucion.importe = $scope.ticket.subtotal;
  			$scope.asignarPaso(3);
 			$scope.fin = true;
 		}).error(function(data) {
 		});
	}
 
	$scope.imprimirCortesia = function(){
 		devolucionBoletoService.imprimirCortesia($scope.ticket.idTicket, $scope.devolucion.idDevolucion ).success(function(data,status,headers) {	 		 
			$scope.listaImpresiones=data;
 			$scope.modalPrinter ();
 		   
		}).error(function(data) {
		  });
	}
	
	$scope.resetValues = function() {
		$scope.fin = false;
		$scope.ticket = null;
		$scope.idTicket =null;
		$scope.devolucion ={};
        $scope.formDevolucion.$setPristine()
		$scope.status= statusFactory.statusPaso(1);
		$scope.status.numeroPaso = 1;
	}
	
	$scope.reiniciarDevolucion = function() {
	    $scope.resetValues();
	}
	  
});
 