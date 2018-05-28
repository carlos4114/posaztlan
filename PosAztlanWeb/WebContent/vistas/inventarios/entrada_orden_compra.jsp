				<div class="x_panel">
					<div class="x_title">
						<h2><i class="fa fa-shopping-cart"></i> Entrada</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
                      <br />
                	
                      <div class="x_panel">
		                <form ng-submit="submit()" name="formEntrada" id="formEntrada" data-parsley-validate class="form-horizontal form-label-left">
		              		<div class="form-group">
		              			<label class="control-label col-md-2 col-sm-2 col-xs-2" for="ordenCompra">Orden de Compra
		                        </label>
								<div class="col-md-2 col-sm-2 col-xs-2">
		                          <input type="text" id="ordencompra" class="form-control col-md-7 col-xs-12"
		                          ng-model="filtrosVO.idOrdenCompra">
		                        </div>
		                        
		                        <div class="col-md-5 col-sm-5 col-xs-5">
		                          		<button type="button" name="buscar" id="buscar" class="btn btn-success" 
		                          		ng-click="obtenerOrdenCompra()">
		                          		<i class="fa fa-search"></i> Buscar</button>
		                        </div>
		                        
		              		</div>
		              		<br>
		              
							<div class="table-responsive col-lg-12 col-md-12 col-sm-12 col-xs-12 col-lg-offset-0 col-md-offset-0 col-sm-offset-0">
		                   		<table id ="datatable-checkbox" class="table table-striped table-bordered dt-responsive nowrap" role ="grid" aria-describedby="datatable-checkbox_info">
		                   			<thead>
		                   				<tr role="row" class="odd pointer" >
		                   					<th>
		                   						<div>
		                   							<input type="checkbox" id="check-all" class="icheckbox_flat-green" 
		                   							ng-model="seleccionarTodosCh" ng-click="seleccionarTodos()" ng-disabled ="producto.cantidadFinal != null">
		                   						</div>
		                   					</th>
		                   					<th class="sorting_asc" aria-sort="ascending"> Nombre</th>
		                   					<th class="sorting_asc" aria-sort="ascending"> Familia</th>
		                   					<th class="sorting_asc" aria-sort="ascending"> Marca</th>
		                   					<th class="sorting_asc" aria-sort="ascending"> Tipo</th>
		                   					<th class="sorting_asc" aria-sort="ascending"> Medida</th>
		                   					<!-- <th class="sorting_asc" aria-sort="ascending"> U. Medida</th> -->
		                   					<th class="sorting_asc" aria-sort="ascending"> Descripción</th>
		                   					<th class="sorting_asc" aria-sort="ascending" width="80"> Precio U.</th>
		                   					<th class="sorting_asc" aria-sort="ascending" width="80"> Precio U. Final</th>	
		                   					<th class="sorting_asc" aria-sort="ascending" width="80"> Cantidad</th>
		                   					<th class="sorting_asc" aria-sort="ascending" width="80"> Cant. Entrada</th>
		                   					<th class="sorting_asc" aria-sort="ascending" width="80"> Cant. Restante</th>
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
									<!--		<td>{{producto.nombreUnidadMedida}}</td> -->
											<td>{{producto.descripcion}}</td>
											<td>{{producto.precioUnitario}}</td>
											<td>
												<div>
													<input type="text" ng-model="producto.precioUnitarioFinal" class="col-xs-10" ng-disabled="producto.nombreEstatus != 'NUEVA'">
												</div>
											</td>
											<td>{{producto.cantidad}}</td>
											<td>
												<div>
													<input type="text" ng-model="producto.cantidadFinal" class="col-xs-10" ng-disabled="producto.nombreEstatus == 'CERRADA'">
												</div>
											</td>
											<td>{{producto.cantidadRestante}}</td>
										</tr>
										
									</tbody>
		                   		</table>
		                   </div>
	    	                 
		                      <div class="form-group">
		                      	<div class="col-md-6 col-sm-6 col-xs-6 col-md-offset-0 text-right">
		                          <button type="button" ng-click="guardarParcial()" class="btn btn-success" ><i class="fa fa-save"></i>Guardar Parcial</button>
		                        </div>
		                        <div class="col-md-6 col-sm-6 col-xs-6 col-md-offset-0 text-left">
		                          <button type="button" ng-click="cerrarOrdenCompra()" class="btn btn-success" ><i class="fa fa-save"></i>Cerrar Orden</button>
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
			
					</div> <!-- content -->
				</div> <!-- xpanel -->
				</div>