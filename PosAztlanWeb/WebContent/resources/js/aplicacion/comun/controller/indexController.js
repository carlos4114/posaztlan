'use strict';
 
angular.module('indexModule').controller("IndexController", ['$scope', 'IndexService','GlobalFactory', 'ErrorFactory','$http', 
  function($scope, IndexService, GlobalFactory, ErrorFactory, $http) {
	 obtenerMenu();
     $scope.nombreUsuario = GlobalFactory.getCompleteUserName();
     $scope.logoEmpresa = GlobalFactory.getLogoEmpresa();
	 
	 function obtenerMenu(){
    	IndexService.obtenerMenu()
            .then(
            function(d) {
                $scope.menu = d;
            },
            function(errResponse){
                console.error('Error obteniendo el menú.');
            }
        );
     }
	 
	 $scope.showChilds = function(item){
		    comprimeMenu();
	        item.active = !item.active;
	 };
	 
	 function comprimeMenu(){
		    angular.forEach($scope.menu, function(menu, key){
		        angular.forEach(menu.submenus, function(submenu, key){
		        	submenu.active = false;
		        });
		    });
	 }
	
}]);