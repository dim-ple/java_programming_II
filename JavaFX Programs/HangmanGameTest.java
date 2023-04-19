// Program created by: Harrison Goehring
// Date Created: April 19th, 2023

// This program 

import java.util.ArrayList;
import java.util.Arrays;

import javafx.application.Application;
import javafx.scene.Scene; 
import javafx.scene.layout.Pane;
import javafx.stage.Stage; 

import javafx.scene.control.Label;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;

public class HangmanGameTest extends Application {

	public void start(Stage primaryStage) {
		
		// Creates a String Array with our 7-letter words that we will cast to the ArrayList
		String[] array = {"Array","Java", "Extreme", "Easy", "Restart", "Boolean"};
		
		// Creates a character array that will hold all the letters of the chosen word
		
		
		// Creates an ArrayList with the contents of our array. This ArrayList contains 
		// String answers to out hangman game.
		ArrayList<String> words = new ArrayList<>(Arrays.asList(array));
		
		// Shuffles the elements in our ArrayList
		java.util.Collections.shuffle(words);
		int randIndex = (int)Math.floor(Math.random() * (6 - 0 + 1));
		String answer = words.get(randIndex);
		
		char[] letterArray = answer.toCharArray();
		
		
		Pane pane = new Pane();
		

		// This block of code defines our hangman stand
		Line headConnection = new Line(275.0, 70.0, 275.00, 35.0);
	    Line horizontalConnection = new Line(275.0, 35.0, 125.0, 35.0);
	    Line hangPost = new Line(125.0, 35.0, 125.0, 335.0);
	    Arc hangStand = new Arc(125.0, 435.0, 75.0, 100.0, 63.0, 55.0);
	    hangStand.setType(ArcType.OPEN);
	    hangStand.setFill(Color.WHITE);
	    hangStand.setStroke(Color.BLACK);
		
	    // Paints our hangman stand to the pane
	    pane.getChildren().addAll(headConnection, horizontalConnection, hangPost, hangStand);
	    
		// Defines
	    Line body = new Line(275.0, 130.0, 275.0, 220.0);
	    Line rightLeg = new Line(275.0, 220.0, 325.0, 275.0);
	    Line leftLeg = new Line(275.0, 220.0, 225.0, 275.0);
	    Line rightArm = new Line(295.0, 122.0, 360.0, 185.0);
	    Line leftArm = new Line(255.0, 122.0, 180.0, 185.0);
	    
	    Circle face = new Circle();
		face.setRadius(30);
		face.setStroke(Color.BLACK);
		face.setFill(Color.WHITE);
		face.setCenterX(275);
	    face.setCenterY(100);
	    
	    Scene scene = new Scene(pane, 500, 500); // Adds our pane to the application window and sets the width and height of the window.

	    primaryStage.setTitle("Smiley Face"); // Set's our stage/window title
	    primaryStage.setScene(scene); // Set's out scene into the window
	    primaryStage.setResizable(false); // Set's our window so it is not re-sizeable by the user.
	    primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		
		launch(args);

	}

}
