'use strict';

var VentaProductoPaso3Controller = angular.module('indexModule').controller("VentaProductoPaso3Controller", function($scope,$controller,$filter,ModalService,dulceriaService){
    $controller('modalController',{$scope : $scope });
	$scope.cambioTotal 			=0.00;
	$scope.pagoConTotal			=0.00;
	$scope.isImpreso			=false;
    $scope.ticketVenta={};

    
    $scope.modalPrinter = function() {
        ModalService.showModal({
          templateUrl: 'vistas/templatemodal/templatePrintTicket.html',
          controller: 'modalControllerPrintTicket',
    	    scope: $scope
        }).then(function(modal) {
          modal.element.modal();
        });
  	};
  	
    
    
	$scope.imprimirTicket =function(){
		$scope.isImpreso =true;
		dulceriaService.imprimirTicket($scope.ticketVenta.idTicket,$scope.pagoConTotal, $scope.cambioTotal).success(function(data,status,headers) {	 		 
			$scope.listaImpresiones=data;
 			$scope.modalPrinter ();
			
			// 		 angular.forEach(data, function(value, key){
// 			generaArchivo(value.nombre,value.archivo,"application/pdf");
// 		   });
		}).error(function(data) {
		  });
	}
 	
	function generaArchivo(nombre, archivo, extension) {

	 	 var blob = new base64toBlob(archivo, extension);
		 var url = window.URL || window.webkitURL;
		 var blobUrl = url.createObjectURL(blob);
//		 var a         = document.createElement('a');
//		 a.href        = blobUrl; 
//		 a.target      = '_blank';
//		 a.download    = nombre;
		 printJS(blobUrl)
//		 window.print(blobUrl);
//		 setTimeout("printWindow.window.print()", 1000);    
//		 document.body.appendChild(a);
//		 a.click();
		 

	}

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

	$scope.resetVenta = function() {
		$scope.consultarPaquetes();
		$scope.paquetesSeleccionados= [];
		$scope.cambioTotal 			=0.00;
		$scope.pagoConTotal			=0.00;
	 	$scope.pago				    ={pagoCon:0.00, cambio:0.00, subtotalAux:0,subtotal:0, porPagar:0, pagado:0,estatusPagoVO:$scope.estatusPagoVO};
		$scope.listaPagos			=[];
		$scope.isImpreso			=false;
	}
	
	
	$scope.imprimirCortesia =function(){
		
		dulceriaService.imprimirCortesia(10, 2000).success(function(data,status,headers) {	 		 
 		 angular.forEach(data, function(value, key){
 			generaArchivo(value.nombre,value.archivo,"application/pdf");
 		   });
		}).error(function(data) {
		  });
	}
});