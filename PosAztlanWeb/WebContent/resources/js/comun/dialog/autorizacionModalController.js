angular.module('indexModule').controller('authorizationModalController', function($scope, $element,tipoAutorizacion,athorizationService, close) {
	
	$scope.tipoAutorizacion=tipoAutorizacion;
 	$scope.respuesta=null;
 	
	$scope.authorize = function(athorization){
		
		if ( $scope.form.$invalid) {
            angular.forEach( $scope.form.$error, function (field) {
              angular.forEach(field, function(errorField){
            	  errorField.$setDirty();
              })
            });
         }else{
     		
        	 athorization.idTipoAutorizacion=$scope.tipoAutorizacion;
        	 athorizationService.consultarAutorizacion(athorization).success(function(data) {
        		 $('body').removeClass('modal-open');
        		 $('body').css('padding-right','0');
    			 $('.modal-backdrop').remove();

//        		 $('.modal').modal('hide');
//        		 $('.modalAutorizacion').data('modal', null);
//        		 $('.modal-backdrop').remove();
        		 $scope.respuesta =data;
        		 if($scope.respuesta.idAutorizacion!=null){
        			 close($scope.respuesta,1);
        		 }
      		}).error(function(data) {
  
     		});
          }
	}
	 
	
});