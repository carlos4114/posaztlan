package mx.com.aztlan.pos.servicios.dulceria.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.EstatusPagoDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.FormaPagoDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.EstatusPago;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.FormaPago;
import mx.com.aztlan.pos.infraservices.persistencia.utileria.business.FechasUtilsBO;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.negocio.administracion.vo.VentaManualVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.CanalVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ProductoVO;
import mx.com.aztlan.pos.negocio.dulceria.business.VentaProductoBO;
import mx.com.aztlan.pos.negocio.dulceria.vo.ArchivoPdfVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.EstatusPagoVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.FormaPagoVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.PagoVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.PaqueteAgotadoVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.PaqueteVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.ProductoXPaqueteVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.TicketVentaVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.VentaVO;
import mx.com.aztlan.pos.negocio.reportes.vo.HttpResponseOcVO;
import mx.com.aztlan.pos.servicios.util.EstatusPagoType;
import mx.com.aztlan.pos.servicios.util.FormaPagoType;
import mx.com.aztlan.pos.servicios.util.MovimientoInvType;

@Service
public class VentaProductoController {

	@Autowired
	private VentaProductoBO ventaProductoBO;
	@Autowired
	private EstatusPagoDAOI estatusPagoDAO;	
	@Autowired
	private FormaPagoDAOI formaPagoDAO;	

	public List<PaqueteVO> getPaquetes(Integer idPuntoVenta) throws BusinessGlobalException {
		return ventaProductoBO.getPaquetes(idPuntoVenta);
	}
	
	public PaqueteAgotadoVO validarPaquete(List<PaqueteVO> paquetesVO,Integer idPuntoVenta) {
		return ventaProductoBO.validarPaquete(paquetesVO,idPuntoVenta );
	}
	
	@Transactional (readOnly=false)
	public TicketVentaVO createVenta(VentaVO ventaVO) throws BusinessGlobalException {
		return ventaProductoBO.createVenta(ventaVO);
	}
	
	@Transactional (readOnly=false)
	public HttpResponseOcVO createVentaManual(VentaManualVO ventaManualVO, VentaVO ventaVO) throws BusinessGlobalException {
		List<PaqueteVO> paquetesVO = new ArrayList<PaqueteVO>();
		BigDecimal importe = new BigDecimal(0);
		HttpResponseOcVO responseVO = new HttpResponseOcVO();
		List<PagoVO> pagosVO = new ArrayList<PagoVO>();
		PagoVO pagoVO = new PagoVO();
		
		for(ProductoVO productoVO : ventaManualVO.getProductos()){
			BigDecimal precio = productoVO.getPrecio();
			PaqueteVO paqueteVO = new PaqueteVO();
			
			paqueteVO.setActivo(true);
			paqueteVO.setCanalVO(new CanalVO(ventaVO.getIdCanal()));
			paqueteVO.setCantidad(productoVO.getCantidad());
			paqueteVO.setIdPaquete(productoVO.getIdProducto());			
			paqueteVO.setImporte(precio.multiply(new BigDecimal(productoVO.getCantidad())));
			paqueteVO.setPaquete(false);
												
			List<ProductoXPaqueteVO> productosVO = new ArrayList<ProductoXPaqueteVO>();
			ProductoXPaqueteVO productoXPaqVO = new ProductoXPaqueteVO();
			productoXPaqVO.setProductoVO(new mx.com.aztlan.pos.negocio.dulceria.vo.ProductoVO(productoVO.getIdProducto()));
			productoXPaqVO.setCantidad(1);
			
			productosVO.add(productoXPaqVO);
			paqueteVO.setProductosXPaqueteVO(productosVO);
			importe = importe.add(paqueteVO.getImporte());
			
			paquetesVO.add(paqueteVO);
		}
		
		EstatusPago estatusPago = this.estatusPagoDAO.findByClave(EstatusPagoType.PAGADO.getType());
		FormaPago formaPago = this.formaPagoDAO.findByClave(FormaPagoType.EFECTIVO.getType());
		
		pagoVO.setEstatusPagoVO(new EstatusPagoVO(estatusPago.getIdEstatus()));
		pagoVO.setFecha(FechasUtilsBO.getCurrentDate());
		pagoVO.setFormaPagoVO(new FormaPagoVO(formaPago.getIdFormaPago()));
		pagoVO.setImporte(importe);
		
		pagosVO.add(pagoVO);
		
		ventaVO.setTipoVenta(MovimientoInvType.VENTA_OUT_MAN.getType());		
		ventaVO.setPaquetesVO(paquetesVO);
		ventaVO.setPagosVO(pagosVO);
		
		//CREAMOS LA VENTA EN BD
		TicketVentaVO ticketVO = this.ventaProductoBO.createVenta(ventaVO);

		//CREAMOS EL REPORTE DE VENTA MANUAL EN EXCEL
		responseVO.setArchivoExcelVO(this.ventaProductoBO.crearXlsVentaManual(ticketVO.getIdTicket()));
		
		return responseVO;
	}
	
	public  List<ArchivoPdfVO> getTicketPdf(Integer idTicket, BigDecimal pagoCon, BigDecimal cambio, Integer idCine)throws BusinessGlobalException{
		return ventaProductoBO.generarTicketPdf(idTicket,pagoCon, cambio, idCine);
		
	}


}
