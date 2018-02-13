	    <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2><i class="fa fa-calculator"></i> Corte de Caja </h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
                      <br />
                      
		               <form ng-submit="conciliarEfectivo()" name="formCorteCaja" id="formCorteCaja" data-parsley-validate class="form-horizontal form-label-left">						  
		                  <div class="x_panel">
		                  	  <div class="form-group">
			                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="efectivoReal">Efectivo en Caja<span class="required">*</span>
			                        </label>
			                        <div class="col-md-6 col-sm-6 col-xs-12">
			                           <input ng-change="ocultarConciliacion()" type="text" id="efectivoReal" 
			                           		numeric placeholder="0.0" min=0 decimals="2" ng-model="cajaVO.efectivoReal" required 
			                           		required="required" class="form-control col-md-7 col-xs-12">
								    </div>
			                  </div>
							  <br/>
			                  <div class="form-group">
			                        <div class="col-md-6 col-sm-6 col-xs-6 col-md-offset-3">
			                          <button type="submit" ng-disabled="formCorteCaja.$invalid" class="btn btn-primary" >Conciliar</button>
			                        </div>
		                      </div>
		                      <div class="alert" align="center" role="alert" ng-show="errorConciliar.length">	  
									  	 <span  class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
									     {{errorConciliar}}
							  </div> 
		                 </div>
		                 </form>
		                 <div ng-if="conciliado">    	                 
		                 	<div class="x_panel" >		                      		
		                      		<div class="form-group">
				                        <label class="control-label col-md-3 col-sm-3 col-xs-12" >Efectivo en Sistema
				                        </label>
				                        <div align="center" class="col-md-6 col-sm-6 col-xs-12">
				                          <h2 class="tile-stats alert" align="center" >{{cajaVO.efectivoSistema | currency}}
				                          </h2>
				                        </div>
				                    </div>
				                    <br/>
				                    <div class="form-group"> 
							              <div class="alert col-lg-10 col-md-10 col-sm-10 col-xs-12" align="center" role="alert">	  
											 
						                        <div ng-if="efectivoCuadra">
						                             <span  class="glyphicon glyphicon-ok" aria-hidden="true"></span>
													     El efectivo en caja es igual que el registrado en sistema													     
										        </div>							
										        <div ng-if="!efectivoCuadra">   								 
										               <span  class="glyphicon glyphicon-remove" aria-hidden="true"></span>
										         		El efectivo en caja NO es igual que el registrado en sistema         
									    		</div>	    
										 </div>
							       </div>  
							</div>       
							<form ng-submit="submit()" name="formCorteCaja2" id="formCorteCaja2" data-parsley-validate class="form-horizontal form-label-left">						  
				             <div class="x_panel" >
				                 <div ng-if="!efectivoCuadra">        							            
							        <div class="form-group">
					                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="comentarios2">Comentarios<span class="required">*</span>
					                        </label>
					                        <div class="col-md-6 col-sm-6 col-xs-12">
					                          <textarea maxlength="200" id="comentarios2" placeholder="Comentarios" ng-model="cajaVO.comentarios" class="form-control col-md-7 col-xs-12">
					                          </textarea>
					                        </div>
				                    </div>	
				                    <div class="form-group">
					                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="cargoAjuste">A quien se le cargará el ajuste?<span class="required">*</span>
					                    </label>
					                    <div class="col-md-6 col-sm-6 col-xs-12">
					                          <select class="form-control col-md-7 col-xs-12" id="cargoAjuste" name="cargoAjuste" required
												ng-options="cargoAjuste.id as cargoAjuste.nombre for cargoAjuste in listaCargoAjuste"
												ng-model="cajaVO.idCargoAjuste">
												  <option value="" selected="selected">Selecciona un responsable
											 	  </option>
											  </select>	                          
					                    </div>
					                </div>
					              </div>  				          
					                <div class="form-group">
				                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="entradaCaja">Efectivo a dejar en caja<span class="required">*</span>
				                        </label>
				                        <div class="col-md-6 col-sm-6 col-xs-12">
				                          <input type="text" numeric placeholder="0.0" min=0 decimals="2" required id="entradaCaja" placeholder="Efectivo a dejar" ng-model="cajaVO.entradaCaja" class="form-control col-md-7 col-xs-12">
				                        </div>
				                    </div>
									                     
			                      	<br/>
				                    <div class="form-group">
				                        <div class="col-md-6 col-sm-6 col-xs-6 col-md-offset-3">
				                          <button type="submit" class="btn btn-success" ng-disabled="formCorteCaja2.$invalid"><i class="fa fa-money"></i> Guardar Corte</button>
				                        </div>
				                    </div>		                      		                      
				                      
				                    <div class="alert alert-success" align="center" role="alert" ng-show="mensajeGeneral.length">	  
									  	 <span  class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span>
									     {{mensajeGeneral}}
							        </div>    
									<div class="alert" align="center" role="alert" ng-show="errorGeneral.length">	  
									  	 <span  class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
									     {{errorGeneral}}
							        </div>
							    </div> 	
							   </form>
							  </div> 				    					           
					           <div class="x_panel">
					                <br/>
				                	<div class="form-group" align="center" >
						                 <label class="control-label col-lg-10 col-md-10 col-sm-10 col-xs-10" >Ultimos 30 cortes de caja</span>
						                 </label>
						            </div>
				                    <div class="row">
												              <div class="table-responsive col-lg-10 col-md-12 col-sm-12 col-xs-12 col-lg-offset-1 col-md-offset-1 col-sm-offset-1">
											                      <table id="datatable-responsive" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
											                        <thead>
											                          <tr>
											                            <th class="text-center">Fecha </th>
											                            <th class="text-center">$ en Caja</th>
											                            <th class="text-center">$ en Sistema</th>
											                            <th class="text-center">Cajero</th>
											                            <th class="text-center">Comentarios</th>
											                            <th class="text-center">Cargo del Ajuste</th>
											                            <th class="text-center">Autorizador</th>
											                            <th class="text-center">Final en Caja</th>
																	  </tr>
											                        </thead>
		
											                        <tbody>
											                      								                         
											                          <tr 
											                           dir-paginate="u in listaCortesCaja |  filter: filterSearch |itemsPerPage: 5">   
											                            <td class="text-center"><span ng-bind="u.fecha  | date:'dd-MM-yyyy HH:mm:ss'"></span></td>
											                            <td class="text-center"><span ng-bind="u.efectivoReal | currency"></span></td>
											                            <td class="text-center"><span ng-bind="u.efectivoSistema | currency"></span></td>
											                            <td class="text-center"><span ng-bind="u.cajero"></span></td>
											                            <td class="text-center"><span ng-bind="u.comentarios"></span></td>
											                            <td class="text-center"><span ng-bind="u.cargoAjuste"></span></td>
											                            <td class="text-center"><span ng-bind="u.usuarioAutorizador"></span></td>
											                            <td class="text-center"><span ng-bind="u.entradaCaja | currency"></span></td>									                            
											                          </tr> 									                          
											                        </tbody>
											                        <dir-pagination-controls></dir-pagination-controls> 
											                      </table>
											                  </div> 
									</div> 
								 </div><!-- x-panel -->    	 			                			                 	             
		            </div>       
				</div> <!-- x-panel -->
			</div> <!-- 12 COLS -->
		</div> <!-- ROW -->	