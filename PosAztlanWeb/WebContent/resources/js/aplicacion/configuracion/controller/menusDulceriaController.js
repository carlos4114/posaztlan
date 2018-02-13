'use strict';

var MenusDulceriaController = angular.module('indexModule').controller("MenusDulceriaController", function($scope,menusDulceriaService,ModalService){

	$scope.paquete={};
	$scope.listaPaquetes={};
	$scope.listaProductos={};
	 
	$scope.guardarPaquete =function( paquete){
		
	}
	
	$scope.eliminarPaquete =function( paquete){
 		 
		 menusDulceriaService.eliminarPaquete(paquete.idPaquete).success(function(data) {	
				$scope.consultarPaquetes ();

		  }).error(function(data) {
				console.log(data);
		  });
		 
	}
	$scope.onChange = function (e, file) {
		var data = file[0];
		 
	  };
	//Consultar productos 
	$scope.consultarProductos =function( ){
		menusDulceriaService.consultarProductos().success(function(data) {	
				
				$scope.listaProductos=data;
 		  }).error(function(data) {
 				console.log(data);
		  });
	}
	
	$scope.consultarPaquetes =function( ){
		menusDulceriaService.consultarPaquetes().success(function(data) {				
			$scope.listaPaquetes=data;
		  }).error(function(data) {
				console.log(data);
	  });
	}

	 $scope.guardarPaqueteConfirm = function(paquete){
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
			        		$scope.guardarPaquete(paquete);
			        	}
			        }); 
			    });
			};
		 
			$scope.showConfirmacion ("¿Estas seguro de guardar el paquete ?");
		 
	};
	
	$scope.consultarPaquetes ();
	$scope.consultarProductos();
	
});