<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <meta charset="utf-8">
 <title>Venta Boleto</title>
</head>
<body>
	<!-- Bootstrap -->

	<!-- page content -->
	<!-- bloque de wizard -->
	<div class="row">
		<div class="col-md-12 col-sm-12 col-xs-12">

			<div id="wizard" class="form_wizard wizard_horizontal">
				<ul class="wizard_steps">
					<li><a href="" ng-class="statusVenta.elegirPelicula"> <span
							class="step_no">1</span> <span class="step_descr"> Elige
								la pel&iacute;cula<br />
						</span>
					</a></li>
					<li><a href="" ng-class="statusVenta.elegirPromocion"> <span
							class="step_no">2</span> <span class="step_descr">
								Selecciona la promoci&oacute;n<br />
						</span>
					</a></li>
					<li><a href="" ng-class="statusVenta.elegirCantidad"> <span
							class="step_no">3</span> <span class="step_descr">
								Selecciona la cantidad<br />
						</span>
					</a></li>
					<li><a href="" ng-class="statusVenta.seleccionarAsientos"> <span
							class="step_no">4</span> <span class="step_descr">
								Seleccionar Asientos<br />
						</span>
					</a></li>
					<li><a href="" ng-class="statusVenta.registrarPago"> <span
							class="step_no">5</span> <span class="step_descr">
								Registra el pago<br />
						</span>
					</a></li>
					<li><a href="" ng-class="statusVenta.confirmarVenta"> <span
							class="step_no">6</span> <span class="step_descr">
								Confirma la venta<br />
						</span>
					</a></li>
				</ul>
				<!-- bloque de PASO de wizard - CARTELERA -->
				<div class="col-md-12 col-sm-12 col-xs-12"
					ng-show="statusVenta.numeroPaso ===1" elegir-pelicula></div>
				<div class="col-md-12 col-sm-12 col-xs-12"
					ng-if="statusVenta.numeroPaso ===2" elegir-promocion></div>
				<div class="col-md-12 col-sm-12 col-xs-12"
					ng-if="statusVenta.numeroPaso ===3" elegir-cantidad></div>
				<div class="col-md-12 col-sm-12 col-xs-12"
					ng-if="statusVenta.numeroPaso ===4" seleccionar-asientos></div>
				<div class="col-md-12 col-sm-12 col-xs-12"
					ng-if="statusVenta.numeroPaso ===5" registrar-pago></div>	
				<div class="col-md-12 col-sm-12 col-xs-12"
					ng-if="statusVenta.numeroPaso ===6" confirmar-venta></div>

				<!-- /bloque de PASO de wizard -->
			</div>
		</div>
	</div>
	<!-- /bloque de wizard -->


</body>
</html>