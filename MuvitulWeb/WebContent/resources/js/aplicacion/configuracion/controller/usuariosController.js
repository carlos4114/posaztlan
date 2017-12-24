'use strict';

angular.module('indexModule').controller("UsuariosController",['$scope','GlobalFactory', 'UsuariosService','ErrorFactory', 
    function($scope,GlobalFactory, UsuariosService,ErrorFactory){	 			
	 var idEmpresa = GlobalFactory.getIdEmpresa(); 
	
	 $scope.consultaCinesXEmpresa = function(idEmpresa) {
		 UsuariosService.consultaCinesXEmpresa(idEmpresa)
		 .then(
	      function(d) {
        	  $scope.listaCines = d;
	      },
          function(errResponse){
          });
     }
	 
	 $scope.consultaPerfilesXEmpresa = function(idEmpresa) {
		 UsuariosService.consultaPerfilesXEmpresa(idEmpresa)
		 .then(
           function(d) {
        	 $scope.listaPerfiles = d;
 	      },
          function(errResponse){
          });
     }

	 $scope.consultaPuntosVentaXCine = function(idCine) {
		 UsuariosService.consultaPuntosVentaXCine(idCine)
		 .then(
           function(d) {
        	 $scope.listaPuntosVenta = d;
 	      },
          function(errResponse){
          });
     }
	 
	 $scope.inicializarValores = function(){
		 $scope.listaUsuarios = null;		 	
	 	 $scope.listaPerfiles = null;
	 	 $scope.listaPuntosVenta = null;	 	 
	 	 $scope.listaCines = null;
	     $scope.usuarioVO = {idUsuario:null,correo:'',nombre:'',paterno:'',materno:'',idEstatus:null,estatus:'',idPerfil:null,perfil:'',idPuntoVenta:null,puntoVenta:'',idCine:null};
	 	 $scope.correoConfirma='';
	     $scope.errorGeneral='';
		 $scope.mensajeGeneral='';
	 }	 
	 
	 $scope.obtenerUsuarios = function(idCine) {
		 UsuariosService.obtenerUsuarios(idCine)
		 .then(
	      function(d) {
        	  $scope.listaUsuarios = d;
	      },
          function(errResponse){
          });
     }
	 
	 $scope.guardarUsuario = function(usuarioVO) {
		 
		 if($scope.usuarioVO.correo != $scope.correoConfirma){
	            $scope.errorGeneral = "El correo y la confirmaci\u00F3n no coinciden.";
	            return false;
		 }
		 
		 $scope.errorGeneral='';
		 $scope.mensajeGeneral='';
		 UsuariosService.guardarUsuarioNuevo(usuarioVO)
		 .then(
	      function(d) {
	    	  if(d.errorCode){
	        	  $scope.errorGeneral = d.message;
	    	  }else{	 
		 		  $scope.mensajeGeneral = 'Se ha guardado el usuario.';
		 		  $scope.limpiarFormulario();
	    	  }
	      },
          function(errResponse){
   		   		$scope.errorGeneral = "No se pudo guardar el usuario. "+ErrorFactory.getErrorMessage(errResponse.status);
          });
     }
	 
	 $scope.actualizarUsuario = function(usuarioVO) {
		 
		 if($scope.usuarioVO.correo != $scope.correoConfirma){
	            $scope.errorGeneral = "El correo y la confirmaci\u00F3n no coinciden.";
	            return false;
		 }
		 
		 $scope.errorGeneral='';
		 $scope.mensajeGeneral='';
		 UsuariosService.actualizarUsuario(usuarioVO)
		 .then(
	      function(d) {
	    	  if(d.errorCode){
	        	  $scope.errorGeneral = d.message;
	    	  }else{	 
		 		  $scope.mensajeGeneral = 'Se ha actualizado el usuario.';
		 		  $scope.limpiarFormulario();
	    	  }
	      },
          function(errResponse){
   		   		$scope.errorGeneral = "No se pudo actualizar el usuario. "+ErrorFactory.getErrorMessage(errResponse.status);
          });
     }
	 
	 $scope.editarUsuario = function(idUsuario) {
			$scope.errorGeneral='';
			$scope.mensajeGeneral='';
	        
			for(var i = 0; i < $scope.listaUsuarios.length; i++){
	            if($scope.listaUsuarios[i].idUsuario === idUsuario) {
	            	$scope.usuarioVO = angular.copy($scope.listaUsuarios[i]);
	            	$scope.correoConfirma=$scope.usuarioVO.correo;	            	
	            	$("#puntoVenta").val($scope.usuarioVO.idPuntoVenta);
	            	$scope.consultaPuntosVentaXCine($scope.usuarioVO.idCine);
	                break;
	            }
	        }	        
	   }
	 
	 $scope.submit = function(){
	    	if($scope.usuarioVO.idUsuario === null){
	            $scope.guardarUsuario($scope.usuarioVO);
	        }else{
	        	$scope.actualizarUsuario($scope.usuarioVO);        	
	        }
	 }

	 $scope.cambiarCine = function(idCine){
		 $scope.consultaPuntosVentaXCine(idCine);
		 $scope.obtenerUsuarios(idCine);		 
	 }
	 
	 $scope.limpiarFormulario = function(){     	
		 $scope.fromUsuarios.$setPristine();
	     $scope.usuarioVO = {idUsuario:null,correo:'',nombre:'',paterno:'',materno:'',idEstatus:null,estatus:'',idPerfil:null,perfil:'',idPuntoVenta:null,puntoVenta:'',idCine:null};
	     $scope.listaUsuarios=null;
	     $scope.listaPuntosVenta=null;
	     $scope.correoConfirma='';
	     $scope.listaCines=null;
	     $scope.consultaCinesXEmpresa(idEmpresa);
	 }
	 		
	 $scope.inicializarValores();	
	 $scope.consultaCinesXEmpresa(idEmpresa);
	 $scope.consultaPerfilesXEmpresa(idEmpresa); 	

}]);