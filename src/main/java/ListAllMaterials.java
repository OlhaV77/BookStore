

import java.util.ArrayList;
import java.util.Date;


public class ListAllMaterials {
    public static void main(String[] args) {
        BookStore subject = new BookStore();

        ArrayList<Author> authorsForFirstBook = new ArrayList<>();
        authorsForFirstBook.add(new Author("Tom", "Henz"));

        Date date1 = new Date(2020,4,30);

        Book book = new Book("History",
                5.55,
                date1,
                authorsForFirstBook,
                new ISBN("ISBN",2108-9990)
        );
        subject.add(book);

        ArrayList<Author> authorsForSecondBook = new ArrayList<>();

        authorsForSecondBook.add(new Author("Robert", "Ervin"));
        authorsForSecondBook.add(new Author("Lee", "Keem"));
        authorsForSecondBook.add(new Author("Leo", "Tolstoy"));

       Date date = new Date(2020, 3, 13);

        Book book2 = new Book("Math",
                8.67,
                date,
                authorsForSecondBook,
                new ISBN("ISBN", 3297-4564)
        );
        subject.add(book2);

        ArrayList<Author> secondBookAuthor = new ArrayList<>();
        secondBookAuthor.add(new Author("Lewis", "Carroll"));

       Date date2 = new Date(2013, 2, 15);

        Book book3 = new Book("Art",
                8.67,
                date2,
                secondBookAuthor,
                new ISBN("ISBN", 3297-6754));
        subject.add(book3);

        for (int i = 0; i < subject.items.size(); i++) {
            System.out.println(subject.items.get(i));
        }
    }


}
