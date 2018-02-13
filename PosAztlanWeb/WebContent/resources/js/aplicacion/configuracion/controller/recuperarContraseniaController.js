'use strict';

angular.module('recuperarContraseniaModule').controller("RecuperarContraseniaController",['$scope', 'RecuperarContraseniaService','ErrorFactory', 
  function($scope, RecuperarContraseniaService,ErrorFactory){	 	
	 		  
		 var self = this;
		 
		 self.email='';
		 self.errorGeneral='';
		 self.mensajeGeneral='';
		 
		 self.submit = submit;		 
		 
		 function submit(){
			 
			 var usuarioLoginVO = {usuario:self.email,contrasenia:''};
			 
			 RecuperarContraseniaService.recuperarContrasenia(usuarioLoginVO)
	            .then(
	            function(d) {
	            	$scope.mensajeGeneral = 'Se ha enviado un correo electr\u00F3nico con los datos de tu nueva contrase\u00F1a.';
	            	self.email='';
	            },
	            function(errResponse){
	                console.error('Error recuperando la contraseña.',errResponse);
	                console.log(ErrorFactory.getErrorMessage(errResponse.status));
	                $scope.errorGeneral = "No se pudo recuperar la contrase\u00F1a. "+errResponse.status+":"+ErrorFactory.getErrorMessage(errResponse.status);
	            }
	        );      
         }

}]);