// Program created by: Harrison Goehring
// Date Created: January 30th, 2023

// This program allows the user to pick a low and high number. It will then generate 10 random numbers within
// the range specified by the user. Those 10 random numbers will be stored in an array and the contents will
// be printed to the console.

import java.util.Scanner; // Imports our scanner utility so we can take in user input.


public class RandomNumbers {
	
	public static void main(String[] args) {
		
		// This first chunk of code I took from my previous EvenNumbers program/assignment as
		// it has a very similar user display and input system.
		
		Scanner input = new Scanner(System.in); // Creates our new scanner item
		
		// Prompts the User for the Low Extreme of our range
		System.out.println("This program will give you random numbers within the range you specify.");
		System.out.println("Enter your low extreme: "); 
		int lowExtreme = input.nextInt(); // Stores our user input for the Low Extreme of our range
		
		// Prompts the User for the High Extreme of our range
		System.out.println("Enter your high extreme (this should be higher than " + lowExtreme + "): "); 
		int highExtreme = input.nextInt(); // Stores our user input for the High Extreme of our range
		
		// While-loop checks to ensure our Higher extreme is actually larger than our Lower extreme.
		// If the Higher extreme is greater than the Lower extreme, we proceed with our program.
		while (lowExtreme >= highExtreme) {
			System.out.println("Error: Enter a number higher than " + lowExtreme + ": "); // Prompts the User for the High Extreme of our range
			highExtreme = input.nextInt(); // Stores our user input for the High Extreme of our range
		}
		
		int[] randomRange = getTenRandomNums(lowExtreme, highExtreme); // Invokes our Ten Random Numbers Method
															   		   // with the low and high extremes as arguments
		
		// System will output the below message followed by each random number stored in the
		// array returned from our Ten Random Numbers method. 
		System.out.print("Your ten random numbers between " + lowExtreme + " and " + highExtreme + " are: ");
		
		// The for-loop iterates through each index of the array and prints the value stored to the console.
		for (int j = 0; j < randomRange.length; j++) {
			
			System.out.print(randomRange[j] + " ");
			
		}
		

	
	
	}
	
	private static int[] getTenRandomNums(int lowExtreme, int highExtreme) {
		// Creates an array with a size of 10 
		int[] range = new int[10];
				
		// For-loop used to iterate through our array, assigning random numbers within our user's 
		// to each array index as 
		for (int i = 0; i < range.length; i++) {
			
			// For each iteration, we use the Math.random method to generate a
			// random double between 0 and 1. We then multiply the result of the Math.random
			// method (our double between 0 and 1) by the length of our range. This will give us 
			// a number between 0 and our highExtreme. We add our lowExtreme to the random number to 
			// ensure we increase the lowExtreme from the first part of our equation from 0 to the value of our 
			// lowExtreme or minimum that our user input. This number is then assigned to an array index.
			range[i] = (int)Math.floor(Math.random() * (highExtreme - lowExtreme + 1) + lowExtreme);
			
			}
		
		return range;
	}

}
