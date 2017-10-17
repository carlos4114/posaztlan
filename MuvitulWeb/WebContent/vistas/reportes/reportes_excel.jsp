
<div class="x_panel">
	<div class="x_title">
		<h2>
			<i class="fa fa-cog"></i> Reportes
		</h2>
		<div class="clearfix"></div>
	</div>
	<div class="x_content">
		<div class="clearfix"></div>

		<div class="row">

			<div
				class="col-xs-12 col-md-6 col-sm-6 col-lg-6 col-lg-offset-3 col-md-offset-3 col-sm-offset-3">
				<div class="x_panel">

					<div class="x_content">
						<br>
						<form id="formReportes" name="formReportes" novalidate>


							<div class="row">
								<div
									class="col-lg-6 col-md-6 col-sm-12 col-xs-12  col-md-offset-3 ">
									<div class="form-group"
										ng-class="{'has-error': formReportes.tipoReporte.$invalid && formReportes.tipoReporte.$dirty}">
										<label>Tipo Reporte<span class="required">*</span>
										</label>
										<div class="input-group col-xs-12 ">
											<select class="form-control" id="tipoReporte"
												ng-options="reporte as reporte.nombre for reporte  in listaTipoReporte"
												ng-model="reporte.tipoReporte" required name="tipoReporte">
												<option value="" selected="selected">Selecciona
													Reporte</option>
											</select>
										</div>
										<div
											ng-show="formReportes.tipoReporte.$invalid && formReportes.tipoReporte.$dirty"
											ng-style="{color:'red'}">El campo es requerido.</div>
									</div>
								</div>
							</div>


							<div class="row  ">


								<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12  ">
									<div class="form-group"
										ng-class="{'has-error': formReportes.fechaInicio.$invalid && formReportes.fechaInicio.$dirty}">
										<label>Fecha Inicio <span class="required">*</span>
										</label>
										<div class="input-group">
											<span class="input-group-addon"><i
												class="fa fa-calendar"></i></span><input type="text"
												date-range-picker-dos required  id="fechaInicio" name="fechaInicio"
												 ng-model="reporte.fechaInicio"
												class="form-control col-md-7 col-xs-12">
										</div>
										<div
											ng-show="formReportes.fechaInicio.$invalid && formReportes.fechaInicio.$dirty"
											ng-style="{color:'red'}">El campo es requerido.</div>
									</div>
								</div>

								<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12  ">
									<div class="form-group"
										ng-class="{'has-error': formReportes.fechaFin.$invalid && formReportes.fechaFin.$dirty}">
										<label>Fecha Fin <span class="required">*</span>
										</label>
										<div class="input-group">
											<span class="input-group-addon"><i
												class="fa fa-calendar"></i></span> <input type="text"
												date-range-picker-dos required  id="fechaFin" name="fechaFin"
												ng-model="reporte.fechaFin" 
												class="form-control col-md-7 col-xs-12">
										</div>
										<div
											ng-show="formReportes.fechaFin.$invalid && formReportes.fechaFin.$dirty"
											ng-style="{color:'red'}">El campo es requerido.</div>
									</div>
								</div>
							</div>

							<div class="form-group">
								<div
									class="col-md-9 col-sm-9 col-xs-12 col-sm-offset-5   col-md-offset-5 col-lg-offset-5">
									<button type="submit" class="btn btn-success"
										ng-click="consultarReporte(reporte )">Buscar</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="clearfix"></div>

	</div>
	<!-- content -->
</div>
<!-- xpanel -->


