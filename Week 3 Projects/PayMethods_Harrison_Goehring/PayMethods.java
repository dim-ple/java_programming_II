// Program created by: Harrison Goehring
// Date Created: January 26th, 2023

// This program takes in the number of hours worked by an employee & the employee's pay
// rate. It then takes these inputs and determines and displays the gross pay for the 
// employee. If the employee works over 40 hours, any hours over the initial 40 increase
// the pay rate by a time and a half (1.5).

import java.util.Scanner; // Import our scanner utility so we can take in user input.

public class PayMethods { 

     
	 // our main method, will call all the methods of the PayMethods class
	 // to calculate our employee's gross pay.
	 public static void main(String []args){      
    	 
    	System.out.println("Welcome to the Payment Calculator!"); // welcome message to the user.
        
        int hours = getHoursWorked(); // Initializes the method to input hours worked by the employee
        							  // We are saving the return of this method to the hours variable to use
        							  // in the Gross Pay calculation method later.
        
        double payRate = getPayRate(); // Initializes the method to input the pay rate for the employee
		  							   // We are saving the return of this method to the payRate variable to use
		  							   // in the Gross Pay calculation method later.
        
        double grossPay = calcGross(hours, payRate); // Initializes the Gross Pay calculation method using our
        											 // hours and payRate variables as arguments. The return is stored
        											 // in the grossPay variable to be output to the console/user later.
        
        // Outputs a message to the console and user noting the gross pay of the employee, formatted to 2 decimal places
        System.out.print("The gross pay for the employee is ");
        System.out.format("$%.2f", grossPay);
     
     }
     
     // This method will take the hours worked for an employee as an input, store the input into the hours variable 
	 // and will return the hours variable. 
	 private static int getHoursWorked() {
    	 
		 int hours; // Declare our hours variable, will return this at method's conclusion
		 Scanner input = new Scanner(System.in); // Creates a new scanner item
         
         // Prompts the user to enter the employees hours worked and stores an integer input into the hours variable.
    	 System.out.println("Enter the amount of hours the employee worked: "); 
         hours = input.nextInt();
         
         return hours; // Returns our hours variable.
     }
     
	// This method will take the payRate for an employee as an input, store the input into the payRate variable 
    // and will return the payRate variable. 
     private static double getPayRate() {
        
    	double payRate; // Declare our payRate variable, will return this at method's conclusion
    	Scanner input = new Scanner(System.in); // Creates a new scanner item
        
        // Prompts the user to enter the employees pay rate and stores an double input into the payRate variable.
        System.out.println("Enter the employee's $ per hour pay rate: ");
        payRate = input.nextDouble(); 
       
        return payRate; // Returns our payRate variable.
     }
     
     // This method takes two arguments, hours and pay rate, for an employee we would like to 
     // calculate gross pay for. This method will also determine, if the employee has worked overtime,
     // what their pay for that overtime will be.
     private static double calcGross(int hours, double payRate){
        
    	double grossPay; // Declare our grossPay variable, will return this at method's conclusion
        double OTPAYRATE = 1.5; // Declares our constant overtime pay rate
    	
        
        // Conditional If-Else to determine if we need to adjust our gross pay calculation to 
        // accomodate overtime pay for an employee. 
        // We first check if the employee worked overtime, i.e. did the employee work more than 40 hours?
        // If so, we move forward with the statements in the if conditional. If the employee works 40 or less hours
        // we move on to the statements in the else conditional
    	if (hours > 40) { 
        	
    		int overtimeHours = hours - 40; // We want to find out how many hours of overtime the employee worked. 
        									// We do this by taking our employees hours and subtracting the 40 hours 
        									// of work paid at the standard pay rate.
        	
    		double overtimePay = overtimeHours * (payRate * OTPAYRATE); // We determine our overtimePay by taking our
    																	// overtime hours and multiplying it by our pay rate
    																	// multiplied by our Overtime Pay Rate.
    		
        	grossPay = (40 * payRate) + overtimePay; // Our employee's gross pay is then calculated. The first 40 hours
        											 // are paid at the defualt pay rate and they are then added to our 
        											 // overtime pay.
        	
        } else { // If the employee works 40 hours or less we move on to the below statement to calculate gross pay
        	grossPay = hours * payRate; // Gross pay is calculated by multiplying the employee's hours by their pay rate
        }
    	 
        return grossPay; // Once the If-else conditional completes, we return our gross pay for the employee.
     }
     
}
