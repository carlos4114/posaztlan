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
                          <a href="" class="selected">
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
			<h2><i class="fa fa-credit-card"></i> Registra el Pago </h2>			
			<div class="title_right">
                  <div class="row pull-right">
                  									<a href="#/ventaProducto">													  
													   <button type="button" class="btn btn-primary"><i class="fa fa-shopping-cart"></i> Modificar Productos</button>
													</a>
													<a href="#/ventaProducto3">
													   <button type="button" class="btn btn-success">Confirmar la Venta <i class="fa fa-thumbs-o-up"></i> </button>
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
								      <div class="animated flipInY col-lg-2 col-md-2 col-sm-2 col-xs-2 col-lg-offset-2 col-md-offset-1">									                    
									      <div class="tile">
					                        <h2>Total</h2>
					                        <h3>$ 369.00 </h3>
					                      </div>
					                  </div>    
				                      <div class="animated flipInY col-lg-2 col-md-2 col-sm-2 col-xs-2">									                    
									    <div class="tile">
					                        <h2>Pagado</h2>
					                        <h3>$ 250.00 </h3>
					                    </div>
					                  </div>  
				                      <div class="animated flipInY col-lg-2 col-md-2 col-sm-2 col-xs-2">									                    
										  <div class="tile">
					                        <h2>Por Pagar</h2>
					                        <h3>$ 119.00 </h3>
					                      </div>
					                  </div>    
					 </div><!-- row -->
					 <br/>
				    <div class="row">
				                      <div class="table-responsive col-lg-6 col-md-6 col-sm-8 col-xs-12 col-lg-offset-2 col-md-offset-1" >
									                      <table class="table table-striped jambo_table bulk_action">
									                        <thead>
									                          <tr class="headings">
									                            <th class="column-title text-center">Forma de Pago</th>
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
									                        </tbody>
									                      </table>
									     </div> <!-- table-responsive -->
				     </div><!-- row -->		
                  </div> <!-- /x panel -->
                  <div class="x_panel">
				            	    <br/>							      	
								    <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left">
								      <div class="form-group">
				                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="forma-pago">Forma de Pago <span class="required">*</span>
				                        </label>
				                        <div class="col-md-6 col-sm-6 col-xs-12">
				                          <div class="btn-group btn-group-justified" data-toggle="buttons">
					                        <label class="btn btn-primary active">
					                          <input type="radio" class="sr-only" id="fp-efectivo" name="forma-pago" value="0" checked>
					                          <span class="docs-tooltip" title="Pago en Efectivo" >
					                            Efectivo
					                          </span>
					                        </label>
					                        <label class="btn btn-primary">
					                          <input type="radio" class="sr-only" id="fp-tarjeta-debito" name="forma-pago" value="1">
					                          <span class="docs-tooltip" title="Tarjeta de D&eacute;bito" >
					                            D&eacute;bito
					                          </span>
					                        </label>
					                        <label class="btn btn-primary">
					                          <input type="radio" class="sr-only" id="fp-tarjeta-credito" name="forma-pago" value="2">
					                          <span class="docs-tooltip" title="Tarjeta de Cr&eacute;dito" >
					                            Cr&eacute;dito
					                          </span>
					                        </label>					                        
					                      </div>
				                        </div>
				                      </div>
									  <div class="form-group">
				                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="monto">Importe <span class="required">*</span></label>
				                        <div class="col-md-6 col-sm-6 col-xs-12">
				                          <input type="text" id="importe" required="required" class="form-control col-md-7 col-xs-12" placeholder=" 00.00 ">
				                        </div>
				                      </div>
				                      <div class="form-group">
				                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="numero-cuenta">N&uacute;mero de Cuenta <span class="required">*</span>
				                        </label>
				                        <div class="col-md-6 col-sm-6 col-xs-12">
				                          <input type="text" id="numero-cuenta" required="required" class="form-control col-md-7 col-xs-12" placeholder=" &Uacute;ltimos 4 d&iacute;gitos ">
				                        </div>
				                      </div>
				                      <div class="form-group">
				                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
				                          <button type="submit" class="btn btn-success"> Guardar Pago </button>
				                        </div>
				                      </div>				
				                    </form>
								  
					 </div>
					 <!-- /xpanel formulario -->
                </div> <!-- /12 col -->
              </div> <!-- /content -->
        </div> <!-- /x panel global -->
     </div> <!-- /step div	 -->   
  </div> <!-- /wizard -->   