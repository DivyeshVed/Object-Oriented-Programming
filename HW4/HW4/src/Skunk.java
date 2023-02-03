/**Creating the Skunk class.
 *@author dved6
 *@version 13.1
*/
public class Skunk extends Pet {
    //Creating the numSpray variable.
    private int numSpray;

    /**
     * Constructor.
     * @param health inp
     * @param attack inp
     * @param numSpray inp
     */
    public Skunk(int health, int attack, int numSpray) {
        super(health, attack);
        if (numSpray < 0) {
            this.numSpray = 0;
        } else {
            this.numSpray = numSpray;
        }
    }

    /**
     * Creating the second constructor.
     */
    public Skunk() {
        this(5, 3, 1);
    }

    /**
     * Creating the sprayPet.
     * @param pet inp
     */
    public void sprayPet(Pet pet) {
        pet.setAttack(2 * (pet.getAttack() / 3));
        pet.setHealth(2 * (pet.getHealth() / 3));
        this.numSpray -= 1;
    }

    /**
     * Overriding the attackPet method.
     * @param preyPet inp
     */
    public void attackPet(Pet preyPet) {
        if (numSpray >= 1) {
            this.sprayPet(preyPet);
        }
        preyPet.getAttacked(this.getAttack());
    }

    //Overriding the toString method.
    @Override
    public String toString() {
        String output = "Skunk:" + super.toString() + "/" + numSpray;
        return output;
    }

    /**
     * Getters and setters for numSpray.
     * @return out
     */
    public int getNumSpray() {
        return numSpray;
    }

    /**
     * Getters and setters for numSpray.
     * @param numSpray inp
     */
    public void setNumSpray(int numSpray) {
        this.numSpray = numSpray;
    }

    /**
     * Created the hasFainted Method.
     * @return out
     */
    public boolean hasFainted() {
        if (this.getHealth() <= 0) {
            return true;
        }
        return false;
    }
}
