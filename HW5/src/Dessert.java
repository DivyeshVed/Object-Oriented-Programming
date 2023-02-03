/**
 * Class Dessert
 * @author dved6
 * @version 13.1
 */
public abstract class Dessert implements Comparable<Dessert> {
    // Creating instance variables.
    private String flavor;
    private double sweetness;

    /**
     * Creating a constructor that takes in flavor and sweetness.
     * @param flavor input.
     * @param sweetness input.
     */
    public Dessert(String flavor, double sweetness) {
        this.flavor = flavor;
        this.sweetness = sweetness;
    }

    /**
     * Creating a default constructor.
     */
    public Dessert() {
        this("vanilla", 25.0);
    }

    // Creating the toString method, rounding sweetness to 2 dp.
    @Override
    public String toString() {
        return "This is a " + flavor + " dessert with a sweetness of " + sweetness + ".";
    }

    // Creating the equals method.
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Dessert d = (Dessert) obj;
        if (flavor.equals(d.flavor)) {
            return false;
        }

        if (d.sweetness != this.sweetness) {
            return false;
        }

        return true;
    }

    //Overriding compareto method.
    @Override
    public int compareTo(Dessert d1) {
        if (this.sweetness > d1.sweetness) {
            return 1;
        } else if (this.sweetness == d1.sweetness) {
            return this.flavor.compareTo(d1.flavor);
        } else {
            return 0;
        }
    }

    /**
     * Adding getter and setter for flavor.
     * @return output.
     */
    public String getFlavor() {
        return flavor;
    }

    /**
     * Adding getter and setter for flavor.
     * @param flavor input.
     */
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    /**
     * Adding getter and setter for sweetness.
     * @return output.
     */
    public double getSweetness() {
        return sweetness;
    }

    /**
     * Adding getter and setter for sweetness.
     * @param sweetness input.
     */
    public void getSweetness(double sweetness) {
        this.sweetness = sweetness;
    }
}
