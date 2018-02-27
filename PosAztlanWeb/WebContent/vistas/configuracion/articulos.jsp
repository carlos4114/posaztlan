	    <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2><i class="fa fa-cutlery"></i> Artículos </h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
                      <br />
                      <div class="x_panel">
		                   <form ng-submit="submit()" name="formArticulos" id="formArticulos" data-parsley-validate class="form-horizontal form-label-left">
							  <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="cine">Cine<span class="required">*</span>
		                        </label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
									<select class="form-control col-md-7 col-xs-12" id="cine" name="cine" directiva-select2
										ng-change="cambiarCine(articuloVO.idCine)"
										ng-options="cine.idCine as cine.nombre for cine in listaCines"
										ng-model="articuloVO.idCine">
										<option value="" selected="selected">Selecciona un cine
										</option>
									</select>
								</div>
		                      </div>	
		                      <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="nombre">Nombre<span class="required">*</span>
		                        </label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
		                          <input type="text" id="nombre" placeholder="Nombre" ng-model="articuloVO.nombre" required="required" class="form-control col-md-7 col-xs-12">
		                        </div>
		                      </div>
						      		
						      <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="clasificacion">Clasificación<span class="required">*</span>
		                        </label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
									<select class="form-control col-md-7 col-xs-12" name="clasificacion" id="clasificacion" required										
										ng-options="clasificacion.idClasificacionArt as clasificacion.nombre for clasificacion in listaClasificaciones"
										ng-model="articuloVO.idClasificacionArt">
										<option value="" selected="selected">Selecciona una Clasificación
										</option>
									</select>
								</div>
		                      </div>	
		                      
		                      
						       <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="unidadMedida">Unidad de Medida<span class="required">*</span>
		                        </label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
									<select class="form-control col-md-7 col-xs-12" name="unidadMedida" id="unidadMedida" required										
										ng-options="unidadMedida.idUnidadMedida as unidadMedida.nombre for unidadMedida in listaUnidadesMedida"
										ng-model="articuloVO.idUnidadMedida" >
										<option value="" selected="selected">Selecciona la unidad de medida
										</option>
									</select>
								</div>
		                      </div>                      
							  
		                       <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="puntoReorden">Punto de Reorden<span class="required">*</span>
		                        </label>
		                        <div class="col-md-2 col-sm-2 col-xs-6">
		                          <input type="text" id="puntoReorden" placeholder="0" 
		                          ng-model="articuloVO.puntoReorden" required="required" class="form-control col-md-7 col-xs-12">
		                        </div>
		                      </div>	
		                      
		                      <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="puntoVenta">Punto de Venta<span class="required">*</span>
		                        </label>.
		                        <div class="col-md-6 col-sm-6 col-xs-12">
									<select class="select2_multiple form-control" multiple="multiple" id="puntoVenta"
											ng-options="puntoVenta.idPuntoVenta as puntoVenta.nombre for puntoVenta in listaPuntosVenta"
											ng-model="articuloVO.puntosVentaList ">
										</select>
						
										<script>
											$(".select2_multiple").select2({
												allowClear : true
											});
										</script>
								</div>
		                      </div>
		                      
		                   	 <!-- <div class ="form-group">
		                   	  	<label class="control-label col-md-3 col-sm-3 col-xs-12" for="estatus">Estatus <span class="required">*</span> </label>
		                   	  	<div id="estatus" class="btn-group" data-toggle="buttons">
                            		<label class="btn btn-default active" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                              			<input type="radio" name="estatus" value="1" data-parsley-multiple="estatus">Activo</label>
                            		<label class="btn btn-primary" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                              			<input type="radio" name="estatus" value="0" data-parsley-multiple="estatus">Inactivo</label>
                          		</div>
		                   	  </div>-->
		                     <!--  <div ng-if="articuloVO.idArticulo">   	
			                      <div class="form-group">
			                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="estatus">Estatus<span class="required">*</span>
			                        </label>
			                        <div class="col-md-6 col-sm-6 col-xs-12">
					                        <select class="form-control col-md-7 col-xs-12" name="estatus" id="estatus" required
												ng-options="estatus.id as estatus.nombre for estatus in listaEstatus"
												ng-model="articuloVO.activo">
												<option value="" selected="selected">Selecciona el estatus
												</option>
										</select>
					                </div>
			                      </div>
			                  </div>    
			                       -->
	                      	  
	                      	  <div ng-if="articuloVO.idArticulo">   	
			                      <div class="form-group">
			                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="estatus">Estatus<span class="required">*</span>
			                        </label>
			                        <div class="col-md-2 col-sm-2 col-xs-2">
					                        <select class="form-control col-md-7 col-xs-12" name="estatus" id="estatus" required
												ng-change="cambiarEstatus(estatus)"
												ng-model="estatus">
												<option value ="1">Activo</option>
												<option value ="0">Inactivo</option>
										</select>
					                </div>
			                      </div>
			                  </div>  
			                  
	                      	  <br/>
		                      <div class="form-group">
		                        <div class="col-md-6 col-sm-6 col-xs-6 col-md-offset-3">
		                          <button type="submit" class="btn btn-success" ng-disabled="formArticulos.$invalid"><i class="fa fa-save"></i>{{!articuloVO.idArticulo ? 'Guardar' : 'Actualizar'}}</button>
		                          <button type="button" ng-click="limpiarFormulario()" class="btn btn-primary" ><i class="fa fa-file-o"></i>Nuevo</button>
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
									                            <th class="text-center">Clasificaci&oacuten </th>
									                            <th class="text-center">U. Medida </th>
									                            <th class="text-center">Punto de reorden </th>
									                            <th class="text-center">Estatus </th>
									                            <th class="text-center">Editar </th>
															  </tr>
									                        </thead>

									                        <tbody>
									                          <!-- <tr 
									                             ng-repeat="u in listaUsuarios" > -->
									                          <tr 
									                           dir-paginate="a in listaArticulos |  filter: filterSearch |itemsPerPage: 5">   
									                            <td class="text-center"><span ng-bind="a.nombre"></span></td>
									                            <td class="text-center"><span ng-bind="a.clasificacionArtVO.nombre"></span></td>
									                            <td class="text-center"><span ng-bind="a.unidadMedidaVO.nombre"></span></td>
									                            <td class="text-center"><span ng-bind="a.puntoReorden"></span></td>
									                            <td class="text-center"><span ng-bind="a.activo ? 'ACTIVO' : 'INACTIVO'"></span></td>
									                            <td class="text-center">
									                              <button type="button" ng-click="editarArticulo(a.idArticulo)" class="btn btn-round btn-default btn-md"><i class="fa fa-edit"></i></button>
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