package eg.edu.alexu.csd.datastructure.LinkedLists.cs18011305_18011304;


import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SingleLinkedListTest {

    @org.junit.Test
    public void add() {
        SingleLinkedList singleList = new SingleLinkedList();
        singleList.add(0,5);
        singleList.add(1,2);
        singleList.add(2,'m');
        assertEquals(5,singleList.get(0));
        assertEquals(2,singleList.get(1));
        assertEquals('m',singleList.get(2));
    }

    @org.junit.Test
    public void testAdd() {
        SingleLinkedList singleList = new SingleLinkedList();
        singleList.add(8);
        singleList.add('b');
        singleList.add("mmm");
        singleList.add(7);
        assertEquals(8,singleList.get(0));
        assertEquals('b',singleList.get(1));
        assertEquals("mmm",singleList.get(2));
        assertEquals(7,singleList.get(3));
    }

    @org.junit.Test
    public void get() {
        SingleLinkedList singleList = new SingleLinkedList();
        singleList.add("test0");
        singleList.add("test1");
        singleList.add("test2");
        singleList.add(7);
        assertEquals("test0",singleList.get(0));
        assertEquals("test1",singleList.get(1));
        assertEquals("test2",singleList.get(2));
        assertEquals(7,singleList.get(3));
    }

    @org.junit.Test
    public void set() {
        SingleLinkedList singleList = new SingleLinkedList();
        singleList.add(4);
        singleList.add('a');
        singleList.add("test");
        singleList.set(1,5);
        assertEquals(5,singleList.get(1));
    }

    @org.junit.Test
    public void clear() {
        SingleLinkedList singleList = new SingleLinkedList();
        singleList.add(4);
        singleList.add('a');
        singleList.add("test");
        singleList.clear();
        assertEquals(0,singleList.size());
    }

    @org.junit.Test
    public void isEmpty() {
        SingleLinkedList singleList = new SingleLinkedList();
        singleList.add(4);
        singleList.add('a');
        singleList.add("test");
        assertEquals(false,singleList.isEmpty());
        singleList.clear();
        assertEquals(true,singleList.isEmpty());
    }

    @org.junit.Test
    public void remove() {
        SingleLinkedList singleList = new SingleLinkedList();
        singleList.add(4);
        singleList.add('a');
        singleList.add("test");
        assertEquals(3,singleList.size());
        singleList.remove(1);
        assertEquals(2,singleList.size());
        assertEquals("test",singleList.get(1));
    }

    @org.junit.Test
    public void size() {
        SingleLinkedList singleList = new SingleLinkedList();
        singleList.add(4);
        singleList.add('a');
        singleList.add("test");
        assertEquals(3,singleList.size());
    }

    @org.junit.Test
    public void sublist() {
        SingleLinkedList singleList = new SingleLinkedList();
        singleList.add("test");
        singleList.add("mm");
        singleList.add(2);
        singleList.add(8);
        singleList.add('b');
        ILinkedList newList = singleList.sublist(1,3);
        //assertEquals(3, newList.size());
        assertTrue(newList.get(0).equals("mm"));
        assertEquals(2, newList.get(1));
        assertEquals(8, newList.get(2));
    }

    @org.junit.Test
    public void contains() {
        SingleLinkedList singleList = new SingleLinkedList();
        singleList.add(4);
        singleList.add('a');
        singleList.add("test");
        assertEquals(false,singleList.contains(5));
        assertEquals(true,singleList.contains(4));
    }

}
