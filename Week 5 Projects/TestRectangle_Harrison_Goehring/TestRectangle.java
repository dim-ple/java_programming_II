// Program created by: Harrison Goehring
// Date Created: February 20th, 2023

// This program includes a main method that will create two new rectangle objects. The main method will call upon a Rectangle class using a constructor 
// that will create the objects (rectangle1, rectangle 2), and it's methods that will obtain the area and perimeter. 
// The program will then print each rectangle object's attributes (width, height, area, perimeter) to the console.


public class TestRectangle {

	public static void main (String[] args) {
		
		// Creates our first Rectangle object with the argument constructor from the Rectangle class.
		// Our first argument is our width (4) and our second argument is our height (40).
		Rectangle rectangle1 = new Rectangle(4, 40);
		
		// Creates our second Rectangle object with the argument constructor from the Rectangle Class.
		// Our first argument is our width (3.5) and our second argument is our height (35.9).
		Rectangle rectangle2 = new Rectangle(3.5, 35.9);
		
		
		System.out.println("Rectangle 1 Attributes");
		System.out.println("Width of Rectangle 1: " + rectangle1.width); // Outputs the width of Rectangle1
		System.out.println("Height of Rectangle 1: " + rectangle1.height);// Outputs the height of Rectangle1
		System.out.println("Area of Rectangle 1: " + rectangle1.getArea()); // Outputs the return value of our getArea Rectangle Class method
		System.out.println("Perimeter of Rectangle 1: " + rectangle1.getPerimeter()); // Outputs the return value of our getPerimeter
																					  // Rectangle Class method.
		
		System.out.println(); // Creates a space between the output for Rectangle 1 and Rectangle 2
		
		System.out.println("Rectangle 2 Attributes");
		System.out.println("Width of Rectangle 2: " + rectangle2.width); // Outputs the width of Rectangle2
		System.out.println("Height of Rectangle 2: " + rectangle2.height); // Outputs the height of Rectangle2
		System.out.println("Area of Rectangle 2: " + rectangle2.getArea()); // Outputs the return value of our getArea Rectangle Class method
		System.out.println("Perimeter of Rectangle 2: " + rectangle2.getPerimeter()); // Outputs the return value of our getPerimeter
		  																			  // Rectangle Class method.
		
	}
}

// Our Rectangle Class is defined with a default doubles width and height, set to a default value of 1
class Rectangle {
		
	double width = 1;
	double height = 1;
		
	// Our default, no-arg constructor for our rectangle, invoking this constructor will create a rectangle object with the default 
	// width of 1 and height of 1.
	Rectangle() {
		
	}
	
	// Our rectangle constructor that can take a custom width and custom height, entered as arguments when invoking the method to create a 
	// new rectangle object
	Rectangle(double newWidth, double newHeight) {
			
		width = newWidth; // The rectangle's width is equivalent to the newWidth argument passed into the method
		height = newHeight; // The rectangle's height is equivalent to the newHeight argument passed into the method
			
	}
	
	// this method returns the area of our rectangle object when invoked
	double getArea() {  
			
		return width * height;
			
	}
	
	// this method returns the perimeter of our rectangle object when invoked
	double getPerimeter() {
			
		return 2 * (width + height);
			
	}
}

