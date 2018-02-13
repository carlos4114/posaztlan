package mx.com.tecnetia.muvitul.servicios.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DateToTimeSerializer extends JsonSerializer<Date> {

	@Override
	public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
        if (value != null) {        
            SimpleDateFormat sdf = new SimpleDateFormat(Constantes.HH_MM_SS);
            String formatted = sdf.format(value);
            gen.writeString(formatted);
        }
	}

}
