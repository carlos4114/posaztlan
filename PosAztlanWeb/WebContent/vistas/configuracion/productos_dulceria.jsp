				<div class="x_panel">
					<div class="x_title">
						<h2><i class="fa fa-shopping-cart"></i> Productos de Dulcer&iacute;a </h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
                      <br />
                      <div class="x_panel">
		                   <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left">

		                      <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="nombre-producto">Nombre del Producto <span class="required">*</span>
		                        </label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
		                          <input type="text" id="nombre-producto" required="required" class="form-control col-md-7 col-xs-12">
		                        </div>
		                      </div>
		                      <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="precio-venta">Precio de Venta <span class="required">*</span>
		                        </label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
		                          <input type="text" id="precio-venta" required="required" class="form-control col-md-7 col-xs-12" placeholder="0.00">
		                        </div>
		                      </div>
							  <div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12" for="icono">Icono <span class="required">*</span>
									</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
 										<input id="icono_file" type="file" class="file" data-show-preview="false">
										<script>
											$("#icono_file").fileinput({
												language: "es",
												uploadUrl: "/file-upload-batch/2",
												allowedFileExtensions: ["jpg", "png", "gif","ico"]
											});
										</script>
									</div>
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
									                            <th class="text-center">Producto </th>
									                            <th class="text-center">Precio </th>
									                            <th class="text-center">Eliminar </th>
															  </tr>
									                        </thead>

									                        <tbody>
									                          <tr>
									                            <td>Palomitas CH</td>
									                            <td class="text-center">$ 35.00</td>
									                            <td class="text-center">
									                              <button type="button" class="btn btn-round btn-default btn-md"><i class="fa fa-trash-o"></i></button>
																</td>
									                          </tr>
									                          <tr>
									                            <td>Palomitas M</td>
									                            <td class="text-center">$ 40.00</td>
									                            <td class="text-center">
									                              <button type="button" class="btn btn-round btn-default btn-md"><i class="fa fa-trash-o"></i></button>
																</td>
									                          </tr>
									                          <tr>
									                            <td>Refresco CH</td>
									                            <td class="text-center">$ 40.00</td>
									                            <td class="text-center">
									                              <button type="button" class="btn btn-round btn-default btn-md"><i class="fa fa-trash-o"></i></button>
																</td>
									                          </tr>
									                          <tr>
									                            <td>Refresco M</td>
									                            <td class="text-center">$ 45.00</td>
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
