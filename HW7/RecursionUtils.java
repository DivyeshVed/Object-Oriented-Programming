/**
 * Provided methods for use in HW07.
 *
 * @author CS1331 TAs
 * @version 13.31
 */
public class RecursionUtils {

    /**
     * Merges together two ascending-order arrays.
     *
     * @param arr1 the first array, sorted in ascending order
     * @param arr2 the second array, sorted in ascending order
     * @return the combined array, sorted in ascending order
     */
    public static String[] merge(String[] arr1, String[] arr2) {
        String[] result = new String[arr1.length + arr2.length];
        int i, j, k;
        i = 0;
        j = 0;
        k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i].compareTo(arr2[j]) <= 0) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }
        return result;
    }

    /**
     * Copies the specified range of the specified String array into a new String array.
     * The initial index of the range (start) must lie between zero
     * and original.length, inclusive.  The value at
     * original[start] is placed into the initial element of the copy
     * (unless start == original.length or start == end).
     * Values from subsequent elements in the original array are placed into
     * subsequent elements in the copy.  The final index of the range
     * (end) must be greater than or equal to start. The length
     * of the returned array will be end - start.
     * <p>
     * The resulting array is of exactly the same class as the original array.
     *
     * @param original the String array from which a range is to be copied
     * @param start the initial index of the range to be copied, inclusive
     * @param end the final index of the range to be copied, exclusive.
     * @return String[] starting at index start to end
     * @throws ArrayIndexOutOfBoundsException if start < 0, start > original.length, end < 0, or end > original.length
     * @throws IllegalArgumentException if start > end
     * @throws NullPointerException if original is null
     */
    public static String[] copyOfRange(String[] original, int start, int end) throws ArrayIndexOutOfBoundsException,
            IllegalArgumentException,
            NullPointerException {
        if (original == null) {
            throw new NullPointerException("array reference \"original\" is null");
        } else if (start > end) {
            throw new IllegalArgumentException(
                    String.format("start index %d is greater than end index %d", start, end));
        } else if (start < 0 || start > original.length) {
            throw new ArrayIndexOutOfBoundsException(
                    String.format("start index %d is out of bounds for array of length %d", start, original.length));
        } else if (end > original.length) {
            throw new ArrayIndexOutOfBoundsException(
                    String.format("end index %d is out of bounds for array of length %d", end, original.length));
        }

        String[] copy = new String[end - start];
        for (int i = start; i < end; i += 1) {
            copy[i - start] = original[i];
        }
        return copy;
    }
}