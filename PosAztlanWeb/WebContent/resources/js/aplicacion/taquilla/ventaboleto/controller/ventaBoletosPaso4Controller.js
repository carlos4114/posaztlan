 

var VentaBoletosPaso4Controller = angular.module('indexModule').controller("VentaBoletosPaso4Controller", function($controller,$scope,$interval,$filter,ModalService,taquillaService){

 	//$controller('VentaBoletosPaso1Controller',{$scope : $scope });
 	//$controller('VentaBoletosPaso5Controller',{$scope : $scope });

   
   $scope.Timer = null;
   
   $scope.BorrarAsientos = function () {
	   $scope.totalAsientos = 0;
	   $scope.borrarReservadosUsuario();
   };
   
   $scope.StartTimerAsientos = function () {
	   $scope.consultarMapaConAsistencia();
       $scope.Timer = $interval(function () {	 $scope.consultarMapaConAsistencia() }, 10000);
    };

    $scope.StopTimerAsientos = function () {
        if (angular.isDefined($scope.Timer)) {
            $interval.cancel($scope.Timer);
        }
    }
    
});