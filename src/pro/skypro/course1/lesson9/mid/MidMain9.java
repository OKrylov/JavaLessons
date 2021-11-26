package pro.skypro.course1.lesson9.mid;

import pro.skypro.course1.lesson9.min.Author;
import pro.skypro.course1.lesson9.min.Book;

public class MidMain9 {

    public static void main(String[] args) {
        Author rowling = new Author("Joanne", "Rowling");

        Book[] books = new Book[10];

        addBook(books, new Book(rowling, "Harry Potter and the Sorcerer’s Stone", 1997));
        addBook(books, new Book(rowling, "Harry Potter and the Chamber of Secrets", 1998));
        addBook(books, new Book(rowling, "Harry Potter and the Prisoner of Azkaban", 1999));
        addBook(books, new Book(rowling, "Harry Potter and the Goblet of Fire", 2000));
        addBook(books, new Book(rowling, "Harry Potter and the Order of the Phoenix", 2003));
        addBook(books, new Book(rowling, "Harry Potter and the Half-Blood Prince", 2005));

        boolean result = addBook(books, new Book(rowling, "Harry Potter and the Deathly Hallows", 2007));
        if (result) {
            System.out.println("Книга была успешно добавлена в массив!");
        }

        for (Book book : books) {
            if (book != null) {
                printBook(book);
            }
        }
    }

    private static boolean addBook(Book[] books, Book newBook) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = newBook;
                return true;
            }
        }

        return false;
    }

    private static void printBook(Book book) {
//        System.out.println(String.join(": ",
////                book.getAuthorName(),
//                book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName(),
//                book.getTitle(),
//                String.valueOf(book.getPublishYear())
//        ));

        String info = book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName() +
                ": " + book.getTitle() +
                ": " + book.getPublishYear();

        System.out.println(info);
    }

}
