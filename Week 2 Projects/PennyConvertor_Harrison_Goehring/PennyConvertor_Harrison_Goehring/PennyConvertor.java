// Program created by: Harrison Goehring
// Date Created: January 16th, 2023

// This program takes a number of pennies as an input, then it find outs how many dollars, quarters, dimes, nickels and pennies
// the user would get back from a bank.

import java.util.Scanner; // Import our Java Utility Scanner

public class PennyConvertor{

     public static void main(String []args){
        
        Scanner input = new Scanner(System.in); // Creates new Scanner Item
        
        // Prints our question to Sam asking how many pennies he has in his piggy bank
        System.out.println("Sam, enter the number of pennies in your Piggy Bank: ");
        
        // Records the users pennies entry 
        int userPennies = input.nextInt();
        
        // Determines how many dollars are in our penny count. Integer variable returns 0 if 
        // the amount of pennies is less than 100.
        int dollars = userPennies / 100;
        
        // Determines how many quarters are in our penny count after the amount of pennies attributed to the dollar count
        // is subtracted from the total user penny entry. Integer variable returns 0 if the amount is less than 25.
        int quarters = (userPennies - (dollars * 100)) / 25;
        
        // Determines how many dimes are in our penny count after the amount of pennies attributed to the dollar & quarters count
        // is subtracted from the total user penny entry. Integer variable returns 0 if the amount is less than 10.
        int dimes = ((userPennies - (dollars * 100)) - (quarters * 25)) / 10;
        
        // Determines how many dimes are in our penny count after the amount of pennies attributed to the dollar, 
        // quarters & dimes count is subtracted from the total user penny entry. Integer variable 
        // returns 0 if the amount is less than 5.
        int nickels = (((userPennies - (dollars * 100)) - (quarters * 25)) -(dimes * 10)) / 5;
        
        // Determines how many dimes are in our penny count after the amount of pennies attributed to the dollar, 
        // quarters, dimes & nickels count is subtracted from the total user penny entry. Integer variable 
        // returns 0 if the amount is less than 1.
        int pennies = (((userPennies - (dollars * 100)) - (quarters * 25)) - (dimes * 10) - (nickels * 5)) / 1;
        
        
        // Conditional logic checks to see if the amount of dollars/quarters/dimes/nickels/pennies 
        // is 1. If so, the string output reflects a singular currency item. Otherwise,
        // the string output reflects plural currency items.
        if (dollars == 1) {
            System.out.print("Sam will receive " + dollars + " dollar, ");
        } else {
            System.out.print("Sam will receive " + dollars + " dollars, ");
        }
            
        if (quarters == 1) {
            System.out.print(quarters + " quarter, ");
        } else {
            System.out.print(quarters + " quarters, ");
        }
        
        if (dimes == 1) {
            System.out.print(dimes + " dime, ");
        } else {
            System.out.print(dimes + " dimes, ");
        }
         
        if (nickels == 1) {
            System.out.print(nickels + " nickel, ");
        } else {
            System.out.print(nickels + " nickels, ");
        }
        
        if (pennies == 1) {
            System.out.print(pennies + " penny from the bank. ");
        } else {
            System.out.print(pennies + " pennies from the bank. ");
        }
        
        input.close(); // Scanner item closed to prevent memory leak
     }
}