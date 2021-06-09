import java.util.Date;
import java.util.List;

public class Book extends ReadingMaterial {
    List<Author> authors;
    ISBN ISBN_10; // Mandatory!

    // Book can contain many authors
    public Book(String name, double price, Date datePublished, List<Author> authors, ISBN isbn) {
        super(name, price, datePublished);
        this.authors = authors;
        this.ISBN_10 = isbn;
    }

    @Override
    public String toString() {
        return name + " "
                + price + " "
                + datePublished + " "
                + authors + " "
                + ISBN_10;
    }


}


