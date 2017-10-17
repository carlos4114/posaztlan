'use strict';

angular.module('loginModule').controller('LoginController', ['LoginService','$scope','GlobalFactory','ErrorFactory','$window',
        function(loginService, $scope, GlobalFactory,ErrorFactory,$window) {
            $scope.greeting = 'Aplicaci\u00F3n de Referencia';
            $scope.userName = '';
            $scope.password = '';
            $scope.token = null;            	
            $scope.error = '';
            GlobalFactory.setAuthHeader('');
            
            var MAIN_PAGE = GlobalFactory.getProperty('mainPage');
            var CONTEXT_PATH = GlobalFactory.getProperty('contextPath');
            
            $scope.resetValues = function(){
                $scope.userName = '';
                $scope.password = '';
                $scope.token = null;            	
                $scope.error = '';
                GlobalFactory.setAuthHeader('');
            }
            
            $scope.login = function() {
                
                $scope.error = null;
                loginService.login($scope.userName,$scope.password).then(function(responseLogin) {
                	
                	if(responseLogin.errorCode){
                        $scope.resetValues();
                		$scope.error = ErrorFactory.getErrorSecurityMessage(responseLogin.errorCode);
                	}else{

                    	$scope.token = responseLogin.token;
                    	GlobalFactory.setAuthHeader('Bearer ' + responseLogin.token);
            			$window.location.href = '/'+CONTEXT_PATH+"/"+MAIN_PAGE;
                	}
                },
                function(error){
                	console.error('Error en login: ',error);
                    $scope.resetValues();
                    $scope.error = "No se pudieron validar los datos. "+error.status+":"+ErrorFactory.getErrorMessage(error.status);
                });
                
            }

            $scope.logout = function() {
                $scope.resetValues();
            }

            $scope.loggedIn = function() {
                return $scope.token !== null;
            }
        } ]);