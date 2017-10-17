'use strict';

var EntradasDulceriaController = angular.module('indexModule').controller("EntradasDulceriaController", function($scope,$controller,$filter,DataUtils,ModalService,dulceriaService,inventarioService,PropertiesFactory){

	$controller('modalController',{$scope : $scope });
	$scope.parametroBusqueda = {articulo: ""};
	$scope.listaArticulos = [];
	$scope.listaArticulosExistencia = [];
	$scope.listaTiposMovimientosEntrada = [] ;	
	$scope.listaProveedores = [];
	$scope.movimientoInventario = {};
	$scope.tipoEntrada = {};
	
	$scope.resultado = "";		
	
	$scope.activeForm = false;
	$scope.fileUrl = null;
	
	$scope.parametrosInventario = {};
		
	$scope.limpiarParametrosMovimientoEntrada = function() {
			$scope.resultado = "";			
			$scope.activeForm = false;
			$scope.fileUrl = null;
			$scope.movimientoInventario = {};
			$scope.parametrosInventario = {};
			$scope.listaArticulos = [];
			$scope.listaArticulosExistencia = [];
			$scope.tipoEntrada = {};
	}
	
	$scope.consultarTiposMovimientoEntrada = function() {		
		inventarioService.consultarTiposMovimientosEntrada().success(function(data) {
			$scope.listaTiposMovimientosEntrada = data;
		}).error(function(data) {

			
		});
	}
	
	$scope.consultarProveedores = function() {
		inventarioService.consultarProveedores().success(function(data) {
			 $scope.listaProveedores = data;
			 $scope.activeForm = false;
		}).error(function(data) {

		});
	}
	
	$scope.buscarArticulos = function() {
		inventarioService.busquedaArticulosPuntoVenta($scope.parametroBusqueda.articulo).success(function(data) {
			$scope.listaArticulos = data;			
		}).error(function(data) {

		});
	}	
	
	$scope.setDatosDeArticulo = function(articuloPuntoVenta){
		$scope.movimientoInventario.articulo = articuloPuntoVenta.articulo;
		$scope.parametrosInventario.idArticulo = articuloPuntoVenta.articulo.idArticulo;
		$scope.activeForm = true;
	}
	
	$scope.buscarArticulosExistencia = function() {
		inventarioService.busquedaArticulosExistencia($scope.parametrosInventario.idArticulo).success(function(data) {
			$scope.listaArticulosExistencia = data;			
		}).error(function(data) {

		});
	}
	
	$scope.guardarEntrada= function() {				
		$scope.parametrosInventario.idTipoMovimiento = $scope.tipoEntrada.idTipoMovimientoInv;
		$scope.parametrosInventario.claveTipoMovimiento = $scope.tipoEntrada.clave;
		$scope.parametrosInventario.idPuntoVentaConsigna = 0;
		$scope.parametrosInventario.idAutorizacion = 0,
		inventarioService.registrarEntrada($scope.parametrosInventario
				).success(function(data) {
						$scope.resultado = data;
						$scope.activeForm = false;
						$scope.limpiarParametrosMovimientoEntrada();
						$scope.formEntradas.$setPristine();								
						$scope.showAviso("El movimiento se realizo correctamente.");
		}).error(function(data) {
			$scope.showAviso("No fue posible realizar movimiento.");
		});		
	}
	
	$scope.validaFormEntradas = function(){
		
		if ($scope.formEntradas.$invalid) {            
            angular.forEach($scope.formEntradas.$error, function (field) {
              angular.forEach(field, function(errorField){
            	  errorField.$setDirty();
              })
            });                        
            return false;
        }else if($scope.tipoEntrada == undefined){
			 	return false;
		}else{
			return true;
		}
				
		
	}
	
	 $scope.confirmacionEntrada = function(){
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
			        		$scope.guardarEntrada();			     				        	
			        	}
			        }); 
			    });
			};
			
			if($scope.validaFormEntradas()){
				$scope.showConfirmacion ("Est\u00e1 seguro de realizar la entrada de inventario?");
			}else{
				$scope.showAviso("Es necesario llenar los campos obligatorios ");
			}
	};
		
	$scope.setArchivo = function($file){
	   if ($file && $file.$error === 'pattern') {
	             return;
	   }
	   if ($file) {
	       	DataUtils.toBase64($file, function (base64Data) {
			       $scope.$apply(function () {
			   	   $scope.parametrosInventario.archivo = base64Data;
			   	   $scope.parametrosInventario.contentType = $file.type;	                	   
			   	   $scope.parametrosInventario.sizeArchivo = $file.size;
			       $scope.parametrosInventario.nombreArchivo = $file.name;	                	   
			       $scope.fileUrl = window.URL.createObjectURL($file);         	   
	         });
	       });
	    }
	}
		
	$scope.cerrar = function(){
		$('.modal').hide();
		$('.modal-backdrop').remove();
	};  
	
	$scope.init =function(){
		 $scope.consultarTiposMovimientoEntrada();
		 $scope.consultarProveedores();
	 }
	 
	 $scope.init();
	
});

