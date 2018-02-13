<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- bloque de PASO 4 de wizard - ASIENTOS -->
<div id="step-2">
	<div class="x_panel" ng-init="initCron()">
		<div class="x_title">
			<h2>
				<i class="fa fa-th"></i> Seleccionar Asientos
			</h2>
			<div class="row pull-right" ng-init="" >
				<button type="button" class="btn btn-primary"
					ng-click="asignarPaso(3);StopTimerAsientos();StartTimer(paramsExistenciaBoleto)">
					<i class="fa fa-calculator"></i> Modificar Cantidades
				</button>				
				<button type="button" class="btn btn-success"
					ng-disabled="totalAsientos!=totalBoletos && mapaAsientos.length>0"
					ng-click="asignarPaso(5);consultarFormasPago();StopTimerAsientos()">
					Registrar el Pago <i class="fa fa-credit-card"></i>
				</button>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="x_content">
			<!-- bloque de pelicula -->
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
				    <div class="row" ng-if="mapaAsientos.length<=0">
						   <h2 align="center">
								La sala no cuenta con asientos numerados.
						   </h2>
					</div>
					
					<div class="form-group" ng-if="mapaAsientos.length>0"> 
					   <div class="col-md-12 col-sm-12 col-xs-12">
						<div class="x_panel">
							<div class="row">
								<div
									class="animated flipInY col-lg-4 col-md-4 col-sm-4 col-xs-6">
									<div class="tile-stats">
										<h2 class="text-center">Boletos Comprados</h2>
										<h3 class="text-center">{{totalBoletos}}</h3>
									</div>
								</div>
								<div
									class="animated flipInY col-lg-4 col-md-4 col-sm-4 col-xs-6">
									<div class="tile-stats">
										<h2 class="text-center">Por Seleccionar</h2>
										<h3 class="text-center">{{totalBoletos-totalAsientos}}</h3>
									</div>
								</div>
								<div class="animated flipInY col-lg-4 col-md-4 col-sm-4 col-xs-6">
									<div class="tile-stats">
										<h2 class="text-center">Seleccionados</h2>
										<h3 class="text-center">{{totalAsientos}}</h3>
									</div>
								</div>							
							</div>
							<!-- row -->	
						</div>
					  </div>		
										
				        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" align="center">
				           <img src="<c:url value='/resources/img/pantalla.png' />" class="img-responsive" />
						   <br/><br/>											   
						   <table align="center" class="table-responsive">
				             <tbody>	
				               <tr>	
				                  <td valign="top">
				                    <table>	
				               	     <tbody>							                						               
						               <tr dir-paginate="filaAsientos in mapaAsientos |  filter: filterSearch |itemsPerPage: mapaAsientos.length" >
						               		<td style="text-align: center;" width="50px" height="40px">
								               {{filaAsientos[0].fila}}
								            </td>	
						               </tr>
						             </tbody>
						            </table>   	
				                  </td>
				                  <td valign="top">
				               	   <table>	
				               	     <tbody>							                						               
						               <tr dir-paginate="filaAsientos in mapaAsientos |  filter: filterSearch |itemsPerPage: mapaAsientos.length" >
								                 <td dir-paginate="asiento in filtered=(filaAsientos |  filter: filterSearch) |itemsPerPage: filaAsientos.length" width="40px" height="40px">													 
													    <div ng-if="asiento.existente">
													    	<div ng-if="asiento.idEstatusAsiento==2">						    
															   <img align="center" 
															   ng-src="<c:url value='/resources/img/butacaOcupada.png' />" 
											           			height="25px" width="25px" class="img-responsive" title="{{asiento.numeroAsiento}}" />
											           		</div>
											           		<div ng-if="asiento.idEstatusAsiento==1">
											           		   <a href="javascript:void(0)" ng-click="modificarButaca(asiento)">
																   <img align="center" 
																   ng-src="<c:url value='/resources/img/asientos/butacaSeleccionada_{{asiento.numeroAsiento}}.png' />" 
												           			height="25px" width="25px" class="img-responsive" />
											           		   </a>	
											           		</div>	
											           		<div ng-if="asiento.idEstatusAsiento==3">						    
															   <a href="javascript:void(0)" ng-click="modificarButaca(asiento)">
																<img align="center" 
																ng-src="<c:url value='/resources/img/asientos/butacaDisponible_{{asiento.numeroAsiento}}.png' />" 
											           			  height="25px" width="25px" class="img-responsive" />
											           		   </a>
											           		</div>
											           		
										           		</div>
									           		 	
								                 </td>				
						               </tr>
						             </tbody>						             
						           </table>  
						          </td> 
						          <td valign="top">
				                    <table>	
				               	     <tbody>							                						               
						               <tr dir-paginate="filaAsientos in mapaAsientos |  filter: filterSearch |itemsPerPage: mapaAsientos.length" >
						               		<td style="text-align: center;" width="50px" height="40px">
								               {{filaAsientos[0].fila}}
								            </td>	
						               </tr>
						             </tbody>
						            </table>   	
				                  </td>  
						       <tr/>        											          									              
				             </tbody>									             
				           </table>      
						   <br/>											   									           
				        </div>
				     </div> <!-- FORM GROUP - MAPA DE BUTACAS -->
				</div> <!-- x panel -->
			</div>
			<!-- /x12 columnas -->
		</div>
		<!-- /xcontent -->
	</div>
	<!-- /xpanel MODULO -->
</div><!-- /STEP -->
