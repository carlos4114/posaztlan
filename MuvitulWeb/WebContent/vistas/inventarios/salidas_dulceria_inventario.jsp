
<div class="x_panel">
	<div class="x_title">
		<h2>
			<i class="fa fa-barcode"></i> Salidas de Inventario
		</h2>
		<div class="clearfix"></div>
	</div>
	<div class="x_content">
		<br />
		<div class="x_panel">
			<form id="formSalidas" name="formSalidas" data-parsley-validate
				class="form-horizontal form-label-left">

				<div class="col-md-1"></div>
				<div class="col-md-10">

					<div class="row">
						<div class="col-sm-3"></div>
						<div class="col-sm-6">
							<div class="form-group"
								ng-class="{'has-error': formSalidas.Articulo.$invalid && formSalidas.nombreArticulo.$dirty}">
								<label>Artículo <span class="required">*</span>
								</label>
								<div class="input-group">
									<span class="input-group-addon"><i
										class="fa fa-search"></i></span> <input type="text"
										name="nombreArticulo" class="form-control"
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

					<div ng-show="activeForm">
						<div class="row">
							<div class="col-sm-3"></div>
							<div class="col-sm-6">
								<div class="form-group">
									<label class="control-label"
										for="cantidad">Artículo </label>									
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-cube"></i></span>
												<input type="text" id="articulo" readonly="readonly"
													class="form-control col-md-7 col-xs-12" placeholder="0"
													ng-model="movimientoInventario.articulo.nombre">
										</div>									
								</div>
							</div>
							<div class="col-sm-3"></div>
						</div>
						
						<div class="row">
							<div class="col-sm-3"></div>
							<div class="col-sm-6">
								<div class="form-group"
									ng-class="{'has-error': formSalidas.tipoMovSalida.$invalid && formSalidas.tipoMovSalida.$dirty}">
									<label>Tipo de Salida<span class="required">*</span>
									</label>
									<div class="input-group">
										<span class="input-group-addon"><i
											class="fa fa-sign-in"></i></span><select class="form-control"
											id="tipoMovSalida" name="tipoMovSalida" required="required" ng-required="true" 
											ng-options="tipoMovimiento as tipoMovimiento.nombre for tipoMovimiento in listaTiposMovimientosSalida"
											ng-model="tipoSalida" ng-change="validateTipoMovimiento()">
											<option value="" selected="selected">Selecciona tipo de movimiento</option>
										</select>									
									</div>
									<div
											ng-show="formSalidas.tipoMovSalida.$invalid && formSalidas.tipoMovSalida.$dirty"
											ng-style="{color:'red'}">El tipo de movimiento es equerido.</div>
								</div>							
							</div>
							<div class="col-sm-3"></div>
						</div>
						
						<div class="row" ng-show="activeProveedor">
							<div class="col-sm-3"></div>
							<div class="col-sm-6">
								<div class="form-group"
									ng-class="{'has-error': formSalidas.listProveedor.$invalid && formSalidas.listProveedor.$dirty}">
									<label>Proveedor<span class="required">*</span>
									</label>
									<div class="input-group">
										<span class="input-group-addon"><i
											class="fa fa-sign-in"></i></span><select class="form-control"
											id="listProveedor" name="listProveedor" required="required"
											ng-options="inventario as inventario.proveedor.nombre for inventario in listaArticulosExistencia"
											ng-model="inventario"  ng-change="actualizaExistencia(inventario)">
											<option value="" selected="selected">Selecciona proveedor</option>
										</select>									
									</div>
									<div
											ng-show="formSalidas.listProveedor.$invalid && formSalidas.listProveedor.$dirty"
											ng-style="{color:'red'}">El proveedor es equerido.</div>
								</div>							
							</div>
							<div class="col-sm-3"></div>
						</div>
						
						<div class="row" ng-show="activePuntoVentaDestino" >
							<div class="col-sm-3"></div>
							<div class="col-sm-6">

								<div class="form-group" 
									ng-class="{'has-error': formSalidas.puntoVentaDes.$invalid && formSalidas.puntoVentaDes.$dirty}">
									<label class="control-label"
										for="puntoVentaDes">Punto de Venta Destino<span>*</span>
									</label>
									<div class="input-group">
										<span class="input-group-addon"><i
											class="fa fa-cart-arrow-down"></i></span><select class="form-control"
											id="puntoVentaDes" name="puntoVentaDes" 
											ng-options="puntoVenta.idPuntoVenta as puntoVenta.nombre for puntoVenta in listaPuntosVenta"
											ng-model="parametrosInventario.idPuntoVentaConsigna">	
											<option value="" selected="selected">Selecciona punto de venta destino</option>										
										</select>										
									</div>
									<div
											ng-show="formSalidas.puntoVentaDes.$invalid && formSalidas.puntoVentaDes.$dirty"
											ng-style="{color:'red'}">El punto de venta destino es equerido.</div>
								</div>
								<br />
							</div>
							<div class="col-sm-3"></div>
						</div>
						
						<div class="row">
							<div class="col-sm-3"></div>
							<div class="col-sm-6">
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12"
										for="existencia">Existencia Actual</label>
									<div class="col-md-7 col-sm-7 col-xs-12">
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-cubes"></i></span>
											<input type="text" id="existencia" readonly="readonly"
												class="form-control col-md-7 col-xs-12" placeholder="0"
												ng-model="movimientoInventario.existenciaActual">
											<span class="input-group-btn">
												&nbsp; {{movimientoInventario.articulo.unidadMedidaVO.nombre}}.
											</span>
										</div>		
									</div>									
								</div>
								<br />
							</div>
							<div class="col-sm-3"></div>
						</div>

						<div class="row">
							<div class="col-sm-3"></div>
							<div class="col-sm-6">
								<div class="form-group"
									ng-class="{'has-error': formSalidas.cantidadSalida.$invalid && formSalidas.cantidadSalida.$dirty}">
									<label class="control-label col-md-3 col-sm-3 col-xs-12"
										for="cantidadSalida">Cantidad de Salida<span class="required">*</span>
									</label>
									<div class="col-md-7 col-sm-7 col-xs-12">
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-cubes"></i></span>
											<input type="number" id="cantidadSalida" name="cantidadSalida"
												ng-required="true" class="form-control col-md-7 col-xs-12"
												placeholder="0" ng-model="parametrosInventario.cantidad">
											<span class="input-group-btn">
												&nbsp; {{movimientoInventario.articulo.unidadMedidaVO.nombre}}.
											</span>
										 </div>		
										<div
											ng-show="formSalidas.cantidadSalida.$invalid && formSalidas.cantidadSalida.$dirty"
											ng-style="{color:'red'}">La cantidad de salida es
											requerida.</div>
									</div>
									
								</div>

								<br />
							</div>
							<div class="col-sm-3"></div>
						</div>						

						<div class="row">
							<div class="col-sm-3"></div>
							<div class="col-sm-6">
								<div class="form-group">
									<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
										<button type="submit" class="btn btn-success"
											ng-click="confirmacionSalida()" ng-disabled="movimientoInventario.existenciaActual == 0">
											<i class="fa fa-line-chart"></i> Guardar
										</button>
									</div>
								</div>
							</div>
							<div class="col-sm-3"></div>

						</div>
					</div>
				</div>
				<div class="col-md-1"></div>
			</form>
		</div>

	</div>
	<!-- content -->
</div>
<!-- xpanel -->

<!-- modal -->
<div class="modal fade" id="modalArticulos" role="dialog"
	style="overflow-y: auto;" data-keyboard="false" data-backdrop="static">
	<div class="modal-dialog modal-lg">

		<!-- Modal content-->
		<div class="modal-content"
			style="width: 100%; min-width: 280px; margin: auto;">

			<div class="modal-header bg-red-active">
				<div class="box-header text-center">
					<button type="button" class="close" data-dismiss="modal"
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
								</tr>
							</thead>

							<tbody>
								<tr
									dir-paginate="movimientoInventarioVO in listaArticulos |  filter: filterSearch |itemsPerPage: listaArticulos.length  "
									ng-click="setDatosDeArticulo(movimientoInventarioVO)"
									style="cursor: pointer; cursor: hand;" data-dismiss="modal">
									<td class="text-center">{{movimientoInventarioVO.articulo.idArticulo}}</td>
									<td class="text-center">{{movimientoInventarioVO.articulo.nombre}}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>
<!-- modal -->