import java.math.BigInteger; // Import our BigInteger math utility as we will be working with integers larger than the max accessible integer value


public class FiveOrSix {
	
	public static void main(String[] args) {
		
		
		BigInteger[] array = new BigInteger[10]; // Create an array that will store the BigInteger string values larger than the max long value divisible by 5 or 6
		final BigInteger FIVE = new BigInteger("5"); // Creates a constant BigInteger with the value of 5
		final BigInteger SIX = new BigInteger("6"); // Creates a constant BigInteger with the value of 6
		
		long maxInteger = Long.MAX_VALUE; // Create our long variable with the Max long value allowable
		String stringLongMax = String.valueOf(maxInteger); // We then convert the max long value into a string so it can be passed to the BigInteger constructor
		
		BigInteger bigIntLongMax = new BigInteger(stringLongMax); // Using the BigInteger constructor, we create a new BigInteger object with the max long value as a string

		int i = 0; // Counter variable which we will use to exit our while-loop and will help us collect 10 values larger than the max long value divisible by 5 or 6
		
		// Using a while-loop and our i counter variable,
		// on every iteration, we increment our BigInteger object by one, then check to see if the new value is divisible by 5 or 6 with no remainder
		// using the BigInteger modulus method and our constant BigInteger objects with values 5 and 6. If the new value is divisible by 5 or 6, the value
		// is added to our BigInteger array and our counter variable is incremented by one. The loop continues until 10 values are found that are divisible 
		// by 5 or 6.
		while(i < 10) {
			bigIntLongMax = bigIntLongMax.add(BigInteger.ONE);
			if (bigIntLongMax.mod(FIVE) == BigInteger.ZERO || bigIntLongMax.mod(SIX) == BigInteger.ZERO) {
				array[i] = bigIntLongMax;
				i++;
			}
		}

		System.out.println("The First 10 numbers greater than " + bigIntLongMax + " that are divisible by 5 or 6 are: "); // We output a message to the console to
		  																												  // let the user know that the next values printed
		  																												  // are greater than our max long value and are divisible
		  																												  // by either 5 or 6.
		
		// We use a for-loop to iterate through the big integer values stored in our array and print them to the console.
		for (int j = 0; j < array.length; j++) {
			System.out.println(array[j]);
		}
		
	}
}