package mx.com.tecnetia.muvitul.servicios.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DateToDateStringSerializer extends JsonSerializer<Date> {

	@Override
	public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		try {
	        if (value != null) {        
	            SimpleDateFormat sdf = new SimpleDateFormat(Constantes.FORMAT_DD_MM_YYYY_HH_MM_SS);
	            String formatted = sdf.format(value);
	            gen.writeString(formatted);
	        }
	        
		} catch (Exception e) {
		 	e.printStackTrace();
		}

	}

}
