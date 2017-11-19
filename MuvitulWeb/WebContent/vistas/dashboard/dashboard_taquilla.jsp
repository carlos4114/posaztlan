<div class="x_panel">
	<div class="x_title">
		<h2>
			<i class="fa fa-cog"></i> Reportes Taquilla
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
						<select class="form-control" name="cine" directiva-select2 required
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

			<div class="row" ng-if="cine !=null">
				<div class="col-md-12 col-sm-12 col-lg-12">
					<div class="x_panel">
						<div class="x_title">
							<h2>Ingresos semanales Taquilla</h2>

							<div class="clearfix"></div>
						</div>
						<div class="x_content">
							<canvas id="ingresoTaquilla"></canvas>
						</div>
					</div>
				</div>

				<div class="col-md-12 col-sm-12 col-lg-12">
					<div class="x_panel">
						<div class="x_title">
							<h2>Ingresos por Película</h2>

							<div class="clearfix"></div>
						</div>
						<div class="x_content">
							<canvas id="ingresosPelicula"></canvas>
						</div>
					</div>
				</div>
			</div>
			<div class="clearfix"></div>

			<div class="row" ng-if="cine !=null">

				<div class="col-md-12 col-sm-12 col-lg-12">
					<div class="x_panel">
						<div class="x_title">
							<h2>Asistencia promedio</h2>

							<div class="clearfix"></div>
						</div>
						<div class="x_content">
							<canvas id="asistenciaPromedio"></canvas>
						</div>
					</div>
				</div>
			</div>
		</form>

	</div>
	<!-- content -->
</div>
<!-- xpanel -->