 

var VentaBoletosPaso5Controller = angular.module('indexModule').controller("VentaBoletosPaso5Controller", function($controller,$scope,$filter,ModalService,calculosFactory,taquillaService){

	$scope.listaPagos			=[];
	$scope.listaFormasPago		={};
	$scope.estatusPagoVO 		={idEstatus:'1',nombre:'PAGADO'}
 	$scope.pago				    ={subtotalAux:0,subtotal:0, porPagar:0, pagoCon: ' ', pagado:0,estatusPagoVO:$scope.estatusPagoVO};
 	$controller('VentaBoletosPaso4Controller',{$scope : $scope });
 	$controller('VentaBoletosPaso6Controller',{$scope : $scope });
    $controller('modalController',{$scope : $scope });
 
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
  	            
        	 }else if( $scope.pago.cambio>=0 && pago.pagoCon >=0 && $scope.requiereNumCuenta ==false){
 				$scope.cambioTotal = $scope.pago.cambio + $scope.cambioTotal;
 				$scope.pagoConTotal	= calculosFactory.suma(pago.pagoCon , $scope.pagoConTotal);
 			}
 
		 }
		 $scope.resetObjetoPago();
	}
	
	//Obtiene las formas de pago
	$scope.seleccionarFormaPago =function( formaPago, formPagos){
		if(formaPago.requiereNumCuenta == false){
    		$scope.pago.noCuenta ='';
    		$scope.resetObjetoPago();
    		$scope.requiereNumCuenta=false;
    		
		}else
			$scope.requiereNumCuenta=true;
		
		formPagos.$setPristine();
 		$scope.pago.formaPagoVO = formaPago;
	}
	
	$scope.resetObjetoPago =function( ){
//  		$scope.pago.formaPagoVO = null;
  		//$scope.pago.importe = 0.00;
  		$scope.pago.pagoCon = ' ';
  		$scope.pago.cambio = '';
  		$scope.pago.noCuenta=' ';
	}
	
	$scope.calcularTotalPagado =function(listaPagos){
		$scope.pago.pagado=0;
		 angular.forEach( listaPagos, function (data) {
 			 $scope.pago.pagado  = calculosFactory.suma($scope.pago.pagado, data.importe);
		 });
		 $scope.pago.porPagar =calculosFactory.resta($scope.pago.subtotal,$scope.pago.pagado);
		 $scope.pago.importe=$scope.pago.porPagar;
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
			     			$scope.complementarDatosPago();
			     			$scope.objetosVenta.asientos = $scope.mapaAsientos;
			        		$scope.procesarVenta(venta);
			        	}
			        }); 
			    });
			};
			$scope.showConfirmacion ("¿Est\u00e1 seguro de cerrar la venta ?");
		 
	};
	
	//Consulta formas de pago
	$scope.consultarFormasPago =function(){
 		taquillaService.consultarFormasPago().success(function(data) {	
 			$scope.listaFormasPago=data;
 		  }).error(function(data) {
		  });
	}
	
	
	$scope.complementarDatosPago =function(){
		$scope.listaBoletosFilter = $filter('filter')($scope.boletos, {'tipoCliente': '!PROMO'});
 		$scope.objetosVenta.boletosXTicketVO=$scope.listaBoletosFilter;
 		$scope.promocion={ promocionVO:$scope.objetosVenta.promocion, cantidad:($scope.promocion ==null   ) ? 0:1, importe : ($scope.promocion ==null   ) ? 0: $scope.promocion.subtotal}
 		$scope.promo = [];
		$scope.promo.push($scope.promocion);
		$scope.objetosVenta.promocionesXTicketVO=$scope.promo;
  	}
	
	//ProcesarVenta
	$scope.procesarVenta =function( venta ){
		venta.pagosVO=$scope.listaPagos;
		taquillaService.procesarVenta(venta).success(function(data) {	
			$scope.asignarPaso(6);
			$scope.ticketVenta=data;
			 
 		  }).error(function(data) {
		  });
	}
	
	
	$scope.cancelar = function(array,index){
		var valueAtIndex = array[index];
		if (valueAtIndex.formaPagoVO.requiereNumCuenta ==false){
			$scope.cambioTotal = $scope.cambioTotal - (valueAtIndex.pagoCon - valueAtIndex.importe);
			$scope.pagoConTotal	= $scope.pagoConTotal - valueAtIndex.pagoCon;
		}
		array.splice(index,1);
		$scope.calcularTotalPagado($scope.listaPagos);
	}
	 
});