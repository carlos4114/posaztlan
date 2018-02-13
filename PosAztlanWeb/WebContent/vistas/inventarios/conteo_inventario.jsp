<div class="x_panel">
	<div class="x_title">
		<h2>
			<i class="fa fa-barcode"></i> Conteo de Inventario
		</h2>
		<div class="clearfix"></div>
	</div>
	<div class="x_content">
		<br />
		<div class="x_panel">		

				<div class="col-md-1"></div>
				<div class="col-md-10">

					<div class="row">
						<div class="col-sm-3"></div>
						<div class="col-sm-6">
							<div class="form-group">
								<label>Artículo <span class="required">*</span>
								</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-search"></i></span>
									<input type="text" name="nombreArticulo" class="form-control"
										placeholder="Buscar articulo..."
										ng-model="parametroBusqueda.articulo"> <span
										class="input-group-btn">
										<button class="btn btn-default" type="button"
											ng-click="buscarArticulos()" data-toggle="modal"
											data-target="#modalArticulos">Ir!</button>
									</span>
								</div>
							</div>
						</div>
						<div class="col-sm-3"></div>
					</div>

					<div class="row" ng-show="listaConteoArticulos.length > 0">
						<div class="col-sm-1"></div>
						<div class="col-sm-10">
							<!-- table-responsive -->
							<div class="table-responsive">
								<h3 class="text-center">Conteos</h3>
								<table class="table table-striped jambo_table bulk_action">
									<thead>
										<tr class="headings">
											<th class="column-title text-center">Artículo</th>
											<th class="column-title text-center">Existencia Sistema</th>
											<th class="column-title text-center">Existencia Física</th>
											<th class="column-title text-center">Unidad de Medida</th>
											<th class="column-title text-center">Tipo Movimiento</th>
											<th class="column-title text-center">Acción</th>
										</tr>
									</thead>

									<tbody>
										<tr class="even pointer" ng-repeat="conteo in listaConteoArticulos">
											<form id="formMovimiento_{{conteo.idArticuloCorte}}" name="formMovimiento_{{conteo.idArticuloCorte}}" data-parsley-validate
												class="form-horizontal form-label-left"	>
													<td class=" ">{{conteo.articulo.nombre}}</td>
													<td class="text-center">{{conteo.existenciaSistema}}</td>
													<td class="text-center" data-dismiss="modal" data-toggle="modal" data-target="#modalArticulos"
														ng-click="setDatosConteoArticuloUpdate(conteo)"> <a href="">{{conteo.existenciaFisica}} <i class="fa fa-pencil-square-o" aria-hidden="true"></i></a></td>
													<td class="text-center">{{conteo.articulo.unidadMedidaVO.nombre}}</td>	
													<td class="text-center">														
														<div ng-show="conteo.existenciaSistema == conteo.existenciaFisica" ng-style="{color:'#143658'}">Sin diferiencia</div>
														<div ng-show="conteo.existenciaSistema > conteo.existenciaFisica" ng-style="{color:'#143658'}">Realizar salida de inventario</div>
														<div ng-show="conteo.existenciaSistema < conteo.existenciaFisica" ng-style="{color:'#143658'}">Realizar entrada de inventario</div>
													</td>
													<td class="text-center" ng-show="conteo.existenciaSistema != conteo.existenciaFisica">
														<button type="submit" class="btn btn-success"
															ng-click="confirmacionMovimiento(conteo)"
															ng-disabled="movimientoInventario.existenciaActual == 0">
															<i class="fa fa-exchange"></i> Ajustar
														</button>
													</td>
													<td class="text-center" ng-show="conteo.existenciaSistema == conteo.existenciaFisica">
														<i class="fa fa-check-circle-o" aria-hidden="true" style="font-size:25px;color:#3379b5;"></i>
													</td>													
											</form>
										</tr>
									</tbody>
								</table>
							</div>
							<!-- table-responsive -->
						</div>
						<div class="col-sm-1"></div>
					</div>
					<div class="row" ng-show="listaConteoArticulos.length > 0">
						<div class="col-sm-5"></div>
						<div class="col-sm-2">
						<button type="submit" class="btn btn-success"
							ng-click="confirmacionFinalizaConteoArticulo()">
							<i class="fa fa-check-circle"></i>Finalizar Conteo
						</button>
					</div>
						<div class="col-sm-5"></div>
					</div>	
		</div>
		<div class="col-md-1"></div>
	</div>

</div>
<!-- content -->
</div>
<!-- xpanel -->

<!-- modal articulos-->
<div class="modal fade" id="modalArticulos" role="dialog"
	style="overflow-y: auto;" data-keyboard="false" data-backdrop="static">
	<div class="modal-dialog">

		<!-- Modal content 1 -->
		<div class="modal-content"
			style="width: 100%; min-width: 280px; margin: auto;"
			ng-show="!showFormConteoArticuloCreate">

			<div class="modal-header bg-red-active">
				<div class="box-header text-center">
					<button type="button" id="btnCloseModal" class="close" data-dismiss="modal"
						ng-click="reset()" style="color: blue;">&times;</button>
					<h3 class="box-title">Seleccione</h3>
				</div>
			</div>
			<div class="box-body table-responsive no-padding">
				<div class="col-xs-12">
					<div style="display: block; overflow: auto;">
						<table id="datatable-productos" class="table table-hover"
							cellspacing="0" width="100%">
							<thead>
								<tr>
									<th class="text-center">Id</th>
									<th class="text-center">Articulo</th>
									<th class="text-center">Existencia</th>
								</tr>
							</thead>

							<tbody>
								<tr
									dir-paginate="movimientoInventarioVO in listaArticulos |  filter: filterSearch |itemsPerPage: listaArticulos.length  "
									ng-click="setDatosConteoArticuloCreate(movimientoInventarioVO)"
									style="cursor: pointer; cursor: hand;">
									<td class="text-center">{{movimientoInventarioVO.articulo.idArticulo}}</td>
									<td class="text-center">{{movimientoInventarioVO.articulo.nombre}}</td>
									<td class="text-center">{{movimientoInventarioVO.existenciaActual}}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<!-- Fin Modal content 1-->

		<!-- Modal content 2-->

		<div class="modal-content" ng-show="showFormConteoArticuloCreate">
			<div class="modal-header  bg-red-thunderbird bg-font-red-thunderbird">
				<div class="modal-header bg-red-active">
					<div class="box-header text-center">
						<button type="button" id="btnCloseModal" class="close" data-dismiss="modal"
							ng-click="reset()" style="color: blue;">&times;</button>
						<h4 class="modal-title">{{nombreArticulo}}</h4>
					</div>
				</div>
				<div class="modal-body">
					<div class="container">
						<form id="formConteo" name="formConteo" data-parsley-validate
							class="form-horizontal form-label-left">
							<div class="form-group"
								ng-class="{'has-error': formConteo.existenciaFisica.$invalid && formConteo.existenciaFisica.$dirty}">
								<label class="control-label col-md-3 col-sm-3 col-xs-6"
									for="existenciaFisica">Existencia Física<span
									class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-6">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-cubes"></i></span>
										<input type="number" id="existenciaFisica"
											name="existenciaFisica" ng-required="true"
											class="form-control col-md-7 col-xs-12" placeholder="0"
											ng-model="parametrosInventario.existenciaFisica"> <span
											class="input-group-btn"> &nbsp;
											{{movimientoInventario.articulo.unidadMedidaVO.nombre}}. </span>
									</div>
									<div
										ng-show="formConteo.existenciaFisica.$dirty && formConteo.existenciaFisica.$invalid"
										ng-style="{color:'red'}">La existencia es requerida.</div>
								</div>
								<div class="boton col-md-2 col-sm-2 col-xs-6">
									<button class="btn btn-circle btn-danger" type="button" data-dismiss="modal"
										ng-click="guardaConteoArticulo()">Guardar</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<div class="container">
<!-- 						<div class="boton"> -->
<!-- 							<button class="btn btn-circle btn-danger" type="button" -->
<!-- 								ng-click="reset()">Cancelar</button> -->
<!-- 						</div> -->
					</div>
				</div>
			</div>

			<!-- Fin Modal content 2-->
		</div>
	</div>
	<!-- modal -->