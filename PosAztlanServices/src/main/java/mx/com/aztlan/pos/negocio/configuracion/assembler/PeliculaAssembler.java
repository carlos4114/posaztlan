package mx.com.aztlan.pos.negocio.configuracion.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Pelicula;
import mx.com.aztlan.pos.negocio.configuracion.vo.PeliculaVO;
import mx.com.aztlan.pos.negocio.taquilla.assembler.DistribuidoraAssembler;

public class PeliculaAssembler {

	public static PeliculaVO getPeliculaVO(Pelicula pelicula) {
		if (pelicula == null)
			return null;

		PeliculaVO peliculaVO = new PeliculaVO();
		peliculaVO.setIdPelicula(pelicula.getIdPelicula());
		peliculaVO.setCineVO(CineAssembler.getCineVO(pelicula.getCine()));
		peliculaVO.setTitulo(pelicula.getTitulo());
		peliculaVO.setClasificacion(pelicula.getClasificacion());
		peliculaVO.setDuracion(pelicula.getDuracion());
		peliculaVO.setSinopsis(pelicula.getSinopsis());
		peliculaVO.setActivo(pelicula.isActivo());
		peliculaVO.setIcono(pelicula.getIcono());
		peliculaVO.setDistribuidora(DistribuidoraAssembler.getDistribuidoraVO(pelicula.getDistribuidora()));
		
		return peliculaVO;
	}

	public static List<PeliculaVO> getPeliculasVO(List<Pelicula> peliculas) {

		if (peliculas == null || peliculas.isEmpty())
			return null;

		List<PeliculaVO> peliculasVO = new ArrayList<PeliculaVO>();

		for (Pelicula pelicula : peliculas) {
			peliculasVO.add(PeliculaAssembler.getPeliculaVO(pelicula));
		}

		return peliculasVO;
	}
	

	public static Pelicula getPelicula(Integer idPelicula) {
		
		if (idPelicula == null)
			return null;

		Pelicula pelicula = new Pelicula();
		pelicula.setIdPelicula(idPelicula);

		return pelicula;
	}

	public static Pelicula getPelicula(PeliculaVO peliculaVO) {
		
		if (peliculaVO == null)
			return null;

		Pelicula pelicula = new Pelicula();
		pelicula.setIdPelicula(peliculaVO.getIdPelicula());
		pelicula.setCine(CineAssembler.getCine(peliculaVO.getCineVO().getIdCine()));
		pelicula.setTitulo(peliculaVO.getTitulo());
		pelicula.setClasificacion(peliculaVO.getClasificacion());
		pelicula.setDuracion(peliculaVO.getDuracion());
		pelicula.setSinopsis(peliculaVO.getSinopsis());
		pelicula.setActivo(peliculaVO.isActivo());
		pelicula.setIcono(peliculaVO.getIcono());

		return pelicula;
	}

}
