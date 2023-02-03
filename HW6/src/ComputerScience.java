/**
 * Creating the ComputerScience class.
 * @author dved6
 * @version 13.1
 */
public class ComputerScience extends Course {
    //Creating instance variables.
    private String language;

    /**
     * Creating the first constructor.
     * @param courseName input
     * @param id input
     * @param professorName input
     * @param language input
     */
    public ComputerScience(String courseName, int id, String professorName, String language) {
        super(courseName, id, professorName);
        if (language.isEmpty() || language == null) {
            throw new IllegalArgumentException("The string describing the language is either empty or null.");
        } else {
            this.language = language;
        }
    }

    //Overriding the toString method.
    @Override
    public String toString() {
        return "ComputerScience," + getCourseName() + "," + getId() + "," + getProfessorName() + "," + this.language;
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

        ComputerScience cs = (ComputerScience) o;

        if (!this.getCourseName().equals(cs.getCourseName())) {
            return false;
        }

        if (!this.getProfessorName().equals(cs.getProfessorName())) {
            return false;
        }

        if (this.getId() != cs.getId()) {
            return false;
        }

        if (!this.language.equals(cs.language)) {
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
    public String getLanguage() {
        return language;
    }

    /**
     * Setter.
     * @param language input
     */
    public void setLanguage(String language) {
        this.language = language;
    }
}
