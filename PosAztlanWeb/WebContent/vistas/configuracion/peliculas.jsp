				<div class="x_panel">
					<div class="x_title">
						<h2><i class="fa fa-film"></i> Pel&iacute;culas </h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
                      <br />
                      <div class="x_panel">
		                   <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left">

		                      <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="titulo-pelicula">T&iacute;tulo de Pel&iacute;cula<span class="required">*</span>
		                        </label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
		                          <input type="text" id="titulo-pelicula" required="required" class="form-control col-md-7 col-xs-12">
		                        </div>
		                      </div>
		                      <div class="form-group">
		                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="clasificacion">Clasificaci&oacute;n<span class="required">*</span>
		                        </label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
				                          <div class="btn-group btn-group-justified" data-toggle="buttons">
					                        <label class="btn btn-primary active">
					                          <input type="radio" class="sr-only" id="clasificacion-aa" name="clasificacion" value="AA" checked>
					                          <span class="docs-tooltip">
					                            AA
					                          </span>
					                        </label>
					                        <label class="btn btn-primary">
					                          <input type="radio" class="sr-only" id="clasificacion-a" name="clasificacion" value="A">
					                          <span class="docs-tooltip">
					                            A
					                          </span>
					                        </label>
					                        <label class="btn btn-primary">
					                          <input type="radio" class="sr-only" id="clasificacion-b" name="clasificacion" value="B">
					                          <span class="docs-tooltip" >
					                            B
					                          </span>
					                        </label>
					                        <label class="btn btn-primary">
					                          <input type="radio" class="sr-only" id="clasificacion-b15" name="clasificacion" value="B15">
					                          <span class="docs-tooltip" >
					                            B15
					                          </span>
					                        </label>
					                        <label class="btn btn-primary">
					                          <input type="radio" class="sr-only" id="clasificacion-c" name="clasificacion" value="C">
					                          <span class="docs-tooltip" >
					                            C
					                          </span>
					                        </label>
					                        <label class="btn btn-primary">
					                          <input type="radio" class="sr-only" id="clasificacion-d" name="clasificacion" value="D">
					                          <span class="docs-tooltip" >
					                            D
					                          </span>
					                        </label>
					                      </div>
				                </div>
		                      </div>
							  <div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12" for="duracion">Duraci&oacute;n (min)<span class="required">*</span>
									</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
									  <input type="text" id="duracion" required="required" class="form-control col-md-7 col-xs-12" placeholder="0">
									</div>
							  </div>
	                      	  <br/>
		                      <div class="form-group">
		                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
		                          <button type="submit" class="btn btn-success"><i class="fa fa-film"></i> Guardar </button>
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
									                            <th class="text-center">Pel&iacute;cula </th>
									                            <th class="text-center">Clasificaci&oacute;n </th>
									                            <th class="text-center">Duraci&oacute;n </th>
									                            <th class="text-center">Eliminar </th>
															  </tr>
									                        </thead>

									                        <tbody>
									                          <tr>
									                            <td>La Era de Hielo: Choque de Mundos</td>
									                            <td class="text-center">AA</td>
									                            <td class="text-center">95 min</td>
									                            <td class="text-center">
									                              <button type="button" class="btn btn-round btn-default btn-md"><i class="fa fa-trash-o"></i></button>
																</td>
									                          </tr>
									                          <tr>
									                            <td>Yo Antes de Ti</td>
									                            <td class="text-center">B</td>
									                            <td class="text-center">110 min</td>
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
