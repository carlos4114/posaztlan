'use strict';

angular.module('indexModule').controller("EntradaOrdenCompraController",['$scope','GlobalFactory', 'EntradaOrdenCompraService', 'ModalService','DataUtils','ErrorFactory', 
    function($scope,GlobalFactory, EntradaOrdenCompraService,ModalService,DataUtils,ErrorFactory){	 			
	 var idEmpresa = GlobalFactory.getIdEmpresa();  
	 $scope.fileUrl = null;
	 $scope.parametrosInventario = {};

	$scope.cerrarOrdenCompra = function(ordenCompraVO) {
		
		 $scope.errorGeneral='';
		 $scope.mensajeGeneral='';
		 
		 $scope.agregar();
		 
		 EntradaOrdenCompraService.cerrarOrdenCompra(ordenCompraVO)
		 .then(
	      function(d) {
	    	  if(d.errorCode){
	        	  $scope.errorGeneral = d.message;
	    	  }else{	 
		 		  $scope.mensajeGeneral = 'Se ha guardado la orden de compra';
		 		  $scope.limpiarFormulario();
	    	  }
	      },
         function(errResponse){
  		   		$scope.errorGeneral = "No se pudo guardar la orden de compra. "+ErrorFactory.getErrorMessage(errResponse.status);
         });
    }

	 	
	 $scope.obtenerOrdenCompra = function(){
		 $scope.errorGeneral='';
		 $scope.mensajeGeneral='';
		 
		 EntradaOrdenCompraService.obtenerOrdenCompra($scope.filtrosVO)
		 .then(
		  function(d) {
			  $scope.ordenCompraVO = d;
			  $scope.listaProductos = angular.copy($scope.ordenCompraVO.productos);
			  $scope.ordenCompraVO.productos = [];
			  
		  },
		  function(errResponse){
		  });
	 }
	 
	 $scope.seleccionarTodos = function() {
		 for(var i = 0; i < $scope.listaProductos.length; i++){
			 $scope.listaProductos[i].seleccionado = $scope.seleccionarTodosCh;			 
		 }
     }
	 
	 $scope.agregar = function(){
		 	var found = false; 
			$scope.errorGeneral = '';
		 	
			for(var i = 0; i < $scope.listaProductos.length; i++){
				if($scope.listaProductos[i].seleccionado == true) {
					if($scope.listaProductos[i].precioUnitario != null){
						if($scope.listaProductos[i].cantidadFinal == null){
							if($scope.listaProductos[i].cantidadRestante == 0){
								$scope.ordenCompraVO.productos.push(angular.copy($scope.listaProductos[i]));
							}else{
								$scope.errorGeneral = 'No se puede agregar "'+$scope.listaProductos[i].nombre+'". La cantidad de entrada debe ser mayor a cero.';
							}
							
						}else{
							if($scope.listaProductos[i].cantidadFinal > $scope.listaProductos[i].cantidadRestante){
								$scope.errorGeneral = 'No se puede agregar "'+$scope.listaProductos[i].nombre+'". La cantidad de entrada no puede ser mayor a la cantidad restante.';
							}else{
								$scope.ordenCompraVO.productos.push(angular.copy($scope.listaProductos[i]));
							}
						}
					}else{
						$scope.errorGeneral = 'No se puede agregar "'+$scope.listaProductos[i].nombre+'". El precio final debe ser mayor a cero.';
					}
				}
			}
	 }
	 
	 $scope.inicializarValores = function(){
		 $scope.seleccionarTodosCh = false;
		 $scope.listaProductos = null;
		 $scope.filtrosVO = {idEmpresa: idEmpresa, ordenCompra: null};
		 $scope.productoVO = {idEmpresa: idEmpresa, idProducto:null, nombre:'', descripcion:'', 
	    		 idFamilia:null, nombreFamilia:null, idTipoProducto:null, nombreTipoProducto:null, 
	    		 idMedida: null, nombreMedida:null, idUnidadMedida:null, nombreUnidadMedida:null,
	    		 idMarca:null, nombreMarca:null, precioUnitario:null, precioUnitarioFinal:null, 
	    		 nacional:null, cantidad:null, cantidadFinal:null, seleccionado:null, cantidadRestante:null};
	 	 $scope.ordenCompraVO = {idOrdenCompra:null,idProveedor:null, idEmpresa:idEmpresa, descuento: null, parcial:false, productos: []}
	     $scope.errorGeneral='';
		 $scope.mensajeGeneral='';
	 }	 
	 
	 $scope.limpiarFormulario = function(){  
		 $scope.seleccionarTodosCh = false;
		 $scope.listaProductos = null;
	 	 $scope.filtrosVO = {idEmpresa: idEmpresa, ordenCompra: null};
	 	 $scope.productoVO = {idEmpresa: idEmpresa, idProducto:null, nombre:'', descripcion:'', 
	    		 idFamilia:null, nombreFamilia:null, idTipoProducto:null, nombreTipoProducto:null, 
	    		 idMedida: null, nombreMedida:null, idUnidadMedida:null, nombreUnidadMedida:null,
	    		 idMarca:null, nombreMarca:null, precioUnitario:null, precioUnitarioFinal:null, 
	    		 nacional:null, cantidad:null, cantidadFinal:null, seleccionado:null, cantidadRestante:null};
	 	 $scope.ordenCompraVO = {idOrdenCompra:null,idProveedor:null, idEmpresa:idEmpresa, descuento: null, parcial:false, productos: []}
	 }
	 
	 $scope.guardarParcial= function() {	
		 $scope.ordenCompraVO.parcial = true; 
		 
		 if($scope.ordenCompraVO.nombreEstatusOrdenCompra == 'CERRADA'){
			 $scope.errorGeneral = 'La orden de compra ya fue cerrada.';
		 }else{
			 $scope.submit();
		 }
		 
	 }
	 
	 $scope.cerrarOrdenCompra= function() {	
		 $scope.ordenCompraVO.parcial = false; 
		 
		 if($scope.ordenCompraVO.nombreEstatusOrdenCompra == 'CERRADA'){
			 $scope.errorGeneral = 'La orden de compra ya fue cerrada.';
		 }else{
			 $scope.submit();
		 }
	 }
	 
	 $scope.guardar= function() {	
		 $scope.errorGeneral='';
		 $scope.mensajeGeneral='';
		 
		 $scope.agregar();
		 
		 if( $scope.errorGeneral == ''){
			 EntradaOrdenCompraService.registrarEntradaOrdenCompra($scope.ordenCompraVO
			 ).then(function(d) {
		    	  if(d.errorCode){
		        	  $scope.errorGeneral = d.message;
		    	  }else{	 
			 		  $scope.mensajeGeneral = 'La entrada se realizo correctamente.';
			 		  $scope.limpiarFormulario();
			 		  $scope.formEntradas.$setPristine();			
		    	  }
		      },
		      
		      function(errResponse){
	  		   		$scope.errorGeneral = "No se pudo guardar la entrada. "+ErrorFactory.getErrorMessage(errResponse.status);
	  		   		$scope.ordenCompraVO.productos = [];
	         });
		 }
		
	 }
	 
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
			        		$scope.guardar($scope.ordenCompraVO);        				    	        
			        	}
			        }); 
			    });
			};
			
		   $scope.showConfirmacion ("¿Est\u00e1 seguro que desea guardar la entrada?");
	};
	 
	 $scope.inicializarValores();	
	 
	 
}]);