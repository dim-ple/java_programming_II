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
		
		// These two ArrayLists will hold our guessed and incorrect letters
		ArrayList<Character> guessedLetters = new ArrayList<>();
		ArrayList<Character> incorrectLetters = new ArrayList<>();
			
		// Creates a string variable to hold our word
		String word;
		
		// Creates a character array that will hold the characters from the selected word
		char[] letterArray;
		
		// Our int that will help track when a player gets a "Game Over"
		final int GAME_OVER = 7;
			
		// Creates a Boolean to tell whether or not the Player is currently playing, has pressed enter to play
		boolean isPlaying = false;
		
		// Label Objects created to add to our pane
		Label lblAnswer = new Label();
		Label lblMisses = new Label();
		Label lblIntroMsg = new Label();
		
		// Creates our Shape objects to paint to the pane later
		Circle face = new Circle();
		Line body = new Line();
		Line leftArm = new Line();
		Line rightArm = new Line();
		Line leftLeg = new Line();
		Line rightLeg = new Line();
		
		// Creates our pane
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
		    
		    // Sets our intro message to the pane
		    lblIntroMsg.setText("Welcome - Press Enter to Play!");
		    lblIntroMsg.setLayoutX(190);
		    lblIntroMsg.setLayoutY(350);
		    
		    // Paints our hangman stand to the pane
		    pane.getChildren().addAll(headConnection, horizontalConnection, hangPost, hangStand, lblIntroMsg);
		    
		    Scene scene = new Scene(pane, 500, 500); // Adds our pane to the application window and sets the width and height of the window.
		    
		    
		    // Sets an event handler lambda function that checks to see if the enter key is pressed or if the 
		    // letter keys are pressed. If the enter key is pressed and the isPlaying boolean is false, the eventhandler
		    // runs the start game method. If the key entered is a letter key, it passes the key as a character to the guess method. 
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
		    primaryStage.show(); // Display's our scene
			
		}
		
		
		// Start game method, starts the hangman game. It clears the pane and any arraylists and then sets
		// the stage for our hangman display and game
		private void startGame() {
			
			// clear the pane and arraylists to the game starts anew. This is mostly used for game replays after a game
			// over or player win.
			pane.getChildren().clear();
			guessedLetters.clear();
			incorrectLetters.clear();
			
			// re-draws our hangman post to the pane and adds 
			Line headConnection = new Line(275.0, 70.0, 275.00, 35.0);
		    Line horizontalConnection = new Line(275.0, 35.0, 125.0, 35.0);
		    Line hangPost = new Line(125.0, 35.0, 125.0, 335.0);
		    Arc hangStand = new Arc(125.0, 435.0, 75.0, 100.0, 63.0, 55.0);
		    hangStand.setType(ArcType.OPEN);
		    hangStand.setFill(Color.TRANSPARENT);
		    hangStand.setStroke(Color.BLACK);
		    pane.getChildren().addAll(headConnection, horizontalConnection, hangPost, hangStand);
			
		    // Using the java utility  to shuffle the array list of words
			java.util.Collections.shuffle(words);
			word = words.get(0); // pulls the first word in the arraylist after the shuffle
			letterArray = word.toCharArray(); // converts our string, adding its letters to the letter array at separate indices
			
			// Sets our missed letters label
			lblMisses.setText("Missed letters: ");
			lblMisses.setLayoutX(190);
		    lblMisses.setLayoutY(350);
		    
		    // Sets our hidden answer word by calling the fillAnswer method. The answer will appear in all asterisks
		    // until a correct letter is guessed.
		    lblAnswer.setText(fillAnswer());
		    lblAnswer.setLayoutX(190);
		    lblAnswer.setLayoutY(370);
		    
		    // Adds a label to the pane that will message the user if they guess the same letter, get a letter incorrect, get a letter correct
		    // gets a game over, or guesses the word correctly
		    lblIntroMsg.setText("");
		    lblIntroMsg.setLayoutX(190);
		    lblIntroMsg.setLayoutY(390);
		    pane.getChildren().addAll(lblAnswer, lblMisses, lblIntroMsg);
  
		}
		
		// creates a method that is run anytime a character is guessed (pressed by the user, see event handler in start method), takes
		// the letter guessed and determines if it is correct or incorrect. Returns a boolean so we can terminate the method at certain points.
		private boolean guess(char letter) {
			
			// Takes the character value for the key pressed and converts it to lowercase for comparison later in the method.
			letter = Character.toLowerCase(letter);
			
			// If the player is not playing, the method returns false
			if (!isPlaying) {
				return false;
			}
			
			// If the user guessed letter is contained in the guessed letter array, the guess method terminates and tells the user that
			// they've already guessed the letter. The user is not penalized for guessing a letter they have already guessed.
			if (guessedLetters.contains(letter)) {
				lblIntroMsg.setText("You've already guessed that letter! Try again!");
				return false;
			}
			
			// Adds the guessed letter to the guessed letter array
			guessedLetters.add(letter);
			
			// Creates a string variable to hold our chosen word answer
			String setAnswer = fillAnswer();
			
			// Checks to see if the user has won the game yet by seeing if
			// the answer block is equal to the text in the label that contains the correct letters guessed.
			// Essentially, if there has been no change to the values of the setAnswer, the incorrect letter was guessed.
			// If the correct letter was guessed, setAnswer would be changed and would not match the answer label text until
			// the Else clause of this conditional statement is changed to match
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
				// if a correct letter is selected, the answer label is updated to
				// reflect the correct letter being revealed
				lblAnswer.setText(setAnswer);
				
				// Creates a string message to prompt the user if they guessed a correct letter
				String correctMsg = "That's right!";
				
				// checks to see if our set answer matches our word. If so, the player wins and can play again by pressing Enter.
				if (setAnswer.equalsIgnoreCase(word)) {
					// Player Win Message
					correctMsg = "You won! Press Enter to play again.";
					isPlaying = false; // Sets is playing to false so the player can begin a new game by pressing enter.
				}
				
				lblIntroMsg.setText(correctMsg); // sets the intro msg label to display either thats right or you win.
			}
			
			return true; // returns true if the method executes the else clause
		}
		
		// Our method which will print our hidden answer to the answer-word label in our pane. As letters are
		// guessed, the method mutates the string to reveal the correctly guessed characters as they are pressed.
		private String fillAnswer() {
			
			// sets our hidden answer to an empty string, we will fill this with the proper amount of asterisks
			// the conceal our correct word but also display the number of characters
			String hiddenAnswer = "";
			
			// iterates
			for (int i = 0; i < word.length(); i++) {
				boolean matched = false; // creates a matched boolean so we can keep track of whether or not the user matched a letter in the answer word
				
				// Found out you can use this short hand to do some list comprehension to check if our guessed character is contained in the guessedletters array
				// If a character recorded in the guessLetters array is equivalent to any character in the word answer, the asterisk in the place the letter should 
				// show will be replaced by the correct letter.
				
				for (char c:guessedLetters) {
					if(Character.toLowerCase(c) == Character.toLowerCase(word.charAt(i))) {
						hiddenAnswer += word.charAt(i); // the matching letter at the corresponding index is sent in to replace it placeholder asterisk
						matched = true; // sets matched to true
					}
				}
				if (!matched) {
					hiddenAnswer += "*"; // the letter has not been matched, assign an asterisk to conceal the letters not guessed yet
				}
			}
			return hiddenAnswer; // returns our concealed word
		}
		
		// defines our hangman drawing method. Using a switch statement and the number of incorrect guesses
		// we slowly build the hangman, with the final case being to make the hangman swing, the "game over"
		// animation.
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
		
		// methods to draw our hangman. Each body part method will set the position, size and color before
		// adding the body parts
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
		
		// Method that will animate the hangman swinging - experimented with this and couldn't get the animation to work for the "body" line shape. Couldn't get this last
		// bit right so the program is animation-less for now.
		private void hangmanSwing() {
					
			PathTransition ptBody = new PathTransition(Duration.millis(4000), new Arc(275, 175, 50, 20, 0, 180), body);
			ptBody.setCycleCount(Transition.INDEFINITE);
			ptBody.setAutoReverse(true);
			ptBody.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			
			PathTransition ptRightArm = new PathTransition(Duration.millis(4000), new Arc(0.0, 0.0, 0.0, 10.0, 0.0, 0.0), rightArm);
			ptRightArm.setCycleCount(Transition.INDEFINITE);
			ptRightArm.setAutoReverse(true);
			ptRightArm.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			
			
			PathTransition ptLeftArm = new PathTransition(Duration.millis(4000), new Arc(0, 0, 0, 0, 0, 0), leftArm);
			ptLeftArm.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			ptLeftArm.setCycleCount(Transition.INDEFINITE);
			ptLeftArm.setAutoReverse(true);
			
			
			PathTransition ptLeftLeg = new PathTransition(Duration.millis(4000), new Arc(300.0, 150.0, 20.0, 10.0, 40.0, 40.0), leftLeg);
			ptLeftLeg.setCycleCount(Transition.INDEFINITE);
			ptLeftLeg.setAutoReverse(true);
			ptLeftLeg.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			
			
			PathTransition ptRightLeg = new PathTransition(Duration.millis(4000), new Arc(300.0, 150.0, 20.0, 10.0, 40.0, 40.0), leftLeg);
			ptRightLeg.setCycleCount(Transition.INDEFINITE);
			ptRightLeg.setAutoReverse(true);
			ptLeftLeg.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			
			
			ptBody.play();
			ptRightArm.play();
			ptLeftArm.play();
			ptLeftLeg.play();
			ptLeftLeg.play();
			
		}
		
		
		
		public static void main(String[] args) {
			
			launch(args);

	}
}