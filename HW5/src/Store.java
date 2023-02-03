import java.util.ArrayList;

public class Store {

    private String name;
    private ArrayList<Dessert> desserts;

    public Store(String name) {
        this.desserts = new ArrayList<Dessert>();
        this.name = name;
    }

    public void addDessert(Dessert d1) {
        this.desserts.add(desserts.size() - 1, d1);
    }

    public Dessert removeDessert(Dessert d2) {
        for (int i = 0; i < desserts.size(); i++) {
            if (desserts.get(i).equals(d2)) {
                Dessert temp = desserts.get(i);
                desserts.remove(i);
                return temp;
            }
            return null;
        }
        return null;
    }

    public Dessert findDessert(Dessert d3) {

        int leftindex = 0;
        int rightindex = this.desserts.size();

        while (leftindex < rightindex) {
            int pivot = rightindex + leftindex / 2;
            if (d3.compareTo(this.desserts.get(pivot)) == 1) {
                leftindex = pivot + 1;
            } else if (d3.compareTo(this.desserts.get(pivot)) == 0) {
                return this.desserts.get(pivot);
            } else {
                rightindex = pivot - 1;
            }
        }
        return null;
    }

    public void sortStore() {

        int length = this.desserts.size();
        for (int a = 0; a < length; ++a) {
            Dessert key = desserts.get(a);
            int b = a - 1;
            while (b >= 0 && desserts.get(b).compareTo(key) == 1) {
                desserts.set(b + 1, desserts.get(b));
                b = b - 1;
            }
            desserts.set(b + 1, key);
        }
    }

    public int checkStore(Dessert d) {
        int counter = 0;
        for (int i = 0; i < this.desserts.size(); i++) {
            if (desserts.get(i).compareTo(d) == 0 || desserts.get(i).compareTo(d) == 1) {
                counter++;
            }
        }
        return counter;
    }

    public ArrayList<Dessert> getDesserts() {
        return desserts;
    }

}
