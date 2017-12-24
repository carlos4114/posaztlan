		 <!-- page content -->
            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
					<h2><i class="fa fa-asterisk"></i> Cambia tu Contrase&ntilde;a </h2>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <br />
                    <form ng-submit="cambiarContrasenia()" name="myForm" data-parsley-validate class="form-horizontal form-label-left">

                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="constraseniaActual">Contrase&ntilde;a Actual <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="password" ng-model="contraseniaActual" id="constraseniaActual" required="required" class="form-control col-md-7 col-xs-12" placeholder="Contrase&ntilde;a Actual" ng-minlength="3">
                        </div>
                      </div>
					  <br/>
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="contraseniaNueva">Contrase&ntilde;a Nueva <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="password" ng-model="contraseniaNueva" id="contraseniaNueva" required="required" class="form-control col-md-7 col-xs-12" placeholder="Contrase&ntilde;a Nueva" ng-minlength="3">
                        </div>
                      </div>
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="contraseniaConfirma">Confirmar Contrase&ntilde;a <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="password" ng-model="contraseniaConfirma"  id="contraseniaConfirma" required="required" class="form-control col-md-7 col-xs-12" placeholder="Confirma tu Contrase&ntilde;a Nueva" ng-minlength="3">
                        </div>
                      </div>

                      <div class="ln_solid"></div>
                      <div class="form-group">
                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                          <button type="submit" class="btn btn-success" ng-disabled="myForm.$invalid"><i class="fa fa-key"></i> Cambiar Contrase&ntilde;a</button>
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

                    </form>
                  </div>
                </div>
              </div>
            </div>
		<!-- /page content -->