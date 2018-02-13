package mx.com.tecnetia.muvitul.servicios.facade;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.infraservices.servicios.NotFoundException;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.ConfigProgramacionVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.ConfigPromocionVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.PaqueteVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.ProductoVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.ProgramacionVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.PromocionVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.SalaProgramacionVO;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/configuracion")
public interface ConfiguracionFacadeI {

	@RequestMapping(value = "/configProgramaciones", method = RequestMethod.GET)
	public ResponseEntity<ConfigProgramacionVO> getConfigProgramacion(HttpServletRequest request)
			throws BusinessGlobalException, NotFoundException;

	@RequestMapping(value = "/programaciones", method = RequestMethod.GET)
	public ResponseEntity<List<SalaProgramacionVO>> getProgramacionOfSala(HttpServletRequest request,
			String fechaExhibicion) throws BusinessGlobalException, NotFoundException, ParseException;

	// @RequestMapping(value = "/programaciones", method = RequestMethod.GET)
	// public ResponseEntity<ProgramacionVO> getProgramacion(HttpServletRequest
	// request)
	// throws BusinessGlobalException, NotFoundException;

	@RequestMapping(value = "/programaciones", method = RequestMethod.POST)
	public ResponseEntity<ProgramacionVO> createProgramacion(HttpServletRequest request,
			@RequestBody ProgramacionVO programacionVO) throws BusinessGlobalException, NotFoundException;

	@RequestMapping(value = "/programaciones", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteProgramacion(HttpServletRequest request,
			@RequestParam(value = "id") Integer id) throws BusinessGlobalException, NotFoundException;

	@RequestMapping(value = "/configPromociones", method = RequestMethod.GET)
	public ResponseEntity<ConfigPromocionVO> getConfigPromocion(HttpServletRequest request)
			throws BusinessGlobalException, NotFoundException;

	@RequestMapping(value = "/promociones", method = RequestMethod.GET)
	public ResponseEntity<List<PromocionVO>> getPromociones(HttpServletRequest request, String fechaExhibicion)
			throws BusinessGlobalException, NotFoundException,ParseException;

	@RequestMapping(value = "/promociones", method = RequestMethod.POST)
	public ResponseEntity<PromocionVO> createPromocion(HttpServletRequest request, @RequestBody PromocionVO promocionVO)
			throws BusinessGlobalException, NotFoundException;

	@RequestMapping(value = "/promociones", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deletePromocion(HttpServletRequest request, @RequestParam(value = "id") Integer id)
			throws BusinessGlobalException, NotFoundException;

	@RequestMapping(value = "/productos", method = RequestMethod.GET)
	public ResponseEntity<List<ProductoVO>> getProductos(HttpServletRequest request)
			throws BusinessGlobalException, NotFoundException;

	@RequestMapping(value = "/paquetes", method = RequestMethod.GET)
	public ResponseEntity<List<PaqueteVO>> getPaquetes(HttpServletRequest request)
			throws BusinessGlobalException, NotFoundException;

	@RequestMapping(value = "/paquetes", method = RequestMethod.POST)
	public ResponseEntity<PaqueteVO> createPaquete(HttpServletRequest request, @RequestBody PaqueteVO paqueteVO)
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/paquetes", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deletePaquete(HttpServletRequest request, @RequestParam(value = "id") Integer id)
			throws BusinessGlobalException, NotFoundException;

}
