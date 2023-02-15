// Program created by: Harrison Goehring
// Date Created: February 14th, 2023

// This program populates 3 arrays. One single-dimension array contains all even numbers in the range of numbers 1 through 12. Another
// single-dimension array will be populated with all odd numbers in the range of numbers 1 through 12. Lastly, the program will then
// populate a two-dimensional array with the values of the odd and even number arrays multiplied by each other and organized into a 
// matrix that forms a multiplication table or multiplication table array. The program then prints the results of of the multiplication table
// to the console in an organzied manor.

public class ArrayMultiplicationTable {

	public static void main(String[] args) {
		int[] evenNumbers = new int[6]; //Creates an array with a length of 6 that will hold even numbers between 1 and 12
		int[] oddNumbers = new int[6]; //Creates an array with a length of 6 that will hold odd numbers between 1 and 12
		int[][] multiplicationTable = new int[6][6]; //Creates a 2-D array that will hold our even times odd numbers
		
		int currentIndex = 0; // Create a counter variable to be used for the index of our odd and even arrays
							  // that are populated using the below for-loop
		
		// Using a For-Loop where the i-counter starts at 1 (our first number in our 1 - 12 range) and stops iteration
		// once the i-counter is greater than 12, our last number in our range.
		for (int i = 1; i <= 12; i++) {
			// On every iteration, the loop uses a If-Else conditional to determine if the number is even.
			// if the number is even, the loop adds the value of the i-counter to the evenNumber array at
			// currentIndex's position in the array. The currentIndex is then incremented by 1
			if (i % 2 == 0) {
				evenNumbers[currentIndex] = i;
				currentIndex++;
			} else { 
				oddNumbers[currentIndex] = i; // If the number is odd, the value of the i-counter is assigned to the oddNumber array at currentIndex's position in the array.
				 							  // The currentIndex is not incremented by 1 here as out i-counter starts at 1 which is an odd number. The conditional logic allows for
				 							  // the oddNumbers array to be populated first, followed by the evenNumbers array until all the numbers between 1 and 12 have been cycled 
				 						      // through.
			}
		}
		
		
		// This For-Loop iterates through our each "row" of our 2-D Array. It executes its post-increment
		// once the nested For-Loop iterates though all "columns" of the row.
		for (int row = 0; row < multiplicationTable.length; row++) {
			// In the nested for-loop, we iterate through the values in the evenNumbers array by making 
			// "column" the index value for the evenNumbers array. We then multiply each evenNumber array value by our
			// oddNumbers array value which will have an index value equal to the "row" value. This will allow us to
			// fill out each row with 6 column values as the row value will not be incremented until all columns of the first
			// row are filled.
			for (int column = 0; column < multiplicationTable.length; column++) {
				multiplicationTable[row][column] = evenNumbers[column] * oddNumbers[row];
			}
		}
			
		
		
		System.out.print("    "); // creates space needed to properly align our first column heading
		
		// This for-loop populates our column headings. We use If-Else logic to make sure proper
		// spacing is used for single and double digit character numbers displayed in the console 
		for (int j = 0; j < evenNumbers.length; j++) {
			if (evenNumbers[j] < 9) { // if the column header number is 1 digit, the spacing after the result is 3 characters wide
				System.out.print(evenNumbers[j]);
				System.out.print("   ");
			} else { // if the column header number is 2 digits, the spacing after the result is only 2 characters wide
				System.out.print(evenNumbers[j]);
				System.out.print("  ");
			}
		}
		
		// after the for-loop, we jump down two lines to properly space our next row
		System.out.println();
		System.out.println();
		
		// this for-loop begins by printing the row number, checks it's digit length for proper space formatting using
		// an if-else conditional, then uses a nested for-loop to print the row's columns.
		for (int row = 0; row < oddNumbers.length; row++) {
			System.out.print(oddNumbers[row]);
			if (oddNumbers[row] < 10) {
				System.out.print("   ");
			} else {
				System.out.print("  ");
			}
			// this for-loop is intended to print the column values for the current row from the parent for-loop by calling the value of the
			// row as the first index value of the multiplicationTable array and the column as the second index value of the multiplicationArray.
			// this for-loop will iterate and increment the column value from 0 to 5, while the row value will remain the same until all logic
			// in the for-loop is run and the row variable is incremented. The nested for-loop will then populate the column values for the next row.
			for (int column = 0; column < multiplicationTable.length; column++) {
				if (multiplicationTable[row][column] < 10) {
					System.out.print(multiplicationTable[row][column]);
					System.out.print("   ");
				} else if (multiplicationTable[row][column] < 100) {
					System.out.print(multiplicationTable[row][column]);
					System.out.print("  ");
				} else {
					System.out.print(multiplicationTable[row][column]);
					System.out.print(" ");
				}
			}
			
			// after the nested for-loop, we jump down two lines to properly space our next row
			System.out.println();
			System.out.println();
		}
		
		
	}
	
}
