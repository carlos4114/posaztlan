package mx.com.aztlan.pos.negocio.cancelacion.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.CancelacionPagoDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.EstatusPagoDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.PagoDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.TicketVentaDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.CancelacionPago;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.EstatusPago;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Pago;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TicketVenta;
import mx.com.aztlan.pos.negocio.cancelacion.assembler.CancelacionPagoAssembler;
import mx.com.aztlan.pos.negocio.cancelacion.assembler.PagoAssembler;
import mx.com.aztlan.pos.negocio.cancelacion.vo.CancelacionPagoVO;
import mx.com.aztlan.pos.negocio.cancelacion.vo.PagoVO;
import mx.com.aztlan.pos.servicios.util.EstatusPagoType;

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
