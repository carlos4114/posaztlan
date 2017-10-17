'use strict';
 
angular.module('indexModule').directive('buscarTicketCancelacion', function(){
    return {
    	templateUrl : "vistas/taquilla/cancelacion/cancelacion_boleto_paso1.jsp"
    }        
})

angular.module('indexModule').directive('generarCancelacion', function(){
    return {
    	templateUrl : "vistas/taquilla/cancelacion/cancelacion_boleto_paso2.jsp"
    }        
})

angular.module('indexModule').directive('terminarCancelacion', function(){
    return {
    	templateUrl : "vistas/taquilla/cancelacion/cancelacion_boleto_paso3.jsp"
    }        
})



angular.module('indexModule').directive('buscarTicketDevolucion', function(){
    return {
    	templateUrl : "vistas/taquilla/devolucion/devolucion_boleto_paso1.jsp"
    }        
})

angular.module('indexModule').directive('generarDevolucion', function(){
    return {
    	templateUrl : "vistas/taquilla/devolucion/devolucion_boleto_paso2.jsp"
    }        
})

angular.module('indexModule').directive('terminarDevolucion', function(){
    return {
    	templateUrl : "vistas/taquilla/devolucion/devolucion_boleto_paso3.jsp"
    }        
})

 