'use strict';

angular.module('indexModule').controller("CorteCajaController",['$scope','GlobalFactory', 'CorteCajaService','ErrorFactory','ModalService','PropertiesFactory', 
    function($scope,GlobalFactory, CorteCajaService,ErrorFactory,ModalService,PropertiesFactory){	 			
	 
	 $scope.inicializarValores = function(){
		 $scope.listaCargoAjuste = null;		 	
	 	 $scope.listaCortesCaja = null;
	     $scope.cajaVO = {idCorteCaja:null,efectivoReal:null,efectivoSistema:null,comentarios:'',idCargoAjuste:null,entradaCaja:null};
	 	 $scope.conciliado=false;
	 	 $scope.efectivoCuadra=false;
	     $scope.errorGeneral='';
		 $scope.mensajeGeneral='';
		 $scope.errorConciliar='';
		 
	 }	
	
	 $scope.conciliarEfectivo = function() {
		 CorteCajaService.obtenerEfectivo()
		 .then(
	      function(d) {
        	  $scope.cajaVO.efectivoSistema = d;
        	  $scope.efectivoCuadra=$scope.cajaVO.efectivoSistema===$scope.cajaVO.efectivoReal;
        	  $scope.conciliado=true;
	      },
          function(errResponse){
        	  $scope.conciliado=false;
     	 	  $scope.efectivoCuadra=false;       
     	 	  $scope.errorConciliar = "No se pudo obtener el efectivo en Sistema. "+ErrorFactory.getErrorMessage(errResponse.status);
          });
     }
	 
	 $scope.obtenerUltimosCortes = function() {
		 CorteCajaService.obtenerUltimosCortes()
		 .then(
           function(d) {
        	 $scope.listaCortesCaja = d;
 	      },
          function(errResponse){
          });
     }	  
	 
	 $scope.obtenerCatCargoAjuste = function() {
		 CorteCajaService.obtenerCatCargoAjuste()
		 .then(
	      function(d) {
        	  $scope.listaCargoAjuste = d;
	      },
          function(errResponse){
          });
     }
	 
	 $scope.limpiarFormulario = function(){     	
		 $scope.formCorteCaja.$setPristine();
	 	 $scope.listaCortesCaja = null;
	     $scope.cajaVO = {idCorteCaja:null,efectivoReal:null,efectivoSistema:null,comentarios:'',idCargoAjuste:null,entradaCaja:null};
	 	 $scope.conciliado=false;
	 	 $scope.efectivoCuadra=false;
				 
		 $scope.obtenerUltimosCortes();
	 }
	 
	 $scope.guardarCorte = function(autorizacion) {
 		 
		 $scope.errorGeneral='';
		 $scope.mensajeGeneral='';
		 $scope.errorConciliar='';

		 $scope.cajaVO.idAutorizacion = autorizacion.idAutorizacion;
		 
		 if(autorizacion.status==1){
	
			 CorteCajaService.guardarCorte($scope.cajaVO)
			 .then(
		      function(d) {
		    	  if(d.errorCode){
		        	  $scope.errorGeneral = d.message;
		    	  }else{	 
			 		  $scope.mensajeGeneral = 'Se ha guardado el corte de caja.';
			 		  $scope.limpiarFormulario();
		    	  }
		      },
	          function(errResponse){
	   		   		$scope.errorGeneral = "No se pudo guardar el corte de caja. "+ErrorFactory.getErrorMessage(errResponse.status);
	          });
		 }else{
		   		$scope.errorGeneral = autorizacion.descripcion;			 
		 }
     }	
	 
	 $scope.showAuthorization = function(tipo){
		 
			ModalService.showModal({
		    	templateUrl: 'vistas/templatemodal/templateModalAutorizacion.html',
	        	controller: 'authorizationModalController',
	        	inputs:{ tipoAutorizacion: PropertiesFactory.getTipoAutorizacion(tipo)}
		      }).then(function(modal) {
		        modal.element.modal();
		        modal.close.then(function(result) {
		        	$scope.guardarCorte(result);		    		
		        }); 
	 	      });
				 
	 }
	 
	 $scope.confirmacionSalida = function(){
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
			        		$scope.showAuthorization("corteDeCaja");			     				        	
			        	}
			        }); 
			    });
			};
			
		   $scope.showConfirmacion ("¿Est\u00e1 seguro que desea registrar el corte?");
	};
	 
	$scope.ocultarConciliacion = function(){
		if($scope.conciliado != null){
			$scope.errorGeneral='';
			 $scope.mensajeGeneral='';
			 $scope.errorConciliar='';
			if($scope.conciliado==true){							     
	
			    $scope.conciliado=false;	
			    $scope.efectivoCuadra=false;	
			    $scope.formCorteCaja2.$setPristine();
			}
		}
	 }
	 
	 $scope.submit = function(){
		 
	    $scope.confirmacionSalida();	
	 }
	 
	 $scope.inicializarValores();	
	 $scope.obtenerUltimosCortes();
	 $scope.obtenerCatCargoAjuste();	

}]);