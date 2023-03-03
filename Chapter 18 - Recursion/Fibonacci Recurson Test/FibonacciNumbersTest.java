import java.util.Scanner; // imports our Java utility Scanner package

public class FibonacciNumbersTest {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); // Creates a nw Scanner object so we can take in
		
		System.out.print("Enter an index for a Fibonaci number: ");
		int index = input.nextInt();
		
		System.out.println("The Fibonacci number at index " + index + " is " + fibonacci(index));
		

	}
	
	public static long fibonacci(long index) {
		if (index == 0) {
			return 0;
		} else if (index == 1) {
			return 1;
		} else {
			return fibonacci(index - 1) + fibonacci(index - 2);
		}
	}

}
