	    <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2><i class="fa fa-users"></i> Usuarios </h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
                      <br />
                      <div class="x_panel">
		                   <form id="usuarios-form" data-parsley-validate class="form-horizontal form-label-left">

		                      <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="nombre">Nombre<span class="required">*</span>
		                        </label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
		                          <input type="text" id="nombre" placeholder="Nombre" ng-model="nombre" required="required" class="form-control col-md-7 col-xs-12">
		                        </div>
		                      </div>
							   <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="apPaterno">Apellido Paterno<span class="required">*</span>
		                        </label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
		                          <input type="text" id="apPaterno" placeholder="Apellido Paterno" ng-model="apPaterno" required="required" class="form-control col-md-7 col-xs-12">
		                        </div>
		                      </div>
							   <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="apMaterno">Apellido Materno
		                        </label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
		                          <input type="text" id="apMaterno" placeholder="Apellido Materno" ng-model="apMaterno" class="form-control col-md-7 col-xs-12">
		                        </div>
		                      </div>
							   <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="correo">Correo Electr&oacute;nico<span class="required">*</span>
		                        </label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
		                          <input type="email" id="correo" placeholder="Correo Electr&oacute;nico" ng-model="correo" required="required" class="form-control col-md-7 col-xs-12">
		                        </div>
		                      </div>
						      <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="correoConfirma">Confirma Correo<span class="required">*</span>
		                        </label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
		                          <input type="email" id="correoConfirma" placeholder="Confirmar el Correo" ng-model="correoConfirma" required="required" class="form-control col-md-7 col-xs-12">
		                        </div>
		                      </div>			                      
							  <!-- <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="foto">Foto
		                        </label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
 										<input id="foto" ng-model="foto"  type="file" placeholder="Foto del Usuario"  class="file" data-show-preview="false" class="form-control col-md-7 col-xs-12">
										<script>
											$("#icono_file").fileinput({
												language: "es",
												uploadUrl: "/file-upload-batch/2",
												allowedFileExtensions: ["jpg", "png", "gif","ico"]
											});
										</script>
									</div>
		                      </div>  -->
							  <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="perfil">Perfil<span class="required">*</span>
		                        </label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
									<select id="perfil" ng-model="perfil" required="required" class="form-control col-md-7 col-xs-12">
										<option>-- Selecciona el Perfil --</option>
										<option>Gerente</option>
										<option>Cajero en Taquilla</option>
										<option>Cajero en Dulcer&iacute;a</option>
									</select>
								</div>
		                      </div>	
		                      <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="puntoVenta">Punto de Venta<span class="required">*</span>
		                        </label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
									<select id="puntoVenta" ng-model="puntoVenta" class="form-control col-md-7 col-xs-12">
										<option>-- As&iacute;gnale un Punto de Venta --</option>
										<option>Dulcer&iacute;a A</option>
										<option>Dulcer&iacute;a B</option>
										<option>Taquilla 1</option>
										<option>Taquilla 2</option>
									</select>
								</div>
		                      </div>	
		                      
	                      	  <br/>
		                      <div class="form-group">
		                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
		                          <button type="submit" class="btn btn-success"><i class="fa fa-users"></i> Guardar </button>
		                        </div>
		                      </div>

							</form>
						</div>
		                <div class="x_panel">
		                    <div class="row">
										              <div class="table-responsive col-lg-8 col-md-8 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-1 col-sm-offset-1">
									                      <table id="datatable-responsive" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
									                        <thead>
									                          <tr>
									                            <th class="text-center">Nombre </th>
									                            <th class="text-center">Correo Electr&oacute;nico </th>
									                            <th class="text-center">Perfil </th>
									                            <th class="text-center">Punto de Venta </th>
									                            <th class="text-center">Eliminar </th>
															  </tr>
									                        </thead>

									                        <tbody>
									                          <tr>
									                            <td>Aldo Hernández González</td>
									                            <td class="text-center">aldo.hernandez@tecnetia.com.mx</td>
									                            <td class="text-center">Gerente</td>
									                            <td class="text-center"></td>
									                            <td class="text-center">
									                              <button type="button" class="btn btn-round btn-default btn-md"><i class="fa fa-trash-o"></i></button>
																</td>
									                          </tr>
									                          <tr>
									                            <td>Jorge Villanueva Lara</td>
									                            <td class="text-center">jorge.villanueva@tecnetia.com.mx</td>
									                            <td class="text-center">Cajero en Taquilla</td>
									                            <td class="text-center">Taquilla 1</td>
									                            <td class="text-center">
									                              <button type="button" class="btn btn-round btn-default btn-md"><i class="fa fa-trash-o"></i></button>
																</td>
									                          </tr>
									                        </tbody>
									                      </table>
									                  </div> <!-- table-responsive -->
								  </div> <!-- row -->
							</div><!-- x-panel -->
						</div> <!-- content -->
					</div> <!-- xpanel -->
			</div> <!-- 12 COLS -->
		</div> <!-- ROW -->	