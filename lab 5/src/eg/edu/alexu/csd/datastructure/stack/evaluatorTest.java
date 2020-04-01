package eg.edu.alexu.csd.datastructure.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class evaluatorTest {

    @Test
    public void infixToPostfix() {
        evaluator evl = new evaluator();
        assertEquals("2 3 4 * +",evl.infixToPostfix("2 + 3 * 4"));
        assertEquals("a b * 5 +",evl.infixToPostfix("a * b + 5"));
        assertEquals("1 2 + 7 *",evl.infixToPostfix("(1 + 2) * 7"));
        assertEquals("a b * c /",evl.infixToPostfix("a * b / c"));
        assertEquals("a b c - d + / e a - * c *",evl.infixToPostfix("(a / (b - c + d)) * (e - a) * c"));
        assertEquals("a b / c - d e * + a c * -",evl.infixToPostfix("a / b - c + d * e - a * c"));
        assertEquals("0 5 - 2 * 4 +",evl.infixToPostfix("-5 * 2 + 4"));
        assertEquals("5 2 5 0 7 - + * +" , evl.infixToPostfix("5 + 2 * (5 + -7)"));
        assertEquals("25 5 / 2 0 7 - * +" , evl.infixToPostfix("25 / 5 + 2 * -7"));
        assertEquals("2 0 5 - * 0 7 - +" , evl.infixToPostfix("2 * -5 + -7"));
    }


    @Test
            (expected=java.lang.RuntimeException.class)
    public void invaledInputException() {
        evaluator evl = new evaluator();
        evl.infixToPostfix("/9+46*8//4");
        evl.infixToPostfix("9+4-8/4*");
        evl.infixToPostfix("-5$4");
        evl.infixToPostfix("5+4&2");
        evl.evaluate("2 / 0");
        evl.evaluate("8 * 7 + -11 / 0");
    }

    @Test
    public void evaluate() {
        evaluator evl = new evaluator();
        assertEquals(8,evl.evaluate("6 2 / 3 - 4 2 * +"));
        assertEquals(14,evl.evaluate("2 3 4 * +"));
        assertEquals(21 , evl.evaluate("1 2 + 7 *"));
        assertEquals(-6 , evl.evaluate("0 5 - 2 * 4 +"));
        assertEquals(1,evl.evaluate("5 2 5 0 7 - + * +"));
        assertEquals(-9,evl.evaluate("25 5 / 2 0 7 - * +"));
        assertEquals(-17,evl.evaluate("2 0 5 - * 0 7 - +"));
    }
}