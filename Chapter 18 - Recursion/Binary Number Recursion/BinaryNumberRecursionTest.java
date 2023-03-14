// Program created by: Harrison Goehring
// Date Created: March 14th, 2023

// This program will invoke a recursive method that returns a boolean value regarding whether or not an integer entered by the user is a binary multiple or not.
// Once the number is checked, the program will print whether or not the integer is a binary multiple to the console.

import java.util.Scanner; // Imports our Scanner utility.

// Our main method
public class BinaryNumberRecursionTest {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); // Creates our scanner object.
		
		System.out.print("Enter an integer number: "); // Prompts the user to enter an integer number.
		long num = input.nextInt(); // Stores our user's integer input into the num variable as a long type, binary multiples grow exponentially so our user input 
									// could be quite large.
		
		// If-Else statement that initializes the isBinaryMultiple recursive function with our user's input num as an argument.
		// If the method returns true, the console outputs that the number is a binary multiple. If the method returns false, the console outputs
		// that the number is not a binary multiple.
		if (isBinaryMultiple(num)) {
			System.out.print("The number is a binary multiple!");
		} else {
			System.out.print("The number is not a binary multiple!");
		}
		
	}
	
	public static boolean isBinaryMultiple(long num) {
		if (num == 2) { // base case, if our user's number is 2, we know it is a binary multiple.
			return true;
		} else if (num < 2) { // base case, if our user's number is 1 or 0, we know it is NOT a binary multiple. 
			return false;
		} else if (num % 2 != 0) { // base case, if our user's input is odd, we know it isNOT a binary multiple.
			return false;
		} else {
			return isBinaryMultiple(num / 2); // our recursive call of our method, on each iteration we divide our user's number by 2 until it hits the above base cases.
		}									  
											  // Note: if our number is a binary multiple, the user's number will eventually be divided by 2 until num actually becomes the value of 2.
											  // This is because all binary multiples are base 2.
	}
}