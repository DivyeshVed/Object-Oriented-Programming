/**
 * Creating a class called GoldenTicket.
 * @author dved6
 * @version 13.1
 */
public class GoldenTicket {
    private String catchphrase;
    private double discount;

    /**
     * Creating the default constructor.
     * @param catchPhrase input arg
     * @param discount input arg
     */
    public GoldenTicket(String catchPhrase, double discount) {
        // Checking the value of the catchPhrase and setting a default value
        if (catchPhrase == null || catchPhrase.isEmpty()) {
            catchphrase = "Congrats!";
        } else {
            this.catchphrase = catchPhrase;
        }

        // Checking the discount value and setting a default value
        if (discount < 0 || discount > 25) {
            this.discount = 15.0;
        } else {
            this.discount = discount;
        }
    }

    /**
     * Creating a methos that returns a statement.
     * @return string
     */
    public String ticketString() {
        return "Golden Ticket with a " + this.discount + "% discount! " + this.catchphrase;
    }

    /**
     * Getter for catchPhrase.
     * @return catchPhrase
     */
    public String getCatchphrase() {
        return catchphrase;
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
        if (discount < 0 || discount > 25) {
            this.discount = 15.0;
        } else {
            this.discount = discount;
        }
    }

    /**
     * Setter for catchPhrase.
     * @param catchphrase input arg
     */
    public void setCatchphrase(String catchphrase) {
        if (catchphrase == null || catchphrase.isEmpty()) {
            this.catchphrase = "Congrats!";
        } else {
            this.catchphrase = catchphrase;
        }
    }
}

