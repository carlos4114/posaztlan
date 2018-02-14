package mx.com.aztlan.pos.infraservices.servicios.facade;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aztlan.pos.infraservices.negocio.auditoria.vo.ListaMetodosConfigVO;
import mx.com.aztlan.pos.infraservices.servicios.auditoria.controller.AuditoriaController;

public class AuditoriaFacade implements AuditoriaFacadeI{      
    
	private AuditoriaController auditoriaController;
	
	@Override
	@Transactional(readOnly=true)
    public ResponseEntity<ListaMetodosConfigVO> getMetodosConfig() throws Exception{
		
		ListaMetodosConfigVO listaMetodosConfig = new ListaMetodosConfigVO();
		listaMetodosConfig.setMetodosConfig(this.auditoriaController.getMetodosConfig());
        return new ResponseEntity<ListaMetodosConfigVO>(listaMetodosConfig, HttpStatus.OK);
	}

	public void setAuditoriaController(AuditoriaController auditoriaController) {
		this.auditoriaController = auditoriaController;
	}
  
    	
}
