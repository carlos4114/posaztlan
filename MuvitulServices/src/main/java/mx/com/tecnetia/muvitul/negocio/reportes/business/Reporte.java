package mx.com.tecnetia.muvitul.negocio.reportes.business;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.negocio.muvitul.vo.IngresosDiariosTaquillaVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.muvitul.vo.IngresosDulceriaVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.muvitul.vo.IngresosTaquillaVO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ProgramacionDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ReportesDulceriaIbatisDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ReportesTaquillaIbatisDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.SalaDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.TipoClienteDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Programacion;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Sala;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TipoCliente;
import mx.com.tecnetia.muvitul.servicios.util.Fecha;

@Service
@Transactional
public class Reporte {
	
	@Autowired
	ReportesTaquillaIbatisDAOI reportesTaquillaIbatisDAO;	
	@Autowired
	ReportesDulceriaIbatisDAOI reportesDulceriaIbatisDAO;	
	@Autowired
	ProgramacionDAOI programacionDAO;
	@Autowired
	TipoClienteDAOI tipoClienteDAO;
	@Autowired
	SalaDAOI salaDAO;
	
	public ArrayList<Data> getProgramaciones(Integer idCine, Integer idSala, Date fecha){
		  
		  ArrayList<Data> data = new ArrayList<Data>();
		  
		  List<Programacion> programaciones = this.programacionDAO.findBySalaDiaAndExhibicionAll(idSala, Fecha.getDayOfWeekShort(fecha), fecha);
		  List<TipoCliente> tiposCliente = this.tipoClienteDAO.getTipoClientesOrdered();
		  for(Programacion programacion : programaciones){
			  Integer contPromociones = 0;
			  BigDecimal importePromociones = new BigDecimal(0);
			  for(TipoCliente tipoCliente : tiposCliente){
				  IngresosDiariosTaquillaVO ingresosTaquillaVO = this.reportesTaquillaIbatisDAO.getIngresosDiarios(idCine, programacion.getIdProgramacion(), tipoCliente.getIdTipoCliente(), fecha);				  
				  data.add( 
						    new Data(
						    		programacion.getIdProgramacion(),
						    	    programacion.getPelicula()==null?"":programacion.getPelicula().getTitulo(),
						    	    programacion.getHorario().toString(),
						    	    ingresosTaquillaVO==null?0:ingresosTaquillaVO.getCantidad(),
						    	    ingresosTaquillaVO==null?0:ingresosTaquillaVO.getImporte().doubleValue(),
						    	    ingresosTaquillaVO==null?0:ingresosTaquillaVO.getTotal().doubleValue(),
						    	    tipoCliente.getNombre()
						    	    )
						  );
				  contPromociones = contPromociones + (ingresosTaquillaVO==null?0:ingresosTaquillaVO.getPromociones());
				  importePromociones.add(ingresosTaquillaVO==null?new BigDecimal(0):ingresosTaquillaVO.getDescuentos());
			  }
			  data.add( 
					  new Data(
					    		programacion.getPelicula()==null?null:programacion.getPelicula().getIdPelicula(),
					    	    programacion.getPelicula()==null?"":programacion.getPelicula().getTitulo(),
					    	    programacion.getHorario().toString(),
					    	    contPromociones,
					    	    importePromociones.doubleValue(),
					    	    importePromociones.multiply(new BigDecimal(contPromociones)).doubleValue(),
					    	    "PROMOCION"
					    	    )					  
					  );
		  }		 

		  return data;
		 }
	
	/**
	 * @param args
	 */
	public ArrayList<SalaVO> getReporteDiario(Integer idCine, Date fecha) {
		ArrayList<SalaVO> salasVO = new ArrayList<SalaVO>();

		List<Sala> salas = this.salaDAO.findByIdCine(idCine);
		
		for(Sala sala : salas){
			salasVO.add(new SalaVO(sala.getIdSala(),sala.getNombre(), getProgramaciones(idCine, sala.getIdSala(), fecha)));
		}
		
		return salasVO;
	}

	/**
	 * @param args
	 */
	public static ArrayList<SalaVO> getReporteDiarioDummy() {
		ArrayList<SalaVO> salas = new ArrayList<SalaVO>();

		salas.add(new SalaVO(new Integer("1"),"Sala 1", getProgramacionesDummy()));
		salas.add(new SalaVO(new Integer("2"),"Sala 2", getProgramacionesDummy()));
		salas.add(new SalaVO(new Integer("3"),"Sala 3", getProgramacionesDummy()));

		return salas;
	}

	public static ArrayList<Data> getProgramacionesDummy(){
		  
		  ArrayList<Data> data = new ArrayList<Data>();
		  data.add( new Data(new Integer("1"),"Coco","14:45:00",new Integer("2"),new Double("10.0"),new Double("20.0"),"NIÑO"));
		  data.add( new Data(new Integer("1"),"Coco","14:45:00",new Integer("2"),new Double("20.0"),new Double("40.0"),"ADULTO"));
		  data.add( new Data(new Integer("1"),"Coco","14:45:00",new Integer("3"),new Double("20.0"),new Double("60.0"),"ADULTO"));
		  data.add( new Data(new Integer("1"),"Coco","14:45:00",new Integer("0"),new Double("0.0"),new Double("0.0"),"PROMOCION"));

		  data.add( new Data(new Integer("2"),"El Aro 3","16:10:00",new Integer("1"),new Double("30.0"),new Double("30.0"),"NIÑO"));
		  data.add( new Data(new Integer("2"),"El Aro 3","16:10:00",new Integer("2"),new Double("40.0"),new Double("80.0"),"ADULTO"));
		  data.add( new Data(new Integer("2"),"El Aro 3","16:10:00",new Integer("1"),new Double("35.0"),new Double("35.0"),"3A. EDAD"));
		  data.add( new Data(new Integer("2"),"El Aro 3","16:10:00",new Integer("3"),new Double("35.0"),new Double("105.0"),"3A. EDAD"));

		  
		  data.add( new Data(new Integer("3"),"El Aro 3","22:45:00",new Integer("1"),new Double("30.0"),new Double("30.0"),"ADULTO"));
		  data.add( new Data(new Integer("4"),"El Aro 3","22:45:00",new Integer("2"),new Double("25.0"),new Double("50.0"),"NIÑO"));
		  data.add( new Data(new Integer("5"),"El Aro 3","22:45:00",new Integer("3"),new Double("25.0"),new Double("75.0"),"NIÑO"));

		  data.add( new Data(new Integer("6"),"El Aro 3","22:45:00",new Integer("0"),new Double("0.0"),new Double("0.0"),"3A. EDAD"));
		  data.add( new Data(new Integer("7"),"El Aro 3","22:45:00",new Integer("0"),new Double("0.0"),new Double("0.0"),"PROMOCION"));
		  data.add( new Data(new Integer("7"),"El Aro 3","22:45:00",new Integer("2"),new Double("10.0"),new Double("20.0"),"PROMOCION"));

		  return data;
		 }
	
	public ArrayList<TaquillaSemanalVO> getReporteTaquillaSemanal(Integer idCine, Date fechaInicio, Date fechaFin) {
		ArrayList<TaquillaSemanalVO> taquillaSemanal = new ArrayList<TaquillaSemanalVO>();
				
		for(int i = 0; i <7; i++){
			Date fecha = Fecha.sumarRestarDiasFecha(fechaInicio, i);
			Integer noDiaSemana = Fecha.getDayOfWeekInt(fecha);
			List<IngresosTaquillaVO> ingresosSemanalesVO = this.reportesTaquillaIbatisDAO.getIngresosSemanales(idCine, noDiaSemana, fechaInicio, fechaFin);
			for(IngresosTaquillaVO ingresoSemanalVO : ingresosSemanalesVO){
				taquillaSemanal.add(
					    new TaquillaSemanalVO( 
								Fecha.getDayOfWeek(fecha),
								noDiaSemana,
								ingresoSemanalVO.getTitulo(),
								ingresoSemanalVO.getPrecio().doubleValue(),
					    		ingresoSemanalVO.getCantidad(),
					    		ingresoSemanalVO.getTotal().doubleValue(),
					    		ingresoSemanalVO.getSemana().toString()
							)
					);								
			}
			if(Fecha.diferenciaDias(fecha,fechaFin)==0){
				break;				
			}
		}

		return taquillaSemanal;
	}
	
	public ArrayList<DulceriaSemanalVO> getReporteDulceriaSemanal(Integer idCine, Date fechaInicio, Date fechaFin) {
		ArrayList<DulceriaSemanalVO> dulceriaSemanal = new ArrayList<DulceriaSemanalVO>();

		for(int i = 0; i <7; i++){
			Date fecha = Fecha.sumarRestarDiasFecha(fechaInicio, i);
			Integer noDiaSemana = Fecha.getDayOfWeekInt(fecha);
			List<IngresosDulceriaVO> ingresosSemanalesVO = this.reportesDulceriaIbatisDAO.getIngresosSemanales(idCine, noDiaSemana, fechaInicio, fechaFin);
			for(IngresosDulceriaVO ingresoSemanalVO : ingresosSemanalesVO){
				dulceriaSemanal.add(
					    new DulceriaSemanalVO( 
								Fecha.getDayOfWeek(fecha),
								noDiaSemana,
								ingresoSemanalVO.getProducto(),
								ingresoSemanalVO.getPrecio().doubleValue(),
								ingresoSemanalVO.getCantidad(),
								ingresoSemanalVO.getTotal().doubleValue()
							)
					);								
			}
			if(Fecha.diferenciaDias(fecha,fechaFin)==0){
				break;				
			}
		}

		return dulceriaSemanal;
	}

	
	public static ArrayList<TaquillaSemanalVO> getReporteTaquillaSemanalDummy() {
		ArrayList<TaquillaSemanalVO> taquillaSemanal = new ArrayList<TaquillaSemanalVO>();

		taquillaSemanal.add(new TaquillaSemanalVO( "MARTES",new Integer("2"),"Resident Evil 6: El capitulo final",new Double("50.00"),new Integer("5"),new Double("250.00"),"-15"));
		taquillaSemanal.add(new TaquillaSemanalVO( "MIERCOLES",new Integer("3"),"Resident Evil 6: El capitulo final",new Double("50.00"),new Integer("2"),new Double("100.00"),"-15"));
		taquillaSemanal.add(new TaquillaSemanalVO( "JUEVES",new Integer("4"),"Resident Evil 6: El capitulo final",new Double("50.00"),new Integer("2"),new Double("100.00"),"-15"));
		taquillaSemanal.add(new TaquillaSemanalVO( "DOMINGO",new Integer("7"),"El Aro 3",new Double("60.00"),new Integer("5"),new Double("300.00"),"-15"));
		taquillaSemanal.add(new TaquillaSemanalVO( "MARTES",new Integer("2"),"El Aro 3",new Double("60.00"),new Integer("5"),new Double("300.00"),"-15"));
		taquillaSemanal.add(new TaquillaSemanalVO( "MIERCOLES",new Integer("3"),"El Aro 3",new Double("60.00"),new Integer("5"),new Double("300.00"),"-15"));
		taquillaSemanal.add(new TaquillaSemanalVO( "MIERCOLES",new Integer("3"),"Terminator 3",new Double("60.00"),new Integer("5"),new Double("300.00"),"-15"));


		return taquillaSemanal;
	}
	
	public static ArrayList<DulceriaSemanalVO> getReporteDulceriaSemanalDummy() {
		ArrayList<DulceriaSemanalVO> dulceriaSemanal = new ArrayList<DulceriaSemanalVO>();

		dulceriaSemanal.add(new DulceriaSemanalVO( "LUNES",new Integer("1"),"Nachos",new Double("30.00"),new Integer("2"),new Double("60.00")));
		dulceriaSemanal.add(new DulceriaSemanalVO( "MARTES",new Integer("2"),"Nachos",new Double("30.00"),new Integer("5"),new Double("150.00")));
		dulceriaSemanal.add(new DulceriaSemanalVO( "MIERCOLES",new Integer("3"),"Nachos",new Double("30.00"),new Integer("5"),new Double("150.00")));
		dulceriaSemanal.add(new DulceriaSemanalVO( "MIERCOLES",new Integer("3"),"Refresco",new Double("30.00"),new Integer("5"),new Double("150.00")));
		dulceriaSemanal.add(new DulceriaSemanalVO( "JUEVES",new Integer("4"),"Ref-HogDog",new Double("100.00"),new Integer("5"),new Double("500.00")));
		dulceriaSemanal.add(new DulceriaSemanalVO( "JUEVES",new Integer("3"),"Ref-HogDog",new Double("100.00"),new Integer("5"),new Double("500.00")));
		dulceriaSemanal.add(new DulceriaSemanalVO( "LUNES",new Integer("1"),"Ref-HogDog",new Double("100.00"),new Integer("5"),new Double("500.00")));

		return dulceriaSemanal;
	}
	
	
	public ArrayList<TaquillaMensualVO> getReporteTaquillaMensual(Integer idCine, Date fechaInicio, Date fechaFin) {
		ArrayList<TaquillaMensualVO> taquillaMensual = new ArrayList<TaquillaMensualVO>();

		for(int i = 1; i<=5; i++){
			List<IngresosTaquillaVO> ingresosTaquillaVO = this.reportesTaquillaIbatisDAO.getIngresosMensuales(idCine, i, fechaInicio, fechaFin);
			
			for(IngresosTaquillaVO ingresoTaquillaVO : ingresosTaquillaVO){
				taquillaMensual.add(
						new TaquillaMensualVO( 
									"Semana "+i,
									i,
									ingresoTaquillaVO.getTitulo(),
									ingresoTaquillaVO.getPrecio().doubleValue(),
									ingresoTaquillaVO.getCantidad(),
									ingresoTaquillaVO.getTotal().doubleValue(),
									ingresoTaquillaVO.getSemana().toString()
								)
						);				
			}
		}
		        
		return taquillaMensual;
	}
	
	public static ArrayList<TaquillaMensualVO> getReporteTaquillaMensualDummy() {
		ArrayList<TaquillaMensualVO> taquillaMensual = new ArrayList<TaquillaMensualVO>();

		taquillaMensual.add(new TaquillaMensualVO( "Semana1",new Integer("1"),"Resident Evil 6: El capitulo final",new Double("50.00"),new Integer("5"),new Double("250.00"),"-15"));
		taquillaMensual.add(new TaquillaMensualVO( "Semana2",new Integer("2"),"Resident Evil 6: El capitulo final",new Double("50.00"),new Integer("2"),new Double("100.00"),"-15"));
		taquillaMensual.add(new TaquillaMensualVO( "Semana3",new Integer("3"),"Resident Evil 6: El capitulo final",new Double("50.00"),new Integer("2"),new Double("100.00"),"-15"));
		taquillaMensual.add(new TaquillaMensualVO( "Semana1",new Integer("1"),"El Aro 3",new Double("60.00"),new Integer("5"),new Double("300.00"),"-15"));
		taquillaMensual.add(new TaquillaMensualVO( "Semana2",new Integer("2"),"El Aro 3",new Double("60.00"),new Integer("5"),new Double("300.00"),"-15"));
		taquillaMensual.add(new TaquillaMensualVO( "Semana4",new Integer("4"),"El Aro 3",new Double("60.00"),new Integer("5"),new Double("300.00"),"-15"));
		taquillaMensual.add(new TaquillaMensualVO( "Semana5",new Integer("5"),"Terminator 3",new Double("60.00"),new Integer("5"),new Double("300.00"),"-15"));
        
		return taquillaMensual;
	}
	
	public ArrayList<DulceriaMensualVO> getReporteDulceriaMensual(Integer idCine, Date fechaInicio, Date fechaFin) {
		ArrayList<DulceriaMensualVO> dulceriaMensual = new ArrayList<DulceriaMensualVO>();

		for(int i = 1; i<=5; i++){
			List<IngresosDulceriaVO> ingresosDulceriaVO = this.reportesDulceriaIbatisDAO.getIngresosMensuales(idCine, i, fechaInicio, fechaFin);
			
			for(IngresosDulceriaVO ingresoDulceriaVO : ingresosDulceriaVO){
				dulceriaMensual.add(
						new DulceriaMensualVO( 
									"Semana "+i,
									i,
									ingresoDulceriaVO.getProducto(),
									ingresoDulceriaVO.getPrecio().doubleValue(),
									ingresoDulceriaVO.getCantidad(),
									ingresoDulceriaVO.getTotal().doubleValue()
								)
						);				
			}
		}
		
		return dulceriaMensual;
	}
	
	public static ArrayList<DulceriaMensualVO> getReporteDulceriaMensualDummy() {
		ArrayList<DulceriaMensualVO> dulceriaMensual = new ArrayList<DulceriaMensualVO>();

		dulceriaMensual.add(new DulceriaMensualVO( "Semana1",new Integer("1"),"Nachos",new Double("30.00"),new Integer("2"),new Double("60.00")));
		dulceriaMensual.add(new DulceriaMensualVO( "Semana2",new Integer("2"),"Nachos",new Double("30.00"),new Integer("5"),new Double("150.00")));
		dulceriaMensual.add(new DulceriaMensualVO( "Semana3",new Integer("3"),"Nachos",new Double("30.00"),new Integer("5"),new Double("150.00")));
		dulceriaMensual.add(new DulceriaMensualVO( "Semana4",new Integer("4"),"Refresco",new Double("30.00"),new Integer("5"),new Double("150.00")));
		dulceriaMensual.add(new DulceriaMensualVO( "Semana3",new Integer("3"),"Ref-HogDog",new Double("100.00"),new Integer("5"),new Double("500.00")));
		dulceriaMensual.add(new DulceriaMensualVO( "Semana5",new Integer("5"),"Ref-HogDog",new Double("100.00"),new Integer("5"),new Double("500.00")));
		dulceriaMensual.add(new DulceriaMensualVO( "Semana5",new Integer("5"),"Ref-HogDog",new Double("100.00"),new Integer("5"),new Double("500.00")));

		return dulceriaMensual;
	}
	
}