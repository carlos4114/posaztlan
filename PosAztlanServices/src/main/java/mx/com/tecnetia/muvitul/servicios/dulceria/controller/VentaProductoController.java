package mx.com.tecnetia.muvitul.servicios.dulceria.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.dulceria.business.VentaProductoBO;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.ArchivoPdfVO;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.PaqueteAgotadoVO;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.PaqueteVO;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.TicketVentaVO;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.VentaVO;

@Service
public class VentaProductoController {

	@Autowired
	private VentaProductoBO ventaProductoBO;

	public List<PaqueteVO> getPaquetes(Integer idPuntoVenta) throws BusinessGlobalException {
		return ventaProductoBO.getPaquetes(idPuntoVenta);
	}
	
	public PaqueteAgotadoVO validarPaquete(List<PaqueteVO> paquetesVO,Integer idPuntoVenta) {
		return ventaProductoBO.validarPaquete(paquetesVO,idPuntoVenta );
	}
	
	public TicketVentaVO createVenta(VentaVO ventaVO) throws BusinessGlobalException {
		return ventaProductoBO.createVenta(ventaVO);
	}
	
	public  List<ArchivoPdfVO> getTicketPdf(Integer idTicket, BigDecimal pagoCon, BigDecimal cambio, Integer idCine)throws BusinessGlobalException{
		return ventaProductoBO.generarTicketPdf(idTicket,pagoCon, cambio, idCine);
		
	}


}
