/**Creating a class called vehicle.
 *@author dved6
 *@version 13.1
 */
public abstract class Vehicle {
    private final String id; // Creating a string that is immutable
    protected int numMiles;
    protected String[] passengers;
    private double earnings;

    /**
     * First constructor.
     * @param id input
     * @param earnings input
     * @param numMiles input
     * @param passengers input
     */
    public Vehicle(String id, double earnings, int numMiles, String[] passengers) {
        //Setting the values of the variables
        this.id = id;
        this.earnings = 0.0; //Setting it to the default
        this.numMiles = numMiles;
        this.passengers = passengers;
    }


    /**
     * Creating constructor that can be used as a super constructor for the Car class.
     * @param id input
     * @param numMiles input
     * @param passengers input
     */
    public Vehicle(String id, int numMiles, String[] passengers) {
        this.id = id;
        this.numMiles = numMiles;
        this.passengers = passengers;
    }

    /**
     * Third constructor.
     * @param id input
     * @param passengers input
     */
    public Vehicle(String id, String[] passengers) {
        this(id, 0.0, 0, passengers);
    }


    /**
     * canDrive method.
     * @param distance input
     * @return output
     */
    public abstract boolean canDrive(int distance);

    /**
     * calculateCost method.
     * @param distance input
     * @return output
     */
    public abstract double calculateCost(int distance);

    /**
     * addPassenger method.
     * @param distance input
     * @param newPassengers input
     * @return output
     */
    public abstract boolean addPassenger(int distance, String[] newPassengers);

    /**
     * chargeRide method.
     * @param distance input
     */
    public void chargeRide(int distance) {
        numMiles += distance;
        earnings += calculateCost(distance);
    }

    /**
     * OVerrides equals method.
     * @param obj input
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Vehicle v = (Vehicle) obj;
        if (this.id.equals(v.id)) {
            return false;
        }
        return this.numMiles == v.numMiles;
    }

    /**
     * OVerdining string method.
     * @return output
    */
    public String toString() {
        String outputString = id + " has driven " + Math.round(numMiles * 100) / 100
            + " miles and has earned " + String.format("%.2f", earnings) + " dollars.";
        return outputString;
    }

    /**
     * Earnings getter.
     * @return output
     */
    public double getEarnings() {
        return earnings;
    }

    /**
     * Setter for earnings.
     * @param earnings input
     */
    public void setEarnings(double earnings) {
        this.earnings = earnings;
    }

    /**
     * Getter for numMiles.
     * @return output
     */
    public int getNumMiles() {
        return numMiles;
    }

    /**
     * Setter for numMiles.
     * @param numMiles input
     */
    public void setNumMiles(int numMiles) {
        this.numMiles = numMiles;
    }

    /**
     * Getter for id.
     * @return output
     */
    public String getId() {
        return id;
    }
}



