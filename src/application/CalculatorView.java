package application;

import java.util.ArrayList;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class CalculatorView {
	private ArrayList<Button> lista = new ArrayList<>();

	public Parent getView() {
		TextField textField = new TextField();
		textField.setFont(Font.font("Segoe UI", 20));
		textField.setMinSize(334, 100);
		textField.setMaxSize(334, 100);
		Button equal = new Button("=");
		Button minus = new Button("-");
		Button mul = new Button("*");
		Button div = new Button("/");
		Button plus = new Button("+");
		Button clear = new Button("C");
		Button remove = new Button("<-");
		Button percentage = new Button("%");
		Button dec = new Button(".");
		Button sqrt = new Button("\u221A");

		setSize(minus, 125, 70);
		setSize(mul, 125, 70);
		setSize(div, 125, 70);
		setSize(equal, 125, 70);
		setSize(plus, 125, 70);
		setSize(clear, 70, 70);
		setSize(remove, 70, 70);
		setSize(percentage, 70, 70);
		setSize(dec, 70, 70);
		setSize(sqrt, 70, 70);

		plus.setOnAction((event) -> {
			if (textField.getText().split("\\ +").length == 2) {
				equal.fire();
			}
			textField.appendText(" +");

		});

		div.setOnAction((event) -> {
			if (textField.getText().split("\\ /").length == 2) {
				equal.fire();
			}
			textField.appendText(" /");
		});

		mul.setOnAction((event) -> {
			if (textField.getText().split("\\*").length >= 2) {
				equal.fire();
			}
			textField.appendText("*");
		});

		equal.setOnAction((event) -> {
			try {
				Double sum = 0.0;
				String text = textField.getText();
				if (text.contains("*")) {
					String[] niz = text.split("\\*");
					for (int i = 0; i < niz.length; i++) {
						System.out.println(i + ":" + niz[i]);
					}
					sum = Double.valueOf(niz[0]) * Double.valueOf(niz[1]);
				} else if (text.contains("+")) {
					String[] niz = text.split(" +");
					sum = Double.valueOf(niz[0]) + Double.valueOf(niz[1]);
				} else if (text.contains("-")) {
					String[] niz = text.split(" -");
					sum = Double.valueOf(niz[0]) - Double.valueOf(niz[1]);
				} else if (text.contains("/")) {
					String[] niz = text.split("\\ /");
					if (niz[1].equals("0")) {
						textField.setText("ERROR: Divide by zero!");
						return;
					} else {
						Double d = Double.valueOf(niz[0]) / Double.valueOf(niz[1]);
						textField.setText(Double.toString(d));
						return;
					}
				} else if (text.contains("%")) {
					String[] niz = text.split("\\ %");
					double per = Double.valueOf(niz[0]) / 100.0;
					double val = per * Double.valueOf(niz[1]);
					textField.setText(Double.toString(val));
					return;
				} else {
					double res = Math.sqrt(Double.valueOf(textField.getText()));
					textField.setText(Double.toString(res));
					return;
				}
				textField.clear();
				textField.setText("" + sum);
			} catch (Exception e) {
				textField.setText("Invalid input");
			}
		});

		clear.setOnAction((event) ->

		{
			textField.clear();
		});

		remove.setOnAction((event) -> {
			if (textField.getText().length() > 0) {
				textField.setText(textField.getText(0, textField.getLength() - 1));
			}

		});

		minus.setOnAction((event) -> {
			if (textField.getText().split("\\ -").length == 2) {
				equal.fire();
			}
			textField.appendText(" -");
		});

		percentage.setOnAction((event) -> {
			if (textField.getText().split("\\ %").length == 2) {
				equal.fire();
			}

			textField.appendText(" %");
		});

		sqrt.setOnAction((event) -> {
			try {
				if (textField.getText().split(" sqrt").length == 1) {
					equal.fire();
				}
			} catch (Exception e) {
				textField.setText("Input number!");
			}

		});

		dec.setOnAction((event) -> {
			textField.appendText(".");
		});

		for (int i = 0; i <= 9; i++) {
			Button btn = new Button();
			btn.setText(Integer.toString(i));
			btn.setMinSize(70, 70);
			btn.setMaxSize(70, 70);

			btn.setOnAction((event) -> {
				textField.appendText(btn.getText());
			});
			lista.add(btn);

		}

		GridPane grid = new GridPane();
		grid.add(lista.get(0), 1, 4);
		grid.add(lista.get(1), 0, 3);
		grid.add(lista.get(2), 1, 3);
		grid.add(lista.get(3), 2, 3);
		grid.add(lista.get(4), 0, 2);
		grid.add(lista.get(5), 1, 2);
		grid.add(lista.get(6), 2, 2);
		grid.add(lista.get(7), 0, 1);
		grid.add(lista.get(8), 1, 1);
		grid.add(lista.get(9), 2, 1);
		grid.add(equal, 3, 4);
		grid.add(plus, 3, 3);
		grid.add(minus, 3, 2);
		grid.add(mul, 3, 1);
		grid.add(clear, 0, 0);
		grid.add(remove, 1, 0);
		grid.add(percentage, 2, 0);
		grid.add(div, 3, 0);
		grid.add(dec, 2, 4);
		grid.add(sqrt, 0, 4);

		BorderPane bp = new BorderPane();
		bp.setBottom(grid);
		bp.setTop(textField);

		return bp;
	}

	private void setSize(Button btn, int x, int y) {
		btn.setMinSize(x, y);
		btn.setMaxSize(x, y);
	}

}
