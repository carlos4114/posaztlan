	    <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2><i class="fa fa-calculator"></i> Corte de Caja </h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
                      <br />
                      <div class="x_panel">
		                   <form ng-submit="submit()" name="formCorteCaja" id="formCorteCaja" data-parsley-validate class="form-horizontal form-label-left">
							  <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="perfil">Cine<span class="required">*</span>
		                        </label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
									<select class="form-control col-md-7 col-xs-12" id="cine" name="cine" directiva-select2 required
										ng-change="cambiarCine(usuarioVO.idCine)"
										ng-options="cine.idCine as cine.nombre for cine in listaCines"
										ng-model="usuarioVO.idCine">
										<option value="" selected="selected">Selecciona un cine
										</option>
									</select>
								</div>
		                      </div>	
		                      <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="nombre">Nombre<span class="required">*</span>
		                        </label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
		                          <input type="text" id="nombre" placeholder="Nombre" ng-model="usuarioVO.nombre" required="required" class="form-control col-md-7 col-xs-12">
		                        </div>
		                      </div>
							   <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="apPaterno">Apellido Paterno<span class="required">*</span>
		                        </label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
		                          <input type="text" id="apPaterno" placeholder="Apellido Paterno" ng-model="usuarioVO.paterno" required="required" class="form-control col-md-7 col-xs-12">
		                        </div>
		                      </div>
							   <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="apMaterno">Apellido Materno
		                        </label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
		                          <input type="text" id="apMaterno" placeholder="Apellido Materno" ng-model="usuarioVO.materno" class="form-control col-md-7 col-xs-12">
		                        </div>
		                      </div>
							   <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="correo">Correo Electr&oacute;nico<span class="required">*</span>
		                        </label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
		                          <input type="email" id="correo" placeholder="Correo Electr&oacute;nico" ng-model="usuarioVO.correo" required="required" class="form-control col-md-7 col-xs-12">
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
									<select class="form-control col-md-7 col-xs-12" name="perfil" required										
										ng-options="perfil.idPerfil as perfil.nombre for perfil in listaPerfiles"
										ng-model="usuarioVO.idPerfil">
										<option value="" selected="selected">Selecciona un perfil
										</option>
									</select>
								</div>
		                      </div>	
		                      <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="puntoVenta">Punto de Venta<span class="required">*</span>
		                        </label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
									<select class="form-control col-md-7 col-xs-12" name="puntoVenta" id="puntoVenta" directiva-select2 required
										ng-options="puntoVenta.idPuntoVenta as puntoVenta.nombre for puntoVenta in listaPuntosVenta"
										ng-model="usuarioVO.idPuntoVenta">
										<option value="" selected="selected">Selecciona un punto de venta
										</option>
									</select>
								</div>
		                      </div>	
		                      
	                      	  <br/>
		                      <div class="form-group">
		                        <div class="col-md-6 col-sm-6 col-xs-6 col-md-offset-3">
		                          <button type="submit" class="btn btn-success" ng-disabled="formCorteCaja.$invalid"><i class="fa fa-users"></i>{{!usuarioVO.idUsuario ? 'Guardar' : 'Actualizar'}}</button>
		                          <button type="button" ng-click="limpiarFormulario()" class="btn btn-primary" >Nuevo</button>
		                        </div>
		                      </div>		                      		                      
		                      
		                      <div class="alert alert-success" align="center" role="alert" ng-show="mensajeGeneral.length">	  
							  	 <span  class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span>
							     {{mensajeGeneral}}
					          </div>    
							  <div class="alert" align="center" role="alert" ng-show="errorGeneral.length">	  
							  	 <span  class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
							     {{errorGeneral}}
					          </div>

							</form>
						</div>
		                <div class="x_panel">
		                    <div class="row">
										              <div class="table-responsive col-lg-10 col-md-12 col-sm-12 col-xs-12 col-lg-offset-1 col-md-offset-1 col-sm-offset-1">
									                      <table id="datatable-responsive" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
									                        <thead>
									                          <tr>
									                            <th class="text-center">Nombre </th>
									                            <th class="text-center">Ap. Paterno </th>
									                            <th class="text-center">Ap. Materno </th>
									                            <th class="text-center">Correo Electr&oacute;nico </th>
									                            <th class="text-center">Perfil </th>
									                            <th class="text-center">Punto de Venta </th>
									                            <th class="text-center">Estatus </th>
									                            <th class="text-center">Editar </th>
															  </tr>
									                        </thead>

									                        <tbody>
									                          <!-- <tr 
									                             ng-repeat="u in listaUsuarios" > -->
									                          <tr 
									                           dir-paginate="u in listaUsuarios |  filter: filterSearch |itemsPerPage: 10">   
									                            <td class="text-center"><span ng-bind="u.nombre"></span></td>
									                            <td class="text-center"><span ng-bind="u.paterno"></span></td>
									                            <td class="text-center"><span ng-bind="u.materno"></span></td>
									                            <td class="text-center"><span ng-bind="u.correo"></span></td>
									                            <td class="text-center"><span ng-bind="u.perfil"></span></td>
									                            <td class="text-center"><span ng-bind="u.puntoVenta"></span></td>
									                            <td class="text-center"><span ng-bind="u.estatus"></span></td>
									                            <td class="text-center">
									                              <button type="button" ng-click="editarUsuario(u.idUsuario)" class="btn btn-round btn-default btn-md"><i class="fa fa-edit"></i></button>
																</td>
									                          </tr>									                          
									                        </tbody>
									                        <dir-pagination-controls></dir-pagination-controls> 
									                      </table>
									                  </div> <!-- table-responsive -->
								  </div> <!-- row -->
							</div><!-- x-panel -->
						</div> <!-- content -->
					</div> <!-- xpanel -->
			</div> <!-- 12 COLS -->
		</div> <!-- ROW -->	