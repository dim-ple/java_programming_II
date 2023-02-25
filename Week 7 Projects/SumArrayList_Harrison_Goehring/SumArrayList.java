// Program created by: Harrison Goehring
// Date Created: February 25th, 2023

// This program takes 5 numbers entered by a user and stores them in an ArrayList. Using a method, we then take all of the numbers
// stored in the ArrayList and find their sum.

import java.util.Scanner; // Imports our scanner module which will allow user input through the console.
import java.util.ArrayList; // Imports our ArrayList module which we will use to store 5 values entered by the user.


public class SumArrayList {
	
	// Our main method which prompts the user for 5 values and adds them to our ArrayList. At the end of ther main method, we run our sum method to
	// display the sum of our ArrayList and display it to the console.
	public static void main(String[] args) {
		
		ArrayList<Double> list = new ArrayList<>(); // Creates our ArrayList object
		double temp; // Creates a temporary double variable that will be used to hold the users input for storage in the ArrayList
		Scanner input = new Scanner(System.in); // Creates our scanner object so we may take in user input
		
		System.out.println("This program takes 5 values entered by the user and outputs the sum of those 5 numbers.");
		
		// We use a for-loop to collect 5 values from the user and store them into the ArrayList. The loop terminates once 5 values are collected.
		for (int i = 1; i <= 5; i++) {
			System.out.print("Enter value " + i + " of 5: "); //The loop prints a message to help the user track how many values they've entered
			temp = input.nextDouble(); // The user's input is then stored in the temp variable
			list.add(temp); // the temp variable/user input is added to the ArrayList
		}
		
		System.out.print("The sum of the 5 values you entered is: " + sum(list)); // The program then displays the sum of the 5 values entered by the user to the console
																				  // by invoking the sum method we created, using our ArrayList as an argument.
		
	}
	
	// Our sum method which will add each value of the ArrayList to calculate the sum of its contents
	public static double sum(ArrayList<Double> list) {
		double sum = 0; // Create our sum variable which we will return at the end of the method
		
		// Using a for-loop, we iterate through the entire ArrayList (using the size() getter) to add each value at index value i to the sum variable. 
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		
		return sum; // once the loop terminates, we then return our sum
	}
}
