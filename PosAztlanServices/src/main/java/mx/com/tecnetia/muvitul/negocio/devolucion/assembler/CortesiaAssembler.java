package mx.com.tecnetia.muvitul.negocio.devolucion.assembler;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Cine;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TicketVenta;
import mx.com.tecnetia.muvitul.negocio.devolucion.vo.CortesiaPdfVO;
import mx.com.tecnetia.muvitul.servicios.util.Constantes;

public class CortesiaAssembler {

	public static CortesiaPdfVO getCortesiaPdfVO(Cine cine,TicketVenta ticketVenta,Integer idDevolucion) {
		
		if (idDevolucion == null)
			return null;
		
		
		StringBuilder direccion = new StringBuilder();
		direccion.append(cine.getContacto().getCalle().trim()).append(Constantes.COMMA);
		direccion.append(Constantes.NUMBER).append(cine.getContacto().getNumero().trim()).append(Constantes.COMMA);
		direccion.append(cine.getContacto().getColonia().trim()).append(Constantes.COMMA);
		direccion.append(cine.getContacto().getCp().trim()).append(Constantes.COMMA);
		direccion.append(cine.getContacto().getEstado().getNombre().trim());
		
		
		BigDecimal totalPago= new BigDecimal(0);
		totalPago=totalPago.add(ticketVenta.getTotal());
		totalPago=totalPago.subtract(ticketVenta.getDescuento());
		
		SimpleDateFormat sdf = new SimpleDateFormat(Constantes.FORMAT_DD_MM_YYYY_HH_MM_SS);
		String fechaHoraCompra = sdf.format(new Date());
		
		CortesiaPdfVO cortesiaPdfVO = new CortesiaPdfVO();
		cortesiaPdfVO.setRazonSocial(cine.getEmpresa().getNombre());
		cortesiaPdfVO.setNombreCine(cine.getNombre());
		cortesiaPdfVO.setDireccion(direccion.toString());
		cortesiaPdfVO.setRfc(cine.getEmpresa().getRfc());
		cortesiaPdfVO.setTelefono(cine.getContacto().getTelefono() + " " + (cine.getContacto().getTelefono2()==null?"": cine.getContacto().getTelefono2()));
		cortesiaPdfVO.setFechaHoraCompra(fechaHoraCompra);
		cortesiaPdfVO.setNumeroOrdenTicket(ticketVenta.getIdTicket().longValue());
		cortesiaPdfVO.setTotalPago(totalPago);	
		cortesiaPdfVO.setLeyenda(cine.getContacto().getTexto());
		cortesiaPdfVO.setSlogan(cine.getEmpresa().getSlogan());
		cortesiaPdfVO.setSugerencias(cine.getContacto().getSugerencia());
		cortesiaPdfVO.setAgradeciemiento("SIN AGRADECIMIENTO");
		cortesiaPdfVO.setFolioDevolucion(idDevolucion.toString());

		return cortesiaPdfVO;
	}

	
	
}
