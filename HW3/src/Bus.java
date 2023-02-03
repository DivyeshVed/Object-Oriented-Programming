/**
 * Creating a class called bus which is a child class of vehicle.
 * @author dved6
 * @version 13.1
 */
public class Bus extends Vehicle {
    private String location;
    private int stopsPerMile;

    /**
     * First constructor.
     * @param id input
     * @param numMiles input
     * @param location input
     * @param stopsPerMile input
     */
    public Bus(String id, int numMiles, String location, int stopsPerMile) {
        super(id, numMiles, new String[20]);
        this.location = location;
        this.stopsPerMile = stopsPerMile;
    }

    /**
     * Second constructor.
     * @param id input
     * @param location input
     */
    public Bus(String id, String location) {
        this(id, 0, location, 2);
    }

    /**
     * canDrive method.
     * @param distance input
     * @return ouput
     */
    public boolean canDrive(int distance) {
        return distance >= 0;
    }

    /**
     * calculateCost method.
     * @param distance input
     * @return output
     */
    public double calculateCost(int distance) {
        if (!canDrive(distance)) {
            return -1.00;
        } else {
            double cost = (distance * 3) / stopsPerMile;
            return cost;
        }
    }

    /**
     * addPassenger method.
     * @param distance input
     * @param passengerArray input
     * @return output
     */
    public boolean addPassenger(int distance, String[] passengerArray) {
        if (canDrive(distance)) {
            int a = 0;
            for (int i = 0; i < passengerArray.length; i++) {
                if (passengerArray[i] == null) {
                    passengers[i] = passengerArray[a];
                    a++;
                } else if (passengers[i] != null) {
                    passengers[i] = passengers[a];
                    a++;
                }
            }
            double earnings = passengers.length * calculateCost(distance);
            int numMiles = distance;
            return true;
        } else {
            return false;
        }
    }

    /**
     * OVeriridng equals method.
     * @param obj input
     * @return output
     * @Overrides euqals method
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Bus b = (Bus) obj;
        if (b.getId() != this.getId()) {
            return false;
        }
        if (b.getNumMiles() != this.getNumMiles()) {
            return false;
        }
        if (b.location != this.location) {
            return false;
        }
        if (b.stopsPerMile != this.stopsPerMile) {
            return false;
        }
        return true;
    }

    /**
     * toString method.
     * @return output
     */
    @Override
    public String toString() {
        return "Bus " + super.toString() + " This bus drives around "
                + this.location +  " and makes " + this.stopsPerMile + " stops per mile.";
    }

    /**
     * Getter location.
     * @return output
    */
    public String getLocation() {
        return location;
    }

    /**
     * Getter stopsPerMile.
     * @return output
     */
    public int stopsPerMile() {
        return stopsPerMile;
    }

    /**
     * Setter setlocation.
     * @param location input
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Setter stopspermile.
     * @param stopsPerMile otuput
     */
    public void setStopsPerMile(int stopsPerMile) {
        this.stopsPerMile = stopsPerMile;
    }
}




