package dev.folomkin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator = new Calculator(10, 20);

    @Test
    public void shouldCreateCalculatorInstance() {
        assertNotNull(calculator);
    }

    @Test
    public void shouldReturnCorrectSum() {
        assertEquals(30, calculator.calculateSum());
    }
}