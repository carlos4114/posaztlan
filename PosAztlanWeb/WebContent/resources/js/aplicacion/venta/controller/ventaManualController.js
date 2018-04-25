'use strict';

angular.module('indexModule').controller("VentaManualController",['$scope','GlobalFactory', 'VentaManualService', 'ModalService','DataUtils','ErrorFactory', 
    function($scope,GlobalFactory, VentaManualService,ModalService,DataUtils,ErrorFactory){	 			
	 var idEmpresa = GlobalFactory.getIdEmpresa();  
	 var idCanal = GlobalFactory.getIdCanal();  
	 var idAlmacen = GlobalFactory.getIdAlmacen();  
	 
	 $scope.fileUrl = null;
	 $scope.isAdminGral = GlobalFactory.getIsAdminGral();
	 $scope.isAdminGralEmpresa = GlobalFactory.getIsAdminGralEmpresa();
	 $scope.isAdminCanal = GlobalFactory.getIsAdminCanal();	 

	 function base64toBlob(base64Data, contentType) {
		    contentType = contentType || '';
		    var sliceSize = 1024;
		    var byteCharacters = atob(base64Data);
		    var bytesLength = byteCharacters.length;
		    var slicesCount = Math.ceil(bytesLength / sliceSize);
		    var byteArrays = new Array(slicesCount);

		    for (var sliceIndex = 0; sliceIndex < slicesCount; ++sliceIndex) {
		        var begin = sliceIndex * sliceSize;
		        var end = Math.min(begin + sliceSize, bytesLength);

		        var bytes = new Array(end - begin);
		        for (var offset = begin, i = 0 ; offset < end; ++i, ++offset) {
		            bytes[i] = byteCharacters[offset].charCodeAt(0);
		        }
		        byteArrays[sliceIndex] = new Uint8Array(bytes);
		    }

		    var blob = new Blob(byteArrays, {type: contentType});
		    return blob;
		}
		
	    
	    
	    $scope.guardarReporte=function(data, fileName) {
		 	var blob = new base64toBlob(data, "application/vnd.ms-excel" );
	 
	        if (window.navigator.msSaveOrOpenBlob) { // For IE:
	            navigator.msSaveBlob(blob, fileName);
	        } else { // For other browsers:
	            var link = document.createElement('a');
	            link.href = window.URL.createObjectURL(blob);
	            link.download = fileName;
	            link.click();
	            window.URL.revokeObjectURL(link.href);
	        }
	    }
	 
	 $scope.confirmarNuevo = function(){
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
			        		$scope.limpiarFormulario();        				    	        
			        	}
			        }); 
			    });
			};
			
		   $scope.showConfirmacion ("Se va a actualizar la pantalla. ¿Est\u00e1 seguro que desea continuar?");
	};

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
			        		$scope.guardar($scope.ventaVO);        				    	        
			        	}
			        }); 
			    });
			};
			
		   $scope.showConfirmacion ("¿Est\u00e1 seguro que desea guardar la venta?");
	};
	
	$scope.guardar = function(ventaVO) {
		
		 $scope.errorGeneral='';
		 $scope.mensajeGeneral='';
		 ventaVO.idEmpresa = idEmpresa;
		 
		 VentaManualService.guardar(ventaVO)
		 .then(
	      function(d) {
	    	  if(d.errorCode){
	        	  $scope.errorGeneral = d.message;
	    	  }else{	 
		 		  $scope.mensajeGeneral = 'Se ha guardado la venta';
		 		  $scope.limpiarFormulario();
		 		  $scope.guardarReporte(d.archivoExcelVO.archivo,d.archivoExcelVO.nombre);
	    	  }
	      },
         function(errResponse){
  		   		$scope.errorGeneral = "No se pudo guardar la venta. "+ErrorFactory.getErrorMessage(errResponse.status);
         });
    }
	
	 $scope.consultaEmpresas = function() {
		 VentaManualService.consultaEmpresas()
		 .then(
	      function(d) {
        	  $scope.listaEmpresas = d;
	      },
          function(errResponse){
          });
     }
	 
	 $scope.consultaCanales = function(idEmpresa) {
		 VentaManualService.consultaCanales(idEmpresa)
		 .then(
	      function(d) {
        	  $scope.listaCanales = d;
	      },
          function(errResponse){
          });
     }
	 
	 $scope.consultaAlmacenes = function(idCanal) {
		 VentaManualService.consultaAlmacenes(idCanal)
		 .then(
	      function(d) {
        	  $scope.listaAlmacenes = d;
	      },
          function(errResponse){
          });
     }
 
	 	
	 $scope.buscar = function(){
		 
		 VentaManualService.buscar($scope.filtrosVO)
		 .then(
		  function(d) {
			  $scope.listaProductos = d;
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
				 	 for(var j = 0; j < $scope.ventaVO.productos.length; j++){
				 	 	if($scope.ventaVO.productos[j].idProducto == $scope.listaProductos[i].idProducto){
							found = true;			
				 	 	}
				 	 }
					 if(found == false){
						if($scope.listaProductos[i].cantidad==null){
							$scope.errorGeneral = 'No se puede agregar "'+$scope.listaProductos[i].nombre+'". La cantidad debe ser mayor a cero.';															 
						}else{
							if($scope.listaProductos[i].cantidad<=0){
								$scope.errorGeneral = 'No se puede agregar "'+$scope.listaProductos[i].nombre+'". La cantidad debe ser mayor a cero.';							
							}else{
								$scope.ventaVO.productos.push(angular.copy($scope.listaProductos[i]));
								$scope.listaProductos[i].seleccionado = false;
								$scope.listaProductos[i].cantidad = null;
								$scope.seleccionarTodosCh = false;											
							}
						}
					 }else{
						$scope.errorGeneral = 'El producto "'+$scope.listaProductos[i].nombre+'" ya est\u00e1 agregado.';
					 }
				 }
			 }
		 }
	 
	 $scope.quitar = function(idProducto) { 
	 		
	 	for(var i = 0; i < $scope.ventaVO.productos.length; i++){
	       	if( $scope.ventaVO.productos[i].idProducto == idProducto){
	       		$scope.ventaVO.productos.splice(i,1);
	       	}
	 	} 	
	 }
		
	 
	 $scope.inicializarValores = function(){
		 $scope.seleccionarTodosCh = false;
		 $scope.listaProductos = null;
		 $scope.listaEmpresas = null;
	 	 $scope.listaCanales = null;
	 	 $scope.listaAlmacenes = null;
	 	 $scope.filtrosVO = {idEmpresa: idEmpresa, idCanal:idCanal, idAlmacen:idAlmacen, sku: null, nombre:null};
	 	 $scope.productoVO = {idAlmacen: idAlmacen, idProducto:null, nombre:'', descripcion:'', 
	    		 idFamilia:null, nombreFamilia:null, idTipoProducto:null, nombreTipoProducto:null, 
	    		 idMedida: null, nombreMedida:null, idUnidadMedida:null, nombreUnidadMedida:null,
	    		 idMarca:null, nombreMarca:null, precioUnitario:null, nacional:null, cantidad:null,
	    		 existencia: null, seleccionado:null };
	 	 $scope.ventaVO = {idAlmacen: idAlmacen, productos: []}
	     $scope.errorGeneral='';
		 $scope.mensajeGeneral='';
	 }	 
	 
	 $scope.limpiarFormulario = function(){  
		 $scope.errorGeneral='';
		 $scope.mensajeGeneral='';
		 $scope.seleccionarTodosCh = false;
		 $scope.listaProductos = null;
		 $scope.listaEmpresas = null;
	 	 $scope.listaCanales = null;
	 	 $scope.listaAlmacenes = null;

	 	 if($scope.isAdminGral=="true")
	 		 $scope.consultaEmpresas();
	 	 if($scope.isAdminGralEmpresa =="true" && idEmpresa != null)
	 		 $scope.consultaCanales(idEmpresa);
	 	 if($scope.isAdminCanal=="true" && idCanal != null)
	 		 $scope.consultaAlmacenes(idCanal);

	 	 $scope.filtrosVO = {idEmpresa: idEmpresa, idCanal:idCanal, idAlmacen:idAlmacen, sku: null, nombre:null};
	 	 $scope.productoVO = {idAlmacen: idAlmacen, idProducto:null, nombre:'', descripcion:'', 
	    		 idFamilia:null, nombreFamilia:null, idTipoProducto:null, nombreTipoProducto:null, 
	    		 idMedida: null, nombreMedida:null, idUnidadMedida:null, nombreUnidadMedida:null,
	    		 idMarca:null, nombreMarca:null, precioUnitario:null, nacional:null, cantidad:null,
	    		 existencia: null, seleccionado:null };
	 	 $scope.ventaVO = {idAlmacen: null, productos: []}
	 }
	 
	 $scope.cambiarEmpresa = function(){
		 idEmpresa = $scope.filtrosVO.idEmpresa;
		 $scope.consultaCanales(idEmpresa);
	 	 $scope.listaAlmacenes = null;
	 }
	 
	 $scope.cambiarCanal = function(){
		 idCanal = $scope.filtrosVO.idCanal;
		 $scope.consultaAlmacenes(idCanal);
	 }

	 		
	 $scope.inicializarValores();	
	 if($scope.isAdminGral=="true")
		 $scope.consultaEmpresas();
	 
}]);