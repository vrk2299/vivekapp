package com.vivek.app;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorServiceTest {

    @Test
    public void testBasic() {
        CalculatorService c = new CalculatorService();
        assertEquals(6, c.evaluate("2+3"), 0.01);
    }

    @Test
    public void testBodmas() {
        CalculatorService c = new CalculatorService();
        assertEquals(14, c.evaluate("2+3*4"), 0.01);
    }

    @Test
    public void testParenthesis() {
        CalculatorService c = new CalculatorService();
        assertEquals(20, c.evaluate("(2+3)*4"), 0.01);
    }

    @Test
    public void testPower() {
        CalculatorService c = new CalculatorService();
        assertEquals(4, c.evaluate("2**2"), 0.01);
    }
}
