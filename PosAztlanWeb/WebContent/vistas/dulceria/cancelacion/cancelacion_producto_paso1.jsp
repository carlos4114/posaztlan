
<!-- Bootstrap -->
<!-- page content -->
<!-- bloque de wizard -->
<!-- bloque de PASO de wizard - CARTELERA -->
<div id="step-1">

	<div class="x_panel">
		<div class="x_title">
			<h2>
				<i class="fa fa-film"></i> Cancelación Pagos
			</h2>
			
			<div class="title_right">
				<div class="row pull-right">

					<button type="button" ng-click="asignarPaso(2)" ng-disabled="" class="btn btn-success">
						Registrar Cancelación <i class="fa fa-credit-card"></i>
					</button>

				</div>

				<div class="clearfix"></div>
			</div>

		</div>
		<div class="x_content">
			<div class="row">
				<div class="x_content">

					<form class="form-horizontal form-label-left" novalidate>

						<div class="form-group">

							<div
								class="col-lg-5 col-md-4 col-sm-5  col-xs-12  col-lg-offset-3 col-md-offset-3  col-sm-offset-3  ">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="email">No Ticket <span class="required">*</span>
								</label>
								<div class="input-group">
									<input type="text" class="form-control" id="idTicket" integer-number
										ng-model="idTicket" required="required"> <span
										class="input-group-btn">
										<button type="button" class="btn btn-primary"
											ng-click="consultarTicket(idTicket)">Buscar!</button>
									</span>
								</div>
							</div>
						</div>
					</form>
				</div>

			</div>

			<div class="row" ng-if="ticket!=null">

				<div class="x_content">
					<!-- bloque de pelicula -->
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="x_panel">

							<div class="col-md-5 col-sm-5 col-xs-12">
								<div class="row">
									<!-- /row -->
									<div
										dir-paginate="paqueteXTicket in ticket.paquetesXTicketVO  | itemsPerPage:3"
										class="col-lg-6 col-md-6 col-sm-12 col-xs-12 ">
										<div class="tile-stats" style="background-color: #FFFF">
											<div style="position: absolute; top: 10px; right: 10px">
												<img class="img-responsive avatar-view"
													ng-src="data:image/png;base64,{{paqueteXTicket.paqueteVO.icono}}"
													width="50px" height="50px">
											</div>
											<div class="count">{{paqueteXTicket.cantidad}}</div>
											<h3>{{paqueteXTicket.paqueteVO.nombre}}</h3>
											<div ng-if="paqueteXTicket.paqueteVO.paquete">
												<p
													ng-repeat="produtoXPaquete in paqueteVO.productosXPaqueteVO">
													{{paqueteXTicket.produtoXPaquete.cantidad}}
													{{paqueteXTicket.produtoXPaquete.productoVO.nombre}}(s)</p>
											</div>
											<div class="text-center mtop20">
												<h2>{{paqueteXTicket.importe | currency }}</h2>
											</div>
										</div>
									</div>

								</div>
								<div class="row">
									<div
										class="col-lg-5 col-md-4 col-sm-5  col-xs-12  col-lg-offset-4 col-md-offset-5  col-sm-offset-5  col-xs-offset-4">
										<dir-pagination-controls></dir-pagination-controls>
									</div>
								</div>
							</div>

							<div class="col-md-7 col-sm-7 col-xs-12">



								<div class="row">
									<div class=" col-lg-12 col-md-12 col-sm-12 col-xs-12">

										<div class="table-responsive  ">
											<table class="table table-striped jambo_table bulk_action">
												<thead>
													<tr class="headings">
														<th class="column-title text-center">Forma de Pago</th>
														<th class="column-title text-center">Importe</th>
														<th class="column-title text-center">Cuenta</th>
														<th class="column-title text-center">Fecha Pago</th>
														<th class="column-title text-center">Acción</th>

													</tr>
												</thead>

												<tbody>
													<tr class="even pointer"
														ng-repeat="pago in listaPagos  track by pago.idPago">
														<td class=" ">{{pago.formaPagoVO.nombre}}</td>
														<td class="text-center">{{pago.importe | currency}}</td>
														<td class="text-center">{{pago.noCuenta}}</td>
														<td class="text-center">{{pago.fecha}}</td>
														<td class="text-center"><button type="button"
																class="btn {{pago.statusPagoColor}} btn-xs "
																ng-disabled="pago.status == 0"
																ng-click="cancelarPago(pago)">{{pago.label}}</button>
															<button type="button" class="btn btn-danger  btn-xs"
																ng-click="descancelar(pago)"
																ng-if="pago.status == 0 && pago.estatusPagoVO.clave == 'PAG-001'"
																data-toggle="tooltip" data-placement="right"
																title="Tooltip right">
																<i class="  fa fa-times"></i>
															</button></td>

													</tr>

												</tbody>
											</table>
										</div>
										<!-- table-responsive -->
									</div>
								</div>
								<!-- /row -->

								<div class="row">
									<div
										class="col-lg-4 col-md-4 col-sm-4 col-xs-12  col-lg-offset-4 col-md-offset-4  col-sm-offset-4 col-xs-offset-12">

										<div class="tile-stats">
											<h3 class="text-center">TOTAL</h3>
											<br />
											<h3 class="text-center">{{ticket.subtotal | currency}}</h3>

											<br />
											<h3 class="text-center"></h3>
										</div>

									</div>
								</div>
							</div>
						</div>
						<!-- /X9 columnas  -->
						<!-- /xpanel PELICULA -->
					</div>
					<!-- /x12 columnas -->
				</div>
			</div>

		</div>
	</div>

</div>

<!-- /bloque de PASO de wizard -->
<!-- /bloque de wizard -->