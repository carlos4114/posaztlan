
<!-- bloque de PASO 4 de wizard - CANTIDAD -->
<div id="step-2">
	<div class="x_panel">
		<div class="x_title">
			<h2>
				<i class="fa fa-credit-card"></i> Registra el Pago
			</h2>
			<div class="row pull-right" ng-init=calcularTotalPagado(listaPagos)>
				<button type="button" class="btn btn-primary"
					ng-click="asignarPaso(3);StartTimer(paramsExistenciaBoleto)">
					<i class="fa fa-calculator"></i> Modificar Cantidades
				</button>
				<button type="button" class="btn btn-success"
					ng-click="confirmacionVenta(objetosVenta)"
					ng-disabled="pago.porPagar > 0">
					Confirmar la Venta <i class="fa fa-thumbs-o-up"></i>
				</button>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="x_content">
			<!-- bloque de pelicula -->
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="row">
						<div
							class="animated flipInY col-lg-2 col-md-2 col-sm-2 col-xs-2 col-lg-offset-3 col-md-offset-1 col-xs-offset-1">
							<div class="tile">
								<h2>Total</h2>
								<h3>{{pago.subtotal | currency}}</h3>
							</div>
						</div>
						<div class="animated flipInY col-lg-2 col-md-2 col-sm-2 col-xs-2">
							<div class="tile">
								<h2>Pagado</h2>
								<h3>{{pago.pagado | currency}}</h3>
							</div>
						</div>
						<div class="animated flipInY col-lg-2 col-md-2 col-sm-2 col-xs-2">
							<div class="tile">
								<h2>Por Pagar</h2>
								<h3>{{pago.porPagar | currency}}</h3>
							</div>
						</div>
						<div ng-if="cambioTotal > 0 "
							class="animated flipInY  col-lg-2 col-md-3 col-sm-3  col-xs-3 col-xs-offset-1 col-md-offset-0 ">

							<div class="tile-stats">
								<h2 class="text-center">Cambio</h2>
								<br />
								<h3 class="text-center">{{cambioTotal | currency}}</h3>
							</div>
						</div>
					</div>
					<!-- row -->
					<br />
					<div class="row">
						<div
							class="table-responsive col-lg-6 col-md-10 col-sm-8 col-xs-12 col-lg-offset-3 col-md-offset-1 col-sm-offset-2">
							<table class="table table-striped jambo_table bulk_action">
								<thead>
									<tr class="headings">
										<th class="column-title text-center">Forma de Pago</th>
										<th class="column-title text-center">Importe</th>
										<th class="column-title text-center">Cuenta</th>
									</tr>
								</thead>

								<tbody>
									<tr class="even pointer" ng-repeat="pago in listaPagos">
										<td class=" ">{{pago.formaPagoVO.nombre}}</td>
										<td class="text-center">{{pago.importe | currency}}</td>
										<td class="text-center">{{pago.noCuenta}}</td>
									</tr>
									<tr ng-if="listaPagos.length==0">
										<td class="text-center" colspan="4">No existen
											registros.</td>
									</tr>
								</tbody>
							</table>
						</div>
						<!-- table-responsive -->
					</div>
					<!-- row -->
				</div>
				<!-- xpanel -->
				<div class="x_panel">
					<br />
					<form id="formPagos" name="formPagos" role="form" novalidate
						class="form-horizontal form-label-left">
						<div class="form-group"
							ng-class="{'has-error': formPagos.formaPago.$invalid && formPagos.formaPago.$dirty}">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="forma-pago">Forma de Pago <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<div class="btn-group btn-group-justified" data-toggle="buttons">


									<label class="btn btn-primary "
										ng-repeat="formaPago in listaFormasPago"
										ng-click="seleccionarFormaPago(formaPago, formPagos)">
										<input type="radio" class="sr-only" id="fp-efectivo"
										ng-model="pago.formaPagoVO" required name="formaPago"
										name="forma-pago" checked> <span class="docs-tooltip"
										title="Pago {{formaPago.nombre}}"> {{formaPago.nombre}}
									</span>
									</label>
								</div>
							</div>
							<div
								ng-show="formPagos.formaPago.$invalid && formPagos.formaPago.$dirty"
								ng-style="{color:'red'}">El campo es requerido.</div>
						</div>
						<div class="form-group"
							ng-class="{'has-error': formPagos.importe.$invalid && formPagos.importe.$dirty}">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="monto">Importe <span class="required">*</span></label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="text" id="importe" name="importe" numeric min="-20"
									max="10000" decimals="2" required ng-model="pago.importe"
									ng-change="calcularCambio(pago.pagoCon,pago.importe)"
									class="form-control col-md-7 col-xs-12" placeholder=" 00.00 ">
							</div>
							<div
								ng-show="formPagos.importe.$invalid && formPagos.importe.$dirty"
								ng-style="{color:'red'}">El campo es requerido.</div>
						</div>
						<div class="form-group"
							ng-class="{'has-error': (formPagos.pagoCon.$invalid && formPagos.pagoCon.$dirty) || ( pago.importe > pago.pagoCon &&  pago.pagoCon > 0)}"
							ng-if="!pago.formaPagoVO.requiereNumCuenta ">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="monto">Pago Con <span class="required">*</span></label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="text" id="pagoCon" name="pagoCon" required
									ng-model="pago.pagoCon" numeric min="-20" max="10000"
									decimals="2"
									ng-change="calcularCambio(pago.pagoCon,pago.importe)"
									class="form-control col-md-7 col-xs-12" placeholder=" 00.00 ">
							</div>
							<div
								ng-show="formPagos.pagoCon.$invalid && formPagos.pagoCon.$dirty"
								ng-style="{color:'red'}">El campo es requerido.</div>
							<div ng-show="pago.importe > pago.pagoCon &&  pago.pagoCon > 0"
								ng-style="{color:'red'}">El importe {{pago.importe}} es
								mayor a lo que esta recibiendo ! .</div>
						</div>
						<div class="form-group"
							ng-if="!pago.formaPagoVO.requiereNumCuenta ">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="monto">Cambio <span class="required">*</span></label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="text" id="importe" ng-model="pago.cambio" disabled
									numeric min="-20" max="10000" decimals="2"
									class="form-control col-md-7 col-xs-12" placeholder="  ">
							</div>

						</div>
						<div class="form-group"
							ng-if="pago.formaPagoVO.requiereNumCuenta "
							ng-class="{'has-error': formPagos.noCuenta.$invalid && formPagos.noCuenta.$dirty}">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="numero-cuenta">N&uacute;mero de Cuenta <span
								class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="text" id="numero-cuenta" required
									class="form-control col-md-7 col-xs-12" integer-number
									ng-model="pago.noCuenta" name="noCuenta" maxlength="4"
									placeholder=" &Uacute;ltimos 4 d&iacute;gitos ">
							</div>
							<div
								ng-show="formPagos.noCuenta.$invalid && formPagos.noCuenta.$dirty  "
								ng-style="{color:'red'}">El campo es requerido.</div>
						</div>
						<div class="form-group">
							<div
								class="col-md-6 col-sm-6 col-xs-12 col-md-offset-6  col-sm-offset-5 col-md-offset-5">
								<button type="button" class="btn btn-success"
									ng-click="guardarPago(pago,formPagos)">Guardar Pago</button>
							</div>
						</div>
					</form>

				</div>
				<!-- /xpanel formulario -->
			</div>
			<!-- /x12 columnas -->
		</div>
		<!-- /xcontent -->
	</div>
	<!-- /xpanel MODULO -->
</div>
