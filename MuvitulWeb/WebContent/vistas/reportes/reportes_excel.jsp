
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
												directiva-select2 select-width="300px"
												ng-model="reporteVO.tipoReporte" required name="tipoReporte"
												ng-change="resetFormulario()">
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


								<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12"
									ng-if="reporteVO.tipoReporte.codigo == 'KARDEX'">
									<div class="form-group"
										ng-class="{'has-error': formReportes.fechaInicio.$invalid && formReportes.fechaInicio.$dirty}">
										<label>Fecha Inicio <span class="required">*</span>
										</label>
										<div class="input-group">
											<span class="input-group-addon"><i
												class="fa fa-calendar"></i></span><input type="text" fecha required
												id="fechaInicio" name="fechaInicio"
												ng-model="reporteVO.fechaInicio"
												class="form-control col-md-7 col-xs-12">
										</div>
										<div
											ng-show="formReportes.fechaInicio.$invalid && formReportes.fechaInicio.$dirty"
											ng-style="{color:'red'}">El campo es requerido.</div>
									</div>
								</div>

								<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12"
									ng-if="reporteVO.tipoReporte.codigo == 'KARDEX'">
									<div class="form-group"
										ng-class="{'has-error': formReportes.fechaFin.$invalid && formReportes.fechaFin.$dirty}">
										<label>Fecha Fin <span class="required">*</span>
										</label>
										<div class="input-group">
											<span class="input-group-addon"><i
												class="fa fa-calendar"></i></span> <input type="text" fecha
												mindate="reporteVO.fechaInicio" required id="fechaFin"
												name="fechaFin" ng-model="reporteVO.fechaFin"
												class="form-control col-md-7 col-xs-12">
										</div>
										<div
											ng-show="formReportes.fechaFin.$invalid && formReportes.fechaFin.$dirty"
											ng-style="{color:'red'}">El campo es requerido.</div>
									</div>
								</div>

								<div
									class="form-group col-lg-4 col-md-4 col-sm-4 col-xs-12 col-lg-offset-2 col-md-offset-4 col-sm-offset-4 "
									ng-class="{'has-error': formReportes.articulos.$invalid && formReportes.articulos.$dirty}"
									ng-if="reporteVO.tipoReporte.codigo == 'KARDEX'">
									<label>Cine<span class="required">*</span>
									</label>
									<div
										class="input-group col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<select class="form-control" name="articulos"
											directiva-select2 select-width="300px" required
											ng-options="articulo as articulo.nombre for articulo in listaArticulos"
											ng-model="reporteVO.articulo">
											<option value="" selected="selected">Selecciona un
												articulo</option>
										</select>
									</div>
									<div
										ng-show="formReportes.articulos.$invalid && formReportes.articulos.$dirty"
										ng-style="{color:'red'}">El campo es requerido.</div>
								</div>

								<div
									class="col-lg-6 col-md-6 col-sm-12 col-xs-12  col-lg-offset-3 col-md-offset-3 col-sm-offset-3"
									ng-if="reporteVO.tipoReporte.codigo == 'VENTAS-DIA'">
									<div class="form-group"
										ng-class="{'has-error': formReportes.fechaFin.$invalid && formReportes.fechaFin.$dirty}">
										<label>Fecha <span class="required">*</span>
										</label>
										<div class="input-group">
											<span class="input-group-addon"><i
												class="fa fa-calendar"></i></span> <input type="text" fecha
												required id="fechaFin" name="fechaFin"
												ng-model="reporteVO.fechaFin"
												class="form-control col-md-7 col-xs-12">
										</div>
										<div
											ng-show="formReportes.fechaFin.$invalid && formReportes.fechaFin.$dirty"
											ng-style="{color:'red'}">El campo es requerido.</div>
									</div>
								</div>

								<div
									class="col-lg-6 col-md-6 col-sm-12 col-xs-12 col-lg-offset-3 col-md-offset-3 col-sm-offset-3 "
									ng-if="reporteVO.tipoReporte.codigo == 'VENTAS-SEMANA'">
									<div class="form-group"
										ng-class="{'has-error': formReportes.fechaFin.$invalid && formReportes.fechaFin.$dirty}">
										<label>Fecha Inicio <span class="required">*</span>
										</label>
										<div class="input-group">
											<span class="input-group-addon"><i
												class="fa fa-calendar"></i></span> <input type="text"
												calendar-dias-activos required id="fechaFin" name="fechaFin"
												ng-model="reporteVO.fechaFin"
												class="form-control col-md-7 col-xs-12">
										</div>
										<div
											ng-show="formReportes.fechaFin.$invalid && formReportes.fechaFin.$dirty"
											ng-style="{color:'red'}">El campo es requerido.</div>
									</div>
								</div>

								<div
									class="col-lg-6 col-md-6 col-sm-12 col-xs-12 col-lg-offset-3 col-md-offset-3 col-sm-offset-3"
									ng-if="reporteVO.tipoReporte.codigo == 'VENTAS-MENSUAL'">
									<div class="form-group"
										ng-class="{'has-error': formReportes.fechaFin.$invalid && formReportes.fechaFin.$dirty}">
										<label>Fecha <span class="required">*</span>
										</label>
										<div class="input-group">
											<span class="input-group-addon"><i
												class="fa fa-calendar"></i></span> <input type="text"
												calendar-month required id="fechaFin" name="fechaFin"
												ng-model="reporteVO.fechaFin"
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

<!-- 							<div class="container"> -->
<!-- 								<div class="row"> -->
<!-- 									<div class="col-sm-6 form-group"> -->
<!-- 										<div class="input-group" id="DateDemo"> -->
<!-- 											<input type='text' id='weeklyDatePicker' test -->
<!-- 												placeholder="Select Week" /> -->
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</div> -->


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
<script>
	$(document).ready(
			function() {

				//Initialize the datePicker(I have taken format as mm-dd-yyyy, you can     //have your owh)
				$("#weeklyDatePicker").datetimepicker({
					format : 'MM/DD/YYYY',
					locale: 'es'
				});

				//Get the value of Start and End of Week
				$('#weeklyDatePicker').on(
						'dp.change',
						function(e) {
							var value = $("#weeklyDatePicker").val();
							var firstDate = moment(value, "MM/DD/YYYY").day(0)
									.format("MM/DD/YYYY");
							var lastDate = moment(value, "MM/DD/YYYY").day(6)
									.format("MM/DD/YYYY");
							$("#weeklyDatePicker").val(
									firstDate + " - " + lastDate);
						});
			});
</script>
<style>
.bootstrap-datetimepicker-widget tr:hover {
    background-color: #808080;
}

</style>

