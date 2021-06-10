import org.junit.Test;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BookStoreTest {

    @Test
    public void add_whenSimpleStoreBook_works() {
        BookStore subject = new BookStore();

        ArrayList<Author> authors = new ArrayList<>();
        authors.add(new Author("Kim", "Lee"));

        Date date = new Date(2020, 5, 24);

        subject.add(new Book("History",
                5.55,
                date,
                authors,
                new ISBN("ISSN", "0027-9633")));
    }

    @Test
    public void add_whenRecordExists_returnRecord() {
        BookStore subject = new BookStore();

        ArrayList<Author> authorsForFirstBook = new ArrayList<>();
        authorsForFirstBook.add(new Author("Rita", "Tom"));
        authorsForFirstBook.add(new Author("Lee", "Verg"));

        Date date = new Date(1977, 2, 22);

        subject.add(new Book("Math",
                2.99,
                date,
                authorsForFirstBook,
                new ISBN("ISBN", "2108-9990"))
        );

        ArrayList<Author> authorsForSecondBook = new ArrayList<>();
        authorsForSecondBook.add(new Author("Issac", "Newton"));

        Date data = new Date(1956, 6, 6);

        subject.add(new Book("Physics",
                8.55,
                data,
                authorsForSecondBook,
                new ISBN("ISBN", "3297-4564"))
        );

        List<ReadingMaterial> actual = subject.getAllItems();

        assertThat(actual).hasSize(2);

        Book actualFirstBook = (Book) actual.get(0);

        assertThat(actualFirstBook.name).isEqualTo("Math");
        assertThat(actualFirstBook.price).isEqualTo(2.99);
        assertThat(actualFirstBook.datePublished.getYear()).isEqualTo(1977);
        assertThat(actualFirstBook.datePublished.getMonth()).isEqualTo(2);
        assertThat(actualFirstBook.datePublished.getDate()).isEqualTo(22);
        assertThat(actualFirstBook.authors.get(0).firstName).isEqualTo("Rita");
        assertThat(actualFirstBook.authors.get(0).lastName).isEqualTo("Tom");
        assertThat(actualFirstBook.authors.get(1).firstName).isEqualTo("Lee");
        assertThat(actualFirstBook.authors.get(1).lastName).isEqualTo("Verg");
        assertThat(actualFirstBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualFirstBook.ISBN_10.number).isEqualTo("2108-9990");

        Book actualSecondBook = (Book) actual.get(1);

        assertThat(actualSecondBook.name).isEqualTo("Physics");
        assertThat(actualSecondBook.price).isEqualTo(8.55);
        assertThat(actualSecondBook.datePublished.getYear()).isEqualTo(1956);
        assertThat(actualSecondBook.datePublished.getMonth()).isEqualTo(6);
        assertThat(actualSecondBook.datePublished.getDate()).isEqualTo(6);
        assertThat(actualSecondBook.authors.get(0).firstName).isEqualTo("Issac");
        assertThat(actualSecondBook.authors.get(0).lastName).isEqualTo("Newton");
        assertThat(actualSecondBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualSecondBook.ISBN_10.number).isEqualTo("3297-4564");
    }

    @Test
    public void removeBook_whenOneRecordExists_containsZeroRecords() {
        BookStore subject = new BookStore();

        ArrayList<Author> authorsForFirstBook = new ArrayList<>();
        authorsForFirstBook.add(new Author("Robert", "Ervin"));

        Date date = new Date(2020, 3, 23);

        Book book = new Book("History",
                5.55,
                date,
                authorsForFirstBook,
                new ISBN("ISBN", "2108-9990"));

        subject.add(book);

        subject.remove(book);

        List<ReadingMaterial> actual = subject.getAllItems();

        assertThat(actual).hasSize(0);

    }

    @Test
    public void removeBook_whenRemovingExistingRecord_containsRemainingBooks() {
        BookStore subject = new BookStore();

        ArrayList<Author> authorsForFirstBook = new ArrayList<>();
        authorsForFirstBook.add(new Author("Tom", "Henz"));

        Date date1 = new Date(2020, 4, 30);

        Book book = new Book("History",
                5.55,
                date1,
                authorsForFirstBook,
                new ISBN("ISBN", "2108-9990")
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
                new ISBN("ISBN", "3297-4564")
        );
        subject.add(book2);


        subject.remove(book);

        List<ReadingMaterial> actual = subject.getAllItems();

        assertThat(actual).hasSize(1);

        Book actualFirstBook = (Book) actual.get(0);

        assertThat(actualFirstBook.name).isEqualTo("Math");
        assertThat(actualFirstBook.price).isEqualTo(8.67);
        assertThat(actualFirstBook.datePublished.getYear()).isEqualTo(2020);
        assertThat(actualFirstBook.datePublished.getMonth()).isEqualTo(3);
        assertThat(actualFirstBook.datePublished.getDate()).isEqualTo(13);
        assertThat(actualFirstBook.authors.get(0).firstName).isEqualTo("Robert");
        assertThat(actualFirstBook.authors.get(0).lastName).isEqualTo("Ervin");
        assertThat(actualFirstBook.authors.get(1).firstName).isEqualTo("Lee");
        assertThat(actualFirstBook.authors.get(1).lastName).isEqualTo("Keem");
        assertThat(actualFirstBook.authors.get(2).firstName).isEqualTo("Leo");
        assertThat(actualFirstBook.authors.get(2).lastName).isEqualTo("Tolstoy");
        assertThat(actualFirstBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualFirstBook.ISBN_10.number).isEqualTo("3297-4564");
    }

    @Test
    public void removeBook_whenOnTwoRemovingRecordExists_containsOneRecords() {
        BookStore subject = new BookStore();

        ArrayList<Author> firstBookAuthor = new ArrayList<>();
        firstBookAuthor.add(new Author("Jacob", "De Haas"));
        firstBookAuthor.add(new Author("Oscar", "Wild"));

        Date date1 = new Date(2018, 1, 15);

        Book book1 = new Book("History",
                5.55,
                date1,
                firstBookAuthor,
                new ISBN("ISBN", "2108-9990"));
        subject.add(book1);

        ArrayList<Author> secondBookAuthor = new ArrayList<>();
        secondBookAuthor.add(new Author("Lewis", "Carroll"));

        Date date2 = new Date(2013, 2, 15);

        Book book2 = new Book("Math",
                8.67,
                date2,
                secondBookAuthor,
                new ISBN("ISBN", "3297-4564"));
        subject.add(book2);

        ArrayList<Author> therdBookAuthor = new ArrayList<>();
        therdBookAuthor.add(new Author("Robert", "Frost"));

        Date date3 = new Date(2019, 7, 25);

        Book book3 = new Book("Poems",
                10.55,
                date3,
                therdBookAuthor,
                new ISBN("ISBN", "6166-2345"));
        subject.add(book3);

        subject.remove(book2);
        subject.remove(book3);

        List<ReadingMaterial> actual = subject.getAllItems();

        assertThat(actual).hasSize(1);

        Book actualFirstBook = (Book) actual.get(0);

        assertThat(actualFirstBook.name).isEqualTo("History");
        assertThat(actualFirstBook.price).isEqualTo(5.55);
        assertThat(actualFirstBook.datePublished.getYear()).isEqualTo(2018);
        assertThat(actualFirstBook.datePublished.getMonth()).isEqualTo(1);
        assertThat(actualFirstBook.datePublished.getDate()).isEqualTo(15);
        assertThat(actualFirstBook.authors.get(0).firstName).isEqualTo("Jacob");
        assertThat(actualFirstBook.authors.get(0).lastName).isEqualTo("De Haas");
        assertThat(actualFirstBook.authors.get(1).firstName).isEqualTo("Oscar");
        assertThat(actualFirstBook.authors.get(1).lastName).isEqualTo("Wild");
        assertThat(actualFirstBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualFirstBook.ISBN_10.number).isEqualTo("2108-9990");
    }

    @Test
    public void findByPrice_whenFindRecordExists_containsOneRecords() {
        BookStore subject = new BookStore();

        ArrayList<Author> firstAuthorOfTheBook = new ArrayList<>();
        firstAuthorOfTheBook.add(new Author("Jack", "London"));

        Date date1 = new Date(2011, 6, 14);

        subject.add(new Book("History",
                5.55,
                date1,
                firstAuthorOfTheBook,
                new ISBN("ISBN", "2108-9990"))
        );

        ArrayList<Author> secondAuthorOfTheBook = new ArrayList<>();
        secondAuthorOfTheBook.add(new Author("Jacob", "De Haas"));
        secondAuthorOfTheBook.add(new Author("Robert", "Howard"));

        Date date2 = new Date(2021, 2, 18);

        subject.add(new Book("Math",
                8.67,
                date2,
                secondAuthorOfTheBook,
                new ISBN("ISBN", "3297-4564"))
        );

        ArrayList<Author> thirdAuthorOfTheBook = new ArrayList<>();
        thirdAuthorOfTheBook.add(new Author("Robert", "Frost"));
        thirdAuthorOfTheBook.add(new Author("Robert", "Howard"));
        thirdAuthorOfTheBook.add(new Author("William", "Seneca"));

        Date date3 = new Date(2016, 12, 30);

        subject.add(new Book("Poems",
                10.55,
                date3,
                thirdAuthorOfTheBook,
                new ISBN("ISBN", "6166-2345"))
        );

        List<ReadingMaterial> actual = subject.findByPrice(5.55);

        assertThat(actual).hasSize(1);

        Book actualFirstBook = (Book) actual.get(0);

        assertThat(actualFirstBook.name).isEqualTo("History");
        assertThat(actualFirstBook.price).isEqualTo(5.55);
        assertThat(actualFirstBook.datePublished.getYear()).isEqualTo(2011);
        assertThat(actualFirstBook.datePublished.getMonth()).isEqualTo(6);
        assertThat(actualFirstBook.datePublished.getDate()).isEqualTo(14);
        assertThat(actualFirstBook.authors.get(0).firstName).isEqualTo("Jack");
        assertThat(actualFirstBook.authors.get(0).lastName).isEqualTo("London");
        assertThat(actualFirstBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualFirstBook.ISBN_10.number).isEqualTo("2108-9990");
    }

    @Test
    public void findByPrice_whenRepeatRecordExists_containsTwoRecords() {
        BookStore subject = new BookStore();

        ArrayList<Author> firstAuthorOfTheBook = new ArrayList<>();
        firstAuthorOfTheBook.add(new Author("Jack", "London"));

        Date date1 = new Date(2015, 9, 22);

        subject.add(new Book("History",
                5.55,
                date1,
                firstAuthorOfTheBook,
                new ISBN("ISBN", "2108-9990"))
        );

        ArrayList<Author> secondAuthorOfTheBook = new ArrayList<>();
        secondAuthorOfTheBook.add(new Author("Tom", "Donne"));
        secondAuthorOfTheBook.add(new Author("Robert", "Howard"));

        Date date2 = new Date(2011, 10, 10);

        subject.add(new Book("Math",
                8.67,
                date2,
                secondAuthorOfTheBook,
                new ISBN("ISBN", "3297-4564"))
        );

        ArrayList<Author> thirdAuthorOfTheBook = new ArrayList<>();
        thirdAuthorOfTheBook.add(new Author("John", "Milton"));
        thirdAuthorOfTheBook.add(new Author("Robert", "Howard"));
        thirdAuthorOfTheBook.add(new Author("William", "Seneca"));

        Date date3 = new Date(1990, 8, 30);

        subject.add(new Book("Poems",
                10.55,
                date3,
                thirdAuthorOfTheBook,
                new ISBN("ISBN", "6166-2345"))
        );

        ArrayList<Author> fourthAuthorOfTheBook = new ArrayList<>();
        fourthAuthorOfTheBook.add(new Author("Jane", "Smit"));
        fourthAuthorOfTheBook.add(new Author("Robert", "Howard"));
        fourthAuthorOfTheBook.add(new Author("William", "Seneca"));

        Date date4 = new Date(1986, 4, 19);

        subject.add(new Book("IT",
                5.55,
                date4,
                fourthAuthorOfTheBook,
                new ISBN("ISBN", "6166-2345"))
        );

        List<ReadingMaterial> actual = subject.findByPrice(5.55);

        assertThat(actual).hasSize(2);

        Book actualFirstBook = (Book) actual.get(0);

        assertThat(actualFirstBook.name).isEqualTo("History");
        assertThat(actualFirstBook.price).isEqualTo(5.55);
        assertThat(actualFirstBook.datePublished.getYear()).isEqualTo(2015);
        assertThat(actualFirstBook.datePublished.getMonth()).isEqualTo(9);
        assertThat(actualFirstBook.datePublished.getDate()).isEqualTo(22);
        assertThat(actualFirstBook.authors.get(0).firstName).isEqualTo("Jack");
        assertThat(actualFirstBook.authors.get(0).lastName).isEqualTo("London");
        assertThat(actualFirstBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualFirstBook.ISBN_10.number).isEqualTo("2108-9990");

        Book actualSecondBook = (Book) actual.get(1);

        assertThat(actualSecondBook.name).isEqualTo("IT");
        assertThat(actualSecondBook.price).isEqualTo(5.55);
        assertThat(actualSecondBook.datePublished.getYear()).isEqualTo(1986);
        assertThat(actualSecondBook.datePublished.getMonth()).isEqualTo(4);
        assertThat(actualSecondBook.datePublished.getDate()).isEqualTo(19);
        assertThat(actualSecondBook.authors.get(0).firstName).isEqualTo("Jane");
        assertThat(actualSecondBook.authors.get(0).lastName).isEqualTo("Smit");
        assertThat(actualSecondBook.authors.get(1).firstName).isEqualTo("Robert");
        assertThat(actualSecondBook.authors.get(1).lastName).isEqualTo("Howard");
        assertThat(actualSecondBook.authors.get(2).firstName).isEqualTo("William");
        assertThat(actualSecondBook.authors.get(2).lastName).isEqualTo("Seneca");
        assertThat(actualSecondBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualSecondBook.ISBN_10.number).isEqualTo("6166-2345");
    }

    @Test
    public void findByPrice_whenFindOneRecordExists_containsTwoRecords() {
        BookStore subject = new BookStore();

        ArrayList<Author> firstAuthorOfTheBook = new ArrayList<>();
        firstAuthorOfTheBook.add(new Author("Nikola", "Tesla"));

        Date date1 = new Date(2014, 3, 15);

        subject.add(new Book("History",
                5.55,
                date1,
                firstAuthorOfTheBook,
                new ISBN("ISBN", "2108-9990"))
        );

        ArrayList<Author> secondAuthorOfTheBook = new ArrayList<>();
        secondAuthorOfTheBook.add(new Author("Tom", "Burns"));
        secondAuthorOfTheBook.add(new Author("Robert", "Howard"));

        Date date2 = new Date(1966, 8, 28);

        subject.add(new Book("Math",
                8.67,
                date2,
                secondAuthorOfTheBook,
                new ISBN("ISBN", "3297-4564"))
        );

        ArrayList<Author> thirdAuthorOfTheBook = new ArrayList<>();
        thirdAuthorOfTheBook.add(new Author("Jeni", "Tsu"));
        thirdAuthorOfTheBook.add(new Author("Robert", "Howard"));
        thirdAuthorOfTheBook.add(new Author("William", "Seneca"));

        Date date3 = new Date(2020, 9, 1);

        subject.add(new Book("Art of war",
                5.55,
                date3,
                thirdAuthorOfTheBook,

                new ISBN("ISBN", "6166-2345"))
        );

        ArrayList<Author> fourthAuthorOfTheBook = new ArrayList<>();
        fourthAuthorOfTheBook.add(new Author("Bram", "Stoker"));
        fourthAuthorOfTheBook.add(new Author("Robert", "Howard"));
        fourthAuthorOfTheBook.add(new Author("William", "Seneca"));

        Date date4 = new Date(1983, 6, 4);

        subject.add(new Book("Poems",
                10.55,
                date4,
                fourthAuthorOfTheBook,

                new ISBN("ISBN", "6166-2345"))
        );

        List<ReadingMaterial> actual = subject.findByPrice(5.55);

        assertThat(actual).hasSize(2);

        Book actualFirstBook = (Book) actual.get(0);
        assertThat(actualFirstBook.name).isEqualTo("History");
        assertThat(actualFirstBook.price).isEqualTo(5.55);
        assertThat(actualFirstBook.datePublished.getYear()).isEqualTo(2014);
        assertThat(actualFirstBook.datePublished.getMonth()).isEqualTo(3);
        assertThat(actualFirstBook.datePublished.getDate()).isEqualTo(15);
        assertThat(actualFirstBook.authors.get(0).firstName).isEqualTo("Nikola");
        assertThat(actualFirstBook.authors.get(0).lastName).isEqualTo("Tesla");
        assertThat(actualFirstBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualFirstBook.ISBN_10.number).isEqualTo("2108-9990");

        Book actualSecondBook = (Book) actual.get(1);
        assertThat(actualSecondBook.name).isEqualTo("Art of war");
        assertThat(actualSecondBook.price).isEqualTo(5.55);
        assertThat(actualSecondBook.datePublished.getYear()).isEqualTo(2020);
        assertThat(actualSecondBook.datePublished.getMonth()).isEqualTo(9);
        assertThat(actualSecondBook.datePublished.getDate()).isEqualTo(1);
        assertThat(actualSecondBook.authors.get(0).firstName).isEqualTo("Jeni");
        assertThat(actualSecondBook.authors.get(0).lastName).isEqualTo("Tsu");
        assertThat(actualSecondBook.authors.get(1).firstName).isEqualTo("Robert");
        assertThat(actualSecondBook.authors.get(1).lastName).isEqualTo("Howard");
        assertThat(actualSecondBook.authors.get(2).firstName).isEqualTo("William");
        assertThat(actualSecondBook.authors.get(2).lastName).isEqualTo("Seneca");
        assertThat(actualSecondBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualSecondBook.ISBN_10.number).isEqualTo("6166-2345");
    }

    @Test
    public void findByPrice_whenFindOneRecordExists_containsOneRecords() {
        BookStore subject = new BookStore();

        ArrayList<Author> firstAuthorOfTheBook = new ArrayList<>();
        firstAuthorOfTheBook.add(new Author("Robert", "Ervin"));

        Date date1 = new Date(2021, 5, 25);

        subject.add(new Book("History",
                5.55,
                date1,
                firstAuthorOfTheBook,

                new ISBN("ISBN", "2108-9990"))
        );

        ArrayList<Author> secondAuthorOfTheBook = new ArrayList<>();
        secondAuthorOfTheBook.add(new Author("Edgard", "Allan"));
        secondAuthorOfTheBook.add(new Author("Robert", "Howard"));

        Date date2 = new Date(1989, 12, 8);

        subject.add(new Book("Math",
                8.67,
                date2,
                secondAuthorOfTheBook,

                new ISBN("ISBN", "3297-4564"))
        );

        ArrayList<Author> thirdAuthorOfTheBook = new ArrayList<>();
        thirdAuthorOfTheBook.add(new Author("Arthur", "Conan"));
        thirdAuthorOfTheBook.add(new Author("Robert", "Howard"));
        thirdAuthorOfTheBook.add(new Author("William", "Seneca"));

        Date date3 = new Date(2020, 7, 7);

        subject.add(new Book("Poems",
                10.55,
                date3,
                thirdAuthorOfTheBook,

                new ISBN("ISBN", "6166-2345"))
        );

        List<ReadingMaterial> actual = subject.findByPrice(10.55);

        assertThat(actual).hasSize(1);

        Book actualFirstBook = (Book) actual.get(0);

        assertThat(actualFirstBook.name).isEqualTo("Poems");
        assertThat(actualFirstBook.price).isEqualTo(10.55);
        assertThat(actualFirstBook.datePublished.getYear()).isEqualTo(2020);
        assertThat(actualFirstBook.datePublished.getMonth()).isEqualTo(7);
        assertThat(actualFirstBook.datePublished.getDate()).isEqualTo(7);
        assertThat(actualFirstBook.authors.get(0).firstName).isEqualTo("Arthur");
        assertThat(actualFirstBook.authors.get(0).lastName).isEqualTo("Conan");
        assertThat(actualFirstBook.authors.get(1).firstName).isEqualTo("Robert");
        assertThat(actualFirstBook.authors.get(1).lastName).isEqualTo("Howard");
        assertThat(actualFirstBook.authors.get(2).firstName).isEqualTo("William");
        assertThat(actualFirstBook.authors.get(2).lastName).isEqualTo("Seneca");
        assertThat(actualFirstBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualFirstBook.ISBN_10.number).isEqualTo("6166-2345");
    }

    @Test
    public void findByAuthorLastName_whenOneRecordExists_containsOneRecords() {
        BookStore subject = new BookStore();


        ArrayList<Author> firstAuthorOfTheBook = new ArrayList<>();
        firstAuthorOfTheBook.add(new Author("Robert", "Ervin"));

        Date date1 = new Date(2016, 3, 8);

        subject.add(new Book("History",
                5.55,
                date1,
                firstAuthorOfTheBook,

                new ISBN("ISBN", "2108-9990"))
        );

        ArrayList<Author> secondAuthorOfTheBook = new ArrayList<>();
        secondAuthorOfTheBook.add(new Author("Edgard", "Allan"));
        secondAuthorOfTheBook.add(new Author("Robert", "Howard"));

        Date date2 = new Date(2016, 12, 15);

        subject.add(new Book("Math",
                8.67,
                date2,
                secondAuthorOfTheBook,

                new ISBN("ISBN", "3297-4564"))
        );

        ArrayList<Author> thirdAuthorOfTheBook = new ArrayList<>();
        thirdAuthorOfTheBook.add(new Author("Arthur", "Conan"));
        thirdAuthorOfTheBook.add(new Author("Robert", "Howard"));
        thirdAuthorOfTheBook.add(new Author("William", "Seneca"));

        Date date3 = new Date(2016, 11, 2);

        subject.add(new Book("Poems",
                10.55,
                date3,
                thirdAuthorOfTheBook,

                new ISBN("ISBN", "6166-2345"))
        );

        List<ReadingMaterial> actual = subject.findByAuthorLastName("Ervin");

        assertThat(actual).hasSize(1);

        Book actualFirstBook = (Book) actual.get(0);

        assertThat(actualFirstBook.name).isEqualTo("History");
        assertThat(actualFirstBook.price).isEqualTo(5.55);
        assertThat(actualFirstBook.datePublished.getYear()).isEqualTo(2016);
        assertThat(actualFirstBook.datePublished.getMonth()).isEqualTo(3);
        assertThat(actualFirstBook.datePublished.getDate()).isEqualTo(8);
        assertThat(actualFirstBook.authors.get(0).firstName).isEqualTo("Robert");
        assertThat(actualFirstBook.authors.get(0).lastName).isEqualTo("Ervin");
        assertThat(actualFirstBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualFirstBook.ISBN_10.number).isEqualTo("2108-9990");
    }


    @Test
    public void findByAuthorLastName_whenFindOneRecordExists_containsTwoRecords() {
        BookStore subject = new BookStore();

        ArrayList<Author> firstAuthorOfTheBook = new ArrayList<>();
        firstAuthorOfTheBook.add(new Author("Robert", "Ervin"));

        Date date1 = new Date(2020, 7, 11);

        subject.add(new Book("History",
                5.55,
                date1,
                firstAuthorOfTheBook,

                new ISBN("ISBN", "2108-9990"))
        );

        ArrayList<Author> secondAuthorOfTheBook = new ArrayList<>();
        secondAuthorOfTheBook.add(new Author("Edgard", "Tsu"));
        secondAuthorOfTheBook.add(new Author("Robert", "Howard"));

        Date date2 = new Date(2012, 5, 13);

        subject.add(new Book("Art of war",
                45.0,
                date2,
                secondAuthorOfTheBook,

                new ISBN("ISBN", "3297-4564"))
        );

        ArrayList<Author> thirdAuthorOfTheBook = new ArrayList<>();
        thirdAuthorOfTheBook.add(new Author("Arthur", "Conan"));
        thirdAuthorOfTheBook.add(new Author("Robert", "Howard"));
        thirdAuthorOfTheBook.add(new Author("William", "Seneca"));

        Date date3 = new Date(2022, 12, 15);

        subject.add(new Book("Math",
                8.67,
                date3,
                thirdAuthorOfTheBook,

                new ISBN("ISBN", "6166-2345"))
        );

        ArrayList<Author> fourthAuthorOfTheBook = new ArrayList<>();
        fourthAuthorOfTheBook.add(new Author("Bram", "Stoker"));
        fourthAuthorOfTheBook.add(new Author("Robert", "Howard"));
        fourthAuthorOfTheBook.add(new Author("William", "Seneca"));

        Date date4 = new Date(2014, 11, 14);

        subject.add(new Book("Poems",
                10.55,
                date4,
                fourthAuthorOfTheBook,

                new ISBN("ISBN", "6166-2345"))
        );

        ArrayList<Author> fifthAuthorOfTheBook = new ArrayList<>();
        fifthAuthorOfTheBook.add(new Author("Jeni", "Tsu"));

        Date date5 = new Date(1978, 6, 17);

        subject.add(new Book("Art",
                20.5,
                date5,
                fifthAuthorOfTheBook,

                new ISBN("ISBN", "6166-2035"))
        );

        List<ReadingMaterial> actual = subject.findByAuthorLastName("Tsu");

        assertThat(actual).hasSize(2);

        Book actualFirstBook = (Book) actual.get(0);

        assertThat(actualFirstBook.name).isEqualTo("Art of war");
        assertThat(actualFirstBook.price).isEqualTo(45.0);
        assertThat(actualFirstBook.datePublished.getYear()).isEqualTo(2012);
        assertThat(actualFirstBook.datePublished.getMonth()).isEqualTo(5);
        assertThat(actualFirstBook.datePublished.getDate()).isEqualTo(13);
        assertThat(actualFirstBook.authors.get(0).firstName).isEqualTo("Edgard");
        assertThat(actualFirstBook.authors.get(0).lastName).isEqualTo("Tsu");
        assertThat(actualFirstBook.authors.get(1).firstName).isEqualTo("Robert");
        assertThat(actualFirstBook.authors.get(1).lastName).isEqualTo("Howard");
        assertThat(actualFirstBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualFirstBook.ISBN_10.number).isEqualTo("3297-4564");

        Book actualSecondBook = (Book) actual.get(1);

        assertThat(actualSecondBook .name).isEqualTo("Art");
        assertThat(actualSecondBook .price).isEqualTo(20.5);
        assertThat(actualSecondBook .datePublished.getYear()).isEqualTo(1978);
        assertThat(actualSecondBook .datePublished.getMonth()).isEqualTo(6);
        assertThat(actualSecondBook .datePublished.getDate()).isEqualTo(17);
        assertThat(actualSecondBook .authors.get(0).firstName).isEqualTo("Jeni");
        assertThat(actualSecondBook .authors.get(0).lastName).isEqualTo("Tsu");
        assertThat(actualSecondBook .ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualSecondBook .ISBN_10.number).isEqualTo("6166-2035");

    }

    @Test
    public void findByAuthorLastName_whenRecordsExist_returnsCorrectRecord() {
        BookStore subject = new BookStore();

        ArrayList<Author> firstAuthorOfTheBook = new ArrayList<>();
        firstAuthorOfTheBook.add(new Author("Robert", "Ervin"));

        Date date1 = new Date(2018, 10, 7);

        subject.add(new Book("History",
                5.55,
                date1,
                firstAuthorOfTheBook,

                new ISBN("ISBN", "2108-9990"))
        );

        ArrayList<Author> secondAuthorOfTheBook = new ArrayList<>();
        secondAuthorOfTheBook.add(new Author("Edgard", "Tsu"));
        secondAuthorOfTheBook.add(new Author("Robert", "Howard"));

        Date date2 = new Date(2013, 3, 6);

        subject.add(new Book("Art of war",
                45.0,
                date2,
                secondAuthorOfTheBook,

                new ISBN("ISBN", "3297-4564"))
        );

        ArrayList<Author> thirdAuthorOfTheBook = new ArrayList<>();
        thirdAuthorOfTheBook.add(new Author("Arthur", "Conan"));
        thirdAuthorOfTheBook.add(new Author("Robert", "Howard"));
        thirdAuthorOfTheBook.add(new Author("William", "Seneca"));

        Date date3 = new Date(1990, 12, 1);

        subject.add(new Book("Math",
                8.67,
                date3,
                thirdAuthorOfTheBook,

                new ISBN("ISBN", "6166-2345"))
        );

        ArrayList<Author> fourthAuthorOfTheBook = new ArrayList<>();
        fourthAuthorOfTheBook.add(new Author("Nikola", "Tesla"));
        fourthAuthorOfTheBook.add(new Author("Robert", "Howard"));
        fourthAuthorOfTheBook.add(new Author("William", "Seneca"));

        Date date4 = new Date(2020, 6, 28);

        subject.add(new Book("Poems",
                10.55,
                date4,
                fourthAuthorOfTheBook,

                new ISBN("ISBN", "6166-2345"))
        );

        ArrayList<Author> fifthAuthorOfTheBook = new ArrayList<>();
        fifthAuthorOfTheBook.add(new Author("Jeni", "Tsu"));

        Date date5 = new Date(2020, 4, 21);

        subject.add(new Book("Art",
                20.5,
                date5,
                fifthAuthorOfTheBook,

                new ISBN("ISBN", "6166-2035"))
        );

        List<ReadingMaterial> actual = subject.findByAuthorLastName("Tsu");

        assertThat(actual).hasSize(2);

        Book actualFirstBook = (Book) actual.get(0);

        assertThat(actualFirstBook.name).isEqualTo("Art of war");
        assertThat(actualFirstBook.price).isEqualTo(45.0);
        assertThat(actualFirstBook.datePublished.getYear()).isEqualTo(2013);
        assertThat(actualFirstBook.datePublished.getMonth()).isEqualTo(3);
        assertThat(actualFirstBook.datePublished.getDate()).isEqualTo(6);
        assertThat(actualFirstBook.authors.get(0).firstName).isEqualTo("Edgard");
        assertThat(actualFirstBook.authors.get(0).lastName).isEqualTo("Tsu");
        assertThat(actualFirstBook.authors.get(1).firstName).isEqualTo("Robert");
        assertThat(actualFirstBook.authors.get(1).lastName).isEqualTo("Howard");
        assertThat(actualFirstBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualFirstBook.ISBN_10.number).isEqualTo("3297-4564");

        Book actualSecondBook = (Book) actual.get(1);

        assertThat(actualSecondBook.name).isEqualTo("Art");
        assertThat(actualSecondBook.price).isEqualTo(20.5);
        assertThat(actualSecondBook.datePublished.getYear()).isEqualTo(2020);
        assertThat(actualSecondBook.datePublished.getMonth()).isEqualTo(4);
        assertThat(actualSecondBook.datePublished.getDate()).isEqualTo(21);
        assertThat(actualSecondBook.authors.get(0).firstName).isEqualTo("Jeni");
        assertThat(actualSecondBook.authors.get(0).lastName).isEqualTo("Tsu");
        assertThat(actualSecondBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualSecondBook.ISBN_10.number).isEqualTo("6166-2035");
    }

    @Test
    public void findByAuthorFirstName_whenRecordsExist_returnsCorrectRecord() {
        BookStore subject = new BookStore();

        ArrayList<Author> firstAuthorOfTheBook = new ArrayList<>();
        firstAuthorOfTheBook.add(new Author("Robert", "Ervin"));

        subject.add(new Book("History",
                5.55,
                new Date(),
                firstAuthorOfTheBook,

                new ISBN("ISBN", "2108-9990"))
        );

        ArrayList<Author> secondAuthorOfTheBook = new ArrayList<>();
        secondAuthorOfTheBook.add(new Author("Edgard", "Tsu"));
        secondAuthorOfTheBook.add(new Author("Jeni", "Howard"));

        Date date2 = new Date(2021, 5, 18);

        subject.add(new Book("Art of war",
                45.0,
                date2,
                secondAuthorOfTheBook,

                new ISBN("ISBN", "3297-4564"))
        );

        ArrayList<Author> thirdAuthorOfTheBook = new ArrayList<>();
        thirdAuthorOfTheBook.add(new Author("Jeni", "Conan"));
        thirdAuthorOfTheBook.add(new Author("Robert", "Howard"));
        thirdAuthorOfTheBook.add(new Author("William", "Seneca"));

        Date date3 = new Date(2019, 11, 22);

        subject.add(new Book("Math",
                8.67,
                date3,
                thirdAuthorOfTheBook,

                new ISBN("ISBN", "6166-2345"))
        );

        ArrayList<Author> fourthAuthorOfTheBook = new ArrayList<>();
        fourthAuthorOfTheBook.add(new Author("Nikola", "Tesla"));
        fourthAuthorOfTheBook.add(new Author("Robert", "Howard"));
        fourthAuthorOfTheBook.add(new Author("William", "Seneca"));

        Date date4 = new Date(2016, 8, 3);

        subject.add(new Book("Poems",
                10.55,
                date4,
                fourthAuthorOfTheBook,

                new ISBN("ISBN", "6166-2345"))
        );

        ArrayList<Author> fifthAuthorOfTheBook = new ArrayList<>();
        fifthAuthorOfTheBook.add(new Author("Jeni", "Tsu"));

        Date date5 = new Date(2021, 8, 29);

        subject.add(new Book("Art",
                20.5,
                date5,
                fifthAuthorOfTheBook,

                new ISBN("ISBN", "6166-2035"))
        );

        List<ReadingMaterial> actual = subject.findByAuthorFirstName("Jeni");

        assertThat(actual).hasSize(3);

        Book actualFirstBook = (Book) actual.get(0);

        assertThat(actualFirstBook.name).isEqualTo("Art of war");
        assertThat(actualFirstBook.price).isEqualTo(45.0);
        assertThat(actualFirstBook.datePublished.getYear()).isEqualTo(2021);
        assertThat(actualFirstBook.datePublished.getMonth()).isEqualTo(5);
        assertThat(actualFirstBook.datePublished.getDate()).isEqualTo(18);
        assertThat(actualFirstBook.authors.get(0).firstName).isEqualTo("Edgard");
        assertThat(actualFirstBook.authors.get(0).lastName).isEqualTo("Tsu");
        assertThat(actualFirstBook.authors.get(1).firstName).isEqualTo("Jeni");
        assertThat(actualFirstBook.authors.get(1).lastName).isEqualTo("Howard");
        assertThat(actualFirstBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualFirstBook.ISBN_10.number).isEqualTo("3297-4564");

        Book actualSecondBook = (Book) actual.get(1);

        assertThat(actualSecondBook.name).isEqualTo("Math");
        assertThat(actualSecondBook.price).isEqualTo(8.67);
        assertThat(actualSecondBook.datePublished.getYear()).isEqualTo(2019);
        assertThat(actualSecondBook.datePublished.getMonth()).isEqualTo(11);
        assertThat(actualSecondBook.datePublished.getDate()).isEqualTo(22);
        assertThat(actualSecondBook.authors.get(0).firstName).isEqualTo("Jeni");
        assertThat(actualSecondBook.authors.get(0).lastName).isEqualTo("Conan");
        assertThat(actualSecondBook.authors.get(1).firstName).isEqualTo("Robert");
        assertThat(actualSecondBook.authors.get(1).lastName).isEqualTo("Howard");
        assertThat(actualSecondBook.authors.get(2).firstName).isEqualTo("William");
        assertThat(actualSecondBook.authors.get(2).lastName).isEqualTo("Seneca");
        assertThat(actualSecondBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualSecondBook.ISBN_10.number).isEqualTo("6166-2345");

        Book actualThirdBook = (Book) actual.get(2);

        assertThat(actualThirdBook.name).isEqualTo("Art");
        assertThat(actualThirdBook.price).isEqualTo(20.5);
        assertThat(actualThirdBook.datePublished.getYear()).isEqualTo(2021);
        assertThat(actualThirdBook.datePublished.getMonth()).isEqualTo(8);
        assertThat(actualThirdBook.datePublished.getDate()).isEqualTo(29);
        assertThat(actualThirdBook.authors.get(0).firstName).isEqualTo("Jeni");
        assertThat(actualThirdBook.authors.get(0).lastName).isEqualTo("Tsu");
        assertThat(actualThirdBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualThirdBook.ISBN_10.number).isEqualTo("6166-2035");
    }

    @Test
    public void findByName_whenTwoRecordExists_containsTwoRecords() {
        BookStore subject = new BookStore();

        ArrayList<Author> firstAuthorOfTheBook = new ArrayList<>();
        firstAuthorOfTheBook.add(new Author("Robert", "Ervin"));

        Date date1 = new Date(2020, 11, 15);

        subject.add(new Book("History",
                5.55,
                date1,
                firstAuthorOfTheBook,

                new ISBN("ISBN", "2108-9990"))
        );

        ArrayList<Author> secondAuthorOfTheBook = new ArrayList<>();

        Date date2 = new Date(2018, 6, 9);

        subject.add(new Book("Art",
                45.0,
                date2,
                secondAuthorOfTheBook,

                new ISBN("ISBN", "3297-4564"))
        );

        ArrayList<Author> thirdAuthorOfTheBook = new ArrayList<>();
        thirdAuthorOfTheBook.add(new Author("Arthur", "Conan"));
        thirdAuthorOfTheBook.add(new Author("Robert", "Howard"));
        thirdAuthorOfTheBook.add(new Author("William", "Seneca"));

        Date date3 = new Date(2021, 12, 15);

        subject.add(new Book("Math",
                8.67,
                date3,
                thirdAuthorOfTheBook,

                new ISBN("ISBN", "6166-2345"))
        );


        ArrayList<Author> fourthAuthorOfTheBook = new ArrayList<>();
        fourthAuthorOfTheBook.add(new Author("Nikola", "Tesla"));
        fourthAuthorOfTheBook.add(new Author("Lee", "Howard"));
        fourthAuthorOfTheBook.add(new Author("William", "Seneca"));

        Date date4 = new Date(2020, 8, 29);

        subject.add(new Book("Poems",
                10.55,
                date4,
                fourthAuthorOfTheBook,

                new ISBN("ISBN", "6166-2345"))
        );

        ArrayList<Author> fifthAuthorOfTheBook = new ArrayList<>();
        fifthAuthorOfTheBook.add(new Author("Jeni", "Tsu"));

        Date date5 = new Date(2018, 6, 23);

        subject.add(new Book("Art",
                20.5,
                date5,
                fifthAuthorOfTheBook,

                new ISBN("ISBN", "6166-2035"))
        );

        List<ReadingMaterial> actual = subject.findByName("Art");

        assertThat(actual).hasSize(2);

        Book actualFirstBook = (Book) actual.get(0);

        assertThat(actualFirstBook.name).isEqualTo("Art");
        assertThat(actualFirstBook.price).isEqualTo(45.0);
        assertThat(actualFirstBook.datePublished.getYear()).isEqualTo(2018);
        assertThat(actualFirstBook.datePublished.getMonth()).isEqualTo(6);
        assertThat(actualFirstBook.datePublished.getDate()).isEqualTo(9);
        assertThat(actualFirstBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualFirstBook.ISBN_10.number).isEqualTo("3297-4564");

        Book actualSecondBook = (Book) actual.get(1);

        assertThat(actualSecondBook.name).isEqualTo("Art");
        assertThat(actualSecondBook.price).isEqualTo(20.5);
        assertThat(actualSecondBook.datePublished.getYear()).isEqualTo(2018);
        assertThat(actualSecondBook.datePublished.getMonth()).isEqualTo(6);
        assertThat(actualSecondBook.datePublished.getDate()).isEqualTo(23);
        assertThat(actualSecondBook.authors.get(0).firstName).isEqualTo("Jeni");
        assertThat(actualSecondBook.authors.get(0).lastName).isEqualTo("Tsu");
        assertThat(actualSecondBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualSecondBook.ISBN_10.number).isEqualTo("6166-2035");
    }

    @Test
    public void sortByAuthorLastName_whenRepeatRecordExists_containsSortRecords() {
        BookStore subject = new BookStore();

        ArrayList<Author> firstAuthorOfTheBook = new ArrayList<>();
        firstAuthorOfTheBook.add(new Author("Robert", "Ervin"));

        Date date1 = new Date(2020, 3, 17);

        subject.add(new Book("History",
                5.55,
                date1,
                firstAuthorOfTheBook,

                new ISBN("ISBN", "2108-9990"))
        );

        ArrayList<Author> secondAuthorOfTheBook = new ArrayList<>();
        secondAuthorOfTheBook.add(new Author("Edgard", "Tsu"));
        secondAuthorOfTheBook.add(new Author("Robert", "Howard"));

        Date date2 = new Date(2014, 2, 1);

        subject.add(new Book("Math",
                8.67,
                date2,
                secondAuthorOfTheBook,

                new ISBN("ISBN", "3297-4564"))
        );

        ArrayList<Author> thirdAuthorOfTheBook = new ArrayList<>();
        thirdAuthorOfTheBook.add(new Author("Arthur", "Conan"));
        thirdAuthorOfTheBook.add(new Author("Tom", "Howard"));
        thirdAuthorOfTheBook.add(new Author("William", "Soneca"));

        Date date3 = new Date(2012, 11, 14);

        subject.add(new Book("Poems",
                10.55,
                date3,
                thirdAuthorOfTheBook,

                new ISBN("ISBN", "6166-2345"))
        );

        ArrayList<Author> fourthAuthorOfTheBook = new ArrayList<>();
        fourthAuthorOfTheBook.add(new Author("Nikola", "Tesla"));
        fourthAuthorOfTheBook.add(new Author("Tim", "Seneca"));

        Date date4 = new Date(2016, 7, 26);

        subject.add(new Book("IT",
                55.55,
                date4,
                fourthAuthorOfTheBook,

                new ISBN("ISBN", "6166-2345"))
        );

        ArrayList<Author> fifthAuthorOfTheBook = new ArrayList<>();
        fifthAuthorOfTheBook.add(new Author("Jeni", "Tsu"));

        Date date5 = new Date(2020, 11, 16);

        subject.add(new Book("Home Art",
                59.0,
                date5,
                fifthAuthorOfTheBook,

                new ISBN("ISBN", "6166-2035"))
        );

        List<ReadingMaterial> actual = subject.sortByAuthorLastName();

        assertThat(actual).hasSize(5);

        Book actualFirstBook = (Book) actual.get(0);

        assertThat(actualFirstBook.name).isEqualTo("Poems");
        assertThat(actualFirstBook.price).isEqualTo(10.55);
        assertThat(actualFirstBook.datePublished.getYear()).isEqualTo(2012);
        assertThat(actualFirstBook.datePublished.getMonth()).isEqualTo(11);
        assertThat(actualFirstBook.datePublished.getDate()).isEqualTo(14);
        assertThat(actualFirstBook.authors.get(0).firstName).isEqualTo("Arthur");
        assertThat(actualFirstBook.authors.get(0).lastName).isEqualTo("Conan");
        assertThat(actualFirstBook.authors.get(1).firstName).isEqualTo("Tom");
        assertThat(actualFirstBook.authors.get(1).lastName).isEqualTo("Howard");
        assertThat(actualFirstBook.authors.get(2).firstName).isEqualTo("William");
        assertThat(actualFirstBook.authors.get(2).lastName).isEqualTo("Soneca");
        assertThat(actualFirstBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualFirstBook.ISBN_10.number).isEqualTo("6166-2345");

        Book actualSecondBook = (Book) actual.get(1);

        assertThat(actualSecondBook.name).isEqualTo("History");
        assertThat(actualSecondBook.price).isEqualTo(5.55);
        assertThat(actualSecondBook.datePublished.getYear()).isEqualTo(2020);
        assertThat(actualSecondBook.datePublished.getMonth()).isEqualTo(3);
        assertThat(actualSecondBook.datePublished.getDate()).isEqualTo(17);
        assertThat(actualSecondBook.authors.get(0).firstName).isEqualTo("Robert");
        assertThat(actualSecondBook.authors.get(0).lastName).isEqualTo("Ervin");
        assertThat(actualSecondBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualSecondBook.ISBN_10.number).isEqualTo("2108-9990");

        Book actualThirdBook = (Book) actual.get(2);

        assertThat(actualThirdBook.name).isEqualTo("IT");
        assertThat(actualThirdBook.price).isEqualTo(55.55);
        assertThat(actualThirdBook.datePublished.getYear()).isEqualTo(2016);
        assertThat(actualThirdBook.datePublished.getMonth()).isEqualTo(7);
        assertThat(actualThirdBook.datePublished.getDate()).isEqualTo(26);
        assertThat(actualThirdBook.authors.get(0).firstName).isEqualTo("Nikola");
        assertThat(actualThirdBook.authors.get(0).lastName).isEqualTo("Tesla");
        assertThat(actualThirdBook.authors.get(1).firstName).isEqualTo("Tim");
        assertThat(actualThirdBook.authors.get(1).lastName).isEqualTo("Seneca");
        assertThat(actualThirdBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualThirdBook.ISBN_10.number).isEqualTo("6166-2345");

        Book actualFourthBook = (Book) actual.get(3);

        assertThat(actualFourthBook.name).isEqualTo("Math");
        assertThat(actualFourthBook.price).isEqualTo(8.67);
        assertThat(actualFourthBook.datePublished.getYear()).isEqualTo(2014);
        assertThat(actualFourthBook.datePublished.getMonth()).isEqualTo(2);
        assertThat(actualFourthBook.datePublished.getDate()).isEqualTo(1);
        assertThat(actualFourthBook.authors.get(0).firstName).isEqualTo("Edgard");
        assertThat(actualFourthBook.authors.get(0).lastName).isEqualTo("Tsu");
        assertThat(actualFourthBook.authors.get(1).firstName).isEqualTo("Robert");
        assertThat(actualFourthBook.authors.get(1).lastName).isEqualTo("Howard");
        assertThat(actualFourthBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualFourthBook.ISBN_10.number).isEqualTo("3297-4564");

        Book actualFifthBook = (Book) actual.get(4);

        assertThat(actualFifthBook.name).isEqualTo("Home Art");
        assertThat(actualFifthBook.price).isEqualTo(59.00);
        assertThat(actualFifthBook.datePublished.getYear()).isEqualTo(2020);
        assertThat(actualFifthBook.datePublished.getMonth()).isEqualTo(11);
        assertThat(actualFifthBook.datePublished.getDate()).isEqualTo(16);
        assertThat(actualFifthBook.authors.get(0).firstName).isEqualTo("Jeni");
        assertThat(actualFifthBook.authors.get(0).lastName).isEqualTo("Tsu");
        assertThat(actualFifthBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualFifthBook.ISBN_10.number).isEqualTo("6166-2035");
/*
        assertThat(actual.get(5).name).isEqualTo("Math");
        assertThat(actual.get(5).authors.get(0).firstName).isEqualTo("Robert");
        assertThat(actual.get(5).authors.get(0).lastName).isEqualTo("Howard");
        assertThat(actual.get(5).authors.get(1).firstName).isEqualTo("Edgard");
        assertThat(actual.get(5).authors.get(1).lastName).isEqualTo("Tsu");
        assertThat(actual.get(5).price).isEqualTo(8.67);
        assertThat(actual.get(5).ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actual.get(5).ISBN_10.number).isEqualTo(3297 - 4564);

        assertThat(actual.get(3).name).isEqualTo("Poems");
        assertThat(actual.get(3).authors.get(0).firstName).isEqualTo("Arthur");
        assertThat(actual.get(3).authors.get(0).lastName).isEqualTo("Canon");
        assertThat(actual.get(3).authors.get(1).firstName).isEqualTo("Tom");
        assertThat(actual.get(3).authors.get(1).lastName).isEqualTo("Howard");
        assertThat(actual.get(3).authors.get(2).firstName).isEqualTo("William");
        assertThat(actual.get(3).authors.get(2).lastName).isEqualTo("Soneca");
        assertThat(actual.get(3).price).isEqualTo(10.55);
        assertThat(actual.get(3).ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actual.get(3).ISBN_10.number).isEqualTo(6166 - 2345);

        assertThat(actual.get(5).name).isEqualTo("Poems");
        assertThat(actual.get(5).authors.get(0).firstName).isEqualTo("Arthur");
        assertThat(actual.get(5).authors.get(0).lastName).isEqualTo("Canon");
        assertThat(actual.get(5).authors.get(1).firstName).isEqualTo("Tom");
        assertThat(actual.get(5).authors.get(1).lastName).isEqualTo("Howard");
        assertThat(actual.get(5).authors.get(2).firstName).isEqualTo("William");
        assertThat(actual.get(5).authors.get(2).lastName).isEqualTo("Soneca");
        assertThat(actual.get(5).price).isEqualTo(10.55);
        assertThat(actual.get(5).ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actual.get(5).ISBN_10.number).isEqualTo(6166 - 2345);

        assertThat(actual.get(6).name).isEqualTo("IT");
        assertThat(actual.get(6).authors.get(0).firstName).isEqualTo("Nikola");
        assertThat(actual.get(6).authors.get(0).lastName).isEqualTo("Tesla");
        assertThat(actual.get(6).authors.get(1).firstName).isEqualTo("Tim");
        assertThat(actual.get(6).authors.get(1).lastName).isEqualTo("Seneca");
        assertThat(actual.get(6).price).isEqualTo(55.55);
        assertThat(actual.get(6).ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actual.get(6).ISBN_10.number).isEqualTo(6166 - 2345);

 */
    }

    @Test
    public void sortByName_whenRepeatRecordExists_containsSortRecords() {
        BookStore subject = new BookStore();
        ArrayList<Author> firstAuthorOfTheBook = new ArrayList<>();
        firstAuthorOfTheBook.add(new Author("Robert", "Ervin"));

        Date date1 = new Date(2021, 7, 17);

        subject.add(new Book("History",
                5.55,
                date1,
                firstAuthorOfTheBook,

                new ISBN("ISBN", "2108-9990"))
        );

        ArrayList<Author> secondAuthorOfTheBook = new ArrayList<>();
        secondAuthorOfTheBook.add(new Author("Edgard", "Tsu"));
        secondAuthorOfTheBook.add(new Author("Robert", "Howard"));

        Date date2 = new Date(2019, 3, 17);

        subject.add(new Book("Math",
                8.67,
                date2,
                secondAuthorOfTheBook,

                new ISBN("ISBN", "3297-4564"))
        );

        ArrayList<Author> thirdAuthorOfTheBook = new ArrayList<>();
        thirdAuthorOfTheBook.add(new Author("Arthur", "Conan"));
        thirdAuthorOfTheBook.add(new Author("Tom", "Howard"));
        thirdAuthorOfTheBook.add(new Author("William", "Soneca"));

        Date date3 = new Date(2021, 4, 4);

        subject.add(new Book("Poems",
                10.55,
                date3,
                thirdAuthorOfTheBook,

                new ISBN("ISBN", "6166-2345"))
        );

        ArrayList<Author> fourthAuthorOfTheBook = new ArrayList<>();
        fourthAuthorOfTheBook.add(new Author("Nikola", "Tesla"));
        fourthAuthorOfTheBook.add(new Author("Tim", "Seneca"));

        Date date4 = new Date(2021, 1, 13);

        subject.add(new Book("IT",
                55.55,
                date4,
                fourthAuthorOfTheBook,

                new ISBN("ISBN", "6166-2035"))
        );

        ArrayList<Author> fifthAuthorOfTheBook = new ArrayList<>();
        fifthAuthorOfTheBook.add(new Author("Jeni", "Tsu"));

        Date date5 = new Date(2016, 7, 24);

        subject.add(new Book("Poems",
                59.0,
                date5,
                fifthAuthorOfTheBook,

                new ISBN("ISBN", "6166-2035"))
        );

        List<ReadingMaterial> actual = subject.sortByName();

        assertThat(actual).hasSize(5);

        Book actualFirstBook = (Book) actual.get(0);


        assertThat(actualFirstBook.name).isEqualTo("History");
        assertThat(actualFirstBook.price).isEqualTo(5.55);
        assertThat(actualFirstBook.datePublished.getYear()).isEqualTo(2021);
        assertThat(actualFirstBook.datePublished.getMonth()).isEqualTo(7);
        assertThat(actualFirstBook.datePublished.getDate()).isEqualTo(17);
        assertThat(actualFirstBook.authors.get(0).firstName).isEqualTo("Robert");
        assertThat(actualFirstBook.authors.get(0).lastName).isEqualTo("Ervin");
        assertThat(actualFirstBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualFirstBook.ISBN_10.number).isEqualTo("2108-9990");

        Book actualSecondBook = (Book) actual.get(1);


        assertThat(actualSecondBook.name).isEqualTo("IT");
        assertThat(actualSecondBook.price).isEqualTo(55.55);
        assertThat(actualSecondBook.datePublished.getYear()).isEqualTo(2021);
        assertThat(actualSecondBook.datePublished.getMonth()).isEqualTo(1);
        assertThat(actualSecondBook.datePublished.getDate()).isEqualTo(13);
        assertThat(actualSecondBook.authors.get(0).firstName).isEqualTo("Nikola");
        assertThat(actualSecondBook.authors.get(0).lastName).isEqualTo("Tesla");
        assertThat(actualSecondBook.authors.get(1).firstName).isEqualTo("Tim");
        assertThat(actualSecondBook.authors.get(1).lastName).isEqualTo("Seneca");
        assertThat(actualSecondBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualSecondBook.ISBN_10.number).isEqualTo("6166-2035");

        Book actualThirdBook = (Book) actual.get(2);


        assertThat(actualThirdBook.name).isEqualTo("Math");
        assertThat(actualThirdBook.price).isEqualTo(8.67);
        assertThat(actualThirdBook.datePublished.getYear()).isEqualTo(2019);
        assertThat(actualThirdBook.datePublished.getMonth()).isEqualTo(3);
        assertThat(actualThirdBook.datePublished.getDate()).isEqualTo(17);
        assertThat(actualThirdBook.authors.get(0).firstName).isEqualTo("Edgard");
        assertThat(actualThirdBook.authors.get(0).lastName).isEqualTo("Tsu");
        assertThat(actualThirdBook.authors.get(1).firstName).isEqualTo("Robert");
        assertThat(actualThirdBook.authors.get(1).lastName).isEqualTo("Howard");
        assertThat(actualThirdBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualThirdBook.ISBN_10.number).isEqualTo("3297-4564");

        Book actualFourthBook = (Book) actual.get(3);

        assertThat(actualFourthBook.name).isEqualTo("Poems");
        assertThat(actualFourthBook.price).isEqualTo(10.55);
        assertThat(actualFourthBook.datePublished.getYear()).isEqualTo(2021);
        assertThat(actualFourthBook.datePublished.getMonth()).isEqualTo(4);
        assertThat(actualFourthBook.datePublished.getDate()).isEqualTo(4);
        assertThat(actualFourthBook.authors.get(0).firstName).isEqualTo("Arthur");
        assertThat(actualFourthBook.authors.get(0).lastName).isEqualTo("Conan");
        assertThat(actualFourthBook.authors.get(1).firstName).isEqualTo("Tom");
        assertThat(actualFourthBook.authors.get(1).lastName).isEqualTo("Howard");
        assertThat(actualFourthBook.authors.get(2).firstName).isEqualTo("William");
        assertThat(actualFourthBook.authors.get(2).lastName).isEqualTo("Soneca");
        assertThat(actualFourthBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualFourthBook.ISBN_10.number).isEqualTo("6166-2345");

        Book actualFifthBook = (Book) actual.get(4);

        assertThat(actualFifthBook.name).isEqualTo("Poems");
        assertThat(actualFifthBook.price).isEqualTo(59.0);
        assertThat(actualFifthBook.datePublished.getYear()).isEqualTo(2016);
        assertThat(actualFifthBook.datePublished.getMonth()).isEqualTo(7);
        assertThat(actualFifthBook.datePublished.getDate()).isEqualTo(24);
        assertThat(actualFifthBook.authors.get(0).firstName).isEqualTo("Jeni");
        assertThat(actualFifthBook.authors.get(0).lastName).isEqualTo("Tsu");
        assertThat(actualFifthBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualFifthBook.ISBN_10.number).isEqualTo("6166-2035");
    }

    @Test
    public void sortByPriceFromLowToHigt_whenRepeatRecordExists_containsSortRecords() {
        BookStore subject = new BookStore();
        ArrayList<Author> firstAuthorOfTheBook = new ArrayList<>();
        firstAuthorOfTheBook.add(new Author("Robert", "Ervin"));

        Date date1 = new Date(2020, 2, 5);

        subject.add(new Book("History",
                5.55,
                date1,
                firstAuthorOfTheBook,

                new ISBN("ISBN", "2108-9990"))
        );

        ArrayList<Author> secondAuthorOfTheBook = new ArrayList<>();
        secondAuthorOfTheBook.add(new Author("Edgard", "Tsu"));
        secondAuthorOfTheBook.add(new Author("Robert", "Howard"));

        Date date2 = new Date(2017, 4, 29);

        subject.add(new Book("Math",
                5.55,
                date2,
                secondAuthorOfTheBook,

                new ISBN("ISBN", "3297-4564"))
        );

        ArrayList<Author> thirdAuthorOfTheBook = new ArrayList<>();
        thirdAuthorOfTheBook.add(new Author("Arthur", "Conan"));
        thirdAuthorOfTheBook.add(new Author("Tom", "Howard"));
        thirdAuthorOfTheBook.add(new Author("William", "Soneca"));

        Date date3 = new Date(2018, 6, 18);

        subject.add(new Book("Poems",
                10.55,
                date3,
                thirdAuthorOfTheBook,

                new ISBN("ISBN", "6166-2345"))
        );

        ArrayList<Author> fourthAuthorOfTheBook = new ArrayList<>();
        fourthAuthorOfTheBook.add(new Author("Nikola", "Tesla"));
        fourthAuthorOfTheBook.add(new Author("Tim", "Seneca"));

        Date date4 = new Date(2018, 6, 18);

        subject.add(new Book("IT",
                55.55,
                date4,
                fourthAuthorOfTheBook,

                new ISBN("ISBN", "6166-2035"))
        );

        ArrayList<Author> fifthAuthorOfTheBook = new ArrayList<>();
        fifthAuthorOfTheBook.add(new Author("Jeni", "Tsu"));

        Date date5 = new Date(2020, 7, 2);

        subject.add(new Book("Poems",
                59.0,
                date5,
                fifthAuthorOfTheBook,

                new ISBN("ISBN", "6166-2035"))
        );

        List<ReadingMaterial> actual = subject.sortByPriceFromLowToHigh();

        assertThat(actual).hasSize(5);

        Book actualFirstBook = (Book)  actual.get(0);

        assertThat(actualFirstBook.name).isEqualTo("History");
        assertThat(actualFirstBook.price).isEqualTo(5.55);
        assertThat(actualFirstBook.datePublished.getYear()).isEqualTo(2020);
        assertThat(actualFirstBook.datePublished.getMonth()).isEqualTo(2);
        assertThat(actualFirstBook.datePublished.getDate()).isEqualTo(5);
        assertThat(actualFirstBook.authors.get(0).firstName).isEqualTo("Robert");
        assertThat(actualFirstBook.authors.get(0).lastName).isEqualTo("Ervin");
        assertThat(actualFirstBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualFirstBook.ISBN_10.number).isEqualTo("2108-9990");

        Book actualSecondBook = (Book) actual.get(1);

        assertThat(actualSecondBook.name).isEqualTo("Math");
        assertThat(actualSecondBook.price).isEqualTo(5.55);
        assertThat(actualSecondBook.datePublished.getYear()).isEqualTo(2017);
        assertThat(actualSecondBook.datePublished.getMonth()).isEqualTo(4);
        assertThat(actualSecondBook.datePublished.getDate()).isEqualTo(29);
        assertThat(actualSecondBook.authors.get(0).firstName).isEqualTo("Edgard");
        assertThat(actualSecondBook.authors.get(0).lastName).isEqualTo("Tsu");
        assertThat(actualSecondBook.authors.get(1).firstName).isEqualTo("Robert");
        assertThat(actualSecondBook.authors.get(1).lastName).isEqualTo("Howard");
        assertThat(actualSecondBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualSecondBook.ISBN_10.number).isEqualTo("3297-4564");

        Book actualThirdBook = (Book) actual.get(2);

        assertThat(actualThirdBook.name).isEqualTo("Poems");
        assertThat(actualThirdBook.price).isEqualTo(10.55);
        assertThat(actualThirdBook.datePublished.getYear()).isEqualTo(2018);
        assertThat(actualThirdBook.datePublished.getMonth()).isEqualTo(6);
        assertThat(actualThirdBook.datePublished.getDate()).isEqualTo(18);
        assertThat(actualThirdBook.authors.get(0).firstName).isEqualTo("Arthur");
        assertThat(actualThirdBook.authors.get(0).lastName).isEqualTo("Conan");
        assertThat(actualThirdBook.authors.get(1).firstName).isEqualTo("Tom");
        assertThat(actualThirdBook.authors.get(1).lastName).isEqualTo("Howard");
        assertThat(actualThirdBook.authors.get(2).firstName).isEqualTo("William");
        assertThat(actualThirdBook.authors.get(2).lastName).isEqualTo("Soneca");
        assertThat(actualThirdBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualThirdBook.ISBN_10.number).isEqualTo("6166-2345");

        Book actualFourthBook = (Book) actual.get(3);


        assertThat(actualFourthBook.name).isEqualTo("IT");
        assertThat(actualFourthBook.price).isEqualTo(55.55);
        assertThat(actualFourthBook.datePublished.getYear()).isEqualTo(2018);
        assertThat(actualFourthBook.datePublished.getMonth()).isEqualTo(6);
        assertThat(actualFourthBook.datePublished.getDate()).isEqualTo(18);
        assertThat(actualFourthBook.authors.get(0).firstName).isEqualTo("Nikola");
        assertThat(actualFourthBook.authors.get(0).lastName).isEqualTo("Tesla");
        assertThat(actualFourthBook.authors.get(1).firstName).isEqualTo("Tim");
        assertThat(actualFourthBook.authors.get(1).lastName).isEqualTo("Seneca");
        assertThat(actualFourthBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualFourthBook.ISBN_10.number).isEqualTo("6166-2035");

        Book actualFifthBook = (Book) actual.get(4);

        assertThat(actualFifthBook.name).isEqualTo("Poems");
        assertThat(actualFifthBook.price).isEqualTo(59.0);
        assertThat(actualFifthBook.datePublished.getYear()).isEqualTo(2020);
        assertThat(actualFifthBook.datePublished.getMonth()).isEqualTo(7);
        assertThat(actualFifthBook.datePublished.getDate()).isEqualTo(2);
        assertThat(actualFifthBook.authors.get(0).firstName).isEqualTo("Jeni");
        assertThat(actualFifthBook.authors.get(0).lastName).isEqualTo("Tsu");
        assertThat(actualFifthBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualFifthBook.ISBN_10.number).isEqualTo("6166-2035");
    }

    @Test
    public void sortByPriceFromHigtToLow_whenRepeatRecordExists_containsSortRecords() {
        BookStore subject = new BookStore();
        ArrayList<Author> firstAuthorOfTheBook = new ArrayList<>();
        firstAuthorOfTheBook.add(new Author("Robert", "Ervin"));

        Date date1 = new Date(2020, 1, 10);

        subject.add(new Book("History",
                5.55,
                date1,
                firstAuthorOfTheBook,

                new ISBN("ISBN", "2108-9990"))
        );

        ArrayList<Author> secondAuthorOfTheBook = new ArrayList<>();
        secondAuthorOfTheBook.add(new Author("Edgard", "Tsu"));
        secondAuthorOfTheBook.add(new Author("Robert", "Howard"));

        Date date2 = new Date(2020, 2, 1);

        subject.add(new Book("Math",
                5.55,
                date2,
                secondAuthorOfTheBook,
                new ISBN("ISBN", "3297-4564"))
        );

        ArrayList<Author> thirdAuthorOfTheBook = new ArrayList<>();
        thirdAuthorOfTheBook.add(new Author("Arthur", "Conan"));
        thirdAuthorOfTheBook.add(new Author("Tom", "Howard"));
        thirdAuthorOfTheBook.add(new Author("William", "Soneca"));

        Date date3 = new Date(2016, 5, 27);

        subject.add(new Book("Poems",
                10.55,
                date3,
                thirdAuthorOfTheBook,

                new ISBN("ISBN", "6166-2345"))
        );

        ArrayList<Author> fourthAuthorOfTheBook = new ArrayList<>();
        fourthAuthorOfTheBook.add(new Author("Nikola", "Tesla"));
        fourthAuthorOfTheBook.add(new Author("Tim", "Seneca"));

        Date date4 = new Date(2020, 6, 12);

        subject.add(new Book("IT",
                55.55,
                date4,
                fourthAuthorOfTheBook,


                new ISBN("ISBN", "6166-2225"))
        );

        ArrayList<Author> fifthAuthorOfTheBook = new ArrayList<>();
        fifthAuthorOfTheBook.add(new Author("Jeni", "Tsu"));

        Date date5 = new Date(2018, 5, 1);

        subject.add(new Book("Poems",
                59.0,
                date5,
                fifthAuthorOfTheBook,

                new ISBN("ISBN", "6166-2035"))
        );

        List<ReadingMaterial> actual = subject.sortByPriceFromHighToLow();

        assertThat(actual).hasSize(5);

        Book actualFirstBook = (Book) actual.get(0);

        assertThat(actualFirstBook.name).isEqualTo("Poems");
        assertThat(actualFirstBook.price).isEqualTo(59.0);
        assertThat(actualFirstBook.datePublished.getYear()).isEqualTo(2018);
        assertThat(actualFirstBook.datePublished.getMonth()).isEqualTo(5);
        assertThat(actualFirstBook.datePublished.getDate()).isEqualTo(1);
        assertThat(actualFirstBook.authors.get(0).firstName).isEqualTo("Jeni");
        assertThat(actualFirstBook.authors.get(0).lastName).isEqualTo("Tsu");
        assertThat(actualFirstBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualFirstBook.ISBN_10.number).isEqualTo("6166-2035");

        Book actualSecondBook = (Book) actual.get(1);

        assertThat(actualSecondBook.name).isEqualTo("IT");
        assertThat(actualSecondBook.price).isEqualTo(55.55);
        assertThat(actualSecondBook.datePublished.getYear()).isEqualTo(2020);
        assertThat(actualSecondBook.datePublished.getMonth()).isEqualTo(6);
        assertThat(actualSecondBook.datePublished.getDate()).isEqualTo(12);
        assertThat(actualSecondBook.authors.get(0).firstName).isEqualTo("Nikola");
        assertThat(actualSecondBook.authors.get(0).lastName).isEqualTo("Tesla");
        assertThat(actualSecondBook.authors.get(1).firstName).isEqualTo("Tim");
        assertThat(actualSecondBook.authors.get(1).lastName).isEqualTo("Seneca");
        assertThat(actualSecondBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualSecondBook.ISBN_10.number).isEqualTo("6166-2225");

        Book actualThirdBook = (Book) actual.get(2);

        assertThat(actualThirdBook.name).isEqualTo("Poems");
        assertThat(actualThirdBook.price).isEqualTo(10.55);
        assertThat(actualThirdBook.datePublished.getYear()).isEqualTo(2016);
        assertThat(actualThirdBook.datePublished.getMonth()).isEqualTo(5);
        assertThat(actualThirdBook.datePublished.getDate()).isEqualTo(27);
        assertThat(actualThirdBook.authors.get(0).firstName).isEqualTo("Arthur");
        assertThat(actualThirdBook.authors.get(0).lastName).isEqualTo("Conan");
        assertThat(actualThirdBook.authors.get(1).firstName).isEqualTo("Tom");
        assertThat(actualThirdBook.authors.get(1).lastName).isEqualTo("Howard");
        assertThat(actualThirdBook.authors.get(2).firstName).isEqualTo("William");
        assertThat(actualThirdBook.authors.get(2).lastName).isEqualTo("Soneca");
        assertThat(actualThirdBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualThirdBook.ISBN_10.number).isEqualTo("6166-2345");

        Book actualFourthBook = (Book) actual.get(3);

        assertThat(actualFourthBook.name).isEqualTo("History");
        assertThat(actualFourthBook.price).isEqualTo(5.55);
        assertThat(actualFourthBook.datePublished.getYear()).isEqualTo(2020);
        assertThat(actualFourthBook.datePublished.getMonth()).isEqualTo(1);
        assertThat(actualFourthBook.datePublished.getDate()).isEqualTo(10);
        assertThat(actualFourthBook.authors.get(0).firstName).isEqualTo("Robert");
        assertThat(actualFourthBook.authors.get(0).lastName).isEqualTo("Ervin");
        assertThat(actualFourthBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualFourthBook.ISBN_10.number).isEqualTo("2108-9990");

        Book actualFifthBook = (Book) actual.get(4);

        assertThat(actualFifthBook.name).isEqualTo("Math");
        assertThat(actualFifthBook.price).isEqualTo(5.55);
        assertThat(actualFifthBook.datePublished.getYear()).isEqualTo(2020);
        assertThat(actualFifthBook.datePublished.getMonth()).isEqualTo(2);
        assertThat(actualFifthBook.datePublished.getDate()).isEqualTo(1);
        assertThat(actualFifthBook.authors.get(0).firstName).isEqualTo("Edgard");
        assertThat(actualFifthBook.authors.get(0).lastName).isEqualTo("Tsu");
        assertThat(actualFifthBook.authors.get(1).firstName).isEqualTo("Robert");
        assertThat(actualFifthBook.authors.get(1).lastName).isEqualTo("Howard");
        assertThat(actualFifthBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualFifthBook.ISBN_10.number).isEqualTo("3297-4564");
    }

    @Test
    public void addMagazine_whenRepeatRecordExists_containsRecords() {
        BookStore subject = new BookStore();

        Date date1 = new Date(2021, 4, 25);
        Date date2 = new Date(2021, 5, 1);


        subject.add(new Magazine("Cosmo", 3.55, date1, 4589));
        subject.add(new Magazine("People", 4.0, date2, 3476));

        List<ReadingMaterial> actual = subject.getAllItems();

        assertThat(actual).hasSize(2);

        Magazine actualFirstMagazine = (Magazine) actual.get(0);

        assertThat(actual.get(0).name).isEqualTo("Cosmo");
        assertThat(actual.get(0).price).isEqualTo(3.55);
        assertThat(actual.get(0).datePublished.getYear()).isEqualTo(2021);
        assertThat(actual.get(0).datePublished.getMonth()).isEqualTo(4);
        assertThat(actual.get(0).datePublished.getDate()).isEqualTo(25);
        assertThat(actualFirstMagazine.magazineNumber).isEqualTo(4589);

        Magazine actualSecondMagazine = (Magazine) actual.get(1);

        assertThat(actual.get(1).name).isEqualTo("People");
        assertThat(actual.get(1).price).isEqualTo(4.0);
        assertThat(actual.get(1).datePublished.getYear()).isEqualTo(2021);
        assertThat(actual.get(1).datePublished.getMonth()).isEqualTo(5);
        assertThat(actual.get(1).datePublished.getDate()).isEqualTo(1);
        assertThat(actualSecondMagazine.magazineNumber).isEqualTo(3476);
    }

    @Test
    public void addMagazineAndBook_whenRepeatRecordExists_containsRecords() {
        BookStore subject = new BookStore();

        Date date1 = new Date(2021, 2, 1);
        subject.add(new Magazine("Cosmo", 3.55, date1, 1223));

        Date date2 = new Date(2021, 3, 1);
        subject.add(new Magazine("People", 4.0, date2, 4536));

        ArrayList<Author> firstAuthorOfTheBook = new ArrayList<>();
        firstAuthorOfTheBook.add(new Author("Jeni", "Tsu"));

        Date date5 = new Date(2018, 5, 1);

        subject.add(new Book("Poems",
                59.0,
                date5,
                firstAuthorOfTheBook,
                new ISBN("ISBN", "6166-2035"))
        );

        List<ReadingMaterial> actual = subject.getAllItems();

        assertThat(actual).hasSize(3);

        Magazine actualFirstMagazine = (Magazine) actual.get(0);

        assertThat(actual.get(0).name).isEqualTo("Cosmo");
        assertThat(actual.get(0).price).isEqualTo(3.55);
        assertThat(actual.get(0).datePublished.getYear()).isEqualTo(2021);
        assertThat(actual.get(0).datePublished.getMonth()).isEqualTo(2);
        assertThat(actual.get(0).datePublished.getDate()).isEqualTo(1);
        assertThat(actualFirstMagazine.magazineNumber).isEqualTo(1223);

Magazine actualSecondMagazine = (Magazine) actual.get(1);

        assertThat(actual.get(1).name).isEqualTo("People");
        assertThat(actual.get(1).price).isEqualTo(4.0);
        assertThat(actual.get(1).datePublished.getYear()).isEqualTo(2021);
        assertThat(actual.get(1).datePublished.getMonth()).isEqualTo(3);
        assertThat(actual.get(1).datePublished.getDate()).isEqualTo(1);
        assertThat(actualSecondMagazine.magazineNumber).isEqualTo(4536);

        Book actualFirstBook = (Book) actual.get(2);

        assertThat(actualFirstBook.name).isEqualTo("Poems");
        assertThat(actualFirstBook.price).isEqualTo(59.0);
        assertThat(actualFirstBook.datePublished.getYear()).isEqualTo(2018);
        assertThat(actualFirstBook.datePublished.getMonth()).isEqualTo(5);
        assertThat(actualFirstBook.datePublished.getDate()).isEqualTo(1);
        assertThat(actualFirstBook.authors.get(0).firstName).isEqualTo("Jeni");
        assertThat(actualFirstBook.authors.get(0).lastName).isEqualTo("Tsu");
        assertThat(actualFirstBook.ISBN_10.isbn).isEqualTo("ISBN");
        assertThat(actualFirstBook.ISBN_10.number).isEqualTo("6166-2035");
    }
}
