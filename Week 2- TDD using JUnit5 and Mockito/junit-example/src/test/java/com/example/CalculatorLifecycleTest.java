package com.example;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorLifecycleTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        // Setup - runs before each test
        calculator = new Calculator();
        System.out.println("Setup: Calculator instance created");
    }

    @After
    public void tearDown() {
        // Teardown - runs after each test
        System.out.println("Teardown: Test completed");
    }

    @Test
    public void testAddition() {
        // Arrange: done in setUp()

        // Act
        int result = calculator.add(10, 5);

        // Assert
        assertEquals("10 + 5 should equal 15", 15, result);
    }

    @Test
    public void testSubtraction() {
        // Arrange: done in setUp()

        // Act
        int result = calculator.subtract(10, 3);

        // Assert
        assertEquals("10 - 3 should equal 7", 7, result);
    }
}
