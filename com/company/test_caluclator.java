package com.company;


import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class test_caluclator {
   icalculator cal = new calculator();
    @Test
    public void testadd (){
        assertEquals(6, cal.add(4,2));
        assertEquals(-10, cal.add(-2,-8));
        assertEquals(4, cal.add(25,-21));
        assertEquals(-5, cal.add(-34,29));
        assertEquals(6, cal.add(6,0));
    }
    @Test
    public void testdivide () {
        assertEquals(5, cal.divide(25,5),0);
        assertEquals(2.5, cal.divide(5,2),0);
        assertEquals(-5, cal.divide(-10,2),0);
        assertEquals(0, cal.divide(0,9),0);
        assertEquals(20, cal.divide(120,6),0);
        assertEquals(16.5, cal.divide(66,4),0);
    }
    @Test
    (expected=java.lang.RuntimeException.class)
    public void divideException() {
        cal.divide(5, 0);
    }
}
