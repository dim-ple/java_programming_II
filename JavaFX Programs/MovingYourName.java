// Program created by: Harrison Goehring
// Date Created: April 6th, 2023

// This program that displays my name as text. My name will move left to right circularly and, if it were to reach the far end of 
// or window, it would continue scrolling on the opposite side.

// Imports our JavaFX tools to create our Application window, scene and pane
import javafx.application.Application;
import javafx.scene.Scene; 
import javafx.scene.layout.Pane;
import javafx.stage.Stage; 

// Imports our JavaFX tool to display our completion time message to the application window
import javafx.scene.text.Text;
import javafx.scene.shape.Line;


import javafx.animation.PathTransition;
import javafx.animation.Timeline;

import javafx.util.Duration; // Imports our duration



public class MovingYourName extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		Pane pane = new Pane(); // Creates a new pane to paint our name to.
		
		Text text = new Text(150, 150, "Harrison Goehring"); // Creates our text object which we will paint on our pane
		pane.getChildren().addAll(text);
		
		
		PathTransition pt = new PathTransition(Duration.millis(8000), new Line(-150, 150, 350, 150), text);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.play();
		
		Scene scene = new Scene(pane, 300, 300); // Adds our pane to the application window and sets the width and height of the window.
		
		primaryStage.setTitle("Circle Clicker"); // Set's our stage/window title
		primaryStage.setScene(scene); // Set's out scene into the window
		primaryStage.setResizable(false); // Set's our window so it is not re-sizeable by the user.
		primaryStage.show(); // Displays our stage in an application window
		
	}
	
	public static void main(String[] args) {
		
		launch(args);
		
	}

}
