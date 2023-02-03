/**
 * Creating a class called Recursion.
 * @author dved6
 * @version 13.31
 */
public class Recursion {
    /**
     * Creating the main method as a testing method.
     * @param args input
     */
    public static void main(String[] args) {

        //test for mergeSort and countDuplicates method
        //String[] input = {"hello", "google", "cry", "google", "five", "hello"};
        // String[] output = mergeSort(input);
        // for (int i = 0; i < output.length; i++) {
        //     System.out.println(output[i]);
        // }
        // System.out.println(countDuplicates(input));


        //String[] input  = {"A","A", "B", "C", "C", "C", "D"};

        //String[] input = {"Brian", "Alex", "David", "Charlie", "Aaron"};
        // String[] output = mergeSort(input);
        // for (int i = 0; i < output.length; i++) {
        //     System.out.println(output[i]);
        // }
        // System.out.println(countDuplicates(input));

        //test for mergeAll method
        // String[][] input = {{"Alex", "Brian"}, {"Aaron", "David"}, {"Charlie"}};
        // String[] output = mergeAll(input);
        // for (int i = 0; i < output.length; i++) {
        //     System.out.println(output[i]);
        // }

        //test for validatePalindrome method
        // String s1 = "Racecar";
        // System.out.println(verifyPalindrome(s1));

        // String s2 = "hello";
        // System.out.println(verifyPalindrome(s2));

        // String s3 = "hi";
        // System.out.println(verifyPalindrome(s3));

        // String s4 = "rEdiviDer";
        // System.out.println(verifyPalindrome(s4));


        //test for numInteriorPoints method
        // Point[] points = Point.getArrayOfRandomPoints(10, 5);
        // for (Point p: points) {
        //     System.out.println(p.getX() +" " +  p.getY());
        // }
        // System.out.println(numInteriorPoints(points, 5));
    }

    /**
     * Creating the mergeSort method.
     * @param a input
     * @return output
     */
    public static String[] mergeSort(String[] a) {
        String[] output = new String[a.length];
        if (a.length > 1) {
            int mid = a.length / 2;
            String[] left = null;
            String[] right = null;
            if ((a.length % 2) == 0) {
                left = new String[a.length / 2];
                right = new String[a.length / 2];
            } else {
                left = new String[a.length / 2];
                right = new String[(a.length / 2) + 1];
            }
            int x = 0;
            int y = 0;
            for (; x < mid; x++) {
                left[x] = a[x];
            }
            for (; x < a.length; x++) {
                right[y++] = a[x];
            }
            left = mergeSort(left);
            right = mergeSort(right);
            output = RecursionUtils.merge(left, right);
            return output;
        }
        return a;
    }

    /**
     * Creating the mergeAll method.
     * @param s input
     * @return output
     */
    public static String[] mergeAll(String[][] s) {
        int counter = 0;
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                counter++;
            }
        }
        String[] tmp = new String[counter];
        tmp = mergeHelper(s, s[0], s[1], 1);
        tmp = mergeSort(tmp);
        return tmp;

    }

    /**
     * Creating the mergeHelper method.
     * @param s input
     * @param s1 input
     * @param s2 input
     * @param i input
     * @return output
     */
    public static String[] mergeHelper(String[][] s, String[] s1, String[] s2, int i) {
        if (i == (s.length - 1)) {
            return RecursionUtils.merge(s1, s2);
        } else {
            return mergeHelper(s, RecursionUtils.merge(s1, s2), s[i + 1], i + 1);
        }
    }

    /**
     * Creating the verifyPalindrome method.
     * @param str input
     * @return output
     */
    public static boolean verifyPalindrome(String str) {
        if (str == null) {
            return false;
        }
        str = str.toLowerCase();
        if (str.length() <= 1) {
            return true;
        }
        if ((str.charAt(0)) != (str.charAt(str.length() - 1))) {
            return false;
        } else {
            return verifyPalindrome(str.substring(1, str.length() - 1));
        }

    }

    /**
     * Creating the numInteriorPoints method.
     * @param points input
     * @param radius input
     * @return output
     */
    public static int numInteriorPoints(Point[] points, int radius) {
        if (points == null) {
            return 0;
        }
        return numHelperMethod(points, radius, 0);
    }

    /**
     * Creating the numHelperMethod.
     * @param points input
     * @param radius input
     * @param count input
     * @return output
     */
    public static int numHelperMethod(Point[] points, int radius, int count) {
        if (points.length == 0) {
            return count;
        } else {
            Point[] temp = new Point[points.length - 1];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = points[i + 1];
            }
            if (((points[0].getX() * points[0].getX()) + (points[0].getY() * points[0].getY())) < (radius * radius)) {
                return numHelperMethod(temp, radius, count + 1);
            }
            return numHelperMethod(temp, radius, count);
        }

    }

    /**
     * Creating the countDuplicate method.
     * @param str input
     * @return output
     */
    public static int countDuplicates(String[] str) {
        if (str == null || str.length < 2) {
            return 0;
        }
        String[] sorted = mergeSort(str);
        String[] temp = new String[sorted.length - 1];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = sorted[i + 1];
        }
        if (sorted[0].equals(sorted[1])) {
            return 1 + countDuplicates(temp);
        } else {
            return countDuplicates(temp);
        }
    }
}
