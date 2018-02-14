<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title> Pos Aztlan | Olvidaste tu contraseña? </title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    	
	<link rel="stylesheet" href="<c:url value='/resources/css/vendors/bootstrap/dist/css/bootstrap.css' />"></link>
</head>
<body ng-app="recuperarContraseniaModule" >
<div class="container">  
  <div class="row" id="pwd-container">
    <div class="col-md-4"></div>
    
    <div class="col-md-4">
      
		<form ng-submit="ctrl.submit()" name="myForm" ng-controller="RecuperarContraseniaController as ctrl">
          <img src="<c:url value='/resources/img/MuvitulT.png' />" class="img-responsive" alt="" >
		  <br/>
              
          <h4 class="text-center">Recupera tu contraseña</h4>

          <br/>

          <input type="email" ng-model="ctrl.email" placeholder="Correo Electrónico" required="required" class="form-control input-lg" value="" />     
          
          <div class="pwstrength_viewport_progress"></div>

          <input type="submit" value="Enviar Contraseña" class="btn btn-lg btn-primary btn-block" ng-disabled="myForm.$invalid">
		  
		  <div class="alert alert-success" role="alert" ng-show="mensajeGeneral.length">	  
		  	<span  class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span>
		    {{mensajeGeneral}}
          </div>    
		  <div class="alert alert-danger" role="alert" ng-show="errorGeneral.length">	  
		  	<span  class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
		    {{errorGeneral}}
          </div>
          
          <br/>
          <div class="text-center">
			 <a class="reset_pass" href="<c:url value='/login.jsp' />"><u>Iniciar Sesión</u></a>
		  </div>	
       	  <br/>
          
         </form>
        
        <div class="text-center">
             <!--  <img src="<c:url value='/resources/img/tecnetia.png' />" height="75px" width="150px" class="center-block" alt="" >-->
             <h6>2017. Grupo Tecnetia SA de CV. <a href="http://tecnetia.com.mx/aviso-de-privacidad/" target="_blank"><u>Aviso de Privacidad.</u></a></h6>
 		</div>
      
      </div>
      
      <div class="col-md-4"></div>
      

  </div>
    
</div>

    <script src="<c:url value='/resources/js/vendors/jquery/dist/jquery.js' />"></script>
    <script src="<c:url value='/resources/js/vendors/bootstrap/dist/js/bootstrap.js' />"></script>
    <script src="<c:url value='/resources/js/vendors/angular/angular.min.js' />"></script>

    <script src="<c:url value='/resources/js/comun/global.js' />"></script>
    <script src="<c:url value='/resources/js/comun/service/globalService.js' />"></script>
    <script src="<c:url value='/resources/js/comun/service/errorService.js' />"></script>

    <script src="<c:url value='/resources/js/aplicacion/configuracion/recuperarContrasenia.js' />"></script>
    <script src="<c:url value='/resources/js/aplicacion/configuracion/service/recuperarContraseniaService.js' />"></script>
    <script src="<c:url value='/resources/js/aplicacion/configuracion/controller/recuperarContraseniaController.js' />"></script>
   
</body>
</html>
