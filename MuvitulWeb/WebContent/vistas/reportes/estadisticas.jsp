<!DOCTYPE html>
<html lang="en">

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title> CINE POS | Estadísticas </title>

    <!-- Bootstrap -->
    <link href="css/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="css/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="css/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- bootstrap-progressbar -->
    <link href="css/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="css/build/custom.min.css" rel="stylesheet">
  </head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="index.html" class="site_title"><i class="fa "></i> <span>Cine POS</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile">
              <div class="profile_pic">
                <img src="images/img.jpg" alt="..." class="img-circle profile_img">
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
                  <li><a href="index.html"><i class="fa fa-home"></i> Inicio </a></li>
                  <li><a><i class="fa fa-ticket"></i> Taquilla <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="venta_boletos.html">Venta de Boletos</a></li>
                      <li><a href="#promociones">Promociones</a></li>
                      <li><a href="#cancelacionesaut">Cancelaciones/Autorizaciones</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-cutlery"></i> Dulcería/Cafetería <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="venta_producto.html">Venta de Producto</a></li>
                      <li><a href="#promociones">Promociones</a></li>
                      <li><a href="#cancelacionesaut">Cancelaciones/Autorizaciones</a></li>
                      <li><a href="#merma">Merma</a></li>
                    </ul>
                  </li>
                </ul>
              </div>

              <div class="menu_section">
                <h3>Administración</h3>
                <ul class="nav side-menu">
                  <li><a href="estadisticas.html"><i class="fa fa-line-chart"></i> Estadísticas </a></li>
                </ul>
              </div>

            </div>
            <!-- /sidebar menu -->

            <!-- /menu footer buttons -->
            <div class="sidebar-footer hidden-small">
              <a data-toggle="tooltip" href="#ajustes" data-placement="top" title="Ajustes">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" href="login.html" data-placement="top" title="Cerrar Sesión">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
              </a>
            </div>
            <!-- /menu footer buttons -->
          </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
          <div class="nav_menu">
            <nav>
              <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
              </div>

              <ul class="nav navbar-nav navbar-right">
                <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    <img src="images/img.jpg" alt="">Aldo Hernández
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">
                    <li>
                      <a href="javascript:;">
                        <span class="badge bg-red pull-right">50%</span>
                        <span>Ajustes</span>
                      </a>
                    </li>
                    <li><a href="javascript:;">Ayuda</a></li>
                    <li><a href="login.html"><i class="fa fa-sign-out pull-right"></i> Cerrar Sesión </a></li>
                  </ul>
                </li>

                <li role="presentation" class="dropdown">
                  <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                    <i class="fa fa-envelope-o"></i>
                    <span class="badge bg-green">8</span>
                  </a>
                  <ul id="menu1" class="dropdown-menu list-unstyled msg_list" role="menu">
                    <li>
                      <a>
                        <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
                        <span>
                          <span>Aldo H.</span>
                          <span class="time">Hace 3 min.</span>
                        </span>
                        <span class="message">
                          Ojo! Estás por superar el límite de Merma mensual en...
                        </span>
                      </a>
                    </li>
                    <li>
                      <a>
                        <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
                        <span>
                          <span>Aldo H.</span>
                          <span class="time">Hace 1 hr.</span>
                        </span>
                        <span class="message">
                          Mañana empieza promoción NIÑOS GRATIS en la compra de...
                        </span>
                      </a>
                    </li>
                    <li>
                      <a>
                        <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
                        <span>
                          <span>Aldo H.</span>
                          <span class="time">Hace 3 días</span>
                        </span>
                        <span class="message">
                          Ojo! Tu inventario de SALCHICHAS está próximo a terminarse...
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
              </ul>
            </nav>
          </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="row top_tiles" style="margin: 10px 0;">
              <div class="col-md-3 col-sm-3 col-xs-6 tile">
                <span>Boletos Vendidos</span>
                <h2>45,492</h2>
                <span class="sparkline_one" style="height: 160px;">
                      <canvas width="200" height="60" style="display: inline-block; vertical-align: top; width: 94px; height: 30px;"></canvas>
                  </span>
              </div>
              <div class="col-md-3 col-sm-3 col-xs-6 tile">
                <span>Ventas - Boletos</span>
                <h2>$ 2,274,600 </h2>
                <span class="sparkline_one" style="height: 160px;">
                      <canvas width="200" height="60" style="display: inline-block; vertical-align: top; width: 94px; height: 30px;"></canvas>
                  </span>
              </div>
              <div class="col-md-3 col-sm-3 col-xs-6 tile">
                <span>Ventas - Dulcería</span>
                <h2>$ 5,789,939 </h2>
                <span class="sparkline_one" style="height: 160px;">
                      <canvas width="200" height="60" style="display: inline-block; vertical-align: top; width: 94px; height: 30px;"></canvas>
                  </span>
              </div>
              <div class="col-md-3 col-sm-3 col-xs-6 tile">
                <span>Boletos Semanal</span>
                <h2>3,490</h2>
                <span class="sparkline_two" style="height: 160px;">
                      <canvas width="200" height="60" style="display: inline-block; vertical-align: top; width: 94px; height: 30px;"></canvas>
                  </span>
              </div>

            </div>
            <br />


            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="dashboard_graph x_panel">
                  <div class="row x_title">
                    <div class="col-md-6">
                      <h3>Ingresos</h3>
                    </div>
                    <div class="col-md-6">
                      <div id="reportrange" class="pull-right" style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc">
                        <i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
                        <span>December 30, 2015 - June 30, 2016</span> <b class="caret"></b>
                      </div>
                    </div>
                  </div>
                  <div class="x_content">
                    <div class="demo-container" style="height:250px">
                      <div id="placeholder3xx3" class="demo-placeholder" style="width: 100%; height:250px;"></div>
                    </div>
                  </div>
                </div>
              </div>
            </div>


            <div class="row">
              <div class="col-md-4 col-sm-6 col-xs-12">
                <div class="x_panel fixed_height_320">
                  <div class="x_title">
                    <h2>Ventas Por Producto</h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="#">Ajustes</a>
                          </li>
                        </ul>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <h4>Producto</h4>
                    <div class="widget_summary">
                      <div class="w_left w_25">
                        <span>Refresco</span>
                      </div>
                      <div class="w_center w_55">
                        <div class="progress">
                          <div class="progress-bar bg-green" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 66%;">
                            <span class="sr-only">60% Complete</span>
                          </div>
                        </div>
                      </div>
                      <div class="w_right w_20">
                        <span>123k</span>
                      </div>
                      <div class="clearfix"></div>
                    </div>
                    <div class="widget_summary">
					  <div class="w_left w_25">
						<span>Palomitas</span>
					  </div>
					  <div class="w_center w_55">
						<div class="progress">
						  <div class="progress-bar bg-green" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 50%;">
							<span class="sr-only">50% Complete</span>
						  </div>
						</div>
					  </div>
					  <div class="w_right w_20">
						<span>100k</span>
					  </div>
					  <div class="clearfix"></div>
                    </div>
					<div class="widget_summary">
						  <div class="w_left w_25">
							<span>Nachos</span>
						  </div>
						  <div class="w_center w_55">
							<div class="progress">
							  <div class="progress-bar bg-green" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 30%;">
								<span class="sr-only">30% Complete</span>
							  </div>
							</div>
						  </div>
						  <div class="w_right w_20">
							<span>85k</span>
						  </div>
						  <div class="clearfix"></div>
						</div>
					</div>
                </div>
              </div>

              <div class="col-md-4 col-sm-6 col-xs-12">
                <div class="x_panel fixed_height_320">
                  <div class="x_title">
                    <h2>Ventas Por Película</h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="#">Ajustes</a>
                          </li>
                        </ul>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                  <table class="" style="width:100%">
                    <tr>
                      <th style="width:37%;">
                        <p>Top 5</p>
                      </th>
                      <th>
                        <div class="col-lg-7 col-md-7 col-sm-7 col-xs-7">
                          <p class="">Película</p>
                        </div>
                        <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
                          <p class="">Ventas</p>
                        </div>
                      </th>
                    </tr>
                    <tr>
                      <td>
                        <canvas id="canvas1" height="140" width="140" style="margin: 15px 10px 10px 0"></canvas>
                      </td>
                      <td>
                        <table class="tile_info">
                          <tr>
                            <td>
                              <p><i class="fa fa-square aero"></i>La Era de H... </p>
                            </td>
                            <td>20%</td>
                          </tr>
                          <tr>
                            <td>
                              <p><i class="fa fa-square purple"></i>Yo Antes de Ti </p>
                            </td>
                            <td>10%</td>
                          </tr>
                          <tr>
                            <td>
                              <p><i class="fa fa-square red"></i>La Leyenda de... </p>
                            </td>
                            <td>20%</td>
                          </tr>
                          <tr>
                            <td>
                              <p><i class="fa fa-square green"></i>Día de la Indep...</p>
                            </td>
                            <td>35%</td>
                          </tr>
                          <tr>
						                              <td>
						                                <p><i class="fa fa-square blue"></i>Otras </p>
						                              </td>
						                              <td>15%</td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                  </table>
                  </div>
                </div>
              </div>

              <div class="col-md-4 col-sm-6 col-xs-12">
                <div class="x_panel fixed_height_320">
                  <div class="x_title">
                    <h2>Metas de Venta</h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">

                          <li><a href="#">Ajustes</a>
                          </li>
                        </ul>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <div class="dashboard-widget-content">
                      <ul class="quick-list">
                        <li><i class="fa fa-line-chart"></i><a href="#">Boletos</a></li>
                        <li><i class="fa fa-thumbs-up"></i><a href="#">Dulcería</a></li>
                      </ul>

                      <div class="sidebar-widget">
                        <h4>Boletos</h4>
                        <canvas width="150" height="80" id="foo" class="" style="width: 160px; height: 100px;"></canvas>
                        <div class="goal-wrapper">
                          <span id="gauge-text" class="gauge-value pull-left">0</span>
                          <span class="gauge-value pull-left">%</span>
                          <span id="goal-text" class="goal-value pull-right">100%</span>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>

              <div class="col-md-4 col-sm-6 col-xs-12 widget_tally_box">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Merma</h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="#">Ajustes</a>
                          </li>
                        </ul>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">

                    <div id="graph_bar" style="width:100%; height:200px;"></div>

                    <div class="col-xs-12 bg-white progress_summary">

                      <div class="row">
                        <div class="progress_title">
                          <span class="left">Refresco</span>
                          <span class="right"></span>
                          <div class="clearfix"></div>
                        </div>

                        <div class="col-xs-2">
                          <span>Manzana</span>
                        </div>
                        <div class="col-xs-8">
                          <div class="progress progress_sm">
                            <div class="progress-bar bg-green" role="progressbar" data-transitiongoal="89"></div>
                          </div>
                        </div>
                        <div class="col-xs-2 more_info">
                          <span>89%</span>
                        </div>
                      </div>
                      <div class="row">
                        <div class="progress_title">
                          <span class="left">Nachos</span>
                          <span class="right"></span>
                          <div class="clearfix"></div>
                        </div>

                        <div class="col-xs-2">
                          <span>Queso</span>
                        </div>
                        <div class="col-xs-8">
                          <div class="progress progress_sm">
                            <div class="progress-bar bg-green" role="progressbar" data-transitiongoal="79"></div>
                          </div>
                        </div>
                        <div class="col-xs-2 more_info">
                          <span>79%</span>
                        </div>
                      </div>
                      <div class="row">
                        <div class="progress_title">
                          <span class="left">Hot Dog</span>
                          <span class="right"></span>
                          <div class="clearfix"></div>
                        </div>

                        <div class="col-xs-2">
                          <span>Jitomate</span>
                        </div>
                        <div class="col-xs-8">
                          <div class="progress progress_sm">
                            <div class="progress-bar bg-green" role="progressbar" data-transitiongoal="69"></div>
                          </div>
                        </div>
                        <div class="col-xs-2 more_info">
                          <span>69%</span>
                        </div>
                      </div>

                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- /page content -->

                <!-- footer content -->
		        <footer>
		          <div class="pull-right">
		            2016 Derechos Reservados. Grupo Tecnetia SA de CV. <a href="#avisoPrivacidad">Aviso de Privacidad.</a>
		          </div>
		          <div class="clearfix"></div>
		        </footer>
		        <!-- /footer content -->
      </div>
    </div>

    <!-- jQuery -->
    <script src="js/vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="js/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="js/vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="js/vendors/nprogress/nprogress.js"></script>
    <!-- Chart.js -->
    <script src="js/vendors/Chart.js/dist/Chart.min.js"></script>
    <!-- jQuery Sparklines -->
    <script src="js/vendors/jquery-sparkline/dist/jquery.sparkline.min.js"></script>
    <!-- morris.js -->
    <script src="js/vendors/raphael/raphael.min.js"></script>
    <script src="js/vendors/morris.js/morris.min.js"></script>
    <!-- gauge.js -->
    <script src="js/vendors/gauge.js/dist/gauge.min.js"></script>
    <!-- bootstrap-progressbar -->
    <script src="js/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
    <!-- Skycons -->
    <script src="js/vendors/skycons/skycons.js"></script>
    <!-- Flot -->
    <script src="js/vendors/Flot/jquery.flot.js"></script>
    <script src="js/vendors/Flot/jquery.flot.pie.js"></script>
    <script src="js/vendors/Flot/jquery.flot.time.js"></script>
    <script src="js/vendors/Flot/jquery.flot.stack.js"></script>
    <script src="js/vendors/Flot/jquery.flot.resize.js"></script>
    <!-- Flot plugins -->
    <script src="js/flot/jquery.flot.orderBars.js"></script>
    <script src="js/flot/date.js"></script>
    <script src="js/flot/jquery.flot.spline.js"></script>
    <script src="js/flot/curvedLines.js"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="js/moment/moment.min.js"></script>
    <script src="js/datepicker/daterangepicker.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="js/build/custom.min.js"></script>

    <!-- Flot -->
    <script>
      $(document).ready(function() {
        //random data
        var d1 = [
          [0, 1],
          [1, 9],
          [2, 6],
          [3, 10],
          [4, 5],
          [5, 17],
          [6, 6],
          [7, 10],
          [8, 7],
          [9, 11],
          [10, 35],
          [11, 9],
          [12, 12],
          [13, 5],
          [14, 3],
          [15, 4],
          [16, 9]
        ];

        //flot options
        var options = {
          series: {
            curvedLines: {
              apply: true,
              active: true,
              monotonicFit: true
            }
          },
          colors: ["#26B99A"],
          grid: {
            borderWidth: {
              top: 0,
              right: 0,
              bottom: 1,
              left: 1
            },
            borderColor: {
              bottom: "#7F8790",
              left: "#7F8790"
            }
          }
        };
        var plot = $.plot($("#placeholder3xx3"), [{
          label: "Ventas",
          data: d1,
          lines: {
            fillColor: "rgba(150, 202, 89, 0.12)"
          }, //#96CA59 rgba(150, 202, 89, 0.42)
          points: {
            fillColor: "#fff"
          }
        }], options);
      });
    </script>
    <!-- /Flot -->

    <!-- jQuery Sparklines -->
    <script>
      $(document).ready(function() {
        $(".sparkline_one").sparkline([2, 4, 3, 4, 5, 4, 5, 4, 3, 4, 5, 6, 7, 5, 4, 3, 5, 6], {
          type: 'bar',
          height: '40',
          barWidth: 9,
          colorMap: {
            '7': '#a1a1a1'
          },
          barSpacing: 2,
          barColor: '#26B99A'
        });

        $(".sparkline_two").sparkline([2, 4, 3, 4, 5, 4, 5, 4, 3, 4, 5, 6, 7, 5, 4, 3, 5, 6], {
          type: 'line',
          width: '200',
          height: '40',
          lineColor: '#26B99A',
          fillColor: 'rgba(223, 223, 223, 0.57)',
          lineWidth: 2,
          spotColor: '#26B99A',
          minSpotColor: '#26B99A'
        });
      });
    </script>
    <!-- /jQuery Sparklines -->

    <!-- Doughnut Chart -->
    <script>
      $(document).ready(function() {
        var options = {
          legend: false,
          responsive: false
        };

        new Chart(document.getElementById("canvas1"), {
          type: 'doughnut',
          tooltipFillColor: "rgba(51, 51, 51, 0.55)",
          data: {
            labels: [
              "La Era de Hielo",
              "Yo Antes de Ti",
              "La Leyenda de Tarzán",
              "Día de la Independencia",
              "Otras"
            ],
            datasets: [{
              data: [20, 10, 20, 35, 15],
              backgroundColor: [
                "#BDC3C7",
                "#9B59B6",
                "#E74C3C",
                "#26B99A",
                "#3498DB"
              ],
              hoverBackgroundColor: [
                "#CFD4D8",
                "#B370CF",
                "#E95E4F",
                "#36CAAB",
                "#49A9EA"
              ]
            }]
          },
          options: options
        });
      });
    </script>
    <!-- /Doughnut Chart -->

    <!-- bootstrap-daterangepicker -->
    <script type="text/javascript">
      $(document).ready(function() {

        var cb = function(start, end, label) {
          console.log(start.toISOString(), end.toISOString(), label);
          $('#reportrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
        };

        var optionSet1 = {
          startDate: moment().subtract(29, 'days'),
          endDate: moment(),
          minDate: '01/01/2012',
          maxDate: '12/31/2015',
          dateLimit: {
            days: 60
          },
          showDropdowns: true,
          showWeekNumbers: true,
          timePicker: false,
          timePickerIncrement: 1,
          timePicker12Hour: true,
          ranges: {
            'Today': [moment(), moment()],
            'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
            'Last 7 Days': [moment().subtract(6, 'days'), moment()],
            'Last 30 Days': [moment().subtract(29, 'days'), moment()],
            'This Month': [moment().startOf('month'), moment().endOf('month')],
            'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
          },
          opens: 'left',
          buttonClasses: ['btn btn-default'],
          applyClass: 'btn-small btn-primary',
          cancelClass: 'btn-small',
          format: 'MM/DD/YYYY',
          separator: ' to ',
          locale: {
            applyLabel: 'Aceptar',
            cancelLabel: 'Limpiar',
            fromLabel: 'Desde',
            toLabel: 'Hasta',
            customRangeLabel: 'Custom',
            daysOfWeek: ['Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sa'],
            monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
            firstDay: 1
          }
        };
        $('#reportrange span').html(moment().subtract(29, 'days').format('MMMM D, YYYY') + ' - ' + moment().format('MMMM D, YYYY'));
        $('#reportrange').daterangepicker(optionSet1, cb);
        $('#reportrange').on('show.daterangepicker', function() {
          console.log("show event fired");
        });
        $('#reportrange').on('hide.daterangepicker', function() {
          console.log("hide event fired");
        });
        $('#reportrange').on('apply.daterangepicker', function(ev, picker) {
          console.log("apply event fired, start/end dates are " + picker.startDate.format('MMMM D, YYYY') + " to " + picker.endDate.format('MMMM D, YYYY'));
        });
        $('#reportrange').on('cancel.daterangepicker', function(ev, picker) {
          console.log("cancel event fired");
        });
        $('#options1').click(function() {
          $('#reportrange').data('daterangepicker').setOptions(optionSet1, cb);
        });
        $('#options2').click(function() {
          $('#reportrange').data('daterangepicker').setOptions(optionSet2, cb);
        });
        $('#destroy').click(function() {
          $('#reportrange').data('daterangepicker').remove();
        });
      });
    </script>
    <!-- /bootstrap-daterangepicker -->

    <!-- morris.js -->
    <script>
      $(document).ready(function() {
        Morris.Bar({
          element: 'graph_bar',
          data: [
            { "period": "Ene", "Miles Pesos": 80 },
            { "period": "Feb", "Miles Pesos": 125 },
            { "period": "Mar", "Miles Pesos": 176 },
            { "period": "Abr", "Miles Pesos": 224 },
            { "period": "May", "Miles Pesos": 265 },
            { "period": "Jun", "Miles Pesos": 314 },
            { "period": "Jul", "Miles Pesos": 347 },
            { "period": "Ago", "Miles Pesos": 287 },
            { "period": "Sep", "Miles Pesos": 240 },
            { "period": "Oct", "Miles Pesos": 211 }
          ],
          xkey: 'period',
          hideHover: 'auto',
          barColors: ['#26B99A', '#34495E', '#ACADAC', '#3498DB'],
          ykeys: ['Miles Pesos', 'sorned'],
          labels: ['Miles Pesos', 'SORN'],
          xLabelAngle: 60,
          resize: true
        });

        $MENU_TOGGLE.on('click', function() {
          $(window).resize();
        });
      });
    </script>
    <!-- /morris.js -->

    <!-- Skycons -->
    <script>
      var icons = new Skycons({
          "color": "#73879C"
        }),
        list = [
          "clear-day", "clear-night", "partly-cloudy-day",
          "partly-cloudy-night", "cloudy", "rain", "sleet", "snow", "wind",
          "fog"
        ],
        i;

      for (i = list.length; i--;)
        icons.set(list[i], list[i]);

      icons.play();
    </script>
    <!-- /Skycons -->

    <!-- gauge.js -->
    <script>
      var opts = {
        lines: 12,
        angle: 0,
        lineWidth: 0.4,
        pointer: {
          length: 0.75,
          strokeWidth: 0.042,
          color: '#1D212A'
        },
        limitMax: 'false',
        colorStart: '#1ABC9C',
        colorStop: '#1ABC9C',
        strokeColor: '#F0F3F3',
        generateGradient: true
      };
      var target = document.getElementById('foo'),
          gauge = new Gauge(target).setOptions(opts);

      gauge.maxValue = 100;
      gauge.animationSpeed = 32;
      gauge.set(80);
      gauge.setTextField(document.getElementById("gauge-text"));

      var target = document.getElementById('foo2'),
          gauge = new Gauge(target).setOptions(opts);

      gauge.maxValue = 5000;
      gauge.animationSpeed = 32;
      gauge.set(4200);
      gauge.setTextField(document.getElementById("gauge-text2"));
    </script>
    <!-- /gauge.js -->
  </body>
</html>