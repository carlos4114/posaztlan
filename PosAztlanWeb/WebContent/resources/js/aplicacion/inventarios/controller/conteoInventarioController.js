'use strict';

angular.module('indexModule').controller("ConteoInventarioController",['$scope','GlobalFactory', 'ConteoInventarioService', 'ModalService','DataUtils','ErrorFactory', 
    function($scope,GlobalFactory, ConteoInventarioService,ModalService,DataUtils,ErrorFactory){	 			
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


	$scope.guardarParcial = function() {
		 $scope.conteoVO.esParcial = true;
		 $scope.guardar();
	}
	
	$scope.guardar = function() {
		
		 $scope.errorGeneral='';
		 $scope.mensajeGeneral='';
		 $scope.conteoVO.idEmpresa = idEmpresa;
		 $scope.conteoVO.idAlmacen = idAlmacen;
		 $scope.conteoVO.idCanal = idCanal;
		 $scope.conteoVO.productos = $scope.listaProductos;
		 ConteoInventarioService.guardar($scope.conteoVO)
		 .then(
	      function(d) {
	    	  if(d.errorCode){
	        	  $scope.errorGeneral = d.message;
	    	  }else{	 
		 		  $scope.limpiarFormulario();
		 		  $scope.mensajeGeneral = 'Se ha guardado el conteo con el folio ' + d;
	    	  }
	      },
         function(errResponse){
  		   		$scope.errorGeneral = "No se pudo guardar el conteo. "+ErrorFactory.getErrorMessage(errResponse.status);
         });
    }
	
	$scope.autorizar = function() {
		
		 $scope.errorGeneral='';
		 $scope.mensajeGeneral='';
		 $scope.conteoVO.idEmpresa = idEmpresa;
		 $scope.conteoVO.idAlmacen = idAlmacen;
		 $scope.conteoVO.idCanal = idCanal;
		 $scope.conteoVO.productos = $scope.listaProductos;
		 ConteoInventarioService.autorizarConteo($scope.conteoVO)
		 .then(
	      function(d) {
	    	  if(d.errorCode){
	        	  $scope.errorGeneral = d.message;
	    	  }else{	 
		 		  $scope.limpiarFormulario();
		 		  $scope.mensajeGeneral = 'Se ha autorizado el conteo con el folio ' + d;
	    	  }
	      },
        function(errResponse){
 		   		$scope.errorGeneral = "No se pudo guardar el conteo. "+ErrorFactory.getErrorMessage(errResponse.status);
        });
   }
	
	 $scope.consultaEmpresas = function() {
		 ConteoInventarioService.consultaEmpresas()
		 .then(
	      function(d) {
        	  $scope.listaEmpresas = d;
	      },
          function(errResponse){
          });
     }
	 
	 $scope.consultaCanales = function(idEmpresa) {
		 ConteoInventarioService.consultaCanales(idEmpresa)
		 .then(
	      function(d) {
        	  $scope.listaCanales = d;
	      },
          function(errResponse){
          });
     }
	 
	 $scope.consultaAlmacenes = function(idCanal) {
		 ConteoInventarioService.consultaAlmacenes(idCanal)
		 .then(
	      function(d) {
        	  $scope.listaAlmacenes = d;
	      },
          function(errResponse){
          });
     }
 
	 $scope.obtenerConteo = function(){
		 $scope.parametrosBusquedaVO.idEmpresa = idEmpresa;
		 ConteoInventarioService.obtenerConteo($scope.parametrosBusquedaVO)
		 .then(
		  function(d) {
			  $scope.listaProductos = d.productos;
		  },
		  function(errResponse){
		  });
	 }

	 $scope.obtenerProductosConteo = function(){
		 
		 ConteoInventarioService.obtenerProductosConteo($scope.parametrosBusquedaVO)
		 .then(
		  function(d) {
			  $scope.listaProductos = d;
		  },
		  function(errResponse){
		  });
	 }

	 $scope.buscar = function(){
		 
		if($scope.parametrosBusquedaVO.folio == null || $scope.parametrosBusquedaVO.folio == ""){
			$scope.obtenerProductosConteo();
		}else{
			$scope.obtenerConteo();
		}
	 }
	
	 $scope.inicializarValores = function(){
		 $scope.seleccionarTodosCh = false;
		 $scope.listaProductos = null;
		 $scope.listaEmpresas = null;
	 	 $scope.listaCanales = null;
	 	 $scope.listaAlmacenes = null;
	 	 $scope.parametrosBusquedaVO = {idEmpresa:idEmpresa,idCanal:idCanal, idAlmacen:idAlmacen};
	 	 $scope.productoVO = {idAlmacen: idAlmacen, idProducto:null, nombre:'', descripcion:'', 
	    		 idFamilia:null, nombreFamilia:null, idTipoProducto:null, nombreTipoProducto:null, 
	    		 idMedida: null, nombreMedida:null, idUnidadMedida:null, nombreUnidadMedida:null,
	    		 idMarca:null, nombreMarca:null, precioUnitario:null, nacional:null, cantidad:null,
	    		 existencia: null, seleccionado:null, existenciaSistema:null, existenciaFisica:null };
	 	$scope.conteoVO = {idEmpresa: null, idCanal: null, idAlmacen: null, idConteo:null, folio:null, 
	 			 idEstatusConteo:null, esParcial:false, productos: []};
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

	 	 $scope.parametrosBusquedaVO = {idEmpresa:idEmpresa, idCanal:idCanal, idAlmacen:idAlmacen, folio:null};
	 	 $scope.productoVO = {idAlmacen: idAlmacen, idProducto:null, nombre:'', descripcion:'', 
	    		 idFamilia:null, nombreFamilia:null, idTipoProducto:null, nombreTipoProducto:null, 
	    		 idMedida: null, nombreMedida:null, idUnidadMedida:null, nombreUnidadMedida:null,
	    		 idMarca:null, nombreMarca:null, precioUnitario:null, nacional:null, cantidad:null,
	    		 existencia: null, seleccionado:null, existenciaSistema:null, existenciaFisica:null };
	 	 $scope.conteoVO = {idEmpresa: null, idCanal: null, idAlmacen: null, idConteo:null, folio:null, 
	 			 idEstatusConteo:null, esParcial:false, productos: []};
	 }
	 
	 $scope.cambiarEmpresa = function(){
		 idEmpresa = $scope.parametrosBusquedaVO.idEmpresa;
		 $scope.consultaCanales(idEmpresa);
	 	 $scope.listaAlmacenes = null;
	 }
	 
	 $scope.cambiarCanal = function(){
		 idCanal = $scope.parametrosBusquedaVO.idCanal;
		 $scope.consultaAlmacenes(idCanal);
	 }
	 
	 
	 $scope.cambiarAlmacen = function(){
		 idAlmacen = $scope.parametrosBusquedaVO.idAlmacen;
	 }
	 		
	 $scope.inicializarValores();	
	 
	 if($scope.isAdminGral=="true")
		 $scope.consultaEmpresas();
	 
	 if(idEmpresa!=null)
		 $scope.consultaCanales(idEmpresa);
	 if(idCanal!=null)
		 $scope.consultaAlmacenes(idCanal);
	 
}]);