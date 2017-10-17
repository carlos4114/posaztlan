<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
 <META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Venta Boleto</title>
</head>
<body>
<!-- Bootstrap -->
<!-- page content -->
<!-- bloque de wizard -->
<!-- bloque de PASO de wizard - CARTELERA -->
<div id="step-1">

	<div class="x_panel">
		<div class="x_title">
			<h2>
				<i class="fa fa-film"></i> Resumen Cancelación Pagos
			</h2>
			<div class="row pull-right">

				<button type="button" class="btn btn-primary"
					ng-click="resetDatos();">
					<i class="fa fa-star"></i> Nueva Cancelación
				</button>

			</div>
			<div class="clearfix"></div>

		</div>
		<div class="x_content">


			<div class="row" ng-if="cancelacionTicket!=null">

				<div class="x_content">
					<!-- bloque de pelicula -->
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="x_panel">
							<div class="x_title">
								<h2>
									<i class="fa fa-film"></i>{{cancelacionTicket.programacionVO.peliculaVO.titulo}}
								</h2>

								<div class="clearfix"></div>
							</div>
							<div class="col-md-3 col-sm-3 col-xs-3">

								<!-- /row -->
								<div class="row">
									<div class="profile_img">
										<div id="crop-avatar">
											<img class="img-responsive avatar-view"
												ng-src="data:image/png;base64,{{cancelacionTicket.programacionVO.peliculaVO.icono}}">
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-9 col-sm-9 col-xs-9">

								<div class="row">
									<div
										class="col-md-4 col-sm-4 col-xs-12 col-lg-offset-1 col-md-offset-1  col-sm-offset-1">
										<br /> <br />
										<div class="row">
											<div class="col-md-12 col-sm-12 col-xs-12">
												<label>CINE:{{cancelacionTicket.programacionVO.peliculaVO.cineVO.nombre}}
												</label>
											</div>
										</div>
										<div class="row">
											<div class="col-md-12 col-sm-12 col-xs-12">
												<label>FECHA: {{cancelacionTicket.fechaExhibicion}}</label>
											</div>
										</div>
										<div class="row">
											<div class="col-md-12 col-sm-12 col-xs-12">
												<label>HORARIO:
													{{cancelacionTicket.programacionVO.horario}}
													{{cancelacionTicket.programacionVO.formatoVO.nombre}} </label>
											</div>
										</div>
										<div class="row">
											<div class="col-md-12 col-sm-12 col-xs-12">
												<label>SALA:{{cancelacionTicket.programacionVO.salaVO.nombre}}
												</label>
											</div>
										</div>
										<div class="row">
											<div class="col-md-12 col-sm-12 col-xs-12">
												<label>CLASIFICACION:
													{{cancelacionTicket.programacionVO.peliculaVO.clasificacion}}
												</label>
											</div>
										</div>
									</div>
									<!-- /col md 6 -->
									<div
										class="animated flipInY col-lg-4 col-md-4 col-sm-4 col-xs-12 col-lg-offset-3 col-md-offset-3 col-sm-offset-3 ">
										<!-- 										class="animated flipInY col-lg-4 col-md-4 col-sm-4 col-xs-12 col-lg-offset-3 col-md-offset-3 col-sm-offset-3"> -->

										<div class="tile-stats">
											<h3 class="text-center">TOTAL</h3>
											<br />
											<h3 class="text-center">{{cancelacionTicket.subtotal |
												currency}}</h3>

											<br />
											<h3 class="text-center"></h3>
										</div>

									</div>
									<!-- /div col-md-6 -->
								</div>

							</div>
							<br /> <br /> <br />
							<div class="row">

								<div
									class="col-lg-offset-1 col-md-offset-1  col-sm-offset-1 col-lg-7 col-md-7 col-sm-7 col-xs-12 ">

									<div class="table-responsive  ">
										<table class="table table-striped jambo_table bulk_action">
											<thead>
												<tr class="headings">
													<th class="column-title text-center">Forma de Pago</th>
													<th class="column-title text-center">Importe</th>
													<th class="column-title text-center">Cuenta</th>
													<th class="column-title text-center">Fecha Pago</th>
													<th class="column-title text-center">Estatus</th>

												</tr>
											</thead>

											<tbody>
											<tbody>
												<tr class="even pointer"
													ng-repeat="pago in cancelacionTicket.pagosVO track by $index">
													<td class=" ">{{pago.formaPagoVO.nombre}}</td>
													<td class="text-center">{{pago.importe | currency}}</td>
													<td class="text-center">{{pago.noCuenta}}</td>
													<td class="text-center">{{pago.fecha}}</td>
													<td class="text-center"><button type="button"
															class="btn {{pago.estatusPagoVO.clave =='CAN-003' ? 'btn-danger':'btn-success'  }} btn-xs ">{{pago.estatusPagoVO.clave =='CAN-003' ? 'CANCELADO':'PAGADO'}}</button></td>
												</tr>

											</tbody>
											</tbody>

										</table>
									</div>
									<!-- table-responsive -->
								</div>

							</div>
							<!-- /row -->

							<!-- /X9 columnas  -->
						</div>
						<!-- /xpanel PELICULA -->
					</div>
					<!-- /x12 columnas -->
				</div>
			</div>

		</div>
	</div>

</div>
</body>
</html>
<!-- /bloque de PASO de wizard -->
<!-- /bloque de wizard -->