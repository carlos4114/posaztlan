package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Caja;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Cine;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TicketVenta;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.TicketPdfVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.TicketVentaVO;
import mx.com.tecnetia.muvitul.servicios.util.Constantes;

public class TicketVentaAssembler {

	public static TicketVenta getTicketVenta(Integer idUsuario, Integer idPuntoVenta,Integer idCaja, BigDecimal descuento,
			BigDecimal importe, BigDecimal total) {

		if (idUsuario == null || idPuntoVenta==null)
			return null;

		TicketVenta ticketVenta = new TicketVenta();
		ticketVenta.setPuntoVenta(PuntoVentaAssembler.getPuntoVenta(idPuntoVenta));
		ticketVenta.setUsuario(UsuarioAssembler.getUsuario(idUsuario));
		ticketVenta.setFecha(new Date());
		ticketVenta.setDescuento(descuento);
		ticketVenta.setImporte(importe);
		ticketVenta.setTotal(total);
		ticketVenta.setCaja(idCaja==null?null:new Caja(idCaja));

		return ticketVenta;

	}


	public static TicketVentaVO getTicketVentaVO(TicketVenta ticketVenta) {
		if (ticketVenta == null)
			return null;

		TicketVentaVO ticketVentaVO = new TicketVentaVO();
		ticketVentaVO.setIdTicket(ticketVenta.getIdTicket());
		ticketVentaVO.setPuntoVentaVO(PuntoVentaAssembler.getPuntoVentaVO(ticketVenta.getPuntoVenta()));
		ticketVentaVO.setUsuarioVO(UsuarioAssembler.getUsuarioVO(ticketVenta.getUsuario().getIdUsuario()));
		ticketVentaVO.setFecha(ticketVenta.getFecha());
		ticketVentaVO.setDescuento(ticketVenta.getImporte());
		ticketVentaVO.setImporte(ticketVenta.getImporte());
		ticketVentaVO.setTotal(ticketVenta.getTotal());
		ticketVentaVO.setIdCaja(ticketVenta.getCaja()==null?null:ticketVenta.getCaja().getIdCaja());
		
		return ticketVentaVO;
	}
	
	public static TicketPdfVO getTicketPdfVO(Cine cine, TicketVenta ticketVenta, BigDecimal recibe, BigDecimal cambio) {
		
		if (ticketVenta == null)
			return null;

		BigDecimal iva= new BigDecimal(0);
		iva=iva.add(ticketVenta.getTotal());
		iva=iva.subtract(ticketVenta.getDescuento());
		iva=iva.subtract(ticketVenta.getImporte());
		
		BigDecimal totalPago= new BigDecimal(0);
		totalPago=totalPago.add(ticketVenta.getTotal());
		totalPago=totalPago.subtract(ticketVenta.getDescuento());
		
		StringBuilder direccion = new StringBuilder();
		direccion.append(cine.getContacto().getCalle().trim()).append(Constantes.COMMA);
		direccion.append(Constantes.NUMBER).append(cine.getContacto().getNumero().trim()).append(Constantes.COMMA);
		direccion.append(cine.getContacto().getColonia().trim()).append(Constantes.COMMA);
		direccion.append(cine.getContacto().getCp().trim()).append(Constantes.COMMA);
		direccion.append(cine.getContacto().getEstado().getNombre().trim());
		
		SimpleDateFormat sdf = new SimpleDateFormat(Constantes.FORMAT_DD_MM_YYYY_HH_MM_SS);
		String fechaHoraCompra = sdf.format(new Date());
		
		TicketPdfVO ticketVO = new TicketPdfVO();
		ticketVO.setRazonSocial(cine.getEmpresa().getNombre());
		ticketVO.setNombreCine(cine.getNombre());
		ticketVO.setDireccion(direccion.toString());
 		ticketVO.setRfc (cine.getEmpresa().getRfc());
 		ticketVO.setTelefono(cine.getContacto().getTelefono() + " " + (cine.getContacto().getTelefono2()==null?"": cine.getContacto().getTelefono2()));
 		ticketVO.setFechaHoraCompra(fechaHoraCompra);
 		ticketVO.setNumeroOrdenTicket(ticketVenta.getIdTicket().longValue());
 		//ticketVO.setFolioTicket((long)ticketVenta.getIdTicket());
		ticketVO.setIva(iva);
		ticketVO.setSubtotal(ticketVenta.getImporte());
		ticketVO.setTotalPago(totalPago);		
		ticketVO.setRecibe(recibe);
		ticketVO.setCambio(cambio);
		ticketVO.setLeyenda(cine.getContacto().getTexto());
		ticketVO.setSlogan(cine.getEmpresa().getSlogan());
		ticketVO.setSugerencias(cine.getContacto().getSugerencia());

		return ticketVO;
	}
}
