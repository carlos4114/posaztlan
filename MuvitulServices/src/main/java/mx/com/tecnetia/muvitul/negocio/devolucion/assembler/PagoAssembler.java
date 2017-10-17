package mx.com.tecnetia.muvitul.negocio.devolucion.assembler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.EstatusPago;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.FormaPago;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Pago;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TicketVenta;
import mx.com.tecnetia.muvitul.negocio.devolucion.vo.PagoVO;


public class PagoAssembler {

	
	public static Pago getPago(TicketVenta ticketVenta,EstatusPago estatusPago, FormaPago formaPago, BigDecimal importe){

		if(ticketVenta==null )
			return null;

		BigDecimal totalPago= new BigDecimal(0);
		totalPago=totalPago.add(ticketVenta.getTotal());
		totalPago=totalPago.subtract(ticketVenta.getDescuento());
		
		Pago pago= new Pago();
		pago.setEstatusPago(estatusPago);
		pago.setFormaPago(formaPago);
		pago.setTicketVenta(ticketVenta);
		pago.setNoCuenta("");
		pago.setImporte((importe==null)?totalPago.negate():importe.negate());
		pago.setFecha(new Date());
		
		return pago;
	}
	
	public static PagoVO getPagoVO(Pago pago){

		if(pago==null )
			return null;

		
		PagoVO pagoVO= new PagoVO();
		pagoVO.setIdPago(pago.getIdPago());
		pagoVO.setEstatusPagoVO(EstatusPagoAssembler.getEstatusPagoVO(pago.getEstatusPago()));
		pagoVO.setFormaPagoVO(FormaPagoAssembler.getFormaPagoVO(pago.getFormaPago()));
		pagoVO.setNoCuenta(pago.getNoCuenta());
		pagoVO.setImporte(pago.getImporte());
		pagoVO.setFecha(pago.getFecha());
		
		return pagoVO;
	}
	
	public static List<PagoVO> getPagosVO(Set<Pago> pagos){

		if(pagos==null || pagos.isEmpty())
			return null;
		
		List<PagoVO> pagosVO = new ArrayList<PagoVO>();
		
		for (Pago pago : pagos) {
			pagosVO.add(PagoAssembler.getPagoVO(pago));
		}

		return pagosVO;
	}
	
	

}
