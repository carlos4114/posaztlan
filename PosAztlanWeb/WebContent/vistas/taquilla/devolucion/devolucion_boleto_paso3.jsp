
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
					<i class="fa fa-film"></i> Devolución Boletos
				</h2>
				<div class="clearfix"></div>

			</div>
			<div class="x_content">


				<div class="row">

					<div class="x_content">
						<!-- bloque de pelicula -->
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>
										<i class="fa fa-film"></i>{{ticket.programacionVO.peliculaVO.titulo}}
									</h2>
									<div class="row pull-right">

										<button type="button" class="btn btn-primary"
											ng-click="reiniciarDevolucion()">
											<i class="fa fa-film"></i> Nueva Devolución
										</button>

										 

									</div>

									<div class="clearfix"></div>
								</div>
								<div class="col-md-3 col-sm-3 col-xs-3">

									<!-- /row -->
									<div class="row">
										<div class="profile_img">
											<div id="crop-avatar">
												<img class="img-responsive avatar-view"
													ng-src="data:image/png;base64,{{ticket.programacionVO.peliculaVO.icono}}">
											</div>
										</div>
									</div>
								</div>
								<div class="col-md-9 col-sm-9 col-xs-9">

									<div class="row">
										<div class="col-md-4 col-sm-4 col-xs-12">
											<br /> <br />
											<div class="row">
												<div class="col-md-12 col-sm-12 col-xs-12">
													<label>CINE:{{ticket.programacionVO.peliculaVO.cineVO.nombre}}
													</label>
												</div>
											</div>
											<div class="row">
												<div class="col-md-12 col-sm-12 col-xs-12">
													<label>FECHA: {{ticket.fechaExhibicion}}</label>
												</div>
											</div>
											<div class="row">
												<div class="col-md-12 col-sm-12 col-xs-12">
													<label>HORARIO: {{ticket.programacionVO.horario}}
														{{ticket.programacionVO.formatoVO.nombre}} </label>
												</div>
											</div>
											<div class="row">
												<div class="col-md-12 col-sm-12 col-xs-12">
													<label>SALA:{{ticket.programacionVO.salaVO.nombre}}
													</label>
												</div>
											</div>
											<div class="row">
												<div class="col-md-12 col-sm-12 col-xs-12">
													<label>CLASIFICACION:
														{{ticket.programacionVO.peliculaVO.clasificacion}} </label>
												</div>
											</div>
										</div>
										<!-- /col md 6 -->
										<div
											class="col-lg-offset-1 col-md-offset-1  col-sm-offset-1 col-lg-7 col-md-7 col-sm-6 col-xs-12 ">

											<div class="table-responsive  ">
												<table class="table table-striped jambo_table bulk_action">
													<thead>
														<tr class="headings">
															<th class="column-title text-center">Tipo</th>
															<th class="column-title text-center">Cant.</th>
															<th class="column-title text-center">Subtotal</th>
														</tr>
													</thead>

													<tbody>
														<tr class="odd pointer"
															ng-repeat="boleto in  ticket.boletosXTicketVO">
															<td class=" ">{{boleto.tipoClienteVO.nombre}}</td>
															<td class="text-center">{{boleto.cantidad}}</td>
															<td class="text-center">{{boleto.importe |
																currency}}</td>
														</tr>
													</tbody>
												</table>
											</div>
											<!-- table-responsive -->
										</div>
										<!-- /div col-md-6 -->
									</div>

									<div class="row">
										<!-- 									<div -->
										<!-- 										class="animated flipInY col-lg-4 col-md-4 col-sm-4 col-xs-12"> -->

										<!-- 										<div class="tile-stats"> -->
										<!-- 											<h2 class="text-center">Promoci&oacute;n</h2> -->
										<!-- 											<br /> -->
										<!-- 											<h3 class="text-center">{{objetosVenta.promocion.nombre}}</h3> -->
										<!-- 											<p class="text-center">{{objetosVenta.promocion.descripcion}}</p> -->
										<!-- 											<p class="text-center" -->
										<!-- 												ng-if="promocion.cantidad ==0 || promocion== null">No -->
										<!-- 												seleccionó Promoción</p> -->
										<!-- 										</div> -->

										<!-- 									</div> -->
										<div
											class="animated flipInY col-lg-4 col-md-12  col-sm-12  col-xs-12 col-lg-offset-5 col-md-offset-0 col-sm-offset-0 ">

											<div class="tile-stats">
												<h3 class="text-center">TOTAL</h3>
												<br />
												<h3 class="text-center">{{ticket.subtotal | currency}}</h3>
											</div>

										</div>

										<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6   text-center"
											ng-if="devolucion.cortesia">
											<a class="btn btn-app"
												title="Cerrar venta e imprimir boletos"
												ng-click="imprimirCortesia()"> <i
												class="fa fa-print"></i> Imprimir Boletos
											</a>

										</div>
									</div>
									<!-- /row -->



								</div>

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