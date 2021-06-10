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
        System.out.println();
        for (Author author : authors) {
            System.out.print("Author: " + author.firstName + " ");
            System.out.println(author.lastName + ", ");
        }
        return "Name: " + name + "\n" +
                "Price: " + price + "\n"
                + "Data Published: " + datePublished.getYear() + ", "
                + datePublished.getMonth() + ", "
                + datePublished.getDate() + "\n"
                + "ISBN-NUMBER: " + ISBN_10.isbn + " "
                + ISBN_10.number;
    }


}


