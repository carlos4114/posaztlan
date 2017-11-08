
<div class="x_panel">
	<div class="x_title">
		<h2>
			<i class="fa fa-barcode"></i> Entradas de Inventario
		</h2>
		<div class="clearfix"></div>
	</div>
	<div class="x_content">
		<br />
		<div class="x_panel">
			<form id="formEntradas" name="formEntradas" data-parsley-validate
				class="form-horizontal form-label-left">

				<div class="col-md-1"></div>
				<div class="col-md-10">

					<div class="row">
						<div class="col-sm-3"></div>
						<div class="col-sm-6">
							<div class="form-group"
								ng-class="{'has-error': formEntradas.Articulo.$invalid && formEntradas.nombreArticulo.$dirty}">
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
									<label for="articulo">Artículo </label>									
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
									ng-class="{'has-error': formEntradas.tipoMovEntrada.$invalid && formEntradas.tipoMovEntrada.$dirty}">
									<label>Tipo de Entrada<span class="required">*</span>
									</label>
									<div class="input-group">
										<span class="input-group-addon"><i
											class="fa fa-sign-in"></i></span><select class="form-control"
											id="tipoMovEntrada" name="tipoMovEntrada" required="required" ng-required="true" 
											ng-options="tipoMovimiento as tipoMovimiento.nombre for tipoMovimiento in listaTiposMovimientosEntrada"
											ng-model="tipoEntrada">
											<option value="" selected="selected">Selecciona tipo de movimiento</option>
										</select>									
									</div>
									<div
											ng-show="formEntradas.tipoMovEntrada.$invalid && formEntradas.tipoMovEntrada.$dirty"
											ng-style="{color:'red'}">El tipo de movimiento es equerido.</div>
								</div>							
							</div>
							<div class="col-sm-3"></div>
						</div>
						
						<div class="row">
							<div class="col-sm-3"></div>
							<div class="col-sm-6">
								<div class="form-group"
									ng-class="{'has-error': formEntradas.proveedor.$invalid && formEntradas.proveedor.$dirty}">
									<label>Proveedor<span class="required">*</span>
									</label>
									<div class="input-group">
										<span class="input-group-addon"><i
											class="fa fa-truck"></i></span><select class="form-control"
											id="proveedor" name="proveedor" required="required" ng-required="true" 
											ng-options="proveedor.idProveedor as proveedor.nombre for proveedor in listaProveedores"
											ng-model="parametrosInventario.idProveedor">											
										</select>									
									</div>
									<div
											ng-show="formEntradas.proveedor.$invalid && formEntradas.proveedor.$dirty"
											ng-style="{color:'red'}">El proveedor es equerido.</div>
								</div>							
							</div>
							<div class="col-sm-3"></div>
						</div>						

						<div class="row">
							<div class="col-sm-3"></div>
							<div class="col-sm-6">
								<div class="form-group"
									ng-class="{'has-error': formEntradas.cantidadEntrada.$invalid && formEntradas.cantidadEntrada.$dirty}">
									<label class="control-label col-md-3 col-sm-3 col-xs-12"
										for="cantidadEntrada">Cantidad de Entrada<span class="required">*</span>
									</label>
									<div class="col-md-7 col-sm-7 col-xs-12">									
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-cubes"></i></span>
											<input type="number" id="cantidadEntrada" name="cantidadEntrada"
												ng-required="true" class="form-control col-md-7 col-xs-12"
												placeholder="0" ng-model="parametrosInventario.cantidad">
											<span class="input-group-btn">
												&nbsp; {{movimientoInventario.articulo.unidadMedidaVO.nombre}}.
											</span>
										</div>																							
										<div
											ng-show="formEntradas.cantidadEntrada.$invalid && formEntradas.cantidadEntrada.$dirty"
											ng-style="{color:'red'}">La cantidad de entrada es requerida.</div>
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
									ng-class="{'has-error': formEntradas.importe.$invalid && formEntradas.importe.$dirty}">
									<label class="control-label col-md-3 col-sm-3 col-xs-12"
										for="importe">Importe<span class="required">*</span>
									</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-usd"></i></span>
											<input type="number" id="importe" name="importe"
												ng-required="true" class="form-control col-md-7 col-xs-12"
												placeholder="0" ng-model="parametrosInventario.importe">
										</div>		
										<div
											ng-show="formEntradas.importe.$invalid && formEntradas.importe.$dirty"
											ng-style="{color:'red'}">El importe es requerido.</div>
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
									<label class="control-label col-md-3 col-sm-3 col-xs-12"">Documento<span></span>
									</label>
									<div class="col-md-6 col-sm-6 col-xs-12">	
										<div class="input-group">
											<label class="import-file"> 
											<input type="file"
												ngf-select id="archivo" name="archivo"
												ngf-change="setArchivo($file)" accept=".pdf,.jpg,.png,.jpeg,.doc,.docx,.xls,.xlsx">
											</label>
										</div>
									</div>
								</div>
							</div>
							<div class="col-sm-3"></div>
						</div>
						
						<div class="row">
							<div class="col-sm-3"></div>
							<div class="col-sm-6">
								<div class="form-group">
									<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
										<button type="submit" class="btn btn-success"
											ng-click="confirmacionEntrada()">
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