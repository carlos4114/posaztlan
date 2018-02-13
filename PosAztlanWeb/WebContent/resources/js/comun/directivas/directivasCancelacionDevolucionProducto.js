'use strict';
 
angular.module('indexModule').directive('buscarTicketCancelacionDulceria', function(){
    return {
    	templateUrl : "vistas/dulceria/cancelacion/cancelacion_producto_paso1.jsp"
    }        
})

angular.module('indexModule').directive('generarCancelacionDulceria', function(){
    return {
    	templateUrl : "vistas/dulceria/cancelacion/cancelacion_producto_paso2.jsp"
    }        
})

angular.module('indexModule').directive('terminarCancelacionDulceria', function(){
    return {
    	templateUrl : "vistas/dulceria/cancelacion/cancelacion_producto_paso3.jsp"
    }        
})



angular.module('indexModule').directive('buscarTicketDevolucionDulceria', function(){
    return {
    	templateUrl : "vistas/dulceria/devolucion/devolucion_producto_paso1.jsp"
    }        
})

angular.module('indexModule').directive('generarDevolucionDulceria', function(){
    return {
    	templateUrl : "vistas/dulceria/devolucion/devolucion_producto_paso2.jsp"
    }        
})

angular.module('indexModule').directive('terminarDevolucionDulceria', function(){
    return {
    	templateUrl : "vistas/dulceria/devolucion/devolucion_producto_paso3.jsp"
    }        
})

 