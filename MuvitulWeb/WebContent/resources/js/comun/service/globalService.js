'use strict';

//para declarar fabrica de servicios globales de la aplicacion
angular.module('globalModule').factory('GlobalFactory',['$window','$location','$http','$q', function($window,$location,$http, $q){
	
	var paginaLogin = "login.jsp";    
	var paginaPrincipal = "inicio.jsp";    
	var pathArray = $location.path("/").absUrl().substr(1).split('/'); 
	var contextPath = pathArray[3];    
    var httpProtocol = $location.protocol();    
    var appProperties = {
    					 servicesPath : 'http://localhost:8080/muvitul-service/rest/',
			    		 securityPath : 'http://localhost:8080/muvitul-seguridad/rest/',
			    		 httpProtocol: httpProtocol,
			    		 contextPath: contextPath,
			    		 mainPage: paginaPrincipal
			    		}
	
	// SE INICIALIZA EL HEADER DE AUTENTICACIÓN (TOKEN) Y SE REVISA SI ESTÁ FIRMADO EL USUARIO,
    // DE LO CONTRARIO SE DIRECCIONA AL LOGIN.
    if(pathArray[4].indexOf(paginaLogin) == -1){
	    var token = $http.defaults.headers.common.Authorization;
		if(!token)
			token = $http.defaults.headers.common.Authorization = localStorage.getItem("Authorization")
		if(!token){
			$window.location.href = '/'+contextPath+"/"+paginaLogin;
		}
    }	
	
    var interfaz = {       
        getProperty: function(name){
            return appProperties[name];
        },
        setAuthHeader: function(header){        	
            $http.defaults.headers.common.Authorization = header;
            localStorage.setItem("Authorization", header);
        },
        getAuthHeader: function(){
        	var token = $http.defaults.headers.common.Authorization;
        	if(!token){
        		$http.defaults.headers.common.Authorization = localStorage.getItem("Authorization");
        	}
            return $http.defaults.headers.common.Authorization;
        },
        initAuthHeader: function(){
            var token = $http.defaults.headers.common.Authorization;
        	if(!token){
        		$http.defaults.headers.common.Authorization = localStorage.getItem("Authorization");
        	}
        },
        actualizarToken: function(){
            var deferred = $q.defer();
            var actualizarTkService = appProperties['securityPath'] + 'seguridad/actualizarTk';
            $http.get(actualizarTkService)
                .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error al actualizar token.',errResponse);
                    deferred.reject(errResponse);
                }
            );
            return deferred.promise;
        }
    }
    return interfaz;
    
}]);


//interceptores de cada response del sistema
angular.module('globalModule').factory('ResponseInterceptorFactory', ['$q', '$injector', function($q, $injector) {  
    var responseInterceptor = {
        response: function(response) {
        	var GlobalFactory = $injector.get('GlobalFactory');
        	var token = GlobalFactory.getAuthHeader();
        	var responseUrlArray = response.config.url.split('/');
        	var responseService = responseUrlArray[responseUrlArray.length-1];
        	
        	//console.log('ActualizarToken? ',responseService!=='actualizarTk');
        	//console.log('Token: ',token);        	        	
            	//validamos si ya esta firmado el usuario y ademas que no sea la invocacion al servicio de actualizacion del token (sino se ciclaria)
        	if(token && responseService!=='actualizarTk'){
        		//actualizamos la fecha de expiracion del token
            	//console.log('Actualizamos el token:: ',token);        	        	
        		GlobalFactory.actualizarToken()
                .then(
	                function(responseLogin) {
	                    GlobalFactory.setAuthHeader('Bearer ' + responseLogin.token);	                	
	                },
	                function(errResponse){
	                    console.error('Error actualizando el token.');
	                }
                );
        		
        	}
 
            return response;
        },
        responseError: function(response) {
            // Session has expired
            /*if (response.status == 419){
                var SessionService = $injector.get('SessionService');
                var $http = $injector.get('$http');
                var deferred = $q.defer();
            }*/
            
            var deferred = $q.defer();
            return $q.reject(response);
        }
    };
    
    return responseInterceptor;
    
}]);


//para declarar interceptores de la apliacion
angular.module('globalModule').config(['$httpProvider', function($httpProvider) {  
    $httpProvider.interceptors.push('ResponseInterceptorFactory');
}]);
