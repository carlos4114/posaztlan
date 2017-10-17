 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
  <div id="wizard" class="form_wizard wizard_horizontal">
      <ul class="wizard_steps">
                        <li>
                          <a href="" class="selected">
                            <span class="step_no">1</span>
                            <span class="step_descr">
                                              Elige el Producto<br />
                                          </span>
                          </a>
                        </li>
                        <li>
                          <a href="" >
                            <span class="step_no">2</span>
                            <span class="step_descr">
                                              Registra el Pago<br />
                                          </span>
                          </a>
                        </li>
                        <li>
                          <a href="">
                            <span class="step_no">3</span>
                            <span class="step_descr">
                                              Confirma la venta<br />
                                          </span>
                          </a>
                        </li>
     </ul> 	

    <!-- bloque de PASO de wizard -->					  
    <div id="step-1">
	  <div class="x_panel">
		 <div class="x_title">
			<h2><i class="fa fa-shopping-cart"></i> Selecciona el Producto </h2>			
			<div class="title_right">
                  <div class="row pull-right">
													<a href="#/ventaProducto2">
													   <button type="button" class="btn btn-success">Registrar el Pago <i class="fa fa-credit-card"></i> </button>
													</a>
			     </div>                 
            			
			    <div class="clearfix"></div>
		   </div>		   
         </div>       
		 <div class="x_content">
			
			<!-- bloque de 12 col -->
			<div class="col-md-12 col-sm-12 col-xs-12">
			  <div class="x_panel">	            
					<!-- begin product table -->
                    <div class="col-lg-7 col-md-7 col-sm-7 col-xs-12">
					   <div class="row">
						      <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12 form-group pull-left top_search">         
				                  <div class="input-group">
				                    <input type="text" class="form-control" placeholder="Buscar producto...">
				                    <span class="input-group-btn">
				                      <button class="btn btn-default" type="button">Ir!</button>
				                    </span>
				                  </div>
			                   </div>
					   </div>
                  	 <div class="row">

                      <div class="animated flipInY col-lg-4 col-md-4 col-sm-6 col-xs-6">
                        <a href="#combo">
	                        <div class="tile-stats" style="background-color: #F6CECE" >
	                          <div style="position: absolute; top:10px; right:10px" >
	                          	<img src="<c:url value='resources/img/combo_icon.jpeg' />" width="50px" height="50px"  >	                          	
	                          </div>
	                          <div class="count">1</div>
	                          <h3>Combo 1</h3>
	                          <p>2 Refrescos J, 1 Palomitas J</p>
							  <div class="text-center mtop20"><h2>$120.00</h2></div>
	                        </div>
                        </a>
                      </div>
                      <div class="animated flipInY col-lg-4 col-md-4 col-sm-6 col-xs-6">
                        <a href="#combo">
	                        <div class="tile-stats">
	                          <div style="position: absolute; top:10px; right:10px" >
	                          	<img src="<c:url value='resources/img/combo_icon.jpeg' />" width="50px" height="50px"  >
	                          </div>
	                          <div class="count">0</div>

	                          <h3>Combo 2</h3>
	                          <p>2 Refrescos J, 1 Nachos</p>
	                		  <div class="text-center mtop20"><h2>$110.00</h2></div>
	                        </div>
                        </a>
                      </div>
                      <div class="animated flipInY col-lg-4 col-md-4 col-sm-6 col-xs-6">
                        <a href="#combo">
	                        <div class="tile-stats"  style="background-color: #F5F6CE">
	                          <div style="position: absolute; top:10px; right:10px" >
	                          	<img src="<c:url value='resources/img/combo_icon.jpeg' />" width="50px" height="50px"  >
	                          </div>
	                          <div class="count">0</div>

	                          <h3>Combo 3</h3>
	                          <p>2 Refrescos J, 1 Palomitas J, 1 Hot Dog</p>
	                		  <div class="text-center mtop20"><h2>$125.00</h2></div>
	                        </div>
                        </a>
                      </div>                                            
                  	  <div class="animated flipInY col-lg-4 col-md-4 col-sm-6 col-xs-6">
                        <a href="#combo">
	                        <div class="tile-stats">
	                          <div style="position: absolute; top:10px; right:10px" >
	                          	<img src="<c:url value='resources/img/combo_icon.jpeg' />" width="50px" height="50px"  >
	                          </div>
	                          <div class="count">1</div>
	                          <h3>Combo 4</h3>
	                          <p>2 Icee, 1 Palomitas</p>
	                		  <div class="text-center mtop20"><h2>$150.00</h2></div>
	                        </div>
                        </a>
                      </div>                  	  	
                      <div class="animated flipInY col-lg-4 col-md-4 col-sm-6 col-xs-6">
                        <a href="#refresco">
	                        <div class="tile-stats">
	                          <div style="position: absolute; top:10px; right:10px" >
	                          	<img src="<c:url value='resources/img/refresco_icon.jpeg' />" width="50px" height="50px"  >
	                          </div>
	                          <div class="count">0</div>
	                          <h3>Refresco Ch</h3>
	                          <p>-</p>
	                		  <div class="text-center mtop20"><h2>$30.00</h2></div>
	                        </div>
                        </a>
                      </div>
                      <div class="animated flipInY col-lg-4 col-md-4 col-sm-6 col-xs-6">
                        <a href="#refresco">
	                        <div class="tile-stats">
	                          <div style="position: absolute; top:10px; right:10px" >
	                          	<img src="<c:url value='resources/img/refresco_icon.jpeg' />" width="50px" height="50px"  >
	                          </div>
	                          <div class="count">0</div>
	                          <h3>Refresco M</h3>
	                          <p>-</p>
	                		  <div class="text-center mtop20"><h2>$35.00</h2></div>
	                        </div>
                        </a>
                      </div>
                   	  <div class="animated flipInY col-lg-4 col-md-4 col-sm-6 col-xs-6">
                        <a href="#refresco">
	                        <div class="tile-stats">
	                          <div style="position: absolute; top:10px; right:10px" >
	                          	<img src="<c:url value='resources/img/refresco_icon.jpeg' />" width="50px" height="50px"  >
	                          </div>
	                          <div class="count">1</div>

	                          <h3>Refresco G</h3>
	                          <p>-</p>
	                		  <div class="text-center mtop20"><h2>$39.00</h2></div>
	                        </div>
                        </a>
                      </div>
                      <div class="animated flipInY col-lg-4 col-md-4 col-sm-6 col-xs-6">
                        <a href="#refresco">
	                        <div class="tile-stats">
	                          <div style="position: absolute; top:10px; right:10px" >
	                          	<img src="<c:url value='resources/img/refresco_icon.jpeg' />" width="50px" height="50px"  >
	                          </div>
	                          <div class="count">0</div>

	                          <h3>Refresco J</h3>
	                          <p>-</p>
	                		  <div class="text-center mtop20"><h2>$43.00</h2></div>
	                        </div>
                        </a>
                      </div>                  	  
                      <div class="animated flipInY col-lg-4 col-md-4 col-sm-6 col-xs-6">
                        <a href="#palomitas">
	                        <div class="tile-stats">
	                          <div style="position: absolute; top:10px; right:10px" >
	                          	<img src="<c:url value='resources/img/popcorn_icon.jpeg' />" width="50px" height="50px"  >
	                          </div>
	                          <div class="count">2</div>
	                          <h3>Palomitas Ch</h3>
	                          <p>-</p>
	                		  <div class="text-center mtop20"><h2>$30.00</h2></div>
	                        </div>
                        </a>
                      </div>
                       <div class="animated flipInY col-lg-4 col-md-4 col-sm-6 col-xs-6">
                         <a href="#palomitas">
	                        <div class="tile-stats">
	                          <div style="position: absolute; top:10px; right:10px" >
	                          	<img src="<c:url value='resources/img/popcorn_icon.jpeg' />" width="50px" height="50px"  >
	                          </div>
	                          <div class="count">0</div>

	                          <h3>Palomitas M</h3>
	                          <p>-</p>
	                		  <div class="text-center mtop20"><h2>$35.00</h2></div>
	                        </div>
                        </a>
                      </div>
                      <div class="animated flipInY col-lg-4 col-md-4 col-sm-6 col-xs-6">
                        <a href="#palomitas">
	                        <div class="tile-stats">
	                          <div style="position: absolute; top:10px; right:10px" >
	                          	<img src="<c:url value='resources/img/popcorn_icon.jpeg' />" width="50px" height="50px"  >
	                          </div>
	                          <div class="count">0</div>

	                          <h3>Palomitas G</h3>
	                          <p>-</p>
	                		  <div class="text-center mtop20"><h2>$39.00</h2></div>
	                        </div>
                        </a>
                      </div>
                      <div class="animated flipInY col-lg-4 col-md-4 col-sm-6 col-xs-6">
                        <a href="#palomitas">
	                        <div class="tile-stats">
	                          <div style="position: absolute; top:10px; right:10px" >
	                          	<img src="<c:url value='resources/img/popcorn_icon.jpeg' />" width="50px" height="50px"  >
	                          </div>
	                          <div class="count">0</div>

	                          <h3>Palomitas J</h3>
	                          <p>-</p>
	                		  <div class="text-center mtop20"><h2>$43.00</h2></div>
	                        </div>
                        </a>
                      </div>
                     </div> <!-- /row -->
                       
                    </div>
					<!-- finish product table -->

				<!-- empieza sidebar - resumen de venta -->
 				<div class="table-responsive col-lg-5 col-md-5 col-sm-5 col-xs-12">
 					  <h3 class="text-center">Resumen de Venta</h3>
					  <table class="table table-striped jambo_table bulk_action">
 							                      <thead>
							                        <tr class="headings">
							                          <th class="column-title text-center">Cant.</th>
							                          <th class="column-title text-center">Producto</th>
							                          <th class="column-title text-center">Precio</th>
							                          <th class="column-title text-center no-link last">Quitar</th>
							                        </tr>
							                      </thead>
							                      <tbody>
							                        <tr class="odd pointer">
							                          <td class="text-center">1</td>
							                          <td>Combo 1</td>
							                          <td class="text-center">$120.00</td>
							                          <td class="text-center"><a href="#" title="Quitar Boleto"><i class="success fa fa-minus-square-o"></i></a></td>
							                        </tr>
							                        <tr class="even pointer">
							                          <td class="text-center">1</td>
							                          <td>Combo 4</td>
							                          <td class="text-center">$150.00</td>
							                          <td class="text-center"><a href="#" title="Quitar Boleto"><i class="success fa fa-minus-square-o"></i></a></td>
							                        </tr>
							                        <tr class="odd pointer">
							                          <td class="text-center">1</td>
							                          <td>Refresco G</td>
							                          <td class="text-center">$39.00</td>
							                          <td class="text-center"><a href="#" title="Quitar Boleto"><i class="success fa fa-minus-square-o"></i></a></td>
							                        </tr>
							                        <tr class="even pointer">
							                          <td class="text-center">2</td>
							                          <td>Palomitas Ch</td>
							                          <td class="text-center">$60.00</td>
							                          <td class="text-center"><a href="#" title="Quitar Boleto"><i class="success fa fa-minus-square-o"></i></a></td>
							                        </tr>
							                      </tbody>
							</table>
							<div class="x_content">
												<div class="row" align="center">
													<h3> TOTAL = $369.00 </h3>
												</div>												
							</div>
					  </div>
					  <!-- end sidebar - resumen de venta -->

                  </div> <!-- /x panel -->
                </div> <!-- /12 col -->
              </div> <!-- /content -->
        </div> <!-- /x panel global -->
     </div> <!-- /step div	 -->   
  </div> <!-- /wizard -->   