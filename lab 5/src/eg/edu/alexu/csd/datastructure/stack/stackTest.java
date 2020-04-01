package eg.edu.alexu.csd.datastructure.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class stackTest {


    @org.junit.Test
    public void pop() {
        stack s = new stack();
        s.push(5);
        s.push("test");
        assertEquals(2,s.size());
        s.pop();
        assertEquals(1,s.size());
        s.pop();
        assertEquals(0,s.size());
    }

    @org.junit.Test
    public void peek() {
        stack s = new stack();
        s.push("test");
        s.push(5);
        s.push(8);
        assertEquals(8,s.peek());
        s.peek();
        assertEquals(3,s.size());
    }

    @org.junit.Test
    public void push() {
        stack s = new stack();
        s.push(5);
        s.push(-7);
        s.push('a');
        assertEquals(3,s.size());
        s.push("test");
        assertEquals(4,s.size());
    }

    @org.junit.Test
    public void isEmpty() {
        stack s = new stack();
        s.push(4);
        s.push(7);
        assertEquals(false,s.isEmpty());
        s.pop();
        s.pop();
        assertEquals(true,s.isEmpty());
    }

    @org.junit.Test
    public void size() {
        stack s = new stack();
        s.push(1);
        assertEquals(1,s.size());
        s.push(2);
        assertEquals(2,s.size());
        s.peek();
        assertEquals(2,s.size());
        s.pop();
        assertEquals(1,s.size());
        s.pop();
        assertEquals(0,s.size());
    }

    @Test
            (expected=java.lang.RuntimeException.class)
    public void invaledInputException() {
        stack s = new stack();
        s.pop();
        s.peek();
    }
}