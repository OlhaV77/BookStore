import java.util.*;
import java.util.stream.Collectors;

public class StoreBook {
    private List<Book> books = new ArrayList<>();

    public void add(Book book) {
        books.add(book);
    }

    public List<Book> getAllBooks() {
        return books;
    }

    // TODO: implement me and test
    public void remove(Book book) {
        books.removeIf(book1 -> book1.name.equals(book.name)
                && book1.author.equals(book.author)
                && book1.price == book.price);

    }
/*
    // TODO: remove
    public void removeBookByTheName(String name) {

        books.removeIf(myname -> myname.name.equals(name));
    }

    // TODO: remove
    public void removeBookByTheAuthor(String author) {

        books.removeIf(myauthor -> myauthor.author.equals(author));
    }

 */

    public List<Book> findByPrice(double price) {
        List<Book> result = books.stream()
                .filter(element -> element.price == price)
                .collect(Collectors.toList());
        return result;
    }

    // TODO: re-write without stream
    public List<Book> findByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.author.equals(author)) {
                result.add(book);
            }
            books = result;
        }
        return books;
    }

    //  List<Book> result = books.stream()
    //         .filter(element -> element.author.equals(author))
    //         .collect(Collectors.toList());
    //  return result;
    // }

    public List<Book> sortByPriceFromLowToHigt() {
        books.sort((x, y) -> {
            if (x.price == y.price)
                return 0;
            return x.price < y.price ? -1 : 1;
        });
        return books;
    }

    public List<Book> sortByPriceFromHigtToLow() {
        books.sort((x, y) -> {
            if (x.price == y.price)
                return 0;
            return x.price > y.price ? -1 : 1;
        });
        return books;
    }

    public List<Book> sortByAuthor() {
        List<Book> result = books.stream()
                .sorted((x, y) ->
                        x.author.compareTo(y.author))
                .collect(Collectors.toList());
        return result;
    }

    public List<Book> sortByName() {
        List<Book> result = books.stream()
                .sorted((x, y) -> x.name.compareTo(y.name))
                .collect(Collectors.toList());
        return result;
    }

}