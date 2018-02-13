'use strict';
 
angular.module('indexModule').directive('elegirProducto', function(){
    return {
    	templateUrl : "vistas/dulceria/ventaproducto/venta_producto_paso1.jsp"
    }        
})

angular.module('indexModule').directive('registrarPagoProducto', function(){
    return {
    	templateUrl : "vistas/dulceria/ventaproducto/venta_producto_paso2.jsp"
    }        
})

angular.module('indexModule').directive('confirmarVentaProducto', function(){
    return {
    	templateUrl : "vistas/dulceria/ventaproducto/venta_producto_paso3.jsp"
    }        
})