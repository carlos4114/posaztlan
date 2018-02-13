
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
							<div class="x_title">
								<h2>
									<i class="fa fa-film"></i>{{ticket.programacionVO.peliculaVO.titulo}}
								</h2>

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
									<div
										class="col-md-4 col-sm-4 col-xs-12 col-lg-offset-1 col-md-offset-1  col-sm-offset-1">
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
										class="  col-lg-4 col-md-4 col-sm-4 col-xs-12  col-lg-offset-1 col-md-offset-1   ">
										<!-- 										class="animated flipInY col-lg-4 col-md-4 col-sm-4 col-xs-12 col-lg-offset-3 col-md-offset-3 col-sm-offset-3"> -->

										<div class="tile-stats">
											<h3 class="text-center">TOTAL</h3>
											<br />
											<h3 class="text-center">{{ticket.subtotal | currency}}</h3>

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
									class=" col-lg-7 col-md-7 col-sm-7 col-xs-12  col-lg-offset-1 col-md-offset-1  col-sm-offset-1 ">

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
														<button type="button" class="btn btn-danger  btn-xs" ng-click="descancelar(pago)" 
														ng-if="pago.status == 0 && pago.estatusPagoVO.clave == 'PAG-001'"
															data-toggle="tooltip" data-placement="right"
															title="Tooltip right">
															<i class="  fa fa-times"></i>
														</button></td>

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

<!-- /bloque de PASO de wizard -->
<!-- /bloque de wizard -->