				<div class="x_panel">
					<div class="x_title">
						<h2><i class="fa fa-shopping-cart"></i> Venta Manual</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
                      <br />
                	
                      <div class="x_panel">
		                <form ng-submit="submit()" name="formVentaManual" id="formVentaManual" data-parsley-validate class="form-horizontal form-label-left">
		              	  
			              <div ng-if="isAdminGral == 'true' || isAdminGralEmpresa == 'true' || isAdminCanal == 'true'">	
		              	   <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" align="center">
				             <div class="x_panel">		              	  
			              	  <div ng-if="isAdminGral == 'true'">	
			              		<div class="form-group">
			              			<label class="control-label col-md-3 col-sm-3 col-xs-12" for="empresa">Empresa<span class="required">*</span> 
			                        </label>
			                        <div class="col-md-6 col-sm-6 col-xs-12">
										<select class="form-control col-md-7 col-xs-12" id="empresa" name="empresa" directiva-select2
											ng-change="cambiarEmpresa()"
											ng-options="empresa.id as empresa.nombre for empresa in listaEmpresas"
											ng-model="filtrosVO.idEmpresa">
											<option value="" selected="selected">Selecciona una empresa
											</option>
										</select>
									</div>								
				          		 </div>
			                    </div>  
			                    <div ng-if="isAdminGral == 'true' || isAdminGralEmpresa == 'true'">	
					          		<div class="form-group">
				                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="perfil">Canal<span class="required">*</span>
				                        </label>
				                        <div class="col-md-6 col-sm-6 col-xs-12">
											<select class="form-control col-md-7 col-xs-12" id="canal" name="canal" directiva-select2
												ng-change="cambiarCanal()"
												ng-options="canal.idCanal as canal.nombre for canal in listaCanales"
												ng-model="filtrosVO.idCanal">
												<option value="" selected="selected">Selecciona un canal
												</option>
											</select>
										</div>
				                      </div>
				                 </div>  
				                 <div ng-if="isAdminGral == 'true' || isAdminGralEmpresa == 'true' || isAdminCanal == 'true'">	   
			                      <div class="form-group">
			                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="perfil">Almacén<span class="required">*</span>
			                        </label>
			                        <div class="col-md-6 col-sm-6 col-xs-12">
										<select class="form-control col-md-7 col-xs-12" id="almacen" name="almacen" directiva-select2
											ng-change="cambiarAlmacen()"
											ng-options="almacen.idAlmacen as almacen.nombre for almacen in listaAlmacenes"
											ng-model="filtrosVO.idAlmacen">
											<option value="" selected="selected">Selecciona un almacén
											</option>
										</select>
									</div>
			                      </div>
			                     </div>
			                   </div>
			                  </div> 
			                 </div>    	
		              		<br>
		              		<div ng-if="filtrosVO.idAlmacen != 'null' && filtrosVO.idAlmacen != null">	
			              		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" align="center">
				              		<div class="x_panel">
			              				<h2 align="center"> Filtros </h2>
			              				<br />
					              		<div class="form-group">
					              			 <label class="control-label col-md-2 col-sm-2 col-xs-2" for="sku">SKU
					                        </label>			                       
					                        <div class="col-md-3 col-sm-3 col-xs-3">
												<input type="text" id="sku" class="form-control col-md-7 col-xs-12" ng-model="filtrosVO.sku">
											</div>
											<label class="control-label col-md-2 col-sm-2 col-xs-3" for="Nombre">Nombre
					                        </label>
					                        <div class="col-md-3 col-sm-3 col-xs-3">
												<input type="text" id="nombre" class="form-control col-md-7 col-xs-12" ng-model="filtrosVO.nombre">
											</div>
					              		</div>			              		
					              		
					              		<div class="form-group">
					              			<div class="col-md-12 col-sm-12 col-xs-12 col-md-offset-0 text-center">
					                          		<button type="button" name="buscar" id="buscar" class="btn btn-success" 
					                          		ng-click="buscar()">
					                          		<i class="fa fa-search"></i> Buscar</button>
					                        </div>
					              		</div>
				              		</div>
			              		</div>
			              	</div>	
		              		
		                	<br /><br />
							<div class="table-responsive col-lg-12 col-md-12 col-sm-12 col-xs-12 col-lg-offset-0 col-md-offset-0 col-sm-offset-0">
		                   		<table id ="datatable-checkbox" class="table table-striped table-bordered dt-responsive nowrap" role ="grid" aria-describedby="datatable-checkbox_info">
		                   			<thead>
		                   				<tr role="row" class="odd pointer" >
		                   					<th>
		                   						<div>
		                   							<input type="checkbox" id="check-all" class="icheckbox_flat-green" ng-model="seleccionarTodosCh" ng-click="seleccionarTodos()">
		                   						</div>
		                   					</th>
		                   					<th class="sorting_asc" aria-sort="ascending"> SKU</th>
		                   					<th class="sorting_asc" aria-sort="ascending"> Nombre</th>
		                   					<th class="sorting_asc" aria-sort="ascending"> Familia</th>
		                   					<th class="sorting_asc" aria-sort="ascending"> Marca</th>
		                   					<th class="sorting_asc" aria-sort="ascending"> Tipo</th>
		                   					<th class="sorting_asc" aria-sort="ascending"> Medida</th>
		                   					<th class="sorting_asc" aria-sort="ascending"> U. Medida</th>
		                   					<th class="sorting_asc" aria-sort="ascending"> Existencia</th>	
		                   					<th class="sorting_asc" aria-sort="ascending"> Precio U.</th>	
		                   					<th class="sorting_asc" aria-sort="ascending" width="80"> Cantidad</th>
		                   				</tr>
		                   			</thead>
		                   			
		                   			<tbody>
										<tr ng-repeat="producto in listaProductos">
											<td>
												<div>
													<input type="checkbox" ng-disabled="producto.validarExistencia && producto.existencia<=0" class="icheckbox_flat-green" ng-model="producto.seleccionado">
												</div>
											</td>
											<td class="text-center">{{producto.sku}}</td>
											<td>{{producto.nombre}}</td>
											<td>{{producto.familia}}</td>
											<td>{{producto.marca}}</td>
											<td>{{producto.tipoProducto}}</td>
											<td>{{producto.medida}}</td>
											<td>{{producto.unidadMedida}}</td>
											<td>{{producto.existencia}}</td>
											<td>{{producto.precio}}</td>
											<td>
												<div>
													<input type="text" ng-disabled="producto.validarExistencia && producto.existencia<=0" ng-model="producto.cantidad" class="col-xs-10">
												</div>
											</td>											
										</tr>
										
									</tbody>
		                   		</table>
		                   </div>
	    	                 
		                      <div class="form-group">
			                    <div class="col-md-12 col-sm-12 col-xs-12 col-md-offset-0 text-center">
		                          <button type="button" ng-click="agregar()" class="btn btn-success" ><i class="fa fa-save"></i>Agregar</button>
		                          <button type="button" ng-click="confirmarNuevo()" class="btn btn-primary" ><i class="fa fa-file-o"></i>Nuevo</button>
		                        </div>
		                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 col-md-offset-0 text-center">
		                        	<div class="alert alert-success" align="center" role="alert" ng-show="mensajeGeneral.length">	  
									  	 <span  class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span>
									     {{mensajeGeneral}}
						            </div>
		                        	<div class="alert" align="center" role="alert" ng-show="errorGeneral.length">	  
									  	 <span  class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
									     {{errorGeneral}}
						            	 <br/>
		    		          	    </div>
		                        </div>
		                      </div>       
						</form>
						
						 <div class="x_panel">
		                    <div class="row">
								<div class="table-responsive col-lg-12 col-md-12 col-sm-12 col-xs-12 col-lg-offset-0 col-md-offset-0 col-sm-offset-0">
									<table id="datatable-responsive" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
									   	<thead>
									   		 <tr>
									           <th class="text-center">SKU </th>
									           <th class="text-center">Nombre </th>
									           <th class="text-center">Familia </th>
									           <th class="text-center">Marca </th>
									           <th class="text-center">Tipo </th>
									           <th class="text-center"> Medida</th>
		                   					   <th class="text-center">U. Medida</th>
		                   					   <th class="text-center">Existencia</th>	
		                   					   <th class="text-center">Precio U.</th>	
		                   					   <th class="text-center">Cantidad</th>
		                   					   <th class="column-title text-center no-link last">Quitar</th>
											</tr>
									   	</thead>

										<tbody>
									    	<tr dir-paginate="p in ventaManualVO.productos |  filter: filterSearch |itemsPerPage: 10">   
									        	<td class="text-center"><span ng-bind="p.sku"></span></td>
									        	<td class="text-center"><span ng-bind="p.nombre"></span></td>
												<td class="text-center"><span ng-bind="p.familia"></span></td>
												<td class="text-center"><span ng-bind="p.marca"></span></td>
												<td class="text-center"><span ng-bind="p.tipoProducto"></span></td>
												<td class="text-center"><span ng-bind="p.medida"></span></td>
												<td class="text-center"><span ng-bind="p.unidadMedida"></span></td>
												<td class="text-center"><span ng-bind="p.existencia"></span></td>
												<td class="text-center"><span ng-bind="p.precio"></span></td>
												<td class="text-center">{{p.cantidad}}</td>
												<td class="text-center"><a href=""
															ng-click="quitar(p.idProducto)" title="Quitar"><i
																class="success fa fa-minus-square-o"></i></a></td>
												
											</tr>
										</tbody>
										<dir-pagination-controls></dir-pagination-controls>
									</table>
								</div> <!-- table-responsive -->
							</div> <!-- row -->
							
							<div class="form-group">
		                        <div class="col-md-12 col-sm-12 col-xs-12 col-md-offset-0 text-center">
		                          <button type="button" ng-click="submit()" class="btn btn-success" ><i class="fa fa-save"></i>Guardar</button>
		                        </div>
		                      </div>
		                      
						</div>
					</div> <!-- content -->
				</div> <!-- xpanel -->
				</div>