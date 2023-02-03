/**
 * Creating a class
 * @author dved6
 * @version 13.1
 */
public class Cake extends Dessert {
    // Creating instance variable
    private String frosting;

    /**
     * Creating a constructor that takes in flavor, sweetness and frosting.
     * @param flavor input.
     * @param sweetness input.
     * @param frosting input.
     */
    public Cake(String flavor, double sweetness, String frosting) {
        super(flavor, sweetness);
        this.frosting = frosting;
    }

    /**
     * Default construtor.
     * @param flavor input.
     */
    public Cake(String flavor) {
        super(flavor, 45.0);
        this.frosting = "vanilla";

    }

    /**
     * Overriding toString()
     */
    @Override
    public String toString() {
        String output = "This is a " + getFlavor() + " cake with a " + frosting + " frosting and has a sweetness of "
                + getSweetness() + ".";
        return output;
    }

    /**
     * Equals method.
     */
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
        Cake c = (Cake) obj;
        if (this.getFlavor().equals(c.getFlavor()) && this.getSweetness() == c.getSweetness()
                && (this.frosting.equals(c.frosting))) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Getter.
     * @return output.
     */
    public String getFrosting() {
        return frosting;
    }

    /**
     * setter.
     * @param frosting input.
     */
    public void setFrosting(String frosting) {
        this.frosting = frosting;
    }
}
