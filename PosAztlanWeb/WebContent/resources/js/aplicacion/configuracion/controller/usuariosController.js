'use strict';

angular.module('indexModule').controller("UsuariosController",['$scope','GlobalFactory', 'UsuariosService','ErrorFactory', 
    function($scope,GlobalFactory, UsuariosService,ErrorFactory){	 			
	 var idEmpresa = GlobalFactory.getIdEmpresa(); 
	 
	 
	 $scope.consultaEstatusUsuario = function() {
		 UsuariosService.consultaEstatusUsuario()
		 .then(
	      function(d) {
        	  $scope.listaEstatus = d;
	      },
          function(errResponse){
          });
     }
	 
	$scope.consultaCajasXAlmacen = function(idAlmacen) {
		 UsuariosService.consultaCajasXAlmacen(idAlmacen)
		 .then(
	      function(d) {
        	  $scope.listaCajas = d;
	      },
          function(errResponse){
          });
     }
	 
	 $scope.consultaCanalesXEmpresa = function(idEmpresa) {
		 UsuariosService.consultaCanalesXEmpresa(idEmpresa)
		 .then(
	      function(d) {
        	  $scope.listaCanales = d;
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

	 $scope.consultaAlmacenes = function(idCanal) {
		 UsuariosService.consultaAlmacenesXCanal(idCanal)
		 .then(
           function(d) {
        	 $scope.listaAlmacenes = d;
 	      },
          function(errResponse){
          });
     }
	 
	 $scope.inicializarValores = function(){
		 $scope.listaCajas = null;	
		 $scope.listaEstatus = null;	
		 $scope.listaUsuarios = null;		 	
	 	 $scope.listaPerfiles = null;
	 	 $scope.listaAlmacenes = null;	 	 
	 	 $scope.listaCanales = null;
	     $scope.usuarioVO = {idUsuario:null,correo:'',nombre:'',paterno:'',materno:'',idEstatus:null,estatus:'',idPerfil:null,perfil:'',idAlmacen:null,almacen:'',idCanal:null};
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
	            	$scope.consultaCajasXAlmacen($scope.listaUsuarios[i].idAlmacen); 
	            	$scope.usuarioVO = angular.copy($scope.listaUsuarios[i]);
	            	$scope.correoConfirma=$scope.usuarioVO.correo;	            	
	            	$("#almacen").val($scope.usuarioVO.idAlmacen);
	            	$scope.consultaAlmacenes($scope.usuarioVO.idCanal);
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

	 $scope.cambiarCanal = function(idCanal){
		 $scope.consultaAlmacenes(idCanal);
		 $scope.obtenerUsuarios(idCanal);	
		 
	 }
	 
	 $scope.cambiarAlmacen = function(idAlmacen){
		 $scope.consultaCajasXAlmacen(idAlmacen);
	 }
	 
	 $scope.limpiarFormulario = function(){     	
		 $scope.formUsuarios.$setPristine();
		 $scope.listaCajas = null;		
		 $scope.listaUsuarios = null;		 	
	 	 $scope.listaAlmacenes = null;	 	 
	 	 $scope.listaCanales = null;
	 	 $scope.correoConfirma='';
	     $scope.usuarioVO = {idUsuario:null,correo:'',nombre:'',paterno:'',materno:'',idEstatus:null,estatus:null,idPerfil:null,perfil:'',idAlmacen:null,almacen:'',idCanal:null};
	     $scope.consultaCanalesXEmpresa(idEmpresa);
	 }
	 		
	 $scope.inicializarValores();	
	 $scope.consultaCanalesXEmpresa(idEmpresa);
	 $scope.consultaPerfilesXEmpresa(idEmpresa); 	
	 $scope.consultaEstatusUsuario(); 	

}]);