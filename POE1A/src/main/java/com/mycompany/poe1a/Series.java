/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe1a;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
class Series 
{
    
    private final ArrayList<SeriesModel> seriesList = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void CaptureSeries() 
    {
        System.out.println("CAPTURE A NEW SERIES");
        System.out.println("*************************");
        System.out.print("Enter the series id: ");
        String id = scanner.nextLine();

        System.out.print("Enter the series name: ");
        String name = scanner.nextLine();

        String age;
        while (true) 
        {
            System.out.print("Enter the series age restriction: ");
            age = scanner.nextLine().trim();

            if (!isValidAge(age))
            {
                System.out.println("You have entered a incorrect series age!!!");
                System.out.print("Pleases re-enter the series age >> ");
                age = scanner.nextLine().trim();
                if (isValidAge(age)) 
                {
                    break;
                }
            }
            else
            {
                break;
            }
        }

        System.out.print("Enter the number of episodes for " + name + ": ");
        String episodes = scanner.nextLine();

        seriesList.add(new SeriesModel(id, name, age, episodes));
        System.out.println("Series Processed Successfully!!!");
    }

    public void SearchSeries() 
    {
        System.out.print("Enter the series id to search: ");
        String id = scanner.nextLine();
        SeriesModel found = null;

        for (SeriesModel s : seriesList) 
        {
            if (s.SeriesId.equals(id)) 
            {
                found = s;
                break;
            }
        }

        if (found != null) 
        {
            System.out.println(found.toString());
        } 
        else 
        {
            System.out.println("----------------------------------------");
            System.out.println("Series with series id: " + id + " was not found!");
            System.out.println("----------------------------------------");
        }
    }

    public void UpdateSeries() 
    {
        System.out.print("Enter the series id to update: ");
        String id = scanner.nextLine();
        SeriesModel found = null;

        for (SeriesModel s : seriesList)
        {
            if (s.SeriesId.equals(id)) 
            {
                found = s;
                break;
            }
        }

        if (found != null) 
        {
            System.out.print("Enter new series name: ");
            found.SeriesName = scanner.nextLine();

            String age;
            while (true)
            {
                System.out.print("Enter the series age restriction: ");
                age = scanner.nextLine().trim();

                if (!isValidAge(age)) 
                {
                    System.out.println("You have entered a incorrect series age!!!");
                    System.out.print("Pleases re-enter the series age >> ");
                    age = scanner.nextLine().trim();
                    if (isValidAge(age)) 
                    {
                        break;
                    }
                }
                else 
                {
                    break;
                }
            }

            System.out.print("Enter new number of episodes: ");
            found.SeriesNumberOfEpisodes = scanner.nextLine();

            System.out.println("Series updated successfully!");
        }
        else 
        {
            System.out.println("Series with series id: " + id + " was not found!");
        }
    }

    public void DeleteSeries() 
    {
        System.out.print("Enter the series id to delete: ");
        String id = scanner.nextLine();
        SeriesModel found = null;

        for (SeriesModel s : seriesList)
        {
            if (s.SeriesId.equals(id)) 
            {
                found = s;
                break;
            }
        }

        if (found != null) 
        {
            System.out.print("Are you sure you want to delete series " + id + " from the system? Yes (y) to delete: ");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("y")) 
            {
                seriesList.remove(found);
                System.out.println("---------------------------------------");
                System.out.println("Series with Series ID: " + id + " WAS deleted!");
                System.out.println("---------------------------------------");
            }
        } 
        else 
        {
            System.out.println("Series with series id: " + id + " was not found!");
        }
    }

    public void SeriesReport() 
    {
        if (seriesList.isEmpty()) 
        {
            System.out.println("No series available.");
        }
        else 
        {
            System.out.println("LATEST SERIES REPORT");
            System.out.println("**************************************");
            for (SeriesModel s : seriesList) 
            {
                System.out.println(s.toString());
            }
        }
    }

    public void ExitSeriesApplication() 
    {
        System.out.println("Exiting application... Goodbye!");
        System.exit(0);
    }

    boolean isValidAge(String ageStr) 
    {
        try 
        {
            int age = Integer.parseInt(ageStr);
            return age >= 2 && age <= 18;
        } 
        catch (NumberFormatException e) 
        {
            return false;
        }
    }
}
