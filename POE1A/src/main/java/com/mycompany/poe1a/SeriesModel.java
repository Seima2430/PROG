/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe1a;

/**
 *
 * @author RC_Student_lab
 */
public class SeriesModel 
{
    
    public String SeriesId;
    public String SeriesName;
    public String SeriesAge;
    public String SeriesNumberOfEpisodes;

    public SeriesModel(String seriesId, String seriesName, String seriesAge, String seriesNumberOfEpisodes) 
    {
        this.SeriesId = seriesId;
        this.SeriesName = seriesName;
        this.SeriesAge = seriesAge;
        this.SeriesNumberOfEpisodes = seriesNumberOfEpisodes;
    }

    @Override
    public String toString() 
    {
        return "----------------------------------------\n" +
               "Series ID : " + SeriesId + "\n" +
               "Series Name: " + SeriesName + "\n" +
               "Series Age Restriction: " + SeriesAge + "\n" +
               "Series Number of Episodes: " + SeriesNumberOfEpisodes + "\n" +
               "----------------------------------------";
    }
}
