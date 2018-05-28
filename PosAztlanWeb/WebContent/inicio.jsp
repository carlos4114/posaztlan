<%@ page contentType="text/html; charset=UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="utf-8">
        </head>
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Pos Aztlan | Inicio</title>
        <script type="text/javascript" src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>

        <!-- Bootstrap -->
        <link href="<c:url value='/resources/css/vendors/bootstrap/dist/css/bootstrap.min.css' />" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="<c:url value='/resources/css/vendors/font-awesome/css/font-awesome.min.css' />" rel="stylesheet">
        <!-- NProgress -->
        <link href="<c:url value='/resources/css/vendors/nprogress/nprogress.css' />" rel="stylesheet">
        <!-- iCheck -->
        <link href="<c:url value='/resources/js/vendors/iCheck/skins/flat/_all.css' />" rel="stylesheet">
        <link href="<c:url value='/resources/js/vendors/switchery/dist/switchery.min.css' />" rel="stylesheet">

        <!-- Custom Theme Style -->
        <link href="<c:url value='/resources/css/build/custom.min.css' />" rel="stylesheet">
        <!-- global project Style -->
        <link href="<c:url value='/resources/css/global.css' />" rel="stylesheet" charset='utf-8'>
        <!-- fileupload -->
        <link href="<c:url value='/resources/css/vendors/bootstrap/dist/css/fileinput.css' />" rel="stylesheet">
        <!-- Select2 -->
        <link href="<c:url value='/resources/css/vendors/select2/dist/css/select2.min.css' />" rel="stylesheet">
        <!-- bootstrap datepicker -->
        <link href="<c:url value='/resources/js/vendors/datepicker/datepicker3.css' />" rel="stylesheet">
        <!-- Bootstrap time Picker -->
        <link href="<c:url value='/resources/js/vendors/timepicker/bootstrap-timepicker.min.css' />" rel="stylesheet">
        <!-- Block UI -->
        <link href="<c:url value='/resources/js/vendors/blockUI/angular-block-ui.min.css' />" rel="stylesheet">
        <!-- Block UI -->
        <link href="<c:url value='/resources/css/modals/modals.css' />" rel="stylesheet">
        <!-- Print Js -->
        <link href="<c:url value='/resources/js/vendors/printJs/print.min.css' />" rel="stylesheet">
		<!-- Menu Styles -->
	    <link href="<c:url value='/resources/css/build/menu.css' />" rel="stylesheet">

        </head>
        
        <body class="nav-md" ng-app="indexModule" >
            <div ng-controller="IndexController" class="container body">
                <div class="main_container">
                    <div class="col-md-3 left_col">

                        <!-- AQUI VA EL MENU DE LA APLICACION -->
                        <div class="left_col scroll-view">
				            <div class="navbar nav_title" align="center" style="border: 0; background-color: white;"  class="text-center">
				              <a href="inicio.jsp" class="site_title">
				                <img  
				                     ng-src="data:image/png;base64,{{logoEmpresa}}"
				                     height="50px" width="100px" class="img-responsive" alt="" 
				                 />
				               </a>
				            </div>

                            <div class="clearfix"></div>

                            <!-- menu profile quick info -->
                            <div class="profile">
                                <div class="profile_pic">
                                    <img src="<c:url value='/resources/img/default_pic.png' />" alt="..." class="img-circle profile_img">
                                </div>
                                <div class="profile_info">
                                    <span>Bienvenid@,</span>
                                    <h2>{{nombreUsuario}}</h2>
                                </div>
                            </div>
                            <!-- /menu profile quick info -->

                            <br />
                            <!-- sidebar menu -->
                            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

								<div class="menu_section">
					                <h3>General</h3>
					                <ul class="nav side-menu">
					                  <li><a href="inicio.jsp"><i class="fa fa-home"></i> Inicio </a></li>                                   
					                </ul>
					              </div>
					              <div class="menu_section" ng-repeat="seccion in menu" >
								   	  <h3>{{seccion.nombre}}</h3>		             
						              <ul class="nav side-menu">
							              <li ng-repeat="submenu in seccion.submenus" ng-click="showChilds(submenu)">
							                <a><i class="{{submenu.icono}}"></i> {{submenu.nombre}} <span class="fa fa-chevron-down"></span></a>
								            <ul class="opcion_menu" ng-repeat="opcion in submenu.submenus"  ng-show="submenu.active" >
								                <a href="{{opcion.liga}}"><li style="color:white">{{opcion.nombre}}</li></a>
								            </ul>
							              </li> 		        
						              </ul>              	
						          </div>
                                
                            </div>
                            <!-- /sidebar menu -->

                        </div>

                    </div>

                    <!-- top navigation -->

                    <div class="top_nav">
                        <!-- AQUÃ VA EL HEADER DE LA APLICACION -->
                        <div class="nav_menu">
                            <nav>
                                <div class="nav toggle">
                                    <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                                </div>

                                <ul class="nav navbar-nav navbar-right">
                                    <li class="">
                                      <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false"> 
                                        <img src="<c:url value='/resources/img/default_pic.png' />" alt="">{{nombreUsuario}}<span class=" fa fa-angle-down"></span>
									  </a>
                                        <ul class="dropdown-menu dropdown-usermenu pull-right">
                                            <li><a href="#/cambiarContrasenia"> <span>Cambiar
												Contrase&ntilde;a</span>
									</a></li>
                                            <li><a href="login.jsp"><i
											class="fa fa-sign-out pull-right"></i> Cerrar Sesión </a></li>
                                        </ul>
                                    </li>
 
                                </ul>
                            </nav>
                        </div>

                    </div>
                    <!-- /top navigation -->

                    <!-- page content -->
                    <div class="right_col" role="main">
                        <!-- AQUÃ VA LA PÃGINA QUE QUEREMOS SE INSERTE EN EL BODY - FRAME PRINCIPAL DEL SISTEMA -->
                        <div ng-view></div>
                    </div>
                    <!-- /page content -->

                    <!-- footer content -->
                    <footer>
                        <!-- AQUÃ VA EL FOOTER DE LA APLICACIÃN -->
                        <div class="pull-right">
                            2018. DRH SA de CV. <a href="http://tecnetia.com.mx/aviso-de-privacidad/" target="_blank">Aviso
						de Privacidad.</a>
                        </div>
                        <div class="clearfix"></div>

                    </footer>
                    <!-- /footer content -->
                </div>
            </div>

            <!-- jQuery -->
            <script src="<c:url value='/resources/js/vendors/jquery/dist/jquery.min.js' />"></script>
            <!-- Bootstrap -->
            <script src="<c:url value='/resources/js/vendors/bootstrap/dist/js/bootstrap.min.js' />"></script>
            <!-- FastClick -->
            <script src="<c:url value='/resources/js/vendors/fastclick/lib/fastclick.js' />"></script>
            <!-- NProgress -->
            <script src="<c:url value='/resources/js/vendors/nprogress/nprogress.js' />"></script>
            <!-- Angular -->
            <script src="<c:url value='/resources/js/vendors/angular/angular.min.js' />"></script>
            <!-- Angular Route -->
            <script src="<c:url value='/resources/js/vendors/angular/angular-route.js' />"></script>
            <!-- Block UI -->
            <script src="<c:url value='/resources/js/vendors/blockUI/angular-block-ui.min.js' />"></script>
            <!-- Calendar and Date -->
            <script src="<c:url value='/resources/js/moment/moment.min.js' />"></script>
            <script src="<c:url value='/resources/js/comun/config/angular-locale_es-mx.js'/>"></script>
            <script src="<c:url value='/resources/js/datepicker/datetime-inputs.min.js' />"></script>
            <script src="<c:url value='/resources/js/datepicker/daterangepicker.js' />"></script>
            <script src="<c:url value='/resources/js/vendors/bootstrap/moment-with-locales.js' />"></script>
            <script src="<c:url value='/resources/js/vendors/bootstrap/bootstrap-datetimepicker.js' />"></script>
            <!-- Bootstrap Datepicker -->
            <script src="<c:url value='/resources/js/vendors/datepicker/bootstrap-datepicker.js' />"></script>
            <!-- Bootstrap Timepicker -->
            <script src="<c:url value='/resources/js/vendors/timepicker/bootstrap-timepicker.min.js' />"></script>
            <!-- Manejo de carga de archivos -->
            <script src="<c:url value='/resources/js/vendors/bootstrap/fileinput.js' />"></script>
            <script src="<c:url value='/resources/js/vendors/bootstrap/locales/es.js' />"></script>

            <!-- Underscore.js -->
            <script src="<c:url value='/resources/js/vendors/underscore/underscore.js'/>"></script>
            <!-- Lib Modales -->
            <script src="<c:url value='/resources/js/vendors/angular/angular-modal-service.js' />"></script>
            <script src="<c:url value='/resources/js/comun/lib/ng-decimal.js' />"></script>
            <script src="<c:url value='/resources/js/comun/lib/numeric-directive.js' />"></script>

            <script src="<c:url value='/resources/js/comun/lib/angular-base64-upload.js' />"></script>
            <script src="<c:url value='/resources/js/comun/lib/ng-file-upload.min.js' />"></script>
            <script src="<c:url value='/resources/js/comun/lib/ui-bootstrap-tpls.min.js' />"></script>

            <!-- Select2 -->
            <script src="<c:url value='/resources/js/vendors/select2/dist/js/select2.full.min.js'/>"></script>
            <!--     Print JS -->
            <script src="<c:url value='/resources/js/vendors/printJs/print.min.js'/>"></script>
            <!--     Chart JS -->
            <script src="<c:url value='/resources/js/vendors/Chart.js/dist/Chart.min.js'/>"></script>

            <!-- iCheck -->
            <script src="<c:url value='/resources/js/vendors/iCheck/icheck.min.js'/>"></script>
            <script src="<c:url value='/resources/js/vendors/switchery/dist/switchery.min.js'/>"></script>

            <!-- Custom Theme Scripts -->
            <script src="<c:url value='/resources/js/build/custom.min.js' />"></script>
            <script src="<c:url value='/resources/js/comun/global.js' />"></script>
            <script src="<c:url value='/resources/js/comun/service/globalService.js' />"></script>            
            <script src="<c:url value='/resources/js/comun/service/errorService.js' />"></script>
            

            <!---------- LIBRERIAS DEL MODULO DE INDEX PARA LA APLICACION ------------>
            <script src="<c:url value='/resources/js/aplicacion/comun/index.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/comun/service/indexService.js' />"></script>             
            <script src="<c:url value='/resources/js/aplicacion/comun/controller/indexController.js' />"></script>            
            
            <script src="<c:url value='/resources/js/comun/constantes/constanteConfig.js'/>"></script>

            <script src="<c:url value='/resources/js/comun/directivas/data-util.service.js' />"></script>
            <script src="<c:url value='/resources/js/comun/directivas/fileUploadDirective.js' />"></script>

            <!-- Select 2 -->
            <script src="<c:url value='/resources/js/comun/directivas/directivaSelect2.js' />"></script>

            <!-- Autorizacion -->
            <script src="<c:url value='/resources/js/comun/dialog/service/autorizacionService.js' />"></script>
            <script src="<c:url value='/resources/js/comun/dialog/autorizacionModalController.js' />"></script>

            <!-- 	Filters -->
            <script src="<c:url value='/resources/js/comun/filters/groupByFilter.js'/>"></script>

            <!-- Inteceptors -->
            <script src="<c:url value='/resources/js/comun/interceptors/requestInterceptor.js'/>"></script>
            <script src="<c:url value='/resources/js/comun/interceptors/interceptorsConfig.js'/>"></script>

            <!-- 	Factorys -->
            <script src="<c:url value='/resources/js/comun/factory/calculaTotalesFactory.js'/>"></script>
            <script src="<c:url value='/resources/js/comun/factory/determinaStatusFactory.js'/>"></script>

            <script src="<c:url value='/resources/js/comun/factory/propiedadesService.js' />"></script>

            <!-- 	Directivas -->
            <script src="<c:url value='/resources/js/comun/directivas/calendar.js' />"></script>
            <script src="<c:url value='/resources/js/comun/directivas/integerNumberDirective.js' />"></script>
            <script src="<c:url value='/resources/js/comun/directivas/pagination.js' />"></script>
            <script src="<c:url value='/resources/js/comun/directivas/directivasVentaBoleto.js' />"></script>
            <script src="<c:url value='/resources/js/comun/directivas/directivasVentaProducto.js' />"></script>
            <script src="<c:url value='/resources/js/comun/directivas/directivasCancelacionDevolucionBoleto.js' />"></script>
            <script src="<c:url value='/resources/js/comun/directivas/directivasCancelacionDevolucionProducto.js' />"></script>

            <!-- Controller del modulo de taquilla - venta -->

            <script src="<c:url value='/resources/js/aplicacion/venta/controller/ventaManualController.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/venta/service/ventaManualService.js' />"></script>
            
            <!-- <script src="<c:url value='/resources/js/aplicacion/taquilla/ventaboleto/service/taquillaAngularService.js'/>"></script>
            <script src="<c:url value='/resources/js/aplicacion/taquilla/ventaboleto/controller/ventaBoletosPaso1Controller.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/taquilla/ventaboleto/controller/ventaBoletosPaso2Controller.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/taquilla/ventaboleto/controller/ventaBoletosPaso3Controller.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/taquilla/ventaboleto/controller/ventaBoletosPaso4Controller.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/taquilla/ventaboleto/controller/ventaBoletosPaso5Controller.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/taquilla/ventaboleto/controller/ventaBoletosPaso6Controller.js' />"></script>
 -->
            <!-- Controller del modulo de taquilla - devolucion boletos -->

            <script src="<c:url value='/resources/js/aplicacion/taquilla/devolucion/controller/devolucionPaso1Controller.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/taquilla/devolucion/controller/devolucionPaso2Controller.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/taquilla/devolucion/controller/devolucionPaso3Controller.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/taquilla/devolucion/service/devolucionService.js'/>"></script>
            <!-- Controller del modulo de taquilla - cancelacion boletos -->

            <script src="<c:url value='/resources/js/aplicacion/taquilla/cancelacion/controller/cancelacionPaso1Controller.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/taquilla/cancelacion/controller/cancelacionPaso2Controller.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/taquilla/cancelacion/controller/cancelacionPaso3Controller.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/taquilla/cancelacion/service/cancelacionService.js'/>"></script>


            <!-- Controller del modulo de dulceria -->
            <script src="<c:url value='/resources/js/aplicacion/dulceria/ventaproducto/service/dulceriaAngularService.js'/>"></script>
            <script src="<c:url value='/resources/js/aplicacion/dulceria/ventaproducto/controller/ventaProductoPaso1Controller.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/dulceria/ventaproducto/controller/ventaProductoPaso2Controller.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/dulceria/ventaproducto/controller/ventaProductoPaso3Controller.js' />"></script>


            <script src="<c:url value='/resources/js/aplicacion/dulceria/devolucion/controller/devolucionController.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/dulceria/devolucion/controller/devolucionPaso2Controller.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/dulceria/devolucion/controller/devolucionPaso3Controller.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/dulceria/devolucion/service/devolucionService.js'/>"></script>

            <script src="<c:url value='/resources/js/aplicacion/dulceria/cancelacion/controller/cancelacionPaso1Controller.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/dulceria/cancelacion/controller/cancelacionPaso2Controller.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/dulceria/cancelacion/controller/cancelacionPaso3Controller.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/dulceria/cancelacion/service/cancelacionService.js'/>"></script>


            <!-- Modulos Dashboard -->
            <script src="<c:url value='/resources/js/aplicacion/dashboard/dulceria/controller/dashboardDulceriaController.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/dashboard/dulceria/service/dashboardDulceriaService.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/dashboard/taquilla/controller/dashboardTaquillaController.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/dashboard/taquilla/service/dashboardTaquillaService.js' />"></script>

			<!-- ReportesExcel -->
			 <script src="<c:url value='/resources/js/aplicacion/reportes/controller/reportesController.js' />"></script>
			 <script src="<c:url value='/resources/js/aplicacion/reportes/service/reportesService.js' />"></script>




            <!-- Modulos de Inventarios -->
            <script src="<c:url value='/resources/js/aplicacion/inventarios/controller/entradasController.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/inventarios/controller/salidasDulceriaController.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/inventarios/controller/conteoInventarioController.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/inventarios/service/conteoInventarioService.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/inventarios/service/inventarioAngularService.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/inventarios/controller/salidasController.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/inventarios/service/salidasService.js' />"></script>
			<script src="<c:url value='/resources/js/aplicacion/inventarios/controller/traspasoController.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/inventarios/service/traspasoService.js' />"></script>
            <!-- Modulos de ConfiguraciÃ³n -->
            <script src="<c:url value='/resources/js/aplicacion/configuracion/controller/menusDulceriaController.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/configuracion/service/menusDulceriaService.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/configuracion/controller/peliculasController.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/configuracion/controller/preciosVentaController.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/configuracion/controller/programacionController.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/configuracion/service/programacionesTaquillaService.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/configuracion/controller/promocionesTaquillaController.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/configuracion/service/promocionesTaquillaService.js' />"></script>

            <!-- Controller del modulo de cambio de contraseÃ±a -->
			<script src="<c:url value='/resources/js/aplicacion/configuracion/service/cambiarContraseniaService.js' />"></script> 
            <script src="<c:url value='/resources/js/aplicacion/configuracion/controller/cambiarContraseniaController.js' />"></script>

            <!-- Controller del modulo de usuarios -->
			<script src="<c:url value='/resources/js/aplicacion/configuracion/service/usuariosService.js' />"></script> 
            <script src="<c:url value='/resources/js/aplicacion/configuracion/controller/usuariosController.js' />"></script>
			
			<!-- Controller del modulo de corte de caja -->
			<script src="<c:url value='/resources/js/aplicacion/administracion/service/corteCajaService.js' />"></script> 
            <script src="<c:url value='/resources/js/aplicacion/administracion/controller/corteCajaController.js' />"></script>

			<!-- Controller del modulo de salas -->
			<script src="<c:url value='/resources/js/aplicacion/configuracion/service/salasService.js' />"></script> 
            <script src="<c:url value='/resources/js/aplicacion/configuracion/controller/salasController.js' />"></script>

            <!-- Controller para modales -->
            <script src="<c:url value='/resources/js/comun/dialog/mensajeModalController.js'/>"></script>
            <script src="<c:url value='/resources/js/comun/dialog/modalController.js'/>"></script>
            <script src="<c:url value='/resources/js/comun/dialog/modalControllerPrintTicket.js'/>"></script>
            
            <!-- Controller del modulo Catalogo de articulos -->
			<script src="<c:url value='/resources/js/aplicacion/configuracion/service/articulosService.js' />"></script> 
            <script src="<c:url value='/resources/js/aplicacion/configuracion/controller/articulosController.js' />"></script>
            
            <!-- Controller del modulo catalogo de paquetes -->
			<script src="<c:url value='/resources/js/aplicacion/configuracion/service/paquetesService.js' />"></script> 
            <script src="<c:url value='/resources/js/aplicacion/configuracion/controller/paquetesController.js' />"></script>
            
            <!-- Controller del modulo catalogo de productos -->
            <script src="<c:url value='/resources/js/aplicacion/configuracion/service/productosService.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/configuracion/controller/productosController.js' />"></script>
            
            <!-- Controller del modulo ordenes de compra -->
            <script src="<c:url value='/resources/js/aplicacion/administracion/service/ordenesCompraService.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/administracion/controller/ordenesCompraController.js' />"></script>
            
            <!-- Controller del modulo entrada por orden de compra -->
            <script src="<c:url value='/resources/js/aplicacion/inventarios/service/entradaOrdenCompraService.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/inventarios/controller/entradaOrdenCompraController.js' />"></script>
        </body>

        </html>