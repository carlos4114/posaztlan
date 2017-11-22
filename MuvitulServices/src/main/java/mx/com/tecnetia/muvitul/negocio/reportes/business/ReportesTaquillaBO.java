package mx.com.tecnetia.muvitul.negocio.reportes.business;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.negocio.configuracion.vo.EmpresaVO;
import mx.com.tecnetia.muvitul.negocio.reportes.vo.ArchivoExcelVO;
import mx.com.tecnetia.muvitul.negocio.reportes.vo.DetalleInventarioKardexVO;
import mx.com.tecnetia.muvitul.negocio.reportes.vo.ProgramacionVO;
import mx.com.tecnetia.muvitul.negocio.reportes.vo.ReporteJasperVO;
import mx.com.tecnetia.muvitul.negocio.reportes.vo.ReportesKardexVO;
import mx.com.tecnetia.muvitul.negocio.reportes.vo.SalaVO;
import mx.com.tecnetia.muvitul.negocio.reportes.vo.TaquillaVentaVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.CineVO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
@Transactional
public class ReportesTaquillaBO {

	private static final Logger logger = LoggerFactory.getLogger(ReportesTaquillaBO.class);
	@Autowired
	private ServletContext context;
	@Autowired
	private ReporteJasperBO reporteJasperBO;
	ArchivoExcelVO archivoExcelVO = null;

	public ArchivoExcelVO generarKardex(Integer idCine,Integer idUsuario) {
		
		archivoExcelVO = new ArchivoExcelVO("Kardex");
		ResourceBundle cfg = ResourceBundle.getBundle("config");
		String rutaKardexJasper = cfg.getString("reporte.cines.inventario.kardex.jasper");
		String rutaReporteXls = context.getRealPath(cfg.getString("reporte.cines.inventario.kardex.xls"));

		EmpresaVO empresaVO = new EmpresaVO();
		empresaVO.setNombre("Tecnetia");
		CineVO cineVO = new CineVO();
		cineVO.setNombre("Xochimilco");

		DetalleInventarioKardexVO detalleInventarioKardexVO1 = new DetalleInventarioKardexVO(new Date(), "Entrada",
				"Compra", 30, 20, new Double("200"), new Double("10"));
		DetalleInventarioKardexVO detalleInventarioKardexVO2 = new DetalleInventarioKardexVO(new Date(), "Entrada",
				"Cortesia", 10, 20, new Double("200"), new Double("10"));
		DetalleInventarioKardexVO detalleInventarioKardexVO3 = new DetalleInventarioKardexVO(new Date(), "Entrada",
				"Venta", 30, 20, new Double("200"), new Double("10"));
		DetalleInventarioKardexVO detalleInventarioKardexVO4 = new DetalleInventarioKardexVO(new Date(), "Entrada",
				"Compra", 30, 20, new Double("200"), new Double("10"));
		DetalleInventarioKardexVO detalleInventarioKardexVO5 = new DetalleInventarioKardexVO(new Date(), "Entrada",
				"Merma", 30, 20, new Double("200"), new Double("10"));

		List<DetalleInventarioKardexVO> listaDetalleInventario = new ArrayList<>();
		listaDetalleInventario.add(detalleInventarioKardexVO1);
		listaDetalleInventario.add(detalleInventarioKardexVO2);
		listaDetalleInventario.add(detalleInventarioKardexVO3);
		listaDetalleInventario.add(detalleInventarioKardexVO4);
		listaDetalleInventario.add(detalleInventarioKardexVO5);

		ReportesKardexVO reportesKardexVO = new ReportesKardexVO(cineVO, empresaVO, "30/07/2017",
				"Del 24 al 27 de Junio de 2017", new Double("30.7"), new Double("30.7"), "Coca-Cola", "Lata", 
				"Ml",new Integer(10),new Double("200"),listaDetalleInventario);
		
		HashMap<String, Object> paramKardex = new HashMap<String, Object>();
		paramKardex.put("empresa", reportesKardexVO.getEmpresaVO().getNombre());
		paramKardex.put("cine", reportesKardexVO.getCineVO().getNombre());
		paramKardex.put("emision", reportesKardexVO.getEmision());
		paramKardex.put("periodo", reportesKardexVO.getPeriodo());
		paramKardex.put("valInventarioI", reportesKardexVO.getValorInventarioInicial());
		paramKardex.put("valInventarioF", reportesKardexVO.getValorInventarioFinal());
		paramKardex.put("nombreProducto", reportesKardexVO.getNombreProducto());
		paramKardex.put("medida", reportesKardexVO.getMedida());
		paramKardex.put("tipo", reportesKardexVO.getTipo());
		paramKardex.put("invCantidad", reportesKardexVO.getInvCantidad());
		paramKardex.put("invTotal", reportesKardexVO.getInvTotal());

		JRBeanCollectionDataSource detalleInventario = new JRBeanCollectionDataSource(
				reportesKardexVO.getListDetalleInventarioKardexVO());
		paramKardex.put("recordDataSourceDetalle", detalleInventario);
 
		ReporteJasperVO reporteJasperVO = new ReporteJasperVO();
		reporteJasperVO.setRutaReporte(rutaKardexJasper);
		reporteJasperVO.setRutaPdf(rutaReporteXls);
		reporteJasperVO.setParametros(paramKardex);

		try {
			archivoExcelVO.setArchivo(reporteJasperBO.getReporteXls(reporteJasperVO));
		} catch (JRException e) {
 			e.printStackTrace();
		} catch (IOException e) {
 			e.printStackTrace();
		}
		return archivoExcelVO;

	}
	
	
	public ArchivoExcelVO generarReporteVentas(Integer idCine,Integer idUsuario) {
		
		archivoExcelVO = new ArchivoExcelVO("Kardex");
		ResourceBundle cfg = ResourceBundle.getBundle("config");
		String rutaVentasJasper = cfg.getString("reporte.cines.inventario.ventas.jasper");
		String rutaReporteXls = context.getRealPath(cfg.getString("reporte.cines.inventario.ventas.xls"));

		EmpresaVO empresaVO = new EmpresaVO();
		empresaVO.setNombre("Tecnetia");
		CineVO cineVO = new CineVO();
		cineVO.setNombre("Xochimilco");
		
		ProgramacionVO programacionVO  = new ProgramacionVO(new Double("100"),new Integer("100"), new Double("100"),new Integer("100"),new Double("100"),"Sala1","16:10","Rápidos y Furiosos 8");
		
		List<ProgramacionVO> listaProgramacionVO = new ArrayList<>();
		listaProgramacionVO.add(programacionVO);
		
		SalaVO salaVO1= new SalaVO( listaProgramacionVO,"Sala1"); 
		SalaVO salaVO2= new SalaVO( listaProgramacionVO,"Sala2"); 
		SalaVO salaVO3= new SalaVO( listaProgramacionVO,"Sala3"); 
		SalaVO salaVO4= new SalaVO( listaProgramacionVO,"Sala4"); 
		SalaVO salaVO5= new SalaVO( listaProgramacionVO,"Sala5"); 

		List<SalaVO> listaSalaVO = new ArrayList<>();
		listaSalaVO.add(salaVO1);
		listaSalaVO.add(salaVO2);
		listaSalaVO.add(salaVO3);
		listaSalaVO.add(salaVO4);
		listaSalaVO.add(salaVO5);

		
		TaquillaVentaVO taquillaVentaVO = new TaquillaVentaVO(empresaVO,cineVO,listaSalaVO );
 
		
		HashMap<String, Object> paramKardex = new HashMap<String, Object>();
		paramKardex.put("empresa",taquillaVentaVO.getEmpresaVO().getNombre() );
		paramKardex.put("cine", taquillaVentaVO.getCineVO().getNombre());
		paramKardex.put("emision", "30/07/2017");
		paramKardex.put("periodo",  "Del 24 al 24 de Julio de 2017");
		paramKardex.put("ingresoTaquilla",new Double("50,000.00"));
		paramKardex.put("ingresoDulceria", new Double("90,000.00"));
 		paramKardex.put("ingresoTotal", new Double("140,000.00"));
		paramKardex.put("tipoReporte", "Diario");
		JRBeanCollectionDataSource detalleInventario = new JRBeanCollectionDataSource(taquillaVentaVO.getListaSalaVO());
		paramKardex.put("listaDataSourceTaquilla", detalleInventario);
 
		ReporteJasperVO reporteJasperVO = new ReporteJasperVO();
		reporteJasperVO.setRutaReporte(rutaVentasJasper);
		reporteJasperVO.setRutaPdf(rutaReporteXls);
		reporteJasperVO.setParametros(paramKardex);

		try {
			archivoExcelVO.setArchivo(reporteJasperBO.getReporteXls(reporteJasperVO));
		} catch (JRException e) {
 			e.printStackTrace();
		} catch (IOException e) {
 			e.printStackTrace();
		}
		return archivoExcelVO;

	}

}
