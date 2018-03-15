				<div class="x_panel">
					<div class="x_title">
						<h2><i class="fa fa-shopping-cart"></i> Ordenes de compra/pedidos</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
                      <br />
                	
                      <div class="x_panel">
		                <form ng-submit="submit()" name="formOrdenCompra" id="formOrdenCompra" data-parsley-validate class="form-horizontal form-label-left">
		              		<div class="form-group">
		              			<label class="control-label col-md-3 col-sm-3 col-xs-3" for="proveedor">Proveedor 
		                        </label>
		                        <div class="col-md-3 col-sm-3 col-xs-3">
									<select class="form-control col-md-7 col-xs-12" id="proveedor" name="proveedor" directiva-select2
										ng-options="proveedor.id as proveedor.nombre for proveedor in listaProveedores"
										ng-model="ordenCompraVO.idProveedor">
										<option value="" selected="selected">Selecciona un proveedor
										</option>
									</select>
								</div>
								<label class="control-label col-md-2 col-sm-2 col-xs-2" for="descuento">Descuento
		                        </label>
								<div class="col-md-2 col-sm-2 col-xs-2">
		                          <input type="text" id="descuento" class="form-control col-md-7 col-xs-12"
		                          ng-model="ordenCompraVO.descuento">
		                        </div>
		              		</div>
		              		<br>
		              		<h2 align="center"> Filtros </h2>
		              		<div class="col-md-10 col-md-offset-1" align="center">
		              		<div class="x_panel">
		              		<div class="form-group">
		              			 <label class="control-label col-md-2 col-sm-2 col-xs-2" for="familia">Familia
		                        </label>
		                        <div class="col-md-3 col-sm-3 col-xs-3">
									<select class="form-control col-md-7 col-xs-12" id="familia" name="familia" directiva-select2
									ng-options="familia.id as familia.nombre for familia in listaFamilias" 
										ng-model="filtrosVO.idFamilia">
										<option value="" selected="selected">Selecciona una familia
										</option>
									</select>
								</div>
								<label class="control-label col-md-3 col-sm-3 col-xs-3" for="marca">Marca
		                        </label>
		                        <div class="col-md-3 col-sm-3 col-xs-3">
									<select class="form-control col-md-7 col-xs-12" id="marca" name="marca" directiva-select2
									ng-options="marca.id as marca.nombre for marca in listaMarcas" 
									ng-model="filtrosVO.idMarca">
										<option value="" selected="selected">Selecciona una Marca
										</option>
									</select>
								</div>
		              		</div>
		              		<div class="form-group">
		              			 <label class="control-label col-md-2 col-sm-2 col-xs-12" for="tipo">Tipo
		                        </label>
		                        <div class="col-md-3 col-sm-3 col-xs-3">
									<select class="form-control col-md-7 col-xs-12" id="tipo" name="tipo" directiva-select2
									ng-options="tipo.id as tipo.nombre for tipo in listaTipos" 
									ng-model="filtrosVO.idTipoProducto">
										<option value="" selected="selected">Selecciona un tipo
										</option>
									</select>
								</div>
								
		                       <label class="control-label col-md-3 col-sm-3 col-xs-3" for="tipo">Medida
		                        </label>
		                        <div class="col-md-3 col-sm-3 col-xs-3">
									<select class="form-control col-md-7 col-xs-12" id="medida" name="medida" directiva-select2
									ng-options="medida.id as medida.nombre for medida in listaMedidas" 
									ng-model="filtrosVO.idMedida">
										<option value="" selected="selected">Selecciona una medida
										</option>
									</select>
								</div>
		              		</div>
		              		
		              		<div class="form-group">
		                        <label class="control-label col-md-2 col-sm-2 col-xs-3" for="Nombre">Nombre
		                        </label>
		                        <div class="col-md-3 col-sm-3 col-xs-3">
									<input type="text" id="nombre" class="form-control col-md-7 col-xs-12" ng-model="filtrosVO.nombre">
								</div>
								
		                        
		              		</div>
		              		
		              		<div class="form-group">
		              			<div class="col-md-12 col-sm-12 col-xs-12 col-md-offset-0 text-center">
		                          		<button type="button" name="buscar" id="buscar" class="btn btn-success" 
		                          		ng-click="buscar(filtrosVO)">
		                          		<i class="fa fa-search"></i> Buscar</button>
		                        </div>
		              		</div>
		              			</div>
		              		</div>
		              		
		                
							<div class="table-responsive col-lg-12 col-md-12 col-sm-12 col-xs-12 col-lg-offset-0 col-md-offset-0 col-sm-offset-0">
		                   		<table id ="datatable-checkbox" class="table table-striped table-bordered dt-responsive nowrap" role ="grid" aria-describedby="datatable-checkbox_info">
		                   			<thead>
		                   				<tr role="row" class="odd pointer" >
		                   					<th>
		                   						<div>
		                   							<input type="checkbox" id="check-all" class="icheckbox_flat-green" ng-model="seleccionarTodosCh" ng-click="seleccionarTodos()">
		                   						</div>
		                   					</th>
		                   					<th class="sorting_asc" aria-sort="ascending"> Nombre</th>
		                   					<th class="sorting_asc" aria-sort="ascending"> Familia</th>
		                   					<th class="sorting_asc" aria-sort="ascending"> Marca</th>
		                   					<th class="sorting_asc" aria-sort="ascending"> Tipo</th>
		                   					<th class="sorting_asc" aria-sort="ascending"> Medida</th>
		                   					<th class="sorting_asc" aria-sort="ascending"> U. Medida</th>
		                   					<th class="sorting_asc" aria-sort="ascending"> Descripción</th>
		                   					<th class="sorting_asc" aria-sort="ascending" width="80"> Precio U.</th>	
		                   					<th class="sorting_asc" aria-sort="ascending" width="80"> Cantidad</th>
		                   				</tr>
		                   			</thead>
		                   			
		                   			<tbody>
										<tr ng-repeat="producto in listaProductos">
											<td>
												<div>
													<input type="checkbox" class="icheckbox_flat-green" ng-model="producto.seleccionado">
												</div>
											</td>
											<td class="text-center">{{producto.nombre}}</td>
											<td>{{producto.nombreFamilia}}</td>
											<td>{{producto.nombreMarca}}</td>
											<td>{{producto.nombreTipo}}</td>
											<td>{{producto.nombreMedida}}</td>
											<td>{{producto.nombreUnidadMedida}}</td>
											<td>{{producto.descripcion}}</td>
											<td>
												<div>
													<input type="text" ng-model="producto.precioUnitario" class="col-xs-10">
												</div>
											</td>
											<td>
												<div>
													<input type="text" ng-model="producto.cantidad" class="col-xs-10">
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
									           <th class="text-center">Nombre </th>
									           <th class="text-center">Familia </th>
									           <th class="text-center">Marca </th>
									           <th class="text-center">Tipo </th>
									           <th class="text-center"> Medida</th>
		                   					   <th class="text-center">U. Medida</th>
		                   				       <th class="text-center">Descripción</th>
		                   					   <th class="text-center">Precio U.</th>	
		                   					   <th class="text-center">Cantidad</th>
		                   					   <th class="column-title text-center no-link last">Quitar</th>
											</tr>
									   	</thead>

										<tbody>
									    	<tr dir-paginate="p in ordenCompraVO.productos |  filter: filterSearch |itemsPerPage: 10">   
									        	<td class="text-center"><span ng-bind="p.nombre"></span></td>
												<td class="text-center"><span ng-bind="p.nombreFamilia"></span></td>
												<td class="text-center"><span ng-bind="p.nombreMarca"></span></td>
												<td class="text-center"><span ng-bind="p.nombreTipo"></span></td>
												<td class="text-center"><span ng-bind="p.nombreMedida"></span></td>
												<td class="text-center"><span ng-bind="p.nombreUnidadMedida"></span></td>
												<td class="text-center"><span ng-bind="p.descripcion"></span></td>
												<td class="text-center">{{p.precioUnitario}}</td>
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