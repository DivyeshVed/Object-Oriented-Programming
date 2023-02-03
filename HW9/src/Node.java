/**
 * Creating the Node class.
 * @author dved6
 * @version 13.1
 * @param <T> input
 */
public class Node<T> {
    //Creating the generic data type varibale.
    private T data;
    private Node<T> next;

    /**
     * Creating the constructor.
     * @param data input
     * @param next input
     */
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Creating the second constructor.
     */
    public Node() {
        this(null, null);
    }

    /**
     * Creating the third constructor.
     * @param data input
     */
    public Node(T data) {
        this(data, null);
    }

    /**
     * Writing setters and getters.
     * @return output
     */
    public Node<T> getNext() {
        return this.next;
    }

    /**
     * Writing setters and getters.
     * @param next input
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * Writing setters and getters.
     * @return output
     */
    public T getData() {
        return this.data;
    }

    /**
     * Writing setters and getters.
     * @param data input
     */
    public void setData(T data) {
        this.data = data;
    }
}
