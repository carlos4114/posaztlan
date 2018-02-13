

<!-- Bootstrap -->
<!-- page content -->
<!-- bloque de wizard -->
<!-- bloque de PASO de wizard - CARTELERA -->
<div id="step-1">

	<div class="x_panel">
		<div class="x_title">
			<h2>
				<i class="fa fa-film"></i> Resumen Devolución Productos
			</h2>
			<div class="clearfix">
				<div class="clearfix"></div>
			</div>

		</div>
		<div class="x_content">
			<div class="row">

				<div
					class="col-lg-2 col-md-2 col-sm-2 col-xs-12 col-lg-offset-10 col-md-offset-2 col-sm-offset-5 col-xs-offset-0">
					<a href="#/devolucion_producto"><button type="button"
							class="btn btn-success  col-xs-12"
							ng-click="resetValues();asignarPaso(1)">Nueva Devolución</button></a>
				</div>
			</div>
			<div class="row">

				<div class="x_content">
					<!-- bloque de pelicula -->
					<div class="col-md-12 col-sm-12 col-xs-12">



						<div class="row">

							<div class="col-md-12 col-sm-12 col-xs-12">
								<div class="form-group"
									ng-show="devolucion.tipoDevolucionVO.clave == 'EFE-002'">
									<div
										class="animated flipInY col-lg-4 col-md-4 col-sm-4 col-xs-6 col-lg-offset-4 col-md-offset-4 col-xs-offset-4 col-sm-offset-4 ">


										<div class="tile-stats">
											<h3 class="text-center">Importe Devolución</h3>
											<br />
											<h3 class="text-center">{{devolucion.importe |
												currency}}</h3>
										</div>


									</div>
								</div>

								<div class="form-group"
									ng-show="devolucion.tipoDevolucionVO.clave == 'PRO-001'">
									<div
										class="animated flipInY col-lg-4 col-md-4 col-sm-4 col-xs-6 col-lg-offset-4 col-md-offset-4 col-xs-offset-4 col-sm-offset-4 ">


										<div class="tile-stats">
											<h3 class="text-center">Devolución por Producto</h3>
											<br />
											<h3 class="text-center"></h3>
										</div>


									</div>
								</div>
							</div>
						</div>

						<div class="row">

							<div
								dir-paginate="paqueteXTicket in ticket.paquetesXTicketVO   | itemsPerPage: 10"
								class="col-lg-4 col-md-4 col-sm-6 col-xs-6 ">
								<fieldset ng-disabled="true">
									<div class="tile-stats"
										ng-style="{'background-color': '#FFFFFF'} ">

										<div style="position: absolute; top: 10px; right: 10px">
											<img class="img-responsive avatar-view"
												ng-src="data:image/png;base64,{{paqueteXTicket.paqueteVO.icono}}"
												width="50px" height="50px">
										</div>
										<div class="count"></div>
										<h3>{{paqueteXTicket.paqueteVO.nombre}}</h3>
										<div>
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 ">
												<div
													ng-repeat="productoXPaquete in paqueteXTicket.paqueteVO.productosXPaqueteVO">
													<div class="row">
														<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 ">
															<input type="checkbox"
																id="checkb{{paqueteXTicket.id}}{{productoXPaquete.productoVO.idProducto}}"
																class="flat "
																ng-model="productoXPaquete.productoVO.selected">{{productoXPaquete.productoVO.nombre}}
														</div>
														<div class="col-lg-5 col-md-6 col-sm-6 col-xs-6 ">

															<div class="contSwitch my-disabled">

																<input type="checkbox"
																	ng-checked="productoXPaquete.productoVO.estado"
																	ng-model="productoXPaquete.productoVO.estado"
																	class="inputSwitch"
																	id="inputSwitch_{{paqueteXTicket.id}}{{productoXPaquete.productoVO.idProducto}}"> <label
																	for="inputSwitch_{{paqueteXTicket.id}}{{productoXPaquete.productoVO.idProducto}}"
																	class="labelSwitch">
																	<div
																		id="switchBar_{{paqueteXTicket.id}}{{productoXPaquete.productoVO.idProducto}}"
																		class="switchBar"></div>
																	<div
																		id="switchItem_{{paqueteXTicket.id}}{{productoXPaquete.productoVO.idProducto}}"
																		class="switchItem"></div>

																</label>
															</div>


														</div>

													</div>
												</div>
											</div>
										</div>
										<div class="text-center mtop20">
											<h2>{{paqueteXTicket.paqueteVO.precio | currency }}</h2>
										</div>
									</div>
								</fieldset>
							</div>
							<div class="row">
								<div
									class="col-lg-5 col-md-4 col-sm-5  col-xs-12  col-lg-offset-4 col-md-offset-5  col-sm-offset-5  col-xs-offset-4">
									<dir-pagination-controls></dir-pagination-controls>
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