'use strict';

var cancelacionDulceriaControllerPaso2 = angular.module('indexModule').controller('cancelacionDulceriaControllerPaso2', function($controller,$scope,dulceriaService,ModalService,calculosFactory,cancelacionDulceriaService,PropertiesFactory){

	$controller('cancelacionDulceriaControllerPaso3',{$scope : $scope });
    $controller('modalController',{$scope : $scope });
	$scope.estatusPagoVO 			= {idEstatus:'',nombre:'PAGADO',clave :'PAG-001'}
	$scope.listaMotivosCancelacion	= {};
	$scope.cancelacion 				= {};
	$scope.listaPagos  				= [];
	$scope.listaPagosActuales  		= [];
	$scope.listaPagosCancelados 	= [];
 	$scope.pago	 					= { porPagar:0, pagado:0, montoCancelado:0};
	
 	
	$scope.procesarCancelacion = function(cancelacion) {
		if ( $scope.validaForm($scope.formCancelacions))
       	 	$scope.showAuthorization(cancelacion,PropertiesFactory.getTipoAutorizacion('cancelacion'));	 
         else
			$scope.showAviso("Es necesario llenar los campos obligatorios ");    
	}

	$scope.guardarPago =function(pago,formPagos){
		
		if (! $scope.validaForm(formPagos)) {
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
		 } else{
			 
 	        	pago.fecha = moment(new Date()).format('DD/MM/YYYY');
	  			$scope.calcularTotalPagado($scope.listaPagosActuales);
	  			 
	        	 if( pago.importe <= $scope.pago.porPagar){
	        		pago.estatusPagoVO=$scope.estatusPagoVO;
	 	 			$scope.listaPagosActuales.push(angular.copy(pago));
		  			$scope.calcularTotalPagado($scope.listaPagosActuales);
	        	 } else{ 
	  			     $scope.calcularTotalPagado($scope.listaPagosActuales);
	  	             $scope.showAviso("El monto que quieres pagar es menor al restante por pagar.");
	        	 }
	        	 if( $scope.pago.cambio >= 0 && pago.pagoCon >=0 && $scope.requiereNumCuenta ==false){
	 				 $scope.cambioTotal = $scope.pago.cambio + $scope.cambioTotal;
	 				 $scope.pagoConTotal = pago.pagoCon + $scope.pagoConTotal;
	 			}
		 }
		 $scope.resetObjetoPago();
	}
	
	$scope.resetObjetoPago =function(){
		$scope.pago.importe = 0.00;
		$scope.pago.pagoCon = 0.00;
		$scope.pago.cambio = 0.00;
		$scope.pago.noCuenta=" ";
	}
	
	$scope.calcularTotalPagado =function(listaPagos){
		 $scope.pago.pagado=0;
		 angular.forEach( listaPagos, function (data) {
 			 $scope.pago.pagado  = calculosFactory.suma($scope.pago.pagado, data.importe);
		 });
		 $scope.pago.porPagar =calculosFactory.resta($scope.pago.montoCancelado,$scope.pago.pagado);
	}

	$scope.calcularCambio =function(pagoCon,pagoImporte){
		if (pagoCon > 0 && pagoImporte < pagoCon)
			$scope.pago.cambio= pagoCon - pagoImporte;
		else
			$scope.pago.cambio = 0.00;
	}
	
	//Obtiene las formas de pago
	$scope.seleccionarFormaPago =function( formaPago, formPagos){
		if(formaPago.requiereNumCuenta == false){
    		$scope.pago.noCuenta ='';
    		$scope.requiereNumCuenta=false;
		}else
			$scope.requiereNumCuenta=true;
		
		formPagos.$setPristine();
 		$scope.pago.formaPagoVO = formaPago;
	}
	
	$scope.consultarMotivosCancelaciones = function() {
		cancelacionDulceriaService.consultarMotivosCancelaciones().success(function(data) {
	 		$scope.listaMotivosCancelacion	= data;
	 	}).error(function(data) {
		});
	}
	
	$scope.cargarCatalogos=function(){
		$scope.consultarMotivosCancelaciones();
		$scope.consultarFormasPago();
	 };
	 
 		//Consulta formas de pago
 	$scope.consultarFormasPago =function(){
 		dulceriaService.consultarFormasPago().success(function(data) {	
 	 		$scope.listaFormasPago=data;
 	 	}).error(function(data) {
 		});
 	}
 	
	$scope.showAuthorization = function(cancelacion,tipoAutorizacion) {
		if( $scope.pago.pagado < $scope.pago.montoCancelado ){
			 $scope.showAviso("No se ha cubierto el monto completo");
		       return;
		}
		
		ModalService.showModal({
	    	templateUrl: 'vistas/templatemodal/templateModalAutorizacion.html',
	    	controller: 'authorizationModalController',
	    	inputs:{ tipoAutorizacion: tipoAutorizacion}
	      }).then(function(modal) {
	        modal.element.modal();
	        modal.close.then(function(result) {	
	        	if(result.status==1)
	        		cancelacion.idAutorizacion=result.idAutorizacion;
	        		$scope.crearCancelacion(cancelacion);
	        }); 
	      });
			 
		}
	
	$scope.cancelar = function(array,index){
		array.splice(index,1);
		$scope.calcularTotalPagado($scope.listaPagosActuales);

	}
	
		
 });
 