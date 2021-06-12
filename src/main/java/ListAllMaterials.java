
import java.util.ArrayList;
import java.util.Date;


public class ListAllMaterials {
    public static void main(String[] args) {
        BookStore subject = new BookStore();

        subject.showAllBook();

        ArrayList<Author> authorsForFirstBook = new ArrayList<>();
        authorsForFirstBook.add(new Author("Tom", "Henz"));

        Date date1 = new Date(2020, 4, 30);

        Book book1 = new Book("History",
                5.55,
                date1,
                authorsForFirstBook,
                new ISBN("ISBN", "2108-9990")
        );
        subject.add(book1);


        ArrayList<Author> authorsForSecondBook = new ArrayList<>();

        authorsForSecondBook.add(new Author("Robert", "Ervin"));
        authorsForSecondBook.add(new Author("Lee", "Keem"));
        authorsForSecondBook.add(new Author("Leo", "Tolstoy"));

        Date date2 = new Date(2021, 3, 13);

        Book book2 = new Book("Math",
                8.67,
                date2,
                authorsForSecondBook,
                new ISBN("ISBN", "2345-4467")
        );
        subject.add(book2);


        ArrayList<Author> thirdBookAuthor = new ArrayList<>();
        thirdBookAuthor.add(new Author("Lewis", "Carroll"));

        Date date3 = new Date(2013, 2, 15);

        Book book3 = new Book("Art",
                15.6,
                date3,
                thirdBookAuthor,
                new ISBN("ISBN", "2341-6754"));
        subject.add(book3);

        Date date = new Date(2021, 2, 1);
        subject.add(new Magazine("Cosmo", 3.55, date, 1223));


        for (int i = 0; i < subject.items.size(); i++) {
            System.out.println(subject.items.get(i));
        }
    }


}
