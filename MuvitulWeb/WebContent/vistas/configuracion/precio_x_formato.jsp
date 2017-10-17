				<div class="x_panel">
					<div class="x_title">
						<h2><i class="fa fa-money"></i> Precios Por Formato </h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
                      <br />
                      <div class="x_panel">
		                   <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left">

		                      <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="formato">Formato<span class="required">*</span>
		                        </label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
				                          <div class="btn-group btn-group-justified" data-toggle="buttons">
					                        <label class="btn btn-primary active">
					                          <input type="radio" class="sr-only" id="formato-2d" name="formato" value="2D" checked>
					                          <span class="docs-tooltip">
					                            2D
					                          </span>
					                        </label>
					                        <label class="btn btn-primary">
					                          <input type="radio" class="sr-only" id="formato-3d" name="formato" value="3D">
					                          <span class="docs-tooltip">
					                            3D
					                          </span>
					                        </label>
					                        <label class="btn btn-primary">
					                          <input type="radio" class="sr-only" id="formato-4d" name="formato" value="4D">
					                          <span class="docs-tooltip" >
					                            4D
					                          </span>
					                        </label>
					                      </div>
				                </div>
		                      </div>
							  <div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12" for="precio">Precio de Venta <span class="required">*</span>
									</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
									  <input type="text" id="precio" required="required" class="form-control col-md-7 col-xs-12" placeholder="0.00">
									</div>
							  </div>
							  <div class="form-group">
							  	   <label class="control-label col-md-3 col-sm-3 col-xs-12" for="horario_de">Horario <span class="required">*</span>
							  	   </label>
							  	   <div class="col-md-2 col-sm-2 col-xs-5">
							  			<div class='input-group date' id='horario-de'>
										     <input type='text' class="form-control" />
										     <span class="input-group-addon">
										          <span class="glyphicon glyphicon-time"></span>
										     </span>
                						</div>
							  	   </div>
							  	   <label class="control-label col-md-1 col-sm-1 col-xs-3" for="horario_hasta"> a </span>
							  	   </label>
							  	   <div class="col-md-2 col-sm-2 col-xs-5">
							  			<div class='input-group date' id='horario-hasta'>
										     <input type='text' class="form-control" />
										     <span class="input-group-addon">
										          <span class="glyphicon glyphicon-time"></span>
										     </span>
                						</div>
							  	   </div>
							  	   <script>
							  	   $(function () {
									    $('#horario-de').datetimepicker({
									        format: 'LT'
									    });
									    $('#horario-hasta').datetimepicker({
									        format: 'LT'
									    });
									    
									});									
									</script>
							  </div>
	                      	  <br/>
		                      <div class="form-group">
		                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
		                          <button type="submit" class="btn btn-success"><i class="fa fa-usd"></i> Guardar </button>
		                        </div>
		                      </div>

							</form>
						</div>
		                <div class="x_panel">
		                    <div class="row">
										              <div class="table-responsive col-lg-6 col-md-6 col-sm-12 col-xs-12 col-lg-offset-3 col-md-offset-2 col-sm-offset-1">
									                      <table id="datatable-responsive" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
									                        <thead>
									                          <tr>
									                            <th class="text-center">Formato </th>
									                            <th class="text-center">Precio </th>
									                            <th class="text-center">Horario </th>
									                            <th class="text-center">Eliminar </th>
															  </tr>
									                        </thead>

									                        <tbody>
									                          <tr>
									                            <td class="text-center">2D</td>
									                            <td class="text-center">$ 38.00</td>
									                            <td class="text-center">10:00 AM a 13:00 PM</td>
									                            <td class="text-center">
									                              <button type="button" class="btn btn-round btn-default btn-md"><i class="fa fa-trash-o"></i></button>
																</td>
									                          </tr>
									                          <tr>
									                            <td class="text-center">2D</td>
									                            <td class="text-center">$ 42.00</td>
									                            <td class="text-center">13:00 PM a 23:00 PM</td>
									                            <td class="text-center">
									                              <button type="button" class="btn btn-round btn-default btn-md"><i class="fa fa-trash-o"></i></button>
																</td>
									                          </tr>
									                          <tr>
									                            <td class="text-center">3D</td>
									                            <td class="text-center">$ 50.00</td>
									                            <td class="text-center">10:00 AM a 23:00 PM</td>
									                            <td class="text-center">
									                              <button type="button" class="btn btn-round btn-default btn-md"><i class="fa fa-trash-o"></i></button>
																</td>
									                          </tr>
															  <tr>
																<td class="text-center">4D</td>
																<td class="text-center">$ 55.00</td>
									                            <td class="text-center">10:00 AM a 23:00 PM</td>
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
	