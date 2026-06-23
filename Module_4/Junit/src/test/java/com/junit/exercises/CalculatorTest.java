package com.junit.exercises;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CalculatorTest {
    private Calculator calculator;

    // Setup method executed before each test case
    @Before
    public void setUp() {
        System.out.println("[SetUp] Initializing Calculator fixture...");
        // Arrange phase (common setup for all tests)
        calculator = new Calculator();
    }

    // Teardown method executed after each test case
    @After
    public void tearDown() {
        System.out.println("[TearDown] Cleaning up Calculator fixture...");
        // Resetting the fixture state
        if (calculator != null) {
            calculator.clearHistory();
            calculator = null;
        }
    }

    @Test
    public void testAdd_PositiveNumbers_ReturnsCorrectSum() {
        // Arrange
        int numberA = 10;
        int numberB = 15;
        int expectedResult = 25;

        // Act
        int actualResult = calculator.add(numberA, numberB);

        // Assert
        assertEquals("The addition result should match the expected value", expectedResult, actualResult);
        
        List<String> history = calculator.getHistory();
        assertEquals("History should contain exactly 1 operation record", 1, history.size());
        assertTrue("History should record the addition operation description", 
                history.get(0).contains("Added 10 and 15 to get 25"));
    }

    @Test
    public void testSubtract_PositiveNumbers_ReturnsCorrectDifference() {
        // Arrange
        int numberA = 20;
        int numberB = 8;
        int expectedResult = 12;

        // Act
        int actualResult = calculator.subtract(numberA, numberB);

        // Assert
        assertEquals("The subtraction result should match the expected value", expectedResult, actualResult);
        
        List<String> history = calculator.getHistory();
        assertEquals("History should contain exactly 1 operation record", 1, history.size());
        assertTrue("History should record the subtraction operation description", 
                history.get(0).contains("Subtracted 8 from 20 to get 12"));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivide_ByZero_ThrowsArithmeticException() {
        // Arrange
        int dividend = 10;
        int divisor = 0;

        // Act
        calculator.divide(dividend, divisor);

        // Assert
        // (Handled by the 'expected' property of the @Test annotation)
    }
}
