'use strict';
 
var IndexModule = angular.module('indexModule',['ngRoute','globalModule','blockUI','angularModalService','ng-decimal','angularUtils.directives.dirPagination','purplefox.numeric','ngFileUpload', 'myUpload']);

angular.module('indexModule').config(function($routeProvider){
	
        $routeProvider
            .when("/cambiarContrasenia", {
                controller: "CambiarContraseniaController",
                controllerAs: "vm",
                templateUrl: "vistas/configuracion/cambiar_contrasenia.jsp"
            });
    });

