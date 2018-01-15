package mx.com.tecnetia.muvitul.negocio.reportes.business;

import java.util.ArrayList;

public class Reporte {

	/**
	 * @param args
	 */
	public static ArrayList<Sala> getReporte() {
		ArrayList<Sala> salas = new ArrayList<Sala>();

		salas.add(new Sala(new Integer("1"),"Sala 1", getDatos()));
		salas.add(new Sala(new Integer("2"),"Sala 2", getDatos()));
		salas.add(new Sala(new Integer("3"),"Sala 3", getDatos()));

		return salas;
	}

	public static ArrayList<Data> getDatos(){
		  
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

	
	public static ArrayList<TaquillaSemanal> getReporteSemanal() {
		ArrayList<TaquillaSemanal> taquillaSemanal = new ArrayList<TaquillaSemanal>();

		taquillaSemanal.add(new TaquillaSemanal( "MARTES",new Integer("2"),"Resident Evil 6: El capitulo final",new Double("50.00"),new Integer("5"),new Double("250.00"),"-15"));
		taquillaSemanal.add(new TaquillaSemanal( "MIERCOLES",new Integer("3"),"Resident Evil 6: El capitulo final",new Double("50.00"),new Integer("2"),new Double("100.00"),"-15"));
		taquillaSemanal.add(new TaquillaSemanal( "JUEVES",new Integer("4"),"Resident Evil 6: El capitulo final",new Double("50.00"),new Integer("2"),new Double("100.00"),"-15"));
		taquillaSemanal.add(new TaquillaSemanal( "DOMINGO",new Integer("7"),"El Aro 3",new Double("60.00"),new Integer("5"),new Double("300.00"),"-15"));
		taquillaSemanal.add(new TaquillaSemanal( "MARTES",new Integer("2"),"El Aro 3",new Double("60.00"),new Integer("5"),new Double("300.00"),"-15"));
		taquillaSemanal.add(new TaquillaSemanal( "MIERCOLES",new Integer("3"),"El Aro 3",new Double("60.00"),new Integer("5"),new Double("300.00"),"-15"));
		taquillaSemanal.add(new TaquillaSemanal( "MIERCOLES",new Integer("3"),"Terminator 3",new Double("60.00"),new Integer("5"),new Double("300.00"),"-15"));


		return taquillaSemanal;
	}
	
	public static ArrayList<DulceriaSemanal> getReporteDulceriaSemanal() {
		ArrayList<DulceriaSemanal> dulceriaSemanal = new ArrayList<DulceriaSemanal>();

		dulceriaSemanal.add(new DulceriaSemanal( "LUNES",new Integer("1"),"Nachos",new Double("30.00"),new Integer("2"),new Double("60.00")));
		dulceriaSemanal.add(new DulceriaSemanal( "MARTES",new Integer("2"),"Nachos",new Double("30.00"),new Integer("5"),new Double("150.00")));
		dulceriaSemanal.add(new DulceriaSemanal( "MIERCOLES",new Integer("3"),"Nachos",new Double("30.00"),new Integer("5"),new Double("150.00")));
		dulceriaSemanal.add(new DulceriaSemanal( "MIERCOLES",new Integer("3"),"Refresco",new Double("30.00"),new Integer("5"),new Double("150.00")));
		dulceriaSemanal.add(new DulceriaSemanal( "JUEVES",new Integer("4"),"Ref-HogDog",new Double("100.00"),new Integer("5"),new Double("500.00")));
		dulceriaSemanal.add(new DulceriaSemanal( "JUEVES",new Integer("3"),"Ref-HogDog",new Double("100.00"),new Integer("5"),new Double("500.00")));
		dulceriaSemanal.add(new DulceriaSemanal( "LUNES",new Integer("1"),"Ref-HogDog",new Double("100.00"),new Integer("5"),new Double("500.00")));

		return dulceriaSemanal;
	}
	
}