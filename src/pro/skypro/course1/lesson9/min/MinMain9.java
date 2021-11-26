package pro.skypro.course1.lesson9.min;

public class MinMain9 {

    public static void main(String[] args) {
        Author pushkin = new Author("Alexander", "Pushkin");
        Author rowling = new Author("Joanne", "Rowling");

        Book theBestPieces = new Book(pushkin, "The Best Pieces", 2015);
        Book harryPotter = new Book(rowling, "Harry Potter", 2010);

        System.out.println(theBestPieces);
        System.out.println(harryPotter);

        System.out.println("Now we set a new publish year...");
        harryPotter.setPublishYear(2020);
        System.out.println(harryPotter);

    }
}
