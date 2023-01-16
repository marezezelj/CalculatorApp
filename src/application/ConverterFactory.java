package application;

public class ConverterFactory {
	public Converter createConverter(String type) {
		if (type==null || type.isEmpty()) {
			return null;
		}
		switch(type) {
		case "Mass":
			return new MassConverter();
		case "Volume":
			return new VolumeConvertor();
		case "Length":
			return new DistanceConverter();
		default:
			throw new IllegalArgumentException("Unknown type: "+ type);
		}
	}
}
