package mx.com.aztlan.pos.negocio.dulceria.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Pago;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TicketVenta;
import mx.com.aztlan.pos.negocio.dulceria.vo.DetallePagoPdfVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.PagoVO;

public class PagoAssembler {

	public static Pago getPago(PagoVO pagoVO, TicketVenta  ticketVenta){

		if(pagoVO==null )
			return null;

		Pago pago= new Pago();
		pago.setEstatusPago(EstatusPagoAssembler.getEstatusPago(pagoVO.getEstatusPagoVO().getIdEstatus()));
		pago.setFormaPago(FormaPagoAssembler.getFormaPago(pagoVO.getFormaPagoVO().getIdFormaPago()));
		pago.setTicketVenta(ticketVenta);
		pago.setNoCuenta(pagoVO.getNoCuenta());
		pago.setImporte(pagoVO.getImporte());
		pago.setFecha(pagoVO.getFecha());
		
		return pago;
	}
	
	public static List<Pago> getPagos(List<PagoVO> pagosVO,TicketVenta  ticketVenta){

		if(pagosVO==null || pagosVO.isEmpty())
			return null;
		
		List<Pago> pagos = new ArrayList<Pago>();
		
		for (PagoVO pagoVO : pagosVO) {
			pagos.add(PagoAssembler.getPago(pagoVO, ticketVenta));
		}

		return pagos;
	}
	
	public static List<DetallePagoPdfVO> getDetallesPagoPdfVO(List<Pago> pagos){

		if(pagos==null || pagos.isEmpty())
			return null;
		
		List<DetallePagoPdfVO> detallesPagoPdfVO = new ArrayList<DetallePagoPdfVO>();
		
		for (Pago pago : pagos) {
			detallesPagoPdfVO.add(PagoAssembler.getDetallePagoPdfVO(pago));
		}

		return detallesPagoPdfVO;
	}
	
	public static DetallePagoPdfVO getDetallePagoPdfVO(Pago pago){

		if(pago==null )
			return null;

		DetallePagoPdfVO detallePagoPdfVO= new DetallePagoPdfVO();
		detallePagoPdfVO.setTipoTarjeta(pago.getFormaPago().getNombre());
		detallePagoPdfVO.setCantidad(pago.getImporte());
		detallePagoPdfVO.setNumeroTarjeta(pago.getNoCuenta());
		
		return detallePagoPdfVO;
	}
	
}
