package mx.com.aztlan.pos.negocio.venta.business;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.AsistenciaXSalaDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.BoletosXTicketDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.CineDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ExistenciaBoletoDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.FolioBoletoDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.FolioIbatisDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ImpuestoBoletoDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ImpuestosXTicketTaquillaDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.PagoDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.PrecioXFormatoDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ProgramacionDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.PromocionesXTicketDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.TicketVentaDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.AsistenciaXSala;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.AsistenciaXSalaId;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.BoletosXTicket;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Cine;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.EstatusAsiento;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ExistenciaBoletos;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.FolioBoleto;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.FolioBoletoId;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ImpuestoBoleto;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ImpuestosXTicketTaquilla;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Pago;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Programacion;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PromocionesXTicket;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TicketVenta;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.enumeration.EstatusAsientoEnum;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.negocio.configuracion.vo.AsientoVO;
import mx.com.aztlan.pos.negocio.taquilla.assembler.BoletoXTicketAssembler;
import mx.com.aztlan.pos.negocio.taquilla.assembler.ImpuestoXTicketTaquillaAssembler;
import mx.com.aztlan.pos.negocio.taquilla.assembler.PagoAssembler;
import mx.com.aztlan.pos.negocio.taquilla.assembler.PeliculaAssembler;
import mx.com.aztlan.pos.negocio.taquilla.assembler.PrecioXFormatoAssembler;
import mx.com.aztlan.pos.negocio.taquilla.assembler.ProgramacionAssembler;
import mx.com.aztlan.pos.negocio.taquilla.assembler.PromocionXTicketAssembler;
import mx.com.aztlan.pos.negocio.taquilla.assembler.TicketVentaAssembler;
import mx.com.aztlan.pos.negocio.taquilla.vo.ArchivoPdfVO;
import mx.com.aztlan.pos.negocio.taquilla.vo.BoletoPdfVO;
import mx.com.aztlan.pos.negocio.taquilla.vo.BoletoXTicketVO;
import mx.com.aztlan.pos.negocio.taquilla.vo.DetalleImpuestoPdfVO;
import mx.com.aztlan.pos.negocio.taquilla.vo.DetallePagoPdfVO;
import mx.com.aztlan.pos.negocio.taquilla.vo.DetalleTicketPdfVO;
import mx.com.aztlan.pos.negocio.taquilla.vo.ExistenciaBoletoVO;
import mx.com.aztlan.pos.negocio.taquilla.vo.PeliculaVO;
import mx.com.aztlan.pos.negocio.taquilla.vo.PrecioXFormatoVO;
import mx.com.aztlan.pos.negocio.taquilla.vo.ProgramacionVO;
import mx.com.aztlan.pos.negocio.taquilla.vo.PromocionXTicketVO;
import mx.com.aztlan.pos.negocio.taquilla.vo.TicketPdfVO;
import mx.com.aztlan.pos.negocio.taquilla.vo.TicketVentaVO;
import mx.com.aztlan.pos.negocio.taquilla.vo.VentaVO;
import mx.com.aztlan.pos.negocio.taquilla.vo.VersionFormatoVO;
import mx.com.aztlan.pos.servicios.util.Constantes;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
@Transactional
public class VentaManualBO {
	private static final Logger logger = LoggerFactory.getLogger(VentaManualBO.class);

	@Autowired
	private TicketVentaDAOI ticketVentaDAO;

	@Autowired
	private PagoDAOI pagoDAO;

	@Autowired
	private BoletosXTicketDAOI boletoXTicketDAO;

	@Autowired
	private PromocionesXTicketDAOI promocionXTicketDAO;

	@Autowired
	private ExistenciaBoletoDAOI existenciaBoletoDAO;

	@Autowired
	private ImpuestosXTicketTaquillaDAOI impuestosXTicketTaquillaDAO;

	@Autowired
	private ImpuestoBoletoDAOI impuestoBoletoDAO;

	@Autowired
	private CineDAO cineDAO;

	@Autowired
	private ServletContext context;

	@Autowired
	private ProgramacionDAOI programacionDAO;

	@Autowired
	private PrecioXFormatoDAOI precioXFormatoDAO;
	
	@Autowired
	private AsistenciaXSalaDAOI asistenciaXsalaDAO;
	
	@Autowired
	private FolioBoletoDAOI folioBoletoDAO;
	
	@Autowired
	private FolioIbatisDAOI folioIbatisDAO;
	
}
