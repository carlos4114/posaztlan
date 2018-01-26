'use strict';

var devolucionDulceriaController = angular.module('indexModule').controller('devolucionDulceriaController', function($controller,$scope,$filter,devolucionDulceriaService,statusFactory,ModalService){
	
	$scope.status			= { paso1	:"selected", paso2 :"", paso3	:"", paso4	:"",  paso5  :"", numeroPaso:1	}
	$scope.ticket = null;
	$controller('devolucionDulceriaControllerPaso2',{$scope : $scope });
	$controller('devolucionDulceriaControllerPaso3',{$scope : $scope });
    $controller('modalController',{$scope : $scope });
 	$scope.seleccionDevolucion = false;
 	$scope.disabledTipoDevolucion=false;
		
	$scope.asignarPaso =function( paso){
		if($scope.ticket  == null || $scope.fin == true || $scope.seleccionDevolucion == false )
			return;
		$scope.status= statusFactory.statusPaso(paso);
		$scope.status.numeroPaso = paso;
	}
	
	$scope.consultarTicket = function(idTicket) {
		if(idTicket == undefined){
            $scope.showError("Es necesario introducir un número de ticket");
			$scope.ticket		= null;

            return;
		}

		devolucionDulceriaService.consultarTicketProductos(idTicket).success(function(data) {
 			$scope.ticket = data;
 			$scope.seleccionDevolucion = false;
			$scope.devolucion.idTicketVenta = $scope.ticket.idTicket;
			$scope.cargarCatalogos();
		}).error(function(data) {
				$scope.ticket		= null;
		         $scope.showError("No se encontró Información para el no. de ticket: " +  $scope.idTicket);

		});
	}
	
	
	$scope.seleccionarTodosPaquetes = function( paquetes ) {
		 console.log($scope.ticket.seleccionarPaquetes);
	   		 angular.forEach(paquetes , function(value, key){ 
	   			value.paqueteVO.selected = $scope.ticket.seleccionarPaquetes;
	   			$scope.seleccionarTodosProducto(value);
	 	   	});	
	}

	$scope.seleccionarTodosProducto = function( paquete ) {
			$scope.seleccionDevolucion=$scope.ticket.seleccionarPaquetes;
	 		 angular.forEach(paquete.paqueteVO.productosXPaqueteVO , function(value, key){ 
//	 			 if(paquete.paqueteVO.selected == true )
//	 				 value.productoVO.selected = true;  
//	 			 else
	 				// value.productoVO.selected = $scope.ticket.seleccionarPaquetes;  
	 			value.productoVO.selected = paquete.paqueteVO.selected;  
	 	   	});	

  	}
	
	$scope.seleccionarProducto = function( producto, paquete ) {
		$scope.seleccionDevolucion=true;

		$scope.listaProductosFilter=$filter('filter')(paquete.paqueteVO.productosXPaqueteVO,{ productoVO :{selected: true}} );
		
 		if($scope.listaProductosFilter.length >= 0)
			paquete.paqueteVO.selected = false;
		if($scope.listaProductosFilter.length == paquete.paqueteVO.productosXPaqueteVO.length)
			paquete.paqueteVO.selected = true;
		
 	}

	
	$scope.determinarTipoDevolucion = function() {
		
		console.log('determinar tipodevolucion');
		var clave='EFE-002';
	 	$scope.disabledTipoDevolucion=false;
	 	
	 	
		for (var i = 0; i < $scope.ticket.paquetesXTicketVO.length; ++i) {
			//$scope.listaProductosFilter=$filter('filter')(paquete.paqueteVO.productosXPaqueteVO,{selected:true});
			var n=0;
			angular.forEach($scope.ticket.paquetesXTicketVO[i].paqueteVO.productosXPaqueteVO , function(value, key){ 
				console.log(value.productoVO.nombre);
				console.log(value.productoVO.selected);
				if (value.productoVO.selected == true) n++;
			});
			
		    if (n == 0) { continue; }

			if ( n != $scope.ticket.paquetesXTicketVO[i].paqueteVO.productosXPaqueteVO.length){
				clave='PRO-001';
				//$scope.selecionarTipoDevolucion(clave);
			 	$scope.disabledTipoDevolucion=true;
				break;
			}
		}
		
		$scope.devolucion.paquetesXTicketVO = $scope.ticket.paquetesXTicketVO;
		$scope.selecionarTipoDevolucion(clave);
		$scope.sumaMontoPaquete();

 	}
	
	$scope.selecionarTipoDevolucion = function(clave) {
		angular.forEach($scope.listaTiposDevolucion	, function(value, key){ 
			if (value.clave == clave) {
				$scope.devolucion.tipoDevolucionVO=value; 
			}
		});
	}
	
	$scope.sumaMontoPaquete = function() {
		$scope.devolucion.importe=0;
		angular.forEach($scope.ticket.paquetesXTicketVO, function(value, key){
			if(value.paqueteVO.selected)
				$scope.devolucion.importe  +=value.importe;
		});
	}
	
 });
 