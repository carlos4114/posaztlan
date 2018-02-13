'use strict';

var devolucionDulceriaControllerPaso3 = angular.module('indexModule').controller('devolucionDulceriaControllerPaso3', function($controller,$scope,$filter,statusFactory,devolucionDulceriaService){
 
 	
	$scope.crearDevolucion = function(devolucion) {
		devolucionDulceriaService.crearDevolucion(devolucion).success(function(data) {
 			
// 			$scope.devolucion = data;
// 			$scope.devolucion.importe = $scope.ticket.subtotal;
  			$scope.asignarPaso(3);
 			$scope.fin = true;
	
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
 