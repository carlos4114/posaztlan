package mx.com.tecnetia.muvitul.seguridadservices.servicios.seguridad.controller;


import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.PerfilVO;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.infraservices.servicios.GlobalService;
import mx.com.tecnetia.muvitul.seguridadservices.negocio.seguridad.assembler.PerfilAssembler;
import mx.com.tecnetia.muvitul.seguridadservices.persistencia.muvitul.dao.PerfilDAOI;

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