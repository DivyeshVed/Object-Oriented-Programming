import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Creating the LinkedListIterator method.
 * @author dved6
 * @version 13.1
 * @param <T> input
 */
public class LinkedListIterator<T> implements Iterator<T> {
    private Node<T> next;

    /**
     * Creating the first iterator.
     * @param list input
     */
    public LinkedListIterator(LinkedList<T> list) {
        next = list.getHead();
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("no next element");
        }
        T data = next.getData();
        next = next.getNext();
        return data;
    }
}
