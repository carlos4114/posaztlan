'use strict';

var VentaProductoPaso2Controller = angular.module('indexModule').controller("VentaProductoPaso2Controller", function($scope,$controller,$filter,dulceriaService,calculosFactory,ModalService){
	$controller('modalController',{$scope : $scope });
	$scope.listaPagos			=[];
	$scope.listaFormasPago		={};
	$scope.estatusPagoVO 		={idEstatus:'1',nombre:'PAGADO'}
 	$scope.pago				    ={pagoCon:0.00, cambio:0.00, subtotalAux:0,subtotal:0, porPagar:0, pagado:0,estatusPagoVO:$scope.estatusPagoVO};
	
	$scope.consultarFormasPago =function(){
		dulceriaService.consultarFormasPago().success(function(data) {	
 			$scope.listaFormasPago=data;
 		  }).error(function(data) {
		  });
	}
	
	$scope.seleccionarFormaPago =function( formaPago, formPagos){
		if(formaPago.requiereNumCuenta == false){
    		$scope.pago.noCuenta ='';
    		$scope.requiereNumCuenta=false;
		}else
			$scope.requiereNumCuenta=true;
		
		formPagos.$setPristine();
 		$scope.pago.formaPagoVO = formaPago;
	}
	
	$scope.calcularTotalPagado =function(pagos){
		$scope.pago.pagado=0;
		 angular.forEach( pagos, function (data) {
 			 $scope.pago.pagado  = calculosFactory.suma($scope.pago.pagado, data.importe);
		 });
		 $scope.pago.porPagar =calculosFactory.resta($scope.pago.subtotal,$scope.pago.pagado);
	}
	
	
	$scope.guardarPago =function(pago,formPagos){
		if ( formPagos.$invalid) {
            angular.forEach( formPagos.$error, function (field) {
              angular.forEach(field, function(errorField){
            	  errorField.$setDirty();
              })
            });
            $scope.showAviso("Es necesario llenar los campos obligatorios ");
            return;
         }
		 if(!pago.formaPagoVO.requiereNumCuenta && pago.importe > pago.pagoCon){
			 
	       $scope.showAviso("El importe "+pago.importe+", es mayor a lo que esta recibiendo ");
	       return;
	       
		 } 
		 if(pago.importe == 0){
			 
		       $scope.showAviso("El importe debe ser mayor a 0 ");
		       return;
		       
		 }
		 else{ 
        	pago.fecha=new Date();
        	 
 			$scope.listaPagos.push(angular.copy(pago));
 			$scope.calcularTotalPagado($scope.listaPagos);
 			
       	 if($scope.pago.subtotal < $scope.pago.pagado ){
    		 $scope.listaPagos.pop();
			     $scope.calcularTotalPagado($scope.listaPagos);
	            $scope.showAviso("El monto que quieres pagar es menor al restante por pagar.");
    	 }else 	if( $scope.pago.cambio>=0 && pago.pagoCon >=0 && $scope.requiereNumCuenta ==false){
 				$scope.cambioTotal = $scope.pago.cambio + $scope.cambioTotal;
 				$scope.pagoConTotal	= pago.pagoCon + $scope.pagoConTotal;
 			}
 			

 
		 }
		 $scope.resetObjetoPago();
	}
	
	$scope.resetObjetoPago =function( ){
//		$scope.pago.formaPagoVO = null;
		$scope.pago.importe = 0.00;
		$scope.pago.pagoCon = 0.00;
		$scope.pago.cambio = 0.00;
		$scope.pago.noCuenta=' ';
}

	
	 $scope.confirmacionVenta = function(venta){
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
			     			//$scope.completarDatosPago();
			        		$scope.procesarVenta(venta);
			        	}
			        }); 
			    });
			};
			$scope.showConfirmacion ("¿Est\u00e1 seguro de cerrar la venta ?");
		 
	};
	
	$scope.calcularCambio =function(pagoCon,pagoImporte){
		if (pagoCon > 0 && pagoImporte < pagoCon)
			$scope.pago.cambio=pagoCon-pagoImporte;
		
	}
	
	$scope.procesarVenta =function(venta){
		venta.pagosVO=$scope.listaPagos;
		venta.paquetesVO=$scope.paquetesSeleccionados;
		venta.total=$scope.pago.subtotal;
		console.log(venta);
		dulceriaService.procesarVenta(venta).success(function(data) {	
			$scope.asignarPaso(3);
			$scope.ticketVenta=data;
			 
 		  }).error(function(data) {
		  });

		
	}
	
});