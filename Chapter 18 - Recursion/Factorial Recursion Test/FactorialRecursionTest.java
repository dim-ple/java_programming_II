import java.util.Scanner; // imports our Java scanner utility

public class FactorialRecursionTest {
	
	// Our Main Method
	public static void main (String[] args) {
		
		Scanner input = new Scanner(System.in); // Creates our scanner object so we can take in user input
		
		System.out.print("Enter a non-negative integer: "); // Prompts the user for their input
		
		int n = input.nextInt(); // Initializes our n variable with the input of the user
		
		System.out.println("Facotorial of " + n + " is " + factorial(n)); // Call the factorial method and outputs the result to the console
	}
	
	// Our Factorial method that will return the factorial of a specific number. It is recursive in nature and will call upon itself until
	// we reach our base case
	public static long factorial(int n) {
		
		if (n == 0) { // our base case for the recursive method 
			return 1;
		} else {
			return n * factorial(n - 1); // our recursive call of the factorial method
		}
	
	
	}

}

