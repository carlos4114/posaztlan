	   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	    <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2><i class="fa fa-cog"></i> Salas </h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
                      <br/>
		                   <form ng-submit="submit()" name="formSalas" id="formSalas" data-parsley-validate class="form-horizontal form-label-left">
							  <div class="x_panel"> 
								  <div class="form-group">
			                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="perfil">Cine<span class="required">*</span>
			                        </label>
			                        <div class="col-md-6 col-sm-6 col-xs-12">
										<select class="form-control col-md-7 col-xs-12" id="cine" name="cine" directiva-select2 required
											ng-change="cambiarCine(salaVO.idCine)"
											ng-options="cine.idCine as cine.nombre for cine in listaCines"
											ng-model="salaVO.idCine">
											<option value="" selected="selected">Selecciona un cine
											</option>
										</select>
									</div>
			                      </div>	
			                      <div class="form-group">
			                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="nombre">Nombre<span class="required">*</span>
			                        </label>
			                        <div class="col-md-6 col-sm-6 col-xs-12">
			                          <input type="text" id="nombre" placeholder="Nombre" ng-model="salaVO.nombre" required="required" class="form-control col-md-7 col-xs-12">
			                        </div>
			                      </div>
								   <div class="form-group">
			                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="noButacas">Número de Butacas<span class="required">*</span>
			                        </label>
			                        <div class="col-md-6 col-sm-6 col-xs-12">
			                          <input type="text" id="noButacas" numeric placeholder="0" min=1 decimals="0"
			                               ng-model="salaVO.cupo" required required="required" class="form-control col-md-7 col-xs-12">
			                        </div>
			                      </div>
			                      <div ng-if="salaVO.idSala">
				                      <div class="form-group">
				                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="activo">
				                          Estatus<span class="required">*</span>
				                        </label>
				                        <div class="col-md-6 col-sm-6 col-xs-12">
				                          <input type="checkbox" class="flat" id="activo"  ng-model="salaVO.activo"  />
				                        </div>
				                      </div>
				                   </div>   
								   <div class="form-group">
			                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="tieneNumerado">
			                          Tiene Numerado?
			                        </label>
			                        <div class="col-md-6 col-sm-6 col-xs-12">
			                          <input type="checkbox" class="flat" id="tieneNumerado"  ng-model="salaVO.tieneNumerado"  />
			                        </div>
			                      </div>			                      
		                      	  <br/>
			                      <div class="form-group">
			                        <div class="col-md-6 col-sm-6 col-xs-6 col-md-offset-3">
			                          <button type="submit" class="btn btn-success" ng-disabled="formSalas.$invalid"><i class="fa fa-building-o"></i>{{!salaVO.idSala ? 'Guardar' : 'Actualizar'}}</button>
			                          <button type="button" ng-click="limpiarFormulario()" class="btn btn-primary" >Nueva</button>
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
								  <br/>
								</div>								  
								<div ng-if="salaVO.tieneNumerado">
									  <div class="x_panel" >
									     <div class="form-group"> 
									        <div class="alert col-lg-10 col-md-10 col-sm-10 col-xs-12" align="center" role="alert">	  
												 Configura el mapa de la sala: <strong>{{salaVO.nombre}}</strong>													     
											</div>
									     </div> 									     
									    <div class="form-group">
					                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="filas">Tamaño del mapa<span class="required">*</span>
					                        </label>
					                        <div class="col-md-3 col-sm-3 col-xs-3">
					                           <input ng-blur="cambiarFilasOAsientos()" type="text" id="filas" numeric placeholder="0" min=1 decimals="0"
					                               ng-model="salaVO.filas" required required="required" class="form-control">
					                        </div>
					                        <div class="col-md-1 col-sm-1 col-xs-1">       
					                           <label class="control-label col-md0 col-sm0 col-xs0" for="filas"> X
					                        	</label>  
					                        </div>	
					                        <div class="col-md-3 col-sm-3 col-xs-3">     
					                           <input ng-blur="cambiarFilasOAsientos()" type="text" id="maxAsientos" numeric placeholder="0" min=1 decimals="0"
					                               ng-model="salaVO.maxAsientos" required required="required" class="form-control">			                   
					                        </div>			                        			                       
				                        </div>				
				                        <br/><br/>					     
									     <div class="form-group"> 
									        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" align="center">
									           <img src="<c:url value='/resources/img/pantalla.png' />" class="img-responsive" />
											   <br/><br/>											   
											   <table align="center" class="table-responsive">
									             <tbody>	
									               <tr>	
									                  <td valign="top">
									                    <table>	
									               	     <tbody>							                						               
											               <tr dir-paginate="filaAsientos in salaVO.asientosListVO |  filter: filterSearch |itemsPerPage: salaVO.asientosListVO.length" >
											               		<td width="40px" height="40px">
													               {{filaAsientos[$index].fila}}
													            </td>	
											               </tr>
											             </tbody>
											            </table>   	
									                  </td>
									                  <td valign="top">
									               	   <table>	
									               	     <tbody>							                						               
											               <tr dir-paginate="filaAsientos in salaVO.asientosListVO |  filter: filterSearch |itemsPerPage: salaVO.asientosListVO.length" >
													                 <td dir-paginate="asiento in filtered=(filaAsientos |  filter: filterSearch) |itemsPerPage: filaAsientos.length" width="40px" height="40px">
																		  <a href="javascript:void(0)" ng-click="modificarButaca(asiento)">
																		    <div ng-if="asiento.existente">
																			   <img align="center" src="<c:url value='/resources/img/butacaDisponible.png' />" 
															           			height="25px" width="25px" class="img-responsive" title="{{asiento.numeroAsiento}}" />
															           		</div>
															           		<div ng-if="!asiento.existente">
																			   <img align="center" src="<c:url value='/resources/img/cuadro.png' />" 
															           			height="25px" width="25px" class="img-responsive" title="{{asiento.numeroAsiento}}" />
															           		</div>	
														           		  </a> 	
													                 </td>				
											               </tr>
											             </tbody>
											             <tfoot ng-if="salaVO.asientosListVO!=null">									              
											        	    <tr class="headings">										        	    										                           
									                            <th dir-paginate="filaAsientos in salaVO.asientosListVO[0] |  filter: filterSearch |itemsPerPage: salaVO.asientosListVO[0].length" 
									                                style="text-align: center;" class="column-title">							                              
									                               {{$index+1}}
									                            </th>
									                         </tr>   						                            									        	    
											        	  </tfoot>  
											           </table>  
											          </td>   
											       <tr/>        											          									              
									             </tbody>									             
									           </table>      
											   <br/>											   									           
									        </div>
									     </div>
									  </div>
								  </div>  								 
							   </form>
		                <div class="x_panel">
		                    <div class="row">
										              <div class="table-responsive col-lg-10 col-md-12 col-sm-12 col-xs-12 col-lg-offset-1 col-md-offset-1 col-sm-offset-1">
									                      <table id="datatable-responsive" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
									                        <thead>
									                          <tr>
									                            <th class="text-center">Nombre </th>
									                            <th class="text-center">Butacas </th>
									                            <th class="text-center">Numerado </th>
									                            <th class="text-center">Mapa </th>
									                            <th class="text-center">Estatus </th>
									                            <th class="text-center">Editar </th>
															  </tr>
									                        </thead>

									                        <tbody>									                         
									                          <tr 
									                           dir-paginate="s in listaSalas |  filter: filterSearch |itemsPerPage: 10">   
									                            <td class="text-center"><span ng-bind="s.nombre"></span></td>
									                            <td class="text-center"><span ng-bind="s.cupo"></span></td>
									                            <td class="text-center"><span ng-bind="s.tieneNumerado ? 'SI' : 'NO'"></span></td>
									                            <td class="text-center"><span ng-bind="(s.filas==null || s.maxAsientos==null) ? '' : ((s.filas)+ ' X ' +(s.maxAsientos))"></span></td>
									                            <td class="text-center"><span ng-bind="s.activo ? 'ACTIVA' : 'INACTIVA'"></span></td>
									                            <td class="text-center">
									                              <button type="button" ng-click="editar(s.idSala)" class="btn btn-round btn-default btn-md"><i class="fa fa-edit"></i></button>
																</td>
									                          </tr>									                          
									                        </tbody>
									                        <dir-pagination-controls></dir-pagination-controls> 
									                      </table>
									                  </div> <!-- table-responsive -->
								  </div> <!-- row -->
							</div><!-- x-panel -->
						</div> <!-- content -->
					</div> <!-- xpanel -->
			</div> <!-- 12 COLS -->
		</div> <!-- ROW -->	