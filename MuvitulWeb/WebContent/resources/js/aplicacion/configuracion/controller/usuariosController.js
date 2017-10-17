'use strict';

angular.module('indexModule').controller("UsuariosController",['$scope', 'CambiarContraseniaService','ErrorFactory', 
    function($scope, CambiarContraseniaService,ErrorFactory){	 	
				 
		 $scope.contraseniaActual='';
		 $scope.contraseniaNueva='';
		 $scope.contraseniaConfirma='';
		 $scope.errorGeneral='';
		 $scope.mensajeGeneral='';
		 
		 $scope.cambiarContrasenia = cambiarContrasenia;		 
		 
		 function cambiarContrasenia(){

			 if($scope.contraseniaNueva!=$scope.contraseniaConfirma){
	            $scope.errorGeneral = "La contrase\u00F1a nueva y la confirmaci\u00F3n no coinciden.";
	            return false;
			 }
			 
			 var cambioContraseniaVO = {contraseniaActual:$scope.contraseniaActual,contraseniaNueva:$scope.contraseniaNueva};
			 $scope.errorGeneral='';
			 $scope.mensajeGeneral='';
			 
			 CambiarContraseniaService.cambiarContrasenia(cambioContraseniaVO)
	           .then(
	           function(d) {
	        	 if(d){
	        		 $scope.errorGeneral = ErrorFactory.getErrorSecurityMessage(d.errorCode);
	        	 }else{
		           	 $scope.mensajeGeneral = 'Se ha cambiado la contrase\u00F1a.';
		           	 $scope.contraseniaActual='';
		           	 $scope.contraseniaNueva='';
		           	 $scope.contraseniaConfirma='';
	        	 }
	           },
	           function(errResponse){
	        		   $scope.errorGeneral = "No se pudo cambiar la contrase\u00F1a. "+ErrorFactory.getErrorMessage(errResponse.status);
	           }
	       );      
	    }
}]);