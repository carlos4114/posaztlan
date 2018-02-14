package mx.com.aztlan.pos.servicios.util;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class TimeToDateDeserializer extends JsonDeserializer<Date>  {

	@Override
	public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
	            String date = p.getValueAsString();
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

}
