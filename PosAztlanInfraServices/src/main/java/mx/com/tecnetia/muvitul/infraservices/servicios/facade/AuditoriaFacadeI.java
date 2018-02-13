package mx.com.tecnetia.muvitul.infraservices.servicios.facade;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.vo.ListaMetodosConfigVO;

@RestController
@CrossOrigin
@RequestMapping("/auditoria")
public interface AuditoriaFacadeI {

    @RequestMapping(value = "/getMetodosConfig/", method = RequestMethod.GET)
    @Transactional (readOnly=true)
    ResponseEntity<ListaMetodosConfigVO> getMetodosConfig() throws Exception;

}
