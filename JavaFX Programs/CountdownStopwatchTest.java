// Program created by: Harrison Goehring
// Date Created: April 11th, 2023

// This program allows the user to enter a time in seconds into a text field. When they press the Enter key, the number will count down 
// the seconds. When the seconds reach Zero, the program was supposed to play music, but I was unable to get this to work properly.

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

// Imports our JavaFx tools to play music in our file
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class CountdownStopwatchTest extends Application {

	final String MUSIC_URL = "music.mp3";
	
	@Override
	public void start(Stage primaryStage) { 
		
		Pane pane = new Pane(); // Creates a new pane to paint our textfield to
		
	
		// Commenting out these lines of code, program would not run, threw an exception. 
		// Not exactly sure why
		//Media media = new Media(MUSIC_URL);
		//MediaPlayer mediaPlayer = new MediaPlayer(media);
		
		TextField tfUserSecs = new TextField(); // Adds our text field and sets the font, size of entered text
		tfUserSecs.setFont(new Font("Times", 32));
		
		tfUserSecs.setAlignment(Pos.CENTER); // makes our textfield center aligned
		tfUserSecs.setPrefSize(150, 150); // sets our textfield to be the size of the window 
		
		pane.getChildren().add(tfUserSecs); // adds our textfield to the pane
				
		
		// Creates our animation where our user's entry will reduced by 1 every 1 second
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
		
		
		// our lambda function on key press for "Enter" which will trigger our countdown animation from the number entered
		tfUserSecs.setOnKeyPressed(e -> {
			if (tfUserSecs.getText() != "0") {
				switch (e.getCode()) {
					case ENTER: 
						animation.setCycleCount(Timeline.INDEFINITE);
						animation.play();
				} 
			} else {
				animation.stop(); // stops the animation when the textfield entry is 0
				// mediaPlayer.play(); // Wasn't able to get this to work with an exception being thrown
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
