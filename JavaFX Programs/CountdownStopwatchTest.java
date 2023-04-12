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

// Imports our javafx tools to create our UI textfield used by the user to display our number and eventual countdown
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

// Imports our javafx tools to create our animation
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;


import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class CountdownStopwatchTest extends Application {

	@Override
	public void start(Stage primaryStage) { 
		
		Pane pane = new Pane(); // Creates a new pane to paint our textfield to
		
		TextField tfUserSecs = new TextField("0");
		tfUserSecs.setFont(new Font("Times", 32));
		
		tfUserSecs.setAlignment(Pos.CENTER);
		tfUserSecs.setPrefSize(150, 150);
		
		pane.getChildren().add(tfUserSecs);
				
		
		Timeline animation = new Timeline(
				new KeyFrame(Duration.millis(1000), e -> {
					int totalTime = Integer.valueOf(tfUserSecs.getText());
					String currentTime = tfUserSecs.getText();
					totalTime *= 1000;
					if (totalTime > 0) {
						totalTime -= 1000;
						currentTime = String.valueOf(totalTime / 1000);
						tfUserSecs.setText(currentTime);
					}
				})
			);
		
	
		tfUserSecs.setOnKeyPressed(e -> {
			if (tfUserSecs.getText() != "0") {
				switch (e.getCode()) {
					case ENTER: 
						animation.setCycleCount(Timeline.INDEFINITE);
						animation.play();
				} 
			} else {
				animation.stop();
				
			}
		});
		
		
		
		
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
