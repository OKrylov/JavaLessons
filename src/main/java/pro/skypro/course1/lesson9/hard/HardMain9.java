package pro.skypro.course1.lesson9.hard;

import pro.skypro.course1.lesson9.min.Author;
import pro.skypro.course1.lesson9.min.Book;

public class HardMain9 {

    public static void main(String[] args) {
        Library library = new Library(10);

        Author rowling = new Author("Joanne", "Rowling");

        library.addBook(new Book(rowling, "Harry Potter and the Sorcerer’s Stone", 1997));
        library.addBook(new Book(rowling, "Harry Potter and the Chamber of Secrets", 1998));
        library.addBook(new Book(rowling, "Harry Potter and the Prisoner of Azkaban", 1999));
        library.addBook(new Book(rowling, "Harry Potter and the Goblet of Fire", 2000));
        library.addBook(new Book(rowling, "Harry Potter and the Order of the Phoenix", 2003));
        library.addBook(new Book(rowling, "Harry Potter and the Half-Blood Prince", 2005));
        library.addBook(new Book(rowling, "Harry Potter and the Deathly Hallows", 2007));

        library.printBookInfo("Harry Potter and the Half-Blood Prince");
        library.changeBookEdition("Harry Potter and the Half-Blood Prince", 2021);
        library.printBookInfo("Harry Potter and the Half-Blood Prince");
        library.printBookInfo("Harry Potter and the Half-Blood Prince1241");
    }
}
