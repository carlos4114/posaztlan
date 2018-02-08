 

var VentaBoletosPaso1Controller = angular.module('indexModule').controller('ventaBoletos', function($controller,$scope,$filter,taquillaService,statusFactory,calculosFactory,PropertiesFactory,ModalService){

	$scope.mapaAsientos = null;
	$scope.totalBoletos = 0 ;
	$scope.totalAsientos = 0 ;
	$scope.statusVenta			= { elegirPelicula	:"selected", elegirPromocion :"", elegirCantidad	:"", 
						 		   registrarPago	:"", confirmarVenta  :"", numeroPaso:1	}
	$scope.param		= {
			 fechaExhibicion : moment(new Date()).format('DD/MM/YYYY')
	}
	$scope.listaPeliculas		={};
	$scope.boletos			    =[];
	$scope.objetosVenta			={};
	$scope.promocion			={ cantidad:0, tipoCliente:PropertiesFactory.getTipoPromocion('promo'), subtotal:0, precio:0, };
	$controller('VentaBoletosPaso2Controller',{$scope : $scope });
	$controller('VentaBoletosPaso3Controller',{$scope : $scope });
	$controller('VentaBoletosPaso4Controller',{$scope : $scope });
	$controller('VentaBoletosPaso5Controller',{$scope : $scope });
	$controller('VentaBoletosPaso6Controller',{$scope : $scope });
	$controller('modalController',{$scope : $scope });

 	$scope.seleccionarPelicula =function(pelicula,programacion){
 		$scope.listaPagos				= [];
 		$scope.mapaAsientos = null;
 	 	$scope.pago				    	= {subtotalAux:0,subtotal:0, porPagar:0, pagado:0,estatusPagoVO:$scope.estatusPagoVO};
 		$scope.cambioTotal 				= 0.00;
 		$scope.pagoConTotal				= 0.00;
 		$scope.isImpreso				=false;
 		$scope.objetosVenta.promocion	= null;
 		$scope.promocionBoletoVO.promocionVO = null;
 		$scope.promocion					= null;
 		$scope.listaPreciosXFormato 		= {};
 		$scope.statusVenta.numeroPaso		= 2;
		$scope.statusVenta.elegirPelicula	= "done";
    	$scope.statusVenta.elegirPromocion  = "selected";
		$scope.objetosVenta.programacion	= programacion;
		$scope.objetosVenta.pelicula		= pelicula;
		$scope.objetosVenta.fechaExhibicion		= $scope.param.fechaExhibicion;
		$scope.consultarPromociones($scope.param.fechaExhibicion);
		$scope.consultarPreciosFormato();
  		$scope.configParamsCron(programacion,$scope.param.fechaExhibicion);
	}
	
	$scope.seleccionarPromocion =function(promocion){
		var keepGoing = true;
		angular.forEach($scope.listaPromociones, function(value, key){
		  if(keepGoing) {
		    if(value.check == true){
		    	value.check=false;
		    	if (value==promocion){
			    	keepGoing = false;
		    	}
		    }
		  }
		});
		
		if (keepGoing){
			
//			angular.forEach($scope.listaPromociones, function(value, key){
//			value.check = false;
//		});
//		
			promocion.check 						= true;
	 		$scope.objetosVenta.promocion			= promocion;
			$scope.promocionBoletoVO.promocionVO 	= promocion;
			
			$scope.promocion={ cantidad:1, tipoCliente:PropertiesFactory.getTipoPromocion('promo'), subtotal:0, precio:0,promocionVO :promocion, importe:0 };
	        angular.forEach($scope.boletos, function(value, key){
				value.fechaExhibicion =$scope.param.fechaExhibicion ;

	        	if(value.tipoCliente ==  PropertiesFactory.getTipoPromocion('promo') ){
	        		$scope.eliminar( $scope.boletos, key );
	        	}
			});
	        $scope.boletos.push($scope.promocion); 
	        
		}else{
			
	        angular.forEach($scope.boletos, function(value, key){
				value.fechaExhibicion =$scope.param.fechaExhibicion ;

	        	if(value.tipoCliente ==  PropertiesFactory.getTipoPromocion('promo') ){
	        		$scope.eliminar( $scope.boletos, key );
	        	}
			});

	 		$scope.objetosVenta.promocion	= null;
	 		$scope.promocionBoletoVO.promocionVO = null;
	 		$scope.promocion					= null;
	 		
	 		$scope.pago.subtotal =0;
		 		angular.forEach($scope.boletos, function(value, key){
		  			value.subtotal =calculosFactory.calcularSubtotal(value.cantidad,value.precio);
		  			value.importe = calculosFactory.calcularSubtotal(value.cantidad,value.precio);
		  			$scope.pago.subtotal += value.subtotal;
		  		}); 

		}
		
    }
	
	
	$scope.quitarBoleto = function(boleto) { 
		
		$scope.totalBoletos = $scope.totalBoletos -1;
		$scope.asientosDisponibles.reservar =-1;
		$scope.reservarBoleto($scope.asientosDisponibles);
 		boleto.cantidad = boleto.cantidad-1;
 		$scope.pago.subtotal =0;
// 		if($scope.promocion==null){
	 		angular.forEach($scope.boletos, function(value, key){
	  			value.subtotal =calculosFactory.calcularSubtotal(value.cantidad,value.precio);
	  			value.importe = calculosFactory.calcularSubtotal(value.cantidad,value.precio);
	  			$scope.pago.subtotal += value.subtotal;
	  		}); 
// 		}
		angular.forEach($scope.listaPreciosXFormato, function(value, key){
			if(value.tipoClienteVO.nombre ===boleto.tipoCliente) 
				value.boletosSeleccionados =value.boletosSeleccionados-1;
  			value.importe = calculosFactory.calcularSubtotal(value.cantidad,value.precio);

		});
   			$scope.consultarDescuentos ($scope.promocionBoletoVO);
 	}
	
	$scope.modificarButaca = function(asientoVO) {
		var fechaExhibicion = $scope.param.fechaExhibicion;
		
		if(asientoVO.idEstatusAsiento==3){
			if($scope.totalAsientos==$scope.totalBoletos){
				$scope.showAviso("Solamente selccionaste "+$scope.totalBoletos+" asientos.");
				return;
			}else{
				$scope.totalAsientos = $scope.totalAsientos +1;
			}
		}else{
			if(asientoVO.idEstatusAsiento==1){
				$scope.totalAsientos = $scope.totalAsientos - 1;
			}
		}
		
		taquillaService.updateExistenciaAsiento(fechaExhibicion, asientoVO)
		 .then(
		      function(d) {
		    	  if(d.data.errorCode){
		    		  $scope.showAviso(d.data.message);
		  			  return;		        	  
		    	  }else{	 
		    		  $scope.mapaAsientos = d.data.mapaAsientos;
		    	  }		    	  
		      },
		      function(errResponse){	      
		      });
	}	

	
	$scope.consultarMapaConAsistencia = function() {
		 var fechaExhibicion = $scope.param.fechaExhibicion;	
		 var idProgramacion = $scope.objetosVenta.programacion.idProgramacion;
		 		 
		 taquillaService.consultarMapaConAsistencia(idProgramacion,fechaExhibicion)
		 .then(
		      function(d) {
	     	     $scope.mapaAsientos = d;
		      },
		      function(errResponse){
		      });
  } 
	
	$scope.agregarBoleto =function(tipoClienteVO, index){
		
		if($scope.asientosDisponibles.disponibles ==0){
			$scope.showAviso("No hay asientos disponibles ");
			return;
		}
		
		$scope.totalBoletos = $scope.totalBoletos +1;
		$scope.asientosDisponibles.reservar = 1;
		$scope.reservarBoleto($scope.asientosDisponibles);
 		$scope.consultarExistenciaBoletos($scope.paramsExistenciaBoleto);

		$scope.pago.subtotal = 0;

		tipoClienteVO.boletosSeleccionados = tipoClienteVO.boletosSeleccionados +1;
  		angular.forEach($scope.boletos, function(value, key){
  				value.fechaExhibicion =$scope.param.fechaExhibicion ;
  			if(tipoClienteVO.tipoClienteVO.nombre === value.tipoCliente)
  				value.cantidad = value.cantidad + 1;
	  		
	  			value.subtotal = calculosFactory.calcularSubtotal(value.cantidad,value.precio);
	  			value.importe = calculosFactory.calcularSubtotal(value.cantidad,value.precio);
	  		if($scope.promocion == null){
	  			$scope.pago.subtotal += value.subtotal;
  			}
  		}); 
  		
  		$scope.promocionBoletoVO.boletosXTicketVO=$scope.boletos
   			$scope.consultarDescuentos ($scope.promocionBoletoVO);
    }

	$scope.asignarPaso =function( paso){
		$scope.statusVenta = statusFactory.estatusPasoVenta(paso);
		$scope.statusVenta.numeroPaso = paso;
	}
 
	//Consulta de programacion de peliculas
	$scope.consultarPeliculas =function(fechaExhibicion){
  		taquillaService.consultarPeliculas(fechaExhibicion).success(function(data) {	
 			$scope.listaPeliculas = data;
			$scope.errorPeliculas = false;
   		  }).error(function(data) {
 			 $scope.listaPeliculas = {};
 			 $scope.errorPeliculas = true;
 		  });
	}

	$scope.calcularCambio =function(pagoCon,pagoImporte){
		if (pagoImporte > pagoCon){
			$scope.pago.cambio='';
		}
		
		if (pagoCon >= 0 && pagoImporte <= pagoCon)
			$scope.pago.cambio=pagoCon-pagoImporte;
		
	}
	
	$scope.buscarPeliculasXFecha =function(fechaExhibicion){
 		$scope.consultarPeliculas(fechaExhibicion);
	}
	
 
	
	$scope.consultarPeliculas($scope.param.fechaExhibicion);
 });
 