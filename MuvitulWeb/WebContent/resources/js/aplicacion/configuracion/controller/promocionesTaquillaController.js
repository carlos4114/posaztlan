'use strict';

var MenusDulceriaController = angular.module('indexModule').controller("PromocionesTaquillaController", function(PropertiesFactory,$scope,$controller,promocionesTaquillaService,ModalService){
	
	$scope.promociones={};
	$scope.promocion={ activo:true};
	$scope.camposTipoPromocion={  varN:false, varM:false, precio:false, porcentaje:false, regalos:false};
	$scope.listaPromociones={};
    $controller('modalController',{$scope : $scope });
  
    
	$scope.consultaConfigPromociones =function(){
		promocionesTaquillaService.consultarConfigPromociones().success(function(data) {
		 
   			 $scope.listaPromoPara= data.promocionesParaVO;
			 $scope.listaTiposPromo = data.tiposPromocionVO;
			 $scope.listaProductos=data.productosVO;
 			 $scope.listaRegalos =data.regalosVO;
 		}).error(function(data) {
		});
	}
	
	$scope.consultaPromociones=function(){
		$scope.fechaExhibicion = moment(new Date()).format('DD/MM/YYYY');
		promocionesTaquillaService.consultarPromociones($scope.fechaExhibicion).success(function(data) {
 			$scope.listaPromociones=data;
 			$scope.resetValues();
 		}).error(function(data) {
		});
	}
 
	$scope.eliminarPromocion =function( idPromocion){
		promocionesTaquillaService.eliminarPromocion(idPromocion).success(function(data) {
			 $scope.consultaPromociones();
		}).error(function(data) {
		});
	 }
	
	$scope.crearPromocion = function( promocionVO){
		console.log(promocionVO)
		if ( $scope.formPromociones.$invalid) {
            angular.forEach( $scope.formPromociones.$error, function (field) {
              angular.forEach(field, function(errorField){
            	  errorField.$setDirty();
              })
            });
            $scope.showAviso("Es necesario llenar los campos obligatorios ");
         }else{
		promocionesTaquillaService.crearPromocion(promocionVO).success(function(data) {
	            $scope.showAviso("La promoción fue registrada correctamente.");
	   		    $scope.consultaPromociones();
			}).error(function(data) {
			});
         }
	 }
	
	 $scope.init =function(){
		 $scope.consultaConfigPromociones();
		 $scope.consultaPromociones();
	 }
	 
	 $scope.resetValues = function(){
		$scope.formPromociones.$setPristine();
		$scope.promocion={activo:true};
	 }
	 
	 $scope.validarPromocionPara =function(promocion){
		 if(promocion.promocionParaVO.clave ===PropertiesFactory.getPromocionPara('productos')){
			 $scope.comboProductos=true;
		 }else
			 $scope.comboProductos=false;

	}
	 $scope.validarTipoPromocion= function(promocion){
		 if(promocion.tipoPromocionVO.clave ===PropertiesFactory.getTipoPromocion('prx')){
				$scope.camposTipoPromocion={  varN:false, varM:false, precio:false, porcentaje:false, regalos:true };
 		 }
		 
		 if(promocion.tipoPromocionVO.clave ===PropertiesFactory.getTipoPromocion('nxm')){
				$scope.camposTipoPromocion={  varN:true, varM:true, precio:false, porcentaje:false, regalos:false };
		 }
		 
		 if(promocion.tipoPromocionVO.clave ===PropertiesFactory.getTipoPromocion('npf')){
				$scope.camposTipoPromocion={  varN:true, varM:false, precio:true, porcentaje:false, regalos:false };
		 }
		 if(promocion.tipoPromocionVO.clave ===PropertiesFactory.getTipoPromocion('ppc')){
				$scope.camposTipoPromocion={  varN:true, varM:false, precio:false, porcentaje:true, regalos:false };
		 }
	 }

	 $scope.init();
});