'use strict';

var ProgramacionController = angular.module('indexModule').controller("ProgramacionController", function($scope,$controller,ModalService,programacionesTaquillaService){
//	$('#fechaVigencia').daterangepicker({
//	    singleDatePicker: true,
//	    calender_style: "picker_3"
//	  } );

    $controller('modalController',{$scope : $scope });
	$scope.programacion={activo:'true'};
	$scope.listaSalasProgramaciones=[];
	  
	 
	$scope.consultaConfigProgramaciones =function(){
		programacionesTaquillaService.consultarConfigProgramacion().success(function(data) {
   			 $scope.listaDiasSemana= data.dias;
			 $scope.listaFormatos  = data.formatosVO;
			 $scope.listaPeliculas = data.peliculasVO;
			 
			 $scope.listaSalas     = data.salasVO;
			 $scope.listaVersiones = data.versionesVO;
		}).error(function(data) {

		});
	}
	 
	
	$scope.crearProgramacion = function(programacion) {
 
 
		if ( $scope.formProgramaciones.$invalid) {
            angular.forEach( $scope.formProgramaciones.$error, function (field) {
              angular.forEach(field, function(errorField){
            	  errorField.$setDirty();
              })
            });
            $scope.showAviso("Es necesario llenar los campos obligatorios ");
         }else{
         	 programacionesTaquillaService.crearProgramacion(programacion).success(function(data) {
         		 console.log(data);
         		if (data.nuevo==true){
    	            $scope.showAviso("La programación fue registrada correctamente.");
    				$scope.consultarProgramacion();
    				$scope.resetValues ();
         		}else {
    	            $scope.showAviso("La programación colisiona en horario " + data.horario+ " a " +data.horarioFin +" para la sala " +data.salaVO.nombre +" el dia "+ data.diaSemana);
         		}


			}).error(function(data) {
	
			});
         }
	}
	 
	 $scope.consultarProgramacion = function() {
		 $scope.fechaExhibicion = moment(new Date()).format('DD/MM/YYYY');
		 programacionesTaquillaService.consultarProgramaciones($scope.fechaExhibicion).success(function(data) {
			 $scope.listaSalasProgramaciones=data;	 
			}).error(function(data) {

			});
		}

		$scope.eliminarProgramacion = function(idProgramacion) {
			console.log(idProgramacion)
			programacionesTaquillaService.eliminarProgramaciones(idProgramacion).success(function(data) {
				$scope.consultarProgramacion();
			}).error(function(data) {

			});
		}
	 
	 $scope.init =function(){
		 $scope.consultaConfigProgramaciones();
		 $scope.consultarProgramacion();
	 }
	
	 $scope.resetValues = function(){
			$scope.formProgramaciones.$setPristine();
			$scope.programacion={activo:'true'};
		 }
	 
	 
	 $scope.seleccion =function(dato, tipo){
		 if(tipo=='sala') 
			 $scope.programacion.salaVO=dato;
		 if(tipo=='dia') 
			 $scope.programacion.diaSemana=dato;
		 if(tipo=='formato') 
			 $scope.programacion.formatoVO=dato;
		 if(tipo=='version')
			 $scope.programacion.versionVO=dato;
	 }
	 
	 $scope.init();
});


