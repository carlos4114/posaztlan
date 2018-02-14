package mx.com.aztlan.pos.negocio.configuracion.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Formato;
import mx.com.aztlan.pos.negocio.configuracion.vo.FormatoVO;

public class FormatoAssembler {

	public static FormatoVO getFormatoVO(Formato formato) {

		if (formato == null)
			return null;

		FormatoVO formatoVO = new FormatoVO();
		formatoVO.setIdFormato(formato.getIdFormato());
		formatoVO.setCineVO(CineAssembler.getCineVO(formato.getCine()));
		formatoVO.setNombre(formato.getNombre());
		formatoVO.setActivo(formato.isActivo());

		return formatoVO;
	}

	public static List<FormatoVO> getFormatosVO(List<Formato> formatos) {

		if (formatos == null || formatos.isEmpty())
			return null;

		List<FormatoVO> formatosVO = new ArrayList<FormatoVO>();

		for (Formato formato : formatos) {
			formatosVO.add(FormatoAssembler.getFormatoVO(formato));
		}

		return formatosVO;
	}

	public static Formato getFormato(Integer idFormato) {

		if (idFormato == null)
			return null;

		Formato formato = new Formato();
		formato.setIdFormato(idFormato);

		return formato;
	}

}
