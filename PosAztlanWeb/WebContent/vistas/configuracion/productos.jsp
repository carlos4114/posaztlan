				<div class="x_panel">
					<div class="x_title">
						<h2><i class="fa fa-shopping-cart"></i> Productos </h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
                      <br />
                      <div class="x_panel">
		                   <form ng-submit="submit()" name="formProductos" id="formProductos" data-parsley-validate class="form-horizontal form-label-left">
		                   	  
		                   	  <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="sku">SKU 
		                        </label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
		                          <input type="text" disabled="true" id="sku" class="form-control col-md-7 col-xs-12"
		                          ng-model="productoVO.sku">
		                        </div>
		                      </div>
		                      <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="nombre-producto">Nombre del Producto <span class="required">*</span>
		                        </label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
		                          <input type="text" id="nombre-producto" required="required" class="form-control col-md-7 col-xs-12"
		                          ng-model="productoVO.nombre">
		                        </div>
		                      </div>
		                      
		                      <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="descripcion">Descripci&oacute;n <span class="required">*</span>
		                        </label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
		                          <input type="text" id="descripcion" required="required" class="form-control col-md-7 col-xs-12"
		                          ng-model="productoVO.descripcion">
		                        </div>
		                      </div>
		                      
		                      <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="familia">Familia<span class="required">*</span>
		                        </label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
									<select class="form-control col-md-7 col-xs-12" id="familia" name="familia" directiva-select2 required
										ng-options="familia.id as familia.nombre for familia in listaFamilias"
										ng-model="productoVO.idFamilia">
										<option value="" selected="selected">Selecciona una familia
										</option>
									</select>
								</div>
		                      </div>
		                       <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="marca">Marca<span class="required">*</span>
		                        </label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
									<select class="form-control col-md-7 col-xs-12" id="marca" name="marca" directiva-select2 required
										ng-options="marca.id as marca.nombre for marca in listaMarcas"
										ng-model="productoVO.idMarca">
										<option value="" selected="selected">Selecciona una marca
										</option>
									</select>
								</div>
		                      </div>
		                      
		                       <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="tipo">Tipo<span class="required">*</span>
		                        </label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
									<select class="form-control col-md-7 col-xs-12" id="tipo" name="tipo" directiva-select2 required
										ng-options="tipo.id as tipo.nombre for tipo in listaTipos"
										ng-model="productoVO.idTipoProducto">
										<option value="" selected="selected">Selecciona un tipo
										</option>
									</select>
								</div>
		                      </div>
		                      
		                      <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="medida">Medida<span class="required">*</span>
		                        </label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
									<select class="form-control col-md-7 col-xs-12" id="medida" name="medida" directiva-select2 required
										ng-options="medida.id as medida.nombre for medida in listaMedidas"
										ng-model="productoVO.idMedida">
										<option value="" selected="selected">Selecciona una medida
										</option>
									</select>
								</div>
		                      </div>
		                      
		                      <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="unidadMedida">Unidad Medida<span class="required">*</span>
		                        </label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
									<select class="form-control col-md-7 col-xs-12" id="unidadMedida" name="unidadMedida" directiva-select2 required
										ng-options="unidadMedida.id as unidadMedida.nombre for unidadMedida in listaUnidadesMedida"
										ng-model="productoVO.idUnidadMedida">
										<option value="" selected="selected">Selecciona unidad de medida
										</option>
									</select>
								</div>
		                      </div>
		                      
		                       <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="tipo">Origen<span class="required">*</span>
		                        </label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
									<select class="form-control col-md-7 col-xs-12" id="origen" name="origen" directiva-select2 required
										ng-change="cambiarOrigen(nacional)" 
										ng-model="nacional">
										<option value="1" selected="selected">Nacional
										<option value="0" selected="selected">Importado
										</option>
									</select>
								</div>
		                      </div>
		                      
		                      <div class="form-group">
		                        	<label class="control-label col-md-3 col-sm-3 col-xs-3" for="precio-unico">Precio Unico 
		                        	</label>
		                        	<div class="col-md-2 col-sm-2 col-xs-2">
		                          		<input type="text" id="precio-unico" class="form-control col-md-7 col-xs-12" placeholder="0.00"  ng-model="productoVO.precioUnico">
		                        	</div>
		                      </div>
		                     <div class="col-md-2 col-sm-2 col-xs-2">
		                     </div>
		                     <div class="col-md-8 col-sm-8 col-xs-8">
		                      <div class="x_panel">
		                      	<div class="form-group">
									<label class="control-label col-md-2 col-sm-2 col-xs-2" for="canal"> Canal 
									</label> 
									<div class="col-md-3 col-sm-3 col-xs-3">
									<select class="form-control col-md-7 col-xs-12" id="canal" name="canal" directiva-select2
										ng-options="canal.idCanal as canal.nombre for canal in listaCanales" 
										ng-model="idCanal">
										<option value="" selected="selected">Selecciona un canal
										</option>
									</select>
									</div>
								
									<div class="col-md-2 col-sm-2 col-xs-2">
		                     		</div>
			  						<div class="col-md-2 col-sm-2 col-xs-2">
        								<input type="text" id="precio" name="precio" class="form-control col-md-7 col-xs-12 ng-pristine ng-empty ng-invalid ng-invalid-required ng-touched" 
        								min="1" ng-model="precio" > 
      			  					</div>
      			  					
      			 					<div class="col-md-1 col-sm-1 col-xs-1 col-md-offset-0">
		                          		<button type="button" name="agregar" id="agregar" class="btn btn-success"
		                          		ng-click="agregarPrecio(idCanal,precio)">
		                          		<i class="fa fa-plus"></i> </button>
		                        	</div>
		                        </div> 
		                        
		                        <div class="form-group">
									<div class="col-md-3 col-sm-3 col-xs-12">
									</div>
									<div class="col-md-5 col-sm-5 col-xs-5">
										<br />
										<div
											class="table-responsive col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<table class="table table-striped jambo_table bulk_action">
												<thead>
													<tr class="headings">
														<th class="column-title text-center">Canal</th>
														<th class="column-title text-center">Precio</th>
														<th class="column-title text-center no-link last">Quitar</th>
													</tr>
												</thead>
		
												<tbody>
													<tr class="odd pointer" ng-repeat="canal in productoVO.preciosXCanalList" ng-if="canal.precio > 0">
														<td class="text-center">{{canal.nombre}}</td>
														<td>{{canal.precio | currency}}</td>
														<td class="text-center"><a href=""
															ng-click="quitarPrecio(canal)" title="Quitar Precio"><i
																class="success fa fa-minus-square-o"></i></a></td>
		
													</tr>
													<tr ng-if="productoVO.preciosXCanalList.length==0">
											<td class="text-center" colspan="4">No existen
												registros.</td>
										</tr> 
												</tbody>
											</table>
										</div>

									</div>
								</div>
		                     </div>   
		                      </div>
		                      <div class="col-md-2 col-sm-2 col-xs-2">
		                     </div>
		                      
								<div class="form-group">
		                      		<label class="control-label col-md-3 col-sm-3 col-xs-12" for="impuesto">Impuesto
		                        	</label>
		                        
	    							<div class="col-md-2 col-sm-2 col-xs-2">
		                          		<input type="text" id="impuesto" class="form-control col-md-7 col-xs-12" ng-model="impuesto">
		                        	</div>
								
    								<label class="control-label col-md-1 col-sm-1 col-xs-1" for="impuestoPorcentaje"> % 
		                        	</label>
    
	     							<div class="col-md-2 col-sm-2 col-xs-2">
			                          <input type="text" id="impuestoPorcentaje"  class="form-control col-md-7 col-xs-12" 
			                          placeholder="0.00" ng-model="porcentaje">
			                        </div>
		                        
		                        	<div class="col-md-1 col-sm-1 col-xs-1 col-md-offset-0">
		                          		<button type="button" name="agregar" id="agregar" class="btn btn-success" 
		                          		ng-click="agregarImpuesto(impuesto,porcentaje)">
		                          		<i class="fa fa-plus"></i> </button>
		                        	</div>
		                      </div>
								
							<div class="form-group">
									<div class="col-md-3 col-sm-3 col-xs-12">
									</div>
									<div class="col-md-5 col-sm-5 col-xs-5">
										<br />
										<div
											class="table-responsive col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<table class="table table-striped jambo_table bulk_action">
												<thead>
													<tr class="headings">
														<th class="column-title text-center">Impuesto</th>
														<th class="column-title text-center"> Porc. %</th>
														<th class="column-title text-center no-link last">Quitar</th>
													</tr>
												</thead>
		
												<tbody>
													<tr class="odd pointer" ng-repeat="imp in productoVO.impuestosList" ng-if="imp.porcentaje > 0">
														<td class="text-center">{{imp.nombre}}</td>
														<td>{{imp.porcentaje}}</td>
														<td class="text-center"><a href=""
															ng-click="quitarImpuesto(imp)" title="Quitar Impuesto"><i
																class="success fa fa-minus-square-o"></i></a></td>
		
													</tr>
													<tr ng-if="productoVO.articulosSeleccionadosList.length==0">
											<td class="text-center" colspan="4">No existen
												registros.</td>
										</tr> 
												</tbody>
											</table>
										</div>
										<!-- table-responsive -->
									</div>
								</div>	
								
		                      
							  <div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12" for="icono">Icono <span class="required">*</span>
									</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
 										<input id="icono_file" type="file" class="file" data-show-preview="false" 
 											ngf-select id="archivo" name="archivo"
											ngf-change="setArchivo($file)" accept=".jpg,.png,.jpeg,.gif,.ico">
										<script>
											$("#icono_file").fileinput({
												language: "es",
												uploadUrl: "/file-upload-batch/2",
												allowedFileExtensions: ["jpg", "png", "gif","ico"]
											});
											
										</script>
									</div>
								</div>
								
								<div ng-if="productoVO.idProducto">   	
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
		                      <div class="form-group">
		                        <div class="col-md-6 col-sm-6 col-xs-6 col-md-offset-3">
		                          <button type="submit" class="btn btn-success" ng-disabled="formProductos.$invalid"><i class="fa fa-save"></i>{{!productoVO.idProducto ? 'Guardar' : 'Actualizar'}}</button>
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
									<!-- aqui -->
									</form>
								</div>
	                      	  <br/>

		                <div class="x_panel">
		                    <div class="row">
								<div class="table-responsive col-lg-12 col-md-12 col-sm-12 col-xs-12 col-lg-offset-0 col-md-offset-2 col-sm-offset-0">
									<table id="datatable-responsive" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
									   	<thead>
									   		 <tr>
									   		 	<th class="text-center">SKU </th>
									           <th class="text-center">Producto </th>
									           <th class="text-center">Precio </th>
									           <th class="text-center">Estatus </th>
									           <th class="text-center">Editar </th>
											</tr>
									   	</thead>

										<tbody>
									    	<tr dir-paginate="p in listaProductos |  filter: filterSearch |itemsPerPage: 5">
									    	    <td class="text-center"><span ng-bind="p.sku"></span></td>   
									        	<td class="text-center"><span ng-bind="p.nombre"></span></td>
									        	<td class="text-center">{{p.precioUnico | currency}}</td>
									        	<td class="text-center"><span ng-bind="p.activo ? 'ACTIVO' : 'INACTIVO'"></span></td>
									        	<td class="text-center">
									       			<button type="button" ng-click="editarProducto(p.idProducto)" class="btn btn-round btn-default btn-md"><i class="fa fa-edit"></i></button>
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
