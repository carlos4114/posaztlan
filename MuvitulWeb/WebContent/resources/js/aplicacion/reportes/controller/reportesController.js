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
     			$scope.save(new Blob([data.archivo],
     				    { type: 'application/vnd.openxmlformat-officedocument.spreadsheetml.sheet;'}), data.nombre);
//     			$scope.downloadfile (data.archivo,data.nombre)
    		}).error(function(data) {
    		  });
        }
    }

    $scope.downloadfile = function(file, fileName) {
    	var urlCreator = window.URL || window.webkitURL || window.mozURL || window.msURL;
        if (urlCreator) {
            var blob = new Blob([file], { type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" });
            var url = urlCreator.createObjectURL(blob);
            var a = document.createElement("a");
            document.body.appendChild(a);
            a.style = "display: none";
            a.href = url;
            a.download = "download.xls"; //you may assign this value from header as well 
            a.click();
            window.URL.revokeObjectURL(url);
        }
	}
    
    $scope.save=function(blob, fileName) {
        if (window.navigator.msSaveOrOpenBlob) { // For IE:
            navigator.msSaveBlob(blob, fileName);
        } else { // For other browsers:
            var link = document.createElement('a');
            link.href = window.URL.createObjectURL(blob);
            link.download = fileName;
            link.click();
            window.URL.revokeObjectURL(link.href);
        }
    }
    $scope.consultarTiposReportes = function() {
//     	reportesService.consultarTiposReporte(reporte).success(function(data,status,headers) {
//			 console.log(data);
//		}).error(function(data) {
//		  });
     		
     		
        $scope.listaTipoReporte = [{
        	id: 1,
            nombre: "Tipo Reporte 1",
            codigo: "KARDEX"
        }, {
        	id: 2,
            nombre: "Tipo Reporte 2",
            codigo: "VENTAS-DIA"
        },{
        	id: 3,
            nombre: "Tipo Reporte 3",
            codigo: "VENTAS-SEMANA"
        }
        ];
      
    }
    
    $scope.consultarTiposReportes();
});