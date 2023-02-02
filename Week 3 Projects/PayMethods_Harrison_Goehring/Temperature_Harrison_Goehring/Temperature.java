// Program created by: Harrison Goehring
// Date Created: February 2nd, 2023

// This program takes in a user input temperature degree and the scale (Fahrenheit or Celsius) at which
// the temperature is measured. The program then converts the temperature degree into the other scale. 
// For example, a temperature degree entered with the Fahrenheit scale will be converted into its Celsius scale equivalent. 
// Alternatively, a temperature degree entered with the Celsius scale will be converted into its Fahrenheit scale equivalent.
// Once the conversion completes, the converted temperature will be output to the console.


import java.util.Scanner; // Imports our scanner utility so we can take in user input.

public class Temperature {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); // Creates our new scanner item
		
		System.out.println("Welcome to the Temperature Convertor!"); // Welcome message to the user.
		// Prompts the user for their temperature degrees
		System.out.println("Enter your temperature degree number (You may enter numbers with decimals): ");
		double temp = input.nextDouble(); // Takes the user's input as a double
		
		
		
		// Prompts our user for the temperature scale their entry is in.
		System.out.println("Are your degrees in Fahrenheit or Clesius (Enter F for Fahrenheit and C for Celsius): ");
		
		// Takes the user's input, calls the first character of the user's input
		// and stores it as a character in our tempScale variable. I am using the charAt function to
		// handle user input errors where they may enter the full words 'Fahrenheit' or 'Celsius'
		// when the program just wants a single character, 'F' or 'C'. Lastly, I use the toUpperCase
		// method to ensure the first character entered will not be case sensitive.
		char tempScale = input.next().charAt(0);
		tempScale = Character.toUpperCase(tempScale);
		
		// While-loop checks to see if the user's temperature scale input is not equivalent to the
		// Farhenheit and Celsius characters. If the user's input does not match either 'F' for Fahrenheit 
		// and 'C' for Celsius, the While-loop continues to execute until the user enters 'F' or 'C'.
		while (tempScale != 'F' && tempScale != 'C') {
			
			// Error message is displayed to the user if they did not enter an appropriate tempScale entry
			System.out.print("You entered an invalid temperature scale. Please enter either F for Fahrenheit or C for Celsius.");
			tempScale = input.next().charAt(0); // Takes the user's input and stores it in our tempScale variable
			tempScale = Character.toUpperCase(tempScale); // Converts our tempScale character to upper case
		}
		
		
		// Conditional logic will confirm whether 'F' or 'C' was entered. Depending on the entry stored to 
		// our tempScale variable, the conditional will determine if our conversion will be from Fahrenheit to Celsius
		// or from Celsius to Fahrenheit.
		if (tempScale == 'F') { 
			// if our tempScale variable is 'F', we will run our convertToCelsius method
			// and will print the output of the conversion, formatted to 1 decimal place,
			// to the console.
			System.out.print(temp + " degrees Fahrenheit converted to Celsius would be ");
			System.out.format("%.1f", convertToCelsius(temp)); 
			System.out.print(" degrees Celsius.");
		} else {
			// if our tempScale variable is 'C', we will run our convertToFahrenheit method
			// and will print the output of the conversion, formatted to 1 decimal place,
			// to the console.
			System.out.print(temp + " degrees Celsius converted to Fahrenheit would be ");
			System.out.format("%.1f", convertToFahrenheit(temp));
			System.out.print(" degrees Fahrenheit.");
		} 
		
			
	}
	
	// Our method to convert from Fahrenheit to Celsius
	// The method takes one argument (the double temperature)
	// that we need to convert and returns the converted double
	// in degrees Celsius.
	private static double convertToCelsius(double temp) {
		double celsiusTemp = (temp - 32) * 5/9;
		
		return celsiusTemp;
	}
	
	
	// Our method to convert from Celsius to Fahrenheit
	// The method takes one argument (the double temperature)
	// that we need to convert and returns the converted double
	// in degrees Fahrenheit.
	private static double convertToFahrenheit(double temp) {
		
		double fahrenheitTemp = (temp * 9/5) + 32;
		
		return fahrenheitTemp;
	}
}


