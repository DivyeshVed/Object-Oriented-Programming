/**Creating the Pet class.
 *@author dved6
 *@version 13.1
*/
public abstract class Pet implements Comparable<Pet> {
    private int health;
    private int attack;

    /**
     * Creating the first construtor.
     * @param health inp
     * @param attack inp
     */
    public Pet(int health, int attack) {
        if (health <= 0) {
            this.health = 1;
        } else {
            this.health = health;
        }
        if (attack < 0) {
            this.attack = 0;
        } else {
            this.attack = attack;
        }
    }

    /**
     * Creating the abstract hasFainted Method.
     * @return out
     */
    public boolean hasFainted() {
        if (this.getHealth() <= 0) {
            return true;
        }
        return false;
    }

    /**
     * Creating the getAttacked method.
     * @param damage inp
     */
    public void getAttacked(int damage) {
        health = health - damage;
    }

    /**
     * Creating the attackPet method.
     * @param preyPet inp
     */
    public void attackPet(Pet preyPet) {
        preyPet.getAttacked(attack);
    }

    /**
     *Overriding the toString method from the parent class.
     */
    @Override
    public String toString() {
        String output = attack + "/" + health;
        return output;
    }

    /**
     * Comparing the pets using the toCompare method.
     * @param pet inp
     * @return out
     */
    public int compareTo(Pet pet) {
        if (this.attack + this.health == pet.getAttack() + pet.getHealth()) {
            return 0;
        } else if (this.attack + this.health > pet.getAttack() + pet.getHealth()) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * Getter and setters for the attack and health.
     * @return out
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Getter and setters for the attack and health.
     * @param attack inp
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     * Getter and setters for the attack and health.
     * @return out
     */
    public int getHealth() {
        return health;
    }

    /**
     * Getter and setters for the attack and health.
     * @param health inp
     */
    public void setHealth(int health) {
        this.health = health;
    }
}

