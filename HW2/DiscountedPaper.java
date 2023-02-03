/**
 * Creates a class called DiscountedPaper which is a child of PaperProduct.
 * @author dved6
 * @version 13.1
 */
public class DiscountedPaper extends PaperProduct {
    private double discount;
    private GoldenTicket ticket = null;

    /**
     * Creates the deafult constructor.
     * @param name input arg
     * @param numberOfSheets input arg
     * @param weightUnitOfSheet input arg
     * @param discount input arg
     * @param ticket input arg
     */
    public DiscountedPaper(String name, int numberOfSheets, double weightUnitOfSheet,
                           double discount, GoldenTicket ticket) {
        super(name, numberOfSheets, weightUnitOfSheet);
        if (discount < 0 || discount > 50) {
            this.discount = 15.0;
        } else {
            this.discount = discount;
        }
        this.ticket = ticket;
    }

    /**
     * Creating another constructor that takes in name and numberOfSheets and parameters.
     * @param name input arg
     * @param numberOfSheets input arg
     */
    public DiscountedPaper(String name, int numberOfSheets) {
        this(name, numberOfSheets, -1, 15, null);
    }

    /**
     * Creating another constructor that takes in no paremeters.
     * @param name input arg
     */
    public DiscountedPaper(String name) {
        this(name, -1, -1, 15, null);
    }

    /**
     * Creating the copy constructor.
     * @param toDiscountedPaper input arg
     */
    public DiscountedPaper(DiscountedPaper toDiscountedPaper) {
        super(toDiscountedPaper);
        if (discount < 0 || discount > 50) {
            this.discount = 15.0;
        } else {
            this.discount = toDiscountedPaper.discount;
        }
        this.ticket = new GoldenTicket(toDiscountedPaper.ticket.getCatchphrase(),
                toDiscountedPaper.ticket.getDiscount());
    }

    /**
     * Creating a methods that returns a double and calcualtes cost after discount.
     * @return result
     */
    public double discountedCost() {
        double result;
        if (this.getTicket() != null) {
            double first = totalCost() * (1 - ((this.discount / 100.0)));
            result = first * (1 - (this.getTicket().getDiscount() / 100.0));
        } else {
            result = totalCost() * (1 - (this.discount / 100.0));
        }
        return result;
    }

    /**
     * Creates a method that tells us whether the product is there to ship.
     * @param companyName input arg
     * @return string
     */
    public String shipDiscounted(String companyName) {
        if (getTotalProductsToShip() == 0) {
            return "Cannot ship any items, Warehouse is empty! The total cost after the discount is "
                    + String.format("%.2f", discountedCost()) + ".";
        } else {
            return ship(companyName) + "The total cost after the discount is "
                    + String.format("%.2f", discountedCost()) + ".";

        }
    }

    /**
     * Creating a method that checks for the goldne ticket discount.
     * @return result
     */
    public String botherAccounting() {
        double goldenTicketDiscount;
        if (ticket == null) {
            goldenTicketDiscount = 0;
        } else {
            goldenTicketDiscount = this.ticket.getDiscount();
        }
        String result = "Discounted Paper Product: \nOriginal Cost: "
                + String.format("%.2f", this.totalCost()) + "\nFinal Cost: "
                + String.format("%.2f", discountedCost()) + "\nOriginal Discount: "
                + String.format("%.2f", this.discount) + "% \nGolden Ticket Discount: "
                + String.format("%.2f", goldenTicketDiscount) + "%";
        return result;
    }

    /**
     * Getter for discount.
     * @return discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * Setter for discount.
     * @param discount input arg
     */
    public void setDiscount(double discount) {
        if (discount < 0 || discount > 50) {
            this.discount = 15.0;
        } else {
            this.discount = discount;
        }
    }

    /**
     * Setter for ticket.
     * @param ticket input arg
     */
    public void setTicket(GoldenTicket ticket) {
        this.ticket = ticket;
    }

    /**
     * Getter for ticket.
     * @return ticket
     */
    public GoldenTicket getTicket() {
        return ticket;
    }

}
