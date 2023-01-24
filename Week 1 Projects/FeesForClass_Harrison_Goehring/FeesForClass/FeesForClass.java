// Program created by: Harrison Goehring
// Date Created: January 15th, 2023

// This program displays the total $ cost for a class that a company owes based off
// the user's input for the amount of students taking the class. To find the total cost, 
// the program will multiply the total number of students by the $42.75 per student cost.


// Import Scanner Utility to take in User Input
import java.util.Scanner;

public class FeesForClass {

	public static void main(String args[]) {
		
		// Our constant for the $ amount per person taking the class
		final double classFeeRate = 42.75;
		
		// Creates a Scanner item
		Scanner input = new Scanner(System.in);
		
		// Prompts the user to enter the number of students attending the class. The input is stored in a variable as an integer
		System.out.println("Enter the number of company members attending the class (Minimum of 1, Maximum of 25): ");
		int numOfStudents = input.nextInt();
		
		// While Loop checks to ensure the number of of students is not less than 1 and not more than 25
		// If the number of students is less than 1 or more than 25, it prints an error message and prompts the
		// user for an input between 1 and 25
		while (numOfStudents < 1 || numOfStudents > 25) {
			System.out.println("Error: Enter a number between 1 and 25: ");
			numOfStudents = input.nextInt();
		} // If our number of students is between 1 and 25, our program continues...
		
		// Casts the number of students variable as a double
		double numOfStudentsDouble = numOfStudents;
		
		// Calculates to total amount of $ due from the company by multiplying the double number of students and 
		// constant class fee per student of $42.75
		double totalCompanyOwes = numOfStudentsDouble * classFeeRate;
		
		// Prints the total $ amount to be paid by the company for the amount of students entered.
		System.out.print("The total amount the company owes for " + numOfStudents + " students attending the class is ");
		System.out.format("$%.2f", totalCompanyOwes); //Formats our printed total to 2 decimal places
		
		// Closes our Scanner item to prvent memory leak
		input.close(); 
		
	}
	
}
