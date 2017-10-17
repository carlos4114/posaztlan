'use strict';

var devolucionDulceriaControllerPaso2 = angular.module('indexModule').controller('devolucionDulceriaControllerPaso2', function($controller,$scope,$filter,devolucionDulceriaService,statusFactory,PropertiesFactory,ModalService){
	
	$scope.listaTiposDevolucion		={};
	$scope.listaMotivosDevolucion	={};
	$scope.devolucion				={};
 	$controller('devolucionDulceriaControllerPaso3',{$scope : $scope });
	
	$scope.procesarDevolucion = function(devolucion) {
		if ( $scope.validaForm()) {
       	 	$scope.showAuthorization(devolucion,PropertiesFactory.getTipoAutorizacion('cortesia'));	 
         }else{
				$scope.showAviso("Es necesario llenar los campos obligatorios ");
         }
	}
	
	$scope.validaForm = function(){
		if ( $scope.formDevolucion.$invalid) {            
            angular.forEach($scope.formDevolucion.$error, function (field) {
              angular.forEach(field, function(errorField){
            	  errorField.$setDirty();
              })
            });                        
            return false;
        }else{
			return true;
		}
	}
	
	
	$scope.showAuthorization = function(devolucion,tipoAutorizacion) {

		ModalService.showModal({
	    	templateUrl: 'vistas/templatemodal/templateModalAutorizacion.html',
	    	controller: 'authorizationModalController',
	    	inputs:{ tipoAutorizacion: tipoAutorizacion}
	      }).then(function(modal) {
	        modal.element.modal();
	        modal.close.then(function(result) {	
	        	
	        	if(result.status==1){
	        		devolucion.idAutorizacion=result.idAutorizacion;
	        		$scope.crearDevolucion(devolucion);
	        	}
	        }); 
	      });
			 
		}
		
		$scope.consultarMotivosDevoluciones = function() {
			devolucionDulceriaService.consultarMotivosDevoluciones(1).success(function(data) {
 				$scope.listaMotivosDevolucion=data;
 			}).error(function(data) {
			});
		}
		
		$scope.consultarTiposDevoluciones = function() {
			devolucionDulceriaService.consultarTiposDevoluciones(1).success(function(data) {
				$scope.listaTiposDevolucion		=data;
				console.log(data);
			}).error(function(data) {
			});
		}
			
		$scope.cargarCatalogos=function(){
			$scope.consultarMotivosDevoluciones();
			$scope.consultarTiposDevoluciones();
		};
		
});
 