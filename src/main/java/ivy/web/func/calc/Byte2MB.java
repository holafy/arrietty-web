package ivy.web.func.calc;

import java.math.BigDecimal;

public class Byte2MB {

	public double calc(Object value) {
		Double sourceValue = null;
		if (value instanceof Double) {
			sourceValue = (Double) value;
		} else if (value.getClass().isPrimitive()) {
			sourceValue = (Double) value;
		} else if (value instanceof String) {
			try {
				sourceValue = Double.valueOf(value.toString());
			} catch (NumberFormatException e) {
				return 0f;
			}
		} else {
			return 0f;
		}
		double size = sourceValue / 1024.0 / 1024.0;
		BigDecimal decimal = new BigDecimal(size);
		BigDecimal formatDoubleValue = decimal.setScale(2,
				BigDecimal.ROUND_HALF_UP);
		size = formatDoubleValue.doubleValue();
		return size;
	}
}
