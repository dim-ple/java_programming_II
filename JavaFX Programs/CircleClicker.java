// Program created by: Harrison Goehring
// Date Created: April 6th, 2023

// This program that displays a circle with a 10 pixel radius filled with a random color at a random location on a pane,
// When you click the circle, it disappears and a new random-color circle is displayed at another random location. 
// After 20 circles are clicked, the program will display the time spent in the program in seconds.


// Imports our JavaFX tools to create our Application window, scene and pane
import javafx.application.Application;
import javafx.scene.Scene; 
import javafx.scene.layout.Pane;
import javafx.stage.Stage; 

// Imports our JavaFX tools to allow us to paint circles and fill them with color
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

// Imports our JavaFX tool to display our completion time message to the application window
import javafx.scene.text.Text;

// Imports our JavaFX EventHandler and MouseEvent, specifically used to register clicks on our cirlces
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;


public class CircleClicker extends Application {
	
	// our start method which starts the application
	public void start(Stage primaryStage) {
		
		Pane pane = new Pane(); // Creates a new pane to paint our circles on
		
		Circle circle = new Circle(randomCoordinate(), randomCoordinate(), 10); // Creates our first circle object with a radius of 10. 
																				// X & Y coordinates on the pane are given using the random
																				// coordinate method defined below. 
		
		circle.setFill(Color.color(Math.random(), Math.random(), Math.random())); // Sets a random fill color for our first circle shape.
																				  // The color method can take RGB coordinates which takes 
		                                                                          // doubles as arguments. Using Math.random(), we can return
																				  // a random double between 0.0 and 1.0. Perfect to ensure
																				  // that our fill color is more than likely to different every
																				  // iteration.
		
		Text text = new Text(); // Creates our text object which we will paint on our pane
		
		pane.getChildren().add(circle);
		long startTime = System.currentTimeMillis(); // Saves the current time in Milliseconds using the Built-in System method
													 // Will be used later in an equation to determine the total amount of time
													 // spent clicking 20 circles
	
		// Define our EventHandler for when the mouse is clicked.
		circle.setOnMouseClicked(new EventHandler<>() {
			int clickerCounter = 1; // Creates our counter variable
			
			// Our handler takes in a mouse event as an argument. As long as our click counter is not 20 or more AND
			// the user is clicking within the circle shape on the pane, the old circle will be cycled off of the pane
			// and a new circle of the same size with random fill will be generated on the pane. 
			public void handle(MouseEvent e) {
				if (clickerCounter < 20 && circle.contains(e.getX(), e.getY())) {
					
					clickerCounter++; // Increments our click counter by 1
					
					pane.getChildren().clear(); // Clears the pane
					
					circle.setCenterX(randomCoordinate()); // sets a new random X coordinate for our circle object
					circle.setCenterY(randomCoordinate()); // sets a new random Y coordinate for our circle object
					circle.setFill(Color.color(Math.random(), Math.random(), Math.random())); // sets a random fill color for our circle
					
					pane.getChildren().add(circle); // adds the newly positioned and colored circle on the pane
				
				} else { // Once the click counter reaches 20, we clear the pane and post the time it took for the user to complete 20 circle clicks
					long endTime = System.currentTimeMillis(); // Saves the time of completion as our endTime variable using
															   // the built in System library method to get the current time in milliseconds
					
					pane.getChildren().clear(); // Clears the pane of any shapes, text, etc.
					
					float sec = (endTime - startTime) / 1000F; // This variable saves our total time of completion by 
															   // subtracting our end time by our start time. It then 
															   // converts from milliseconds to seconds by dividing the 
															   // the product of the subtraction by a float of 1000.
					
					String secsElaps = String.valueOf(sec); // Converts our float variable storing the total seconds it took to click
															// 20 circles into a String so it can be painted in a text object to the pane.
					text.setText("Time Spent: " + secsElaps + " seconds"); // Paints our result to the pane
					
					// Sets position of the Text object
					text.setX(85);
					text.setY(140);
					
					pane.getChildren().add(text); // Adds our completion time text to the window	
				}
			}	
		});
		
		Scene scene = new Scene(pane, 300, 300); // Adds our pane to the application window and sets the width and height of the window.
		
		primaryStage.setTitle("Circle Clicker"); // Set's our stage/window title
		primaryStage.setScene(scene); // Set's out scene into the window
		primaryStage.setResizable(false); // Set's our window so it is not re-sizeable by the user.
		primaryStage.show(); // Displays our stage in an application window
		
	}
	
	public static void main(String[] args) {
		
		launch(args);

	}
	
	
	// Creates our Random Coordinate method used to generate the X & Y positions for our circles. We do this by using the Math.random() method
	// Math.floor method, and our range from 1 to 300.
	private static int randomCoordinate() {
		
		return (int)Math.floor(Math.random() * (300 - 1 + 1));
		
	}
	
	
	
}