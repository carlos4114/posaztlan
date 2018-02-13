
<div class="x_panel">
	<div class="x_title">
		<h2>
			<i class="fa fa-cutlery"></i> Platillos/Paquetes en Dulcer&iacute;a
		</h2>
		<div class="clearfix"></div>
	</div>
	<div class="x_content">
		<br />
		<div class="x_panel">
			<form id="demo-form2" data-parsley-validate
				class="form-horizontal form-label-left">

				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12"
						for="nombre-platillo">Nombre <span class="required">*</span>
					</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<input type="text" id="nombre-platillo" ng-model="paquete.nombre"
							required="required" class="form-control col-md-7 col-xs-12">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12"
						for="productos">Productos <span class="required">*</span>
					</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<select class="select2_multiple form-control" multiple="multiple"
							ng-options="producto as producto.nombre for producto  in listaProductos"
							ng-model="paquete.productos">

						</select>
						<script>
							$(".select2_multiple").select2({
								allowClear : true
							});
						</script>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12"
						for="precio-venta">Precio de Venta <span class="required">*</span>
					</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<input type="text" id="precio-venta" required="required"
							ng-model="paquete.precio" class="form-control col-md-7 col-xs-12"
							placeholder="0.00">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12"
						for="icono">Icono <span class="required">*</span>
					</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<input id="icono_file" type="file" class="file"
							on-change="onChange" ng-model="file" data-show-preview="false">
						<script>
							$("#icono_file").fileinput(
									{
										language : "es",
										showUpload : false,
										allowedFileExtensions : [ "jpg", "png",
												"gif", "ico" ]
									});
						</script>
					</div>
				</div>
				<br />
				<div class="form-group">
					<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
						<button type="button" class="btn btn-success"
							ng-click="guardarPaqueteConfirm(paquete)">
							<i class="fa fa-usd"></i> Guardar
						</button>
					</div>
				</div>

			</form>
		</div>
		<div class="x_panel">
			<div class="row">
				<div
					class="table-responsive col-lg-6 col-md-6 col-sm-12 col-xs-12 col-lg-offset-3 col-md-offset-2 col-sm-offset-1">
					<table id="datatable-responsive"
						class="table table-striped table-bordered dt-responsive nowrap"
						cellspacing="0" width="100%">
						<thead>
							<tr>
								<th class="text-center">Platillo/Paquete</th>
								<th class="text-center">Productos</th>
								<th class="text-center">Precio</th>
								<th class="text-center">Eliminar</th>
							</tr>
						</thead>
						<tbody>
							<tr class="odd pointer" ng-repeat="paquete in  listaPaquetes ">
								<td>{{paquete.nombre}}</td>
								<td>{{paquete.productos}}</td>
								<td class="text-center">{{paquete.precio}}</td>
								<td class="text-center">
									<button type="button" class="btn btn-round btn-default btn-md"
										ng-click="eliminarPaquete(paquete)">
										<i class="fa fa-trash-o"></i>
									</button>
								</td>
							</tr>

						</tbody>
					</table>
				</div>
				<!-- table-responsive -->
			</div>
			<!-- row -->
		</div>
		<!-- x-panel -->
	</div>
	<!-- content -->
</div>
<!-- xpanel -->
