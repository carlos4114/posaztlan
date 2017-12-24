angular.module('indexModule').controller("reportesController", function($scope, $controller, $filter, statusFactory, reportesService) {

    $controller('modalController',{$scope : $scope });
    $scope.listaArticulos = null;
    
    $scope.consultarReporte = function(reporte) {

        if ($scope.formReportes.$invalid) {
            angular.forEach($scope.formReportes.$error, function(field) {
                angular.forEach(field, function(errorField) {
                    errorField.$setDirty();
                })
            });
            $scope.showAviso("Es necesario llenar los campos obligatorios ");
        } else {
        	reportesService.consultarReportes($scope.reporteVO).success(function(data,status,headers) {
     			 console.log(data);
     			$scope.save(data.archivo,data.nombre);   			 
    		}).error(function(data) {
    		  });
        }
    }
    
  
	function base64toBlob(base64Data, contentType) {
	    contentType = contentType || '';
	    var sliceSize = 1024;
	    var byteCharacters = atob(base64Data);
	    var bytesLength = byteCharacters.length;
	    var slicesCount = Math.ceil(bytesLength / sliceSize);
	    var byteArrays = new Array(slicesCount);

	    for (var sliceIndex = 0; sliceIndex < slicesCount; ++sliceIndex) {
	        var begin = sliceIndex * sliceSize;
	        var end = Math.min(begin + sliceSize, bytesLength);

	        var bytes = new Array(end - begin);
	        for (var offset = begin, i = 0 ; offset < end; ++i, ++offset) {
	            bytes[i] = byteCharacters[offset].charCodeAt(0);
	        }
	        byteArrays[sliceIndex] = new Uint8Array(bytes);
	    }

	    var blob = new Blob(byteArrays, {type: contentType});
	    return blob;
	}
	
    
    
    $scope.save=function(data, fileName) {
	 	var blob = new base64toBlob(data, "application/vnd.ms-excel" );
 
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
            nombre: "Kardex",
            codigo: "KARDEX"
        }, {
        	id: 2,
            nombre: "Ventas por  Dia",
            codigo: "VENTAS-DIA"
        },{
        	id: 3,
            nombre: "Ventas Semanal",
            codigo: "VENTAS-SEMANA"
        },{
        	id: 3,
            nombre: "Ventas Mensual",
            codigo: "VENTAS-MENSUAL"
        }
        
        ];
      
    }
    $scope.resetFormulario = function(){
		$scope.formReportes.$setPristine();
		$scope.reporteVO.fechaInicio=null;
		$scope.reporteVO.fechaFin=null;
		$scope.reporteVO.articulo=null;

		
		$scope.consultarArticulos();
	 }
    
    $scope.consultarArticulos = function(){
    	reportesService.consultarArticulos().success(function(data,status,headers) {
			 $scope.listaArticulos=data;
		}).error(function(data) {
		  });
	 }
    
    $scope.consultarTiposReportes();
});