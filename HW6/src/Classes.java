import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Creating the classes class.
 * @author dved6
 * @version 13.1
 */
public class Classes {
    /**
     * Creating the outputcourses method.
     * @param fileName input
     * @return output
     * @throws FileNotFoundException exception
     */
    public static ArrayList<Course> outputCourses(String fileName) throws FileNotFoundException {
        //Throwing an exception if the file is null or does not exist
        if (fileName.length() == 0) {
            throw new FileNotFoundException();
        }

        //Creating an arraylist to store the objects.
        ArrayList<Course> courseList = new ArrayList<Course>();

        //Reading through the file line by line
        Scanner input = new Scanner(new File(fileName));
        while (input.hasNext()) {
            String line = input.nextLine();
            String[] items = line.split(",");
            if (items[0].equals("ComputerScience")) {
                // Creating the computerScience object if needed.
                ComputerScience cs = new ComputerScience(items[1], Integer.parseInt(items[2]), items[3], items[4]);
                //Adding computorscience object to the course arraylist.
                courseList.add(cs);
            } else if (items[0].equals("LabScience")) {
                //Creating the labsicence object if needed.
                LabScience ls = new LabScience(items[1], Integer.parseInt(items[2]), items[3],
                        Boolean.parseBoolean(items[4]));
                //Adding labscience object to the course arraylist.
                courseList.add(ls);
            } else {
                throw new InvalidCourseException();
            }
        }
        input.close();
        //Returning the course object arraylist.
        return courseList;
    }

    /**
     * Creating the writeCourse method.
     * @param fileToWriteTo input
     * @param courseList2 input
     * @return output
     * @throws FileNotFoundException exception
     */
    public static boolean writeCourses(String fileToWriteTo, ArrayList<Course> courseList2)
            throws FileNotFoundException {
        File fl = new File(fileToWriteTo);
        //Iterating through the arraylist.
        try {
            PrintWriter printWriter = new PrintWriter(fl);
            for (Course course : courseList2) {
                printWriter.append((course.toString() + "\n"));
                printWriter.flush();
            }
            printWriter.close();
        } catch (FileNotFoundException f) {
            System.out.println(f.getMessage());
        }
        //Checking if any writing was done to the file.
        if (fileToWriteTo.length() == 0) {
            System.out.println("Nothing was written to this file.");
            return false;
        }
        return true;
    }

    /**
     * Creating the readCourses method.
     * @param fileToReadFrom input
     * @param crs input
     * @return output
     * @throws FileNotFoundException exception
     */
    public static ArrayList<Integer> readCourses(String fileToReadFrom, Course crs) throws FileNotFoundException {
        //Throwing a file not found exception if the file passed is null or doesn't exist.
        File f = new File(fileToReadFrom);
        if (fileToReadFrom.length() == 0 || f == null) {
            throw new FileNotFoundException();
        }

        //Initialising a line counter.
        int lineCounter = 1;
        //Initialising an integer arrayList
        ArrayList<Integer> intList = new ArrayList<Integer>();
        //Iterating through the file to find the inputted course object.
        Scanner scanner = new Scanner(f);
        while (scanner.hasNext()) {
            String line1 = scanner.nextLine();
            if (crs.toString().equals(line1)) {
                intList.add((Integer) (lineCounter));
            }
            lineCounter++;
        }

        //Checking if the Invalid Course Exception needs to be thrown.
        if (intList.size() > 0) {
            return intList;
        } else {
            throw new InvalidCourseException();
        }
    }


    /**
     * Creating the main method.
     * @param args input
     */
    public static void main(String[] args) {
        //Creating three ComputerScience objects.
        ComputerScience cs1 = new ComputerScience("CS1331", 12345, "Ricky Landry", "Java");
        ComputerScience cs2 = new ComputerScience("CS1371", 67890, "Kantwon Rogers", "MATLAB");
        ComputerScience cs3 = new ComputerScience("CS3630", 98765, "Manavi Rao", "Python");

        //Creating three LabScience objects.
        LabScience ls1 = new LabScience("PHYS2211", 34567, "Rick", true);
        LabScience ls2 = new LabScience("Phys6457", 75869, "Rohan", false);
        LabScience ls3 = new LabScience("CHEM1301", 49857, "Sid", true);

        //Creating an arraylist to hold all the courses.
        ArrayList<Course> inputList = new ArrayList<Course>();
        inputList.add(cs1);
        inputList.add(cs2);
        inputList.add(cs3);
        inputList.add(ls1);
        inputList.add(ls2);
        inputList.add(ls3);

        //Creating a file called TestCourses.csv.
        File myObj = new File("TestCourses.csv");

        //Writing the objects to the file created.
        try {
            writeCourses("TestCourses.csv", inputList);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        //Creating another ComputerScience object and writing it to the data.
        ComputerScience cs4 = new ComputerScience("CS1332", 91234, "Keshav", "Ruby");
//            ArrayList<Course> inputList2 = new ArrayList<>();
        inputList.add(cs4);
        //Adding this new object to the file we created.
        try {
            writeCourses("TestCourses.csv", inputList);
        } catch (FileNotFoundException g) {
            System.out.println(g.getMessage());
        }

        //Reading this csv file.
        try {
            System.out.println(outputCourses("TestCourses.csv"));
        } catch (FileNotFoundException h) {
            System.out.println(h.getMessage());
        }
    }
}
