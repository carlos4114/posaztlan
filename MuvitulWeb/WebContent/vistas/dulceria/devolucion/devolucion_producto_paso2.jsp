

<!-- Bootstrap -->
<!-- page content -->
<!-- bloque de wizard -->
<!-- bloque de PASO de wizard - CARTELERA -->
<div id="step-1">

	<div class="x_panel">
		<div class="x_title">
			<h2>
				<i class="fa fa-film"></i> Devolución Productos
			</h2>
				<div class="title_right">
					<div class="row pull-right"
						ng-init="">

						<button type="button" ng-click="asignarPaso(1)"
							class="btn btn-primary">
							<i class="fa fa-shopping-cart"></i> Consultar Ticket
						</button>

						<button type="button" ng-click="procesarDevolucion(devolucion)"
							ng-disabled="" class="btn btn-success">
							Confirmar Devolución<i class="fa fa-thumbs-o-up"></i>
						</button>

					</div>

					<div class="clearfix"></div>
				</div>
		</div>
		<div class="x_content">

			<div class="row">

				<div class="x_content">
					<form id="formDevolucion" name="formDevolucion" novalidate
						class="form-horizontal form-label-left">
						<!-- bloque de pelicula -->
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">

								<div class="row ">
									<div class="row col-md-6 col-sm-6 col-xs-12">

										<div class="form-group col-md-12 col-sm-6 col-xs-12"
											ng-class="{'has-error': formDevolucion.tipoDevolucion.$invalid && formDevolucion.tipoDevolucion.$dirty}">
											<label>Tipo de Devolución<span class="required">*</span>
											</label>
											<div class="input-group col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<select class=" form-control"  data-live-search="true"
													name="tipoDevolucion" required ng-disabled="disabledTipoDevolucion == true"
													ng-options="tipoDevolucion as tipoDevolucion.nombre for tipoDevolucion in listaTiposDevolucion"
													ng-model="devolucion.tipoDevolucionVO">
<!-- 													<option value="" selected="selected">Selecciona -->
<!-- 														tipo devolución</option> -->
												</select>
											</div>
											<div
												ng-show="formDevolucion.tipoDevolucion.$invalid && formDevolucion.tipoDevolucion.$dirty"
												ng-style="{color:'red'}">El campo es requerido.</div>
										</div>

										<div class="form-group col-md-12 col-sm-12 col-xs-12"
											ng-class="{'has-error': formDevolucion.motivoDevolucion.$invalid && formDevolucion.motivoDevolucion.$dirty}">
											<label>Motivo de Devolución<span class="required">*</span>
											</label>
											<div class="input-group col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<select class="select2_single form-control"  data-live-search="true"
													name="motivoDevolucion" required
													ng-options="motivoDevolucion as motivoDevolucion.nombre for motivoDevolucion in listaMotivosDevolucion"
													ng-model="devolucion.motivoDevolucionVO">
													<option value="" selected="selected">Selecciona
														motivo devolución</option>
												</select>
											</div>
											<div
												ng-show="formDevolucion.motivoDevolucion.$invalid && formDevolucion.motivoDevolucion.$dirty"
												ng-style="{color:'red'}">El campo es requerido.</div>
										</div>

										<div class="form-group "
											ng-class="{'has-error': formDevolucion.descripcionDevolucion.$invalid && formDevolucion.descripcionDevolucion.$dirty}">
											<label>Comentarios<span class="required">*</span>
											</label>
											<div
												class="input-group col-lg-12 col-md-12 col-sm-12 col-xs-12 ">
												<div class=" ">
													<textarea id="descripcionDevolucion" required
														class="form-control col-lg-12 col-md-12 col-sm-12 col-xs-12"
														name="descripcionDevolucion"
														ng-model="devolucion.comentarios"></textarea>
												</div>
											</div>
											<div
												ng-show="formDevolucion.descripcionDevolucion.$invalid && formDevolucion.descripcionDevolucion.$dirty"
												ng-style="{color:'red'}">El campo es requerido.</div>
										</div>


									</div>
									<div class="row col-md-3 col-sm-3 col-xs-12">
										<div class="form-group" ng-show="devolucion.tipoDevolucionVO.clave == 'EFE-002'">
											<div
												class="animated flipInY col-lg-12 col-md-12 col-sm-12 col-xs-12 col-lg-offset-12 col-md-offset-12  col-sm-offset-4 ">


												<div class="tile-stats">
													<h3 class="text-center">Importe Devolución</h3>
													<br />
													<h3 class="text-center">{{devolucion.importe | currency}}</h3>
												</div>


											</div>
										</div>
										
										<div class="form-group" ng-show="devolucion.tipoDevolucionVO.clave == 'PRO-001'">
											<div
												class="animated flipInY col-lg-12 col-md-12 col-sm-12 col-xs-12 col-lg-offset-12 col-md-offset-12  col-sm-offset-4 ">


												<div class="tile-stats">
													<h3 class="text-center">Devolución por Producto</h3>
													<br />
													<h3 class="text-center"> </h3>
												</div>


											</div>
										</div>
									</div>
								</div>

								<!-- /X9 columnas  -->

							</div>
							<!-- /xpanel PELICULA -->

<!-- 							<div class="row "> -->
<!-- 								<div class="form-group"> -->
<!-- 									<button type="submit" -->
<!-- 										class="col-lg-2 col-md-2 col-sm-2 col-xs-2 col-lg-offset-5 col-md-offset-5  col-sm-offset-5 col-xs-offset-5   btn btn-round btn-info" -->
<!-- 										ng-click="procesarDevolucion(devolucion)">Guardar</button> -->
<!-- 								</div> -->
<!-- 							</div> -->
						</div>
						<!-- /x12 columnas -->
					</form>
				</div>
			</div>


		</div>
	</div>
	<!-- Select2 -->
	<script>
		$(document).ready(function() {
			$(".select2_single").select2({
				language : "es",
				placeholder : "Seleccione una opción",
				allowClear : true
			});
			$(".select2_group").select2({
				language : "es"

			});
			$(".select2_multiple").select2({
				language : "es",
				maximumSelectionLength : 4,
				placeholder : "Seleccione una opción",
				allowClear : true
			});
		});
	</script>

</div>

<!-- /bloque de PASO de wizard -->
<!-- /bloque de wizard -->