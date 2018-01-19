package mx.com.tecnetia.muvitul.infraservices.persistencia.utileria.business;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


/**
 * Clase que se encarga de manipular los distintos formatos para fechas
 *<pre>
 * Formatos de fechas
 *<pre>
 * @author         <a href="mailto:ricardo.barranco@softtek.com">Ricardo Barranco F.</a>
 * @version         1.0
 *
 * @since         1.0
 */
public class FechasUtilsBO {
	/**
     *	Este método obtiene la fecha a partir de enteros
     */
    public static String getDateDDMMYYYY(int day, int month, int year, String separator) {
    	
    	String dayString = day<10?"0"+Integer.toString(day):Integer.toString(day);
    	String monthString = month<10?"0"+Integer.toString(month):Integer.toString(month);
    	String yearString = Integer.toString(year);
    	
    	return dayString+separator+monthString+separator+yearString;
    }	
    
    /**
     *	Este método obtiene el dia como cadena a partir de la fecha
     */
    public static String getStringDay(String date, String delimitador) {
    	Integer dia = getDayOfIntValue(date, delimitador);
    	return dia<10?"0"+dia.toString():dia.toString();
    }
	
	/**
     *	Este método obtiene el nombre del mes a partir de una fecha
     */
    public static String obtenerMesCadena(String date, String delimitador) {
    	
      int mes = getMonthOfIntValue(date, delimitador)-1;
      
      String mesF = null;
      switch (mes) {
        case 0:
        	mesF = "Enero";
          break;
        case 1:
        	mesF = "Febrero";
          break;
        case 2:
        	mesF = "Marzo";
          break;
        case 3:
        	mesF = "Abril";
          break;
        case 4:
        	mesF = "Mayo";
          break;
        case 5:
        	mesF = "Junio";
          break;
        case 6:
        	mesF = "Julio";
          break;
        case 7:
        	mesF = "Agosto";
          break;
        case 8:
        	mesF = "Septiembre";
          break;
        case 9:
        	mesF = "Octubre";
          break;
        case 10:
        	mesF = "Noviembre";
          break;
        default:
        	mesF = "Diciembre";
          break;
      }

      return mesF;
    }
	
	/** Variable estatica con la fechaActual en formato Completo*/
	private static String fechaActualCadena;
	
	/**
     * Se encarga de obtener el ultimo día del mes de una fecha
     * @return int ultimo día del mes
     * @param Date fecha
     */
    public static Date getLastDayOfMonth(Date fecha) {
    	int mes = getMonthOfIntValue(dateToString(fecha,"dd/mm/yyyy"), "/")-1;
    	int anio = getYearOfIntValue(dateToString(fecha,"dd/mm/yyyy"), "/");
    	if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12){    		
           return stringToDate("31/"+Integer.toString(mes)+"/"+Integer.toString(anio),"/");    		
    	}
    	
    	if(mes == 4 || mes == 6 || mes == 9 || mes == 11){    		
    		return stringToDate("30/"+Integer.toString(mes)+"/"+Integer.toString(anio),"/");    		
     	}
    	    	
        if(isBisiesto(anio)){
        	return stringToDate("29/"+Integer.toString(mes)+"/"+Integer.toString(anio),"/");	
        }
        
        return stringToDate("28/"+Integer.toString(mes)+"/"+Integer.toString(anio),"/");
    }
	
	/**
     * Se encarga de validar si un año es bisiesto
     * @return true en caso de que se bisiesto
     * @param String anio
     */
    public static boolean isBisiesto(int anio) {
    	int anioInt = anio;
    	if ((anioInt % 4 == 0) && ((anioInt % 100 != 0) || (anioInt % 400 == 0)))
    		return true;
    	else
    		return false;
    }
    
	/**
     * Se encarga de formatear la fecha con el patron definido
     * por el parametro formato
     * @return Fecha en formato String al cual se se aplico la mascara
     * @param fecha <code>Date</code>Parametro fecha que se desea formatear
     * @param formato <code>String</code> Patron que contiene el formato
     */
    public static String dateToString(Date fecha, String formato) {
        String fechaStr = null;

        SimpleDateFormat sdf =
            new SimpleDateFormat(getFormato(formato), Locale.getDefault());

        try {
            fechaStr = sdf.format(fecha);
        }
        catch (Exception e) {
            fechaStr = "";
        }

        return fechaStr;
    }
    
    /**
     * Se encarga de formatear la fecha con el patron definido con hora
     * por el parametro formato
     * @return Fecha en formato String al cual se se aplico la mascara
     * @param fecha <code>Date</code>Parametro fecha que se desea formatear
     * @param formato <code>String</code> Patron que contiene el formato
     */
    public static String dateHourToString(Date fecha, String formato) {
        String fechaStr = null;

        SimpleDateFormat sdf =
            new SimpleDateFormat(formato, Locale.getDefault());

        try {
            fechaStr = sdf.format(fecha);
        }
        catch (Exception e) {
            fechaStr = "";
        }

        return fechaStr;
    }
    
    /**
     * Se encarga de formatear la fecha con el patron definido
     * por el parametro formato
     * @return Fecha en formato String al cual se se aplico la mascara
     * @param fecha <code>Date</code>Parametro fecha que se desea formatear
     * @param formato <code>String</code> Patron que contiene el formato
     */
    public static String getHour(Date fecha, String formato) {
        String fechaStr = null;

        SimpleDateFormat sdf =
            new SimpleDateFormat(formato.replaceAll("MM","mm"), Locale.getDefault());

        try {
            fechaStr = sdf.format(fecha);
        }
        catch (Exception e) {
            fechaStr = "";
        }

        return fechaStr;
    }

    /**
     * Regresa una fecha en un Objeto Date a partir de una fecha en String
     * @param date <code>String</code> Fecha que se quiere formatear a Date
     * @param delimitador Delimitador de la fecha. Ej: / - . 01/02/1998  01-02-1998
     * @return Date
     */
    public static Date stringToDate(String date, String delimitador) {
        Calendar cDate1 =
            new GregorianCalendar(
                getYearOfIntValue(date, delimitador),
                getMonthOfIntValue(date, delimitador)-1,
                getDayOfIntValue(date, delimitador));

        return cDate1.getTime();
    }

    /**
     * Regresa el dia a partir de una fecha en String
     * @param date <code>String</code> Fecha a la cual se quiere obtener el dia
     * @param delimitador Delimitador de la fecha. Ej: / - . 01/02/1998  01-02-1998
     * @return int
     */
    public static int getDayOfIntValue(String date, String delimitador) {
        int day = 0;
        String[] fecha = date.split(delimitador);

        try {
            if ((fecha != null) && (fecha.length > 1)) {
                day = Integer.parseInt(fecha[0]);
            }

            return day;
        }
        catch (Exception e) {
            return 0;
        }
    }

    /**
     * Regresa el mes a partir de una fecha en String
     * @param date <code>String</code> Fecha a la cual se quiere obtener el mes
     * @param delimitador Delimitador de la fecha. Ej: / - . 01/02/1998  01-02-1998
     * @return int
     */
    public static int getMonthOfIntValue(String date, String delimitador) {
        int month = 0;
        String[] fecha = date.split(delimitador);

        try {
            if ((fecha != null) && (fecha.length > 1)) {
                month = Integer.parseInt(fecha[1]);
                //month = month - 1;
            }
        }
        catch (Exception e) {
            return 0;
        }

        return month;
    }

    /**
     * Regresa el anio a partir de una fecha en String
     * @param date <code>String</code> Fecha a la cual se quiere obtener el anio
     * @param delimitador  Delimitador de la fecha. Ej: / - . 01/02/1998  01-02-1998
     * @return int
     */
    public static int getYearOfIntValue(String date, String delimitador) {
        String[] fecha = date.split(delimitador);
        int year;

        try {
            year = Integer.parseInt(fecha[fecha.length - 1]);

            //year = new Integer(  fecha[fecha.length-1]).intValue();
        }
        catch (Exception e) {
            year = 0;
        }

        return year;
    }

    /**
     * Método que regresa el año actual en número
     * @return int Año Actual
     */
    public static int getCurrentYear() {
        Calendar cal = new GregorianCalendar();
        int year = cal.get(Calendar.YEAR);

        return year;
    }

    /**
     * Método que regresa el mes actual en número
     * @return int Mes Actual
     */
    public static int getCurrentMonth() {
        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        // agreagdo por omar
        int year = cal.get( Calendar.YEAR ) ; 
        month += ( year * 100 ) ;
        ////////

        return month;
    }

    /**
     * Método que regresa el dia actual en número
     * @return int Dia Actual
     */
    public static int getCurrentDay() {
        Calendar cal = new GregorianCalendar();
        int day = cal.get(Calendar.DAY_OF_MONTH);

        return day;
    }

    /**
     * Obtiene la fecha Actual en Gregorian Calendar
     *
     * @return Date
     */
    public static Date getCurrentDate() {
        Calendar cal = new GregorianCalendar();

        return cal.getTime();
    }

    /**
     * Regresa la fecha actual en el formato pedido por parametro
     * @param format <code>int</code>Constante de formato de fecha actual
     * @return sDate <code>String</code>Cadena con la fecha actual dado el formato
     */
    public static String getCurrentDate(int format) {
        String sDate = null;
        int year = getCurrentYear();
        String strYear = "" + year;
        int month = getCurrentMonth(); // 0=Jan, 1=Feb, ...
        month += 1;

        String strMonth;

        if (month < 10) {
            strMonth = "0" + month;
        }
        else {
            strMonth = "" + month;
        }

        int day = getCurrentDay(); // 1...
        String strDay;

        if (day < 10) {
            strDay = "0" + day;
        }
        else {
            strDay = "" + day;
        }

        switch (format) {
        // dd-mm-yyyy
        case 0 :
            sDate = strDay + "-" + strMonth + "-" + strYear;

            break;

        // dd-mm-yy
        case 1 :
            sDate = strDay + "-" + strMonth + "-" + strYear.substring(2, 4);

            break;

        // mm-dd-yyyy
        case 2 :
            sDate = strMonth + "-" + strDay + "-" + strYear;

            break;

        // mm-dd-yy
        case 3 :
            sDate = strMonth + "-" + strDay + "-" + strYear.substring(2, 4);

            break;

        // dd/mm/yyyy
        case 4 :
            sDate = strDay + "/" + strMonth + "/" + strYear;

            break;

        // dd/mm/yy
        case 5 :
            sDate = strDay + "/" + strMonth + "/" + strYear.substring(2, 4);

            break;

        // mm/dd/yyyy
        case 6 :
            sDate = strMonth + "/" + strDay + "/" + strYear;

            break;

        // mm/dd/yy
        case 7 :
            sDate = strMonth + "/" + strDay + "/" + strYear.substring(2, 4);

            break;
        
        // yymmaa
        case 8:
        	sDate =  strYear.substring(2, 4)+strMonth +strDay;
        	
        	break;
        // yyyymmaa
        case 9:
        	sDate =  strYear+strMonth +strDay;
        	
        	break;
        //ddmmyy
        case 10:
        	sDate =  strDay+strMonth+strYear.substring(2, 4);
        	break;
        //ddmmyyyy
        case 11:
        	sDate =  strDay+strMonth+strYear;
        	break;
        default :
            sDate = strDay + "/" + strMonth + "/" + strYear;
        }

        return sDate;
    }

    /**
     * Aplica el formato correcto para el formateador de fechas
     * @param formato <code>String</code> Formato
     * @return String
     */
    public static String getFormato(String formato) {
        return formato.replaceAll("m", "M");
    }

    /**
     * Suma años a la fecha pasada por parametro como tipo date.
     *
     * @param d Cadena con la fecha
     * @param iYears Años a agregar
     * @return Fecha en tipo Date agregandole los años especificados
     */
    public static Date addYearsToDate(java.util.Date d, int iYears) {
        //create Calendar
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);

        //add years
        cal.add(Calendar.YEAR, iYears);

        //create Date
        return cal.getTime();
    }
    
    /**
     * Suma minutos a la fecha pasada por parametro como tipo date.
     *
     * @param d fecha
     * @param min Minutos a agregar
     * @return Fecha en tipo Date agregandole los minutos especificados
     */
    public static Date addMinutesToDate(java.util.Date d, int min) {
        //create Calendar
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);

        //add minutes
        cal.add(Calendar.MINUTE, min);

        //create Date
        return cal.getTime();
    }

    /**
     * Suma años a la fecha pasada por parametro como cadena.
     *
     * @param date Cadena con la fecha
     * @param delimitador Delimitador de la fecha (Si el separador es / o - o . etc....
     * @param iYears Años a agregar
     * @return Cadena con la fecha agregandole los años especificados
     */
    public static String addYearsToDate(String date, String delimitador,
        int iYears) {
        return dateToString(
                addYearsToDate(stringToDate(date, delimitador), iYears),
                "dd" + delimitador + "mm" + delimitador + "yyyy");
    }

    /**
     * Suma dias a la fecha pasada por parametro como tipo date.
     *
     * @param d Cadena con la fecha
     * @param iDays Dias a agregar
     * @return Fecha en tipo Date agregandole los dias especificados
     */
    public static Date addDaysToDate(java.util.Date d, int iDays) {
        //create Calendar
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);

        //add days
        cal.add(Calendar.DATE, iDays);

        //create Date
        return cal.getTime();
    }

    /**
     * Suma dias a la fecha pasada por parametro como cadena.
     *
     * @param date Cadena con la fecha
     * @param delimitador Delimitador de la fecha (Si el separador es / o - o . etc....
     * @param iDays Dias a agregar
     * @return Cadena con la fecha agregandole los dias especificados
     */
    public static String addDaysToDate(String date, String delimitador,
        int iDays) {
        return dateToString(
            addDaysToDate(stringToDate(date, delimitador), iDays),
            "dd" + delimitador + "mm" + delimitador + "yyyy");
    }

    /**
     * Suma meses a la fecha pasada por parametro como tipo date.
     *
     * @param d Cadena con la fecha
     * @param iMonths Meses a agregar
     * @return Fecha en tipo Date agregandole los meses especificados
     */
    public static Date addMonthsToDate(java.util.Date d, int iMonths) {
        //create Calendar
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);

        //add months
        cal.add(Calendar.MONTH, iMonths);

        //create Date
        return cal.getTime();
    }

    /**
     * Suma meses a la fecha pasada por parametro como cadena.
     *
     * @param date Cadena con la fecha
     * @param delimitador Delimitador de la fecha (Si el separador es / o - o . etc....
     * @param iMonths Meses a agregar
     * @return Cadena con la fecha agregandole los meses especificados
     */
    public static String addMonthsToDate(String date, String delimitador,
        int iMonths) {
        return dateToString(addMonthsToDate(
                stringToDate(date, delimitador),
                iMonths), "dd" + delimitador + "mm" + delimitador + "yyyy");
    }
    
    
    /**
     * Suma un periodo de tiempo a una fecha dada.
     *
     * @param d Fecha en formato Date
     * @param cycleTrm Periodo a agregar
     * @param cyclePeriod Indica que tipo de periodo sera.
     * @return objeto Date con la fecha agregandole los meses especificados
     */
    /*public static Date addPeriodToDate(java.util.Date d, int cycleTrm, String cyclePeriod) {
    	
    	Date newDate = null;
    	
    	//MESES
    	if (cyclePeriod.trim().toUpperCase().equals(Constants.EOM_PERIOD)) { 
    		newDate = addMonthsToDate(d, cycleTrm);
    	}
    	// DIAS
    	else if (cyclePeriod.trim().toUpperCase().equals(Constants.DAY_PERIOD)) {
    		newDate = addDaysToDate(d, cycleTrm);
    	}
    	// SEMANAS
    	else if (cyclePeriod.trim().toUpperCase().equals(Constants.WEEK_PERIOD)) {
    		newDate = addDaysToDate(d, cycleTrm * 7);
    	}
        //create Date
        return newDate;
    }*/
    
    /**
     * Convierte una fecha de tipo Date a Timestamp
     *
     * @param  date Fecha en tipo Date
     * @return Fecha en Timestamp
     */
    public static Timestamp convertDateToTimestamp(Date date) {
        if (date instanceof Timestamp) {
            return (Timestamp) date;
        }

        return new Timestamp(date.getTime());
    }

    /**
     * Convierte una fecha de tipo Date a un Date de GregorianCalendar
     *
     * @param date Fecha en tipo Date
     * @return Fecha en Timestamp
     */
    public static Date convertDateToGregorianCalendar(Date date) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);

        return cal.getTime();
    }
   
    /**
     * Convierte una fecha de tipo Date a un Date de GregorianCalendar
     *
     * @param date Fecha en tipo Date
     * @return Fecha en Timestamp
     */
    public static Calendar dateToGregorianCalendar(Date date) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);

        return cal;
    }
    /**
     * Convierte una fecha de tipo String que se encuentra en orden YYYYMMDD
     * a una fecha de tipo Date
     *
     * @param date Fecha en tipo string
     * @param delimitador String que delimita la division de la fecha puede ser -,/,. etc.
     * ejemplo :  2007-05-15, 2007/02/23
     * @return Fecha en tipo Date
     */
    public static Date stringYYYYMMDDToDate(String date, String delimitador) {
        int day = 0;
        int month = 0;
        int year = 0;
        String[] fecha1 = date.split(" ");

        if (fecha1[0].matches("(?i).*/.*(?i)")) {
            delimitador = "/";
        }
        else if (fecha1[0].matches("(?i).*-.*(?i)")) {
            delimitador = "-";
        }

        String[] fecha = fecha1[0].split(delimitador);

        try {
            if ((fecha != null) && (fecha.length > 1)) {
                year = Integer.parseInt(fecha[0]);
                month = Integer.parseInt(fecha[1]);
                month = month - 1;
                day = Integer.parseInt(fecha[2]);
            }
        }
        catch (Exception e) {
            day = 0;
            month = 0;
            year = 0;
        }

        Calendar cDate1 = new GregorianCalendar(year, month, day);

        return cDate1.getTime();
    }

    /**
     * Obtiene la diferencia en long de dos fechas
     *
     * @param cDate1 Fecha
     * @param cDate2 Fecha
     * @return long
     */
    public static long getDiff(Calendar cDate1, Calendar cDate2) {
        long difDateinMil = 0;

        if (cDate1.after(cDate2)) {
            difDateinMil = cDate1.getTimeInMillis() - cDate2.getTimeInMillis();
        }
        else {
            difDateinMil = cDate2.getTimeInMillis() - cDate1.getTimeInMillis();
        }

        return difDateinMil;
    }

    /**
     * Obtiene la diferencia en dias entre dos fechas
     *
     * @param date1 Fecha
     * @param date2 Fecha
     *
     * @return long dias
     */
    public static long getDaysDiffBetweenDates(Date date1, Date date2) {
        java.util.GregorianCalendar cal1 = new java.util.GregorianCalendar();
        cal1.setTime(date1);

        java.util.GregorianCalendar cal2 = new java.util.GregorianCalendar();
        cal2.setTime(date2);

        long difms = cal2.getTimeInMillis() - cal1.getTimeInMillis();
        long difd = difms / (1000 * 60 * 60 * 24);

        return difd;
    }
    
    /**
     * Obtiene la diferencia en minutos entre dos fechas
     *
     * @param date1 Fecha
     * @param date2 Fecha
     *
     * @return long dias
     */
    public static long getMinutesDiffBetweenDates(Date date1, Date date2) {
        java.util.GregorianCalendar cal1 = new java.util.GregorianCalendar();
        cal1.setTime(date1);

        java.util.GregorianCalendar cal2 = new java.util.GregorianCalendar();
        cal2.setTime(date2);

        long difms = cal2.getTimeInMillis() - cal1.getTimeInMillis();
        long difd = difms / (1000 * 60);

        return difd;
    }
    
    /**
     * Obtiene una fecha de tipo Date a partir de una fecha de tipo String que se encuentra
     * en formato ddMMyy o formato dd-MM-yy segun se especifique en uno de los parametros recibidos.
     * @param strFecha.- Fecha en formato ddMMyy o dd-MM-yy (Ejemplo.- 251207, 25-12-07)
     * @param formatoFecha.- Se refiere al formato en el que se encuantra el parametro strFecha
     * 						 (Ejemplo.- ddMMyy, dd-MM-yy)
     * 
     * Ejemplo:
     * 		Entrada : 251207,  25-12-07
     * 		Salida  : Tue Dec 25 00:00:00 CST 2007,  Tue Dec 25 00:00:00 CST 2007 
     */
    public static Date stringddMMyyToDate(String strFecha, String formatoFecha) {
    	SimpleDateFormat formatoDelTexto = new SimpleDateFormat(formatoFecha);
		Date fecha = null;
		try {
			fecha = formatoDelTexto.parse(strFecha);
		} catch (ParseException ex) { ex.printStackTrace(); }

		return fecha;
    }

    /**
     * Obtiene un fecha en formato DDMMM a partir de una fecha en formato
     * YYYYMMDD ejemplo : 2007/12/30 --> 12-Dic
     *
     * @param date Fecha en String
     * @param delimitador Delimitador de la fecha
     *
     * @return fecha formateada
     */
    public static String stringYYYYMMDDToDDMMM(String date, String delimitador) {
        Date dat = stringYYYYMMDDToDate(date, delimitador);

        java.text.SimpleDateFormat sdfDay =
            new java.text.SimpleDateFormat("dd", Locale.getDefault());
        java.text.SimpleDateFormat sdfMonth =
            new java.text.SimpleDateFormat("MMM", Locale.getDefault());

        String dateStr =
            sdfDay.format(dat).concat("-").concat(
                    capitalizeFirst(sdfMonth.format(dat)));

        return dateStr;
    }

    /**
     * Obtiene un fecha en formato DDMMMYYYY a partir de una fecha en formato
     * YYYYMMDD ejemplo : 2007/12/30 --> 12-Dic-2007
     *
     * @param date Fecha en String
     * @param delimitador Delimitador de la fecha
     *
     * @return fecha formateada
     */
    public static String stringYYYYMMDDToDDMMMYYYY(String date,
        String delimitador) {
        Date dat = stringYYYYMMDDToDate(date, delimitador);

        java.text.SimpleDateFormat sdfDay =
            new java.text.SimpleDateFormat("dd", Locale.getDefault());
        java.text.SimpleDateFormat sdfMonth =
            new java.text.SimpleDateFormat("MMM", Locale.getDefault());
        java.text.SimpleDateFormat sdfYear =
            new java.text.SimpleDateFormat("yyyy", Locale.getDefault());

        String dateStr =
            sdfDay.format(dat).concat("-").concat(
                    capitalizeFirst(sdfMonth.format(dat))).concat("-").concat(
                    sdfYear.format(dat));

        return dateStr;
    }

    /**
     * Convierte la primera letra de una cadena a mayusculas
     *
     * @param str Cadena
     *
     * @return Cadena formateada
     */
    public static String capitalizeFirst(String str) {
        String retval = str;
        String firstChar = retval.substring(0, 1);
        firstChar = firstChar.toUpperCase();
        retval = firstChar + retval.substring(1);

        return retval;
    }

    /**
     * Convierte una cadena que contiene una fecha con hora a un objeto
     * Date con la misma hora especificada en la cadena.
     *
     * @param date Fecha con hora
     * @param delimitador Delimitador de la fecha
     *
     * @return Date
     */
    public static Date stringToDateTime(String date, String delimitador) {
        Date dat = stringToDate(date, delimitador);

        java.text.SimpleDateFormat sdf =
            new java.text.SimpleDateFormat(
                    "dd" + delimitador + "MM" + delimitador + "yyyy",
                    Locale.getDefault());

        String date2 = sdf.format(dat);

        Calendar cDate1 =
            new GregorianCalendar(
                getYearOfIntValue(date2, delimitador),
                getMonthOfIntValue(date2, delimitador)-1,
                getDayOfIntValue(date2, delimitador),
                getHourOfIntValue(date),
                getMinOfIntValue(date),
                getSecOfIntValue(date));

        return cDate1.getTime();
    }

    /**
     * Obtiene la hora de una fecha que tiene especificado un time
     *
     * @param date Fecha
     *
     * @return int hour
     */
    public static int getHourOfIntValue(String date) {
        String[] fecha = date.split(" ");
        String[] time = null;
        int hour = 0;

        try {
            if (fecha.length > 1) {
                time = fecha[1].split(":");

                hour = Integer.parseInt(time[0]);
            }
        }
        catch (Exception e) {
            hour = 0;
        }

        return hour;
    }

    /**
     * Obtiene los minutos de una fecha que tiene especificado un time
     *
     * @param date Fecha
     *
     * @return int min
     */
    public static int getMinOfIntValue(String date) {
        String[] fecha = date.split(" ");
        String[] time = null;
        int min = 0;

        try {
            if (fecha.length > 1) {
                time = fecha[1].split(":");

                min = Integer.parseInt(time[1]);
            }
        }
        catch (Exception e) {
            min = 0;
        }

        return min;
    }

    /**
     * Obtiene los segundos de una fecha que tiene especificado un time
     *
     * @param date Fecha
     *
     * @return int sec
     */
    public static int getSecOfIntValue(String date) {
        String[] fecha = date.split(" ");
        String[] time = null;
        int sec = 0;

        try {
            if (fecha.length > 1) {
                time = fecha[1].split(":");

                if (time[2] != null) {
                    time = time[2].split("\\.");
                    sec = Integer.parseInt(time[0]);
                }

                //year = new Integer(  fecha[fecha.length-1]).intValue();
            }
        }
        catch (Exception e) {
            sec = 0;
        }

        return sec;
    }

    /**
     * Obtiene los nanosegundos de una fecha que tiene especificado un time
     *
     * @param date Fecha
     *
     * @return int nano
     */
    public static int getNanoOfIntValue(String date) {
        String[] fecha = date.split(" ");
        String[] time = null;
        int nano = 0;

        try {
            if (fecha.length > 1) {
                time = fecha[1].split(":");

                if (time[2] != null) {
                    time = time[2].split("\\.");
                    nano = Integer.parseInt(time[1]);
                }

                //year = new Integer(  fecha[fecha.length-1]).intValue();
            }
        }
        catch (Exception e) {
            nano = 0;
        }

        return nano;
    }
    /**
     * Obtiene la fecha Actual en Formato Completo
     * @return fechaActualCadena <code>String</code>
     */
    public static String getCurrentDateCadena() {
    	 if (fechaActualCadena == null || "".equals(fechaActualCadena)) {
    		 fechaActualCadena = obtenerFechaCadena(
    				 				dateToString(
    				 						getCurrentDate(),
    				 						"dd/MM/yyyy"), "/");
    	 }
    	 return fechaActualCadena;
    }
    /**
     *	Este método obtiene la fecha actual en formato "Lunes 12 de Enero de 2004"
     * @param date Fecha en formato cadena
     * @param delimitador delimitador de la cadena para parsearla.
     * @return Fecha en formato Cadena
     */
    public static String obtenerFechaCadena(String date, String delimitador) {
    	
      int mes = getMonthOfIntValue(date, delimitador)-1;
      int dia = getDayOfIntValue(date, delimitador);
      int anioF = getYearOfIntValue(date, delimitador);
      
      String mesF = null;
      @SuppressWarnings("unused")
	String diaF = null;
      
      switch (dia) {
        case 1:
        	diaF = "Domingo";
          break;
        case 2:
        	diaF = "Lunes";
          break;
        case 3:
        	diaF = "Martes";
          break;
        case 4:
        	diaF = "Miercoles";
          break;
        case 5:
        	diaF = "Jueves";
          break;
        case 6:
        	diaF = "Viernes";
          break;
        default:
        	diaF = "Sabado";
          break;
      }
      switch (mes) {
        case 0:
        	mesF = "Enero";
          break;
        case 1:
        	mesF = "Febrero";
          break;
        case 2:
        	mesF = "Marzo";
          break;
        case 3:
        	mesF = "Abril";
          break;
        case 4:
        	mesF = "Mayo";
          break;
        case 5:
        	mesF = "Junio";
          break;
        case 6:
        	mesF = "Julio";
          break;
        case 7:
        	mesF = "Agosto";
          break;
        case 8:
        	mesF = "Septiembre";
          break;
        case 9:
        	mesF = "Octubre";
          break;
        case 10:
        	mesF = "Noviembre";
          break;
        default:
        	mesF = "Diciembre";
          break;
      }
      //return diaF + " " + dia + " de " + mesF + " de " + anioF;
      return dia + " de " + mesF + " de " + anioF;
    }
        
    /**
     * Obtiene la diferencia en años de dos fechas
     *
     * @param cDate1 Fecha
     * @param cDate2 Fecha
     * @return long
     */
    public static long getYearsDiff(Date date1, Date date2) {
    	int anios1 = Integer.valueOf(FechasUtilsBO.dateToString(date1, "yyyy"));
    	int anios2 = Integer.valueOf(FechasUtilsBO.dateToString(date2, "yyyy"));
    	
        int dias1 = Integer.valueOf(FechasUtilsBO.dateToString(date1, "dd"));
    	int dias2 = Integer.valueOf(FechasUtilsBO.dateToString(date2, "dd"));
    	
    	int meses1 = Integer.valueOf(FechasUtilsBO.dateToString(date1, "MM"));
    	int meses2 = Integer.valueOf(FechasUtilsBO.dateToString(date2, "MM"));
    	
    	Long diffYears = new Long(0);
    	if(anios1>anios2){
    	  diffYears = new Long(anios1 - anios2);
    	  if((meses1 < meses2)||((dias1 < dias2)&&(meses1==meses2)))    		
    			   diffYears--;    	    
    	}else{   		  
    		diffYears = new Long(anios2 - anios1);
    		if((meses2 < meses1)||((dias2 < dias1)&&(meses1==meses2)))    		
 			    diffYears--;
    	}
    	
    	return diffYears; 
    }
    
    
    public static Date stringToDateHour(String fecha, String formato) {
    	SimpleDateFormat sdf = new SimpleDateFormat(formato);
    	
    	if(fecha.length()<12){
    		fecha = fecha + " 00:00:00";
    	}
		try {
			return sdf.parse(fecha);
		} catch (ParseException e) {
			return null;
		}
    }
    
    public static Date convertObjectToDate(Object obj) {

    	if ( obj != null ) {
    		//String strFecha = UtilFormatValues.convertObjectToString(obj);
    		//return stringToDate(stringYYYYMMDDToDDMMMYYYY(strFecha,"-"), "-");
    		return (Date) obj;
    	}
    	
    	return null;
    }
    
    public static Integer getDayOfTheWeek(Integer daysToAdd){
    	Calendar calendar = Calendar.getInstance();
    	
		calendar.add(Calendar.DAY_OF_WEEK, daysToAdd.intValue());		
		
		return calendar.get(Calendar.DAY_OF_WEEK);
    }
    
    public static Date addWorkDays(Date date, Integer days){
    	    	    	
    	Calendar calendar = Calendar.getInstance();
    	
    	calendar.setTime(date);
    	for(int i=0; i<days.intValue(); ){
    		calendar.add(Calendar.DAY_OF_WEEK, 1);    		
    		if(calendar.get(Calendar.DAY_OF_WEEK)!=Calendar.SATURDAY && calendar.get(Calendar.DAY_OF_WEEK)!=Calendar.SUNDAY){
    			i++;
    		}
    	}
    	
		return calendar.getTime();
    }
    
    /**
     * Método que regresa el mes de una fecha especifica
     * @return int Mes Buscado
     */
    public static int getMonthFromDate(Date date) {
    	Calendar calendar=Calendar.getInstance();
    	calendar.setTime(date);
    	int month=0;
    	 
    	//try{
    	  month=calendar.get(Calendar.MONTH);
    	  // agregado por omar
    	  month = month + ( calendar.get( Calendar.YEAR ) * 100 ) ;
    	  ///////////
    	//} catch(Exception ex){
    		//month=FechasUtilsBO.getCurrentMonth();
    	//}
    	
    	return month;
    }
    
    public static String invertDate(String fecha){
    	String[] fechaTmp= fecha.split(" ");
		String[] soloFecha = fechaTmp[0].split("/");
		String fechaNueva = fecha;
		if(fechaTmp.length<2){
			fechaNueva = soloFecha[2]+"-"+soloFecha[1]+"-"+soloFecha[0];			
		}else{
			if(soloFecha.length>=3)
				fechaNueva = soloFecha[2]+"-"+soloFecha[1]+"-"+soloFecha[0]+" "+fechaTmp[1];
		}
		return fechaNueva;
    }
    /**
     * Convierte una fecha en formato dd/MM/yyyy a forato yyyy-MM-dd .
     *
     * @param stringData Cadena con la fecha en formato dd/MM/yyyy
     * @return Fecha en tipo String con formato yyyy-MM-dd 
     */
    public  static String convertStringToData(String stringData){

	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd");
	    Date data;
	    String formattedTime = null;
		try {
			data = sdf.parse(stringData);
		    formattedTime = output.format(data);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return formattedTime;
	}
    
    
    public static Date getFechaFinMes(Date fecha){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha); // Configuramos la fecha que se recibe
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH)); 
        return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos

 }
    
    public static Date getFechaInicioMes(Date fecha){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha); // Configuramos la fecha que se recibe
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum( Calendar.DAY_OF_MONTH)); 
        return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos

 }
    
    public static String convertMMYYtoddMMYY(String fecha, String formato){
    	// input format: MM/yy
    	SimpleDateFormat parser = new SimpleDateFormat("MM/yy");
    	// output format: yyyy-MM-dd
    	SimpleDateFormat formatter = new SimpleDateFormat(formato);
    	String fechaFormateada = null;
    	try {
    		fechaFormateada=formatter.format(parser.parse(fecha));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 2017-11-01
		return fechaFormateada;
    }
    
    /**
     * DOCUMENT ME!
     *
     * @param args DOCUMENT ME!
     */
    public static void main(String[] args) {
    	
		String fecha = "2017-12-01";
		String fecha2 = "2017-12-21";
		
		System.out.println(stringYYYYMMDDToDate(fecha,"-"));
		System.out.println(stringYYYYMMDDToDate(fecha2,"-"));
		 
//		System.out.println(dateToString(addDaysToDate(getCurrentDate(),7),"yyyy-MM-dd"));
//		System.out.println(convertMMYYtoddMMYY(fecha));

		//Date f = stringToDateHour(fecha, "dd/MM/yyyy HH:mm:ss");
		//Date f2  = stringToDateHour(fecha2, "dd/MM/yyyy HH:mm:ss");
		
		//System.out.println(f.before(f2));
		
		//System.out.println(invertDate(fecha));
        
    }
        
}
