package mx.com.tecnetia.muvitul.servicios.caja.controller;


import io.jsonwebtoken.Claims;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.HttpResponseVO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.CajaIbatisDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.CorteCajaDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Autorizacion;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.enumeration.ClaimsEnum;
import mx.com.tecnetia.muvitul.infraservices.persistencia.utileria.business.FechasUtilsBO;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.infraservices.servicios.GlobalService;
import mx.com.tecnetia.muvitul.negocio.caja.assembler.CorteCajaAssembler;
import mx.com.tecnetia.muvitul.negocio.caja.vo.CorteCajaVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.business.AutorizacionBO;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CajaController extends GlobalService{
 
	@Autowired
	AutorizacionBO autorizacionBO;
	@Autowired
	CorteCajaDAOI corteCajaDAO;
	@Autowired
	CajaIbatisDAOI cajaIbatisDAO;	
		
	/**
     * Servicio para obtener los ultimos N cortes de caja de un usuario
     */
	@Transactional (readOnly = true)
	public List<CorteCajaVO> obtenerCortesCaja(Claims claims) throws BusinessGlobalException, Exception{
		 if (claims == null) 
	            throw new BusinessGlobalException("Error al obtener los cortes de caja de un usuario. Claims no puede ser nulo.");
		 Integer idCaja = (Integer)claims.get(ClaimsEnum.CAJA);
		 
		 //obtenemos los cortes de caja de un usuario		 
		 return CorteCajaAssembler.getCorteCajaListVO(this.corteCajaDAO.getPorCaja(idCaja, 30));
	}
	
	/**
     * Servicio para obtener el efectivo que debiera haber en una caja, desde el ultimo corte
     */
	@Transactional (readOnly = true)
	public BigDecimal obtenerEfectivoEnCaja(Claims claims) throws BusinessGlobalException, Exception{
		 if (claims == null) 
	            throw new BusinessGlobalException("Error al obtener los cortes de caja de un usuario. Claims no puede ser nulo.");
		 Integer idCaja = (Integer)claims.get(ClaimsEnum.CAJA);
		 
		 //obtenemos el efectivo que debiera haber en la caja hasta hoy
		 return this.cajaIbatisDAO.getEfectivoEnCaja(idCaja);
	}
	
	/**
     * Servicio para guardar un corte de caja
     */
	@Transactional (readOnly = false)
	public HttpResponseVO guardarCorteCaja(CorteCajaVO corteCajaVO, Claims claims) throws BusinessGlobalException{
		 if (corteCajaVO == null) 
            throw new BusinessGlobalException("Error al guardar el corte de caja. CorteCajaVO no puede ser nulo.");
		 if (claims == null) 
	            throw new BusinessGlobalException("Error al guardar el corte de caja. Claims no puede ser nulo.");
		 Integer idUsuario = (Integer)claims.get(ClaimsEnum.USUARIO);
		 Integer idCaja = (Integer)claims.get(ClaimsEnum.CAJA);
		
		 if (idUsuario == null) 
	            throw new BusinessGlobalException("Error al guardar el corte de caja. Usuario no puede ser nulo.");
		 if (idCaja == null) 
	            throw new BusinessGlobalException("Error al guardar el corte de caja. La caja no puede ser nula.");
		
		 
		 //si la autorizacion es valida guardamos el corte de caja
		 corteCajaVO.setIdCorteCaja(null);
		 corteCajaVO.setFecha(FechasUtilsBO.getCurrentDate());
		 this.corteCajaDAO.save(CorteCajaAssembler.getCorteCaja(corteCajaVO, new Autorizacion(corteCajaVO.getIdAutorizacion()), idCaja, idUsuario));		 
		 
		 return new HttpResponseVO();		 
	}
	 
}