package pro.skypro.course1.lesson10;

public class Library {
    private final Book[] books;

    public Library(int size) {
        System.out.println("HELLO!!!");
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
            if (book.getTitle().equals(bookName)) {
                book.setPublishYear(newYear);
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
//        System.out.println(Arrays.toString(books));

        StringBuilder sb = new StringBuilder("Books:");
        sb.append(System.lineSeparator());
        for (Book book : books) {
            if (book != null) {
                sb.append(book);
                sb.append(System.lineSeparator());
            }
        }

        return sb.toString();
    }

}
