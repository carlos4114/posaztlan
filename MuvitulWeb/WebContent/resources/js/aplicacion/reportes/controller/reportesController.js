angular.module('indexModule').controller("reportesController", function($scope, $controller, $filter, statusFactory, reportesService) {

    $controller('modalController',{$scope : $scope });

    $scope.consultarReporte = function(reporte) {

        if ($scope.formReportes.$invalid) {
            angular.forEach($scope.formReportes.$error, function(field) {
                angular.forEach(field, function(errorField) {
                    errorField.$setDirty();
                })
            });
            $scope.showAviso("Es necesario llenar los campos obligatorios ");
        } else {
			 console.log(reporte);
			 $scope.reporteVO= {rutaPdf:"sadasdsadsd"};
        	reportesService.consultarReportes($scope.reporteVO).success(function(data,status,headers) {
     			 console.log(data);
    		}).error(function(data) {
    		  });
        }
    }

    
    $scope.consultarTiposReportes = function() {
//     	reportesService.consultarTiposReporte(reporte).success(function(data,status,headers) {
//			 console.log(data);
//		}).error(function(data) {
//		  });
     		
     		
        $scope.listaTipoReporte = [{
            nombre: "Tipo Reporte 1",
            data: "data"
        }, {
            nombre: "Tipo Reporte 2",
            data: "data"
        },{
            nombre: "Tipo Reporte 3",
            data: "data"
        }
        ];
      
    }
    
    $scope.consultarTiposReportes();
});