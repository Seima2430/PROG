/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe1a;

import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class Main 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Series seriesApp = new Series();

        while (true) 
        {
            System.out.println("LATEST SERIES - 2025");
            System.out.println("**************************************");
            System.out.print("Enter (1) to launch menu or any other key to exit: ");
            String choice = scanner.nextLine();
            if (!choice.equals("1")) 
            {
                seriesApp.ExitSeriesApplication();
            }

            System.out.println("1. Capture a new series");
            System.out.println("2. Search for a series");
            System.out.println("3. Update series age restriction");
            System.out.println("4. Delete a series");
            System.out.println("5. Print series report - 2025");
            System.out.println("6. Exit Application");

            System.out.print("Please select one of the following menu items: ");
            String menuChoice = scanner.nextLine();

            switch (menuChoice) 
            {
                case "1" -> seriesApp.CaptureSeries();
                case "2" -> seriesApp.SearchSeries();
                case "3" -> seriesApp.UpdateSeries();
                case "4" -> seriesApp.DeleteSeries();
                case "5" -> seriesApp.SeriesReport();
                case "6" -> seriesApp.ExitSeriesApplication();
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
