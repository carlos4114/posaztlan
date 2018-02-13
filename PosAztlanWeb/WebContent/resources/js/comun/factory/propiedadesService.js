'use strict';

//para declarar fabrica de servicios globales de la aplicacion
angular.module('globalModule').factory('PropertiesFactory',[ function(){

	var tiposAutorizacion = {
			  cortesia: '1',
	   		  devolucionCliente : '2',
	   		  cancelacion: '3',
	   		  salidaProveedor: '4',
	   		  salidaTraspaso: '5',
	   		  salidaMerma: '6',
	   		  ajusteEntradaManual: '7',
	   		  ajusteSalidaManual: '8',
	   		  corteDeCaja: '9'	   		  
	   		  }
		
	
	
	var promocionesPara = {
		  productos: 'PRO-001',
   		  boletos : 'BOL-002',
   		  paquetes: 'PAQ-003',
   		  }
	
	var tiposPromocion = {
			
			  nxm: 'NXM-001',
	   		  npf : 'NXF-002',
	   		  ppc: 'PPC-003',
	   		  prx:'PRX-004',
	   		  promo:'PROMO',
	   	}
    	
	
    var interfaz = {       
        getPromocionPara: function(name){
            return promocionesPara[name];
        },
        getTipoPromocion: function(name){
        	return tiposPromocion[name];
        },
        getTipoAutorizacion: function(name){
        	return tiposAutorizacion[name];
        }
    }
    return interfaz;
    
}]);