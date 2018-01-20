

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
			<div class="title_right">
				<div class="row pull-right">

					<button type="button" ng-click="asignarPaso(2)" ng-if="ticket.exhibicionVencida == false && ticket.devolucionesVO.length <= 0" class="btn btn-success">
						Registrar Devolución <i class="fa fa-credit-card"></i>
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
									<input type="text" class="form-control" id="idTicket"
										ng-model="idTicket" required="required" integer-number
										ng-change=""> <span class="input-group-btn">
										<button type="button" class="btn btn-primary"
											ng-click="consultarTicket(idTicket)">Buscar!</button>
									</span>
								</div>
							</div>
						</div>
					</form>
				</div>

			</div>
			<div class="row ">

				<div class="alert alert-danger text-center  "
					ng-if="ticket.devolucionesVO.length > 0">
					<strong>El número de ticket {{ticket.idTicket}} ya ha sido
						devuelto, con fecha {{ticket.devolucionesVO[0].fechaHora |
						date:'dd/MM/yyyy HH:mm:ss'}} </strong>
				</div>
				<div class="alert alert-danger text-center  "
					ng-if="ticket.exhibicionVencida == true && ticket.devolucionesVO.length == 0">
					<strong>El número de ticket {{ticket.idTicket}} contiene
						boletos con exhibición vencida el  : {{ticket.fechaExhibicion}}</strong>
				</div>
			</div>

			<div class="row" ng-if="ticket!=null"
				ng-class="{'my-disabled' : ticket.devolucionesVO.length > 0 || ticket.exhibicionVencida == true}">

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
										class="col-lg-offset-1 col-md-offset-1  col-sm-offset-0 col-lg-7 col-md-7 col-sm-8 col-xs-12 ">

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
														<td class="text-center">{{boleto.importe | currency}}</td>
													</tr>
												</tbody>
											</table>
										</div>
										<!-- table-responsive -->
									</div>
									<!-- /div col-md-6 -->
								</div>

								<div class="row">

									<div
										class="animated flipInY col-lg-5 col-md-7 col-sm-4 col-xs-12 col-lg-offset-6 col-md-offset-5 col-sm-offset-6">
										<!-- 										class="animated flipInY col-lg-4 col-md-4 col-sm-4 col-xs-12 col-lg-offset-3 col-md-offset-3 col-sm-offset-3"> -->

										<div class="tile-stats">
											<h3 class="text-center">TOTAL</h3>
											<br />
											<h3 class="text-center">{{ticket.subtotal | currency}}</h3>

											<br />
											<h3 class="text-center"></h3>
										</div>

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

<!-- /bloque de PASO de wizard -->
<!-- /bloque de wizard -->