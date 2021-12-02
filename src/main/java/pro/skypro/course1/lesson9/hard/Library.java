package pro.skypro.course1.lesson9.hard;

import pro.skypro.course1.lesson9.min.Book;

public class Library {

    private final Book[] books;

    public Library(int size) {
        this.books = new Book[size];
    }

    public boolean addBook(Book newBook) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = newBook;
                return true;
            }
        }

        return false;
    }

    public void printBooks() {
        for (Book book : books) {
            if (book != null) {
                printBook(book);
            }
        }
    }

    public void printBookInfo(String bookName) {
        for (Book book : books) {
            if (book != null && book.getTitle().equals(bookName)) {
                System.out.println(book.getTitle() + " by " + book.getAuthorName() + " was published in " + book.getPublishYear());
                return;
            }
        }

        System.out.println("Book '" + bookName + "' was not found!");
    }

    private void printBook(Book book) {
        System.out.println(String.join(": ",
                book.getAuthorName(),
                book.getTitle(),
                String.valueOf(book.getPublishYear())
        ));
    }

    public boolean changeBookEdition(String bookName, int newYear) {
        for (Book book : books) {
            if (book != null && book.getTitle().equals(bookName)) {
                book.setPublishYear(newYear);
                return true;
            }
        }

        return false;
    }


    public boolean changeBookEdition(Book book, int newYear) {
//        book.setPublishYear(newYear);
        for (Book libraryBook : books) {
            if (libraryBook != null && libraryBook.equals(book)) {
                libraryBook.setPublishYear(newYear);
                return true;
            }
        }

        return false;
    }

}
