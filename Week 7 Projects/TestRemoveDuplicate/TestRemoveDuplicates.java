// Program created by: Harrison Goehring
// Date Created: February 28th, 2023

// This program takes 10 integers from the user and stores them in an ArrayList object. The program then uses a defined method that will
// remove any duplicate integers from the list. The program will then output the distinctly unique numbers entered by the user to the console
// in the order that they were entered.

import java.util.ArrayList; // Imports our ArrayList tool so we can store values
import java.util.Scanner; // Imports our scanner tool so we can take user input


public class TestRemoveDuplicates {
	
	
	public static void main(String[] args) {
		
		ArrayList <Integer> list = new ArrayList<>(); // creates a new ArrayList object which will store our integers
		int temp; // creates a temporary variable that will hold our user's inputs, to be added to our ArrayList
		Scanner input = new Scanner(System.in); // creates a new Scanner object 
		
		System.out.println("This program takes 10 integers entered by the user and prints only the distinctly unique integers to the console.");
		
		// We use a for-loop to collect 10 values from the user and store them into the ArrayList. The loop terminates once 10 values are collected.
		// On every iteration, the user is prompted to enter in i value out of 10. On every user input, the user's integer input is stored in our 
		// ArrayList.
		for (int i = 1; i <= 10; i++) {
			System.out.print("Enter value " + i + " of 10: "); //The loop prints a message to help the user track how many values they've entered
			temp = input.nextInt(); // The user's input is then stored in the temp variable
			list.add(temp); // the temp variable/user input is added to the ArrayList
		}
		
		// Initializes our method to remove any duplicate numbers from our ArrayList. The method
		// does not return a new ArrayList. Rather, it amends the existing argument list.
		removeDuplicates(list);
		
		
		System.out.print("The distinctly unique numbers entered by the user are as follows: ");
		
		// For-loop iterates through each index value of the list with it's duplicates removed and prints the values to the console.
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		
	}
	
	public static void removeDuplicates(ArrayList<Integer> list) {
		
		// Created a new ArrayList object where we will copy the values from our argument ArrayList to
		ArrayList <Integer> copiedArray = new ArrayList<>();
		
		copiedArray.addAll(list); // We copy all the values stored in the argument ArrayList to our temporary ArrayList
		
		list.clear(); // We use the clear method to remove all values from the ArrayList were removing duplicates from
		
		// Using a for-loop, we will iterate through the entire temporary array. On each iteration, we check to see if our
		// argument ArrayList already contains the value at whatever the current index of the temporary array is. If the value is not already 
		// contained in our argument ArrayList, it is added to the argument ArrayList. If the value is contained in our argument ArrayList,
		// we don't add the value to the list and move onto the next value in the temporary array
		for (int i = 0; i < copiedArray.size(); i++) {
			if (!list.contains(copiedArray.get(i))) {
				list.add(copiedArray.get(i));
			}
		}
		
	}
}
