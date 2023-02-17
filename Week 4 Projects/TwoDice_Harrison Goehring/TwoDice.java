// Program created by: Harrison Goehring
// Date Created: February 17th, 2023

// This program will count and output the frequency at which certain dice roll outcomes will occur when dice or die are rolled 500
// times. For this particular main method, we chose to simulate rolling 2 die and utilized all possible outcomes for a 2 die roll
// in an array that was passed to a method. This method would count the times each outcome was rolled and would return the count in another
// integer array. The results stored in the array and frequency of the outcome rolls are then printed to the console.


public class TwoDice {

	// Our main method - within the main, we will call our DiceRoll method and will print the results to the console.
	public static void main(String[] args) {
		
		int[] possibleOutcomes = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}; // Create our size 11 integer array which stores the possible outcome sums
																	   // when two die are rolled (2 through 12)
		
		int[] results = DiceRoll(possibleOutcomes); // Calls our DiceRoll method with our possibleOutcomes array as our argument and then
													// saves the results of the DiceRoll method to a new array
	
		// Outputs a welcome message that explains what the program will be outputting to the console
		System.out.println("This program simulates two die rolled a total of 500 times. The results of each outcome is as follows: ");  
		
		// Created a For-Loop to iterate through the results array and possibleOutcomes arrays, out putting the values to the console.
		// I also added a double variable to determine each outcomes percentage frequency that it was rolled for output to the console.
		for (int i = 0; i < possibleOutcomes.length; i++) {
			
			double frequencyPercentage = (results[i] / 500.00) * 100.00; // Created a variable that takes the amount of times each outcome was rolled,
																		 // divides it by the total times rolled (500), then multiplies the result by 100
																		 // to get a the percentage frequency the out come was rolled.
			
			System.out.print("A roll of " + possibleOutcomes[i] + " was rolled " + results[i] + " times out of 500, or ");
			
			System.out.format("%.1f", frequencyPercentage);
			System.out.println("% of the time.");
		}
	}
	
	// This method takes an integer array of possible outcomes of rolled die and returns another integer array with the amount of times each outcome was rolled.
	// I wanted to create a method that could be re-used no matter what the size of the argument array of possible outcomes.
	// The number of rolls is pre-determined to be 500, so I would like to later revise this method to prompt the user for their desired amount of rolls. Additionally,
	// might need to explore a sorting method to make unordered arrays work with this method.
	private static int[] DiceRoll(int[] diceOutcomes) {
		
		int[] countOfOutcomes = new int[diceOutcomes.length]; // Creates our integer array which we will return by the end of our method.
															  // the return array length should be equivalent to the integer array passed
															  // to our method as an argument. This array will count how many times the corresponding
															  // index value from the argument array has been rolled out of 500 rolls.
		
		// Now that our outcome count array has been established, I created a for-loop to iterate a total of 500 times.
		// On each iteration, I used the Math.random  method to generate a random double between 0 and 1 and our Math.floor method to 
		// eliminate any decimals. We then multiply the result of the Math.random() method by the length of our array. Now we have a number
		// between 0 and the length of our array. We will then need to add our lowest value of the diceOutcome array, or our minimum for our range.
		// Once the equation is completed, we will have a random number between 2 and 12 for the specific array passed through our main method.
		for (int j = 0; j < 500; j++) {
			
			int outcome = (int)Math.floor(Math.random() * (diceOutcomes[diceOutcomes.length - 1] - diceOutcomes[0] + 1) + diceOutcomes[0]);
			
			
			// Created a nested for-loop which checks to see if the random number we generated matches any of the values in the 
			// passed argument array. If so, that matching index value for the counter array will be incremented by 1.
			for (int k = 0; k < diceOutcomes.length; k++) { 
				if (outcome == diceOutcomes[k]) {
					countOfOutcomes[k]++;
				}
			}	
		}
		
		return countOfOutcomes; // we return our counter array once finished
	}
	
}
