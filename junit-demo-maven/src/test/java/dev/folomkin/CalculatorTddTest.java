package dev.folomkin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTddTest {

    private CalculatorTdd calculator;

    private int arg1;
    private int arg2;

    private int result;


    @BeforeEach
    public void setUp() {
        calculator = new CalculatorTdd();
    }

    @AfterEach
    public void tearDown() {
        calculator = null;
    }

    @Test
    public void testSum() {
        givenArgument(2,2);
        when_command_is(CalculatorTdd.Command.SUM);
        then_result_is(4);
    }

    @Test
    public void testDivide() {
        assertThrows(IllegalArgumentException.class, () -> calculator.div(20, 0));
    }

    private void givenArgument(int arg1, int arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    private void when_command_is(CalculatorTdd.Command command) {
        this.result = calculator.calculate(command, arg1, arg2);
    }

    private void then_result_is(int expected) {
        assertEquals(result, expected);
    }
}
