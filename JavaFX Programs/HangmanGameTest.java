// Program created by: Harrison Goehring
// Date Created: April 21st, 2023

// This program runs a Hangman type game where the user will be able to guess a word, one letter at a time. If the user does not guess a letter in the word correctly,
// they lose the game. If the user guesses the correct letters to spell the word, they can move on to guess another word. After the user correctly guesses 4 words, they win!


// Imports utility's to create ArrayLists, and an ArrayList from an Array to hold our words, guessed letters and incorrectly guessed letters
import java.util.ArrayList;
import java.util.Arrays;

// Imports our JavaFX tools to create and animate our Hangman scene and text labels
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

// Imports our JavaFx tool that will take in and 
import javafx.scene.input.KeyCode;


public class HangmanGameTest extends Application {
		
	// Creates a String Array with our 7-letter words that we will cast to the ArrayList
		String[] array = {"Array", "Java", "Easy", "Boolean"};
					
		// Creates an ArrayList with the contents of our array. This ArrayList contains 
		// String answers to out hangman game.
		ArrayList<String> words = new ArrayList<>(Arrays.asList(array));
		ArrayList<Character> guessedLetters = new ArrayList<>();
		ArrayList<Character> incorrectLetters = new ArrayList<>();
			
		String word;
		char[] letterArray;
			
		final int GAME_OVER = 7;
		int guessCount = 0;
			
		boolean isPlaying = false;
					
		Label lblAnswer = new Label();
		Label lblMisses = new Label();
		Label lblIntroMsg = new Label();
		
		Circle face = new Circle();
		Line body = new Line();
		Line leftArm = new Line();
		Line rightArm = new Line();
		Line leftLeg = new Line();
		Line rightLeg = new Line();
			
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
		  
		    lblIntroMsg.setText("Welcome - Press Enter to Play!");
		    lblIntroMsg.setLayoutX(190);
		    lblIntroMsg.setLayoutY(350);
		    
		    // Paints our hangman stand to the pane
		    pane.getChildren().addAll(headConnection, horizontalConnection, hangPost, hangStand, lblIntroMsg);
		    
		    Scene scene = new Scene(pane, 500, 500); // Adds our pane to the application window and sets the width and height of the window.
		    
		    scene.setOnKeyPressed(e -> {
		    	if (e.getCode() == KeyCode.ENTER && !isPlaying) {
		    		isPlaying = true;
		    		startGame();
		    	} else if (e.getCode().isLetterKey()) {
		    		guess(e.getCode().getName().charAt(0));
		    	}
		    });

		    primaryStage.setTitle("Hangman Game"); // Set's our stage/window title
		    primaryStage.setScene(scene); // Set's out scene into the window
		    primaryStage.setResizable(false); // Set's our window so it is not re-sizeable by the user.
		    primaryStage.show();
			
		}
		
		
		
		private void startGame() {
			
			pane.getChildren().clear();
			guessedLetters.clear();
			incorrectLetters.clear();
			
			
			Line headConnection = new Line(275.0, 70.0, 275.00, 35.0);
		    Line horizontalConnection = new Line(275.0, 35.0, 125.0, 35.0);
		    Line hangPost = new Line(125.0, 35.0, 125.0, 335.0);
		    Arc hangStand = new Arc(125.0, 435.0, 75.0, 100.0, 63.0, 55.0);
		    hangStand.setType(ArcType.OPEN);
		    hangStand.setFill(Color.TRANSPARENT);
		    hangStand.setStroke(Color.BLACK);
		    pane.getChildren().addAll(headConnection, horizontalConnection, hangPost, hangStand, lblIntroMsg);
			
			pane.getChildren().remove(lblIntroMsg);
			
			java.util.Collections.shuffle(words);
			word = words.get(0);
			letterArray = word.toCharArray();
			
			lblMisses.setText("Missed letters: ");
			lblMisses.setLayoutX(190);
		    lblMisses.setLayoutY(350);
		    
		    lblAnswer.setText(fillAnswer());
		    lblAnswer.setLayoutX(190);
		    lblAnswer.setLayoutY(370);
		    
		    lblIntroMsg.setText("");
		    lblIntroMsg.setLayoutX(190);
		    lblIntroMsg.setLayoutY(390);
		    
		    pane.getChildren().addAll(lblAnswer, lblMisses, lblIntroMsg);
  
		}
		
		private boolean guess(char letter) {
		
			
			letter = Character.toLowerCase(letter);
			
			if (!isPlaying) {
				return false;
			}
			
			if (guessedLetters.contains(letter)) {
				lblIntroMsg.setText("You've already guessed that letter! Try again!");
				return false;
			}
			
			guessedLetters.add(letter);
			
			String setAnswer = fillAnswer();
			
			if (setAnswer.equalsIgnoreCase(lblAnswer.getText())) {
				
				incorrectLetters.add(letter);
				
				if(incorrectLetters.size() == GAME_OVER) {
					lblIntroMsg.setText("Game Over - Press Enter to Try Again.");
					isPlaying = false;
				} else {
					lblIntroMsg.setText(letter + " was an incorrect guess. Guess Again!");
					drawHangman(incorrectLetters.size());
				}
				
				lblMisses.setText(lblMisses.getText() + letter);
				
				return false;
			} else {
				lblAnswer.setText(setAnswer);
				String correctMsg = "That's right!";
				if (setAnswer.equalsIgnoreCase(word)) {
					correctMsg += " You won! Press Enter to play again.";
					isPlaying = false;
				}
				
				lblIntroMsg.setText(correctMsg);
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
		
		private void drawHangman(int guesses) {
			
			switch (guesses) {
				case 1: drawFace(); break;
				case 2: drawBody(); break;
				case 3: drawRightArm(); break;
				case 4: drawLeftArm(); break;
				case 5: drawRightLeg(); break;
				case 6: drawLeftLeg(); break;
				case 7: hangmanSwing(); break; 
			}
		
		}
		
		private void drawFace() {
			
			face.setRadius(30);
			face.setStroke(Color.BLACK);
			face.setFill(Color.WHITE);
			face.setCenterX(275);
		    face.setCenterY(100);
			
			pane.getChildren().add(face);
		}
		
		private void drawBody() {
			
			body.setStartX(275.0);
			body.setStartY(130.0);
			body.setEndX(275.0);
			body.setEndY(220.0);
			body.setStroke(Color.BLACK);
		
			pane.getChildren().add(body);
		}
		
		private void drawRightArm() {
			
			
			rightArm.setStartX(295.0);
			rightArm.setStartY(122.0);
			rightArm.setEndX(360.0);
			rightArm.setEndY(185.0);
			rightArm.setStroke(Color.BLACK);
		
			pane.getChildren().add(rightArm);
		}

		private void drawLeftArm() {
	
			leftArm.setStartX(255.0);
			leftArm.setStartY(122.0);
			leftArm.setEndX(180.0);
			leftArm.setEndY(185.0);
			leftArm.setStroke(Color.BLACK);
			pane.getChildren().add(leftArm);
			
		}

		private void drawRightLeg() {
	
			rightLeg.setStartX(275.0);
			rightLeg.setStartY(220.0);
			rightLeg.setEndX(325.0);
			rightLeg.setEndY(275.0);
			rightLeg.setStroke(Color.BLACK);

			pane.getChildren().add(rightLeg);
		}

		private void drawLeftLeg() {
	
			leftLeg.setStartX(275.0);
			leftLeg.setStartY(220.0);
			leftLeg.setEndX(225.0);
			leftLeg.setEndY(275.0);
			leftLeg.setStroke(Color.BLACK);

			pane.getChildren().add(leftLeg);
		}
		
		private void hangmanSwing() {
			
			
			
			PathTransition ptBody = new PathTransition(Duration.millis(4000), new Arc(300.0, 150.0, 20.0, 10.0, 40.0, 40.0), body);
			ptBody.setCycleCount(Transition.INDEFINITE);
			ptBody.setAutoReverse(true);
			ptBody.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			ptBody.play();
			
			PathTransition ptRightArm = new PathTransition(Duration.millis(4000), new Arc(300.0, 150.0, 20.0, 10.0, 40.0, 40.0), rightArm);
			ptRightArm.setCycleCount(Transition.INDEFINITE);
			ptRightArm.setAutoReverse(true);
			ptRightArm.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			ptRightArm.play();
			
			PathTransition ptLeftArm = new PathTransition(Duration.millis(4000), new Arc(300.0, 150.0, 20.0, 10.0, 40.0, 40.0), leftArm);
			ptLeftArm.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			ptLeftArm.setCycleCount(Transition.INDEFINITE);
			ptLeftArm.setAutoReverse(true);
			ptLeftArm.play();
			
			PathTransition ptLeftLeg = new PathTransition(Duration.millis(4000), new Arc(300.0, 150.0, 20.0, 10.0, 40.0, 40.0), leftLeg);
			ptLeftLeg.setCycleCount(Transition.INDEFINITE);
			ptLeftLeg.setAutoReverse(true);
			ptLeftLeg.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			ptLeftLeg.play();
			
			PathTransition ptRightLeg = new PathTransition(Duration.millis(4000), new Arc(300.0, 150.0, 20.0, 10.0, 40.0, 40.0), leftLeg);
			ptRightLeg.setCycleCount(Transition.INDEFINITE);
			ptRightLeg.setAutoReverse(true);
			ptLeftLeg.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			ptLeftLeg.play();
			
			
		
		}
		
		
		
		public static void main(String[] args) {
			
			launch(args);

	}
}