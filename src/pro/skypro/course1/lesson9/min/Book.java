package pro.skypro.course1.lesson9.min;

public class Book {

    private final Author author;
    private final String title;
    private int publishYear;

    public Book(Author author, String title, int publishYear) {
        this.author = author;
        this.title = title;
        this.publishYear = publishYear;
    }

    public String getAuthorName() {
        return author.getFirstName() + " " + author.getLastName();
    }

    public Author getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author=" + author +
                ", title='" + title + '\'' +
                ", publishYear=" + publishYear +
                '}';
    }
}
