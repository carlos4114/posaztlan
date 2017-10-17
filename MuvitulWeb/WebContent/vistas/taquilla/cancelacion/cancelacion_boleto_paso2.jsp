
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Venta Boleto</title>

</head>
<body>

	<!-- Bootstrap -->
	<!-- page content -->
	<!-- bloque de wizard -->
	<!-- bloque de PASO de wizard - CARTELERA -->
	<div id="step-1">

		<div class="x_panel">
			<div class="x_title">
				<h2>
					<i class="fa fa-film"></i> Cancelación Pagos
				</h2>
				
				<div class="title_right">
					<div class="row pull-right"
						ng-init="">

						<button type="button" ng-click="asignarPaso(1)"
							class="btn btn-primary">
							<i class="fa fa-shopping-cart"></i> Consultar Ticket
						</button>

						<button type="button" ng-click="procesarCancelacion(cancelacion)"
							ng-disabled="" class="btn btn-success">
							Confirmar Cancelación<i class="fa fa-thumbs-o-up"></i>
						</button>

					</div>

					<div class="clearfix"></div>
				</div>

			</div>
			
			<div class="x_content">

				<div class="row">

					<div class="x_content">

						<!-- bloque de pelicula -->
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">

								<form id="formPagos" name="formPagos" role="form" novalidate
									class="form-horizontal form-label-left">
									<div class="row  col-lg-12 col-md-12 col-sm-12 col-xs-12">


										<div
											class="animated flipInY col-lg-3 col-md-3 col-sm-3 col-xs-12 col-lg-offset-1 col-md-offset-1 col-sm-offset-1 ">

											<div class="tile-stats">
												<h3 class="text-center">Monto a Cubrir</h3>
												<br>
												<h3 class="text-center ng-binding">{{
													pago.montoCancelado | currency}}</h3>

												<br>
												<h3 class="text-center"></h3>
											</div>

										</div>
										<div
											class="animated flipInY col-lg-3 col-md-3 col-sm-3 col-xs-12 col-lg-offset-1 col-md-offset-1 col-sm-offset-1 ">

											<div class="tile-stats">
												<h3 class="text-center">Pagado</h3>
												<br>
												<h3 class="text-center ng-binding">{{ pago.pagado |
													currency}}</h3>

												<br>
												<h3 class="text-center"></h3>
											</div>

										</div>
										<div
											class="animated flipInY col-lg-3 col-md-3 col-sm-3 col-xs-12 col-lg-offset-1 col-md-offset-1 col-sm-offset-1 ">

											<div class="tile-stats">
												<h3 class="text-center">Por Pagar</h3>
												<br>
												<h3 class="text-center ng-binding">{{ pago.porPagar |
													currency}}</h3>

												<br>
												<h3 class="text-center"></h3>
											</div>

										</div>
									</div>

									<div class="row  col-lg-5 col-md-5 col-sm-12 col-xs-12">
										<div class="form-group"
											ng-class="{'has-error': formPagos.formaPago.$invalid && formPagos.formaPago.$dirty}">
											<label class="control-label  " for="forma-pago">Forma
												de Pago <span class="required">*</span>
											</label>
											<div class="btn-group btn-group-justified"
												data-toggle="buttons">


												<label class="btn btn-primary "
													ng-repeat="formaPago in listaFormasPago"
													ng-click="seleccionarFormaPago(formaPago, formPagos)">
													<input type="radio" class="sr-only" id="fp-efectivo"
													ng-model="pago.formaPagoVO" required name="formaPago"
													name="forma-pago" checked> <span
													class="docs-tooltip" title="Pago {{formaPago.nombre}}">
														{{formaPago.nombre}} </span>
												</label>
											</div>
											<div
												ng-show="formPagos.formaPago.$invalid && formPagos.formaPago.$dirty"
												ng-style="{color:'red'}">El campo es requerido.</div>
										</div>
										<div class="form-group"
											ng-class="{'has-error': formPagos.importe.$invalid && formPagos.importe.$dirty}">
											<label class="control-label  " for="monto">Importe <span
												class="required">*</span></label> <input type="text" id="importe"
												name="importe" numeric min="-20" max="10000" decimals="2"
												required ng-model="pago.importe"
												ng-change="calcularCambio(pago.pagoCon,pago.importe)"
												class="form-control col-md-7 col-xs-12"
												placeholder=" 00.00 ">
											<div
												ng-show="formPagos.importe.$invalid && formPagos.importe.$dirty"
												ng-style="{color:'red'}">El campo es requerido.</div>
										</div>
										<div class="form-group"
											ng-class="{'has-error': (formPagos.pagoCon.$invalid && formPagos.pagoCon.$dirty) || ( pago.importe > pago.pagoCon &&  pago.pagoCon > 0)}"
											ng-if="!pago.formaPagoVO.requiereNumCuenta ">
											<label class="control-label " for="monto">Pago Con <span
												class="required">*</span></label> <input type="text" id="pagoCon"
												name="pagoCon" required ng-model="pago.pagoCon" numeric
												min="-20" max="10000" decimals="2"
												ng-change="calcularCambio(pago.pagoCon,pago.importe)"
												class="form-control col-md-7 col-xs-12"
												placeholder=" 00.00 ">
											<div
												ng-show="formPagos.pagoCon.$invalid && formPagos.pagoCon.$dirty"
												ng-style="{color:'red'}">El campo es requerido.</div>
											<div
												ng-show="pago.importe > pago.pagoCon &&  pago.pagoCon > 0"
												ng-style="{color:'red'}">El importe {{pago.importe}}
												es mayor a lo que esta recibiendo ! .</div>
										</div>
										<div class="form-group"
											ng-if="!pago.formaPagoVO.requiereNumCuenta ">
											<label class="control-label  " for="monto">Cambio <span
												class="required">*</span></label> <input type="text" id="importe"
												ng-model="pago.cambio" disabled numeric min="-20"
												max="10000" decimals="2"
												class="form-control col-md-7 col-xs-12" placeholder="  ">

										</div>
										<div class="form-group"
											ng-if="pago.formaPagoVO.requiereNumCuenta "
											ng-class="{'has-error': formPagos.noCuenta.$invalid && formPagos.noCuenta.$dirty}">
											<label class="control-label " for="numero-cuenta">N&uacute;mero
												de Cuenta <span class="required">*</span>
											</label> <input type="text" id="numero-cuenta" required
												class="form-control col-md-7 col-xs-12" integer-number
												ng-model="pago.noCuenta" name="noCuenta" maxlength="4"
												placeholder=" &Uacute;ltimos 4 d&iacute;gitos ">
											<div
												ng-show="formPagos.noCuenta.$invalid && formPagos.noCuenta.$dirty  "
												ng-style="{color:'red'}">El campo es requerido.</div>
										</div>
										<div class="form-group">
											<div
												class="col-md-6 col-sm-6 col-xs-12 col-md-offset-4 col-sm-offset-4 col-md-offset-5  col-xs-offset-3">
												<button type="button" class="btn btn-success"
													ng-click="guardarPago(pago,formPagos)">Guardar
													Pago</button>
											</div>
										</div>
									</div>


									<div
										class="table-responsive col-lg-6 col-md-6 col-sm-12 col-xs-12 col-lg-offset-1 col-md-offset-1 col-sm-offset-0">
										<h3 class="text-center">Pagos</h3>
										<table class="table table-striped jambo_table bulk_action">
											<thead>
												<tr class="headings">
													<th class="column-title text-center">Forma de Pago</th>
													<th class="column-title text-center">Importe</th>
													<th class="column-title text-center">Cuenta</th>
													<th class="column-title text-center">Acción</th>

												</tr>
											</thead>

											<tbody>
												<tr class="even pointer"
													ng-repeat="pagoActual in listaPagosActuales ">
													<td class=" ">{{pagoActual.formaPagoVO.nombre}}</td>
													<td class="text-center">{{pagoActual.importe | currency}}</td>
													<td class="text-center">{{pagoActual.noCuenta}}</td>
													<td class="text-center"><button type="button"
															class="btn  btn-danger btn-xs "
															ng-click="cancelar(listaPagosActuales,$index)">Quitar</button></td>
													
												</tr>
												<tr ng-if="listaPagosActuales.length==0">
													<td class="text-center" colspan="4" >No existen registros.</td>
												</tr>
											</tbody>

										</table>
									</div>

								</form>
							</div>

							<div class="x_panel">

								<div class="row  col-lg-12 col-md-12 col-sm-12 col-xs-12">

									<form id="formCancelacion" name="formCancelacion" novalidate
										class="form-horizontal form-label-left">

										<div class="row  col-lg-5 col-md-5 col-sm-6 col-xs-12">
											<div class="form-group col-md-12 col-sm-12 col-xs-12"
												ng-class="{'has-error': formCancelacion.motivoCancelacion.$invalid && formCancelacion.motivoCancelacion.$dirty}">
												<label>Motivo de Cancelación<span class="required">*</span>
												</label> <select class="select2_single form-control"
													name="motivoCancelacion" required
													ng-options="motivoCancelacion as motivoCancelacion.nombre for motivoCancelacion in listaMotivosCancelacion"
													ng-model="cancelacion.motivoCancelacionVO">
													<option value="" selected="selected">Selecciona
														Motivo de Cancelación</option>
												</select>
												<div
													ng-show="formCancelacion.motivoCancelacion.$invalid && formCancelacion.motivoCancelacion.$dirty"
													ng-style="{color:'red'}">El campo es requerido.</div>
											</div>

											<div class="form-group  col-md-12 col-sm-12 col-xs-12"
												ng-class="{'has-error': formCancelacion.descripcionCancelacion.$invalid && formCancelacion.descripcionCancelacion.$dirty}">
												<label>Comentarios<span class="required">*</span>
												</label>
												<textarea id="descripcionCancelacion" required
													class="form-control col-lg-12 col-md-12 col-sm-12 col-xs-12"
													name="descripcionCancelacion"
													ng-model="cancelacion.comentarios"></textarea>
												<div
													ng-show="formCancelacion.descripcionCancelacion.$invalid && formCancelacion.descripcionCancelacion.$dirty"
													ng-style="{color:'red'}">El campo es requerido.</div>
											</div>
										</div>

										<div
											class="table-responsive col-lg-6 col-md-6 col-sm-12 col-xs-12 col-lg-offset-1 col-md-offset-1 col-sm-offset-0 ">
											<h3 class="text-center">Cancelados</h3>
											<table class="table table-striped jambo_table bulk_action">
												<thead>
													<tr class="headings">
														<th class="column-title text-center">Forma de Pago</th>
														<th class="column-title text-center">Importe</th>
														<th class="column-title text-center">Cuenta</th>
														<th class="column-title text-center">Acción</th>

													</tr>
												</thead>

												<tbody>
													<tr class="even pointer"
														ng-repeat="pago in listaPagosCancelados track by pago.idPago">
														<td class=" ">{{pago.formaPagoVO.nombre}}</td>
														<td class="text-center">{{pago.importe | currency}}</td>
														<td class="text-center">{{pago.noCuenta}}</td>
														<td class="text-center"><button type="button"
																class="btn  btn-danger btn-xs ">POR CANCELAR</button></td>
													</tr>
												</tbody>

											</table>
										</div>


									</form>

								</div>

							</div>
<!-- 							<div class="row "> -->
<!-- 								<div class="form-group"> -->
<!-- 									<button type="button" -->
<!-- 										class="col-lg-1 col-md-1 col-sm-1 col-xs-3 col-lg-offset-5 col-md-offset-5  col-sm-offset-5 col-xs-offset-5 btn btn-round btn-info" -->
<!-- 										ng-click="procesarCancelacion(cancelacion)">Guardar</button> -->
<!-- 								</div> -->
<!-- 							</div> -->

							<!-- /xpanel PELICULA -->

							<!-- /x12 columnas -->
						</div>

					</div>
				</div>



			</div>
		</div>

		<!-- Select2 -->
		<script>
		
		
		
			$(document).ready(function() {
				$(".select2_single").select2({
					placeholder : "Seleccione una opción",
					allowClear : true
				});
				$('select').select2({
					language : {

						noResults : function() {

							return "No hay resultado";
						},
						searching : function() {

							return "Buscando..";
						}
					}
				});
				$(".select2_group").select2({});
				$(".select2_multiple").select2({
					maximumSelectionLength : 4,
					language : "es",
					placeholder : "Seleccione una opción",
					allowClear : true
				});
			});
		</script>

	</div>
</body>
</html>

<!-- /bloque de PASO de wizard -->
<!-- /bloque de wizard -->