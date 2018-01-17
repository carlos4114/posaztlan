package mx.com.tecnetia.muvitul.servicios.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Fecha {

	public static String getDayOfWeekShort(Date date) {
		String[] days = { "DO", "LU", "MA", "MI", "JU", "VI", "SA" };
		int numberDay = 0;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		numberDay = cal.get(Calendar.DAY_OF_WEEK);
		return days[numberDay - 1];
	}
	
	public static String getDayOfWeek(Date date) {
		String[] days = { "DOMINGO", "LUNES", "MARTES", "MIERCOLES", "JUEVES", "VIERNES", "SABADO" };
		int numberDay = 0;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		numberDay = cal.get(Calendar.DAY_OF_WEEK);
		return days[numberDay - 1];
	}
	

	public static String getBeforeDay(String dia) {
		Map<String,String> map=new HashMap<String,String>();
		map.put("DO", "SA");
		map.put("LU", "DO");
		map.put("MA", "LU");
		map.put("MI", "MA");
		map.put("JU", "MI");
		map.put("VI", "JU");
		map.put("SA", "VI");
		
		return map.get(dia);
	}
	
	public static Date getTime(String date) {
		
		String[] partsHora = date.split(Constantes.COLON);
		String[] partsMin = partsHora[1].split(" ");
		int hora= Integer.parseInt(partsHora[0]);
		int minuto= Integer.parseInt( partsMin[0]);
		
		if (date.contains(Constantes.PM)){
			hora= hora == 12 ? hora : hora+12 ;
		} else {
			hora= hora == 12 ? 0 : hora ;
		}
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, hora);
		cal.set(Calendar.MINUTE, minuto);
		cal.set(Calendar.SECOND, 0);
		
		return cal.getTime();
	}
	
	public static Date formatddMMyyyy(Date date) {
		Date output = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(Constantes.FORMAT_DD_MM_YYYY);
			String dateStr = sdf.format(date);
			output = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	// Suma los días recibidos a la fecha  
	public static Date sumarRestarDiasFecha(Date fecha, int dias){
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(fecha); // Configuramos la fecha que se recibe
	    calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0
	    return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos
	}

	// Suma o resta las horas recibidos a la fecha  
	public static Date sumarRestarHorasFecha(Date fecha, int horas){
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(fecha); // Configuramos la fecha que se recibe
	    calendar.add(Calendar.HOUR, horas);  // numero de horas a añadir, o restar en caso de horas<0
	    return calendar.getTime(); // Devuelve el objeto Date con las nuevas horas añadidas
	}
	 
	public static Integer diferenciaDias(Date fechaInicio,Date fachaFin){
		final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día 86400000
		int dias=(int) ((fechaInicio.getTime()-fachaFin.getTime())/MILLSECS_PER_DAY);
		return dias;
	}
	
	/**
     * Convierte una fecha en formato dd/MM/yyyy a forato yyyy-MM-dd .
     *
     * @param stringData Cadena con la fecha en formato dd/MM/yyyy
     * @return Fecha en tipo String con formato yyyy-MM-dd 
     */
    public static  String convertStringToData(String stringData) throws ParseException {

	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd");
	    Date data = sdf.parse(stringData);
	    String formattedTime = output.format(data);
	    return formattedTime;
	}
	 
}
