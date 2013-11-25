package com.ly.common;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

/**
 * @author xubch@neusoft.com
 * 
 */
public class CustomTimestampSerializer extends JsonSerializer<Timestamp> {


	@Override
	public void serialize(Timestamp value, JsonGenerator jg,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = formatter.format(value);
		jg.writeString(formattedDate);
	}
}