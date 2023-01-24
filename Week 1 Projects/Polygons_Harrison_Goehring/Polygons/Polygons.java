// Program created by: Harrison Goehring
// Date Created: January 15th, 2023

// This program takes in the number of sides for a polygon and outputs 
// the name of the polygon that has that number of sides.

// Imports the Java Scanner utility
import java.util.Scanner; 

public class Polygons {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); //Creates a new Scanner item
		
		// Prompts the user for the number of sides of a polygon.
		System.out.println("Enter the number of sides for a polygon between 3 and 12: ");
		int sides = input.nextInt(); //Stores the number of sides entered by the user
		
		// We use a switch statement to output the name of a polygon based on 
		// the number of sides entered by the user
		switch (sides) {
			
			case 3:
				System.out.println("Triangle");
				break;
			
			case 4: 
				System.out.println("Quadrilateral");
				break;
			
			case 5: 
				System.out.println("Pentagon");
				break;
			
			case 6: 
				System.out.println("Hexagon");
				break;
			
			case 7: 
				System.out.println("Heptagon");
				break;
			
			case 8: 
				System.out.println("Octagon");
				break;	
			
			case 9: 
				System.out.println("Nonagon");
				break;
			
			case 10: 
				System.out.println("Decagon");
				break;
			
			case 11: 
				System.out.println("Hendecagon");
				break;
			
			case 12: 
				System.out.println("Dodecagon");
				break;
			
				// The default case applies if the user enters an invalid number (1, 2, 13 or more), 
				// the program will display an error message if an invalid number is entered. 
			default:
				System.out.println("Error: You entered a number outside the range of this program");
				break;
			
		}
		
	input.close(); // Closes out Scanner item to prevent memory leak

	}
	
	
}
