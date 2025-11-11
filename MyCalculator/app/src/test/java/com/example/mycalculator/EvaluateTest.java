package com.example.mycalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import java.math.BigDecimal;

public class EvaluateTest {

    @Test
    public void evaluate_add() {
        assertEquals(5.0, Evaluate.evaluate("2+3").doubleValue(), 1e-9);
    }

    @Test
    public void evaluate_subtract() {
        assertEquals(2.0, Evaluate.evaluate("5-3").doubleValue(), 1e-9);
    }

    @Test
    public void evaluate_multiply() {
        assertEquals(15.0, Evaluate.evaluate("3*5").doubleValue(), 1e-9);
    }

    @Test
    public void evaluate_divide() {
        assertEquals(2.5, Evaluate.evaluate("5/2").doubleValue(), 1e-9);
    }

    @Test
    public void evaluate_mixed_operations() {
        assertEquals(11.0, Evaluate.evaluate("2+3*3").doubleValue(), 1e-9); // 2 + (3×3)
    }

    @Test
    public void evaluate_with_parentheses() {
        assertEquals(15.0, Evaluate.evaluate("(2+3)*3").doubleValue(), 1e-9);
    }

    @Test
    public void evaluate_decimals() {
        assertEquals(5.75, Evaluate.evaluate("2.5+3.25").doubleValue(), 1e-9);
    }

    @Test
    public void evaluate_negative_numbers() {
        assertEquals(-8.0, Evaluate.evaluate("-5-3").doubleValue(), 1e-9);
    }

    @Test(expected = ArithmeticException.class)
    public void evaluate_divide_by_zero() {
        Evaluate.evaluate("5/0");
    }

    @Test
    public void evaluate_invalid_expression() {
        assertThrows(Exception.class, () -> Evaluate.evaluate("5++2"));
    }

    @Test
    public void evaluate_complex_expression() {
        assertEquals(25.0, Evaluate.evaluate("((3+2)*5)").doubleValue(), 1e-9);
    }
}
