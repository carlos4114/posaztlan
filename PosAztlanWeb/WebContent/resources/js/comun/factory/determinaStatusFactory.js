'use strict';
angular.module('indexModule').factory("statusFactory",function() { 
	 
	return {
		    
		    statusPaso:function(paso) {
	    		 
	   		 var status = {};
	   			switch(paso) {
	   				
	   		    case 1:
	   		    	status.paso1 ="selected";
	   		    	status.paso2="";
	   		    	status.paso3 ="";
	   		    	status.paso4  ="";
	   		    	status.paso5 ="";
	   	 	        break;
	   		    case 2:
	   		    	status.paso1 = "done";
	   		    	status.paso2 ="selected";
	   		    	status.paso3 ="";
	   		    	status.paso4 ="";
	   		    	status.paso5 ="";
	   	 	        break;
	   		    case 3:
	   		    	status.paso1 = "done";
	   		    	status.paso2 ="done";
	   		    	status.paso3 ="selected";
	   		    	status.paso4 ="";
	   		    	status.paso5 ="";
	   	 	        break;
	   		   
	   	 	        }
	   			return status;
	   		 
		    },
			
		    estatusPasoVenta:function(paso) {
	    		 
	   		 var statusVenta = {};
	   			switch(paso) {
	   				
	   		    case 1:
	   		    	statusVenta.elegirPelicula ="selected";
	   		    	statusVenta.elegirPromocion="";
	   		    	statusVenta.elegirCantidad ="";
	   		    	statusVenta.seleccionarAsientos ="";
		   		    statusVenta.registrarPago  ="";
	   		    	statusVenta.confirmarVenta ="";
	   	 	        break;
	   		    case 2:
	   		    	statusVenta.elegirPelicula = "done";
	   		    	statusVenta.elegirPromocion="selected";
	   		    	statusVenta.elegirCantidad ="";
	   		    	statusVenta.seleccionarAsientos ="";
	   		    	statusVenta.registrarPago  ="";
	   		    	statusVenta.confirmarVenta ="";
	   	 	        break;
	   		    case 3:
	   		    	statusVenta.elegirPelicula = "done";
	   		    	statusVenta.elegirPromocion="done";
	   		    	statusVenta.elegirCantidad ="selected";
	   		    	statusVenta.seleccionarAsientos ="";
	   		    	statusVenta.registrarPago  ="";
	   		    	statusVenta.confirmarVenta ="";
	   	 	        break;
	   		    case 4:
	   		    	statusVenta.elegirPelicula = "done";
	   		    	statusVenta.elegirPromocion="done";
	   		    	statusVenta.elegirCantidad ="done";
	   		    	statusVenta.seleccionarAsientos ="selected";
	   		    	statusVenta.registrarPago  ="";
	   		    	statusVenta.confirmarVenta ="";
	   	 	        break;	   	 	        
	   		    case 5:
	   		    	statusVenta.elegirPelicula = "done";
	   		    	statusVenta.elegirPromocion="done";
	   		    	statusVenta.elegirCantidad ="done";
	   		    	statusVenta.seleccionarAsientos ="done";
	   		    	statusVenta.registrarPago  ="selected";
	   		    	statusVenta.confirmarVenta ="";
	   	 	        break;
	   		    case 6:
	   		    	statusVenta.elegirPelicula = "done";
	   		    	statusVenta.elegirPromocion="done";
	   		    	statusVenta.elegirCantidad ="done";
	   		    	statusVenta.seleccionarAsientos ="done";
	   		    	statusVenta.registrarPago  ="done";
	   		    	statusVenta.confirmarVenta ="selected";
	   	 	        break;
	   	 	        }
	   			return statusVenta;
	   		 
		    },
		    
		    estatusPasoVentaProducto:function(paso) {
		    	
		  		var status = {};
				switch (paso) {

				case 1:
					status.elegirProducto = "selected";
					status.registrarPago = "";
					status.confirmarVenta = "";
					break;
				case 2:
					status.elegirProducto = "done";
					status.registrarPago = "selected";
					status.confirmarVenta = "";
					break;
				case 3:
					status.elegirProducto = "done";
					status.registrarPago = "done";
					status.confirmarVenta = "selected";
					break;
				}
				
				return status;
			}
			
		    
	  	}
	});


 
 
 
 