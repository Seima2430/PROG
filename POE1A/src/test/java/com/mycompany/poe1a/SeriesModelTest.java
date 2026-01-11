/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.poe1a;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RC_Student_lab
 */
public class SeriesModelTest {
    
    public SeriesModelTest() {
    }

    @Test
    public void testSeriesModelConstructor() {
        SeriesModel series = new SeriesModel("S001", "Test Series", "12", "24");
        
        assertEquals("Series ID should match", "S001", series.SeriesId);
        assertEquals("Series name should match", "Test Series", series.SeriesName);
        assertEquals("Series age should match", "12", series.SeriesAge);
        assertEquals("Series episodes should match", "24", series.SeriesNumberOfEpisodes);
    }
    
    @Test
    public void testToString() {
        SeriesModel series = new SeriesModel("S001", "Test Series", "12", "24");
        String result = series.toString();
        
        assertTrue("Should contain series ID", result.contains("S001"));
        assertTrue("Should contain series name", result.contains("Test Series"));
        assertTrue("Should contain series age", result.contains("12"));
        assertTrue("Should contain series episodes", result.contains("24"));
        assertTrue("Should contain proper formatting", result.contains("----------------------------------------"));
    }
    
    @Test
    public void testToStringFormat() {
        SeriesModel series = new SeriesModel("S002", "Another Series", "15", "10");
        String result = series.toString();
        
        // Test the exact format
        String expected = "----------------------------------------\n" +
                         "Series ID : S002\n" +
                         "Series Name: Another Series\n" +
                         "Series Age Restriction: 15\n" +
                         "Series Number of Episodes: 10\n" +
                         "----------------------------------------";
        
        assertEquals("ToString should return correct format", expected, result);
    }
}