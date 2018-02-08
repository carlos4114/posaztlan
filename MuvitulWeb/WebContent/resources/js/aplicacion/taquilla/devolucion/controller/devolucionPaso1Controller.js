'use strict';

var devolucionBoletoController = angular.module('indexModule').controller('devolucionBoletoController', function($controller,$scope,$filter,devolucionBoletoService,ModalService,statusFactory){	
	$scope.status	= { paso1	:"selected", paso2 :"", paso3	:"", paso4	:"",  paso5  :"", numeroPaso:1	}

	$scope.ticket = null;
	$controller('devolucionBoletoControllerPaso2',{$scope : $scope });
	$controller('devolucionBoletoControllerPaso3',{$scope : $scope });
    $controller('modalController',{$scope : $scope });

		$scope.asignarPaso =function( paso){
			if($scope.ticket  == null || $scope.fin == true || $scope.ticket.devolucionesVO.length  > 0 || $scope.ticket.exhibicionVencida == true)
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
			
			devolucionBoletoService.consultarTicket(idTicket).success(function(data) {
				$scope.ticket = data;
				$scope.devolucion.idTicketVenta = $scope.ticket.idTicket;
				$scope.cargarCatalogos();

			}).error(function(data) {
 					$scope.ticket		= null;
 			         $scope.showError("No se encontró Información para el no. de ticket: " +  $scope.idTicket);

			});
		}
		
		
		
});
 