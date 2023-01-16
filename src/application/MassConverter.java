package application;

public class MassConverter implements Converter{

	public double convert(String fromUnit, String toUnit, Double val) {
		double kg=0.0;
		double finalVal=0.0;
		
		kg=convertToKilogram(val, fromUnit);
		finalVal=convertToUnit(kg, toUnit);
		
		return finalVal;
	}

	private double convertToUnit(double g, String toUnit) {
		double finalVal=0.0;
		switch(toUnit) {
		case "mg":
			finalVal=g*1000000;
			break;
		case "g":
			finalVal=g*1000;
			break;
		case "kg":
			finalVal=g;
			break;
		case "t":
			finalVal=g/1000;
			break;
		case "US ton":
			finalVal=g/907.2;
			break;
		case "lb":
			finalVal=g*2.205;
			break;
		case "oz":
			finalVal=g*35.274;
			break;
		}
		
		return finalVal;
	}
	

	private double convertToKilogram(Double val, String fromUnit) {
		double kilogram=0.0;
		switch(fromUnit) {
		case "mg":
			kilogram=val/1000000;
			break;
		case "g":
			kilogram=val/1000;
			break;
		case "kg":
			kilogram=val;
			break;
		case "t":
			kilogram=val*1000;
			break;
		case "US ton":
			kilogram=val*907.2;
			break;
		case "lb":
			kilogram=val/2.205;
			break;
		case "oz":
			kilogram=val/35.274;
			break;
		}
		
		return kilogram;
	}
}
