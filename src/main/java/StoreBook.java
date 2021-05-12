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

    public void remove(Book book) {
        books.remove(book);
    }

    public List<Book> findByPrice(double price) {
        List<Book> result = books.stream()
               .filter(element -> element.price == price)
                .collect(Collectors.toList());
        return result;
    }

    // TODO: re-write for-loop using index
    public List<Book> findByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.author.equals(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> findByName(String name) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.name.equals(name)) {
                results.add(book);
            }
        }
        return results;
    }

    // TODO: implement sort with comparator interface
    public List<Book> sortByPriceFromLowToHigh() {

        books.sort((x, y) -> {
            if (x.price == y.price)
                return 0;
            return x.price < y.price ? -1 : 1;
        });
        return books;
    }

    public List<Book> sortByPriceFromHighToLow() {
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