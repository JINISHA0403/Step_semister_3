package week6.class_problems;

public class IdCard {

    String name;
    int booksIssued;

    // Constructor
    IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }

    public static void main(String[] args) {

        // First object
        IdCard ravi = new IdCard("Ravi", 0);

        // Second variable points to the SAME object
        IdCard duplicate = ravi;

        // Change using second variable
        duplicate.booksIssued = 3;

        // Third variable creates a SEPARATE object
        IdCard separate = new IdCard("Ravi", 3);

        System.out.println("Ravi's booksIssued (via first variable): "
                + ravi.booksIssued);

        System.out.println("duplicate == ravi: " + (duplicate == ravi));

        System.out.println("separate == ravi: " + (separate == ravi));
    }
}
