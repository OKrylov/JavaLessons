package pro.skypro.course1.lesson9.min;

public class Author {

//    private static final String DEFAULT_NAME = "Ivan";

    private final String firstName;
    private final String lastName;


//    public Author(String lastName) {
//        this.firstName = DEFAULT_NAME;
//        this.lastName = lastName;
//    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
