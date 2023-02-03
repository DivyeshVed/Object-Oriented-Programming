import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Creating the LinkedList class that implements from List.
 * @author dved6
 * @version 13.1
 * @param <T> input
 */
public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private int size;

    /**
     * Creating the constructor.
     */
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Creating the second constructor.
     * @param input input
     */
    public LinkedList(T[] input) {
        this.head.setData(input[0]);
        Node<T> curr = head;
        size = 1;
        for (int i = 0; i < input.length - 1; i++) {
            curr.setNext(new Node<T>(input[i + 1], null));
            size++;
        }
    }

    /**
     * Overriding the add method.
     * @param element data we are adding to the list
     */
    @Override
    public void add(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Can't add null element");
        }
        Node<T> temp = new Node<T>(element);
        if (this.head == null) {
            head = temp;
        } else {
            Node<T> curr = head;
            while (curr.getNext() != null) {
                curr = curr.getNext();
            }
            curr.setNext(temp);
        }
        size++;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        if (element == null) {
            throw new IllegalArgumentException("Can't add null element");
        }
        if (size == 0) {
            add(element);
        }
        if (index == 0) {
            Node<T> newNode = new Node<T>(element, head);
            head = newNode;
            size++;
        } else {
            Node<T> curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.getNext();
            }
            Node<T> newNode = new Node<T>(element, curr.getNext());
            curr.setNext(newNode);
            size++;
        }
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        Node<T> curr = head;
        if (index == 0) {
            head = curr.getNext();
        }
        if (size == 1) {
            T store = head.getData();
            clear();
            return store;
        }
        for (int i = 0; i < index - 1; i++) {
            curr = curr.getNext();
        }
        T store = curr.getNext().getData();
        curr.setNext(curr.getNext().getNext());
        size--;
        return store;
    }

    @Override
    public T remove(T element) {
        Node<T> curr = head;
        for (int i = 0; i < size; i++) {
            curr = curr.getNext();
            if (curr.getNext().getData() == element) {
                T temp = curr.getNext().getData();
                curr.setNext(curr.getNext().getNext());
                size--;
                return temp;
            }
        }
        throw new NoSuchElementException("This element does not exist in the linkedlist");
    }


    @Override
    public T remove() {
        Node<T> curr = head;
        T temp = curr.getData();
        if (size == 1) {
            clear();
            return temp;
        }
        head.setData(curr.getNext().getData());
        head.setNext(curr.getNext().getNext());
        size--;
        return temp;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        } else if (index == 0) {
            return head.getData();
        } else {
            Node<T> curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.getNext();
            }
            return curr.getData();
        }
    }

    @Override
    public boolean contains(T element) {
        if (isEmpty()) {
            return false;
        }
        Node<T> curr = head;
        for (int i = 0; i < size - 1; i++) {
            if (curr.getData() == element) {
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }


    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        if (element == null) {
            throw new IllegalArgumentException("Can't add null element");
        }
        Node<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.getNext();
        }
        T store = curr.getData();
        curr.setData(element);
        return store;

    }

    /**
     * Creating the toArray method.
     * @return output
     */
    public T[] toArray() {
        T[] store = (T[]) (new Object[this.size]);
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            store[i] = current.getData();
            current = current.getNext();
        }
        return store;
    }

    /**
     * Creating the removeDuplicates method.
     */
    public void removeDuplicates() {
        Node<T> current = head;
        Node<T> index = null;
        Node<T> temp = null;

        if (head == null) {
            return;
        } else {
            while (current != null) {
                temp = current;
                index = current.getNext();
                while (index != null) {
                    if (current.getData() == index.getData()) {
                        temp.setNext(index.getNext());
                        size--;
                    } else {
                        temp = index;
                    }
                    index = index.getNext();
                }
                current = current.getNext();
            }
        }

    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /**
     * Cerating getter.
     * @return output
     */
    public Node<T> getHead() {
        return head;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<T>(this);
    }

    /**
     * Creating the printlln method.
     */
    public void printLL() {
        Node<T> curr = head;
        for (int i = 0; i < size; i++) {
            System.out.println(curr.getData());
            curr = curr.getNext();
        }
    }

    /**
     * Creating a printArray method.
     * @param bob input
     */
    public void printArray(Object[] bob) {
        for (int i = 0; i < bob.length; i++) {
            System.out.println(bob[i]);
        }

    }

//    /**
//     * Creating main method for testing.
//     * @param args
//     */
//    public static void main(String args[]) {
//        LinkedList<String> ll = new LinkedList<String>();
//        ll.add("Hi3");
//        ll.add("Hi5");
//        ll.add("Hi4");
//        ll.add("Hi3");
//        ll.add("Hi2");
//        ll.add("Hi1");
//
//        System.out.println("This is our basic linked list:");
//        System.out.println(ll.get(0));
//        System.out.println(ll.get(1));
//        System.out.println(ll.get(2));
//        System.out.println(ll.get(3));
//        System.out.println(ll.get(4));
//        System.out.println(ll.get(5));
//        System.out.println();
//        System.out.println();
//        System.out.println();

    // System.out.println("size: " + ll.size());
    // System.out.println("Removing Hi2");
    // ll.remove("Hi2");
    // System.out.println("Updated LinkedList");
    // ll.printLL();
    // System.out.println("size: " + ll.size());

    // System.out.println("Removing the 1st element");
    // ll.remove(0);
    // System.out.println("Updated LinkedList");
    // ll.printLL();
    // System.out.println("size: " + ll.size());

    // System.out.println("Removing the 3rd element");
    // ll.remove(2);
    // ll.printLL();
    // System.out.println("size: " + ll.size());


    // ll.add(3, "Hiiiii");
    // System.out.println("Updated LinkedList");
    // ll.printLL();


    // System.out.println(ll.isEmpty());
    // ll.clear();
    // System.out.println(ll.isEmpty());
    // ll.printLL();


    // ll.printLL();
    // System.out.println(ll.size);
    // ll.add(0,"Hi1");
    // ll.printLL();
    // System.out.println(ll.size);

    // ll.remove();
    // System.out.println("Removed the first element");
    // System.out.println(ll.size());
    // ll.printLL();

    // ll.remove();
    // System.out.println("Removed the second element");
    // System.out.println(ll.size());
    // ll.printLL();

    // ll.printLL();

    // System.out.println(ll.contains("Hi3"));
    //ll.printArray(ll.toArray());
    // ll.removeDuplicates();
    // ll.printLL();
}
