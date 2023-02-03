/**
 * Creating a class called GarageOwner.
 *
 * @author dved6
 * @version 13.31
 */
public class GarageOwner {
    private String name;
    private int age;
    private int carsOwned;

    /**
     * Cretaing a constructr called GarageOwner.
     * @param name the name
     * @param age the age
     */
    public GarageOwner(String name, int age) {
        this.name = name;
        this.age = age;
        this.carsOwned = 0;
    }
    /**
     * Gets the name.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the age.
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age.
     * @param age the age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the number of cars owned.
     * @return cars owned
     */
    public int getCarsOwned() {
        return carsOwned;
    }

    /**
     * Sets the number of cars owned.
     * @param carsOwned the number of cars owned
     */
    public void setCarsOwned(int carsOwned) {
        this.carsOwned = carsOwned;
    }


}