package mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.business;

import java.util.*;

import mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.vo.AuditoriaConfigMetodoVO;


public interface AuditoriaConfigBOI
{

	Map<Integer,AuditoriaConfigMetodoVO> obtenerMetodosAuditables();
    
 }
