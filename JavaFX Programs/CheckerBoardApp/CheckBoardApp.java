// Program created by: Harrison Goehring
// Date Created: March 29th, 2023

// This program uses the JavaFX library to create a checkerboard pattern of black and white squares in an application window.

import javafx.application.Application;
import javafx.scene.Scene; 
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage; 

public class CheckBoardApp extends Application {
	public void start(Stage primaryStage) {
		Pane pane = new Pane(); // Creates our new pane in which we will place our checkboard pattern
		
		int rowPos = 0; // Creates a variable to hold our row position for each square. This will be increased every parent loop iteration
		int boardSize = 8; // Creates a varabile to determine our board size (checkerboards are 8x8 grids)
		int windowWidthHeight = 320; // Creates a variable to hold our window height and width. 
		
		
		// Using a similar for-loop + nested for-loop from one of our previous assignments where we needed to display 
		// a chekerboard pattern to the console - the program is able to populate 8 rows of alternating white and black square shapes
		// using JavaFX.
		
		// The parent for-loop, will terminate once 8 iterations occur (or once 8 rows of squares are completed.
		for (int row = 1; row <= 8; row++) {
			
			
			// On each parent for-loop iteration, we check to see if the row number is even or odd. If the row is odd, our first square will be white. If the row is even, our first
			// square will be black.
			if (row % 2 == 0) { 
				
				// Once the row has been determined as even or odd, the nested for-loops produce equal sized squares, with appropriate fill colors and equally spaced from each other.
				// Once 8 squares are created, the nested for-loop terminates
				for (int i = 0; i < windowWidthHeight / 2; i += 40) {
					Rectangle black = new Rectangle(i*2, rowPos, 40, 40);
					black.setFill(Color.BLACK);
					black.setStroke(Color.BLACK);
					pane.getChildren().add(black);
				}
				
				for (int i = 40; i <= windowWidthHeight; i += 80) {
					Rectangle white = new Rectangle(i, rowPos, 40, 40);
					white.setFill(Color.WHITE);
					white.setFill(Color.WHITE);
					pane.getChildren().add(white);
				}
			} else {
				
				for (int i = 0; i < windowWidthHeight / 2; i += 40) {
					Rectangle white = new Rectangle(i*2, rowPos, 40, 40);
					white.setFill(Color.WHITE);
					white.setStroke(Color.WHITE);
					pane.getChildren().add(white);
				}
				
				for (int i = 40; i <= windowWidthHeight; i += 80) {
					Rectangle black = new Rectangle(i, rowPos, 40, 40);
					black.setFill(Color.BLACK);
					black.setFill(Color.BLACK);
					pane.getChildren().add(black);
				}
			}
			
			rowPos += windowWidthHeight / boardSize; // Incrementally increases the row postion on the x-axis of the window by the window size divided by the amount of rows. This will help
													 // to position the new row shapes below and adjacent to each other.
			
		}
		
		Scene scene = new Scene(pane, windowWidthHeight, windowWidthHeight); // Sets our scene/window using our checkerboard pane and equivalent height and width so the checkboard squares 
																			 // fit correctly.
		primaryStage.setTitle("CheckerBoard"); // Set's our stage/window title
		primaryStage.setScene(scene); // Set's out scene into the window
		primaryStage.setResizable(false); // Set's our window so it is not re-sizeable by the user.
		primaryStage.show(); // Shows our window when the start method is run
		
	}
	
	
	// our main method
	public static void main(String[] args) {
		
		launch(args); // launch command included in our main method in case the program is run through an IDE that has limited support for JavaFX
	}
}
