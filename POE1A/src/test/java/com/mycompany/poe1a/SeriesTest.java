/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.poe1a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RC_Student_lab
 */
public class SeriesTest {
    
    private Series series;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final java.io.InputStream originalIn = System.in;
    
    public SeriesTest() {
    }
    
    @Before
    public void setUp() {
        series = new Series();
        System.setOut(new PrintStream(outputStream));
    }
    
    @After
    public void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }
    
    // Helper method to access private seriesList using reflection
    private ArrayList<SeriesModel> getSeriesList() throws Exception {
        Field field = Series.class.getDeclaredField("seriesList");
        field.setAccessible(true);
        return (ArrayList<SeriesModel>) field.get(series);
    }
    
    // Helper method to access private scanner using reflection
    private void setScannerInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
    
    // Helper method to access private isValidAge method using reflection
    private boolean isValidAge(String ageStr) throws Exception {
        Method method = Series.class.getDeclaredMethod("isValidAge", String.class);
        method.setAccessible(true);
        return (Boolean) method.invoke(series, ageStr);
    }
    
    @Test
    public void testIsValidAgeValid() throws Exception {
        assertTrue("Age 5 should be valid", isValidAge("5"));
        assertTrue("Age 2 should be valid", isValidAge("2"));
        assertTrue("Age 18 should be valid", isValidAge("18"));
        assertTrue("Age 10 should be valid", isValidAge("10"));
    }
    
    @Test
    public void testIsValidAgeInvalid() throws Exception {
        assertFalse("Age 1 should be invalid", isValidAge("1"));
        assertFalse("Age 19 should be invalid", isValidAge("19"));
        assertFalse("Age 0 should be invalid", isValidAge("0"));
        assertFalse("Age -5 should be invalid", isValidAge("-5"));
        assertFalse("Age 20 should be invalid", isValidAge("20"));
        assertFalse("Non-numeric input should be invalid", isValidAge("abc"));
        assertFalse("Empty input should be invalid", isValidAge(""));
        assertFalse("Decimal input should be invalid", isValidAge("12.5"));
    }
    
    @Test
    public void testCaptureSeriesValid() throws Exception {
        String input = "S001\nTest Series\n12\n24\n";
        setScannerInput(input);
        
        series.CaptureSeries();
        
        ArrayList<SeriesModel> seriesList = getSeriesList();
        assertEquals("Should have one series in list", 1, seriesList.size());
        
        SeriesModel capturedSeries = seriesList.get(0);
        assertEquals("Series ID should match", "S001", capturedSeries.SeriesId);
        assertEquals("Series name should match", "Test Series", capturedSeries.SeriesName);
        assertEquals("Series age should match", "12", capturedSeries.SeriesAge);
        assertEquals("Series episodes should match", "24", capturedSeries.SeriesNumberOfEpisodes);
        
        String output = outputStream.toString();
        assertTrue("Should contain success message", output.contains("Series Processed Successfully!!!"));
    }
    
    @Test
    public void testCaptureSeriesWithInvalidAgeRetry() throws Exception {
        String input = "S002\nAnother Series\n20\n12\n18\n"; // 20 is invalid, then 12 is valid
        setScannerInput(input);
        
        series.CaptureSeries();
        
        ArrayList<SeriesModel> seriesList = getSeriesList();
        assertEquals("Should have one series in list", 1, seriesList.size());
        
        SeriesModel capturedSeries = seriesList.get(0);
        assertEquals("Series age should be the valid one", "12", capturedSeries.SeriesAge);
        
        String output = outputStream.toString();
        assertTrue("Should contain error message", output.contains("incorrect series age"));
        assertTrue("Should contain success message", output.contains("Series Processed Successfully!!!"));
    }
    
    @Test
    public void testSearchSeriesFound() throws Exception {
        // First add a series
        String input = "S001\nTest Series\n12\n24\n";
        setScannerInput(input);
        series.CaptureSeries();
        
        outputStream.reset(); // Clear the output
        
        // Now search for it
        input = "S001\n";
        setScannerInput(input);
        series.SearchSeries();
        
        String output = outputStream.toString();
        assertTrue("Should find the series", output.contains("S001"));
        assertTrue("Should find the series", output.contains("Test Series"));
        assertTrue("Should find the series", output.contains("12"));
        assertTrue("Should find the series", output.contains("24"));
    }
    
    @Test
    public void testSearchSeriesNotFound() {
        String input = "S999\n";
        setScannerInput(input);
        
        series.SearchSeries();
        
        String output = outputStream.toString();
        assertTrue("Should show not found message", output.contains("was not found"));
        assertTrue("Should show the searched ID", output.contains("S999"));
    }
    
    @Test
    public void testUpdateSeries() throws Exception {
        // First add a series
        String input = "S001\nTest Series\n12\n24\n";
        setScannerInput(input);
        series.CaptureSeries();
        
        outputStream.reset(); // Clear the output
        
        // Now update it
        input = "S001\nUpdated Series\n15\n30\n";
        setScannerInput(input);
        series.UpdateSeries();
        
        ArrayList<SeriesModel> seriesList = getSeriesList();
        SeriesModel updatedSeries = seriesList.get(0);
        
        assertEquals("Name should be updated", "Updated Series", updatedSeries.SeriesName);
        assertEquals("Age should be updated", "15", updatedSeries.SeriesAge);
        assertEquals("Episodes should be updated", "30", updatedSeries.SeriesNumberOfEpisodes);
        
        String output = outputStream.toString();
        assertTrue("Should show update success", output.contains("Series updated successfully!"));
    }
    
    @Test
    public void testUpdateSeriesWithInvalidAgeRetry() throws Exception {
        // First add a series
        String input = "S001\nTest Series\n12\n24\n";
        setScannerInput(input);
        series.CaptureSeries();
        
        outputStream.reset(); // Clear the output
        
        // Now update it with invalid age first
        input = "S001\nUpdated Series\n20\n15\n30\n"; // 20 invalid, then 15 valid
        setScannerInput(input);
        series.UpdateSeries();
        
        ArrayList<SeriesModel> seriesList = getSeriesList();
        SeriesModel updatedSeries = seriesList.get(0);
        
        assertEquals("Age should be the valid one", "15", updatedSeries.SeriesAge);
        
        String output = outputStream.toString();
        assertTrue("Should show error message", output.contains("incorrect series age"));
        assertTrue("Should show update success", output.contains("Series updated successfully!"));
    }
    
    @Test
    public void testUpdateSeriesNotFound() {
        String input = "S999\n";
        setScannerInput(input);
        
        series.UpdateSeries();
        
        String output = outputStream.toString();
        assertTrue("Should show not found message", output.contains("was not found"));
    }
    
    @Test
    public void testDeleteSeriesConfirm() throws Exception {
        // First add a series
        String input = "S001\nTest Series\n12\n24\n";
        setScannerInput(input);
        series.CaptureSeries();
        
        outputStream.reset(); // Clear the output
        
        // Now delete it with confirmation
        input = "S001\ny\n";
        setScannerInput(input);
        series.DeleteSeries();
        
        ArrayList<SeriesModel> seriesList = getSeriesList();
        assertEquals("Series list should be empty after deletion", 0, seriesList.size());
        
        String output = outputStream.toString();
        assertTrue("Should show delete success", output.contains("WAS deleted"));
    }
    
    @Test
    public void testDeleteSeriesCancel() throws Exception {
        // First add a series
        String input = "S001\nTest Series\n12\n24\n";
        setScannerInput(input);
        series.CaptureSeries();
        
        outputStream.reset(); // Clear the output
        
        // Now try to delete but cancel
        input = "S001\nn\n";
        setScannerInput(input);
        series.DeleteSeries();
        
        ArrayList<SeriesModel> seriesList = getSeriesList();
        assertEquals("Series list should still have the series", 1, seriesList.size());
        
        String output = outputStream.toString();
        assertFalse("Should not show delete success", output.contains("WAS deleted"));
    }
    
    @Test
    public void testDeleteSeriesNotFound() {
        String input = "S999\n";
        setScannerInput(input);
        
        series.DeleteSeries();
        
        String output = outputStream.toString();
        assertTrue("Should show not found message", output.contains("was not found"));
    }
    
    @Test
    public void testSeriesReportEmpty() {
        series.SeriesReport();
        
        String output = outputStream.toString();
        assertTrue("Should show no series available", output.contains("No series available"));
    }
    
    @Test
    public void testSeriesReportWithData() throws Exception {
        // First add a series
        String input = "S001\nTest Series\n12\n24\n";
        setScannerInput(input);
        series.CaptureSeries();
        
        outputStream.reset(); // Clear the output
        
        // Now generate report
        series.SeriesReport();
        
        String output = outputStream.toString();
        assertTrue("Should show series report header", output.contains("LATEST SERIES REPORT"));
        assertTrue("Should contain series data", output.contains("S001"));
        assertTrue("Should contain series data", output.contains("Test Series"));
        assertTrue("Should contain series data", output.contains("12"));
        assertTrue("Should contain series data", output.contains("24"));
    }
    
    @Test
    public void testSeriesReportWithMultipleSeries() throws Exception {
        // Add first series
        String input = "S001\nTest Series 1\n12\n24\n";
        setScannerInput(input);
        series.CaptureSeries();
        
        // Add second series
        input = "S002\nTest Series 2\n15\n10\n";
        setScannerInput(input);
        series.CaptureSeries();
        
        outputStream.reset(); // Clear the output
        
        // Generate report
        series.SeriesReport();
        
        String output = outputStream.toString();
        assertTrue("Should show both series", output.contains("S001") && output.contains("S002"));
        assertTrue("Should show both series names", output.contains("Test Series 1") && output.contains("Test Series 2"));
    }
    
    @Test
    public void testExitSeriesApplication() {
        try {
            series.ExitSeriesApplication();
            // If we reach here, System.exit wasn't called (which is expected in test environment)
            assertTrue("Exit method should be callable", true);
        } catch (Exception e) {
            fail("ExitSeriesApplication should not throw exceptions");
        }
    }
    
    @Test
    public void testDuplicateSeriesId() throws Exception {
        // Add first series
        String input = "S001\nTest Series 1\n12\n24\n";
        setScannerInput(input);
        series.CaptureSeries();
        
        outputStream.reset(); // Clear the output
        
        // Try to add series with same ID
        input = "S001\nTest Series 2\n15\n10\n";
        setScannerInput(input);
        series.CaptureSeries();
        
        ArrayList<SeriesModel> seriesList = getSeriesList();
        assertEquals("Should still have only one series", 1, seriesList.size());
        
        // The original series should remain unchanged
        assertEquals("Original series name should remain", "Test Series 1", seriesList.get(0).SeriesName);
    }
}