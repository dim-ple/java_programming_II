// Program created by: Harrison Goehring
// Date Created: April 11th, 2023

// This program allows the user to enter a time in seconds into a text field. When they press the Enter key, the number will count down 
// the seconds. When the seconds reach Zero, the program will play music.

// Imports our JavaFX tools to create our Application window, scene and pane
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene; 
import javafx.scene.layout.Pane;
import javafx.stage.Stage; 

import javafx.scene.control.TextField;
import javafx.scene.text.Font;

import javafx.util.Duration;


public class CountdownStopwatchTest extends Application {
	@Override
	public void start(Stage primaryStage) { 
		
		Pane pane = new Pane();
		
		TextField tfUserSecs = new TextField("Enter the Starting Time (in seconds)");
		tfUserSecs.setFont(new Font("Times", 32));
		
		tfUserSecs.setAlignment(Pos.CENTER);
		tfUserSecs.setPrefSize(150, 150);
		
		tfUserSecs.setOnAction(e -> { 
			int totalTime = Integer.valueOf(tfUserSecs.getText());
			totalTime *= 1000;
			while (totalTime > 0) {
				totalTime -= 1000;
				tfUserSecs.setText(String.valueOf(totalTime / 1000));
			}
			
		});
		
		pane.getChildren().add(tfUserSecs);
		
		Scene scene = new Scene(pane, 150, 150); // Adds our pane to the application window and sets the width and height of the window.
		primaryStage.setTitle("Countdown Stopwatch"); // Set's our stage/window title
		primaryStage.setScene(scene); // Set's out scene into the window
		primaryStage.setResizable(false); // Set's our window so it is not re-sizeable by the user.
		primaryStage.show(); // Displays our scene in an application window
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
