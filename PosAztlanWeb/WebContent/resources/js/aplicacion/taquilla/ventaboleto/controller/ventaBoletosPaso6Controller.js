 

var VentaBoletosPaso6Controller = angular.module('indexModule').controller("VentaBoletosPaso6Controller", function($scope,$controller,taquillaService,ModalService){
    $controller('modalController',{$scope : $scope });
 
    $scope.ticketVenta={};
	$scope.cambioTotal 		=0.00;
	$scope.pagoConTotal		=0.00;
	$scope.isImpreso		=false;
 
 	$scope.modalPrinter = function() {
      ModalService.showModal({
        templateUrl: 'vistas/templatemodal/templatePrintTicket.html',
        controller: 'modalControllerPrintTicket',
  	    scope: $scope
      }).then(function(modal) {
        modal.element.modal();
      });
	};
	
	$scope.imprimirBoleto =function(){
			$scope.isImpreso=true;
 		taquillaService.imprimirTickets($scope.ticketVenta.idTicket,$scope.pagoConTotal, $scope.cambioTotal).success(function(data,status,headers) {
 			$scope.listaImpresiones=data;
 			$scope.modalPrinter ();

		}).error(function(data) {
		  });
	}

	 

});