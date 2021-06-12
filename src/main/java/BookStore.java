import java.util.*;
import java.util.stream.Collectors;

public class BookStore {

    public List<ReadingMaterial> items = new ArrayList<>();

    public void add(ReadingMaterial book) {
        items.add(book);
    }

    public List<ReadingMaterial> getAllItems() {
        return items;
    }

    public void remove(ReadingMaterial book) {
        items.remove(book);
    }

    public List<ReadingMaterial> findByPrice(double price) {
        List<ReadingMaterial> result = items.stream()
                .filter(element ->
                        element.price == price)
                .collect(Collectors.toList());
        return result;
    }

    // TODO: re-write for-loop using index
    public List<ReadingMaterial> findByAuthorLastName(String author) {

        List<ReadingMaterial> result = new ArrayList<>();

        List<Book> books = items.stream()
                .filter(readingMaterial -> readingMaterial instanceof Book)
                .map(book -> (Book) book)
                .collect(Collectors.toList());

        for (int i = 0; i < books.size(); i++) {
            for (int j = 0; j < books.get(i).authors.size(); j++) {
                if (books.get(i).authors.get(j).lastName.equals(author)) {
                    result.add(books.get(i));
                }
            }
        }
        return result;
    }

    public List<ReadingMaterial> findByAuthorFirstName(String author) {
        List<ReadingMaterial> result = new ArrayList<>();

        // List<Book> books = items.stream().
        //         filter(readingMaterial -> readingMaterial instanceof Book)
        //         .map(book -> (Book) book)
        //        .collect(Collectors.toList());

        List<Book> books = new ArrayList<>();
        for (ReadingMaterial read : items) {
            if (read instanceof Book) {
                Book book1 = (Book) read;
                books.add(book1);
            }
        }

        for (Book book : books) {
            for (Author someAuthor : book.authors) {
                if (someAuthor.firstName.equals(author)) {
                    result.add(book);
                }
            }
        }
        return result;
    }

    public List<ReadingMaterial> findByName(String name) {
        List<ReadingMaterial> results = new ArrayList<>();
        for (ReadingMaterial book : items) {
            if (book.name.equals(name)) {
                results.add(book);
            }
        }
        return results;
    }

    // TODO: implement sort with comparator interface
    public List<ReadingMaterial> sortByPriceFromLowToHigh() {
        Collections.sort(items, new PriceFromLowtoHighComparator());
        return items;
    }

    public List<ReadingMaterial> sortByPriceFromHighToLow() {
        Collections.sort(items, new PriceToHighToLowComparator());

        // books.sort((x, y) -> {
        //    if (x.price == y.price)
        //       return 0;
        //   return x.price > y.price ? -1 : 1;
        // });
        return items;
    }

    public List<ReadingMaterial> sortByAuthorLastName() {

        List<Book> books = items.stream()
                .filter(readingMaterial -> readingMaterial instanceof Book)
                .map(book -> (Book) book)
                .collect(Collectors.toList());

        for (Book book : books) {
            for (int j = 0; j < book.authors.size(); j++) {
                return books.stream().sorted(Comparator.comparing(x -> x.authors.get(j).lastName))
                        .collect(Collectors.toList());
            }
        }
        return null;
    }

    public List<ReadingMaterial> sortByName() {
        return items.stream()
                .sorted(Comparator.comparing(x -> x.name))
                .collect(Collectors.toList());
    }

    public int scanUserInputMenu() {
        System.out.println(1 + ". Show all books");
        System.out.println((2 + ". Quit"));

        int inputMenu = scanMenu();
        if (inputMenu != 1 && inputMenu != 2) {
            System.out.println("Wrong menu selected");
        }
        return inputMenu;
    }

    public int scanMenu() {
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    public List<ReadingMaterial> showAllBook() {
        int displayBooks = 1;
        int quit = 2;

        while (true){

        int userChoice = scanUserInputMenu();

        if (userChoice == displayBooks) {

            return items.stream()
                    .filter(readingMaterial -> readingMaterial instanceof Book)
                    .map(book -> (Book) book)
                    .collect(Collectors.toList());
        }

        if (userChoice == quit) {
            System.exit(0);
        }
        }
    }

}