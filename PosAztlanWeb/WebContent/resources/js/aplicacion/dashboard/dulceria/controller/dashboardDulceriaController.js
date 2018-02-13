angular.module('indexModule').controller("dashboardDulceriaController", function($scope, $controller, $filter, statusFactory, dashboardDulceriaService) {
  
	$scope.fechaActual = moment(new Date()).format('DD/MM/YYYY');
	$scope.ingresoTaquilla={};
	$scope.cine = null;
	
    $scope.consultarRentabilidaDulceria = function(idCine) {
    	dashboardDulceriaService.consultarRentabilidad(idCine,$scope.fechaActual, 30).success(function(data) {
            graficaRentabilidad(data);
		}).error(function(data) {
		});
     }
	
    //GRAFICA INGRESOS DE TAAQUILLA
    graficaIngresoDulceria = function(data) {
         var ctxIngresoTaquilla = document.getElementById("ingresoDulceria");
        var ingresoTaquilla = new Chart(ctxIngresoTaquilla, {
            type: 'line',
            data: {
                labels: data.dias,
                datasets: data.datasets
            },
            options: {
                responsive: true,
                title: {
                    display: true,
                    text: " "
                },
                scales: {
                    yAxes: [{
                        ticks: {
                            beginAtZero: true
                        },
                        scaleLabel: {
                            display: true,
                            labelString: 'Pesos'
                        }
                    }]
                }
            }
        });
    }

    graficaRentabilidad = function(rentabilidadVO) {
         var timeFormat = 'DD/MM/YYYY';
         var ctxAsistenciaPromedio = document.getElementById("asistenciaPromedio");
        var asistenciaPromedio = new Chart(ctxAsistenciaPromedio, {
            type: 'line',
            data: {
                labels: rentabilidadVO.fechas,
                datasets: [  {
                    label: "Rentabilidad",
                    backgroundColor: "rgba(3, 88, 106, 0.3)",
                    borderColor: "rgba(3, 88, 106, 0.70)",
                    pointBorderColor: "rgba(3, 88, 106, 0.70)",
                    pointBackgroundColor: "rgba(3, 88, 106, 0.70)",
                    pointHoverBackgroundColor: "#fff",
                    pointHoverBorderColor: "rgba(151,187,205,1)",
                    pointBorderWidth: 1,
                    fill: false,
                    data: rentabilidadVO.totales
                }]
            },
            options: {
            	responsive: true,
                title: {
                    text: "Titulo"
                },
                scales: {
                    xAxes: [{
                        type: "time",
                        display: true,

                        time: {
                            format: timeFormat,
                            unit: 'day',
                            tooltipFormat: timeFormat
                        },
                        ticks: {
                            callback: function(value) { 
                                return new Date(value).toLocaleDateString('es-ES', {day:'numeric',month:'short', year:'numeric'}); 
                            },
                        },
                        scaleLabel: {
                            display: false,
                            labelString: 'Ultimos 30 días'
                        }
                    }, ],
                    yAxes: [{
                        scaleLabel: {
                            display: true,
                            labelString: '% Rentabilidad'
                        }
                    }]
                },
            }
        });
    }
    
    
    //INICIO CONFIGURACION Ingresos semanales Taquilla
    $scope.consultarIngresosDulceria = function(idCine) {
       	dashboardDulceriaService.ingresosSemanales( idCine , $scope.fechaActual, 4, 'DUL-001').success(function(data) {
            configuracionGraficaIngresoTaquilla(data);
        }).error(function(data) {});
    }

    configuracionGraficaIngresoTaquilla = function(data) {
        var datasets = [];

        var config = {
            backgroundColor: "rgba(38, 185, 154, 0.31)",
            borderColor: "rgba(38, 185, 154, 0.7)",
            pointBorderColor: "rgba(38, 185, 154, 0.7)",
            pointBackgroundColor: "rgba(38, 185, 154, 0.7)",
            pointHoverBackgroundColor: "#fff",
            pointHoverBorderColor: "rgba(220,220,220,1)",
            pointBorderWidth: 1
        };

        var configSemanaActual = {
            backgroundColor: "rgba(3, 88, 106, 0.3)",
            borderColor: "rgba(3, 88, 106, 0.70)",
            pointBorderColor: "rgba(3, 88, 106, 0.70)",
            pointBackgroundColor: "rgba(3, 88, 106, 0.70)",
            pointHoverBackgroundColor: "#fff",
            pointHoverBorderColor: "rgba(151,187,205,1)",
            pointBorderWidth: 1,
        };

        var arrayLength = data.ingresoSemanalVO.length;

        for (var i = 0; i < arrayLength - 1; i++) {
            config.data = data.ingresoSemanalVO[i].totales;
            config.label = data.ingresoSemanalVO[i].descripcion;
            datasets.push(angular.copy(config));
        }

        configSemanaActual.data = data.ingresoSemanalVO[arrayLength - 1].totales;
        configSemanaActual.label = data.ingresoSemanalVO[arrayLength - 1].descripcion;
        datasets.push(angular.copy(configSemanaActual));

        data.datasets = datasets;
        graficaIngresoDulceria(data);

    }
    
    $scope.consultaCinesXEmpresa = function() {
    	dashboardDulceriaService.consultarCinesEmpresa( ).success(function(data) {
      	  $scope.listaCines=data;
         }).error(function(data) {
         });
    }
    
    //INICIO Consulta Mas Rentables
    $scope.consultarMasRentablesDulceria = function(idCine) {
    	$scope.listaMasRentables = null;
    	dashboardDulceriaService.consultarRentables(idCine,$scope.fechaActual,30, true, 10).success(function(data) {
    		$scope.listaMasRentables  = data ; 
		}).error(function(data) {
		});
    }

    //INICIO Consulta Menos Rentables
    $scope.consultarMenosRentablesDulceria = function(idCine) {
    	$scope.listaMenosRentables = null;
    	dashboardDulceriaService.consultarRentables(idCine,$scope.fechaActual,30, false, 10).success(function(data) {
    		$scope.listaMenosRentables=data;
		}).error(function(data) {
		});
    }
    //INICIO Consulta Mas Vendidos
    $scope.consultarMasVendidosDulceria = function(idCine) {

        dashboardDulceriaService.consultarVendidos(idCine,$scope.fechaActual,30, true, 10).success(function(data) {
        	 $scope.listaMasVendidos =data;
		}).error(function(data) {
		});
    	
    }
    //INICIO Consulta menos Vendidos
    $scope.consultarMenosVendidosDulceria = function(idCine) {
    	$scope.listaMenosVendidos = null;
    	dashboardDulceriaService.consultarVendidos(idCine,$scope.fechaActual,30, false, 10).success(function(data) {
    		$scope.listaMenosVendidos =data;
		}).error(function(data) {
		});
    }
    
  
    $scope.consultarGraficas = function(idCine) {
     	 $scope.consultarIngresosDulceria (idCine);
    	 $scope.consultarMasRentablesDulceria (idCine);
    	 $scope.consultarMenosRentablesDulceria (idCine);
    	 $scope.consultarMasVendidosDulceria (idCine);
    	 $scope.consultarMenosVendidosDulceria (idCine);
    	 $scope.consultarRentabilidaDulceria (idCine);
    }
    
    $scope.consultaCinesXEmpresa(); 
  


});