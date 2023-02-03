/**
 * Creating a class called Garage.
 *
 * @author dved6
 * @version 13.31
 */

public class Garage {
    private GarageOwner theOwner;
    private Car[] carCatalogue;

    /**
     * Creating a constructor called Garage.
     *
     * @param theOwner input arguement
     * @param carCatalogue input arguement
     */
    public Garage(GarageOwner theOwner, Car[] carCatalogue) {
        this.theOwner = theOwner;
        this.carCatalogue = carCatalogue;
    }

    /**
     * Creating a construtor called Garage with no input arguements.
     */
    public Garage() {
        this.theOwner = new GarageOwner("Enzo Ferrari", 35);
        this.carCatalogue = new Car[4];
    }

    /**
     * Creating a method that addCar.
     *
     * @param index input arguement
     * @param c input arguement
     * @return previous
     */
    public Car addCar(int index, Car c) {
        if (c == null) {
            System.out.println("Cannot add a car to this spot");
            return null;
        }
        if (index < 0 || index > 3) { // Checking if index is greater than 3 because the array size is 4
            System.out.println("Cannot add a car to this spot");
            return null;
        }
        if (carCatalogue[index] == null) {
            carCatalogue[index] = c;
            System.out.println("A " + carCatalogue[index].getColor() + " " + carCatalogue[index].getYear()
                + " " + carCatalogue[index].getMake() + " " + carCatalogue[index].getModel()
                + " was just parked here.");
            theOwner.setCarsOwned(theOwner.getCarsOwned() + 1);
            return null;
        }
        Car prev = carCatalogue[index];
        System.out.println("There was a " + prev.getColor() + " " + prev.getYear() + " " + prev.getMake()
            + " " + prev.getModel() + " here before.");
        carCatalogue[index] = c;
        return prev;
    }

    /**
     * Creating a method called sellCar.
     *
     * @param index input arguement
     * @return store
     */
    public Car sellCar(int index) {
        if (index < 0 || index > 3) {
            System.out.println("There was no car to sell!");
            return null;
        }
        if (carCatalogue[index] == null) {
            System.out.println("There was no car to sell!");
            return null;
        }
        Car store = carCatalogue[index];
        System.out.println(theOwner.getName() + " just sold a " + store.getColor() + " " + store.getYear()
            + " " + store.getMake() + " " + store.getModel());
        carCatalogue[index] = null;
        theOwner.setCarsOwned(theOwner.getCarsOwned() - 1);
        return store;
    }

    /**
     * Creating a method called showCertainCars.
     *
     * @param conditionCat input arguement
     */
    public void showCertainCars(int conditionCat) {
        for (int i = 0; i < carCatalogue.length; i++) {
            if (carCatalogue[i] != null && carCatalogue[i].getConditionCategory() > conditionCat) {
                System.out.println("A " + carCatalogue[i].getColor() + " " + carCatalogue[i].getYear()
                    + " " + carCatalogue[i].getMake() + " " + carCatalogue[i].getModel()
                    + " with a condition category of " + carCatalogue[i].getConditionCategory());
            }
        }
    }
}