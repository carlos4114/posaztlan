<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <!-- Bootstrap -->
	
        <!-- page content -->
        		<!-- bloque de wizard -->
			    <div id="wizard" class="form_wizard wizard_horizontal">
        			<ul class="wizard_steps">
                        <li>
                          <a href="" class="selected">
                            <span class="step_no">1</span>
                            <span class="step_descr">
                                              Elige la pel&iacute;cula<br />
                                          </span>
                          </a>
                        </li>
                        <li>
                          <a href="">
                            <span class="step_no">2</span>
                            <span class="step_descr">
                                              Selecciona la promoci&oacute;n<br />
                                          </span>
                          </a>
                        </li>
                        <li>
                          <a href="">
                            <span class="step_no">3</span>
                            <span class="step_descr">
                                              Selecciona la cantidad<br />
                                          </span>
                          </a>
                        </li>
                        <li>
                          <a href="">
                            <span class="step_no">4</span>
                            <span class="step_descr">
                                              Registra el pago<br />
                                          </span>
                          </a>
                        </li>
                        <li>
                          <a href="">
                            <span class="step_no">5</span>
                            <span class="step_descr">
                                              Confirma la venta<br />
                                          </span>
                          </a>
                        </li>
                      </ul> 	
				     <!-- bloque de PASO de wizard - CARTELERA -->					  
					  <div id="step-1">

					    <div class="x_panel">
						  <div class="x_title">
							<h2><i class="fa fa-film"></i> Cartelera</h2>
							<div class="clearfix"></div>
						  </div>
						  <div class="x_content">
							  <!-- bloque de pelicula -->
							  <div class="col-md-12 col-sm-12 col-xs-12">
								<div class="x_panel">
								  <div class="x_title">
									<h2><i class="fa fa-film"></i> La Era de Hielo: Choque de Mundos</h2>
									<div class="clearfix"></div>
								  </div>
								  <div class="x_content">
									<div class="" role="tabpanel" data-example-id="togglable-tabs">
									  <ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
										<li role="presentation" class="active"><a href="ventaBoletos#tab_cont_horarios1" id="horarios1-tab" role="tab" data-toggle="tab" aria-expanded="true">Horarios</a>
										</li>
										<li role="presentation" class=""><a href="ventaBoletos#tab_cont_sinopsis1" role="tab" id="sinopsis1-tab" data-toggle="tab" aria-expanded="false">Sinopsis</a>
										</li>
									  </ul>
									  <div id="myTabContent1" class="tab-content">
										<div role="tabpanel" class="tab-pane fade active in" id="tab_cont_horarios1" aria-labelledby="horarios1-tab">
											<div class="col-md-3">
												<div class="profile_img">
													 <div id="crop-avatar">
														<img class="img-responsive avatar-view" src="<c:url value='resources/img/pelicula1.jpg' />" >
													 </div>
												</div>
											  </div>
											  <div class="col-md-9">
											  		<br/>
													<div class="row">
											  		  <div class="form-group pull-left">
														<p>
															<button type="button" class="btn btn-round btn-info">AA</button>
															<button type="button" class="btn btn-round btn-info">95 min</button>
														</p>
														<p>ESP 
														   <a href="#/ventaBoletos2">
														      <button type="button" class="btn btn-round btn-warning" title="Disponibles: 10">20:30</button>
														   </a>
														   <button type="button" class="btn btn-round btn-default">22:30</button>
														</p>   
														<p>3D
															<button type="button" class="btn btn-round btn-danger" title="Disponibles: 0">18:10</button>
															<button type="button" class="btn btn-round btn-default">20:00</button>
															<button type="button" class="btn btn-round btn-default">22:10</button>
														</p>
													  </div>
													</div><!-- /row -->  
											</div>									
										</div>
										<div role="tabpanel" class="tab-pane fade" id="tab_cont_sinopsis1" aria-labelledby="sinopsis1-tab">
										  <div class="col-md-55">
												<div class="profile_img">
													 <div id="crop-avatar">
														<img class="img-responsive avatar-view" src="<c:url value='resources/img/pelicula1.jpg' />" >
													 </div>
												</div>
										  </div>
										  <div class="col-md-6">
											  <br/><br/>
											  <p>La &eacute;pica persecuci&oacute;n de Scrat de la escurridiza bellota, lo catapulta a un universo donde accidentalmente desata una serie de eventos c&oacute;smicos que transforman y amenazan al mundo de La Era de Hielo. Para salvarse, Sid, Manny, Diego y el resto de la manada deben abandonar su hogar y embarcarse en una b&uacute;squeda llena de comedia y aventura, viajando a tierras ex&oacute;ticas nuevas y encontrando una colecci&oacute;n de coloridos nuevos personajes.</p>
										  </div>	  
										</div>
									  </div>
									</div>

								  </div>
								</div>
							  </div>
							  <!-- /bloque de pelicula -->
							  
							  <!-- bloque de pelicula -->
							  <div class="col-md-12 col-sm-12 col-xs-12">
								<div class="x_panel">
								  <div class="x_title">
									<h2><i class="fa fa-film"></i> Yo Antes de Ti</h2>
									<div class="clearfix"></div>
								  </div>
								  <div class="x_content">
									<div class="" role="tabpanel" data-example-id="togglable-tabs">
									  <ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
										<li role="presentation" class="active"><a href="ventaBoletos#tab_cont_horarios2" id="horarios2-tab" role="tab" data-toggle="tab" aria-expanded="true">Horarios</a>
										</li>
										<li role="presentation" class=""><a href="ventaBoletos#tab_cont_sinopsis2" role="tab" id="sinopsis2-tab" data-toggle="tab" aria-expanded="false">Sinopsis</a>
										</li>
									  </ul>
									  <div id="myTabContent1" class="tab-content">
										<div role="tabpanel" class="tab-pane fade active in" id="tab_cont_horarios2" aria-labelledby="horarios2-tab">
											<div class="col-md-3">
												<div class="profile_img">
													 <div id="crop-avatar">
													 	<img class="img-responsive avatar-view" src="<c:url value='resources/img/pelicula2.jpg' />" >
													 </div>
												</div>
											  </div>
											  <div class="col-md-9">
											  		<br/>
													<div class="row">											  
													  <div class="form-group pull-left">														
														<p>
															<button type="button" class="btn btn-round btn-info">B</button>
															<button type="button" class="btn btn-round btn-info">110 min</button>
														</p>
														<p>ESP <button type="button" class="btn btn-round btn-default">19:50</button><button type="button" class="btn btn-round btn-default">22:30</button></p>
														<p>SUB
															<button type="button" class="btn btn-round btn-default">18:10</button>
															<button type="button" class="btn btn-round btn-warning" title="Disponibles: 10">20:10</button>
															<button type="button" class="btn btn-round btn-default">22:40</button>
														</p>
													</div>
												  </div><!-- /row -->	
											</div>									
										</div>
										<div role="tabpanel" class="tab-pane fade" id="tab_cont_sinopsis2" aria-labelledby="sinopsis2-tab">
										  <div class="col-md-55">
												<div class="profile_img">
													 <div id="crop-avatar">
													   <img class="img-responsive avatar-view" src="<c:url value='resources/img/pelicula2.jpg' />" >
													 </div>
												</div>
										  </div>
										  <div class="col-md-6">
											  <p>Louisa Clark vive en un pintoresco pueblo campestre de Inglaterra. Sin una direcci&oacute;n clara para su vida, la exc&eacute;ntrica y creativa joven de 26 a&ntilde;os va de un trabajo a otro para ayudar a su muy unida familia. Sin embargo, su actitud generalmente alegre ser&aacute; puesta a prueba cuando se encuentre frente a su m&aacute;s reciente desaf&iacute;o laboral. Al comenzar a trabajar en el castillo del lugar, se convierte en cuidadora y compa&ntilde;era de Will Traynor (Claflin), un joven y adinerado banquero que qued&oacute; en silla de ruedas por culpa de un accidente sucedido dos a&ntilde;os atr&aacute;s, y cuyo mundo cambi&oacute; dram&aacute;ticamente en un abrir y cerrar de ojos. Ya no es el alma aventurera que supo ser, y el hoy c&iacute;nico Will se ha rendido. Hasta que Lou decide demostrarle que vale la pena vivir la vida. Lou y Will se embarcar&aacute;n en una serie de aventuras, obtendr&aacute;n de ellas m&aacute;s de lo que esperaban y sus vidas (y corazones) cambiar&aacute;n de maneras en las que ninguno de los dos podr&iacute;an haber imaginado.</p>
										  </div>	  
										</div>
									  </div>
									</div>

								  </div>
								</div>
							  </div>
							  <!-- /bloque de pelicula -->

						  </div>
					   </div>
					  </div> 
					  <!-- /bloque de PASO de wizard -->
 				</div>
 				<!-- /bloque de wizard -->
			    	 