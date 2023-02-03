/**Creating the Hippo class.
 *@author dved6
 *@version 13.1
*/
public class Hippo extends Pet {
    //Creating the buff variable.
    private int buff;

    /**
     * Constructor.
     * @param health inp
     * @param attack inp
     * @param buff inp
     */
    public Hippo(int health, int attack, int buff) {
        super(health, attack);
        if (this.buff < 0){
            this.buff = 0;
        } else{
            this.buff = buff;
        }
    }

    /**
     * Creating the second constructor.
     */
    public Hippo() {
        this(7, 4, 2);
    }

    /**
     * Creating the getBuffed method.
     */
    public void getBuffed() {
        setHealth(getHealth() + buff);
        setAttack(getAttack() + buff);
    }

    //Creating the attackPet method.
    @Override
    public void attackPet(Pet preyPet) {
        super.attackPet(preyPet);
    }

    //Overriding the toString method.
    @Override
    public String toString() {
        String output = "Hippo:" + super.toString() + "/" + buff;
        return output;
    }

    /**
     * Getter.
     * @return out
     */
    public int getBuff() {
        return buff;
    }

    /**
     * Setter.
     * @param buff inp
     */
    public void setBuff(int buff) {
        this.buff = buff;
    }

    /**
     * Creating the hasFainted method.
     * @return out
     */
    public boolean hasFainted() {
        if (this.getHealth() <= 0) {
            return true;
        }
        return false;
    }
}
