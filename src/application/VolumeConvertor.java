package application;

public class VolumeConvertor implements Converter {

	public double convert(String fromUnit, String toUnit, Double startVal) {
		double m3 = 0.0;
		double finalVal = 0.0;

		m3 = convertToM3(startVal, fromUnit);
		finalVal = convertFinal(m3, toUnit);

		return finalVal;
	}

	private double convertFinal(double m3, String toUnit) {
		double convertedVal = 0.0;
		switch (toUnit) {
		case "mm\u00b3":
			convertedVal = m3 * 1000000000.0;
			break;
		case "cm\u00b3":
			convertedVal = m3 * 1000000.0;
			break;
		case "m\u00b3":
			convertedVal = m3;
			break;
		case "dm\u00b3":
			convertedVal = m3 * 1000.0;
			break;
		case "ft\u00b3":
			convertedVal = m3 * 35.315;
			break;
		case "l":
			convertedVal = m3 * 1000.0;
			break;
		case "gal":
			convertedVal = m3 * 264.2;
			break;
		}
		return convertedVal;
	}

	private double convertToM3(double val, String fromUnit) {
		double convertedVal = 0.0;
		switch (fromUnit) {
		case "mm\u00b3":
			convertedVal = val / 1000000000.0;
			break;
		case "cm\u00b3":
			convertedVal = val / 1000000.0;
			break;
		case "m\u00b3":
			convertedVal = val;
			break;
		case "dm\u00b3":
			convertedVal = val / 1000.0;
			break;
		case "ft\u00b3":
			convertedVal = val / 35.315;
			break;
		case "l":
			convertedVal = val / 1000.0;
			break;
		case "gal":
			convertedVal = val / 264.2;
			break;
		}
		return convertedVal;
	}
}
