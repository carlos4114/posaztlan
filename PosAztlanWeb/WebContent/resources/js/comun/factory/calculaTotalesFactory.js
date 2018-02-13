'use strict';
angular.module('indexModule').factory("calculosFactory",function(ModalService) { 
	 
	return {
		    calcularSubtotal:function(cantidad,precio) {
		      return cantidad * precio;
		    },
		    calcularTotal:function(a,b) {
		      return a * b;
		    },
		    suma:function(a,b) {
		    	 var total=0;
		    	  total = parseFloat(a) + parseFloat(b);
			      return total;
			},
			resta:function(a,b) {
				var total = 0;
				total = parseFloat(a) -  parseFloat(b);
			      return total;
			},
		    calcularTotal:function(a,b) {
			      return a * b;
			    },
			test:function(valor) {
				var resultado;
 				      ModalService.showModal({
 				    	 templateUrl: 'vistas/templatemodal/templateModalAutorizacion.html',
 			        	controller: 'authorizationModalController',
 			        	inputs:{ tipoAutorizacion: 1}
				      }).then(function(modal) {
				        modal.element.modal();
				        modal.close.then(function(result) {	
				        	resultado=result;
				        		return resultado;
				        	 
				         
				        }); 
				        return resultado;
				      });
 		   }
		    
	  	}
	});


 
 
 
 