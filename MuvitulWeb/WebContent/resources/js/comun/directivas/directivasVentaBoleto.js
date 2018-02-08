'use strict';
 
angular.module('indexModule').directive('elegirPelicula', function(){
    return {
    	templateUrl : "vistas/taquilla/ventaboleto/venta_boletos_paso1.jsp"
    }        
})

angular.module('indexModule').directive('elegirPromocion', function(){
    return {
    	templateUrl : "vistas/taquilla/ventaboleto/venta_boletos_paso2.jsp"
    }        
})

angular.module('indexModule').directive('elegirCantidad', function(){
    return {
    	templateUrl : "vistas/taquilla/ventaboleto/venta_boletos_paso3.jsp"
    }        
})

angular.module('indexModule').directive('seleccionarAsientos', function(){
    return {
    	templateUrl : "vistas/taquilla/ventaboleto/venta_boletos_paso4.jsp"
    }        
})

angular.module('indexModule').directive('registrarPago', function(){
    return {
    	templateUrl : "vistas/taquilla/ventaboleto/venta_boletos_paso5.jsp"
    }        
})

angular.module('indexModule').directive('confirmarVenta', function(){
    return {
    	templateUrl : "vistas/taquilla/ventaboleto/venta_boletos_paso6.jsp"
    }        
})