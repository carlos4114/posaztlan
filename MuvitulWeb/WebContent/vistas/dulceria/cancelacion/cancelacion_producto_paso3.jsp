
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
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="x_panel">

							<div class="col-md-12 col-sm-12 col-xs-12">

								<div class="row">

									<div
										class="col-lg-7 col-md-10 col-sm-10 col-xs-12 col-lg-offset-1 col-md-offset-1 col-sm-offset-1 col-xs-offset-1">

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
																class="btn {{pago.estatusPagoVO.clave =='CAN-003' ? 'btn-danger':'btn-success'  }} btn-xs ">{{pago.estatusPagoVO.clave
																=='CAN-003' ? 'CANCELADO':'PAGADO'}}</button></td>
													</tr>

												</tbody>
												</tbody>

											</table>
										</div>
										<!-- table-responsive -->
									</div>

									<div
										class="animated flipInY col-lg-2 col-md-3 col-sm-4 col-xs-6 col-lg-offset-1">
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


						</div>
					</div>
				</div>
			</div>

		</div>
	</div>

</div>

<!-- /bloque de PASO de wizard -->
<!-- /bloque de wizard -->