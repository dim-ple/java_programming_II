/* */

import javafx.application.Application; //our JavaFX application
import javafx.scene.Scene; // imports our JavaFX scene tool
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage; // imports our stage tool
import javafx.scene.layout.GridPane;

public class CheckBoardApp extends Application {
	public void start(Stage primaryStage) {
		Pane pane = new Pane(); // Creates our new pane in which we will place our checkboard pattern
		
		int rowPos = 0; // Creates a 
		int boardSize = 8;
		int windowWidthHeight = 320;
		
		for (int row = 1; row <= 8; row++) {
			
			if (row % 2 == 0) {
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
	
	public static void main(String[] args) {
		
		launch(args);
	}
}
