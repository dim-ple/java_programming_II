// Program created by: Harrison Goehring
// Date Created: February 16th, 2023

// This program takes a predefined 2-D array and uses a series of methods to calculate the sum and average of the array's values, 
// the minimum & maximum values stored in the array, and the number of stored values in the array greater than 50. Once all the values
// are calculated, the program will print the results to the console.


public class ArrayCalculations {
	
	// Our main method that will run procedurally through our defined methods below
	public static void main(String[] args) {
	
		// Creates our 4x5 two dimensional array with some values
		int[][] twoDArray = {
				{16, 22, 54, 25, 41},
				{63, 91, 62, 42, 28},
				{98, 85, 13, 83, 33},
				{91, 58, 16, 23, 11}
		};
		
		int sum = twoDSum(twoDArray); //initializes our sum variable with the return of the twoDSum method
		double average = twoDAverage(twoDArray, sum); //initializes our Average variable with the return of the twoDAverage method
													  //we use our sum variable initialized previously as an argument for the method 
		int max = twoDMax(twoDArray); //initializes our max variable with the return of the twoDMax method
		int min = twoDMin(twoDArray); //initializes our min variable with the return of the twoDMin method
		int numOfValuesOver50 = countNumOfValuesOver50TwoD(twoDArray); //initializes our numOfValuesOver50 variable with 
																       //the return of the countNumofValuesOver50TwoD method
		
		System.out.print("The current values in our list are: "); // Console prompt to let our user know what values are contained in
																  // our 2-D array.
		
		// This nested for-loop iterates through all values in our 2-D array and prints them to the console
		for (int row = 0; row < twoDArray.length; row++) {
			for (int column = 0; column < twoDArray[0].length; column++) {
				System.out.print(twoDArray[row][column] + " "); // prints the value for the current 2-D array index to the console
			}
		}
		
		System.out.println(); // Starts a new line to help format the console results
		
		// Prints the result of our twoDSum method to the console
		System.out.print("The Sum of the numbers in the list is ");
		System.out.print(sum);
		
		System.out.println(); // Starts a new line to help format the console results
		
		// Prints the result of our twoDAverage method to the console
		System.out.print("The Average of the numbers in the list is ");
		System.out.format("%.2f", average);
		
		System.out.println(); // Starts a new line to help format the console results
		
		// Prints the result of our twoDMax method to the console
		System.out.print("The Maximum value in the list is ");
		System.out.print(max);
		
		System.out.println(); // Starts a new line to help format the console results
		
		// Prints the result of our twoDMin method to the console
		System.out.print("The Minimum value in the list is ");
		System.out.print(min);
		
		System.out.println(); // Starts a new line to help format the console results
		
		// Prints the result of our countNumOfValuesOver50TwoD method to the console
		System.out.print("There are " + numOfValuesOver50 + " numbers in the list over 50");
		
	}


	private static int twoDSum(int[][] twoDArray) {
		
		int sum = 0; // Initializes an integer sum variable beginning at 0 that we will return at the end of our method
		
		// For-loop that will iterate through each row in the 2-D array, with a nested For-Loop that will iterate through
		// all columns of the current index row. The nested for-loop will terminate once the length (or number of columns) of the row 
		// has been reached and the parent for-loop will terminate once the number of rows has been reached.
		for (int row = 0; row < twoDArray.length; row++) {
			for (int column = 0; column < twoDArray[0].length; column++) {
				sum += twoDArray[row][column]; // as each value of the current row and column index for the 2-D array is added to
										       // the sum variable.
			}
		}
		
		return sum; // once the loop terminates, the method will return the sum variable which contains the sum of all values in the
					// 2-D array.
	}

	// Create our method that will calculate the average of the values within the 2-D Array. This method will take
	// a 2-D array as an argument, as well as an integer sum (which we will procedurally define before we run this method in the main) 
	private static double twoDAverage(int[][] twoDArray, int sum) {
		
		double average = 0; // Initializes an integer sum variable beginning at 0 that we will return at the end of our method
		double numOfValues = 0; // Initializes a counter variable that will help us to keep track of the number of values in the
								// 2-D array
		
		// We use the same nested For-Loop from our twoDSum method to iterate through all indexes of the 2-D array
		for (int row = 0; row < twoDArray.length; row++) {
			for (int column = 0; column < twoDArray[0].length; column++) {
				numOfValues++;	// For every iteration we increment the numOfValues variable by 1, counting each value
								// to use later in our calculation for the average of the 2-D array
			}
		}
		
		average = sum / numOfValues; // Calculates our average by dividing our sum argument by the number of values
									 // within the 2-D array.
		
		return average; // returns our average
	}

	// Create our method that will find the max value within the 2-D Array. We are only using the 2-D array as an argument.
	private static int twoDMax(int[][] twoDArray) {
		
		int max = twoDArray[0][0]; // Initializes an integer variable which will hold our maximum value
					 			   // We assign the variable the value of the first index of the 2-D array.
		
		// We use the same nested For-Loop from our twoDSum method to iterate through all indexes of the 2-D array
		for (int row = 0; row < twoDArray.length; row++) {
			for (int column = 0; column < twoDArray[0].length; column++) {
				if (max < twoDArray[row][column]) {
					max = twoDArray[row][column]; // For every iteration, we use a conditional if statement to check if
												  // the current value stored in the max variable is less than the current
												  // 2-D array value at its current index. If max is less than that value, 
												  // the 2-D array value at that index is assigned to the max variable.
				}
			}
		}
		
		return max; // returns our maximum value in the 2-D array
	}

	// Create our method that will find the minimum value within the 2-D Array. We are only using the 2-D array as an argument.
	private static int twoDMin(int[][] twoDArray) {
			
		int min = twoDArray[0][0]; // Initializes an integer variable which will hold our minimum value
								   // We assign the variable the value of the first index of the 2-D array.
			
		for (int row = 0; row < twoDArray.length; row++) {
			for (int column = 0; column < twoDArray[0].length; column++) {
				if (min > twoDArray[row][column]) {
					min = twoDArray[row][column]; // For every iteration, we use a conditional if statement to check if
					  							  // the current value stored in the min variable is greater than the current
					  							  // 2-D array value at its current index. If min is greater than that value, 
					  							  // the 2-D array value at that index is assigned to the min variable.
				}
			}
		}
	
		return min;	// returns our minimum value of the 2-D Array
	}

	// Create our method that will count how many values within our 2-D array are over the value of 50. We use
	// a 2-D array as an argument for this method
	private static int countNumOfValuesOver50TwoD(int[][] twoDArray) {
		
		int numOfValuesOver50 = 0; // We create a counter variable that starts at 0
		
		// We use the same nested for-loop from our previous methods that will iterate through all
		// values stored in the 2-D array.
		for (int row = 0; row < twoDArray.length; row++) {
			for (int column = 0; column < twoDArray[0].length; column++) {
				// We use an If conditional statement to compare the current 2-D array index value to the value of 50
				// If the current index value is over 50, we increment our counter variable by 1.
				if (twoDArray[row][column] > 50) {
					numOfValuesOver50++;
				}
			}
		}
		
		return numOfValuesOver50; // returns our counter variable with the total number of values in the 2-D array greater than 50
	}

}