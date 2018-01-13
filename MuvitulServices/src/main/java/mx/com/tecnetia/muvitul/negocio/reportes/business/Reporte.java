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
		  data.add( new Data(new Integer("2"),"El Aro 3","16:10:00",new Integer("1"),new Double("30.0"),new Double("30.0"),"ADULTO"));
		  data.add( new Data(new Integer("3"),"El Aro 3","22:45:00",new Integer("1"),new Double("30.0"),new Double("30.0"),"ADULTO"));
		  data.add( new Data(new Integer("4"),"El Aro 3","22:45:00",new Integer("2"),new Double("25.0"),new Double("50.0"),"NIÑO"));
		  data.add( new Data(new Integer("5"),"El Aro 3","22:45:00",new Integer("3"),new Double("25.0"),new Double("75.0"),"NIÑO"));

		  data.add( new Data(new Integer("6"),"El Aro 3","22:45:00",new Integer("0"),new Double("0.0"),new Double("0.0"),"TERCERA EDAD"));
		  data.add( new Data(new Integer("7"),"El Aro 3","22:45:00",new Integer("0"),new Double("0.0"),new Double("0.0"),"PROMOCION"));

		  return data;
		 }

}