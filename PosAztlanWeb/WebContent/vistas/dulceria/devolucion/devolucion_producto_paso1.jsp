<!-- Bootstrap -->
<!-- page content -->
<!-- bloque de wizard -->
<!-- bloque de PASO de wizard - CARTELERA -->
<div id="step-1">

	<div class="x_panel">
		<div class="x_title">
			<h2>
				<i class="fa fa-film"></i> Devolución Producto
			</h2>
			<div class="title_right">
				<div class="row pull-right">

					<button type="button"
						ng-click="asignarPaso(2);determinarTipoDevolucion()"
						ng-disabled="" class="btn btn-success">
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
										integer-number ng-model="idTicket" required="required">
									<span class="input-group-btn">
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
				<div class="row">

					<p>
						<input type="checkbox" class="flat"
							ng-disabled="ticket.devolucionesVO.length > 0"
							ng-model="ticket.seleccionarPaquetes"
							ng-click="seleccionarTodosPaquetes(ticket.paquetesXTicketVO)">Seleccionar
						Paquetes
					</p>
				</div>
				<div class="row">

					<div
						dir-paginate="paqueteXTicket in ticket.paquetesXTicketVO   | itemsPerPage: 10"
						class="col-lg-4 col-md-4 col-sm-6 col-xs-6  ">
						<fieldset ng-disabled="ticket.devolucionesVO.length > 0">
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
									<p>
										<input type="checkbox" class="flat"
											ng-model="paqueteXTicket.paqueteVO.selected"
											ng-click="seleccionarTodosProducto(paqueteXTicket)">Seleccionar
										Todo
									</p>
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 ">
										<div
											ng-repeat="productoXPaquete in paqueteXTicket.paqueteVO.productosXPaqueteVO">
											<div class="row">
												<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 ">
													<input type="checkbox"
														id="checkb{{paqueteXTicket.id}}{{productoXPaquete.productoVO.idProducto}}"
														class="flat "
														ng-model="productoXPaquete.productoVO.selected"
														ng-click="seleccionarProducto(productoXPaquete,paqueteXTicket)">{{productoXPaquete.productoVO.nombre}}
												</div>
												<div class="col-lg-5 col-md-6 col-sm-6 col-xs-6 ">

													<div class="contSwitch"
														ng-class="{'my-disabled' : ticket.devolucionesVO.length > 0}">

														<input type="checkbox"
															ng-checked="productoXPaquete.productoVO.estado"
															ng-model="productoXPaquete.productoVO.estado"
															class="inputSwitch"
															id="inputSwitch_{{paqueteXTicket.id}}{{productoXPaquete.productoVO.idProducto}}"
															ng-click="statusProducto(productoXPaquete )"> <label
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

				</div>
				<div class="row ">
					<div
						class="col-lg-5 col-md-4 col-sm-5  col-xs-12  col-lg-offset-3 col-md-offset-3  col-sm-offset-3 ">
						<dir-pagination-controls></dir-pagination-controls>
					</div>
				</div>
			</div>
		</div>


		<script type="text/javascript">
			
		</script>

	</div>
</div>


<!-- /bloque de PASO de wizard -->
<!-- /bloque de wizard -->