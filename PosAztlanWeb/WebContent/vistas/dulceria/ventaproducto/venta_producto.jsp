<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="wizard" class="form_wizard wizard_horizontal">
	<ul class="wizard_steps">
		<li><a href="" ng-class="statusVenta.elegirProducto"> <span class="step_no">1</span>
				<span class="step_descr"> Elige el Producto<br /></span>
		</a></li>

		<li><a href="" ng-class="statusVenta.registrarPago"> <span class="step_no">2</span>
				<span class="step_descr"> Registra el Pago<br /></span>
		</a></li>

		<li><a href="" ng-class="statusVenta.confirmarVenta"> <span class="step_no">3</span>
				<span class="step_descr"> Confirma la venta<br /></span>
		</a></li>

	</ul>

	<div ng-if="statusVenta.numeroPaso ===1" elegir-producto></div>
	<div ng-if="statusVenta.numeroPaso ===2" registrar-pago-producto></div>
	<div ng-if="statusVenta.numeroPaso ===3" confirmar-venta-producto></div>

</div>