'use strict';
 
var IndexModule = angular.module('indexModule',['ngRoute','globalModule','blockUI','angularModalService','ng-decimal','angularUtils.directives.dirPagination','purplefox.numeric','ngFileUpload', 'myUpload']);

angular.module('indexModule').config(function($routeProvider){
	
        $routeProvider
        	/******VENTA DE BOLETOS*****/

        /*    .when("/ventaBoletos", {
                controller: "ventaBoletos",
                controllerAs: "vm",
                templateUrl: "vistas/taquilla/ventaboleto/venta_boletos.jsp" 
            
            })
            .when("/cancelacion_boleto", {
                controller: "cancelacionBoletoController",
                templateUrl: "vistas/taquilla/cancelacion/cancelacion_boleto.jsp" 
            
            })
              .when("/componentes", {
                 templateUrl: "vistas/taquilla/cancelacion/componentes.jsp" 
            
            })
            .when("/devolucion_boleto", {
                controller: "devolucionBoletoController",
                templateUrl: "vistas/taquilla/devolucion/devolucion_boleto.jsp" 
            
            })*/
            
            /****FIN VENTA DE BOLETOS******/
            
            /******VENTA DE PRODUCTO*****/
	        .when("/ventaManual", {
	            controller: "VentaManualController",
	            controllerAs: "vm",
	            templateUrl: "vistas/venta/venta_manual.jsp"
	        })

        /*    .when("/ventaProducto", {
                controller: "ventaProductoController",
                controllerAs: "vm",
                templateUrl: "vistas/dulceria/ventaproducto/venta_producto.jsp"
            })
            
             .when("/cancelacion_producto", {
                controller: "cancelacionDulceriaController",
                templateUrl: "vistas/dulceria/cancelacion/cancelacion_producto.jsp" 
            
            })
            .when("/devolucion_producto", {
                controller: "devolucionDulceriaController",
                templateUrl: "vistas/dulceria/devolucion/devolucion_producto.jsp" 
            
            })*/
            
             /******FIN VENTA DE PRODUCTO*****/

             /******CONFIGURACIONES*****/
            /*
            .when("/salas", {
                controller: "SalasController",
                controllerAs: "vm",
                templateUrl: "vistas/configuracion/salas.jsp"
            })
            .when("/programacion", {
                controller: "ProgramacionController",
                controllerAs: "vm",
                templateUrl: "vistas/configuracion/programacion.jsp"
            })
            .when("/preciosVenta", {
                controller: "PreciosVentaController",
                controllerAs: "vm",
                templateUrl: "vistas/configuracion/precio_x_formato.jsp"
            })
            .when("/peliculas", {
                controller: "PeliculasController",
                controllerAs: "vm",
                templateUrl: "vistas/configuracion/peliculas.jsp"
            })
            
            .when("/menusDulceria", {
                controller: "MenusDulceriaController",
                controllerAs: "vm",
                templateUrl: "vistas/configuracion/menus_dulceria.jsp"
            })            
             .when("/promocionesTaquilla", {
                controller: "PromocionesTaquillaController",
                controllerAs: "vm",
                templateUrl: "vistas/configuracion/promocion_taquilla.jsp"
            })*/
        
        	.when("/productos", {
        		controller: "ProductosController",
        		controllerAs: "vm",
        		templateUrl: "vistas/configuracion/productos.jsp"
        	})
            .when("/cambiarContrasenia", {
                controller: "CambiarContraseniaController",
                controllerAs: "vm",
                templateUrl: "vistas/configuracion/cambiar_contrasenia.jsp"
            }).when("/usuarios", {
                controller: "UsuariosController",
                controllerAs: "vm",
                templateUrl: "vistas/configuracion/usuarios.jsp"
            })
           

            /******FIN CONFIGURACIONES*****/
            
            /******ADMINISTRACION*****/
            .when("/corteCaja", {
                controller: "CorteCajaController",
                controllerAs: "vm",
                templateUrl: "vistas/administracion/corte_caja.jsp"
            })
             .when("/ordenesCompra", {
                controller: "OrdenesCompraController",
                controllerAs: "vm",
                templateUrl: "vistas/administracion/orden_compra.jsp"
            })
            /********* FIN ADMINISTRACION***********/

            /******INVENTARIOS*****/            
            .when("/entradasInventario", {
                controller: "EntradasDulceriaController",
                controllerAs: "vm",
                templateUrl: "vistas/inventarios/entradas_dulceria_inventario.jsp"
            })
            .when("/salidasInventario", {
                controller: "SalidasDulceriaController",
                controllerAs: "vm",
                templateUrl: "vistas/inventarios/salidas_dulceria_inventario.jsp"
            })
            .when("/conteoInventario", {
                controller: "ConteoInventarioController",
                controllerAs: "vm",
                templateUrl: "vistas/inventarios/conteo_inventario.jsp"
            })
            /******FIN INVENTARIOS*****/            
            
            /******ESTADISTICAS*****/            
         /*   .when("/dashboardDulceria", {
	            controller: "dashboardDulceriaController",
 	            templateUrl: "vistas/dashboard/dashboard_dulceria.jsp"
	        })
	         .when("/dashboardTaquilla", {
	            controller: "dashboardTaquillaController",
 	            templateUrl: "vistas/dashboard/dashboard_taquilla.jsp"
	        })
	        .when("/reportesExcel", {
	            controller: "reportesController",
 	            templateUrl: "vistas/reportes/reportes_excel.jsp"
	        });*/
            /******FIN ESTADISTICAS*****/            
        
    });

