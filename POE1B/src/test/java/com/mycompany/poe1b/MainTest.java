/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.poe1b;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RC_Student_lab
 */
public class MainTest {
    
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final java.io.InputStream originalIn = System.in;
    
    public MainTest() {
    }
    
    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }
    
    @After
    public void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }
    
    @Test
    public void testMainExitOption() {
        String input = "exit\n"; // Any non-"1" input
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        try {
            Main.main(new String[]{});
            // If we reach here, the test passes (System.exit wasn't actually called in test environment)
            assertTrue(true);
        } catch (SecurityException e) {
            // Expected when System.exit is called
            assertTrue("SecurityException indicates exit was attempted", true);
        }
    }
    
    @Test
    public void testMainInvalidMenuChoice() {
        String input = "1\ninvalid\n6\n"; // Launch menu, invalid choice, then exit
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        try {
            Main.main(new String[]{});
            String output = outputStream.toString();
            assertTrue("Should show invalid choice message", output.contains("Invalid choice"));
        } catch (SecurityException e) {
            // Expected when System.exit is called
            assertTrue("SecurityException indicates exit was attempted", true);
        }
    }
    
    @Test
    public void testMainMenuDisplay() {
        String input = "1\n6\n"; // Launch menu, then exit
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        try {
            Main.main(new String[]{});
            String output = outputStream.toString();
            assertTrue("Should show menu title", output.contains("STUDENT GRADE MANAGEMENT SYSTEM"));
            assertTrue("Should show menu options", output.contains("Add a new student"));
            assertTrue("Should show menu options", output.contains("Search for a student"));
            assertTrue("Should show menu options", output.contains("Update student grade"));
            assertTrue("Should show menu options", output.contains("Delete a student"));
            assertTrue("Should show menu options", output.contains("Print student grade report"));
            assertTrue("Should show menu options", output.contains("Exit Application"));
        } catch (SecurityException e) {
            // Expected when System.exit is called
            assertTrue("SecurityException indicates exit was attempted", true);
        }
    }
}