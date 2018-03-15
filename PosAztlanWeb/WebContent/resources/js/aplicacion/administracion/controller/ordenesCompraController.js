'use strict';

angular.module('indexModule').controller("OrdenesCompraController",['$scope','GlobalFactory', 'OrdenesCompraService', 'ModalService','DataUtils','ErrorFactory', 
    function($scope,GlobalFactory, OrdenesCompraService,ModalService,DataUtils,ErrorFactory){	 			
	 var idEmpresa = GlobalFactory.getIdEmpresa();  
	 $scope.fileUrl = null;
	 
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
			        		$scope.guardar($scope.ordenCompraVO);        				    	        
			        	}
			        }); 
			    });
			};
			
		   $scope.showConfirmacion ("¿Est\u00e1 seguro que desea guardar la orden de compra?");
	};
	
	$scope.guardar = function(ordenCompraVO) {
		
		 $scope.errorGeneral='';
		 $scope.mensajeGeneral='';
		 ordenCompraVO.idEmpresa = idEmpresa;
		 
		 OrdenesCompraService.guardar(ordenCompraVO)
		 .then(
	      function(d) {
	    	  if(d.errorCode){
	        	  $scope.errorGeneral = d.message;
	    	  }else{	 
		 		  $scope.mensajeGeneral = 'Se ha guardado la orden de compra';
		 		  $scope.limpiarFormulario();
		 		  $scope.guardarReporte(d.archivoExcelVO.archivo,d.archivoExcelVO.nombre);
	    	  }
	      },
         function(errResponse){
  		   		$scope.errorGeneral = "No se pudo guardar la orden de compra. "+ErrorFactory.getErrorMessage(errResponse.status);
         });
    }
	
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
		 filtrosVO.idProveedor = $scope.ordenCompraVO.idProveedor;
		 OrdenesCompraService.buscar(filtrosVO)
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
	
	 
	 /*$scope.agregar = function(){
		 for(var i = 0; i < $scope.listaProductos.length; i++){
			 if($scope.listaProductos[i].seleccionado == true) {
				 $scope.ordenCompraVO.productos.push($scope.listaProductos[i]);
			 }
		 }
	 }*/
	 
	 $scope.agregar = function(){
		 	var found = false; 
			$scope.errorGeneral = '';
		 	
			 for(var i = 0; i < $scope.listaProductos.length; i++){
				 if($scope.listaProductos[i].seleccionado == true) {
				 	 for(var j = 0; j < $scope.ordenCompraVO.productos.length; j++){
				 	 	if($scope.ordenCompraVO.productos[j].idProducto == $scope.listaProductos[i].idProducto){
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
								if($scope.listaProductos[i].precioUnitario.length==0){
									$scope.errorGeneral = 'No se puede agregar "'+$scope.listaProductos[i].nombre+'". El precio unitario debe ser mayor a cero.';
								}else{
									if($scope.listaProductos[i].precioUnitario<=0){
										$scope.errorGeneral = 'No se puede agregar "'+$scope.listaProductos[i].nombre+'". El precio unitario debe ser mayor a cero.';															
									}else{
										$scope.ordenCompraVO.productos.push(angular.copy($scope.listaProductos[i]));
										$scope.listaProductos[i].seleccionado = false;
										$scope.seleccionarTodosCh = false;											
									}
								}
							}
						}
					 }else{
						$scope.errorGeneral = 'El producto "'+$scope.listaProductos[i].nombre+'" ya est\u00e1 agregado.';
					 }
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
		 $scope.seleccionarTodosCh = false;
		 $scope.listaProductos = null;
		 $scope.listaProveedores = null;
	 	 $scope.listaFamilias = null;
	 	 $scope.listaMarcas = null;
	 	 $scope.listaTipos = null;
	 	 $scope.listaMedidas = null;
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
		 $scope.seleccionarTodosCh = false;
		 $scope.listaProductos = null;
		 $scope.listaProveedores = null;
	 	 $scope.listaFamilias = null;
	 	 $scope.listaMarcas = null;
	 	 $scope.listaTipos = null;
	 	 $scope.listaMedidas = null;
	 	 $scope.consultaFamilias(idEmpresa);
		 $scope.consultaMarcas(idEmpresa);
		 $scope.consultaMedidas(idEmpresa);
		 $scope.consultaTipos(idEmpresa);
		 $scope.consultaProveedores(idEmpresa);
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