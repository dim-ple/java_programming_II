// Program created by: Harrison Goehring
// Date Created: January 23rd, 2023

// This program takes an integer number from the user and creates an X-by-X 
// checker board in the console, where X is the number entered by the user.

import java.util.Scanner; // Import our Java Utility Scanner,
						  // will allow us to create a scanner item and take user input

public class Checkers {
	
	public static void main(String []args) {
       
		Scanner input = new Scanner(System.in); // Creates our scanner item
        
        char asterisk = '*'; // Declaring our board character to represent a filled-in square
        					 // of a checker board
        
        // A prompt to the user explaining how the program will work
        System.out.println("This program will be create an X-by-X checkerboard, where"
        		+ " X is the integer number you input."); 
        
        // A prompt to our user asking for an integer greater than 0
        System.out.println("Enter an integer number greater than 0: ");
        int x = input.nextInt(); // Our user's input is stored in the variable 'x'
        
        // While-loop checks to see if the integer entered by the user is less than
        // or equal to 0. If so, the console will print an error message until the
        // user enters an integer greater than 0
        while (x <= 0) {
        	System.out.println("Error: Enter an integer number greater than 0: ");
        	x = input.nextInt();
        }
        
        System.out.println(); // Prints a blank line for better user readability
		
        // I created a for-loop to iterate an equal amount of times to the number
        // entered in by our user. This for-loop will create our rows for the checker
        // board.
        for (int i = 1; i <= x; i++) { // I chose to make my counter variable i equal to 1 
        							   // which represents our row number for the checker board.
            						   // This is so that the program could differentiate between even and 
        							   // odd rows. If my counter variable had been 0, my checker
        							   // board would not have filled in properly.
        	            	
            if (i % 2 == 0) { // Conditional statement to determine if the row number (i counter) is even or odd
                   
            	// If the row is even, for each row we print our asterisk followed  
            	// by our empty space X amount of times on the same line
            	for (int j = 0; j < x; j++) { 
                       System.out.print(asterisk + " ");
                  }
               } else { // If the row is odd, for each row we print our empty space
            	   		// followed by our asterisk X amount of times on the same line
                   for (int j = 0; j < x; j++) {
                       System.out.print(" " + asterisk);
                  }
               }
        	
            System.out.println(); // Once every iteration of of the initial for-loop completes,
            					  // we jump to the next line or row
        }
        
        input.close(); //Closes scanner item to prevent memory leak
            
    }

}