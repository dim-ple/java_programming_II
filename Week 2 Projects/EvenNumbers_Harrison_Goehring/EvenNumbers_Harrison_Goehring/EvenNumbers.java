// Program created by: Harrison Goehring
// Date Created: January 19th, 2023

// This program takes two numbers from the user which will establish a range of numbers. The user will be asked to provide a 
// the lowest value in the range and the highest value in the range. The program will then create an array of values between the 
// low value and high value (inclusive of those two values), iterates through all the values in the range and returns the sum of 
// all even numbers in the range.

import java.util.Scanner; // Import our Java Utility Scanner

public class EvenNumbers {
	
	public static void main(String args[]) {
		
		Scanner input = new Scanner(System.in); // Creates our new scanner item
		
		// Prompts the User for the Low Extreme of our range
		System.out.print("Enter a low number: "); 
		int lowNum = input.nextInt(); // Stores our user input for the Low Extreme of our range
		
		// Prompts the User for the High Extreme of our range
		System.out.println("Enter a high number (this should be higher than " + lowNum + "):"); 
		int highNum = input.nextInt(); // Stores our user input for the High Extreme of our range
		
		// While-loop checks to ensure our Higher extreme is actually larger than our Lower extreme.
		// If the Higher extreme is greater than the Lower extreme, we proceed with our program.
		while (lowNum >= highNum) {
			System.out.println("Error: Enter a number higher than " + lowNum + ": "); // Prompts the User for the High Extreme of our range
			highNum = input.nextInt(); // Stores our user input for the High Extreme of our range
		}
		
		int[] range = createRange(lowNum, highNum); // Our createRange method will return an integer array which we will assign to the 
													// range variable.
		
		int i = 0; // Counter Variable for our While Loop
		int sumOfEvenNums = 0; // Variable to track the Sum of even numbers in our range
		
		// While-loop executes as long as our counter variable is less than the length of our range array
		while (i < range.length) {
			
			// If conditional checks if the integer recorded in each index of the range array is even.
			// We check this by getting running the integer modulus 2. If the result of this equation is 0
			// we add the integer from the selected index of range to our Even Numbers Sum variable.
			if (range[i] % 2 == 0) {
				sumOfEvenNums += range[i];
			}
			
			i++; // We will increment the counter variable to allow us to iterate through all index values of the range array
				 // Once our counter variable becomes larger than the length of the range array, the program exits the while-loop
		}
		
		// Prints to the console the sum of all even numbers in the range between our user's low and high number inputs
		System.out.println("The sum of all even numbers between " + lowNum + " and " + highNum + " is " + sumOfEvenNums);
	
		
		input.close(); // Closes our scanner item to prevent memory leak
		
	}

	// I wanted to create a method that could return an array with a range of integers between the
	// two integer numbers the user had input at the very beginning of the program. The createRange method takes
	// a Low number extreme of our range and High number extreme of our range as arguments.
	public static int[] createRange(int lowNum, int highNum) {
	
		// It then declares an empty integer array with a length equivalent to the total number of integers 
		// between the Low and High numbers.
		int[] range = new int[(highNum - lowNum) + 1];
		
		// The method then uses a for-loop to iterate through each index of the array. 
		// It begins by assigning the first index to the Low number argument passed into the method. 
		// At the end of each iteration, we add 1 to the Low number argument.
		for (int j = 0; j < range.length; j++) {
			range[j] = lowNum;
			lowNum++;
		} // The for-loop will continue until our counter variable becomes equal to the length of our 
		  // range. At this point, we will have assigned a number to each index of the array.
		
		return range; // We return our completed array!

	}

}