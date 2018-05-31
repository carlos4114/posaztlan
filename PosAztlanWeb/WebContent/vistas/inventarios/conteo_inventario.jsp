				<div class="x_panel">
					<div class="x_title">
						<h2><i class="fa fa-shopping-cart"></i> Conteo de Inventario</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
                      <br />
                	<div class="x_panel">
                		<div class="form-group">
		              			<label class="control-label col-md-1 col-sm-1 col-xs-1" for="folio">Folio 
		                        </label>
								<div class="col-md-2 col-sm-2 col-xs-2">
		                          <input type="text" id="folio" class="form-control col-md-7 col-xs-12"
		                          ng-model="parametrosBusquedaVO.folio">
		                        </div>
		                        
		                        <div class="col-md-6 col-sm-6 col-xs-6">
		                          		<button type="button" name="buscar" id="buscar" class="btn btn-success" 
		                          		ng-click="obtenerConteo()">
		                          		<i class="fa fa-search"></i> Buscar</button>
		                        </div>
		              		</div>
		              		
                	</div>
                      <div class="x_panel">
		                <form ng-submit="submit()" name="formConteo" id="formConteo" data-parsley-validate class="form-horizontal form-label-left">
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
											ng-model="parametrosBusquedaVO.idEmpresa">
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
												ng-model="parametrosBusquedaVO.idCanal">
												<option value="" selected="selected">Selecciona un canal
												</option>
											</select>
										</div>
				                      </div>
				                 </div>  
				                 <div ng-if="isAdminGral == 'true' || isAdminGralEmpresa == 'true' || isAdminCanal == 'true'">	   
			                      <div class="form-group">
			                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="perfil">Almacén
			                        </label>
			                        <div class="col-md-6 col-sm-6 col-xs-12">
										<select class="form-control col-md-7 col-xs-12" id="almacen" name="almacen" directiva-select2
											ng-change="cambiarAlmacen()"
											ng-options="almacen.idAlmacen as almacen.nombre for almacen in listaAlmacenes"
											ng-model="parametrosBusquedaVO.idAlmacen">
											<option value="" selected="selected">Selecciona un almacén
											</option>
										</select>
									</div>
			                      </div>
			                     </div>
			                     
			                     <div class="form-group">
		                        <div class="col-md-6 col-sm-6 col-xs-6 text-right">
		                          		<button type="button" name="buscar" id="buscar" class="btn btn-success" 
		                          		ng-click="obtenerProductosConteo()">
		                          		<i class="fa fa-search"></i> Buscar</button>
		                        </div>
		                        
		                         <div class="col-md-6 col-sm-6 col-xs-6 col-md-offset-0 text-left">
		                          <button type="button" ng-click="obtenerReporte()" class="btn btn-success" ><i class="fa fa-file-excel-o"></i>Reporte</button>
		                        </div>
		                        
		              		</div>
		              		
			                   </div>
			                  </div> 
			                 </div>
		              		
		              		<br>
		              
							<div class="table-responsive col-lg-12 col-md-12 col-sm-12 col-xs-12 col-lg-offset-0 col-md-offset-0 col-sm-offset-0">
		                   		<table id ="datatable-checkbox" class="table table-striped table-bordered dt-responsive nowrap" role ="grid" aria-describedby="datatable-checkbox_info">
		                   			<thead>
		                   				<tr role="row" class="odd pointer" >
		                   					
		                   					<th class="sorting_asc" aria-sort="ascending"> SKU</th>
		                   					<th class="sorting_asc" aria-sort="ascending"> Nombre</th>
		                   					<th class="sorting_asc" aria-sort="ascending"> Almacen</th>
		                   					<th class="sorting_asc" aria-sort="ascending"> Familia</th>
		                   					<th class="sorting_asc" aria-sort="ascending"> Marca</th>
		                   					<th class="sorting_asc" aria-sort="ascending"> Tipo</th>
		                   					<th class="sorting_asc" aria-sort="ascending"> Medida</th>
		                   					<th class="sorting_asc" aria-sort="ascending"> Existencia Sistema</th>
		                   					<th class="sorting_asc" aria-sort="ascending"> Existencia Física</th>
		                   					<th class="sorting_asc" aria-sort="ascending"> Diferencia</th>
		                   					<th class="sorting_asc" aria-sort="ascending"> U. Medida</th>
		                   				</tr>
		                   			</thead>
		                   			
		                   			<tbody>
										<tr ng-repeat="producto in listaProductos">
											
											<td class="text-center">{{producto.sku}}</td>
											<td class="text-center">{{producto.nombre}}</td>
											<td class="text-center">{{producto.idAlmacen}}</td>
											<td>{{producto.familia}}</td>
											<td>{{producto.marca}}</td>
											<td>{{producto.tipoProducto}}</td>
											<td>{{producto.medida}}</td>
											<td>{{producto.existencia}}</td>
											<td>
												<div>
													<input type="text" ng-model="producto.existenciaFisica"  ng-disabled="conteoVO.nombreEstatus == 'CERRADO' || conteoVO.nombreEstatus == 'AUTORIZADO'" class="col-xs-10" ng-change="calcularDiferencia(producto)">
												</div>
											</td>
											<td>{{producto.diferencia}}</td>
											<td>{{producto.unidadMedida}}</td>
										</tr>
										
									</tbody>
		                   		</table>
		                   </div>
	    	                 
		                      <div class="form-group">
		                        <div ng-if="isAutorizadorConteo == 'false'">
			                      
			                      	<div class="col-md-6 col-sm-6 col-xs-6 col-md-offset-0 text-right">
			                          <button type="button" ng-click="guardarParcial()" class="btn btn-success" ><i class="fa fa-save"></i>Guardar Parcial</button>
			                        </div>
			                        <div class="col-md-6 col-sm-6 col-xs-6 col-md-offset-0 text-left">
			                          <button type="button" ng-click="cerrarConteo()" class="btn btn-success" ><i class="fa fa-save"></i>Cerrar Conteo</button>
			                        </div>
			                    </div>     
			                        
		                        <div ng-if="isAutorizadorConteo == 'true' && conteoVO.nombreEstatus == 'CERRADO'">
			                        <div class="col-md-12 col-sm-12 col-xs-12 col-md-offset-0 text-center">
			                          <button type="button" ng-click="autorizar()" ng-disabled="conteoVO.nombreEstatus == 'AUTORIZADO'" class="btn btn-success" ><i class="fa fa-save"></i>Autorizar Conteo</button>
			                        </div>
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