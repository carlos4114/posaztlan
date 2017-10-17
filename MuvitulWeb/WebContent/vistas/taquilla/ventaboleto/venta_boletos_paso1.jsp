

<!-- Bootstrap -->
<!-- page content -->
<!-- bloque de wizard -->
<!-- bloque de PASO de wizard - CARTELERA -->
<div id="step-1">

	<div class="x_panel">
		<div class="x_title">
			<h2>
				<i class="fa fa-film"></i> Cartelera
			</h2>
			<div class="clearfix"></div>

		</div>
		<div class="x_content">
			<div class="row">

				<div class="col-md-2 col-md-offset-9">
					<label>Fecha Función:</label>

					<div class="input-group" id='horario-pelicula'>
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-th"></i></span> <input type="text" fecha
							id="fechaInicio"
							ng-change="buscarPeliculasXFecha(param.fechaExhibicion)"
							ng-model="param.fechaExhibicion" readonly
							class="form-control col-md-7 col-xs-12">

					</div>
				</div>

			</div>
			<div class="alert   alert-danger" ng-if="errorPeliculas">
				<strong>Cuidado! </strong> No se encuentran funciones en cartelera.
			</div>



			<!-- bloque de pelicula -->
			<div dir-paginate="pelicula in listaPeliculas | itemsPerPage: 5">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="x_panel">
						<div class="x_title">
							<h2>
								<i class="fa fa-film"></i> {{pelicula.titulo}}
							</h2>
							<div class="clearfix"></div>
						</div>
						<div class="x_content">
							<div class="" role="tabpanel" data-example-id="togglable-tabs">
								<ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
									<li role="presentation" class="active"><a
										ng-href="ventaBoletos#tab_horarios{{pelicula.idPelicula}}"
										id="horarios1-tab" role="tab" data-toggle="tab"
										aria-expanded="true">Horarios</a></li>
									<li role="presentation" class=""><a
										href="ventaBoletos#tab_sinopsis{{pelicula.idPelicula}}"
										role="tab" id="sinopsis1-tab" data-toggle="tab"
										aria-expanded="false">Sinopsis</a></li>
								</ul>
								<div id="myTabContent1" class="tab-content">
									<div role="tabpanel" class="tab-pane fade active in"
										id="tab_horarios{{pelicula.idPelicula}}"
										aria-labelledby="horarios1-tab">
										<div class="col-md-3">
											<div class="profile_img">
												<div id="crop-avatar">
													<img class="img-responsive avatar-view"
														ng-src="data:image/png;base64,{{pelicula.icono}}"
														width="90%">
												</div>
											</div>
										</div>
										<div class="col-md-9">
											<br />
											<div class="row">
												<div class="">

													<p>
														<button type="button" class="btn btn-round btn-info">{{pelicula.clasificacion}}</button>
														<button type="button" class="btn btn-round btn-info">{{pelicula.duracion}}
															min</button>
													</p>


													<div ng-repeat="funcion in  pelicula.versionFormatoVO">

														<div class="row col-md-12">
															<p>{{funcion.nombre}}
															<ul id="2" class="col-md-2 col-xs-6"
																ng-repeat="programacion in funcion.programaciones">
																<button type="button"
																	ng-click="seleccionarPelicula(pelicula,programacion)"
																	ng-class="programacion.existenciaBoletoVO.color"
																	ng-disabled="programacion.existenciaBoletoVO.disponibles ==0"
																	title="Disponibles: {{programacion.existenciaBoletoVO.disponibles}}">{{programacion.horario}}</button>
															</ul>
															</p>
														</div>
													</div>


												</div>
											</div>
											<!-- /row -->
										</div>
									</div>
									<div role="tabpanel" class="tab-pane fade"
										id="tab_sinopsis{{pelicula.idPelicula}}"
										aria-labelledby="sinopsis1-tab">
										<div class="col-md-4 col-xs-12">
											<div class="profile_img">
												<div id="crop-avatar">
													<img class="img-responsive avatar-view" width="250px"
														height="200px"
														ng-src="data:image/png;base64,{{pelicula.icono}}">
												</div>
											</div>
										</div>
										<div class="col-md-6 col-xs-12">
											<p>
												<button type="button" class="btn btn-round btn-info">{{pelicula.distribuidoraVO.nombre}}</button>
												<button type="button" class="btn btn-round btn-info">{{pelicula.paisVO.nombre}}</button>
											</p>
											<br /> <br />
											<p>{{pelicula.sinopsis}}</p>
										</div>
									</div>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
			<dir-pagination-controls></dir-pagination-controls>
		</div>


	</div>


</div>

<!-- /bloque de PASO de wizard -->
<!-- /bloque de wizard -->