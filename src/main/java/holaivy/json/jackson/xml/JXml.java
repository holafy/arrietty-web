package holaivy.json.jackson.xml;

import ivy.basic.ViException;

import java.io.File;
import java.io.Writer;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.fasterxml.jackson.xml.XmlMapper;

public class JXml {

	public static final XmlMapper xml = new XmlMapper();
	static {
		xml.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,
				false);
		xml.setSerializationInclusion(Inclusion.NON_NULL);
	}

	public JXml() {
		super();
	}

	public static <T> T decode(String r, Class<T> valueType) throws ViException {
		try {
			return xml.readValue(r, valueType);
		} catch (Exception e) {
			throw new ViException(e.getMessage());
		}
	}

	public static <T> T decode(JsonNode r, Class<T> valueType)
			throws ViException {
		try {
			return xml.readValue(r, valueType);
		} catch (Exception e) {
			throw new ViException(e.getMessage());
		}
	}

	public static <T> T decode(File file, Class<T> valueType)
			throws ViException {
		try {
			return xml.readValue(file, valueType);
		} catch (Exception e) {
			throw new ViException(e.getMessage());
		}
	}

	public static String encode(Object value) throws ViException {
		try {
			return xml.writeValueAsString(value);
		} catch (Exception e) {
			throw new ViException(e.getMessage());
		}
	}

	public static void encode(Writer out, Object value) throws ViException {
		try {
			xml.writeValue(out, value);
		} catch (Exception e) {
			throw new ViException(e.getMessage());
		}
	}

	public static void encode(File out, Object value) throws ViException {
		try {
			xml.writeValue(out, value);
		} catch (Exception e) {
			throw new ViException(e.getMessage());
		}
	}

}
