/**
 * Creating the main class.
 * @author dved6
 * @version 13.1
 */
public class PetBattlefield {
    //Creating the instance variables
    private Pet[] firstTeam = new Pet[4];
    private Pet[] secondTeam = new Pet[4];

    /**
     * Creating the first constructor.
     * @param firstTeam inp
     * @param secondTeam inp
     */
    public PetBattlefield(Pet[] firstTeam, Pet[] secondTeam) {
        if (firstTeam.length > 4) {
            firstTeam = new Pet[4];
        } else {
            this.firstTeam = firstTeam;
        }
        if (secondTeam.length > 4) {
            secondTeam = new Pet[4];
        } else {
            this.secondTeam = secondTeam;
        }
    }

    //Creating the toString methods.
    @Override
    public String toString() {
        String firstString = "";
        String secondString = "";
        for (int i = 0; i < firstTeam.length; i++) {
            if (firstTeam[i] == null){
                firstString += "Empty";
            } else{
                firstString += firstTeam[i].toString();
            }
            if (secondTeam[i] == null){
                secondString += "Empty";
            } else {
                secondString += secondTeam[i].toString();
            }
            if (i != (firstTeam.length - 1)) {
                firstString += ", ";
                secondString += ", ";
            }
        }
        String output = "First Team: " + firstString + " vs Second Team: " + secondString;
        return output;
    }

    /**
     * Creating the compateTeams method.
     */
    public void compareTeams() {
        int firstWon = 0;
        int secondWon = 0;
        for (int i = 0; i < firstTeam.length; i++) {
            if (firstTeam[i].compareTo(secondTeam[i]) == 1) {
                firstWon++;
            } else if (firstTeam[i].compareTo(secondTeam[i]) == -1) {
                secondWon++;
            }
        }
        if (firstWon > secondWon) {
            System.out.println("The first team will probably win");
        } else if (secondWon > firstWon) {
            System.out.println("The second team will probably win");
        } else {
            System.out.println("It is an even match");
        }
    }

    /**
     * Creating the battle method.
     */
    public void battle() {
        int numPets = firstTeam.length;
        int first = 0;
        int second = 0;
        while ((first < numPets) && (second < numPets)) {
            firstTeam[first].attackPet(secondTeam[second]);
            firstTeam[first].getAttacked(secondTeam[second].getAttack());
            secondTeam[second].attackPet(firstTeam[first]);
            secondTeam[second].getAttacked(firstTeam[first].getAttack());
            if (firstTeam[first].hasFainted()) {
                firstTeam[first] = null;
                first++;
            }
            if (secondTeam[second].hasFainted()) {
                secondTeam[second] = null;
                second++;
            }
        }
        if (first == numPets && second == numPets) {
            System.out.println("Both teams fainted");
        }
        if (first == numPets) {
            System.out.println("The second team won");
        }
        if (second == numPets) {
            System.out.println("The first team won");
        }
    }

    /**
     * Getter.
     * @return string
     */
    public Pet[] getFirstTeam() {
        return firstTeam;
    }

    /**
     * Setter.
     * @param firstTeam inp
     */
    public void setFirstTeam(Pet[] firstTeam) {
        this.firstTeam = firstTeam;
    }

    /**
     * Getter.
     * @return string
     */
    public Pet[] getSecondTeam() {
        return secondTeam;
    }

    /**
     * Setter.
     * @param secondTeam inp
     */
    public void setSecondTeam(Pet[] secondTeam) {
        this.secondTeam = secondTeam;
    }

    /**
     * Main method.
     * @param args inp
     */
    public static void main(String[] args) {
        Turtle t = new Turtle();
        Hippo h = new Hippo();
        Skunk s = new Skunk();
        Turtle t1 = new Turtle(10, 5, true);
        Hippo h1 = new Hippo(15, 10, 3);
        Skunk s1 = new Skunk(13, 2, 6);
        Pet[] team1 = {t, h, null, s, null};
        Pet[] team2 = {null, s, t, null, h};
        PetBattlefield try1 = new PetBattlefield(team1, team2);
        try1.compareTeams();
        try1.battle();
    }
}
