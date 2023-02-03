/**
 * Creating a class.
 * @author dved6
 * @version 13.1
 */
public class IceCream extends Dessert {
    // Making the instance variables.
    private int scoops;
    private boolean cone;

    /**
     *  Creating the first constructor.
     * @param flavor input.
     * @param sweetness input
     * @param scoops input
     * @param cone input
     */
    public IceCream(String flavor, double sweetness, int scoops, boolean cone) {
        super(flavor, sweetness);
        this.scoops = scoops;
        this.cone = cone;
    }

    /**
     * Constructor.
     * @param scoops input
     * @param cone input
     */
    public IceCream(int scoops, boolean cone) {
        super("vanilla", 45.0);
        this.cone = cone;
        this.scoops = scoops;
    }

    //Default construtor.
    public IceCream() {
        super("vanilla", 45.0);
        this.scoops = 1;
        this.cone = false;
    }

    // Creating the toString method
    @Override
    public String toString() {
        if (cone) {
            return "This is a " + getFlavor() + " ice cream with " + scoops + " scoops and has a cone.";
        } else {
            return "This is a " + getFlavor() + " ice cream with " + scoops + " scoops and does not have a cone.";
        }
    }

    // Creating the equals method
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
        IceCream i = (IceCream) obj;
        if (this.getFlavor().equals(i.getFlavor()) && this.getSweetness() == i.getSweetness()
                && (this.scoops == i.scoops) && (this.cone == i.cone)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Getter.
     * @return output
     */
    public int getScoops() {
        return scoops;
    }

    /**
     * Setter.
     * 
     */
    public void setScoops() {
        this.scoops = scoops;
    }

    public boolean getCone() {
        return cone;
    }

    public void setCone() {
        this.cone = cone;
    }
}
