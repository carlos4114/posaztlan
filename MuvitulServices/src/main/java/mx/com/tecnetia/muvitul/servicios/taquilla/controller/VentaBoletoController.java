package mx.com.tecnetia.muvitul.servicios.taquilla.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.taquilla.business.ExistenciaBoletoBO;
import mx.com.tecnetia.muvitul.negocio.taquilla.business.PromocionBO;
import mx.com.tecnetia.muvitul.negocio.taquilla.business.VentaBoletoBO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.ArchivoPdfVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.ExistenciaBoletoVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PeliculaVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PrecioXFormatoVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PromocionBoletoVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PromocionVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.TicketVentaVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.VentaVO;

@Service
public class VentaBoletoController {
	
	@Autowired
	private PromocionBO promocionBO;
	@Autowired
	private VentaBoletoBO ventaBoletoBO;
	@Autowired
	private ExistenciaBoletoBO existenciaBoletoBO;
	
	
	public List<PeliculaVO> getPeliculasByCine(Integer idCine,String diaSemana, Date fechaExhibicion ) throws BusinessGlobalException {
		return ventaBoletoBO.findByCineDiaAndExhibicion(idCine,diaSemana, fechaExhibicion);
	}
	
	public List<PromocionVO> getPromocionesByCine(Integer idCine, Integer idPromocionPara, Date fechaExhibicion) throws BusinessGlobalException {
		return promocionBO.findByCineAndExhibicion(idCine,idPromocionPara,fechaExhibicion);
	}

	public BigDecimal getDescuentoByPromocion(PromocionBoletoVO promocionBoletoVO) throws BusinessGlobalException{
		return promocionBO.getDescuentoByPromocion(promocionBoletoVO);
	}
	
	public List<PrecioXFormatoVO> getPreciosByFormato(Integer idCine, Integer idFormato) throws BusinessGlobalException {
		return ventaBoletoBO.findPreciosByFormatoCine(idCine,idFormato);
	}

	public ExistenciaBoletoVO getExistenciaBoleto(Integer idProgramacion, Integer idSala, Date fechaExhibicion) throws BusinessGlobalException{
		return existenciaBoletoBO.findByProgramacionSalaAndExhibicion(idProgramacion, idSala, fechaExhibicion);
	}
	
	public ExistenciaBoletoVO updateExistenciaBoleto(ExistenciaBoletoVO existenciaBoletoVO) throws BusinessGlobalException {
		existenciaBoletoBO.update(existenciaBoletoVO);
		return getExistenciaBoleto(existenciaBoletoVO.getProgramacionVO().getIdProgramacion(), existenciaBoletoVO.getProgramacionVO().getSalaVO().getIdSala(), existenciaBoletoVO.getFechaExhibicion());
	}

	public TicketVentaVO createVenta(VentaVO ventaVO) throws BusinessGlobalException {
		return ventaBoletoBO.createVenta(ventaVO);
	}
	
	public  List<ArchivoPdfVO> getTicketsPdf(Integer idUsuario, Integer idTicket ,BigDecimal pagoCon, BigDecimal cambio)throws BusinessGlobalException{
		return ventaBoletoBO.generarTicketsPdf(idUsuario, idTicket, pagoCon, cambio);
	}
}
