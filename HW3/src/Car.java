/** Creating a class called car that represents a normal car.
*@author dved6
*@version 13.1
*/
public class Car extends Vehicle {
    // Declaring the instance variables
    private double rate;
    private double fees;
    private int maxNumMiles;
    /**
     * Making the first constructor.
     * @param id input
     * @param numMiles input
     * @param passengers input
     * @param rate input
     * @param fees input
     * @param maxNumMiles input
    */
    public Car(String id, int numMiles, String[] passengers, double rate, double fees, int maxNumMiles) {
        super(id, numMiles, passengers);
        this.rate = rate;
        this.fees = fees;
        this.maxNumMiles = maxNumMiles;
    }

    /**
     * Making the second construtor.
     * @param id input
     * @param numMiles input
     * @param maxNumMiles input
     */
    public Car(String id, int numMiles, int maxNumMiles) {
        this(id, numMiles, new String[3], 10.0, 15.0, maxNumMiles);
    }

    /**
     * Making the third constructor.
     * @param id input parameter
     */
    public Car(String id) {
        this(id, 10, new String[3], 10.0, 15.0, 200);
    }

    /**
     * Making the canDrive method.
     * @param distance input
     * @return output
     */
    public boolean canDrive(int distance) {
        double compareValue;
        compareValue = maxNumMiles - distance - getNumMiles();
        return (!(compareValue < 0.0)) && (distance >= 0);
    }

    /**
     * Making the calculateCost method.
     * @param distance input parameter
     * @return double
     */
    public double calculateCost(int distance) {
        if (!(this.canDrive(distance))) {
            return -1;
        } else {
            //Calculating the cost of the car for that distance
            return ((rate * distance) + fees);
        }
    }

    /**
     * Creating the addPassenger method.
     * @param distance input
     * @param newPassengers input
     * @return ouptut
     */
    public boolean addPassenger(int distance, String[] newPassengers) {
        // Counting the number of nulls in the array
        int nullCount = 0;
        for (String passenger : passengers) {
            if (passenger == null) {
                nullCount++;
            }
        }

        //Checking if the number of nulls in equal to the number of new passengers
        if ((newPassengers.length == nullCount) && (this.canDrive(distance))) {
            String[] finalPassenger = new String[passengers.length];
            // Iterating through this string and the passengers string at the same time
            int b = 0;
            for (int a = 0; a < finalPassenger.length; a++) {
                if (passengers[a] == null) {
                    finalPassenger[a] = newPassengers[b];
                    b++;
                } else if (passengers[a] != null) {
                    passengers[a] = passengers[a];
                    b++;
                }
            }
            chargeRide(distance);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Overriding the equals method.
     * @param o input
     * @return output
     * @Overrides the equals method
     */
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }
        Car c = new Car(getId());
        if (c.getId().equals(this.getId())) {
            return true;
        }
        if (c.getNumMiles() != this.getNumMiles()) {
            return false;
        }
        if (c.rate != this.rate) {
            return false;
        }
        if (c.fees != this.fees) {
            return false;
        }
        return c.maxNumMiles == this.maxNumMiles;
    }

    /**
     * Overiding the toString method.
     * @return output
     * @Overrides toString method
     */
    public String toString() {
        String output = "Car " + super.toString() + " It can only drive "
            + Math.round(maxNumMiles * 100) / 100 + " miles. It costs "
            + String.format("%.2f", rate) + " dollars per mile and there is a one-time fee of "
            + String.format("%.2f", fees) + " dollars.";
        return output;
    }


    /**
     * Getter for rate.
     * @return output
     */
    public double getRate() {
        return rate;
    }

    /**
     * Getter for fees.
     * @return output
     */
    public double getFees() {
        return fees;
    }

    /**
     * Getter for maxnummiles.
     * @return output
     */
    public int getMaxNumMiles() {
        return maxNumMiles;
    }

    /**
     * Setter for rate.
     * @param rate input
     */
    public void setRate(int rate) {
        this.rate = rate;
    }

    /**
     * Setter for fees.
     * @param fees input
     */
    public void setFees(int fees) {
        this.fees = fees;
    }

    /**
     * Setter for maxnummiles.
     * @param maxNumMiles input
     */
    public void setMaxNumMiles(int maxNumMiles) {
        this.maxNumMiles = maxNumMiles;
    }
}
