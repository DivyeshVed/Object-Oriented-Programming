/**
 * Creating a class called Car.
 *
 * @author dved6
 * @version 13.31
 */

public class Car {
    private int year;
    private String make;
    private String model;
    private String color;
    private int conditionCategory;
    private boolean isRestored;
    /**
    * Creating a constructor called Car.
    *
    * @param year input arguement
    * @param make input arguement
    * @param model input arguement
    * @param color input arguement
    * @param conditionCategory input arguement
    */
    public Car(int year, String make, String model, String color, int conditionCategory) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.color = color;
        this.conditionCategory = conditionCategory;
        if (conditionCategory > 100 || conditionCategory < 40) {
            this.conditionCategory = 80;
            System.out.println("Excellent");
        }
        if (conditionCategory < 50) {
            System.out.println("Driver");
        }
        if (conditionCategory < 60) {
            System.out.println("Good");
        }
        if (conditionCategory < 70) {
            System.out.println("Very Good");
        }
        if (conditionCategory < 80) {
            System.out.println("Fine");
        }
        if (conditionCategory < 90) {
            System.out.println("Excellent");
        }
        if (conditionCategory < 100) {
            System.out.println("Perfect");
        }
        if (conditionCategory >= 90) {
            this.isRestored = true;
        }

    }

    /**
    * Creating a class called Car.
    *
    * @param year input arguement
    * @param make input arguement
    * @param model input arguement
    */
    public Car(int year, String make, String model) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.color = "blue";
        this.conditionCategory = 80;
        System.out.println("Excellent");
        this.isRestored = false;
    }

    /**
    * Creating a class called Car.
    */
    public Car() {
        this.year = 1960;
        this.make = "Jaguar";
        this.model = "E-Type";
        this.color = "silver";
        this.conditionCategory = 89;
        System.out.println("Excellent");
        this.isRestored = false;
    }


    /**
     * Gets the year.
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the year.
     * @param year the year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Gets the make.
     * @return the make
     */
    public String getMake() {
        return make;
    }

    /**
     * Sets the make.
     * @param make the make
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * Gets the model.
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the model.
     * @param model the model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets the color.
     * @return the color
     * */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color.
     * @param color the color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Gets the condition category.
     * @return the condition category
     */
    public int getConditionCategory() {
        return conditionCategory;
    }

    /**
     * Sets the condition category.
     * @param conditionCategory the condition category
     */
    public void setConditionCategory(int conditionCategory) {
        this.conditionCategory = conditionCategory;
    }

    /**
     * Gets the restoration.
     * @return whether it is restored or not
     */
    public boolean getIsRestored() {
        return isRestored;
    }

    /**
     * Sets the isRestored.
     * @param isRestored whether it has been restored or not
     */
    public void setIsRestored(boolean isRestored) {
        this.isRestored = isRestored;
    }
}