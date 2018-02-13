<div class="x_panel">
	<div class="x_title">
		<h2>
			<i class="fa fa-cog"></i> Reportes Dulcería
		</h2>
		<div class="clearfix"></div>
	</div>
	<div class="x_content">
		<div class="clearfix"></div>

		<form id="formDashboardDulceria" name="formDashboardDulceria"
			novalidate>
			<div class="row">


				<div
					class="form-group col-lg-4 col-md-4 col-sm-4 col-xs-12 col-lg-offset-4 col-md-offset-4 col-sm-offset-4 "
					ng-class="{'has-error': formDashboardDulceria.cine.$invalid && formDashboardDulceria.cine.$dirty}">
					<label>Cine<span class="required">*</span>
					</label>
					<div class="input-group col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<select class="form-control" name="cine"  directiva-select2  required
							ng-change="consultarGraficas(cine.idCine)"
							ng-options="cine as cine.nombre for cine in listaCines"
							ng-model="cine">
							<option value="" selected="selected">Selecciona un cine
							</option>
						</select>
					</div>
					<div
						ng-show="formDashboardDulceria.cine.$invalid && formDashboardDulceria.cine.$dirty"
						ng-style="{color:'red'}">El campo es requerido.</div>
				</div>
			</div>



			<div class="row" >
				<div class="col-xs-12 col-md-12 col-sm-12 col-lg-12" ng-show="cine">
					<div class="x_panel">
						<div class="x_title">
							<h2>Ingresos Dulcería</h2>

							<div class="clearfix"></div>
						</div>
						<div class="x_content">
							<canvas id="ingresoDulceria"></canvas>
						</div>
					</div>
				</div>

				<div class="col-xs-12 col-md-12 col-sm-12 col-lg-12"  >
					<div class="x_panel">
						<div class="x_title">
							<h2>Rentabilidad últimos 30 días</h2>

							<div class="clearfix"></div>
						</div>
						<div class="x_content">
							<canvas id="asistenciaPromedio"></canvas>
						</div>
					</div>
				</div>
			</div>

			<div class="row" ng-show="cine" >

				<div class="col-md-6 col-sm-6 col-xs-12">
					<div class="x_panel">
						<div class="x_title">
							<h2>10 + Vendidos</h2>

							<div class="clearfix"></div>
						</div>
						<div class="x_content">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>#</th>
										<th>Producto</th>
										<th>% Rentabilidad</th>
										<th>Unidad x Ticket</th>
									</tr>
								</thead>
								<tbody>
									<tr class="odd pointer"
										ng-repeat="masVendidos in listaMasVendidos">
										<th scope="row">{{masVendidos.consecutivo}}</th>
										<td class="text-center">{{masVendidos.nombre}}</td>
										<td class="text-center">{{masVendidos.rentabilidad}}</td>
										<td class="text-center">{{masVendidos.unidadXTicket}}</td>
									</tr>
									<tr ng-if="listaMasVendidos==null">
										<td class="text-center" colspan="4">No existen registros.</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>


				<div class="col-md-6 col-sm-6 col-xs-12">
					<div class="x_panel">
						<div class="x_title">
							<h2>10 - Vendidos</h2>

							<div class="clearfix"></div>
						</div>
						<div class="x_content">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>#</th>
										<th>Producto</th>
										<th>% Rentabilidad</th>
										<th>Unidad x Ticket</th>
									</tr>
								</thead>
								<tbody>
									<tr class="odd pointer"
										ng-repeat="menosVendidos in listaMenosVendidos">
										<th scope="row">{{menosVendidos.consecutivo}}</th>
										<td class="text-center">{{menosVendidos.nombre}}</td>
										<td class="text-center">{{menosVendidos.rentabilidad}}</td>
										<td class="text-center">{{menosVendidos.unidadXTicket}}</td>
									</tr>
									<tr ng-if="listaMenosVendidos==null">
										<td class="text-center" colspan="4">No existen registros.</td>
									</tr>
								</tbody>
							</table>

						</div>
					</div>
				</div>




			</div>
			<div class="clearfix"></div>


			<div class="row" ng-show="cine !=null">

				<div class="col-md-6 col-sm-6 col-xs-12">
					<div class="x_panel">
						<div class="x_title">
							<h2>10 + Rentables</h2>

							<div class="clearfix"></div>
						</div>
						<div class="x_content">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>#</th>
										<th>Producto</th>
										<th>% Rentabilidad</th>
										<th>Unidad x Ticket</th>
									</tr>
								</thead>


								<tbody>
									<tr class="odd pointer"
										ng-repeat="masRentables in listaMasRentables">
										<th scope="row">{{masRentables.consecutivo}}</th>
										<td class="text-center">{{masRentables.nombre}}</td>
										<td class="text-center">{{masRentables.rentabilidad}}</td>
										<td class="text-center">{{masRentables.unidadXTicket}}</td>
									</tr>
									<tr ng-if="listaMasRentables == null">
										<td class="text-center" colspan="4">No existen registros.</td>
									</tr>
								</tbody>
							</table>

						</div>
					</div>
				</div>


				<div class="col-md-6 col-sm-6 col-xs-12">
					<div class="x_panel">
						<div class="x_title">
							<h2>10 - Rentables</h2>

							<div class="clearfix"></div>
						</div>
						<div class="x_content">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>#</th>
										<th>Producto</th>
										<th>% Rentabilidad</th>
										<th>Unidad x Ticket</th>
									</tr>
								</thead>
								
								<tbody>
									<tr class="odd pointer"
										ng-repeat="menosRentables in listaMenosRentables">
										<th scope="row">{{menosRentables.consecutivo}}</th>
										<td class="text-center">{{menosRentables.nombre}}</td>
										<td class="text-center">{{menosRentables.rentabilidad}}</td>
										<td class="text-center">{{menosRentables.unidadXTicket}}</td>
									</tr>
									<tr ng-if="listaMenosRentables == null">
										<td class="text-center" colspan="4">No existen registros.</td>
									</tr>
								</tbody>
							</table>

						</div>
					</div>
				</div>


			</div>

		</form>
		<div class="clearfix"></div>

	</div>
	<!-- content -->
</div>
<!-- xpanel -->