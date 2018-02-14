package mx.com.aztlan.pos.infraservices.negocio.auditoria.business;

import java.util.*;

import mx.com.aztlan.pos.infraservices.negocio.auditoria.vo.AuditoriaConfigMetodoVO;


public interface AuditoriaConfigBOI
{

	Map<Integer,AuditoriaConfigMetodoVO> obtenerMetodosAuditables();
    
 }
