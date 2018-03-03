'use strict';

angular.module('indexModule').controller("OrdenesCompraController",['$scope','GlobalFactory', 'OrdenesCompraService', 'ModalService','DataUtils','ErrorFactory', 
    function($scope,GlobalFactory, OrdenesCompraService,ModalService,DataUtils,ErrorFactory){	 			
	 var idEmpresa = GlobalFactory.getIdEmpresa();  
	 $scope.fileUrl = null;

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
			        		if($scope.productoVO.idProducto === null){
			    	            $scope.guardarProducto($scope.productoVO);
			    	        }else{
			    	        	$scope.actualizarProducto($scope.productoVO);        	
			    	        }
			        	}
			        }); 
			    });
			};
			
		   $scope.showConfirmacion ("¿Est\u00e1 seguro que desea guardar el producto?");
	};
	
	 $scope.consultaFamilias = function(idEmpresa) {
		 OrdenesCompraService.consultaFamilias(idEmpresa)
		 .then(
	      function(d) {
        	  $scope.listaFamilias = d;
	      },
          function(errResponse){
          });
     }
	 
	 $scope.consultaMarcas = function(idEmpresa) {
		 OrdenesCompraService.consultaMarcas(idEmpresa)
		 .then(
	      function(d) {
        	  $scope.listaMarcas = d;
	      },
          function(errResponse){
          });
     }
	 
	 $scope.consultaProveedores = function(idEmpresa) {
		 OrdenesCompraService.consultaProveedores(idEmpresa)
		 .then(
	      function(d) {
        	  $scope.listaProveedores = d;
	      },
          function(errResponse){
          });
     }
	 
	 $scope.consultaTipos = function(idEmpresa) {
		 OrdenesCompraService.consultaTipos(idEmpresa)
		 .then(
	      function(d) {
        	  $scope.listaTipos = d;
	      },
          function(errResponse){
          });
     }
	 
	 $scope.consultaMedidas = function(idEmpresa) {
		 OrdenesCompraService.consultaMedidas(idEmpresa)
		 .then(
	      function(d) {
        	  $scope.listaMedidas = d;
	      },
          function(errResponse){
          });
     }
	 
	 $scope.obtenerProductos = function(idEmpresa) {
		 OrdenesCompraService.obtenerProductos(idEmpresa)
		 .then(
	      function(d) {
        	  $scope.listaProductos = d;
	      },
          function(errResponse){
          });
     }
	 	 
	 	
	 $scope.buscar = function(filtrosVO){
		 OrdenesCompraService.buscar(filtrosVO)
		 .then(
		  function(d) {
			  $scope.listaProductos = d;
		  },
		  function(errResponse){
		  });
	 }
	 
	 $scope.seleccionarTodos = function() {
		 
     }
	 
	 $scope.seleccionar= function(idProducto, seleccionado) {
		 var found = false;
		 
		 for(var i = 0; i < $scope.productosList.length; i++){
			 if($scope.productosList[i].idProducto == idProducto) {
				 $scope.productosList[i] = seleccionado;
				 found = true;
			 }
		 }
		 
		 if(found == false){
			 for(var i = 0; i < $scope.listaProductos.length; i++){
				 if($scope.listaProductos[i].idProducto == idProducto) {
					 $scope.productoVO = angular.copy($scope.listaProductos[i]);
					 $scope.productoVO.seleccionado = seleccionado;
					 $scope.productosList.push($scope.productoVO);
				 }
			 }
		 }
     }
	 
	 $scope.cambiarCantidad = function(idProducto,cantidad){
		 for(var i = 0; i < $scope.ordenCompraVO.productos.length; i++){
			 if($scope.ordenCompraVO.productos[i].idProducto == idProducto) {
				 $scope.ordenCompraVO.productos[i].cantidad = cantidad;
			 }
		 }
	 }

	 $scope.agregar = function(){
		 for(var i = 0; i < $scope.productosList.length; i++){
			 if($scope.productosList[i].seleccionado == true) {
				 $scope.ordenCompraVO.productos.push($scope.productosList[i]);
				 $scope.productosList = [];
			 }
		 }
	 }
	 
	 $scope.quitar = function(idProducto) { 
	 		
	 	for(var i = 0; i < $scope.ordenCompraVO.productos.length; i++){
	       	if( $scope.ordenCompraVO.productos[i].idProducto == idProducto){
	       		$scope.ordenCompraVO.productos.splice(i,1);
	       	}
	 	} 	
	 }
		
	 
	 $scope.inicializarValores = function(){
		 $scope.productosList = [];
		 $scope.seleccionado = null;
		 $scope.listaProductos = null;
		 $scope.listaProveedores = null;
	 	 $scope.listaFamilias = null;
	 	 $scope.listaMarcas = null;
	 	 $scope.listaTipos = null;
	 	 $scope.listaMedidas = null;
	 	 $scope.precioUnitario = null;
	 	 $scope.cantidad = null;
	 	 $scope.filtrosVO = {idEmpresa: idEmpresa, idMarca:null, idFamilia:null, idTipoProducto:null, idMedida:null, nombre:null};
	 	 $scope.productoVO = {idEmpresa: idEmpresa, idProducto:null, nombre:'', descripcion:'', 
	    		 idFamilia:null, nombreFamilia:null, idTipoProducto:null, nombreTipoProducto:null, 
	    		 idMedida: null, nombreMedida:null, idUnidadMedida:null, nombreUnidadMedida:null,
	    		 idMarca:null, nombreMarca:null, precioUnitario:null, nacional:null, cantidad:null, 
	    		 seleccionado:null };
	 	 $scope.ordenCompraVO = {idProveedor:null, descuento: null, productos: []}
	     $scope.errorGeneral='';
		 $scope.mensajeGeneral='';
	 }	 
	 
	 $scope.limpiarFormulario = function(){  
		 $scope.productosList = [];
		 $scope.seleccionado = null;
		 $scope.listaProductos = null;
		 $scope.listaProveedores = null;
		 $scope.listaFamilias = null;
	 	 $scope.listaMarcas = null;
	 	 $scope.listaTipos = null;
	 	 $scope.listaMedidas = null;
	 	 $scope.precioUnitario = null;
	 	 $scope.cantidad = null;
	 	 $scope.filtrosVO = {idEmpresa: idEmpresa, idMarca:null, idFamilia:null, idTipoProducto:null, idMedida:null, nombre:null};
	 	 $scope.productoVO = {idEmpresa: idEmpresa, idProducto:null, nombre:'', descripcion:'', 
	    		 idFamilia:null, nombreFamilia:null, idTipoProducto:null, nombreTipoProducto:null, 
	    		 idMedida: null, nombreMedida:null, idUnidadMedida:null, nombreUnidadMedida:null,
	    		 idMarca:null, nombreMarca:null, precioUnitario:null, nacional:null, cantidad:null, 
	    		 seleccionado:null};
	 	 $scope.ordenCompraVO = {idProveedor:null, descuento: null, productos: []}
	 }
	 		
	 $scope.inicializarValores();	
	 $scope.consultaFamilias(idEmpresa);
	 $scope.consultaMarcas(idEmpresa);
	 $scope.consultaMedidas(idEmpresa);
	 $scope.consultaTipos(idEmpresa);
	 $scope.consultaProveedores(idEmpresa);
	
}]);