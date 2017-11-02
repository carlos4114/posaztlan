  angular.module('indexModule').controller("dashboardTaquillaController", function($scope, $controller, $filter, statusFactory, dashboardTaquillaService) {

      $scope.fechaActual = moment(new Date()).format('DD/MM/YYYY');
  	  $scope.cine = null;

      //GRAFICA INGRESOS DE TAAQUILLA
      graficaIngresoTaquilla = function(data) {

          var ctxIngresoTaquilla = document.getElementById("ingresoTaquilla");
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
      //GRAFICA INGRESOS DE PELICULA
      graficaIngresosPelicula = function(data) {
          var ctxIngresosPelicula = document.getElementById("ingresosPelicula");
          var ingresosPelicula = new Chart(ctxIngresosPelicula, {
              type: 'bar',
              data: {
                  labels: data.peliculas,
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
      graficaAsistenciaPromedio = function(data) {
          var ctxAsistenciaPromedio = document.getElementById("asistenciaPromedio");
          var ctxAsistenciaPromedio = new Chart(ctxAsistenciaPromedio, {
              type: 'bar',
              data: {
                  labels: data.dias,
                  datasets: [{
                      label: 'Últimas 4 Semanas ',
                      backgroundColor: "#26B99A",
                      data: data.totales
                  }]
              },
              options: {
                  responsive: true,
                  title: {
                      display: true,
                      text: ""
                  },
                  scales: {
                      yAxes: [{
                          ticks: {
                              beginAtZero: true
                          },
                          scaleLabel: {
                              display: true,
                              labelString: 'Visitantes'
                          }
                      }]
                  }
              }

          });
      }

      //INICIO CONFIGURACION Ingresos semanales Taquilla
      $scope.consultarIngresosTaquilla = function(idCine) {
          dashboardTaquillaService.consultarIngresosXTaquilla(idCine, $scope.fechaActual, 4, 'TAQ-002').success(function(data) {
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
          graficaIngresoTaquilla(data);

      }


      //INICIO CONFIGURACION Ingresos por Pelicula

      $scope.consultarIngresosXPelicula = function(idCine) {
          dashboardTaquillaService.consultarIngresosXPelicula(idCine).success(function(data) {
              configuracionGraficaIngresoPelicula(data);
          }).error(function(data) {});
      }
      configuracionGraficaIngresoPelicula = function(data) {

          var datasets = [{
              label: data.ingresosPeliculaVO[1].descripcion,
              backgroundColor: "#26B99A",
              data: data.ingresosPeliculaVO[1].totales
          }, {
              label: data.ingresosPeliculaVO[0].descripcion,
              backgroundColor: "#03586A",
              data: data.ingresosPeliculaVO[0].totales
          }];

          data.datasets = datasets;
          graficaIngresosPelicula(data);
      }


      //INICIO CONFIGURACION Asistencia promedio
      $scope.consultarAsistenciaPromedio = function(idCine) {
    	  dashboardTaquillaService.consultarAsistenciaPromedio(idCine, $scope.fechaActual, 4).success(function(data) {
    		  graficaAsistenciaPromedio(data)
    		  }).error(function(data) {
        	  
          });
          
      }

       $scope.consultaCinesXEmpresa = function() {
          dashboardTaquillaService.consultarCinesEmpresa().success(function(data) {
        	  $scope.listaCines=data;
        	  
           }).error(function(data) {});
      }
       
       $scope.consultarGraficas = function(idCine) {
    	   $scope.consultarAsistenciaPromedio(idCine);
           $scope.consultarIngresosXPelicula(idCine);
           $scope.consultarIngresosTaquilla(idCine);
           
       }
       
       $scope.consultaCinesXEmpresa();
     
   });