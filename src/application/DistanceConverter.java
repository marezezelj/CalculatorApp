package application;

public class DistanceConverter implements Converter {

	public double convert(String fromUnit, String toUnit, Double startV) {
		double meterLength = 0.0;
		double finalLength = 0.0;

		meterLength = convertToBase(startV, fromUnit);
		finalLength = convertToUnit(meterLength, toUnit);

		return finalLength;
	}

	private double convertToUnit(double meterLength, String toUnit2) {
		double res = 0.0;
		switch (toUnit2) {
		case "km":
			res = meterLength / 1000;
			break;
		case "m":
			res = meterLength;
			break;
		case "cm":
			res = meterLength * 100;
			break;
		case "mm":
			res = meterLength * 1000;
			break;
		case "in":
			res = meterLength * 39.370;
			break;
		case "ft":
			res = meterLength * 3.280839;
			break;
		case "mi":
			res = meterLength / 1609.34;
			break;
		case "yd":
			res = meterLength * 1.094;
			break;
		}
		return res;
	}

	private double convertToBase(double val, String fromUnit2) {
		double convertedVal = 0.0;
		switch (fromUnit2) {
		case "km":
			convertedVal = val * 1000;
			break;
		case "m":
			convertedVal = val;
			break;
		case "cm":
			convertedVal = val / 100;
			break;
		case "mm":
			convertedVal = val / 1000;
			break;
		case "in":
			convertedVal = val / 39.370;
			break;
		case "ft":
			convertedVal = val / 3.280839;
			break;
		case "mi":
			convertedVal = val * 1609.34;
			break;
		case "yd":
			convertedVal = val / 1.094;
			break;
		}

		return convertedVal;
	}

}
