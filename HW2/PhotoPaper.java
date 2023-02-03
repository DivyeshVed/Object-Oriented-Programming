/**
 * Creating a child class from PaperProduct.
 * @author dved6
 * @version 13.1
 */
public class PhotoPaper extends PaperProduct {
    // Declaring the instance variables
    private double glossiness;

    /**
     * Creating the first constructor.
     * @param name input arg
     * @param numberOfSheets input arg
     * @param weightOfUnitSheet input arg
     * @param glossiness input arg
     */
    public PhotoPaper(String name, int numberOfSheets, double weightOfUnitSheet, double glossiness) {
        super(name, numberOfSheets, weightOfUnitSheet);
        // Checking the range for glossiness and assigning it a default value
        if (glossiness < 0 || glossiness > 99) {
            this.glossiness = 70;
        } else {
            this.glossiness = glossiness;
        }
    }

    /**
     * Creating the second constructor.
     * @param name input arg
     * @param numberOfSheets input arg
     */
    public PhotoPaper(String name, int numberOfSheets) {
        this(name, numberOfSheets, -1000, 70);
    }

    /**
     * Creating a constructor that takes in a string.
     * @param name input arg
     */
    public PhotoPaper(String name) {
        this(name, -1000, -100, 70);
    }

    /**
     * Creating a copy constructor.
     * @param toPhotoPaper input arg
     */
    public PhotoPaper(PhotoPaper toPhotoPaper) {
        super(toPhotoPaper);
        this.glossiness = toPhotoPaper.getGlossiness();
    }

    /**
     * Creating a method called photoString.
     * @return string
     */
    public String photoString() {
        return this.glossiness + "% glossy and " + String.format("%.2f", totalWeight()) + "g of "
                + this.getName() + " for $" + String.format("%.2f", totalCost());
    }

    /**
     * Creating a string that takes in the company name.
     * @param companyName input arg
     * @return string
     */
    public String shipPhoto(String companyName) {
        if (getTotalProductsToShip() != 0) {
            return "Paper is " + String.format("%.2f", glossiness) + "% glossy." + ship(companyName);
        } else {
            return "Paper is " + String.format("%.2f", glossiness)
                    + "% glossy. Cannot ship any items, Warehouse is empty!";
        }
    }

    /**
     * Getter for glossiness.
     * @return double
     */
    public double getGlossiness() {
        return glossiness;
    }

    /**
     * Setter for glossiness.
     * @param glossiness input arg
     */
    public void setGlossiness(double glossiness) {
        if (glossiness < 0 || glossiness > 99) {
            this.glossiness = 70;
        } else {
            this.glossiness = glossiness;
        }
    }
}



