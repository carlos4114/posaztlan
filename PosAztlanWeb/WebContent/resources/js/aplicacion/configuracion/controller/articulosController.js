'use strict';

angular.module('indexModule').controller("ArticulosController",['$scope','GlobalFactory', 'ArticulosService','ModalService','ErrorFactory', 
    function($scope,GlobalFactory, ArticulosService,ModalService,ErrorFactory){	 			
	 var idEmpresa = GlobalFactory.getIdEmpresa();  
	 $scope.submit = function(){
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
			        		if($scope.articuloVO.idArticulo === null){
			    	            $scope.guardarArticulo($scope.articuloVO);
			    	        }else{
			    	        	$scope.actualizarArticulo($scope.articuloVO);        	
			    	        }
			        	}
			        }); 
			    });
			};
			
		   $scope.showConfirmacion ("¿Est\u00e1 seguro que desea guardar el art\u00EDculo?");
	};
	 
	 $scope.consultaUnidadesMedida = function() {
		 ArticulosService.consultaUnidadesMedida()
		 .then(
	      function(d) {
        	  $scope.listaUnidadesMedida = d;
	      },
          function(errResponse){
          });
     }
	 
	 $scope.consultaCinesXEmpresa = function(idEmpresa) {
		 ArticulosService.consultaCinesXEmpresa(idEmpresa)
		 .then(
	      function(d) {
        	  $scope.listaCines = d;
	      },
          function(errResponse){
          });
     }
	 
	 $scope.consultaClasificaciones = function(idCine) {
		 ArticulosService.consultaClasificaciones(idCine)
		 .then(
           function(d) {
        	 $scope.listaClasificaciones = d;
 	      },
          function(errResponse){
          });
     }

	 $scope.consultaPuntosVentaXCine = function(idCine) {
		 ArticulosService.consultaPuntosVentaXCine(idCine)
		 .then(
           function(d) {
        	 $scope.listaPuntosVenta = d;
 	      },
          function(errResponse){
          });
     }
	 
	 $scope.inicializarValores = function(){
		 $scope.estatus = null;
		 $scope.listaClasificaciones = null;	
		 $scope.listaUnidadesMedida = null;	
		 $scope.listaArticulos = null;		 	
	 	 $scope.listaPuntosVenta = null;
	 	 $scope.listaArticulosXPuntosVenta = null;
	 	 $scope.listaCines = null;
	     $scope.articuloVO = {idArticulo:null, idCine:null, idClasificacionArt:null, clasificacion:'', unidadMedida:'',nombre:'',activo:true, idUnidadMedida:null, puntoReorden:null, puntosVentaList:null};
	     $scope.errorGeneral='';
		 $scope.mensajeGeneral='';
	 }	 
	 
	 $scope.obtenerArticulos = function(idCine) {
		 ArticulosService.obtenerArticulos(idCine)
		 .then(
	      function(d) {
        	  $scope.listaArticulos = d;
	      },
          function(errResponse){
          });
     }
	 
	 $scope.guardarArticulo = function(articuloVO) {
		 
		 $scope.errorGeneral='';
		 $scope.mensajeGeneral='';
		 ArticulosService.guardarArticulo(articuloVO)
		 .then(
	      function(d) {
	    	  if(d.errorCode){
	        	  $scope.errorGeneral = d.message;
	    	  }else{	 
		 		  $scope.mensajeGeneral = 'Se ha guardado el articulo.';
		 		  $scope.limpiarFormulario();
	    	  }
	      },
          function(errResponse){
   		   		$scope.errorGeneral = "No se pudo guardar el articulo. "+ErrorFactory.getErrorMessage(errResponse.status);
          });
     }
	 
	 $scope.actualizarArticulo = function(articuloVO) {
		 
		 $scope.errorGeneral='';
		 $scope.mensajeGeneral='';
		 ArticulosService.actualizarArticulo(articuloVO)
		 .then(
	      function(d) {
	    	  if(d.errorCode){
	        	  $scope.errorGeneral = d.message;
	    	  }else{	 
		 		  $scope.mensajeGeneral = 'Se ha actualizado el articulo.';
		 		  $scope.limpiarFormulario();
	    	  }
	      },
          function(errResponse){
   		   		$scope.errorGeneral = "No se pudo actualizar el articulo. "+ErrorFactory.getErrorMessage(errResponse.status);
          });
     }
	 
	 $scope.editarArticulo = function(idArticulo) {
			$scope.errorGeneral='';
			$scope.mensajeGeneral='';
	        
			for(var i = 0; i < $scope.listaArticulos.length; i++){
	            if($scope.listaArticulos[i].idArticulo === idArticulo) { 
	            	$scope.articuloVO = angular.copy($scope.listaArticulos[i]);
	            	$scope.consultaPuntosVentaXCine($scope.articuloVO.cineVO.idCine);
	            	if($scope.articuloVO.activo == true){
	            		$scope.estatus = "1";
	            		
	            	}else{
	            		$scope.estatus = "0";
	            	}
	            	break;
	            }
	        }	        			
	   }

	 $scope.cambiarCine = function(idCine){
		 $scope.consultaPuntosVentaXCine(idCine);
		 $scope.obtenerArticulos(idCine);
		 $scope.consultaClasificaciones(idCine);
		 $scope.consultaUnidadesMedida();
		 $scope.errorGeneral='';
		 $scope.mensajeGeneral='';
	 }
	 
	 $scope.cambiarEstatus = function(estatus){
		 if(estatus == "1"){
			 $scope.articuloVO.activo = true;
		 }else{
			 $scope.articuloVO.activo = false;
		 }
	 }
	 
	 $scope.limpiarFormulario = function(){     	
		 $scope.formArticulos.$setPristine();
		 $scope.estatus = null;
	     $scope.articuloVO = {idArticulo:null, idCine:null, idClasificacionArt:null, clasificacion:'', unidadMedida:'',nombre:'',activo:true, idUnidadMedida:null, puntoReorden:null, puntosVentaList:null};
	     $scope.listaClasificaciones = null;	
		 $scope.listaUnidadesMedida = null;	
		 $scope.listaArticulos = null;		 	
	 	 $scope.listaPuntosVenta = null;	 
	   	 $scope.listaArticulosXPuntosVenta = null;
	 	 $scope.listaCines = null;
	     $scope.consultaCinesXEmpresa(idEmpresa);
		 
	 }
	 		
	 $scope.inicializarValores();	
	 $scope.consultaCinesXEmpresa(idEmpresa);
	 $scope.consultaUnidadesMedida();
	 
	 

}]);