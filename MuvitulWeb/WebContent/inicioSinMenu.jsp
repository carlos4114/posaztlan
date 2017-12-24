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

        <title>Muvitul | Inicio</title>
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


        </head>

        <body class="nav-md" ng-app="indexModule">
            <div class="container body">
                <div class="main_container">
                    <div class="col-md-3 left_col">

                        <!-- AQUÃ VA EL MENÃ DE LA APLICACIÃN -->
                        <div class="left_col scroll-view">
                            <div class="navbar nav_title" style="border: 0;">
                                <a href="inicio.jsp" class="site_title"><i class="fa "></i> <span>MUVITUL</span></a>
                            </div>

                            <div class="clearfix"></div>

                            <!-- menu profile quick info -->
                            <div class="profile">
                                <div class="profile_pic">
                                    <img src="<c:url value='/resources/img/img.jpg' />" alt="..." class="img-circle profile_img">
                                </div>
                                <div class="profile_info">
                                    <span>Bienvenido,</span>
                                    <h2>Aldo Hernández</h2>
                                </div>
                            </div>
                            <!-- /menu profile quick info -->

                            <br />
                            <!-- sidebar menu -->
                            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

                                <div class="menu_section">
                                    <h3>General</h3>
                                    <ul class="nav side-menu">
                                        <li><a href="inicio.jsp"><i class="fa fa-home"></i>
										Inicio </a></li>
                                        <li><a><i class="fa fa-ticket"></i> Taquilla <span
										class="fa fa-chevron-down"></span></a>
                                            <ul class="nav child_menu">
                                                <li><a href="#/ventaBoletos">Venta de Boletos</a></li>
                                                <li><a href="#/devolucion_boleto">Devoluciones</a></li>
                                                <li><a href="#/cancelacion_boleto">Cancelaciones Pagos</a></li>
                                            </ul>
                                        </li>
                                        <li><a><i class="fa fa-cutlery"></i> Dulcería/Cafetería
										<span class="fa fa-chevron-down"></span></a>
                                            <ul class="nav child_menu">
                                                <li><a href="#/ventaProducto">Venta de Producto</a></li>
                                                <li><a href="#/devolucion_producto">Devoluciones</a></li>
                                                <li><a href="#/cancelacion_producto">Cancelaciones Pagos</a></li>
                                            </ul>
                                        </li>
                                    </ul>
                                </div>

                                <div class="menu_section">
                                    <h3>Administración</h3>
                                    <ul class="nav side-menu">
                                        <li><a><i class="fa fa-line-chart"></i>
										Reportes/Estadísticas <span class="fa fa-chevron-down"></span></a>
                                            <ul class="nav child_menu">
                                                <li><a href="#/dashboardDulceria">Dashboard Dulceria</a></li>
                                                <li><a href="#/dashboardTaquilla">Dashboard Taquilla</a></li>
                                                <li><a href="#/reportesExcel">Reportes Excel</a></li>

                                                <li><a href="#">Reporte de COMSCORE</a></li>
                                                <li><a href="#">Reporte de Distribuidoras</a></li>
                                            </ul>
                                        </li>
                                        <li><a><i class="fa fa-barcode"></i> Inventarios <span
										class="fa fa-chevron-down"></span></a>
                                            <ul class="nav child_menu">
                                                <li><a href="#/entradasInventario">Entradas en Inventario</a></li>
                                                <li><a href="#/salidasInventario">Salidas en Inventario</a></li>
                                                <li><a href="#/conteoInventario">Conteo de Inventario</a></li>
                                            </ul>
                                        </li>
                                        <li><a><i class="fa fa-cogs"></i> Configuraciones <span
										class="fa fa-chevron-down"></span></a>
                                            <ul class="nav child_menu">
                                                <li><a href="#/cupoSala">Cupo por Sala</a></li>
                                                <li><a href="#/preciosVenta">Precios de Venta</a></li>
                                                <li><a href="#/peliculas">Películas</a></li>
                                                <li><a href="#/programacion">Programación</a></li>
                                                <li><a href="#/productosDulceria">Productos de
												Dulcería</a></li>
                                                <li><a href="#/menusDulceria">Paquetes de Dulcería</a></li>
                                                <li><a href="#/promocionesTaquilla">Promociones
												Taquilla</a></li>

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
                                    <li class=""><a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false"> <img
									src="<c:url value='/resources/img/img.jpg' />" alt="">Aldo
									Hernández <span class=" fa fa-angle-down"></span>
							</a>
                                        <ul class="dropdown-menu dropdown-usermenu pull-right">
                                            <li><a href="#/cambiarContrasenia"> <span>Cambiar
												Contrase&ntilde;a</span>
									</a></li>
                                            <li><a href="/muvitul-web"><i
											class="fa fa-sign-out pull-right"></i> Cerrar Sesión </a></li>
                                        </ul>
                                    </li>
                                    <!--  
                <li role="presentation" class="dropdown">
                  <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                    <i class="fa fa-envelope-o"></i>
                    <span class="badge bg-green">8</span>
                  </a>
                  <ul id="menu1" class="dropdown-menu list-unstyled msg_list" role="menu">
                    <li>
                      <a>
                        <span class="image"><img src="resources/images/img.jpg" alt="Profile Image" /></span>
                        <span>
                          <span>Aldo H.</span>
                          <span class="time">Hace 3 min.</span>
                        </span>
                        <span class="message">
                          Ojo! EstÃÂ¡s por superar el lÃ­mite de Merma mensual en...
                        </span>
                      </a>
                    </li>
                    <li>
                      <a>
                        <span class="image"><img src="resources/images/img.jpg" alt="Profile Image" /></span>
                        <span>
                          <span>Aldo H.</span>
                          <span class="time">Hace 1 hr.</span>
                        </span>
                        <span class="message">
                          MaÃÂ±ana empieza promociÃÂ³n NIÃâOS GRATIS en la compra de...
                        </span>
                      </a>
                    </li>
                    <li>
                      <a>
                        <span class="image"><img src="resources/images/img.jpg" alt="Profile Image" /></span>
                        <span>
                          <span>Aldo H.</span>
                          <span class="time">Hace 3 dÃÂ­as</span>
                        </span>
                        <span class="message">
                          Ojo! Tu inventario de SALCHICHAS estÃÂ¡ prÃÂ³ximo a terminarse...
                        </span>
                      </a>
                    </li>
                    <li>
                      <div class="text-center">
                        <a>
                          <strong>Ver todos...</strong>
                          <i class="fa fa-angle-right"></i>
                        </a>
                      </div>
                    </li>
                  </ul>
                </li>
                -->
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
                            2017. Grupo Tecnetia SA de CV. <a href="http://tecnetia.com.mx/aviso-de-privacidad/" target="_blank">Aviso
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

            <!---------- LIBRERIAS DEL MODULO DE INDEX PARA LA APLICACION ------------>
            <script src="<c:url value='/resources/js/aplicacion/comun/index.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/comun/controller/indexController.js' />"></script>
            <script src="<c:url value='/resources/js/comun/constantes/constanteConfig.js'/>"></script>

            <script src="<c:url value='/resources/js/comun/directivas/data-util.service.js' />"></script>
            <script src="<c:url value='/resources/js/comun/directivas/fileUploadDirective.js' />"></script>

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

            <!-- Controller del modulo de taquilla - venta boletos -->
            <script src="<c:url value='/resources/js/aplicacion/taquilla/ventaboleto/service/taquillaAngularService.js'/>"></script>
            <script src="<c:url value='/resources/js/aplicacion/taquilla/ventaboleto/controller/ventaBoletosPaso1Controller.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/taquilla/ventaboleto/controller/ventaBoletosPaso2Controller.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/taquilla/ventaboleto/controller/ventaBoletosPaso3Controller.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/taquilla/ventaboleto/controller/ventaBoletosPaso4Controller.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/taquilla/ventaboleto/controller/ventaBoletosPaso5Controller.js' />"></script>

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
            <script src="<c:url value='/resources/js/aplicacion/inventarios/controller/entradasDulceriaController.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/inventarios/controller/salidasDulceriaController.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/inventarios/controller/conteoInventarioController.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/inventarios/service/inventarioAngularService.js' />"></script>

            <!-- Modulos de ConfiguraciÃ³n -->
            <script src="<c:url value='/resources/js/aplicacion/configuracion/controller/cupoSalaController.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/configuracion/controller/menusDulceriaController.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/configuracion/service/menusDulceriaService.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/configuracion/controller/peliculasController.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/configuracion/controller/preciosVentaController.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/configuracion/controller/productosDulceriaController.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/configuracion/controller/programacionController.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/configuracion/service/programacionesTaquillaService.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/configuracion/controller/promocionesTaquillaController.js' />"></script>
            <script src="<c:url value='/resources/js/aplicacion/configuracion/service/promocionesTaquillaService.js' />"></script>

            <!-- Controller del modulo de cambio de contraseÃ±a -->
            <script src="<c:url value='/resources/js/aplicacion/configuracion/controller/cambiarContraseniaController.js' />"></script>

            <!-- Controller para modales -->
            <script src="<c:url value='/resources/js/comun/dialog/mensajeModalController.js'/>"></script>
            <script src="<c:url value='/resources/js/comun/dialog/modalController.js'/>"></script>
            <script src="<c:url value='/resources/js/comun/dialog/modalControllerPrintTicket.js'/>"></script>
            
        </body>

        </html>