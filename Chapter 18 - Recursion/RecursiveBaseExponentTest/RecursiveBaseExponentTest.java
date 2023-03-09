// Program created by: Harrison Goehring
// Date Created: March 9th, 2023

// This program takes a base integer and exponent integer from the user. It then outputs the result of the base integer raised to the power of the exponent integer
// using a recursive method.

import java.util.Scanner; // imports our scanner tool

public class RecursiveBaseExponentTest {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); // creates our scanner object so we can take in user input
		
		System.out.print("Enter your base as an integer: "); // Prompts the user for a base integer which is stored in our bas variable
		int bas = input.nextInt();
		
		System.out.print("Enter an exponent integer that is equal to or greater than 1: "); // Prompts the user for an exponent integer greater than 1 and stores it in our expon variable
		int expon = input.nextInt();
		
		// while-loop checks to see if the user entered integer for our exponent is less than 1, if it is, the while-loop will continue to print an error message
		// and will collect inputs from the user until an exponent integer that is equal to or greater than 1 is entered.
		while (expon < 1) {
			System.out.print("Error: Enter an exponent integer equal to or greater than 1: ");
			expon = input.nextInt();
		}
		
		System.out.print("The output of base " + bas + " to the " + expon + " power is " + recurexpon(bas, expon)); // main method outputs the result of our recursive exponent method to the console.
		
	}
	
	// our Recursive Exponent method, takes in a base number and exponent as integers and will return a long as the results of 
	// raising integers by a power can result in numbers larger than those contained in the integer data type. The recursive call
	// decrements our exponent by one until the exponent value reaches 0 which is our base or stopping case for the method.
	public static long recurexpon(int bas, int expon) {
		
		if (expon == 0) { // our base case for the recursive method 
			return 1;
		} else if (expon == 1) { 
			return bas; // If our exponent value is equal to 1, any integer to the power of 1 returns itself
		} else {
			return bas * recurexpon(bas, expon - 1); // our recursive call of the factorial method
		}
		
	}
}
