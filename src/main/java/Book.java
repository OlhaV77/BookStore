
import java.util.Date;
import java.util.List;

public class Book {
    String name;
    double price;
    List <Author> authors;
    ISBN ISBN_10; // Mandatory!
    Date datePublished; // Mandatory

    // Book can contain many authors
    public Book(String name, List<Author> authors, double price, Date datePublished, ISBN isbn) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.datePublished = datePublished;
        this.ISBN_10 = isbn;
    }

}
