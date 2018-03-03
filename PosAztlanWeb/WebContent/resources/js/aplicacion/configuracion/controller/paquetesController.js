'use strict';

angular.module('indexModule').controller("PaquetesController",['$scope','GlobalFactory', 'PaquetesService', 'ModalService','DataUtils','ErrorFactory', 
    function($scope,GlobalFactory, PaquetesService,ModalService,DataUtils,ErrorFactory){	 			
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
			        		if($scope.paqueteVO.idPaquete === null){
			    	            $scope.guardarPaquete($scope.paqueteVO);
			    	        }else{
			    	        	$scope.actualizarPaquete($scope.paqueteVO);        	
			    	        }
			        	}
			        }); 
			    });
			};
			
		   $scope.showConfirmacion ("¿Est\u00e1 seguro que desea guardar el paquete?");
	};
	
	 
	$scope.setArchivo = function($file){
		   if ($file && $file.$error === 'pattern') {
		             return;
		   }
		   if ($file) {
		       	DataUtils.toBase64($file, function (base64Data) {
				       $scope.$apply(function () {
				   	   $scope.parametrosIcono.archivo = base64Data;
				   	   $scope.parametrosIcono.contentType = $file.type;	                	   
				   	   $scope.parametrosIcono.sizeArchivo = $file.size;
				       $scope.parametrosIcono.nombreArchivo = $file.name;	                	   
				       $scope.fileUrl = window.URL.createObjectURL($file);   
				       $scope.paqueteVO.icono = $scope.parametrosIcono.archivo;	
		         });
		       });
		    }
		}
	
	$scope.quitarProductos = function(producto) { 
		producto.quitar = "1";
		
		for(var i = 0; i < $scope.paqueteVO.productosSeleccionadosList.length; i++){
			if( $scope.paqueteVO.productosSeleccionadosList[i].quitar == "1"){
				$scope.restarPrecioSugerido($scope.paqueteVO.productosSeleccionadosList[i].productosAgregadosList);
	        	$scope.paqueteVO.productosSeleccionadosList.splice(i,1);
			}
		}
		
 	}
	
	$scope.quitarProducto = function(producto) { 

		for(var i = 0; i < $scope.productosAgregadosList.length; i++){
 	       	if( $scope.productosAgregadosList[i].idProducto == producto.idProducto){
 	       		$scope.productosAgregadosList.splice(i,1);
 	       	}
 		}
	}

	$scope.agregarProducto = function(idProducto, cantidad) {   
		
		var nombre;
		var precio;
		
		for(var i = 0; i < $scope.listaProductos.length; i++){
			if($scope.listaProductos[i].idProducto == idProducto) { 
				nombre = $scope.listaProductos[i].nombre;
				precio = $scope.listaProductos[i].precio;
			}
		}		
		
        $scope.found=false;
        
        for(var i = 0; i < $scope.productosAgregadosList.length; i++){
        	if( $scope.productosAgregadosList[i].idProducto == idProducto){
        		$scope.found=true;
        		$scope.productosAgregadosList[i].cantidad = 
        			$scope.productosAgregadosList[i].cantidad + cantidad; 
        	}
        }
           
        if ($scope.found==false){
        	$scope.productosAgregadosList.push({idProducto: idProducto, cantidad: cantidad, nombre: nombre, precio: precio});
        }
        
        
        $scope.cantidad = 1;
     
	}
	
	$scope.agregarProductos = function(productosAgregadosList) {   
			
        	$scope.paqueteVO.productosSeleccionadosList.push({productosAgregadosList: productosAgregadosList, cantidad: productosAgregadosList[0].cantidad});
        	$scope.productosAgregadosList = [];
        	
        	$scope.calcularPrecioSugerido(productosAgregadosList);
	}
	
	$scope.calcularPrecioSugerido = function(productosAgregadosList){
		var precio = 0;
		var cantidad = 0;
		
		for(var i = 0; i < productosAgregadosList.length; i++){
			if(productosAgregadosList[i].precio > precio){
				precio =productosAgregadosList[i].precio;
				cantidad = productosAgregadosList[i].cantidad;
			}
		}
		
		$scope.precioSugerido = $scope.precioSugerido  + (precio * cantidad);
	}
	
	$scope.restarPrecioSugerido = function(productosAgregadosList){
		var precio = 0;
		
		for(var i = 0; i < productosAgregadosList.length; i++){
			if(productosAgregadosList[i].precio > precio){
				precio =productosAgregadosList[i].precio;
			}
		}
		
		$scope.precioSugerido = $scope.precioSugerido - precio;
	}
	
	$scope.consultaCinesXEmpresa = function(idEmpresa) {
		 PaquetesService.consultaCinesXEmpresa(idEmpresa)
		 .then(
	      function(d) {
        	  $scope.listaCines = d;
	      },
          function(errResponse){
          });
     }
	 
	 $scope.consultaPuntosVentaXCine = function(idCine) {
		 PaquetesService.consultaPuntosVentaXCine(idCine)
		 .then(
           function(d) {
        	 $scope.listaPuntosVenta = d;
 	      },
          function(errResponse){
          });
     }
	
	  
	 $scope.inicializarValores = function(){
		 $scope.estatus=null;
		 $scope.productosAgregadosList = [];
		 $scope.listaProductos = null;
		 $scope.listaPaquetes = null;
	 	 $scope.listaPuntosVenta = null;
	 	 $scope.listaCines = null;
	 	 $scope.idProducto = null;
	 	 $scope.cantidad = 1;
	 	 $scope.precioSugerido = null;
	   	 $scope.parametrosIcono = {};
	     $scope.paqueteVO = {idPaquete:null, idCine:null, nombre:'', icono:null, activo:true, precio:null, puntosVentaList:null, productosSeleccionadosList:[]};
	     $scope.errorGeneral='';
		 $scope.mensajeGeneral='';
	 }	 
	 
	 $scope.obtenerPaquetes = function(idCine) {
		 PaquetesService.obtenerPaquetes(idCine)
		 .then(
	      function(d) {
        	  $scope.listaPaquetes = d;
	      },
          function(errResponse){
          });
     }
	 
	 $scope.obtenerProductos = function(idCine) {
		 PaquetesService.obtenerProductos(idCine)
		 .then(
	      function(d) {
        	  $scope.listaProductos = d;
	      },
          function(errResponse){
          });
     }
	  
	 $scope.guardarPaquete = function(paqueteVO) {
	
		 $scope.errorGeneral='';
		 $scope.mensajeGeneral='';
		 PaquetesService.guardarPaquete(paqueteVO)
		 .then(
	      function(d) {
	    	  if(d.errorCode){
	        	  $scope.errorGeneral = d.message;
	    	  }else{	 
		 		  $scope.mensajeGeneral = 'Se ha guardado el paquete.';
		 		  $scope.limpiarFormulario();
	    	  }
	      },
          function(errResponse){
   		   		$scope.errorGeneral = "No se pudo guardar el paquete. "+ErrorFactory.getErrorMessage(errResponse.status);
          });
     }
	 
	 $scope.actualizarPaquete = function(paqueteVO) {
		 
		 $scope.errorGeneral='';
		 $scope.mensajeGeneral='';
		 PaquetesService.actualizarPaquete(paqueteVO)
		 .then(
	      function(d) {
	    	  if(d.errorCode){
	        	  $scope.errorGeneral = d.message;
	    	  }else{	 
		 		  $scope.mensajeGeneral = 'Se ha actualizado el paquete.';
		 		  $scope.limpiarFormulario();
	    	  }
	      },
          function(errResponse){
   		   		$scope.errorGeneral = "No se pudo actualizar el paquete. "+ErrorFactory.getErrorMessage(errResponse.status);
          });
     }
	 
	 $scope.editarPaquete = function(idPaquete) {
			$scope.errorGeneral='';
			$scope.mensajeGeneral='';
			$scope.$precioSugerido = 0;
	        
			for(var i = 0; i < $scope.listaPaquetes.length; i++){
	            if($scope.listaPaquetes[i].idPaquete === idPaquete) { 
	            	$scope.paqueteVO = angular.copy($scope.listaPaquetes[i]);
	            	$scope.consultaPuntosVentaXCine($scope.paqueteVO.cineVO.idCine);
	            	if($scope.paqueteVO.activo == true){
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
		 $scope.obtenerProductos(idCine);
		 $scope.obtenerPaquetes(idCine);
		 $scope.errorGeneral='';
		 $scope.mensajeGeneral='';
	 }
	 
	 $scope.cambiarEstatus = function(estatus){
		 if(estatus == "1"){
			 $scope.paqueteVO.activo = true;
		 }else{
			 $scope.paqueteVO.activo = false;
		 }
	 }
	 
	 $scope.limpiarFormulario = function(){   
		 $scope.estatus=null;
		 $scope.productosAgregadosList = [];
		 $scope.listaProductos = null;
		 $scope.listaPaquetes = null;
	 	 $scope.listaPuntosVenta = null;
	 	 $scope.listaCines = null;
	 	 $scope.idProducto = null;
	 	 $scope.cantidad = 1;
	 	 $scope.precioSugerido = null;
	   	 $scope.parametrosIcono = {};
	     $scope.paqueteVO = {idPaquete:null, idCine:null, nombre:'', icono:null, activo:true, precio:null, puntosVentaList:null, productosSeleccionadosList:[]};
		 $scope.consultaCinesXEmpresa(idEmpresa);
	     
	 }
	 		
	 $scope.inicializarValores();	
	 $scope.consultaCinesXEmpresa(idEmpresa);
	
}]);