package mx.com.aztlan.pos.servicios.devolucion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.negocio.devolucion.business.DevolucionBO;
import mx.com.aztlan.pos.negocio.devolucion.vo.ArchivoPdfVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.DevolucionBoletoVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.DevolucionProductoVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.DevolucionResponseVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.TicketVentaBoletoVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.TicketVentaProductoVO;


@Service
public class DevolucionController {
	@Autowired
	private DevolucionBO devolucionBO;

	public TicketVentaBoletoVO getTicketVentaBoletos(Integer idCine, Integer idTicket) {
		return devolucionBO.getTicketVentaBoletos(idCine, idTicket);
	}

	public TicketVentaProductoVO getTicketVentaProductos(Integer idCine,Integer idTicket) {
		return devolucionBO.getTicketVentaProductos(idCine, idTicket);
	}

	public DevolucionResponseVO  createDevolucionBoleto(Integer idUsuario, DevolucionBoletoVO devolucionBoletoVO) {
		return devolucionBO.createDevolucionBoleto(idUsuario, devolucionBoletoVO);
	}

	public  List<ArchivoPdfVO> generarCortesiaPdf(Integer idUsuario,Integer idTicket,Integer idDevolucion)throws BusinessGlobalException{
		return devolucionBO.generarCortesiaPdf(idUsuario,idTicket, idDevolucion);
	}

	public DevolucionResponseVO createDevolucionProducto(Integer idUsuario,Integer idCine, DevolucionProductoVO devolucionProductoVO) throws BusinessGlobalException {
		return devolucionBO.createDevolucionProducto(idUsuario, idCine, devolucionProductoVO);
	}

}
