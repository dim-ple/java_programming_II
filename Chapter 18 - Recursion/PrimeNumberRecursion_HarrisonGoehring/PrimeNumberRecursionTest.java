// Program created by: Harrison Goehring
// Date Created: March 13th, 2023

// This program will invoke a recursive method that returns a boolean value regarding whether or not an integer entered by the user is a prime number or not.
// Once the number is checked, the program will print whether or not the integer is a prime number to the console.

import java.util.Scanner; // Imports our Scanner utility.

public class PrimeNumberRecursionTest {
	
	// Our main method
	public static void main(String[] args) {
		
		int counter = 2; // Create our counter variable which will be used in our recursive isPrime method
		
		Scanner input = new Scanner(System.in); // Creates our scanner object.
		
		System.out.print("Enter an integer number: "); // Prompts the user to enter an integer number.
		int num = input.nextInt(); // The user's input will be stored in a the num variable to be used in our isPrime recursive method.
		
		// If-Else statement that initializes the isPrime recursive function with our user input and counter variable as arguments.
		// If the method returns true, the console outputs that the number is prime. If the method returns false, the console outputs
		// that the number is false.
		if (isPrime(num, counter)) {
			System.out.print("The number is prime!");
		} else {
			System.out.print("The number is not prime!");
		}
		
	}
	
	// Our isPrime recursive method will return a boolean true if the number is prime and false if the number is not prime.
	// This method is based off of the method I created in Week 6 of our class where we were asked to create a method that would
	// determine if a number was prime or not. I used an iterative method for that exercise which I 
	public static boolean isPrime(int num, int i) {
		
		if (num <= 2) { // base case, we know that 0 and 1 are not prime
			return (num == 2) ? true : false; // With the recursive version of this function, we need to create some type of exception for the number 2 as it is a prime number
											  // but will return false/not prime even if we make the if condition "num < 2" as our next base case returns false if our remainder is 0.
											  // the nested if-else shorthand helps us create an exception for the number 2 so it does show as prime when entered by the user.
			
		} else if (num % i == 0) { // base case
			return false; // Checks to see if our number, divided by our i counter variable, has no remainder. If so, the number is not prime. 
			
		} else if (i > Math.sqrt(num)) { // base case
			return true; // Checks to see if i is larger than the square root of our number, if so the number is prime
			
		} else { // our recursive call
			return isPrime(num, i + 1); // In our recursive call, we iterate i by 1 on each call
		}

	}

}
