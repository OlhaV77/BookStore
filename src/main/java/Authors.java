import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Authors extends StoreBook {
    public String firstName;
    public String lastName;

    List<Authors> authors = new ArrayList<>();

    public void addAuthorFirstLastName(Authors firstLastName) {
        authors.add(firstLastName);
    }

    public List<Authors> getAuthorsFirstLastName() {
        return authors;
    }
}