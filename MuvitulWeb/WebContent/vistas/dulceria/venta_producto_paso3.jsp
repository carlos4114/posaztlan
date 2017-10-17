<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <div id="wizard" class="form_wizard wizard_horizontal">
      <ul class="wizard_steps">
                        <li>
                          <a href="" class="done">
                            <span class="step_no">1</span>
                            <span class="step_descr">
                                              Elige el Producto<br />
                                          </span>
                          </a>
                        </li>
                        <li>
                          <a href="" class="done">
                            <span class="step_no">2</span>
                            <span class="step_descr">
                                              Registra el Pago<br />
                                          </span>
                          </a>
                        </li>
                        <li>
                          <a href="" class="selected">
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
			<h2><i class="fa fa-thumbs-o-up"></i> Confirma la Venta </h2>			
			<div class="title_right">
                  <div class="row pull-right">
                  									<a href="#/ventaProducto2">													  
													   <button type="button" class="btn btn-primary"><i class="fa fa-credit-card"></i> Regresar al Pago</button>
													</a>
			     </div>                 
            			
			    <div class="clearfix"></div>
		   </div>		   
         </div>       
		 <div class="x_content">
			
			<!-- bloque de 12 col -->
			<div class="col-md-12 col-sm-12 col-xs-12">
				  <div class="x_panel">	         
				  		<div class="row">
				  		   <h5 class="text-center">Al imprimir el ticket se cerrar&aacute; la venta. Val&iacute;da que todos los datos sean correctos.</h5>							
				  		   <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 col-lg-offset-5 col-md-offset-5 col-sm-offset-5">
							 <a class="btn btn-app" title="Cerrar venta e imprimir ticket" >
                      			<i class="fa fa-print"></i> Imprimir Ticket
                    		 </a>
                    	  </div>
				  		</div> 		
				  </div>
				  <div class="x_panel">	      				  						  		  
					    <div class="row">
								<div class="x_title">
									
									<div class="row pull-right">
										<h3> TOTAL = $369.00 </h3>
									</div>	
									<div class="clearfix"></div>
								  </div>					    
 											  <div class="table-responsive col-lg-6 col-md-6 col-sm-6 col-xs-12">
										              	  <h3 class="text-center">Resumen de Venta</h3>
									                      <table class="table table-striped jambo_table bulk_action">
			 							                      <thead>
										                        <tr class="headings">
										                          <th class="column-title text-center">Cant.</th>
										                          <th class="column-title text-center">Producto</th>
										                          <th class="column-title text-center">Precio</th>
										                         </tr>
										                      </thead>
										                      <tbody>
										                        <tr class="odd pointer">
										                          <td class="text-center">1</td>
										                          <td>Combo 1</td>
										                          <td class="text-center">$120.00</td>
										                        </tr>
										                        <tr class="even pointer">
										                          <td class="text-center">1</td>
										                          <td>Combo 4</td>
										                          <td class="text-center">$150.00</td>
										                        </tr>
										                        <tr class="odd pointer">
										                          <td class="text-center">1</td>
										                          <td>Refresco G</td>
										                          <td class="text-center">$39.00</td>
										                        </tr>
										                        <tr class="even pointer">
										                          <td class="text-center">2</td>
										                          <td>Palomitas Ch</td>
										                          <td class="text-center">$60.00</td>
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
									                            <td class="text-center">$150.00</td>
									                            <td class="text-center">4356</td>
									                          </tr>
									                          <tr class="odd pointer">
									                            <td class=" ">D&eacute;bito</td>
									                            <td class="text-center">$100.00</td>
									                            <td class="text-center">4565</td>
									                          </tr>
									                          <tr class="even pointer">
									                            <td class=" ">Efectivo</td>
									                            <td class="text-center">$119.00</td>
									                            <td class="text-center"></td>
									                          </tr>
									                        </tbody>
									                </table>
									     	  </div> <!-- table-responsive -->
				                         </div><!-- row -->	
						
	              </div> <!-- /x panel -->
            </div> <!-- /12 col -->
         </div> <!-- /content -->
      </div> <!-- /x panel global -->
    </div> <!-- /step div	 -->   
 </div> <!-- /wizard -->   