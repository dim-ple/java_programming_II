// Program created by: Harrison Goehring
// Date Created: April 19th, 2023

// This program runs a Hangman type game where the user will be able to guess a word, one letter at a time. If the user does not guess a letter in the word correctly,
// they lose the game. If the user guesses the correct letters to spell the word, they can move on to guess another word. After the user correctly guesses 4 words, they win!

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

import javafx.animation.PathTransition;
import javafx.animation.Transition;
import javafx.util.Duration;

import javafx.scene.input.KeyCode;

public class HangmanGameTest extends Application {

		// Creates a String Array with our 7-letter words that we will cast to the ArrayList
		String[] array = {"Array", "Java", "Easy", "Boolean"};
				
		// Creates an ArrayList with the contents of our array. This ArrayList contains 
		// String answers to out hangman game.
		ArrayList<String> words = new ArrayList<>(Arrays.asList(array));
		ArrayList<Character> guessedLetters = new ArrayList<>();
		
		String word;
		char[] letterArray;
		
		final int GAME_OVER = 7;
		int attempts = 0;
		
		boolean isPlaying = false;
				
		Label lblAnswer = new Label();
		Label lblMisses = new Label();
		Label lblIntroMsg = new Label();
		
		Pane pane = new Pane();
	
	@Override
	public void start(Stage primaryStage) {

		// This block of code defines our hangman stand
		Line headConnection = new Line(275.0, 70.0, 275.00, 35.0);
	    Line horizontalConnection = new Line(275.0, 35.0, 125.0, 35.0);
	    Line hangPost = new Line(125.0, 35.0, 125.0, 335.0);
	    Arc hangStand = new Arc(125.0, 435.0, 75.0, 100.0, 63.0, 55.0);
	    hangStand.setType(ArcType.OPEN);
	    hangStand.setFill(Color.TRANSPARENT);
	    hangStand.setStroke(Color.BLACK);
	   
	    
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
	    
	    lblIntroMsg.setText("Welcome - Press Enter to Play!");
	    lblIntroMsg.setLayoutX(190);
	    lblIntroMsg.setLayoutY(350);
	    
	    // Paints our hangman stand to the pane
	    pane.getChildren().addAll(headConnection, horizontalConnection, hangPost, hangStand, lblIntroMsg);
	    
	    Scene scene = new Scene(pane, 500, 500); // Adds our pane to the application window and sets the width and height of the window.
	    
	    scene.setOnKeyPressed(e -> {
	    	pane.keyPressHandler(e.getCode());
	    });

	    primaryStage.setTitle("Hangman Game"); // Set's our stage/window title
	    primaryStage.setScene(scene); // Set's out scene into the window
	    primaryStage.setResizable(false); // Set's our window so it is not re-sizeable by the user.
	    primaryStage.show();
		
	}
	
	private void keyPressHandler(KeyCode key) {
		if (key == KeyCode.ENTER && !isPlaying) {
			isPlaying = true;
			startGame();
		} else if (key.isLetterKey()) {
			guess(key.getName().charAt(0));
		}
	}
	
	private void startGame() {
		
		pane.getChildren().remove(lblIntroMsg);
		
		java.util.Collections.shuffle(words);
		word = words.get(0);
		letterArray = word.toCharArray();
		
		lblMisses.setText("Missed letters: ");
		lblMisses.setLayoutX(190);
	    lblMisses.setLayoutY(350);
	    
	    lblAnswer.setText("Guess a word: " + fillAnswer());
	    lblAnswer.setLayoutX(190);
	    lblAnswer.setLayoutY(370);
	    
	    pane.getChildren().addAll(lblAnswer, lblMisses);
	    
	    
	    
	}
	
	private boolean guess(char c) {
		
		if (!isPlaying) {
			return false;
		}
		
		return true;
	}
	
	// Our method which will print our hidden answer to the answer-word label in our pane. As letters are
	// guessed, the method
	private String fillAnswer() {
		
		String hiddenAnswer = "";
		
		for (int i = 0; i < word.length(); i++) {
			boolean matched = false;
			for (char c:guessedLetters) {
				if(Character.toLowerCase(c) == Character.toLowerCase(word.charAt(i))) {
					hiddenAnswer += word.charAt(i);
					matched = true;
					break;
				}
			}
			if (!matched) {
				hiddenAnswer += "*";
			}
		}
		return hiddenAnswer;
	}
	
	public static void main(String[] args) {
		
		launch(args);

	}

}