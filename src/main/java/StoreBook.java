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
        List<Book> result = books.stream().filter(element -> element.price == price).collect(Collectors.toList());
        return result;
    }

    // TODO: re-write for-loop using index
    public List<Book> findByAuthorLastName(String author) {
        List<Book> result = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            for (int j = 0; j < books.get(i).authors.size(); j++) {
                if (books.get(i).authors.get(j).lastName.equals(author)) {
                    result.add(books.get(i));
                }
            }
        }
        return result;
    }

    public List<Book> findByAuthorFirstName(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            for (Author someAuthor : book.authors)
                if (someAuthor.firstName.equals(author)) {
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
        Collections.sort(books, new PriceFromLowtoHighComparator());
        return books;
    }

    public List<Book> sortByPriceFromHighToLow() {
        Collections.sort(books, new PriceToHighToLowComparator());

        // books.sort((x, y) -> {
        //    if (x.price == y.price)
        //       return 0;
        //   return x.price > y.price ? -1 : 1;
        // });
        return books;
    }

    public List<Book> sortByAuthorLastName() {
        for(Book book : books) {
            for (int j = 0; j < book.authors.size(); j++) {

               return books.stream().sorted(Comparator.comparing(x -> x.authors.get(j).lastName))
                        .collect(Collectors.toList());
            }
        }
        return null;
    }

    public List<Book> sortByName() {
        return books.stream()
                .sorted(Comparator.comparing(x -> x.name))
                .collect(Collectors.toList());
    }
}