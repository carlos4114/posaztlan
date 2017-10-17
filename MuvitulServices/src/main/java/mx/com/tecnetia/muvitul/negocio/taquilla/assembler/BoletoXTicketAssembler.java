package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.BoletosXTicket;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.BoletosXTicketId;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Cine;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TicketVenta;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.BoletoPdfVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.BoletoXTicketVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.DetalleTicketPdfVO;
import mx.com.tecnetia.muvitul.servicios.util.Constantes;

public class BoletoXTicketAssembler {

	public static BoletosXTicket getBoletoXTicket(BoletoXTicketVO boletoXTicketVO, TicketVenta ticketVenta, BigDecimal descuentoxBoleto) {

		if (boletoXTicketVO == null)
			return null;

		BigDecimal descuento= new BigDecimal(0);
		descuento = descuento.add(descuentoxBoleto);
		descuento= descuento.multiply(new BigDecimal(boletoXTicketVO.getCantidad()));
		
		BoletosXTicket boletoXTicket = new BoletosXTicket();
		BoletosXTicketId id = new BoletosXTicketId();
		id.setIdTicket(ticketVenta.getIdTicket());
		id.setIdTipoCliente(boletoXTicketVO.getTipoClienteVO().getIdTipoCliente());
		boletoXTicket.setId(id);
		boletoXTicket.setProgramacion(
				ProgramacionAssembler.getProgramacion(boletoXTicketVO.getProgramacionVO().getIdProgramacion()));
		boletoXTicket.setTicketVenta(ticketVenta);
		boletoXTicket.setTipoCliente(
				TipoClienteAssembler.getTipoCliente(boletoXTicketVO.getTipoClienteVO().getIdTipoCliente()));
		boletoXTicket.setCantidad(boletoXTicketVO.getCantidad());
		boletoXTicket.setDescuento(descuento);
		boletoXTicket.setImporte(boletoXTicketVO.getImporte());
		boletoXTicket.setFechaExhibicion(boletoXTicketVO.getFechaExhibicion());
		boletoXTicket.setActivo(true);

		
		
		
		return boletoXTicket;
	}

	public static List<BoletosXTicket> getBoletosXTicket(List<BoletoXTicketVO> boletosXTicketVO,
			TicketVenta ticketVenta, BigDecimal descuentoxBoleto) {

		if (boletosXTicketVO == null || boletosXTicketVO.isEmpty())
			return null;

		List<BoletosXTicket> boletosXTicket = new ArrayList<BoletosXTicket>();

		for (BoletoXTicketVO boletoXTicketVO : boletosXTicketVO) {
			if (boletoXTicketVO.getCantidad() > 0) {
				boletosXTicket.add(BoletoXTicketAssembler.getBoletoXTicket(boletoXTicketVO, ticketVenta, descuentoxBoleto));
			}

		}

		return boletosXTicket;
	}

	public static DetalleTicketPdfVO getDetalleTicketPdfVO(BoletosXTicket boletoXTicket) {

		if (boletoXTicket == null)
			return null;

		BigDecimal precio = new BigDecimal(0);
		precio=	precio.add(boletoXTicket.getImporte());
		precio=precio.divide(new BigDecimal(boletoXTicket.getCantidad()), 2, BigDecimal.ROUND_HALF_EVEN);
		DetalleTicketPdfVO detalleTicketVO = new DetalleTicketPdfVO();
		detalleTicketVO.setCantidad(boletoXTicket.getCantidad());
		detalleTicketVO.setDescripcion(boletoXTicket.getTipoCliente().getNombre());
		detalleTicketVO.setPrecio(precio);
		detalleTicketVO.setSubtotal(boletoXTicket.getImporte());

		return detalleTicketVO;
	}

	public static List<DetalleTicketPdfVO> getDetallesTicketPdfVO(Set<BoletosXTicket> boletosXTicket) {

		if (boletosXTicket == null || boletosXTicket.isEmpty())
			return null;

		List<DetalleTicketPdfVO> detallesTicketVO = new ArrayList<DetalleTicketPdfVO>();

		for (BoletosXTicket boletoXTicket : boletosXTicket) {
			detallesTicketVO.add(BoletoXTicketAssembler.getDetalleTicketPdfVO(boletoXTicket));
		}

		return detallesTicketVO;
	}

	public static BoletoPdfVO getBoletoPdfVO(Cine cine, BoletosXTicket boletosXTicket) {
		
		if (boletosXTicket == null)
			return null;
		
		SimpleDateFormat sdf = new SimpleDateFormat(Constantes.FORMAT_DD_MM_YYYY);
		String fechaExhibicion = sdf.format(boletosXTicket.getFechaExhibicion());
		
		BoletoPdfVO boletoPdfVO = new BoletoPdfVO();
		boletoPdfVO.setFecha(fechaExhibicion);
		boletoPdfVO.setNombreCine(cine.getNombre());
		boletoPdfVO.setTituloPelicula(boletosXTicket.getProgramacion().getPelicula().getTitulo());
		boletoPdfVO.setHorarioFuncion(boletosXTicket.getProgramacion().getHorario().toString());
		boletoPdfVO.setNumSala(boletosXTicket.getProgramacion().getSala().getNombre());
		boletoPdfVO.setTipoBoleto(boletosXTicket.getTipoCliente().getNombre());
		boletoPdfVO.setButaca("--");
		boletoPdfVO.setClasificacion(boletosXTicket.getProgramacion().getPelicula().getClasificacion());

		return boletoPdfVO;
	}
	
}