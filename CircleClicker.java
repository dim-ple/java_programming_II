// Program created by: Harrison Goehring
// Date Created: March 30th, 2023

// This program that displays a circle of 10 pixels filled with a random color at a random location on a pane,
// When you click the circle, it disappears and a new random-color circle is displayed at another random location. 
// After 20 circles are clicked, the program will display the time spent in the program

import javafx.application.Application;
import javafx.scene.Scene; 
import javafx.scene.layout.Pane;
import javafx.stage.Stage; 

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;

import javafx.event.EventHandler;


public class CircleClicker extends Application {
	public void start(Stage primaryStage) {
		
		int clickerCounter = 0;
		
		Pane pane = new Pane();
		
		Circle circle = new Circle(randomCoordinate(), randomCoordinate(), 10);
		circle.setFill(Color.color(Math.random(), Math.random(), Math.random()));
		
		pane.getChildren().add(circle);
		
		circle.setOnMouseClicked(e -> {
			if (circle.contains(e.getX(), e.getY())) {
				pane.getChildren().clear();
				circle.setCenterX(randomCoordinate());
				circle.setCenterY(randomCoordinate());
				circle.setFill(Color.color(Math.random(), Math.random(), Math.random()));
				pane.getChildren().add(circle);
			}
		});
		
		Scene scene = new Scene(pane, 300, 300);
		primaryStage.setTitle("Circle Clicker");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		
		launch(args);

	}
	
	private static int randomCoordinate() {
		
		return (int)Math.floor(Math.random() * (300 - 1 + 1));
		
	}
	
}