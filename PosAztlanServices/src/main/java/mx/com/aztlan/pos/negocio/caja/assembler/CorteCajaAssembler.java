package mx.com.aztlan.pos.negocio.caja.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Autorizacion;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Caja;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.CargoAjuste;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.CorteCaja;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Usuario;
import mx.com.aztlan.pos.negocio.caja.vo.CorteCajaVO;

public class CorteCajaAssembler {
	
	public static CorteCaja getCorteCaja(CorteCajaVO corteCajaVO, Autorizacion autorizacion, Integer idCaja, Integer idUsuario){
		
		if(corteCajaVO==null)
			return null;
		
		CorteCaja corteCaja = new CorteCaja();
		
		corteCaja.setAutorizacion(autorizacion);
		corteCaja.setCaja(new Caja(idCaja));
		corteCaja.setComentarios(corteCajaVO.getComentarios());
		corteCaja.setEfectivoReal(corteCajaVO.getEfectivoReal());
		corteCaja.setEfectivoSistema(corteCajaVO.getEfectivoSistema());
		corteCaja.setFecha(corteCajaVO.getFecha());
		corteCaja.setIdCorteCaja(corteCajaVO.getIdCorteCaja());
		corteCaja.setUsuario(new Usuario(idUsuario));
		corteCaja.setCargoAjuste(new CargoAjuste(corteCajaVO.getIdCargoAjuste()));
		corteCaja.setEntradaCaja(corteCajaVO.getEntradaCaja());

		return corteCaja;
	}
	
	
	public static List<CorteCajaVO> getCorteCajaListVO(List<CorteCaja> cortesCaja){
		
		List<CorteCajaVO> cortesCajaVO = new ArrayList<CorteCajaVO>();
		
		if(cortesCaja==null)
			return cortesCajaVO;
		
		for(CorteCaja corteCaja:cortesCaja){
			cortesCajaVO.add(getCorteCajaVO(corteCaja));
		}
		
		return cortesCajaVO;
	}
	
	public static CorteCajaVO getCorteCajaVO(CorteCaja corteCaja){
		
		CorteCajaVO corteCajaVO = new CorteCajaVO();
		
		if(corteCaja==null)
			return null;
		
		corteCajaVO.setCaja(corteCaja.getCaja()==null?"":corteCaja.getCaja().getNombre());
		corteCajaVO.setComentarios(corteCaja.getComentarios());
		corteCajaVO.setEfectivoReal(corteCaja.getEfectivoReal());
		corteCajaVO.setEfectivoSistema(corteCaja.getEfectivoSistema());
		corteCajaVO.setFecha(corteCaja.getFecha());
		corteCajaVO.setIdCorteCaja(corteCaja.getIdCorteCaja());
		corteCajaVO.setCajero(corteCaja.getUsuario()==null?"":(corteCaja.getUsuario().getNombre()+" "+corteCaja.getUsuario().getPaterno()+" "+(corteCaja.getUsuario().getMaterno()==null?"":corteCaja.getUsuario().getMaterno())));
		corteCajaVO.setUsuarioAutorizador(corteCaja.getAutorizacion()==null?"":(corteCaja.getAutorizacion().getUsuario().getNombre()+" "+corteCaja.getAutorizacion().getUsuario().getPaterno()+" "+(corteCaja.getAutorizacion().getUsuario().getMaterno()==null?"":corteCaja.getAutorizacion().getUsuario().getMaterno())));
		corteCajaVO.setIdCargoAjuste(corteCaja.getCargoAjuste()==null?null:corteCaja.getCargoAjuste().getIdCargoAjuste());
		corteCajaVO.setCargoAjuste(corteCaja.getCargoAjuste()==null?"":corteCaja.getCargoAjuste().getNombre());
		corteCajaVO.setEntradaCaja(corteCaja.getEntradaCaja());
		
		return corteCajaVO;
	}
	
}
