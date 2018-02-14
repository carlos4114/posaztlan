package mx.com.aztlan.pos.negocio.devolucion.assembler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Devolucion;
import mx.com.aztlan.pos.negocio.devolucion.vo.DevolucionBoletoVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.DevolucionProductoVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.DevolucionResponseVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.DevolucionVO;

public class DevolucionAssembler {

	public static Devolucion getDevolucion(DevolucionBoletoVO devolucionBoletoVO, Integer idUsuario ){
		
		if(devolucionBoletoVO==null)
			return null;
		
		Devolucion devolucion = new Devolucion();
		devolucion.setAutorizacion(AutorizacionAssembler.getAutorizacion(devolucionBoletoVO.getIdAutorizacion()));
		devolucion.setMotivoDevolucion(MotivoDevolucionAssembler.getMotivoDevolucion(devolucionBoletoVO.getMotivoDevolucionVO().getIdMotivoDevolucion()));
		devolucion.setTicketVenta(TicketVentaAssembler.getTicketVenta(devolucionBoletoVO.getIdTicketVenta()));
		devolucion.setTipoDevolucion(TipoDevolucionAssembler.getTipoDevolucion(devolucionBoletoVO.getTipoDevolucionVO().getIdTipoDevolucion()));
		devolucion.setUsuario(UsuarioAssembler.getUsuario(idUsuario));
		devolucion.setFechaHora(new Date());
		devolucion.setComentarios(devolucionBoletoVO.getComentarios());
		
		return devolucion;
	}
	
	public static Devolucion getDevolucion(DevolucionProductoVO devolucionProductoVO, Integer idUsuario ){
		
		if(devolucionProductoVO==null)
			return null;
		
		Devolucion devolucion = new Devolucion();
		devolucion.setAutorizacion(AutorizacionAssembler.getAutorizacion(devolucionProductoVO.getIdAutorizacion()));
		devolucion.setMotivoDevolucion(MotivoDevolucionAssembler.getMotivoDevolucion(devolucionProductoVO.getMotivoDevolucionVO().getIdMotivoDevolucion()));
		devolucion.setTicketVenta(TicketVentaAssembler.getTicketVenta(devolucionProductoVO.getIdTicketVenta()));
		devolucion.setTipoDevolucion(TipoDevolucionAssembler.getTipoDevolucion(devolucionProductoVO.getTipoDevolucionVO().getIdTipoDevolucion()));
		devolucion.setUsuario(UsuarioAssembler.getUsuario(idUsuario));
		devolucion.setFechaHora(new Date());
		devolucion.setComentarios(devolucionProductoVO.getComentarios());
		
		return devolucion;
	}
	
	
	public static DevolucionVO getDevolucionVO(Devolucion devolucion){
		if(devolucion==null)
			return null;
		
		DevolucionVO devolucionVO = new DevolucionVO();
		devolucionVO.setIdDevolucion(devolucion.getIdDevolucion());
		devolucionVO.setAutorizacionVO(AutorizacionAssembler.getAutorizacionVO(devolucion.getAutorizacion()));
		devolucionVO.setMotivoDevolucionVO(MotivoDevolucionAssembler.getMotivoDevolucionVO(devolucion.getMotivoDevolucion()));
		devolucionVO.setTipoDevolucionVO(TipoDevolucionAssembler.getTipoDevolucionVO(devolucion.getTipoDevolucion()));
		devolucionVO.setFechaHora(devolucion.getFechaHora());
		devolucionVO.setFolio(devolucion.getFolio());
		devolucionVO.setComentarios(devolucion.getComentarios());
		
		return devolucionVO;
	}
	
	public static List<DevolucionVO> getDevolucionesVO(Set<Devolucion> devoluciones){
		
		if(devoluciones==null)
			return null;
		
		List<DevolucionVO> devolucionesVO= new ArrayList<DevolucionVO>();
		
		for (Devolucion devolucion : devoluciones) {
			devolucionesVO.add(DevolucionAssembler.getDevolucionVO(devolucion));
		}

		return devolucionesVO;
	
	}
	
	public static DevolucionResponseVO getDevolucionResponseVO(Devolucion devolucion, boolean cortesia){
		
		if(devolucion==null)
			return null;
		
		DevolucionResponseVO devolucionResponseVO = new DevolucionResponseVO();
		devolucionResponseVO.setIdDevolucion(devolucion.getIdDevolucion());
		devolucionResponseVO.setCortesia(cortesia);
		
		return devolucionResponseVO;
	}
	
	
	
}
