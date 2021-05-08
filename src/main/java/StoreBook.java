import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StoreBook  {
    private int countOfBooks;
    private List<Book> books = new ArrayList ();

    // for(int i = 0; i < books.size(); i++) {
    //     Book book1 = books.get(i);
    // book1.author ...
    //  }
    //      for(Book mybook: books) {
    //            mybook.author ...
    //    }
    //      books.stream().forEach (book1 -> /* book1.author .... );


    public void add(Book book) {
        books.add (book);
        countOfBooks++;
    }



    public List<Book> getAllBooks() {
        return books;
    }

    public List<Book> removeBookByTheName(String name) {
        books.removeIf (myname -> myname.name.equals (name));
        return books;
    }

    public List<Book> removeBookByTheAuthor(String author) {
        books.removeIf (myauthor -> myauthor.author.equals (author));
        return books;
    }

    public List<Book> findByPrice(double price) {
        books = books.stream ().filter (element ->
                element.price == price).collect (Collectors.toList ());
        return books;
    }

    public List<Book> findByAuthor(String author) {
        books = books.stream ().filter (element -> element.author.equals (author))
                .collect (Collectors.toList ());
        return books;
    }
}