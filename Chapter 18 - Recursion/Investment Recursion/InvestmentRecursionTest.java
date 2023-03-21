// Program created by: Harrison Goehring
// Date Created: March 21st, 2023

// This program will invoke a recursive method that returns the amount of months it would take for our user's investment account to reach $500,000.00
// The program does this by taking in the user's monthly contribution passed as an argument to our recursive method. The investment account has a 2%
// monthly compounded return on the user's investment. 

import java.util.Scanner; // Imports our Scanner utility

public class InvestmentRecursionTest {
	
	// Our main method
	public static void main(String[] args) {
		
		final double INT_RATE = 0.02; // Creates our constant interest rate variable, which will always be 2% or 0.02
	
		Scanner input = new Scanner(System.in); // Creates our scanner object
		
		System.out.print("Enter your monthly deposit amount: "); // Prompts the user for their monthly contribution
		double deposit = input.nextDouble(); // Our monthly deposit is saved to the deposit variable
		
		double startingAcctBal = deposit; // Our monthly contribution/deposit will also equal our starting account balance.
		
		// The program outputs the return of our MonthsTo500K method, the output will tell the user through the console how many months
		// it will take them to reach their $500K investment goal
		System.out.printf("It would take %.0f months to reach our $500,000 investment goal.", MonthsTo500K(startingAcctBal, deposit, INT_RATE, 1));
	
	}
	
	// Our recursive method which takes the user's initial account balance, planned monthly contribution, monthly compound interest rate, and month counter variable as arguments.
	// Once the account balance reaches $500K or more, the method returns the months it took to reach that balance.
	public static double MonthsTo500K(double acctBal, double deposit, double intRate,  double monthCount) {
		
		acctBal += acctBal * intRate; // When the method is first called, we want to add the month's interest to the account balance before adding the deposit 
		
		if (acctBal >= 500000) { // base case. Once our Account Balance hits our $500,000 goal, we can exit the loop and return the count of months it took to get there
			return monthCount;
		} else {
			return MonthsTo500K(acctBal + deposit, deposit, intRate, monthCount + 1); // our recursive case. On each iteration, we add our monthly deposit amount to the Account Balance and
																					  // add 1 to our month counter variable which we will return once our base case above is met	
		}
	}
}
