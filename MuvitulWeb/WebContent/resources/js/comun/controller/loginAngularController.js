'use strict';

angular.module('loginModule').controller('LoginController', ['LoginService','$scope','GlobalFactory','ErrorFactory','$window',
        function(loginService, $scope, GlobalFactory,ErrorFactory,$window) {
            $scope.userName = '';
            $scope.password = '';
            $scope.token = null;            	
            $scope.error = '';
            GlobalFactory.setAuthHeader('');
            GlobalFactory.setUserName('');
            GlobalFactory.setLogoEmpresa('');
            GlobalFactory.setIdEmpresa('');
            
            var MAIN_PAGE = GlobalFactory.getProperty('mainPage');
            var CONTEXT_PATH = GlobalFactory.getProperty('contextPath');
            
            $scope.resetValues = function(){
                $scope.userName = '';
                $scope.password = '';
                $scope.token = null;            	
                $scope.error = '';
                GlobalFactory.setAuthHeader('');
                GlobalFactory.setUserName('');
                GlobalFactory.setLogoEmpresa('');
                GlobalFactory.setIdEmpresa('');
             }
            
            $scope.login = function() {
                
                $scope.error = null;
                loginService.login($scope.userName,$scope.password).then(function(responseLogin) {
                	
                	if(responseLogin.errorCode){
                        $scope.resetValues();
                		$scope.error = ErrorFactory.getErrorSecurityMessage(responseLogin.errorCode);
                	}else{
                		console.log(responseLogin);
                    	$scope.token = responseLogin.token;
                    	GlobalFactory.setAuthHeader('Bearer ' + responseLogin.token);
                    	GlobalFactory.setCompleteUserName(responseLogin.nombreCompletoUsuario);
                    	GlobalFactory.setUserName(responseLogin.userName);
                        GlobalFactory.setLogoEmpresa(responseLogin.logoEmpresa);
                        GlobalFactory.setIdEmpresa(responseLogin.idEmpresa);
            			$window.location.href = '/'+CONTEXT_PATH+"/"+MAIN_PAGE;
                	}
                },
                function(error){                	
                    $scope.resetValues();
                    $scope.error = "No se pudieron validar los datos. "+ErrorFactory.getErrorMessage(error.status);
                });
                
            }

            $scope.logout = function() {
                $scope.resetValues();
            }

            $scope.loggedIn = function() {
                return $scope.token !== null;
            }
        } ]);