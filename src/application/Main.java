package application;

//import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
//import javafx.scene.text.Font;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		CalculatorView calcView = new CalculatorView();
		ConverterView convView = new ConverterView();
		
		BorderPane bp=new BorderPane();
        
        HBox menu=new HBox();
        menu.setPadding(new Insets(10, 10, 10, 10));
        menu.setSpacing(10);
        
        Button calc = new Button("Calculator");
        Button conv = new Button("Unit converter");
        
        calc.setOnAction((event)->{
        	bp.setCenter(calcView.getView());
        	primaryStage.setHeight(540);
        });
        conv.setOnAction((event)->{
        	bp.setCenter(convView.getView());
        	primaryStage.setHeight(300);
        });
        
        menu.getChildren().addAll(calc,conv);
        bp.setTop(menu);
        bp.setCenter(calcView.getView());

		Scene scena = new Scene(bp);
		primaryStage.setScene(scena);
		primaryStage.setHeight(540);
		primaryStage.setWidth(350);
		primaryStage.setTitle("Calculator by Dolph Inc.");
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
