package mx.com.aztlan.pos.seguridadservices.servicios.seguridad.controller;


import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.PerfilVO;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.infraservices.servicios.GlobalService;
import mx.com.aztlan.pos.seguridadservices.negocio.seguridad.assembler.PerfilAssembler;
import mx.com.aztlan.pos.seguridadservices.persistencia.posaztlanbd.dao.PerfilDAOI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PerfilController extends GlobalService{
 
	@Autowired
	PerfilDAOI perfilDAO;		
	
	@Transactional (readOnly = true)
	public List<PerfilVO> obtenerPerfiles(Integer idEmpresa) throws BusinessGlobalException, Exception{
		 if (idEmpresa == null) 
            throw new BusinessGlobalException("Error al obtener los perfiles. La empresa no puede ser nula.");
		
		 return PerfilAssembler.getPerfilesVO(this.perfilDAO.findByEmpresa(idEmpresa));
		 
	} 
}