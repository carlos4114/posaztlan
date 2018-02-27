				<div class="x_panel">
					<div class="x_title">
						<h2><i class="fa fa-shopping-cart"></i> Paquetes Dulcer&iacute;a </h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
                      <br />
                      <div class="x_panel">
		                   <form ng-submit="submit()" name="formPaquetes" id="formPaquetes" data-parsley-validate class="form-horizontal form-label-left">
		                   <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="cine">Cine<span class="required">*</span>
		                        </label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
									<select class="form-control col-md-7 col-xs-12" id="cine" name="cine" directiva-select2
										ng-change="cambiarCine(paqueteVO.idCine)"
										ng-options="cine.idCine as cine.nombre for cine in listaCines"
										ng-model="paqueteVO.idCine">
										<option value="" selected="selected">Selecciona un cine
										</option>
									</select>
								</div>
		                      </div>
		                      <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="puntoVenta">Punto de Venta<span class="required">*</span>
		                        </label>.
		                        <div class="col-md-6 col-sm-6 col-xs-12">
									<select class="select2_multiple form-control" multiple="multiple"
											ng-options="puntoVenta.idPuntoVenta as puntoVenta.nombre for puntoVenta in listaPuntosVenta"
											ng-model="paqueteVO.puntosVentaList ">
										</select>
						
										<script>
											$(".select2_multiple").select2({
												allowClear : true
											});
										</script>
								</div>
		                      </div>
		                      <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="nombre-producto">Nombre del Paquete <span class="required">*</span>
		                        </label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
		                          <input type="text" id="nombre-paquete" required="required" class="form-control col-md-7 col-xs-12"
		                          ng-model="paqueteVO.nombre">
		                        </div>
		                      </div>
		                      
		                      <div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12" for="articulo"> Producto <span class="required">*</span>
									</label> 
									<div class="col-md-3 col-sm-3 col-xs-3">
									<select class="form-control col-md-7 col-xs-12" id="paquete" name="paquete" directiva-select2 required
										ng-options="paquete.idProducto as paquete.nombre for paquete in listaProductos" 
										ng-model="idProducto">
										<option value="" selected="selected">Selecciona un Producto
										</option>
									</select>
									</div>
								
			  						<div class="col-md-1 col-sm-1 col-xs-1">
        								<input type="number" id="cantidad" name="cantidad" ng-required="true" class="form-control col-md-7 col-xs-12 ng-pristine ng-empty ng-invalid ng-invalid-required ng-touched" 
        								min="1" ng-model="cantidad" > 
      			  					</div>
      			  					
      			 					<div class="col-md-1 col-sm-1 col-xs-1 col-md-offset-0">
		                          		<button type="button" name="agregar" id="agregar" class="btn btn-success"
		                          		ng-click="agregarProducto(idProducto,cantidad)">
		                          		<i class="fa fa-plus"></i> </button>
		                        	</div>
		                        	
		                        </div>
		                        <br>
		                       
		                        <div class="form-group">
		                        <div class="col-md-3 col-sm-3 col-xs-12">
									</div>
									<div class="col-md-4 col-sm-4 col-xs-4">
										<br />
										<div
											class="table-responsive col-lg-8 col-md-8 col-sm-8 col-xs-8">
											<table class="table table-striped jambo_table bulk_action">
												<thead>
													<tr>
														<th class="column-title text-center" colspan = 3>
															Productos a seleccionar
														</th>
													</tr>
													<tr class="headings">
														<th class="column-title text-center">Producto</th>
														<th class="column-title text-center">Cant.</th>
														<th class="column-title text-center no-link last">Quitar</th>
													</tr>
												</thead>
		
												<tbody>
													<tr class="odd pointer" ng-repeat="prd in productosAgregadosList" ng-if="prd.cantidad > 0">
														<td class="text-center">{{prd.nombre}}</td>
														<td>{{prd.cantidad}}</td>
														<td class="text-center"><a href=""
															ng-click="quitarProducto(prd)" title="Quitar Producto"><i
																class="success fa fa-minus-square-o"></i></a></td>
		
													</tr>
													<tr ng-if="productosAgregadosList.length==0">
											<td class="text-center" colspan="4">No existen
												registros.</td>
										</tr> 
												</tbody>
											</table>
										</div>
										
										<div class="col-md-1 col-sm-1 col-xs-1 col-md-offset-0">
		                          			<button type="button" name="opcion" id="opcion" class="btn btn-success"
		                          			ng-click="agregarProductos(productosAgregadosList)">
		                          			<i class="fa fa-plus"></i> </button>
		                        		</div>
										<!-- table-responsive -->
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
													<tr>
														<th class="column-title text-center" colspan = 3>
															Productos que contiene el paquete
														</th>
													</tr>
													<tr class="headings">
														<th class="column-title text-center">Producto</th>
														<th class="column-title text-center">Cant.</th>
														<th class="column-title text-center no-link last">Quitar</th>
													</tr>
												</thead>
		
												<tbody>
													<tr class="odd pointer" ng-repeat="prd in paqueteVO.productosSeleccionadosList" ng-if="prd.cantidad > 0">
														<td class="text-center">
															<table class="table table-striped jambo_table bulk_action">
																<thead>
																</thead>
																<tbody>
																	<tr class="odd pointer" ng-repeat="paq in prd.productosAgregadosList">
																		<td class="text-center">{{paq.nombre}}</td>
																	</tr>
																</tbody>
															</table>
														</td>
														<td>{{prd.cantidad}}</td>
														<td class="text-center"><a href=""
															ng-click="quitarProductos(prd)" title="Quitar Producto"><i
																class="success fa fa-minus-square-o"></i></a></td>
		
													</tr>
													<tr ng-if="paqueteVO.productosSeleccionadosList.length==0">
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
		                        	<label class="control-label col-md-3 col-sm-3 col-xs-3" for="precio_sugerido">Precio Sugerido <span class="required">*</span>
		                        	</label>
		                        	<div class="col-md-2 col-sm-2 col-xs-2">
		                          		<input type="text" id="precio_sugerido" class="form-control col-md-7 col-xs-12" placeholder="0.00" ng-model="precioSugerido" readonly="readonly" value="precioSugerido|currency">
		                        	</div>
		                      </div>
								
								<div class="form-group">
		                        	<label class="control-label col-md-3 col-sm-3 col-xs-3" for="precio-venta">Precio de Venta <span class="required">*</span>
		                        	</label>
		                        	<div class="col-md-2 col-sm-2 col-xs-2">
		                          		<input type="text" id="precio-venta" required="required" class="form-control col-md-7 col-xs-12" placeholder="0.00" ng-model="paqueteVO.precio" value="paqueteVO.precio|currency">
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
								
								<div ng-if="paqueteVO.idPaquete">   	
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
		                          <button type="submit" class="btn btn-success" ng-disabled="formPaquetes.$invalid"><i class="fa fa-save"></i>{{!paqueteVO.idPaquete ? 'Guardar' : 'Actualizar'}}</button>
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
								<div class="table-responsive col-lg-6 col-md-6 col-sm-12 col-xs-12 col-lg-offset-3 col-md-offset-2 col-sm-offset-1">
									<table id="datatable-responsive" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
									   	<thead>
									   		 <tr>
									           <th class="text-center">Paquete </th>
									           <th class="text-center">Precio </th>
									           <th class="text-center">Estatus </th>
									           <th class="text-center">Editar </th>
											</tr>
									   	</thead>

										<tbody>
									    	<tr dir-paginate="p in listaPaquetes |  filter: filterSearch |itemsPerPage: 5">   
									        	<td class="text-center"><span ng-bind="p.nombre"></span></td>
									        	<td class="text-center">{{p.precio | currency}}</td>
									        	<td class="text-center"><span ng-bind="p.activo ? 'ACTIVO' : 'INACTIVO'"></span></td>
									        	<td class="text-center">
									       			<button type="button" ng-click="editarPaquete(p.idPaquete)" class="btn btn-round btn-default btn-md"><i class="fa fa-edit"></i></button>
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
