/**
 * Creating a turtle class that is a child class of pet.
 * @author dved6
 * @version 13.1
 */
public class Turtle extends Pet {
    //Creating the melonArmor variable.
    private boolean melonArmor;

    /**
     * Constructor.
     * @param health inp
     * @param attack inp
     * @param melonArmor inp
     */
    public Turtle(int health, int attack, boolean melonArmor) {
        super(health, attack);
        this.melonArmor = melonArmor;
    }

    /**
     * Constructor.
     */
    public Turtle() {
        this(4, 2, true);
    }


    /**
     * Making the getAttacked method. Overiding the one in the Pet class.
     * @param damage inp
     */
    public void getAttacked(int damage) {
        if (melonArmor) {
            damage -= 20;
        }
        setHealth(getHealth() - damage);
    }

    /**
     * Creating the toString method.
     * @return out
     */
    public String toString() {
        String output = "Turtle:" + super.toString() + "/" + melonArmor;
        return output;
    }

    /**
     * Creating the getters and setters that are needed.
     * @return out
     */
    public boolean getMelonArmor() {
        return melonArmor;
    }

    /**
     * Creating the getters and setters that are needed.
     * @param melonArmor inp
     */
    public void setMelonArmor(boolean melonArmor) {
        this.melonArmor = melonArmor;
    }

    /**
     * Hasfainted method.
     * @return out
     */
    public boolean hasFainted() {
        if (this.getHealth() <= 0) {
            return true;
        }
        return false;
    }
}
