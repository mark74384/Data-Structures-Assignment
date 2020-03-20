package eg.edu.alexu.csd.datastructure.LinkedLists.cs18011305_18011304;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DoubleLinkedListTest {
    @Test
    public void add() {
        DoubleLinkedList doubleList = new DoubleLinkedList();
        doubleList.add(0,5);
        doubleList.add(1,2);
        doubleList.add(2,'m');
        assertEquals(5,doubleList.get(0));
        assertEquals(2,doubleList.get(1));
        assertEquals('m',doubleList.get(2));
    }

    @Test
    public void testAdd() {
        DoubleLinkedList doubleList = new DoubleLinkedList();
        doubleList.add(8);
        doubleList.add('b');
        doubleList.add("mmm");
        doubleList.add(7);
        assertEquals(8,doubleList.get(0));
        assertEquals('b',doubleList.get(1));
        assertEquals("mmm",doubleList.get(2));
        assertEquals(7,doubleList.get(3));
    }

    @Test
    public void get() {
        DoubleLinkedList doubleList = new DoubleLinkedList();
        doubleList.add("test0");
        doubleList.add("test1");
        doubleList.add("test2");
        doubleList.add(7);
        assertEquals("test0",doubleList.get(0));
        assertEquals("test1",doubleList.get(1));
        assertEquals("test2",doubleList.get(2));
        assertEquals(7,doubleList.get(3));
    }

    @Test
    public void set() {
        DoubleLinkedList doubleList = new DoubleLinkedList();
        doubleList.add(4);
        doubleList.add('a');
        doubleList.add("test");
        doubleList.set(1,5);
        assertEquals(5,doubleList.get(1));
    }

    @Test
    public void clear() {
        DoubleLinkedList doubleList = new DoubleLinkedList();
        doubleList.add(4);
        doubleList.add('a');
        doubleList.add("test");
        doubleList.clear();
        assertEquals(0,doubleList.size());
    }

    @Test
    public void isEmpty() {
        DoubleLinkedList doubleList = new DoubleLinkedList();
        doubleList.add(4);
        doubleList.add('a');
        doubleList.add("test");
        assertEquals(false,doubleList.isEmpty());
        doubleList.clear();
        assertEquals(true,doubleList.isEmpty());
    }

    @Test
    public void remove() {
        DoubleLinkedList doubleList = new DoubleLinkedList();
        doubleList.add(4);
        doubleList.add('a');
        doubleList.add("test");
        assertEquals(3,doubleList.size());
        doubleList.remove(1);
        assertEquals(2,doubleList.size());
        assertEquals("test",doubleList.get(1));
    }

    @Test
    public void size() {
        DoubleLinkedList doubleList = new DoubleLinkedList();
        doubleList.add(4);
        doubleList.add('a');
        doubleList.add("test");
        assertEquals(3,doubleList.size());
    }

    @Test
    public void sublist() {
        DoubleLinkedList doubleList = new DoubleLinkedList();
        doubleList.add("test");
        doubleList.add("mm");
        doubleList.add(2);
        doubleList.add(8);
        doubleList.add('b');
        ILinkedList newList = doubleList.sublist(1,3);
        assertEquals(3, newList.size());
        assertTrue(newList.get(0).equals("mm"));
        Assertions.assertEquals(2, newList.get(1));
        Assertions.assertEquals(8, newList.get(2));
    }

    @Test
    public void contains() {
        DoubleLinkedList doubleList = new DoubleLinkedList();
        doubleList.add(4);
        doubleList.add('a');
        doubleList.add("test");
        assertEquals(false,doubleList.contains(5));
        assertEquals(true,doubleList.contains(4));
    }
}
