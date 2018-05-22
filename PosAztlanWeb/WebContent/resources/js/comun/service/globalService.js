'use strict';

//para declarar fabrica de servicios globales de la aplicacion
angular.module('globalModule').factory('GlobalFactory',['$window','$location','$http','$q', 
    function($window,$location,$http, $q){
	
	var ambiente = "desarrollo";
	var paginaLogin = "login.jsp";    
	var paginaPrincipal = "inicio.jsp";    
	var pathArray = $location.path("/").absUrl().substr(1).split('/'); 
	var location=$location.path("/").absUrl(); 
	var contextPath = pathArray[3];    
    var httpProtocol = $location.protocol();    
    var appProperties = {
    					 servicesPath : 'http://localhost:8080/PosAztlanServices/rest/',
			    		 securityPath : 'http://localhost:8080/SeguridadServices/rest/',
			    		 httpProtocol: httpProtocol,
			    		 contextPath: contextPath,
			    		 mainPage: paginaPrincipal
			    		}
    var appPropertiesProduccion = {
			 servicesPath : 'http://18.191.42.168:8080/PosAztlanServices/rest/',
   		 securityPath : 'http://18.191.42.168:8080/SeguridadServices/rest/',
   		 httpProtocol: httpProtocol,
   		 contextPath: contextPath,
   		 mainPage: paginaPrincipal
   		}
    
    var paginasSinSeguridad=[
         'vistas/configuracion/recuperar_contrasenia.jsp'
    ];
    
	
	// SE INICIALIZA EL HEADER DE AUTENTICACIÓN (TOKEN) Y SE REVISA SI ESTÁ FIRMADO EL USUARIO,
    // DE LO CONTRARIO SE DIRECCIONA AL LOGIN.
    if(pathArray[4].indexOf(paginaLogin) == -1 && !sinSeguridad()){
	    var token = $http.defaults.headers.common.Authorization;
		if(!token)
			token = $http.defaults.headers.common.Authorization = localStorage.getItem("Authorization")
		if(!token){
			$window.location.href = '/'+contextPath+"/"+paginaLogin;
		}
    }	
	
    var interfaz = {       
        getProperty: function(name){
        	if(ambiente=="desarrollo")
          		return appProperties[name];
          	else
          		return appPropertiesProduccion[name];
            
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
        setUserName: function(userName){        	
            localStorage.setItem("userNameApp", userName);
        },
        getUserName: function(){        		        	
            return localStorage.getItem("userNameApp");
        },
        setLogoEmpresa: function(logoEmpresa){        	
            localStorage.setItem("logoEmpresa", logoEmpresa);
        },
        getLogoEmpresa: function(){        		        	
            return localStorage.getItem("logoEmpresa");
        }, 
        setIdEmpresa: function(idEmpresa){        	
            localStorage.setItem("idEmpresa", idEmpresa);
        },
        getIdEmpresa: function(){        		        	
            return localStorage.getItem("idEmpresa");
        }, 
        setIdCanal: function(idCanal){        	
            localStorage.setItem("idCanal", idCanal);
        },
        getIdCanal: function(){        		        	
            return localStorage.getItem("idCanal");
        }, 
        setIdAlmacen: function(idAlmacen){        	
            localStorage.setItem("idAlmacen", idAlmacen);
        },
        getIdAlmacen: function(){        		        	
            return localStorage.getItem("idAlmacen");
        }, 
        setIsAdminGral: function(isAdminGral){        	
            localStorage.setItem("isAdminGral", isAdminGral);
        },
        getIsAdminGral: function(){        		        	
            return localStorage.getItem("isAdminGral");
        }, 
        setIsAdminGralEmpresa: function(isAdminGralEmpresa){        	
            localStorage.setItem("isAdminGralEmpresa", isAdminGralEmpresa);
        },
        getIsAdminGralEmpresa: function(){        		        	
            return localStorage.getItem("isAdminGralEmpresa");
        }, 
        setIsAdminCanal: function(isAdminCanal){        	
            localStorage.setItem("isAdminCanal", isAdminCanal);
        },
        getIsAdminCanal: function(){        		        	
            return localStorage.getItem("isAdminCanal");
        }, 
        setFotoUsuario: function(fotoUsuario){        	
            localStorage.setItem("fotoUsuario", fotoUsuario);
        },
        getFotoUsuario: function(){        		        	
            return localStorage.getItem("fotoUsuario");
        },  
        setCompleteUserName: function(completeUserName){        	
            localStorage.setItem("completeUserNameApp", completeUserName);
        },
        getCompleteUserName: function(){        		        	
            return localStorage.getItem("completeUserNameApp");
        },
        actualizarToken: function(){
            var deferred = $q.defer();
            var actualizarTkService = '';
            if(ambiente=="desarrollo")	
            	actualizarTkService = appProperties['securityPath'] + 'seguridad/actualizarTk';
            else
            	actualizarTkService = appPropertiesProduccion['securityPath'] + 'seguridad/actualizarTk';
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
        },
        logout: function(){
          	 delete $localStorage.token;
       		delete $rootScope.menuDinamico;		
       		$q.when();
        }
    }
    return interfaz;
    
    function sinSeguridad(){
  	  for(var i=0; i<paginasSinSeguridad.length;i++ ){
  		  if(location.indexOf(paginasSinSeguridad[i]) > -1){
  			  return true;
  		  }
  	  }
  	  return false;
    }
    
}]);


//interceptores de cada response del sistema
angular.module('globalModule').factory('ResponseInterceptorFactory', ['$window','$location','$q', '$injector', 
 function($window,$location,$q, $injector) {  
    var paginaLogin = "login.jsp";  
    var pathArray = $location.path("/").absUrl().substr(1).split('/'); 
	var contextPath = pathArray[3];    
	
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
        	var error = response.data;
        	if(error.indexOf("ExpiredJwtException") !== -1){
    			$window.location.href = '/'+contextPath+"/"+paginaLogin;
        	}else{	            
	            var deferred = $q.defer();
	            return $q.reject(response);
        	}
        }
    };
    
    return responseInterceptor;
    
}]);


//para declarar interceptores de la apliacion
angular.module('globalModule').config(['$httpProvider', function($httpProvider) {  
    $httpProvider.interceptors.push('ResponseInterceptorFactory');
}]);
