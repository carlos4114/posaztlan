'use strict';

angular.module('indexModule').controller("ProductosController",['$scope','GlobalFactory', 'ProductosService', 'ModalService','DataUtils','ErrorFactory', 
    function($scope,GlobalFactory, ProductosService,ModalService,DataUtils,ErrorFactory){	 			
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
				       $scope.productoVO.icono = $scope.parametrosIcono.archivo;	
		         });
		       });
		    }
		}
	
	$scope.quitarImpuesto = function(impuesto) { 
 		impuesto.porcentaje = 0;
 		
 		for(var i = 0; i < $scope.productoVO.impuestosList.length; i++){
        	if( $scope.productoVO.impuestosList[i].nombre == impuesto.nombre){
        		$scope.productoVO.impuestosList.splice(i,1);
        	}
        }
 	}
	
		
	$scope.agregarImpuesto = function(nombre, porcentaje) {   

        $scope.found=false;
        for(var i = 0; i < $scope.productoVO.impuestosList.length; i++){
        	if( $scope.productoVO.impuestosList[i].nombre == nombre){
        		$scope.found=true;
        		$scope.productoVO.impuestosList[i].porcentaje = porcentaje; 
        		$scope.productoVO.impuestosList[i].activo = true;
        	}
        }
           
        if ($scope.found==false){
        	$scope.productoVO.impuestosList.push({nombre: nombre, porcentaje: porcentaje, activo:true});
        }
	}
	 
	 $scope.consultaCanalesXEmpresa = function(idEmpresa) {
		 ProductosService.consultaCanalesXEmpresa(idEmpresa)
		 .then(
	      function(d) {
        	  $scope.listaCanales = d;
	      },
          function(errResponse){
          });
     }
	 
	 $scope.consultaUnidadesMedida = function(idEmpresa) {
		 ProductosService.consultaUnidadesMedida(idEmpresa)
		 .then(
	      function(d) {
        	  $scope.listaUnidadesMedida = d;
	      },
          function(errResponse){
          });
     }
	 
	 $scope.consultaFamilias = function(idEmpresa) {
		 ProductosService.consultaFamilias(idEmpresa)
		 .then(
	      function(d) {
        	  $scope.listaFamilias = d;
	      },
          function(errResponse){
          });
     }
	 
	 $scope.consultaMarcas = function(idEmpresa) {
		 ProductosService.consultaMarcas(idEmpresa)
		 .then(
	      function(d) {
        	  $scope.listaMarcas = d;
	      },
          function(errResponse){
          });
     }
	 
	 $scope.consultaTipos = function(idEmpresa) {
		 ProductosService.consultaTipos(idEmpresa)
		 .then(
	      function(d) {
        	  $scope.listaTipos = d;
	      },
          function(errResponse){
          });
     }
	 
	 $scope.consultaMedidas = function(idEmpresa) {
		 ProductosService.consultaMedidas(idEmpresa)
		 .then(
	      function(d) {
        	  $scope.listaMedidas = d;
	      },
          function(errResponse){
          });
     }
	 
	 $scope.obtenerProductos = function(idEmpresa) {
		 ProductosService.obtenerProductos(idEmpresa)
		 .then(
	      function(d) {
        	  $scope.listaProductos = d;
	      },
          function(errResponse){
          });
     }
	 	 
	 $scope.guardarProducto = function(productoVO) {
	
		 $scope.errorGeneral='';
		 $scope.mensajeGeneral='';
		 ProductosService.guardarProducto(productoVO)
		 .then(
	      function(d) {
	    	  if(d.errorCode){
	        	  $scope.errorGeneral = d.message;
	    	  }else{	 
		 		  $scope.mensajeGeneral = 'Se ha guardado el producto.';
		 		  $scope.limpiarFormulario();
	    	  }
	      },
          function(errResponse){
   		   		$scope.errorGeneral = "No se pudo guardar el producto. "+ErrorFactory.getErrorMessage(errResponse.status);
          });
     }
	 
	 $scope.actualizarProducto = function(productoVO) {
		 
		 $scope.errorGeneral='';
		 $scope.mensajeGeneral='';
		 ProductosService.actualizarProducto(productoVO)
		 .then(
	      function(d) {
	    	  if(d.errorCode){
	        	  $scope.errorGeneral = d.message;
	    	  }else{	 
		 		  $scope.mensajeGeneral = 'Se ha actualizado el producto.';
		 		  $scope.limpiarFormulario();
	    	  }
	      },
          function(errResponse){
   		   		$scope.errorGeneral = "No se pudo actualizar el producto. "+ErrorFactory.getErrorMessage(errResponse.status);
          });
     }
	 
	 $scope.editarProducto = function(idProducto) {
			$scope.errorGeneral='';
			$scope.mensajeGeneral='';
	        
			for(var i = 0; i < $scope.listaProductos.length; i++){
	            if($scope.listaProductos[i].idProducto === idProducto) { 
	            	$scope.productoVO = angular.copy($scope.listaProductos[i]);
	            	
	            	if($scope.productoVO.activo == true){
	            		$scope.estatus = "1"; 
	            	}else{
	            		$scope.estatus = "0";
	            	}
	            	
	            	if($scope.productoVO.nacional == true){
	            		$scope.nacional = "1"; 
	            	}else{
	            		$scope.nacional = "0";
	            	}
	            	
	            	$scope.consultaUnidadesMedida(idEmpresa);
	           	 	$scope.consultaFamilias(idEmpresa);
	           	 	$scope.consultaMarcas(idEmpresa);
	           	 	$scope.consultaMedidas(idEmpresa);
	           	 	$scope.consultaTipos(idEmpresa);
	           	 
	            }
	        }	        
	   }

	 
	 $scope.cambiarEstatus = function(estatus){
		 if(estatus == "1"){
			 $scope.productoVO.activo = true;
		 }else{
			 $scope.productoVO.activo = false;
		 }
	 }
	 
	 $scope.cambiarOrigen = function(nacional){
		 if(nacional == "1"){
			 $scope.productoVO.nacional = true;
		 }else{
			 $scope.productoVO.nacional = false;
		 }
	 }
	 
	 $scope.quitarPrecio = function(canal) { 
	 		canal.precio = 0;
	 		
	 		for(var i = 0; i < $scope.productoVO.preciosXCanalList.length; i++){
	        	if( $scope.productoVO.preciosXCanalList[i].idCanal == canal.idCanal){
	        		$scope.productoVO.preciosXCanalList.splice(i,1);
	        	}
	 		}
	 }
	 
	 
	 $scope.agregarPrecio = function(idCanal, precio) {   
		 var nombre;
		 $scope.found=false;
		 
		 for(var i = 0; i < $scope.listaCanales.length; i++){
			 if($scope.listaCanales[i].idCanal == idCanal) { 
				nombre = $scope.listaCanales[i].nombre;
			}
		}
		 
		 for(var i = 0; i < $scope.productoVO.preciosXCanalList.length; i++){
	        if( $scope.productoVO.preciosXCanalList[i].idCanal == idCanal){
	       		$scope.productoVO.preciosXCanalList[i].precio = precio;
	       		$scope.found=true;
	       	}
		 }
	           
	        
		 if ($scope.found==false){
	       	$scope.productoVO.preciosXCanalList.push({idCanal: idCanal, nombre: nombre, precio: precio});
		 }
	 }
	 
	 $scope.inicializarValores = function(){
		 $scope.estatus = null;
		 $scope.nacional = null;
		 $scope.listaProductos = null;
	 	 $scope.listaFamilias = null;
	 	 $scope.listaMarcas = null;
	 	 $scope.listaTipos = null;
	 	 $scope.listaMedidas = null;
	 	 $scope.listaUnidadesMedida = null;
	 	 $scope.listaCanales = null;
	 	 $scope.impuesto = null;
	 	 $scope.porcentaje = null;
	 	 $scope.idCanal = null;
	 	 $scope.precio = null;
	 	 $scope.parametrosIcono = {};
	 	 $scope.productoVO = {idProducto:null, nombre:'', descripcion:'', icono:null, activo:true, idEmpresa:idEmpresa, 
	    		 idFamilia:null, idMarca:null, idTipoProducto:null, idMedida: null, idUnidadMedida:null, 
	    		 precioUnico:null, nacional:null,preciosXCanalList:[], impuestosList:[]};
	     $scope.errorGeneral='';
		 $scope.mensajeGeneral='';
	 }	 
	 
	 $scope.limpiarFormulario = function(){  
		 $scope.estatus = null;
		 $scope.nacional = null;
		 $scope.listaProductos = null;
	 	 $scope.listaFamilias = null;
	 	 $scope.listaMarcas = null;
	 	 $scope.listaTipos = null;
	 	 $scope.listaMedidas = null;
	 	 $scope.listaUnidadesMedida = null;
	 	 $scope.listaCanales = null;
	 	 $scope.impuesto = null;
	 	 $scope.porcentaje = null;
	 	 $scope.idCanal = null;
	 	 $scope.precio = null;
	 	 $scope.parametrosIcono = {};
	 	
	   	 $scope.productoVO = {idProducto:null, nombre:'', descripcion:'', icono:null, activo:true, idEmpresa:idEmpresa, 
	    		 idFamilia:null, idMarca:null, idTipoProducto:null, idMedida: null, idUnidadMedida:null, 
	    		 precioUnico:null, nacional:null, preciosXCanalList:[], impuestosList:[]};
	   	 $scope.consultaCanalesXEmpresa(idEmpresa);
		 $scope.consultaUnidadesMedida(idEmpresa);
		 $scope.consultaFamilias(idEmpresa);
		 $scope.consultaMarcas(idEmpresa);
		 $scope.consultaMedidas(idEmpresa);
		 $scope.consultaTipos(idEmpresa);
	 }
	 		
	 $scope.inicializarValores();	
	 $scope.consultaCanalesXEmpresa(idEmpresa);
	 $scope.consultaUnidadesMedida(idEmpresa);
	 $scope.consultaFamilias(idEmpresa);
	 $scope.consultaMarcas(idEmpresa);
	 $scope.consultaMedidas(idEmpresa);
	 $scope.consultaTipos(idEmpresa);
	 $scope.obtenerProductos(idEmpresa);
	
}]);