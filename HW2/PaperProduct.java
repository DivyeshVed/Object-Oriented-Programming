/**Used to store details about a paper product in general.
 * @author Divyesh Ved
 * @version 1.0
 */
public class PaperProduct {
    /** Declaring the variables. Each variable is private and is only declaring them, not giving them values. */
    private final String name;
    private int numberOfSheets;
    private final double weightOfUnitSheet;
    private static int totalProductsToShip = 10;

    /** Creating a constant called COST_PER_GRAM which can be accessed from everywhere. */
    public static final double COST_PER_GRAM = 0.025;

    /**
     * Creating a constructor that takes in name, numberOfSheets and weightUnitOfSheet.
     * @param name input arg
     * @param numberOfSheets input arg
     * @param weightOfUnitSheet input arg
     */
    public PaperProduct(String name, int numberOfSheets, double weightOfUnitSheet) {
        /**Checking if the name is null or empty and assigning a default value if it is either. */
        if (name == null || name.isEmpty()) {
            this.name = "A4";
        } else {
            this.name = name;
        }
        //Checking if the number of sheets is valid and assigning it to a default value if it is not
        if (numberOfSheets < 0) {
            this.numberOfSheets = 500;
        } else {
            this.numberOfSheets = numberOfSheets;
        }
        // Checking if the weight of unit sheet is valid, and assigning it a defualt value if it is not valid
        if (weightOfUnitSheet < 0) {
            this.weightOfUnitSheet = 0.25;
        } else {
            this.weightOfUnitSheet = weightOfUnitSheet;
        }
    }

    /**
     * Creating a constructor that takes in name, number of sheets, weight of unit sheet: default value of 0.25.
     * @param name input arg
     * @param numberOfSheets input arg
     */
    public PaperProduct(String name, int numberOfSheets) {
        this(name, numberOfSheets, 0.25);
    }

    /**
     *  Creating a constructor that takes in name, number of sheets, weight of unit sheet: default value of 0.25.
     * @param name input arg
     */
    public PaperProduct(String name) {
        this(name, 500, 0.25);
    }

    /**
     * Copy Constructor.
     * @param toPaperProduct input arg
     */
    public PaperProduct(PaperProduct toPaperProduct) {
        // Copying all the fields from the older object to the new object
        this.name = toPaperProduct.name;
        this.numberOfSheets = toPaperProduct.numberOfSheets;
        this.weightOfUnitSheet = toPaperProduct.weightOfUnitSheet;
    }

    /**
     * Creating a method to calculate the total weight.
     * @return totalWeight
     */
    public double totalWeight() {
        // Calculating the total weight and returning it
        double totalWeight = this.numberOfSheets * this.weightOfUnitSheet;
        return totalWeight;
    }

    /**
     * Creating a method to calculate the totalCost.
     * @return totalCost
     */
    public double totalCost() {
        // Calculating the total cost and returning it
        double totalCost = COST_PER_GRAM * totalWeight();
        return totalCost;
    }

    /**
     * Creating a paperString method.
     * @return string
     */
    public String paperString() {
        // Creating the string to return
        String output = String.format("%.2f", this.totalWeight()) + "g of " + this.name
                + " for $" + String.format("%.2f", this.totalCost()) + ". ";
        return output;
    }

    /**
     * Creating a method called ship, that takes in the company name.
     * @param companyName input arg
     * @return string
     */
    public String ship(String companyName) {
        String output = "";
        // If the totalProductsToShip does not equal zero
        if (totalProductsToShip != 0) {
            output = "Shipped " + String.format("%.2f", this.totalWeight()) + "g of " + this.name + " for $"
                    + String.format("%.2f", this.totalCost()) + " to " + companyName + ". ";
            // Reducing the count of totalProductsToShip by 1
            totalProductsToShip--;
        } else if (totalProductsToShip == 0) {
            output = "Cannot ship any items, Warehouse is empty!";
        }
        return output;
    }

    /**
     * Getter for name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the number of sheets.
     * @return number of sheets
     */
    public int getNumberOfSheets() {
        return numberOfSheets;
    }

    /**
     * Getter for the weight of unit sheet.
     * @return weight of unit sheet
     */
    public double getWeightOfUnitSheet() {
        return weightOfUnitSheet;
    }

    /**
     * Getter for the total products to ship.
     * @return total products to ship
     */
    public static int getTotalProductsToShip() {
        return totalProductsToShip;
    }

    /**
     * Setter for the number of sheets.
     * @param numberOfSheets input arg
     */
    public void setNumberOfSheets(int numberOfSheets) {
        if (numberOfSheets >= 0) {
            this.numberOfSheets = numberOfSheets;
        } else {
            this.numberOfSheets = 500;
        }
    }
}






