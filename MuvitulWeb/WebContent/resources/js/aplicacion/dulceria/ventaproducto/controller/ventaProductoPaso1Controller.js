'use strict';

var VentaProductoPaso1Controller = angular.module('indexModule').controller("ventaProductoController", function($scope,$controller,$filter,ModalService,statusFactory,dulceriaService){
	$scope.statusVenta = {elegirProducto : "selected",registrarPago : "",confirmarVenta : "",numeroPaso : 1	}
	$scope.fechaActual = moment(new Date()).format('DD/MM/YYYY');
	$controller('VentaProductoPaso2Controller',{$scope : $scope });
	$controller('VentaProductoPaso3Controller',{$scope : $scope });
	$scope.paquetes= [];
	$scope.paquetesSeleccionados= [];
	$scope.venta={};

	$scope.asignarPaso = function(paso) {
		$scope.statusVenta=statusFactory.estatusPasoVentaProducto(paso);
		$scope.statusVenta.numeroPaso = paso;
	}
	
	$scope.consultarPaquetes = function() {
		dulceriaService.consultarPaquetes().success(function(data) {
			$scope.paquetes =data;
			 $scope.errorPaquetes=false;
		}).error(function(data) {
			 $scope.paquetes={};
 			 $scope.errorPaquetes=true;
		});
	}

	$scope.agregarPaquete = function(paquete) {
		//paquete.cantidad=paquete.cantidad+1;
//        angular.forEach($scope.paquetes, function(value, key){
//        	if(value.idPaquete ==  paquete.idPaquete && value.nombre ==  paquete.nombre ){
//        		value.cantidad=value.cantidad+1;
//        		value.importe=value.cantidad * value.precio;
//            	$scope.total=$scope.total + value.importe;
//        	}
//		});
        
		paquete.cantidad=paquete.cantidad+1;
		paquete.importe=paquete.importe + paquete.precio;

    	$scope.pago.subtotal=$scope.pago.subtotal+ paquete.precio;
    	
        $scope.found=false;
        angular.forEach($scope.paquetesSeleccionados, function(value, key){
        	if(value.idPaquete ==  paquete.idPaquete && value.nombre ==  paquete.nombre){
        		$scope.found=true;
        	}
		});
        
        if ($scope.found==false){
        	$scope.paquetesSeleccionados.push(paquete);
        }
	}
		   
	$scope.eliminarPaquete = function(paquete) {
		paquete.cantidad=paquete.cantidad-1;
		paquete.importe=paquete.importe - paquete.precio;

    	$scope.pago.subtotal=$scope.pago.subtotal - paquete.precio;
    	
        angular.forEach($scope.paquetesSeleccionados, function(value, key){
        	if(value.cantidad == 0 ){
        		$scope.paquetesSeleccionados.splice(key, 1);
        	}
		});
        
//        for (var i = $scope.paquetesSeleccionados.length - 1; i >= 0; i--) {
//            if (!$scope.paquetesSeleccionados[i].cantidad == 0) {
//                $scope.paquetesSeleccionados.splice(i, 1);
//            }
//        }
	}
	
	$scope.validarPaquetes =function(){
		dulceriaService.validarPaquetes($scope.paquetesSeleccionados).success(function(data) {	

			var mensajes=[];
			
			if(data.agotado){
  			
 			 angular.forEach(data.productosExistenciaVO, function(value, key){
 				var mensaje="";
 				mensaje+=value.productoVO.nombre +"\tExistencia: "+value.existencia+"\tSeleccionados: "+value.seleccionado;
 				mensajes.push(mensaje);
 			});
 			 $scope.showAvisoMensajes(mensajes);
			}
            else
            	$scope.asignarPaso(2); 
			var mensajes=[];
			
			if(data.agotado){
  			
 			 angular.forEach(data.productosExistenciaVO, function(value, key){
 				var mensaje="";
 				mensaje+=value.productoVO.nombre +"\tExistencia: "+value.existencia+"\tSeleccionados: "+value.seleccionado;
 				mensajes.push(mensaje);
 			});
 			 $scope.showAvisoMensajes(mensajes);
			}
            else
            	$scope.asignarPaso(2); 
 		  }).error(function(data) {
 			 $scope.asignarPaso(2); 
		  });
	}
	
	 $scope.showAvisoMensajes= function(messageTo) {
		ModalService.showModal({
							templateUrl : 'vistas/templatemodal/templateModalAvisoDinamico.html',
							controller : 'mensajeModalController',
							inputs : {
								message : messageTo
							}
						}).then(function(modal) {
					modal.element.modal();
				});
	};
	
	
	$scope.consultarPaquetes();

	$scope.requestAutorizacionVO={};
	
	$scope.consultarTicketBoletos = function() {
		dulceriaService.consultarTicketBoletos(214).success(function(data) {
		}).error(function(data) {
		});
	}



	$scope.requestAutorizar = function() {
		$scope.requestAutorizacionVO.correo="urielux@hotmail.com";
		$scope.requestAutorizacionVO.contrasenia="ruix";
		$scope.requestAutorizacionVO.idTipoAutorizacion=2;
		$scope.requestAutorizacionVO.comentarios="Comentarios"
		
		dulceriaService.requestAutorizar($scope.requestAutorizacionVO).success(function(data) {
		}).error(function(data) {
		});
	}

	
	//$scope.requestAutorizar();
	//$scope.consultarTicketBoletos();
//	$scope.consultarTicketProductos();
	
	
	$scope.consultar = function() {
		dulceriaService.consultar(1, $scope.fechaActual, 4, 'DUL-001').success(function(data) {
		}).error(function(data) {
		});
	}
	
	$scope.consultarArticulos = function() {
		dulceriaService.consultarArticulos().success(function(data) {
		}).error(function(data) {
		});
	}
	
	$scope.consultarIngresosPeliculas = function() {
		dulceriaService.consultarIngresoPelicula(1).success(function(data) {
		}).error(function(data) {
		});
	}
	
	$scope.consultarAsistencia = function() {
		dulceriaService.consultarAsistencia(1,$scope.fechaActual, 12).success(function(data) {
		}).error(function(data) {
		});
	}
	
	$scope.consultarCinesEmpresa = function() {
		dulceriaService.consultarCinesEmpresa().success(function(data) {
		}).error(function(data) {
		});
	}
	
	$scope.consultarRentables = function() {
		dulceriaService.consultarRentables(1,$scope.fechaActual,30, false, 10).success(function(data) {
		}).error(function(data) {
		});
	}
	
	$scope.consultarVendidos = function() {
		dulceriaService.consultarVendidos(1,$scope.fechaActual,30, false, 10).success(function(data) {
		}).error(function(data) {
		});
	}
	
	
	$scope.consultarRentabilidad = function() {
		dulceriaService.consultarRentabilidad(1,$scope.fechaActual, 30).success(function(data) {
		}).error(function(data) {
		});
	}
	
	
	//$scope.consultar();
	$scope.consultarArticulos();
//	$scope.consultarIngresosPeliculas();
//	$scope.consultarAsistencia();
//	$scope.consultarCinesEmpresa();
//	$scope.consultarRentables();
//	$scope.consultarVendidos();
//	$scope.consultarRentabilidad();
	
	
});