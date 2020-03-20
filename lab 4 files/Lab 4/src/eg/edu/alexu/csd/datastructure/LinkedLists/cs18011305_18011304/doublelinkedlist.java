package eg.edu.alexu.csd.datastructure.LinkedLists.cs18011305_18011304;

public class DoubleLinkedList implements ILinkedList {
    public class DoubleNode {
        public Object value;
        public DoubleNode next;
        public DoubleNode prev;
        public DoubleNode (Object element){
            this.value = element;
        }
    }

    private DoubleNode head;
    private DoubleNode tail;
    private int size;

    public DoubleLinkedList(){
        this.size = 0;
    }

    @Override
    public void add(int index, Object element) {
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Out of boundaries indexes");
        }
        DoubleNode newnode = new DoubleNode(element);
        if (index==0){
            newnode.next = head;
            newnode.prev = null;
            head = newnode;
        }
        else {
            DoubleNode i = head;
            for (int count = 0; count < index - 1; count++) {
                i = i.next;
            }
            newnode.next = i.next;
            newnode.prev = i;
            i.next = newnode;
        }
        size++;
    }

    @Override
    public void add(Object element) {
        add(size,element);
    }

    @Override
    public Object get(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Out of boundaries indexes");
        }
        DoubleNode curr = head;
        for (int count = 0; count < index; count++) {
            curr = curr.next;
        }
        return curr.value;
    }

    @Override
    public void set(int index, Object element) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Out of boundaries indexes");
        }
        DoubleNode newnode = new DoubleNode(element);
        DoubleNode j;
        if (index == 0){
            j = head;
            newnode.next = j.next;
            newnode.prev = null;
            head = newnode;
        }
        else {
            DoubleNode i = head;
            for (int count = 1; count < index; count++) {
                i = i.next;
            }
            j = i.next;
            newnode.next = j.next;
            newnode.prev = i;
            i.next = newnode;
            i = j.next;
        }
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void remove(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Out of boundaries indexes");
        }
        if (index == 0){
            head = head.next;
            size--;
        }
        else {
            DoubleNode i = head;
            for (int count = 1 ; count<index ; count++){
                i =i.next;
            }
            DoubleNode j = i.next;
            i.next = j.next;
            j.prev = i;
            size--;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ILinkedList sublist(int fromIndex, int toIndex) {
        // Checking indexes
        if (fromIndex < size && toIndex < size && fromIndex < toIndex && fromIndex >= 0) {
            int size = toIndex - fromIndex + 1;
            DoubleNode i = head;
            for (int j = 0; j < fromIndex; j++) {
                i = i.next;
            }
            ILinkedList sublist = new SingleLinkedList();
            for (int j = 0; j < size; j++) {
                sublist.add(i.value);
                i = i.next;
            }
            return sublist;
        }
        throw new ArrayIndexOutOfBoundsException("Out of boundaries indexes");
    }

    @Override
    public boolean contains(Object o) {
        DoubleNode i = head;
        while (i != null) {
            if (i.value.equals(o)) {
                return true;
            }
            i = i.next;
        }
        return false;
    }
}
