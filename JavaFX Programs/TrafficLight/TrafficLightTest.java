// Program created by: Harrison Goehring
// Date Created: April 11th, 2023

// This program simulates a traffic light. It allows the user to select one of three traffic light colors (red, green, yellow) which the user
// can choose from a selection of radio buttons. The color selected via the corresponding radio button is then illuminated on the traffic light
// while all the other lights are no longer illuminated (only one light can be on at a time).

// Imports our JavaFX tools to create our Application window, scene and pane
import javafx.application.Application;
import javafx.scene.Scene; 
import javafx.scene.layout.Pane;
import javafx.stage.Stage; 

// Imports our JavaFX tool to display our completion time message to the application window
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

// imports our UI Radio Button Tool to select our traffic light colors
import javafx.scene.control.RadioButton;


public class TrafficLightTest extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		Pane pane = new Pane(); // Creates a new pane to paint our traffic light and UI controls to
		
		// Creates our rectangle that will hold our traffic lights
		Rectangle lightBox = new Rectangle(160.0, 80.0, 80.0, 200.0);
		lightBox.setFill(Color.WHITE);
		lightBox.setStroke(Color.BLACK);
		
		// Creates our red traffic light as a circle object, this will appear at the top of our light box
		Circle redCircle = new Circle(200.0, 120.0, 20.0);
		redCircle.setStroke(Color.BLACK);
		redCircle.setFill(Color.WHITE);
		
		// Creates our yellow traffic light as a circle object, this will appear in the middle of our light box
		Circle yellowCircle = new Circle(200.0, 180.0, 20.0);
		yellowCircle.setStroke(Color.BLACK);
		yellowCircle.setFill(Color.WHITE);
		
		// Creates our green traffic light as a circle object, this will appear at the bottom of our light box
		Circle greenCircle = new Circle(200.0, 240.0, 20.0);
		greenCircle.setStroke(Color.BLACK);
		greenCircle.setFill(Color.WHITE);
		
		// Adds and positions our radio button to select the Red light
		RadioButton rbRed = new RadioButton("Red");
		rbRed.setLayoutX(120.0);
		rbRed.setLayoutY(360.0);
		
		// Adds and positions our radio button to select the Yellow light
		RadioButton rbYellow = new RadioButton("Yellow");
		rbYellow.setLayoutX(180.0);
		rbYellow.setLayoutY(360.0);
		
		// Adds and positions our radio button to select the Green light
		RadioButton rbGreen = new RadioButton("Green");
		rbGreen.setLayoutX(240.0);
		rbGreen.setLayoutY(360.0);
		
		// Adds our lightbox, color circles and radio buttons to the pane
		pane.getChildren().add(lightBox);
		pane.getChildren().addAll(redCircle, yellowCircle, greenCircle);
		pane.getChildren().addAll(rbRed, rbYellow, rbGreen);
		
		// Event handler to fill the Red light with the yolor red once the red radio button is selected.
		// When the button is selected, the other lights/circles will have their fill set back to white
		// so only the selected circle has color.
		rbRed.setOnAction(e -> {
			if (rbRed.isSelected()) {
				rbYellow.setSelected(false);
				rbGreen.setSelected(false);
				yellowCircle.setFill(Color.WHITE);
				greenCircle.setFill(Color.WHITE);
				redCircle.setFill(Color.RED);
			} else {
				redCircle.setFill(Color.WHITE); // added this else clause to ensure if the radio button is unchecked by the user, 
												// the un-selected circle will go back to a white fill.
			}
		});
		
		// Event handler to fill the Yellow light with the color yellow once the corresponding yellow radio button is hit. Resets
		// the fill colors for the other circles to white.
		rbYellow.setOnAction(e -> {
			if (rbYellow.isSelected()) {
				rbRed.setSelected(false);
				rbGreen.setSelected(false);
				redCircle.setFill(Color.WHITE);
				greenCircle.setFill(Color.WHITE);
				yellowCircle.setFill(Color.YELLOW);
			} else {
				yellowCircle.setFill(Color.WHITE); 
			}
		});
		
		// Event handler to fill the Green light with the color green once the corresponding yellow radio button is hit. Resets
		// the fill colors for the other circles to white.
		rbGreen.setOnAction(e -> {
			if (rbGreen.isSelected()) {
				rbYellow.setSelected(false);
				rbRed.setSelected(false);
				yellowCircle.setFill(Color.WHITE);
				redCircle.setFill(Color.WHITE);
				greenCircle.setFill(Color.GREEN);
			} else {
				greenCircle.setFill(Color.WHITE);
			}
		});
		
		
		Scene scene = new Scene(pane, 400, 400); // Adds our pane to the application window and sets the width and height of the window.
		primaryStage.setTitle("Traffic Light Control"); // Set's our stage/window title
		primaryStage.setScene(scene); // Set's out scene into the window
		primaryStage.setResizable(false); // Set's our window so it is not re-sizeable by the user.
		primaryStage.show(); // Displays our scene in an application window
		
	}
	
	public static void main(String[] args) {
		
		launch(args);

	}

}
