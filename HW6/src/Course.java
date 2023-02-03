/**
 * This creates the abstract Course class.
 * @author dved6
 * @version 13.1
 */
public abstract class Course {
    //Creating the instance variables.
    protected String courseName;
    protected int id;
    protected String professorName;

    /**
     * Creating the first constructor.
     * @param courseName input
     * @param id input
     * @param professorName input
     */
    public Course(String courseName, int id, String professorName) {
        if (courseName.isEmpty() || courseName == null || professorName.isEmpty() || professorName == null) {
            throw new IllegalArgumentException("The course or/and the professor name is either "
                    + "null or an empty string.");
        } else {
            this.courseName = courseName;
            this.professorName = professorName;
        }
        if (String.valueOf(id).length() != 5 || id < 0) {
            throw new IllegalArgumentException("The id number has more than 5 characters or is a negative number.");
        } else {
            this.id = id;
        }
    }

    //Overriding the toString method.
    @Override
    public String toString() {
        return courseName + "," + id + "," + professorName;
    }

    //Overriding the equal's method.
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (o.getClass() != this.getClass()) {
            return false;
        }

        Course c = (Course) o;

        if (!c.courseName.equals(this.courseName)) {
            return false;
        }

        if (!c.professorName.equals(this.professorName)) {
            return false;
        }

        if (c.id != this.id) {
            return false;
        }

        return true;
    }

    //Overriding the hashCode definition.
    @Override
    public int hashCode() {
        return this.id;
    }

    /**
     * Making getters and setters for all variables. Delete the ones that are not needed.
     * @return output
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Setter.
     * @param courseName input
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Getter.
     * @return output
     */
    public String getProfessorName() {
        return professorName;
    }

    /**
     * Setter.
     * @param professorName input
     */
    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    /**
     * Getter.
     * @return output
     */
    public int getId() {
        return id;
    }

    /**
     * Setter.
     * @param id input
     */
    public void setId(int id) {
        this.id = id;
    }
}
