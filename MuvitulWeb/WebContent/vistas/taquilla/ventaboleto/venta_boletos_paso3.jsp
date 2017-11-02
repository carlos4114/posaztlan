
<!-- bloque de PASO 3 de wizard - CANTIDAD -->
<div id="step-2">
	<div class="x_panel" ng-init="initCron()">
		<div class="x_title">
			<h2>
				<i class="fa fa-calculator"></i> Selecciona la Cantidad de Boletos
			</h2>
			<div class="row pull-right">

				<button type="button" class="btn btn-primary"
					ng-click="asignarPaso(2);StopTimer()">
					<i class="fa fa-star"></i> Regresar a Promociones
				</button>


				<button type="button" class="btn btn-success"
					ng-disabled="pago.subtotal == 0 "
					ng-click="asignarPaso(4);consultarFormasPago();StopTimer()">
					Registrar el Pago <i class="fa fa-credit-card"></i>
				</button>

			</div>
			<div class="clearfix"></div>
		</div>
		<div class="x_content">
			<!-- bloque de pelicula -->
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>
							<i class="fa fa-film"></i> {{objetosVenta.pelicula.titulo}}
						</h2>
						<div class="row pull-right">
							<h3>TOTAL = {{pago.subtotal | currency}}</h3>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="col-md-3 col-sm-3 col-xs-3">
						<div class="row">
							<div
								class="animated flipInY col-lg-8 col-md-8 col-sm-10 col-xs-12">
								<div class="tile-stats">
									<h2 class="text-center">Disponibles</h2>
									<h3 class="text-center">{{asientosDisponibles.disponibles}}</h3>
								</div>
							</div>
						</div>
						<!-- /row -->
						<div class="row">
							<div class="profile_img">
								<div id="crop-avatar">
									<img class="img-responsive avatar-view"
										ng-src="data:image/png;base64,{{objetosVenta.pelicula.icono}}"
										width="90%">

								</div>
							</div>
						</div>
					</div>
					<div class="col-md-9 col-sm-9 col-xs-9">

						<div class="row">
							<div class="col-md-4 col-sm-4 col-xs-4">
								<br /> <br />
								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12">
										<label>CINE: {{objetosVenta.pelicula.cineVO.nombre}} </label>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12">
										<label>FECHA: {{objetosVenta.fechaExhibicion |
											date:'dd-MM-yyyy'}} </label>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12">
										<label>HORARIO: {{objetosVenta.programacion.horario}}
											{{objetosVenta.programacion.versionVO.nombre}}
											{{objetosVenta.programacion.formatoVO.nombre}}</label>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12">
										<label>SALA:
											{{objetosVenta.programacion.salaVO.nombre}}</label>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12">
										<label>DISTRIBUIDORA:
											{{objetosVenta.pelicula.distribuidoraVO.nombre}}</label>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12">
										<label>PAIS: {{objetosVenta.pelicula.paisVO.nombre}}</label>
									</div>
								</div>
							</div>
							<!-- /col md 6 -->
							<div class="col-md-8 col-sm-8 col-xs-8">
								<br />

								<div
									class="table-responsive col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<table class="table table-striped jambo_table bulk_action">
										<thead>
											<tr class="headings">
												<th class="column-title text-center">Tipo</th>
												<th class="column-title text-center">Cant.</th>
												<th class="column-title text-center">Subtotal</th>
												<th class="column-title text-center no-link last">Quitar</th>
											</tr>
										</thead>

										<tbody>
											<tr class="odd pointer" ng-repeat="boleto in boletos" ng-if="boleto.cantidad > 0">
												<td class=" " ng-if="boleto.tipoCliente == 'PROMO'">Promoción</td>
												 <td class=" " ng-if="boleto.tipoCliente != 'PROMO'">{{boleto.tipoCliente}}</td>
												<td class="text-center">{{boleto.cantidad}}</td>
												<td class="text-center">{{boleto.subtotal | currency}}</td>
												<td class="text-center"><a href=""
													ng-if="boleto.tipoCliente !='PROMO'"
													ng-click="quitarBoleto(boleto)" title="Quitar Boleto"><i
														class="success fa fa-minus-square-o"></i></a></td>

											</tr> 
											<tr ng-if="pago.subtotal== 0 && (promocion.cantidad ==0 || promocion== null)">	<td class="text-center" colspan="4">No existen
											registros.</td>
									</tr>
											

										</tbody>
									</table>
								</div>
								<!-- table-responsive -->
								<div
									class="animated flipInY col-lg-8 col-md-12 col-sm-12 col-xs-12 col-lg-offset-2">

									<div class="tile-stats">
										<h2 class="text-center">Promoci&oacute;n</h2>
										<br />
										<h3 class="text-center">{{objetosVenta.promocion.nombre}}</h3>
										<p class="text-center">{{objetosVenta.promocion.descripcion}}</p>
										<p class="text-center"
											ng-if="promocion.cantidad ==0 || promocion== null">No seleccionó Promoción</p>
									</div>

								</div>
							</div>
							<!-- /div col-md-6 -->
						</div>
						<!-- /row -->
						<br />
						<form id="demo-form2" data-parsley-validate
							class="form-horizontal form-label-left">
							<!-- row - Tabla de selección de boletos -->
							<div class="row">
								<div ng-repeat="precio in listaPreciosXFormato track by $index">
									<div ng-disabled="asientosDisponibles.disponibles ==0">
										<div
											class="animated flipInY col-lg-4 col-md-4 col-sm-4 col-xs-4">
											<a href="#/ventaBoletos"
												ng-click="agregarBoleto(precio,$index)">
												<div class="tile-stats">
													<div style="position: absolute; top: 10px; right: 10px">
														<img class="img-responsive avatar-view" width="50px"
															height="50px"
															ng-src="data:image/png;base64,{{precio.tipoClienteVO.icono}}">
													</div>
													<div ng-if="precio.tipoClienteVO.idTipoCliente === 2"
														class="count">{{precio.boletosSeleccionados}}</div>
													<div ng-if="precio.tipoClienteVO.idTipoCliente === 1"
														class="count">{{precio.boletosSeleccionados}}</div>
													<div ng-if="precio.tipoClienteVO.idTipoCliente === 3"
														class="count">{{precio.boletosSeleccionados}}</div>

													<br />
													<h3>{{precio.tipoClienteVO.nombre}}</h3>
													<div class="text-center mtop20">
														<h2>{{precio.precio | currency}}</h2>
													</div>
												</div>
											</a>
										</div>
									</div>
								</div>
							</div>
							<!-- /row - Tabla de Seleccion de Boletos -->
						</form>
					</div>
					<!-- /X9 columnas  -->
				</div>
				<!-- /xpanel PELICULA -->
			</div>
			<!-- /x12 columnas -->
		</div>
		<!-- /xcontent -->
	</div>
	<!-- /xpanel MODULO -->
</div>
