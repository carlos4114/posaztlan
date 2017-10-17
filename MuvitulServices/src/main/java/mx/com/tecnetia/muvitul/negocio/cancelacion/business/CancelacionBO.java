package mx.com.tecnetia.muvitul.negocio.cancelacion.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.CancelacionPagoDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.EstatusPagoDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.PagoDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.TicketVentaDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.CancelacionPago;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.EstatusPago;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Pago;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TicketVenta;
import mx.com.tecnetia.muvitul.negocio.cancelacion.assembler.CancelacionPagoAssembler;
import mx.com.tecnetia.muvitul.negocio.cancelacion.assembler.PagoAssembler;
import mx.com.tecnetia.muvitul.negocio.cancelacion.vo.CancelacionPagoVO;
import mx.com.tecnetia.muvitul.negocio.cancelacion.vo.PagoVO;
import mx.com.tecnetia.muvitul.servicios.util.EstatusPagoType;

@Service
@Transactional
public class CancelacionBO {
	private static final Logger logger = LoggerFactory.getLogger(CancelacionBO.class);
	
	@Autowired
	private TicketVentaDAOI ticketVentaDAO;

	@Autowired
	private PagoDAOI pagoDAO;
	
	@Autowired
	private EstatusPagoDAOI estatusPagoDAO;
	
	@Autowired
	private CancelacionPagoDAOI cancelacionPagoDAOI;
	
	public CancelacionPagoVO createCancelacionPago(Integer idUsuario, CancelacionPagoVO cancelacionPagoVO) {

		TicketVenta ticketVenta = ticketVentaDAO.getById( cancelacionPagoVO.getIdTicketVenta());
		EstatusPago estatusCancelado= estatusPagoDAO.findByClave(EstatusPagoType.CANCELADO.getType());
		EstatusPago estatusPagado= estatusPagoDAO.findByClave(EstatusPagoType.PAGADO.getType());
		
		for (PagoVO pagoVO : cancelacionPagoVO.getPagosVO()) {

			if (EstatusPagoType.CANCELADO.getType().equals(pagoVO.getEstatusPagoVO().getClave())){
				Pago pago= pagoDAO.getById(pagoVO.getIdPago());
				pago.setEstatusPago(estatusCancelado);
				pagoDAO.update(pago);
				CancelacionPago cancelacionPago= CancelacionPagoAssembler.getCancelacionPago(pago,ticketVenta,cancelacionPagoVO,idUsuario);
				cancelacionPagoDAOI.save(cancelacionPago);
			}
			
			if (EstatusPagoType.PAGADO.getType().equals(pagoVO.getEstatusPagoVO().getClave())){
				Pago pago=PagoAssembler.getPago(ticketVenta, estatusPagado,pagoVO);
				pagoDAO.save(pago);
			}
		}
		
		cancelacionPagoVO.setIdCancelacionPago(1);

		return cancelacionPagoVO;
		
	}



}
