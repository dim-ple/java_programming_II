// Program created by: Harrison Goehring
// Date Created: April 1st, 2023

// This program uses the JavaFX library to create a Smiley Face in an application window.

import javafx.application.Application;
import javafx.scene.Scene; 
import javafx.scene.layout.Pane;
import javafx.stage.Stage; 

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;



public class HangManApp extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		Pane pane = new Pane();
		
		
		Circle face = new Circle();
		face.setRadius(30);
		face.setStroke(Color.BLACK);
		face.setFill(Color.WHITE);
		face.setCenterX(275);
	    face.setCenterY(100);
	    
	    Line body = new Line(275.0, 130.0, 275.0, 220.0);
	    Line rightLeg = new Line(275.0, 220.0, 325.0, 275.0);
	    Line leftLeg = new Line(275.0, 220.0, 225.0, 275.0);
	    Line rightArm = new Line(295.0, 122.0, 360.0, 185.0);
	    Line leftArm = new Line(255.0, 122.0, 180.0, 185.0);
	    
	    Line headConnection = new Line(275.0, 70.0, 275.00, 35.0);
	    Line horizontalConnection = new Line(275.0, 35.0, 125.0, 35.0);
	    Line hangPost = new Line(125.0, 35.0, 125.0, 335.0);
	    Arc hangStand = new Arc(125.0, 435.0, 75.0, 100.0, 63.0, 55.0);
	    hangStand.setType(ArcType.OPEN);
	    hangStand.setFill(Color.WHITE);
	    hangStand.setStroke(Color.BLACK);
	    
	    
	    pane.getChildren().addAll(face, body, rightLeg, leftLeg, leftArm, rightArm, headConnection, horizontalConnection, hangPost, hangStand); // Adds all of our shapes to the pane


	    Scene scene = new Scene(pane, 400, 400); // Adds our pane to the application window and sets the width and height of the window.

	    primaryStage.setTitle("Smiley Face"); // Set's our stage/window title
	    primaryStage.setScene(scene); // Set's out scene into the window
	    primaryStage.setResizable(false); // Set's our window so it is not re-sizeable by the user.
	    primaryStage.show(); 
	    
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
