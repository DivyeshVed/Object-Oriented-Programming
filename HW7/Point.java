/**
 * Provided Point class for use in HW07.
 *
 * @author CS1331 TAs
 * @version 13.31
 */
public class Point {
    /**
     * The x-value of this Cartesian coordinate.
     */
    private final int x;

    /**
     * The y-value of this Cartesian coordinate.
     */
    private final int y;

    /**
     * Creates a new Cartesian coordinate with the corresponding x and y values.
     *
     * @param x the x-value for this Cartesian coordinate
     * @param y the y-value for this Cartesian coordinate
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the String representation of this Point in the format "(x,y)".
     *
     * @return the String representation of this Point in the format "(x,y)"
     */
    public String toString() {
        return String.format("(%d,%d)", x, y);
    }

    /**
     * Returns the String representation of an array of Points.
     *
     * @param points array of points
     * @return the String representation of an array of Points
     */
    public static String toString(Point[] points) {
        if (points == null) {
            return "null";
        } else {
            StringBuilder sb = new StringBuilder("[");
            for (Point p : points) {
                sb.append(p + " ");
            }
            sb.setCharAt(sb.length() - 1, ']');
            return sb.toString();
        }
    }

    /**
     * Generates an array of Points with random values. The length of the array is specified by length.
     * The range of values will be from [-magnitude, magnitude] (i.e. inclusive on both bounds).
     *
     * @param length the number of desired Points in the array
     * @param magnitude the magnitude of the range of points
     * @throws IllegalArgumentException if length < 0
     * @return the String representation of an array of Points
     */
    public static Point[] getArrayOfRandomPoints(int length, int magnitude) throws IllegalArgumentException {
        if (length < 0) {
            throw new IllegalArgumentException("length must be non-negative");
        }
        Point[] points = new Point[length];
        magnitude = Math.abs(magnitude);
        for (int i = 0; i < length; i += 1) {
            points[i] = new Point((int) (Math.random() * (magnitude * 2 + 1)) - magnitude,
                    (int) (Math.random() * (magnitude * 2 + 1)) - magnitude);
        }
        return points;
    }

    /**
     * Get the X coordinate.
     *
     * @return x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Get the X coordinate.
     *
     * @return y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Test driver for Point class.
     * @param args input arguments
     */
    public static void main(String[] args) {
        Point p = new Point(5, 11);
        System.out.println(p);

        Point[] points = Point.getArrayOfRandomPoints(10, 3);
        System.out.println(Point.toString(points));

        Point[] points2 = Point.getArrayOfRandomPoints(15, -5);
        System.out.println(Point.toString(points2));
    }
}