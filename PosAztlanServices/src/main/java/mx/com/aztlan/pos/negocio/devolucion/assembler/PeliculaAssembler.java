package mx.com.aztlan.pos.negocio.devolucion.assembler;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Pelicula;
import mx.com.aztlan.pos.negocio.devolucion.vo.PeliculaVO;

public class PeliculaAssembler {

	public static PeliculaVO getPeliculaVO(Pelicula pelicula){

		if(pelicula==null)
			return null;
		
		PeliculaVO peliculaVO = new PeliculaVO();
		peliculaVO.setIdPelicula(pelicula.getIdPelicula());
		peliculaVO.setCineVO(CineAssembler.getCineVO(pelicula.getCine()));
		peliculaVO.setDistribuidoraVO(DistribuidoraAssembler.getDistribuidoraVO(pelicula.getDistribuidora()));
		peliculaVO.setPaisVO(PaisAssembler.getPaisVO(pelicula.getPais()));
		peliculaVO.setTitulo(pelicula.getTitulo());
		peliculaVO.setClasificacion(pelicula.getClasificacion());
		peliculaVO.setDuracion(pelicula.getDuracion());
		peliculaVO.setSinopsis(pelicula.getSinopsis());
		peliculaVO.setActivo(pelicula.isActivo());
		peliculaVO.setIcono(pelicula.getIcono());
		return peliculaVO;
	}

	
}
