<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="wizard" class="form_wizard wizard_horizontal">

	<!-- bloque de PASO de wizard -->
	<div id="step-1">
		<div class="x_panel">
			<div class="x_title">
				<h2>
					<i class="fa fa-thumbs-o-up"></i> Confirma la Venta
				</h2>
				<div class="title_right">
					<div class="row pull-right">

						<!-- 						<button type="button" ng-click="asignarPaso(2)" -->
						<!-- 							class="btn btn-primary"> -->
						<!-- 							<i class="fa fa-credit-card"></i> Regresar al Pago -->
						<!-- 						</button> -->

					</div>

					<div class="clearfix"></div>
				</div>
			</div>
			<div class="x_content">

				<!-- bloque de 12 col -->
				<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="x_panel">
						<div class="row">
							
							<div
								class="col-lg-2 col-md-2 col-sm-2 col-xs-6 col-lg-offset-5 col-md-offset-5 col-sm-offset-5 col-xs-offset-3 text-center">
								<a class="btn btn-app" title="Cerrar venta e imprimir boletos"
									ng-click="imprimirTicket()"> <i class="fa fa-print"></i>
									Imprimir Ticket
								</a>

							</div>
							
							<div
								class="col-lg-2col-md-2 col-sm-2 col-xs-12 col-lg-offset-3 col-md-offset-2 col-sm-offset-5 col-xs-offset-0">
								<a href="#/ventaProducto">
									<button type="button" class="btn btn-success  col-xs-12" ng-disabled="isImpreso==false"  ng-click="resetVenta();asignarPaso(1)">Nueva Venta</button>
								</a>
							</div> 
							
						</div>
					</div>
					<div class="x_panel">
						<div class="row">
							<div class="x_title">

								<div class="row pull-right">
									<h3>TOTAL = {{pago.subtotal | currency }}</h3>
								</div>
								<div class="clearfix"></div>
							</div>
							<div
								class="table-responsive col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<h3 class="text-center">Resumen de Venta</h3>
								<table class="table table-striped jambo_table bulk_action">
									<thead>
										<tr class="headings">
											<th class="column-title text-center">Cant.</th>
											<th class="column-title text-center">Producto</th>
											<th class="column-title text-center">Precio</th>
										</tr>
									</thead>

									<tbody>
										<tr class="odd pointer" ng-repeat="paquete in  venta.paquetesVO"
											ng-if="paquete.cantidad >0">
											<td class=" ">{{paquete.cantidad}}</td>
											<td class="text-center">{{paquete.nombre}}</td>
											<td class="text-center">{{paquete.importe | currency }}</td>

										</tr>

									</tbody>

								</table>
							</div>
							<!-- table-responsive -->
							<div
								class="table-responsive col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<h3 class="text-center">Pagos</h3>
								<table class="table table-striped jambo_table bulk_action">
									<thead>
										<tr class="headings">
											<th class="column-title text-center">Forma de Pago</th>
											<th class="column-title text-center">Importe</th>
											<th class="column-title text-center">Cuenta</th>
										</tr>
									</thead>

									<tbody>

										<tbody>
											<tr class="even pointer" ng-repeat="pago in venta.pagosVO">
												<td class=" ">{{pago.formaPagoVO.nombre}}</td>
												<td class="text-center">{{pago.importe | currency }}</td>
												<td class="text-center">{{pago.noCuenta}}</td>
											</tr>

										</tbody>
										</tbody>

									</table>
								</div>
						<!-- table-responsive --></div>

															<!-- row -->

					</div>
					<!-- /x panel -->
				</div>
				<!-- /12 col -->
			</div>
			<!-- /content -->
		</div>
		<!-- /x panel global -->
	</div>
	<!-- /step div	 -->
</div>
<!-- /wizard -->
