
public class Author  {
    String firstName;
    String lastName;

    public Author(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }


    @Override
    public String toString() {

        return firstName + " "
                + lastName;
    }
}