// Program created by: Harrison Goehring
// Date Created: March 30th, 2023

// This program uses the JavaFX library to create a Smiley Face in an application window.

import javafx.collections.ObservableList;
import javafx.application.Application;
import javafx.scene.Scene; 
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage; 


public class SmileyFaceApp extends Application {
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		
				
		Circle face = new Circle();
		face.setRadius(100);
		face.setStroke(Color.BLACK);
		face.setFill(Color.WHITE);
		face.setCenterX(200);
	    face.setCenterY(200);
				
		Arc smile = new Arc(200, 115, 150, 150, 30 + 220, 40);
	    smile.setFill(Color.WHITE);
	    smile.setType(ArcType.OPEN);
	    smile.setStroke(Color.BLACK);
	    
	    
	    Ellipse leftSocket = new Ellipse();
	    leftSocket.setRadiusX(30);
	    leftSocket.setRadiusY(15);
	    leftSocket.setCenterX(155);
	    leftSocket.setCenterY(165);
	    leftSocket.setFill(Color.WHITE);
	    leftSocket.setStroke(Color.BLACK);
	    
	    
	    Ellipse rightSocket = new Ellipse();
	    rightSocket.setRadiusX(30);
	    rightSocket.setRadiusY(15);
	    rightSocket.setCenterX(240);
	    rightSocket.setCenterY(165);
	    rightSocket.setFill(Color.WHITE);
	    rightSocket.setStroke(Color.BLACK);
	    
	    Circle leftEye = new Circle();
	    leftEye.setRadius(10);
		leftEye.setStroke(Color.BLACK);
		leftEye.setFill(Color.BLACK);
		leftEye.setCenterX(155);
	    leftEye.setCenterY(165);
	    
	    Circle rightEye = new Circle();
	    rightEye.setRadius(10);
		rightEye.setStroke(Color.BLACK);
		rightEye.setFill(Color.BLACK);
		rightEye.setCenterX(240);
	    rightEye.setCenterY(165);
		
		
	    
	    Polygon nose = new Polygon();
	    nose.setFill(Color.WHITE);
	    nose.setStroke(Color.BLACK);
	    ObservableList<Double> list = nose.getPoints();
	    
	    //double centerX = getWidth() / 2, centerY = getHeight() / 2;
	    //double radius = Math.min(getWidth(), getHeight()) * 0.4;

	    // Add points to the polygon list
	    /*for (int i = 0; i < 3; i++) {
	      list.add(centerX + radius * Math.cos(2 * i * Math.PI / 3)); 
	      list.add(centerY - radius * Math.sin(2 * i * Math.PI / 3));
	    }*/
	    
	 
	    
	   
	    pane.getChildren().add(face);
	    pane.getChildren().add(smile);
	    pane.getChildren().add(leftSocket);
	    pane.getChildren().add(rightSocket);
	    pane.getChildren().add(leftEye);
	    pane.getChildren().add(rightEye);
	    pane.getChildren().add(nose);
	    
	    
	    Scene scene = new Scene(pane, 400, 400);
	    
	    primaryStage.setTitle("Smiley Face"); // Set's our stage/window title
		primaryStage.setScene(scene); // Set's out scene into the window
	    primaryStage.show();
	}
	
	public static void main(String[] args) {
		
		launch(args);

	}

}
