'use strict';

angular.module('indexModule').controller("SalasController",['$scope','GlobalFactory', 'ModalService','SalasService','ErrorFactory', 
    function($scope,GlobalFactory, ModalService,SalasService,ErrorFactory){	 			
	 var idEmpresa = GlobalFactory.getIdEmpresa(); 
	 
	 $scope.modificarButaca = function(asiento) {
		  SalasService.actualizaAsiento($scope.salaVO.asientosListVO,asiento)
			 .then(
		      function(d) {
		    	  $scope.salaVO.asientosListVO = d;
		      },
	         function(errResponse){
	         });
     }
	 
	 $scope.obtenerMapaNuevo = function(filas,maxAsientos) {
		  SalasService.obtenerMapaNuevo(filas,maxAsientos)
		 .then(
	      function(d) {
       	  $scope.salaVO.asientosListVO = d;
	      },
         function(errResponse){
         });
    }
	 
	  
	  $scope.consultaCinesXEmpresa = function(idEmpresa) {
		  SalasService.consultaCinesXEmpresa(idEmpresa)
		 .then(
	      function(d) {
        	  $scope.listaCines = d;
	      },
          function(errResponse){
          });
     }
	 	 	  
	 $scope.inicializarValores = function(){
		 $scope.listaSalas = null;		 	
	 	 $scope.listaCines = null;
	     $scope.salaVO = {idSala:null,idCine:null,nombre:'',activo:true,cupo:null,tieneNumerado:false,cupoActivo:true,
	    		 		  idCupoSala:null,filas:null,maxAsientos:null,asientosListVO: null};
	     $scope.errorGeneral='';
		 $scope.mensajeGeneral='';			
	 }	 
	 
	 $scope.obtenerSalas = function(idCine) {
		 SalasService.obtenerSalas(idCine)
		 .then(
	      function(d) {
        	  $scope.listaSalas = d;
	      },
          function(errResponse){
          });
     }
	 
	 $scope.limpiarFormulario = function(){     	
		 $scope.formSalas.$setPristine();
	     $scope.salaVO = {idSala:null,idCine:null,nombre:'',activo:true,cupo:null,tieneNumerado:false,cupoActivo:true,
		 		  idCupoSala:null,filas:null,maxAsientos:null,asientosListVO: null};
	     $scope.listaSalas=null;
	     $scope.listaCines=null;
	     $scope.consultaCinesXEmpresa(idEmpresa);	     
	 }
	 
	 $scope.cambiarFilasOAsientos = function(){     	
		 if($scope.salaVO.filas!=null && $scope.salaVO.maxAsientos!=null){
			 if($scope.salaVO.filas>0 && $scope.salaVO.maxAsientos>0){
				 $scope.obtenerMapaNuevo($scope.salaVO.filas,$scope.salaVO.maxAsientos);
			 }			 
		 }
	 }

	 
	 $scope.guardar = function(salaVO) {
		 
		 $scope.errorGeneral='';
		 $scope.mensajeGeneral='';
		 SalasService.guardar(salaVO)
		 .then(
	      function(d) {
	    	  if(d.errorCode){
	        	  $scope.errorGeneral = d.message;
	    	  }else{	 
		 		  $scope.mensajeGeneral = 'Se ha guardado la sala.';
		 		  $scope.limpiarFormulario();
	    	  }
	      },
          function(errResponse){
   		   		$scope.errorGeneral = "No se pudo guardar la sala. "+ErrorFactory.getErrorMessage(errResponse.status);
          });
     }
	 
	 $scope.actualizar = function(salaVO) {
		 
		 $scope.errorGeneral='';
		 $scope.mensajeGeneral='';
		 SalasService.actualizar(salaVO)
		 .then(
	      function(d) {
	    	  if(d.errorCode){
	        	  $scope.errorGeneral = d.message;
	    	  }else{	 
		 		  $scope.mensajeGeneral = 'Se ha actualizado la sala.';
		 		  $scope.limpiarFormulario();
	    	  }
	      },
          function(errResponse){
   		   		$scope.errorGeneral = "No se pudo actualizar la sala. "+ErrorFactory.getErrorMessage(errResponse.status);
          });
     }
	 
	 $scope.confirmaGuardado = function(){
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
			    	    	if($scope.salaVO.idSala === null){
			    	    		$scope.guardar($scope.salaVO);
			    	    	}else{
			    	    		$scope.actualizar($scope.salaVO);
			    	    	}
			        	}
			        }); 
			    });
			};
			
		   $scope.showConfirmacion ("¿Est\u00e1 seguro que desea guardar la sala?");
	};
	 
	 $scope.editar = function(idSala) {
			$scope.errorGeneral='';
			$scope.mensajeGeneral='';
	        
			for(var i = 0; i < $scope.listaSalas.length; i++){
	            if($scope.listaSalas[i].idSala === idSala) {	            	
	            	$scope.salaVO = angular.copy($scope.listaSalas[i]);
	                break;
	            }
	        }	        
	   }
	 
	 $scope.submit = function(){	    	
	     $scope.confirmaGuardado();
	 }

	 $scope.cambiarCine = function(idCine){
		 $scope.obtenerSalas(idCine);		 
	 }	 
	 	 		
	 $scope.inicializarValores();	
	 $scope.consultaCinesXEmpresa(idEmpresa);

}]);