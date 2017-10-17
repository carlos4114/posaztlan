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
                          <a href="" class="done">
                            <span class="step_no">3</span>
                            <span class="step_descr">
                                              Selecciona la cantidad<br />
                                          </span>
                          </a>
                        </li>
                        <li>
                          <a href="" class="done">
                            <span class="step_no">4</span>
                            <span class="step_descr">
                                              Registra el pago<br />
                                          </span>
                          </a>
                        </li>
                        <li>
                          <a href="" class="selected">
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
							<h2><i class="fa fa-thumbs-o-up"></i> Confirma la Venta </h2>
							 <div class="row pull-right">
													<a href="#/ventaBoletos4">													  
													   <button type="button" class="btn btn-primary"><i class="fa fa-credit-card"></i> Regresar al Pago </button>
													</a>													
							 </div>
							<div class="clearfix"></div>
						  </div>
						  <div class="x_content">
							  <!-- bloque de pelicula -->
							  <div class="col-md-12 col-sm-12 col-xs-12">
							    <div class="x_panel">	         
								  		<div class="row">
								  		   <h5 class="text-center">Al imprimir los boletos se cerrar&aacute; la venta. Val&iacute;da que todos los datos sean correctos.</h5>
								  		   <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 col-lg-offset-5 col-md-offset-5 col-sm-offset-5">
											 <a class="btn btn-app" title="Cerrar venta e imprimir boletos" >
				                      			<i class="fa fa-print"></i> Imprimir Boletos
				                    		 </a>
				                    	  </div>
								  		</div> 		
								</div>
							    
								<div class="x_panel">
								  <div class="x_title">
									<h2><i class="fa fa-film"></i> La Era de Hielo: Choque de Mundos</h2>
									<div class="row pull-right">
										<h3> TOTAL = $95.00 </h3>
									</div>	
									<div class="clearfix"></div>
								  </div>
								  <div class="col-md-3 col-sm-3 col-xs-3">
								      <br/><br/>
									  <div class="profile_img">
											<div id="crop-avatar">
												<img class="img-responsive avatar-view" src="<c:url value='resources/img/pelicula1.jpg' />" >
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
											   </div> <!-- /col md 4 --> 
											   <div class="col-md-8 col-sm-8 col-xs-8">
												      <br/>
													  <div class="animated flipInY col-lg-8 col-md-8 col-sm-8 col-xs8">
										                       
											                        <div class="tile-stats" >
											                          <h3 class="text-center">
											                             Promoci&oacute;n						                           
						                           					  </h3>
											                           <br/>
											                          <h3> 2 X 1</h3>
											                          <p>2 X 1 todos los mi&eacute;rcoles</p>					                          
																	</div>
										                       
										              </div>										              	
										             
												  </div><!-- /div col-md-8 --> 												
											</div>	<!-- /row -->	
											<br/>	
											<div class="row">
 											  <div class="table-responsive col-lg-6 col-md-6 col-sm-6 col-xs-12">
										              	  <h3 class="text-center">Boletos</h3>
									                      <table class="table table-striped jambo_table bulk_action">
									                        <thead>
									                          <tr class="headings">
									                            <th class="column-title text-center">Tipo </th>
									                            <th class="column-title text-center">Cant. </th>
									                            <th class="column-title text-center">Subtotal </th>
									                		  </tr>
									                        </thead>
									
									                        <tbody>
									                          <tr class="odd pointer">
									                            <td class=" ">Promoci&oacute;n</td>
									                            <td class="text-center">1</td>
									                            <td class="text-center">-$40.00</td>
									                          </tr>
									                          <tr class="even pointer">
									                            <td class=" ">Ni&ntilde;os</td>
									                            <td class="text-center">2</td>
									                            <td class="text-center">$80.00</td>
									                          </tr>
									                          <tr class="odd pointer">
									                            <td class=" ">Adultos</td>
									                            <td class="text-center">1</td>
									                            <td class="text-center">$55.00</td>
									                          </tr>
									                        </tbody>
									                      </table>
									             </div> <!-- table-responsive -->											
				                      			<div class="table-responsive col-lg-6 col-md-6 col-sm-6 col-xs-12" >
													   <h3 class="text-center">Pagos</h3>
									                   <table class="table table-striped jambo_table bulk_action">
									                        <thead>
									                          <tr class="headings">
									                            <th class="column-title text-center" >Forma de Pago</th>
									                            <th class="column-title text-center">Importe</th>
									                            <th class="column-title text-center">Cuenta</th>									                            
															  </tr>
									                        </thead>
									
									                        <tbody>
									                          <tr class="even pointer">
									                            <td class=" ">Cr&eacute;dito</td>
									                            <td class="text-center">$50.00</td>
									                            <td class="text-center">4356</td>
									                          </tr>
									                          <tr class="odd pointer">
									                            <td class=" ">D&eacute;bito</td>
									                            <td class="text-center">$30.00</td>
									                            <td class="text-center">4565</td>
									                          </tr>
									                          <tr class="even pointer">
									                            <td class=" ">Efectivo</td>
									                            <td class="text-center">$15.00</td>
									                            <td class="text-center"></td>
									                          </tr>
									                        </tbody>
									                </table>
									     	  </div> <!-- table-responsive -->
				                         </div><!-- row -->					                  		  				                 
																					
								  </div><!-- /div 9 columnas -->
								  
								</div>  <!-- /xpanel --> 
							  </div><!-- /col-md-12 -->
							  
					     </div>	
						 <!-- /xcontent -->
					   </div> 
					   <!-- /xpanel MODULO -->
					 </div>
					 <!-- /bloque de PASO 2 de wizard -->						  
        </div>
        <!-- /bloque de wizard -->