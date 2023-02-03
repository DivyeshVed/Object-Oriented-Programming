/**
 * Creating the InvalidCourseException Class.
 * @author dved6
 * @version 13.1
 */
public class InvalidCourseException extends RuntimeException {
    /**
     * Creating the construtor.
     * @param message input
     */
    public InvalidCourseException(String message) {
        super(message);
    }

    /**
     * Creating the no args constructor.
     */
    public InvalidCourseException() {
        System.out.println("Invalid course type!");
    }
}
