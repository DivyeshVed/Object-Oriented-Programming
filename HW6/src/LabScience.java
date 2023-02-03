/**
 * Creating the LabScience class.
 * @author dved6
 * @version 13.1
 */
public class LabScience extends Course {
    //Creating an instance variable.
    private boolean labCoatRequired;

    /**
     * Creating the first construtor.
     * @param courseName input
     * @param id input
     * @param professorName input
     * @param labCoatRequired input
     */
    public LabScience(String courseName, int id, String professorName, boolean labCoatRequired) {
        super(courseName, id, professorName);
        this.labCoatRequired = labCoatRequired;
    }

    //Overriding the toString method.
    @Override
    public String toString() {
        return "LabScience," + getCourseName() + "," + getId() + "," + getProfessorName() + "," + this.labCoatRequired;
    }

    //Overriding the equals method.
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

        LabScience ls = (LabScience) o;

        if (!this.getCourseName().equals(ls.getCourseName())) {
            return false;
        }

        if (!this.getProfessorName().equals(ls.getProfessorName())) {
            return false;
        }

        if (this.getId() != ls.getId()) {
            return false;
        }

        if (Boolean.compare(this.labCoatRequired, ls.labCoatRequired) != 0) {
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
     * Getter.
     * @return output
     */
    public boolean getLabCoatRequired() {
        return labCoatRequired;
    }

    /**
     * Setter.
     * @param labCoatRequired input
     */
    public void setLabCoatRequired(boolean labCoatRequired) {
        this.labCoatRequired = labCoatRequired;
    }
}
