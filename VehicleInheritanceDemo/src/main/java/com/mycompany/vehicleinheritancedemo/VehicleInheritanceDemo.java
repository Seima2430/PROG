/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.vehicleinheritancedemo;

/**
 *
 * @author RC_Student_lab
 */
public class VehicleInheritanceDemo 
{
    // ------------------- Parent Class -------------------
    static class Vehicle 
    {
        String brand;
        String model;
        int year;

        // Method to display vehicle details
        public void displayInfo() 
        {
            System.out.println("Brand: " + brand);
            System.out.println("Model: " + model);
            System.out.println("Year: " + year);
        }
    }

    // ------------------- Car Subclass -------------------
    static class Car extends Vehicle 
    {
        int numDoors; // Unique property of Car

        // Method specific to Car
        public void honk() 
        {
            System.out.println("Car horn sound!");
        }
    }

    // ------------------- Motorcycle Subclass -------------------
    static class Motorcycle extends Vehicle 
    {
        boolean hasSideCar; // Unique property of Motorcycle

        // Method specific to Motorcycle
        public void revEngine() 
        {
            System.out.println("Motorcycle revving!");
        }
    }

    // ------------------- Main Method -------------------
    public static void main(String[] args) 
    {
        System.out.println("=== Vehicle Inheritance Demo ===\n");

        // Create Car object and set its attributes
        Car myCar = new Car();
        myCar.brand = "Toyota";
        myCar.model = "Corolla";
        myCar.year = 2020;
        myCar.numDoors = 4;

        // Create Motorcycle object and set its attributes
        Motorcycle myMotorcycle = new Motorcycle();
        myMotorcycle.brand = "Harley-Davidson";
        myMotorcycle.model = "Street 750";
        myMotorcycle.year = 2018;
        myMotorcycle.hasSideCar = false;

        // Display Car details and call Car-specific method
        System.out.println("Car Details:");
        myCar.displayInfo();
        System.out.println("Number of doors: " + myCar.numDoors);
        myCar.honk();

        System.out.println(); // Blank line for spacing

        // Display Motorcycle details and call Motorcycle-specific method
        System.out.println("Motorcycle Details:");
        myMotorcycle.displayInfo();
        System.out.println("Has Sidecar: " + myMotorcycle.hasSideCar);
        myMotorcycle.revEngine();
    }
}
