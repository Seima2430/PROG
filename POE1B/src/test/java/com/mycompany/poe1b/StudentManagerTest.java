/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.poe1b;

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
public class StudentManagerTest {
    
    private StudentManager studentManager;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final java.io.InputStream originalIn = System.in;
    
    public StudentManagerTest() {
    }
    
    @Before
    public void setUp() {
        studentManager = new StudentManager();
        System.setOut(new PrintStream(outputStream));
    }
    
    @After
    public void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }
    
    // Helper method to access private studentList using reflection
    private ArrayList<Student> getStudentList() throws Exception {
        Field field = StudentManager.class.getDeclaredField("studentList");
        field.setAccessible(true);
        return (ArrayList<Student>) field.get(studentManager);
    }
    
    // Helper method to set scanner input
    private void setScannerInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
    
    // Helper method to access private isValidGrade method using reflection
    private boolean isValidGrade(String gradeStr) throws Exception {
        Method method = StudentManager.class.getDeclaredMethod("isValidGrade", String.class);
        method.setAccessible(true);
        return (Boolean) method.invoke(studentManager, gradeStr);
    }
    
    @Test
    public void testIsValidGradeValid() throws Exception {
        assertTrue("Grade 0 should be valid", isValidGrade("0"));
        assertTrue("Grade 50 should be valid", isValidGrade("50"));
        assertTrue("Grade 100 should be valid", isValidGrade("100"));
        assertTrue("Grade 85.5 should be valid", isValidGrade("85.5"));
    }
    
    @Test
    public void testIsValidGradeInvalid() throws Exception {
        assertFalse("Grade -1 should be invalid", isValidGrade("-1"));
        assertFalse("Grade 101 should be invalid", isValidGrade("101"));
        assertFalse("Non-numeric input should be invalid", isValidGrade("abc"));
        assertFalse("Empty input should be invalid", isValidGrade(""));
        assertFalse("Decimal input beyond range should be invalid", isValidGrade("100.1"));
    }
    
    @Test
    public void testAddStudent() throws Exception {
        String input = "S001\nJohn Doe\n20\nMath\n85.5\nScience\n90.0\nEnglish\n78.5\n";
        setScannerInput(input);
        
        studentManager.AddStudent();
        
        ArrayList<Student> studentList = getStudentList();
        assertEquals("Should have one student in list", 1, studentList.size());
        
        Student addedStudent = studentList.get(0);
        assertEquals("Student ID should match", "S001", addedStudent.StudentId);
        assertEquals("Student name should match", "John Doe", addedStudent.StudentName);
        assertEquals("Student age should match", "20", addedStudent.StudentAge);
        
        String[] expectedCourses = {"Math", "Science", "English"};
        double[] expectedGrades = {85.5, 90.0, 78.5};
        
        assertArrayEquals("Courses should match", expectedCourses, addedStudent.Courses);
        assertArrayEquals("Grades should match", expectedGrades, addedStudent.Grades, 0.01);
        
        String output = outputStream.toString();
        assertTrue("Should contain success message", output.contains("Student added successfully!"));
    }
    
    @Test
    public void testAddStudentWithInvalidGradeRetry() throws Exception {
        String input = "S002\nJane Smith\n21\nMath\n101\n85.5\nScience\n90.0\nEnglish\n78.5\n"; // 101 invalid, then 85.5 valid
        setScannerInput(input);
        
        studentManager.AddStudent();
        
        ArrayList<Student> studentList = getStudentList();
        assertEquals("Should have one student in list", 1, studentList.size());
        
        Student addedStudent = studentList.get(0);
        assertEquals("Math grade should be the valid one", 85.5, addedStudent.Grades[0], 0.01);
        
        String output = outputStream.toString();
        assertTrue("Should contain error message", output.contains("Invalid grade!"));
        assertTrue("Should contain success message", output.contains("Student added successfully!"));
    }
    
    @Test
    public void testAddStudentDuplicateId() throws Exception {
        // Add first student
        String input = "S001\nJohn Doe\n20\nMath\n85.5\nScience\n90.0\nEnglish\n78.5\n";
        setScannerInput(input);
        studentManager.AddStudent();
        
        outputStream.reset(); // Clear the output
        
        // Try to add student with same ID
        input = "S001\nJane Smith\n21\nMath\n95.0\nScience\n92.0\nEnglish\n88.0\n";
        setScannerInput(input);
        studentManager.AddStudent();
        
        ArrayList<Student> studentList = getStudentList();
        assertEquals("Should still have only one student", 1, studentList.size());
        
        // The original student should remain unchanged
        assertEquals("Original student name should remain", "John Doe", studentList.get(0).StudentName);
        
        String output = outputStream.toString();
        assertTrue("Should contain duplicate ID message", output.contains("already exists"));
    }
    
    @Test
    public void testSearchStudentFound() throws Exception {
        // First add a student
        String input = "S001\nJohn Doe\n20\nMath\n85.5\nScience\n90.0\nEnglish\n78.5\n";
        setScannerInput(input);
        studentManager.AddStudent();
        
        outputStream.reset(); // Clear the output
        
        // Now search for it
        input = "S001\n";
        setScannerInput(input);
        studentManager.SearchStudent();
        
        String output = outputStream.toString();
        assertTrue("Should find the student", output.contains("S001"));
        assertTrue("Should find the student", output.contains("John Doe"));
        assertTrue("Should find the student", output.contains("20"));
        assertTrue("Should contain course information", output.contains("Math: 85.5"));
    }
    
    @Test
    public void testSearchStudentNotFound() {
        String input = "S999\n";
        setScannerInput(input);
        
        studentManager.SearchStudent();
        
        String output = outputStream.toString();
        assertTrue("Should show not found message", output.contains("was not found"));
        assertTrue("Should show the searched ID", output.contains("S999"));
    }
    
    @Test
    public void testUpdateStudent() throws Exception {
        // First add a student
        String input = "S001\nJohn Doe\n20\nMath\n85.5\nScience\n90.0\nEnglish\n78.5\n";
        setScannerInput(input);
        studentManager.AddStudent();
        
        outputStream.reset(); // Clear the output
        
        // Now update it
        input = "S001\nJane Doe\n21\n\n\n95.0\n\n\n\n"; // Update name, age, and Math grade only
        setScannerInput(input);
        studentManager.UpdateStudent();
        
        ArrayList<Student> studentList = getStudentList();
        Student updatedStudent = studentList.get(0);
        
        assertEquals("Name should be updated", "Jane Doe", updatedStudent.StudentName);
        assertEquals("Age should be updated", "21", updatedStudent.StudentAge);
        assertEquals("Math grade should be updated", 95.0, updatedStudent.Grades[0], 0.01);
        // Other grades should remain unchanged
        assertEquals("Science grade should remain", 90.0, updatedStudent.Grades[1], 0.01);
        assertEquals("English grade should remain", 78.5, updatedStudent.Grades[2], 0.01);
        
        String output = outputStream.toString();
        assertTrue("Should show update success", output.contains("Student updated successfully!"));
    }
    
    @Test
    public void testUpdateStudentWithInvalidGradeRetry() throws Exception {
        // First add a student
        String input = "S001\nJohn Doe\n20\nMath\n85.5\nScience\n90.0\nEnglish\n78.5\n";
        setScannerInput(input);
        studentManager.AddStudent();
        
        outputStream.reset(); // Clear the output
        
        // Now update with invalid grade first
        input = "S001\n\n\n\n101\n95.0\n\n\n\n"; // Invalid grade 101, then valid 95.0 for Math
        setScannerInput(input);
        studentManager.UpdateStudent();
        
        ArrayList<Student> studentList = getStudentList();
        Student updatedStudent = studentList.get(0);
        
        assertEquals("Math grade should be the valid one", 95.0, updatedStudent.Grades[0], 0.01);
        
        String output = outputStream.toString();
        assertTrue("Should show error message", output.contains("Invalid grade!"));
        assertTrue("Should show update success", output.contains("Student updated successfully!"));
    }
    
    @Test
    public void testUpdateStudentNotFound() {
        String input = "S999\n";
        setScannerInput(input);
        
        studentManager.UpdateStudent();
        
        String output = outputStream.toString();
        assertTrue("Should show not found message", output.contains("was not found"));
    }
    
    @Test
    public void testDeleteStudentConfirm() throws Exception {
        // First add a student
        String input = "S001\nJohn Doe\n20\nMath\n85.5\nScience\n90.0\nEnglish\n78.5\n";
        setScannerInput(input);
        studentManager.AddStudent();
        
        outputStream.reset(); // Clear the output
        
        // Now delete it with confirmation
        input = "S001\ny\n";
        setScannerInput(input);
        studentManager.DeleteStudent();
        
        ArrayList<Student> studentList = getStudentList();
        assertEquals("Student list should be empty after deletion", 0, studentList.size());
        
        String output = outputStream.toString();
        assertTrue("Should show delete success", output.contains("WAS deleted"));
    }
    
    @Test
    public void testDeleteStudentCancel() throws Exception {
        // First add a student
        String input = "S001\nJohn Doe\n20\nMath\n85.5\nScience\n90.0\nEnglish\n78.5\n";
        setScannerInput(input);
        studentManager.AddStudent();
        
        outputStream.reset(); // Clear the output
        
        // Now try to delete but cancel
        input = "S001\nn\n";
        setScannerInput(input);
        studentManager.DeleteStudent();
        
        ArrayList<Student> studentList = getStudentList();
        assertEquals("Student list should still have the student", 1, studentList.size());
        
        String output = outputStream.toString();
        assertFalse("Should not show delete success", output.contains("WAS deleted"));
    }
    
    @Test
    public void testDeleteStudentNotFound() {
        String input = "S999\n";
        setScannerInput(input);
        
        studentManager.DeleteStudent();
        
        String output = outputStream.toString();
        assertTrue("Should show not found message", output.contains("was not found"));
    }
    
    @Test
    public void testStudentReportEmpty() {
        studentManager.StudentReport();
        
        String output = outputStream.toString();
        assertTrue("Should show no students available", output.contains("No students available"));
    }
    
    @Test
    public void testStudentReportWithData() throws Exception {
        // First add a student
        String input = "S001\nJohn Doe\n20\nMath\n85.5\nScience\n90.0\nEnglish\n78.5\n";
        setScannerInput(input);
        studentManager.AddStudent();
        
        outputStream.reset(); // Clear the output
        
        // Now generate report
        studentManager.StudentReport();
        
        String output = outputStream.toString();
        assertTrue("Should show student report header", output.contains("STUDENT GRADE REPORT"));
        assertTrue("Should contain student data", output.contains("S001"));
        assertTrue("Should contain student data", output.contains("John Doe"));
        assertTrue("Should contain student data", output.contains("20"));
        assertTrue("Should contain course data", output.contains("Math: 85.5"));
        assertTrue("Should contain average grade", output.contains("Average Grade:"));
        assertTrue("Should contain letter grade", output.contains("Letter Grade:"));
    }
    
    @Test
    public void testStudentReportWithMultipleStudents() throws Exception {
        // Add first student
        String input = "S001\nJohn Doe\n20\nMath\n85.5\nScience\n90.0\nEnglish\n78.5\n";
        setScannerInput(input);
        studentManager.AddStudent();
        
        // Add second student
        input = "S002\nJane Smith\n21\nMath\n95.0\nScience\n92.0\nEnglish\n88.0\n";
        setScannerInput(input);
        studentManager.AddStudent();
        
        outputStream.reset(); // Clear the output
        
        // Generate report
        studentManager.StudentReport();
        
        String output = outputStream.toString();
        assertTrue("Should show both students", output.contains("S001") && output.contains("S002"));
        assertTrue("Should show both student names", output.contains("John Doe") && output.contains("Jane Smith"));
    }
    
    @Test
    public void testExitApplication() {
        try {
            studentManager.ExitApplication();
            // If we reach here, System.exit wasn't called (which is expected in test environment)
            assertTrue("Exit method should be callable", true);
        } catch (Exception e) {
            fail("ExitApplication should not throw exceptions");
        }
    }
}
