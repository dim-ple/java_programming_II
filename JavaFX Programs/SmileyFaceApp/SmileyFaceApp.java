// Program created by: Harrison Goehring
// Date Created: March 31st, 2023

// This program uses the JavaFX library to create a Smiley Face in an application window.

// Import our JavaFX tools to display our application
import javafx.application.Application;
import javafx.scene.Scene; 
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

//Imported our shapes needed to create the Smiley Face
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Polygon;

public class SmileyFaceApp extends Application {
	@Override //Overrides the start method in the Application Class
	
	public void start(Stage primaryStage) {
		
		Pane pane = new Pane(); // Creates our pane object which will hold our shapes and display to the application window
		
		// Creates our Circle Shape which will be our face canvas we'll paint other shapes/features on. The position of the
		// face will be centered in he application window.
		Circle face = new Circle();
		face.setRadius(100);
		face.setStroke(Color.BLACK);
		face.setFill(Color.WHITE);
		face.setCenterX(200);
	    face.setCenterY(200);
			
	    // Creates our smile by using an Arc Shape and Open Arc Type, positions the smile appropriately
		Arc smile = new Arc(200, 115, 150, 150, 30 + 220, 40);
	    smile.setFill(Color.WHITE);
	    smile.setType(ArcType.OPEN);
	    smile.setStroke(Color.BLACK);
	   
	    // Creates our left and right eye sockets using Ellipse shapes, positions them appropriately
	    Ellipse leftSocket = new Ellipse();
	    leftSocket.setRadiusX(30);
	    leftSocket.setRadiusY(15);
	    leftSocket.setCenterX(155);
	    leftSocket.setCenterY(165);
	    leftSocket.setFill(Color.WHITE);
	    leftSocket.setStroke(Color.BLACK);
	    
	    Ellipse rightSocket = new Ellipse();
	    rightSocket.setRadiusX(30);
	    rightSocket.setRadiusY(15);
	    rightSocket.setCenterX(240);
	    rightSocket.setCenterY(165);
	    rightSocket.setFill(Color.WHITE);
	    rightSocket.setStroke(Color.BLACK);
	    
	    // Creates our left & right eyes using Circle shapes, positions them within the socket/ellipses
	    Circle leftEye = new Circle();
	    leftEye.setRadius(10);
		leftEye.setStroke(Color.BLACK);
		leftEye.setFill(Color.BLUE);
		leftEye.setCenterX(155);
	    leftEye.setCenterY(165);
	    
	    Circle rightEye = new Circle();
	    rightEye.setRadius(10);
		rightEye.setStroke(Color.BLACK);
		rightEye.setFill(Color.BLUE);
		rightEye.setCenterX(240);
	    rightEye.setCenterY(165);
		
	    // Using the Polygon shape, we created a triangle, set it's position to the center point of our face and application window,
	    // and then rotated the triangle.
	    Polygon nose = new Polygon();
	    nose.setFill(Color.RED);
	    nose.setStroke(Color.BLACK);
	    nose.getPoints().addAll(220.0, 180.0, 180.0, 200.0, 220.0, 220.0);
	    nose.setRotate(90);
	    
	    pane.getChildren().addAll(face, smile, leftSocket, rightSocket, leftEye, rightEye, nose); // Adds all of our shapes/facial features to
	    																						  // the pane.
	    
	    Scene scene = new Scene(pane, 400, 400); // Adds our pane to the application window and sets the width and height of the window.
	    
	    primaryStage.setTitle("Smiley Face"); // Set's our stage/window title
		primaryStage.setScene(scene); // Set's out scene into the window
		primaryStage.setResizable(false); // Set's our window so it is not re-sizeable by the user.
	    primaryStage.show(); // Displays our application window and smiley face!
	}
	
	
	public static void main(String[] args) {
		
		launch(args);
		
	}
}
