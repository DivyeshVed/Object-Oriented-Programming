public class Bob {
    /**
     * Creating a method.
     * @param store1 input.
     * @param store2 input.
     * @return ouput.
     */
    public static boolean compareStores(Store store1, Store store2) {
        for (int i = 0; i < store1.getDesserts().size(); i++) {
            if (store2.findDessert(store1.getDesserts().get(i)) != null) {
                return true;
            }
        }
        return false;
    }

    /**
     * This creates another method.
     * @param store1 input.
     * @param dessert1 input.
     * @return output.
     */
    public static boolean shop(Store store1, Dessert dessert1) {
        store1.sortStore();
        if (store1.findDessert(dessert1) == null) {
            return false;
        } else {
            return true;
        }
    }
}
