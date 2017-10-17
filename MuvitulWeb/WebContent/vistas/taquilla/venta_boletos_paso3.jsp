<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!-- page content -->
       		<!-- bloque de wizard -->
			    <div id="wizard" class="form_wizard wizard_horizontal">
        			<ul class="wizard_steps">
                        <li>
                          <a href="" class="done">
                            <span class="step_no">1</span>
                            <span class="step_descr">
                                              Elige la pel&iacute;cula<br />
                                          </span>
                          </a>
                        </li>
                        <li>
                          <a href="" class="done">
                            <span class="step_no">2</span>
                            <span class="step_descr">
                                              Selecciona la promoci&oacute;n<br />
                                          </span>
                          </a>
                        </li>
                        <li>
                          <a href="" class="selected">
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
                      
					  <!-- bloque de PASO 2 de wizard - CANTIDAD -->					  
					  <div id="step-2">
						<div class="x_panel">
						  <div class="x_title">
							<h2><i class="fa fa-calculator"></i> Selecciona la Cantidad de Boletos</h2>
							 <div class="row pull-right">
													<a href="#/ventaBoletos2">													  
													   <button type="button" class="btn btn-primary"><i class="fa fa-star"></i> Regresar a Promociones</button>
													</a>
													<a href="#/ventaBoletos4">
													   <button type="button" class="btn btn-success">Registrar el Pago <i class="fa fa-credit-card"></i> </button>
													</a>
							 </div>
							<div class="clearfix"></div>
						  </div>
						  <div class="x_content">
							  <!-- bloque de pelicula -->
							  <div class="col-md-12 col-sm-12 col-xs-12">
								<div class="x_panel">
								  <div class="x_title">
									<h2><i class="fa fa-film"></i> La Era de Hielo: Choque de Mundos</h2>
									<div class="row pull-right">
										<h3> TOTAL = $95.00 </h3>
									</div>	
									<div class="clearfix"></div>
								  </div>
								    <div class="col-md-3 col-sm-3 col-xs-3">
								         <div class="row">
											  		  <div class="animated flipInY col-lg-8 col-md-8 col-sm-10 col-xs-12">									                    
													      <div class="tile-stats">
									                        <h2 class="text-center">Disponibles</h2>
									                        <h3 class="text-center"> 5 </h3>
									                      </div>
									                  </div>   
										 </div> <!-- /row -->
										 <div class="row">										
											 <div class="profile_img">
												<div id="crop-avatar">
												<img class="img-responsive avatar-view" src="<c:url value='resources/img/pelicula1.jpg' />" >
												</div>
											 </div>
										</div>	 
									  </div>
									  <div class="col-md-9 col-sm-9 col-xs-9">
																						
												<div class="row">
												  <div class="col-md-4 col-sm-4 col-xs-4">
												     <br/><br/>
												     <div class="row">
													      <div class="col-md-12 col-sm-12 col-xs-12">	
															<label>CINE:  San Miguel </label> 
														  </div>
													  </div>
													  <div class="row">
														  <div class="col-md-12 col-sm-12 col-xs-12">	
															<label >FECHA:  Jueves 18 de Julio </label>
														  </div>
													  </div>	
													  <div class="row">
														  <div class="col-md-12 col-sm-12 col-xs-12">	
															<label >HORARIO:  20:30 ESP </label> 
														  </div>
													  </div>	  
												  </div> <!-- /col md 6 --> 
												  <div class="col-md-8 col-sm-8 col-xs-8">
												      <br/>
													  <div class="animated flipInY col-lg-4 col-md-12 col-sm-12 col-xs12">
										                       
											                        <div class="tile-stats" >
											                          <h2 class="text-center">
											                             Promoci&oacute;n						                           
						                           					  </h2>
											                           <br/>
											                          <h3> 2 X 1</h3>
											                          <p>2 X 1 todos los mi&eacute;rcoles</p>					                          
																	</div>
										                       
										              </div>
										              <div class="table-responsive col-lg-8 col-md-12 col-sm-12 col-xs-12">
									                      <table class="table table-striped jambo_table bulk_action">
									                        <thead>
									                          <tr class="headings">
									                            <th class="column-title text-center">Tipo </th>
									                            <th class="column-title text-center">Cant. </th>
									                            <th class="column-title text-center">Subtotal </th>
									                            <th class="column-title text-center no-link last">Quitar</th>
															  </tr>
									                        </thead>
									
									                        <tbody>
									                          <tr class="odd pointer">
									                            <td class=" ">Promoci&oacute;n</td>
									                            <td class="text-center">1</td>
									                            <td class="text-center">-$40.00</td>
									                            <td class="text-center"></td>
									                          </tr>
									                          <tr class="even pointer">
									                            <td class=" ">Ni&ntilde;os</td>
									                            <td class="text-center">2</td>
									                            <td class="text-center">$80.00</td>
									                            <td class="text-center"><a href="#" title="Quitar Boleto"><i class="success fa fa-minus-square-o"></i></a></td>
									                          </tr>
									                          <tr class="odd pointer">
									                            <td class=" ">Adultos</td>
									                            <td class="text-center">1</td>
									                            <td class="text-center">$55.00</td>
									                            <td class="text-center"><a href="#" title="Quitar Boleto"><i class="success fa fa-minus-square-o"></i></a></td>
									                          </tr>
									                        </tbody>
									                      </table>
									                  </div> <!-- table-responsive -->
												  </div><!-- /div col-md-6 --> 												
												</div>	<!-- /row -->												
												<br/>
												<form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left">
													<!-- row - Tabla de selección de boletos -->															
								                  	 <div class="row">								
									                      <div class="animated flipInY col-lg-4 col-md-4 col-sm-4 col-xs-4">
									                        <a href="#combo">
										                        <div class="tile-stats" >
										                          <div style="position:absolute; top:10px; right:10px"  >
										                            <img width="50px" height="50px" src="<c:url value='resources/img/kids_icon.jpeg' />" >
										                          </div>
										                          <div class="count">2</div>
										                           <br/>
										                          <h3>NI&Ntilde;OS</h3>
																  <div class="text-center mtop20"><h2>$40.00</h2></div>
										                        </div>
									                        </a>
									                      </div>
									                      <div class="animated flipInY col-lg-4 col-md-4 col-sm-4 col-xs-4">
									                        <a href="#combo">
										                        <div class="tile-stats">
										                          <div style="position: absolute; top:10px; right:10px" >
										                            <img width="50px" height="50px" src="<c:url value='resources/img/thirdage_icon.jpeg' />" >
										                          </div>
										                           <div class="count">0</div>
										                           <br/>
										                          <h3>3A. EDAD</h3>
										                    	  <div class="text-center mtop20"><h2>$40.00</h2></div>
										                        </div>
									                        </a>
									                      </div>				                  
								                      <div class="animated flipInY col-lg-4 col-md-4 col-sm-4 col-xs-4">
								                        <a href="#combo">
									                        <div class="tile-stats">
									                          <div style="position: absolute; top:10px; right:10px" >
									                          	 <img width="50px" height="50px" src="<c:url value='resources/img/adults_icon.jpeg' />" >
									                          </div>
	                           								  <div class="count">1</div>
															  <br/>
														      <h3>ADULTOS</h3>
									                          <div class="text-center mtop20"><h2>$55.00</h2></div>
									                        </div>
								                        </a>
								                       </div>
								                    </div>								                   
								                 <!-- /row - Tabla de Seleccion de Boletos -->
												</form>			
									   </div>				
										<!-- /X9 columnas  -->
								  </div>
								  <!-- /xpanel PELICULA -->
								</div>
								<!-- /x12 columnas -->
							  </div>	
								<!-- /xcontent -->
						</div> 
						<!-- /xpanel MODULO -->
					  </div>
					  <!-- /bloque de PASO 2 de wizard -->						  
        </div>
        <!-- /bloque de wizard -->