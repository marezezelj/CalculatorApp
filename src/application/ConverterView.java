package application;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class ConverterView {
	String[] types = {"Volume", "Length", "Mass"};
	String[] massTypes = {"mg", "g", "kg", "t", "lb", "oz"};
	String[] lengthTypes = {"mm", "cm", "m", "km", "in", "ft", "mi", "yd"};
	String[] volumeTypes = {"mm\u00b3", "cm\u00b3",  "dm\u00b3", "m\u00b3", "ft\u00b3", "l", "gal"};
	
	private String fromUnit;
	private String toUnit;
	private String fromVal;
	

	public Parent getView() {
		BorderPane bp = new BorderPane();
		Label lab= new Label("Welcome!");
		lab.setPadding(new Insets(0,0,0,10));
		bp.setTop(lab);
		
		Label info= new Label("Conversion Type: ");
		Label info2= new Label("Convert: ");
		Label info3 = new Label("Into: ");
		Label info4 = new Label("Converted value: ");
		Label convValue = new Label("");
		Button convert = new Button("Convert");
		
		TextField tx1=new TextField();
		ComboBox<String> comboMain=new ComboBox<>(FXCollections.observableArrayList(types));
		ComboBox<String> firstUnit = new ComboBox<>();
		ComboBox<String> secondUnit = new ComboBox<>();
		
		GridPane gp = new GridPane();
		gp.setPadding(new Insets(10,10,0,10));
		gp.setVgap(10);
		gp.add(info, 0, 0);
		gp.add(comboMain, 1,0);
		gp.add(tx1, 1, 1);
		gp.add(firstUnit, 2, 1);
		gp.add(info2, 0, 1);
		gp.add(info3, 0, 2);
		gp.add(secondUnit, 1, 2);
		gp.add(info4, 0, 3);
		gp.add(convValue, 1, 3);
		gp.add(convert, 1,4);
		
		comboMain.setOnAction((event)->{
			if(comboMain.getSelectionModel().getSelectedItem().equals("Mass")) {
				firstUnit.setItems(FXCollections.observableArrayList(massTypes));
				secondUnit.setItems(FXCollections.observableArrayList(massTypes));
			} else if(comboMain.getSelectionModel().getSelectedItem().equals("Length")) {
				firstUnit.setItems(FXCollections.observableArrayList(lengthTypes));
				secondUnit.setItems(FXCollections.observableArrayList(lengthTypes));
			} else if(comboMain.getSelectionModel().getSelectedItem().equals("Volume")) {
				firstUnit.setItems(FXCollections.observableArrayList(volumeTypes));
				secondUnit.setItems(FXCollections.observableArrayList(volumeTypes));
			}
		});
		
		convert.setOnAction((event)->{
			Double value=0.0;
			try {
				value=Double.valueOf(tx1.getText());
				Double newValue=0.0;
				fromUnit=firstUnit.getSelectionModel().getSelectedItem();
				toUnit=secondUnit.getSelectionModel().getSelectedItem();
				fromVal=tx1.getText();
				
				/*if(comboMain.getSelectionModel().getSelectedItem().equals("Mass")) {
					MassConverter mc=new MassConverter();
					newValue=mc.convert(fromUnit, toUnit, value);
				} else if(comboMain.getSelectionModel().getSelectedItem().equals("Length")) {
					DistanceConverter dc=new DistanceConverter();
					newValue=dc.convert(fromUnit, toUnit, value);
				} else if(comboMain.getSelectionModel().getSelectedItem().equals("Volume")) {
					VolumeConvertor vc=new VolumeConvertor();
					newValue=vc.convert(fromUnit, toUnit, value);
				}*/
				
				ConverterFactory factory=new ConverterFactory();
				Converter conv=factory.createConverter(comboMain.getSelectionModel().getSelectedItem());
				newValue=conv.convert(fromUnit, toUnit, value);
				
				convValue.setText(Double.toString(newValue)+ " " + secondUnit.getSelectionModel().getSelectedItem());
			} catch (Exception e) {
				convValue.setText("Input Error");
			}
			
			
			
		});
		
		bp.setCenter(gp);
		
		return bp;
	}
}
