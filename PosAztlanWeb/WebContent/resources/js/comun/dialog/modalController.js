angular.module('indexModule').controller('modalController', function($scope, ModalService) {
	$scope.resultadoConfirmacion=false;
	$scope.resultadoAutorizacion={};
	/* Modal Aviso */
	$scope.showAviso = function(messageTo) {
      ModalService.showModal({
        templateUrl: 'vistas/templatemodal/templateModalAviso.html',
        controller: 'mensajeModalController',
        inputs:{ message: messageTo}
      }).then(function(modal) {
        modal.element.modal();
      });
	};
	
	/* Modal Error */
	$scope.showError = function(messageTo) {
      ModalService.showModal({
        templateUrl: 'vistas/templatemodal/templateModalError.html',
        controller: 'mensajeModalController',
        	  inputs:{ message: messageTo}
      }).then(function(modal) {
        modal.element.modal();
      });
	};
	
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
	        		$scope.resultadoConfirmacion=true;
	        	}
	         
	        }); 
	    });
	};

});