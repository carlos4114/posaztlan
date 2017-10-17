<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
					<li><a href="" ng-class="status.paso1"
						ng-click=""> <span class="step_no">1</span> <span
							class="step_descr">Buscar Ticket<br />
						</span>
					</a></li>
					<li><a href=""
						ng-class="status.numeroPaso < 2 ?  'disabled' : status.paso2 "
						ng-click=""> <span class="step_no">2</span> <span
							class="step_descr"> Selecciona Cancelación<br />
						</span>
					</a></li>
					<li><a href=""
						ng-class="status.numeroPaso < 3 ?  'disabled' : status.paso3 ">
							<span class="step_no">3</span> <span class="step_descr">
								Resumen Cancelación<br />
						</span>
					</a></li>

				</ul>
				<!-- bloque de PASO de wizard - CARTELERA -->
				<div class="col-md-12 col-sm-12 col-xs-12"
					ng-show="status.numeroPaso ===1" buscar-ticket-cancelacion></div>
				<div class="col-md-12 col-sm-12 col-xs-12"
					ng-show="status.numeroPaso ===2" generar-cancelacion></div>
				<div class="col-md-12 col-sm-12 col-xs-12"
					ng-show="status.numeroPaso ===3" terminar-cancelacion></div>



				<!-- /bloque de PASO de wizard -->
			</div>
		</div>
	</div>
	<!-- /bloque de wizard -->
</body>
</html>