// Program created by: Harrison Goehring
// Date Created: February 23rd, 2023

// This program will display, to the console, all the prime numbers less than 120 in decreasing order. The program uses an Integer Stack class to store all the prime values 
// and a method to determine what numbers between 0 and 120 are prime. If the number is determined to be prime, it is pushed to the integer stack. Once all the numbers are 
// iterated through and the prime numbers are stored in the stack, we will use a stack method known as pop to print the stored prime numbers in decreasing order to the console. 


public class PrimeNumbers {

	public static void main(String[] args) {
		
		// Creates a new integer stack object named 'primeStack' with our StackOfIntegers default constructor
		StackOfIntegers primeStack = new StackOfIntegers();
		
		// Using a for-loop, we iterate through numbers 0 through 120, checking if each number is prime or composite. If the number is prime, we use
		// our push method to add 
		for (int i = 0; i <= 120; i++) {
			if (isPrime(i)) {
				primeStack.push(i);		
			}
		}
		
		System.out.print("The prime numbers less than 120 are the following: ");
		System.out.println();
		
		// Using a while-loop, we use the pop method from our Stack of Integers class to print our values in descending order as our Pop method returns the value 
		// stored at the top of our stack
		while(!primeStack.empty()) {
			System.out.print(primeStack.pop() + " ");
		}
		
	}
	
	
	// Our method to determine if a number is prime or not, returns true if the number is Prime, returns false if the number is not
	public static boolean isPrime(int value) {
		
		// First, we check to see if the value we are checking is equal to or less than 1. If so, we know that our value cannot be a prime number (Zeros and Ones are not considered prime)
		if (value <= 1) {
			return false;
		}
		
		// Lastly, we check to see if the value divided by a starting value of 2 returns a remainder. We continue the loop incrementing our counter variable (starting at 2) by 1 until 
		// our counter variable exceeds the square root of our value. If at any point any of the counter variables divided by the value returns a remainder of 0, the number is composite.
		for (int i = 2; i <= Math.sqrt(value); i++) {
			if (value % i == 0) {
				return false;
			}
		}
		return true; // If the loop ends without triggering the if conditional, the method then returns that the number is indeed prime.
	}

}	

class StackOfIntegers {
	
	// An array to store integers in the stack
	public int[] elements;
	
	// The number of integers in the stack
	private int size;

	// Our Default size of our stack if none is defined
	public static final int DEFAULT_CAPACITY = 16;
	
	// Constructs empty stack with default capacity of 16
	public StackOfIntegers() {
		this(DEFAULT_CAPACITY); // Calls our constructor below to initialize our default constructor
	}
	
	// Constructs an empty stack with a specified capacity
	public StackOfIntegers(int capacity) {
		elements = new int[capacity];
	}
	
	// Returns true if the stack is empty
	public boolean empty() {
		return size == 0; // Returns True is size is 0
						  // Returns False is size is not 0
	}
	
	// Returns the number of elements in the stack
	public int getSize() {
		return size;
	}
	
	public int peek() {
		return elements[size - 1]; // Returns the top element
								   // of the Stack
	}
	
	public int pop() {
		return elements[--size]; // Removes the integer at the top of our stack
								 // and returns it.
	}
	
	// Our push method adds and stores a new integer (our argument, value)
	// at the top of the stack. The method uses conditional logic to check
	// if the array length is large enough to handle a new value. If the
	// current size is larger than or equal to the length of our array, the
	// method doubles the array size and copies over the values from the previous array
	// to the new array. Once the check is complete, the argument value is added to the next
	// highest index value in the array.
	public int push(int value) {
		if (size >= elements.length) {
			int[] temp = new int[elements.length * 2];
			System.arraycopy(elements, 0, temp, 0, elements.length); // Using the arraycopy method, we input our array (our 'source' array that we wish to copy 
																     // as our first argument. Since we want to copy the array from beginning to end, our second
																	 // argument (the starting position in the source array we want to begin copying from) is set to 0.
																	 // For our 3rd argument, or our Destination Array, we enter in our new temp array as that is the array 
																	 // we want to copy to. Lastly, the 4th argument is our starting position in the temp / destination array
																	 // we set this to 0 as we want to preserve the order of elements from our source array.
			elements = temp; // we then overwrite the previous elements array with the new temp array
		}
		return elements[size++] = value; // Returns our new elements array, incremented one index value and assigns our argument value we passed into the method 
		                                 // into that index value of the array. 
	}
}