/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.programming1afinalproduct;

import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class Programming1AFinalProduct 
{

    // Store the valid username and password for login comparison
    static String savedUsername = "";
    static String savedPassword = "";

    public static void main(String[] args) 
    {
        // Print program header
        System.out.println("PROGRAMMING 1A Final Product");
        
        System.out.println("Sign Up:");

        // Create a Scanner object to read input from the user
        Scanner myScan = new Scanner(System.in);

        // Call each method to perform its respective task
        UsernameChecker(myScan);
        PasswordChecker(myScan);
        PhoneNumber(myScan);
        Login(myScan);
        
    } 
    public static void UsernameChecker(Scanner myScan)
    {
        // Ask the user to enter a username with the specified rules
        System.out.println("Please enter your Username (must include '_' and be <= 5 characters):");

        // Read the input username
        String Username = myScan.nextLine();
        
        // Check if the username meets both conditions: underscore and not longer than 5 characters
        if (Username.length() <= 5 && Username.contains("_")) 
        {
            System.out.println("Username accepted: " + Username);

            // Save the valid username for login use
            savedUsername = Username;
        } 
        else 
        {
            // Inform the user that the username is invalid
            System.out.println("Invalid Username.");
        }
    }
    public static void PasswordChecker(Scanner myScan)
    {
        // Ask the user to enter a password
        System.out.println("Please enter your Password:");

        // Read the input password
        String Password = myScan.nextLine();
        
        // Check if the entered password is valid using the validation method
        if (ValidPassword(Password)) 
        {
            System.out.println("Password is Valid");

            // Save the valid password for login use
            savedPassword = Password;
        }
        else
        {
            // Display the password requirements if the password is invalid
            System.out.println("Invalid password. It must:");
            System.out.println("- Be at least 8 characters long");
            System.out.println("- Contain at least one uppercase letter");
            System.out.println("- Contain at least one number");
            System.out.println("- Contain at least one special character (e.g., !@#$%^&*)"); 
        }
    }
    public static boolean ValidPassword(String Password) 
    {
        // Check if the password has at least 8 characters
        if (Password.length() < 8) 
        {
            return false;
        }

        // Flags to track each requirement
        boolean hasUppercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        // Loop through each character in the password
        for (char ch : Password.toCharArray()) 
        {
            // Check for uppercase letter
            if (Character.isUpperCase(ch))
            {
                hasUppercase = true;
            }
            // Check for digit (number)
            else if (Character.isDigit(ch)) 
            {
                hasDigit = true;
            }
            // Check for special character (not a letter or digit)
            else if (!Character.isLetterOrDigit(ch)) 
            {
                hasSpecialChar = true;
            }
        }

        // Return true only if all requirements are met
        return hasUppercase && hasDigit && hasSpecialChar;
    }
    public static void PhoneNumber(Scanner scanner) 
    {
        // Asking the user to enter their phone number with the country code
        System.out.print("Enter your cell phone number (include country code, e.g. +2783123456): ");
        String input = scanner.nextLine();

        // Check if input starts with a '+' sign
        if (!input.startsWith("+")) 
        {
            System.out.println("Invalid format. Phone number must start with '+' followed by digits.");
        } 
        else 
        {
            // Remove '+' and store the rest of the number
            String numberPart = input.substring(1);

            // Check if the remaining part contains only digits
            if (!numberPart.matches("\\d+")) 
            {
                System.out.println("Invalid input. Only digits are allowed after '+'");
            } 
            // Check if the number is no more than 10 digits long
            else if (numberPart.length() > 11) 
            {
                System.out.println("Invalid input. Number cannot be more than 10 digits after the '+'");
            } 
            // Valid phone number
            else {
                System.out.println("Phone number accepted: " + input);
            }
        }
        System.out.println("Login:");
    }
    public static void Login(Scanner scanner)
    {
        // Ask the user to input username and password for login
        System.out.print("Enter your username: ");
        String enteredUsername = scanner.nextLine();

        System.out.print("Enter your password: ");
        String enteredPassword = scanner.nextLine();

        // Check if both entered credentials match the saved ones
        if (enteredUsername.equals(savedUsername) && enteredPassword.equals(savedPassword)) 
        {
            // If login is successful, ask for first and last name
            System.out.print("Enter your First Name: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter your Last Name: ");
            String lastName = scanner.nextLine();

            // Display a welcome message using full name
            System.out.println("Welcome " + firstName + " " + lastName + ", it is great to see you again.");
        } 
        else 
        {
            // If credentials are incorrect, show a failure message
            System.out.println("Login failed. Incorrect username or password.");
        }
    }
}
