import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class StoreBookTest {

    @Test
    public void add_whenSimpleStoreBook_works() {
        StoreBook subject = new StoreBook();

        subject.add(new Book("Math", "Tim", 2.99));
    }

    @Test
    public void add_whenOneRecordExists_returnOneRecord() {
        StoreBook subject = new StoreBook();

        subject.add(new Book("Math", "Tom", 2.99));
        subject.add(new Book("Physics", "Nuton", 8.55));

        List<Book> actual = subject.getAllBooks();

        assertThat(actual).hasSize(2);

        assertThat(actual.get(0).name).isEqualTo("Math");
        assertThat(actual.get(0).author).isEqualTo("Tom");
        assertThat(actual.get(0).price).isEqualTo(2.99);

        assertThat(actual.get(1).name).isEqualTo("Physics");
        assertThat(actual.get(1).author).isEqualTo("Nuton");
        assertThat(actual.get(1).price).isEqualTo(8.55);
    }

    @Test
    public void removeBook_whenOneRecordExists_containsZeroRecords() {
        StoreBook subject = new StoreBook();

        Book book = new Book("History", "Viktor", 5.55);
        subject.add(book);

        subject.remove(book);

        List<Book> actual = subject.getAllBooks();

        assertThat(actual).hasSize(0);
    }


    @Test
    public void removeBook_whenRemovingExistingRecord_containsRemainingBooks() {
        StoreBook subject = new StoreBook();

        Book book = new Book("History", "Viktor", 5.55);

        subject.add(book);
        subject.add(new Book("Math", "Tom", 8.67));

        subject.remove(book);

        List<Book> actual = subject.getAllBooks();

        assertThat(actual).hasSize(1);

        assertThat(actual.get(0).name).isEqualTo("Math");
        assertThat(actual.get(0).author).isEqualTo("Tom");
        assertThat(actual.get(0).price).isEqualTo(8.67);
    }

    @Test
    public void removeBook_whenOnTwoRecordExists_containsZeroRecords() {
        StoreBook subject = new StoreBook();

        Book book1 = new Book("History", "Viktor", 5.55);
        subject.add(book1);
        Book book2 = new Book("Math", "Tom", 8.67);
        subject.add(book2);
        Book book3 = new Book("Poems", "Taras", 10.55);
        subject.add(book3);

        subject.remove(book2);
        subject.remove(book3);

        List<Book> actual = subject.getAllBooks();

        assertThat(actual).hasSize(1);

        assertThat(actual.get(0).name).isEqualTo("History");
        assertThat(actual.get(0).author).isEqualTo("Viktor");
        assertThat(actual.get(0).price).isEqualTo(5.55);
    }

    @Test
    public void findByPrice_whenOneRecordExists_containsZeroRecords() {
        StoreBook subject = new StoreBook();

        subject.add(new Book("History", "Viktor", 5.55));
        subject.add(new Book("Math", "Tom", 8.67));
        subject.add(new Book("Poems", "Taras", 10.55));

        List<Book> actual = subject.findByPrice(5.55);

        assertThat(actual).hasSize(1);

        assertThat(actual.get(0).name).isEqualTo("History");
        assertThat(actual.get(0).author).isEqualTo("Viktor");
        assertThat(actual.get(0).price).isEqualTo(5.55);
    }

    @Test
    public void findByPrice_whenRepeatRecordExists_containsZeroRecords() {
        StoreBook subject = new StoreBook();

        subject.add(new Book("History", "Viktor", 5.55));
        subject.add(new Book("Math", "Tom", 8.67));
        subject.add(new Book("Poems", "Taras", 10.55));
        subject.add(new Book("IT", "Smit", 5.55));

        List<Book> actual = subject.findByPrice(5.55);

        assertThat(actual).hasSize(2);

        assertThat(actual.get(0).name).isEqualTo("History");
        assertThat(actual.get(0).author).isEqualTo("Viktor");
        assertThat(actual.get(0).price).isEqualTo(5.55);

        assertThat(actual.get(1).name).isEqualTo("IT");
        assertThat(actual.get(1).author).isEqualTo("Smit");
        assertThat(actual.get(1).price).isEqualTo(5.55);

    }

    @Test
    public void findByPrice_whenTwoRecordExists_containsZeroRecords() {
        StoreBook subject = new StoreBook();

        subject.add(new Book("History", "Viktor", 5.55));
        subject.add(new Book("Math", "Tom", 8.67));
        subject.add(new Book("Art of war", "Tsu", 5.55));
        subject.add(new Book("Poems", "Taras", 10.55));

        List<Book> actual = subject.findByPrice(5.55);

        assertThat(actual).hasSize(2);

        assertThat(actual.get(0).name).isEqualTo("History");
        assertThat(actual.get(0).author).isEqualTo("Viktor");
        assertThat(actual.get(0).price).isEqualTo(5.55);

        assertThat(actual.get(1).name).isEqualTo("Art of war");
        assertThat(actual.get(1).author).isEqualTo("Tsu");
        assertThat(actual.get(1).price).isEqualTo(5.55);
    }

    @Test
    public void findByPrice_whenThreeRecordExists_containsZeroRecords() {
        StoreBook subject = new StoreBook();

        subject.add(new Book("History", "Viktor", 5.55));
        subject.add(new Book("Math", "Tom", 8.67));
        subject.add(new Book("Poems", "Taras", 10.55));

        List<Book> actual = subject.findByPrice(10.55);

        assertThat(actual).hasSize(1);

        assertThat(actual.get(0).name).isEqualTo("Poems");
        assertThat(actual.get(0).author).isEqualTo("Taras");
        assertThat(actual.get(0).price).isEqualTo(10.55);

    }


    @Test
    public void findByAuthor_whenOneRecordExists_containsZeroRecords() {
        StoreBook subject = new StoreBook();

        subject.add(new Book("History", "Viktor", 5.55));
        subject.add(new Book("Math", "Tom", 8.67));
        subject.add(new Book("Poems", "Taras", 10.55));

        List<Book> actual = subject.findByAuthor("Taras");

        assertThat(actual).hasSize(1);

        assertThat(actual.get(0).name).isEqualTo("Poems");
        assertThat(actual.get(0).author).isEqualTo("Taras");
        assertThat(actual.get(0).price).isEqualTo(10.55);
    }


    @Test
    public void findByAuthor_whenTwoRecordExists_containsZeroRecords() {
        StoreBook subject = new StoreBook();

        subject.add(new Book("History", "Viktor", 5.55));
        subject.add(new Book("Art of war", "Tsu", 45.0));
        subject.add(new Book("Math", "Tom", 8.67));
        subject.add(new Book("Poems", "Taras", 10.55));
        subject.add(new Book("Art", "Tsu", 20.5));

        List<Book> actual = subject.findByAuthor("Tsu");

        assertThat(actual).hasSize(2);

        assertThat(actual.get(0).name).isEqualTo("Art of war");
        assertThat(actual.get(0).author).isEqualTo("Tsu");
        assertThat(actual.get(0).price).isEqualTo(45.0);

        assertThat(actual.get(1).name).isEqualTo("Art");
        assertThat(actual.get(1).author).isEqualTo("Tsu");
        assertThat(actual.get(1).price).isEqualTo(20.5);
    }

    @Test
    public void findByAuthor_whenRecordsExist_returnsCorrectRecord() {
        StoreBook subject = new StoreBook();

        subject.add(new Book("History", "Viktor", 5.55));
        subject.add(new Book("Art of war", "Tsu", 45.0));
        subject.add(new Book("Math", "Tom", 8.67));
        subject.add(new Book("Poems", "Taras", 10.55));
        subject.add(new Book("Art", "Tsu", 20.5));

        List<Book> actual = subject.findByAuthor("Tsu");

        assertThat(actual).hasSize(2);

        assertThat(actual.get(0).name).isEqualTo("Art of war");
        assertThat(actual.get(0).author).isEqualTo("Tsu");
        assertThat(actual.get(0).price).isEqualTo(45.0);

        assertThat(actual.get(1).name).isEqualTo("Art");
        assertThat(actual.get(1).author).isEqualTo("Tsu");
        assertThat(actual.get(1).price).isEqualTo(20.5);
    }

    @Test
    public void findByName_whenTwoRecordExists_containsTwoRecords() {
        StoreBook subject = new StoreBook();

        subject.add(new Book("History", "Viktor", 5.55));
        subject.add(new Book("Art", "Tsu", 45.0));
        subject.add(new Book("Math", "Tom", 8.67));
        subject.add(new Book("Poems", "Taras", 10.55));
        subject.add(new Book("Art", "Robert Lee", 20.5));

        List<Book> actual = subject.findByName("Art");

        assertThat(actual).hasSize(2);

        assertThat(actual.get(0).name).isEqualTo("Art");
        assertThat(actual.get(0).author).isEqualTo("Tsu");
        assertThat(actual.get(0).price).isEqualTo(45.0);

        assertThat(actual.get(1).name).isEqualTo("Art");
        assertThat(actual.get(1).author).isEqualTo("Robert Lee");
        assertThat(actual.get(1).price).isEqualTo(20.5);
    }


    @Test
    public void sortByAuthor_whenRepeatRecordExists_containsSortRecords() {
        StoreBook subject = new StoreBook();

        subject.add(new Book("History", "Viktor", 5.55));
        subject.add(new Book("Math", "Tom", 8.67));
        subject.add(new Book("Poems", "Taras", 10.55));
        subject.add(new Book("IT", "Amit", 5.55));
        subject.add(new Book("Home Art", "Viktor", 59.0));

        List<Book> actual = subject.sortByAuthor();

        assertThat(actual).hasSize(5);

        assertThat(actual.get(0).name).isEqualTo("IT");
        assertThat(actual.get(0).author).isEqualTo("Amit");
        assertThat(actual.get(0).price).isEqualTo(5.55);

        assertThat(actual.get(1).name).isEqualTo("Poems");
        assertThat(actual.get(1).author).isEqualTo("Taras");
        assertThat(actual.get(1).price).isEqualTo(10.55);

        assertThat(actual.get(2).name).isEqualTo("Math");
        assertThat(actual.get(2).author).isEqualTo("Tom");
        assertThat(actual.get(2).price).isEqualTo(8.67);

        assertThat(actual.get(3).name).isEqualTo("History");
        assertThat(actual.get(3).author).isEqualTo("Viktor");
        assertThat(actual.get(3).price).isEqualTo(5.55);

        assertThat(actual.get(4).name).isEqualTo("Home Art");
        assertThat(actual.get(4).author).isEqualTo("Viktor");
        assertThat(actual.get(4).price).isEqualTo(59.0);
    }

    @Test
    public void sortByName_whenRepeatRecordExists_containsSortRecords() {
        StoreBook subject = new StoreBook();

        subject.add(new Book("History", "Viktor", 5.55));
        subject.add(new Book("Math", "Tom", 8.67));
        subject.add(new Book("Poems", "Taras", 10.55));
        subject.add(new Book("IT", "Amit", 5.55));
        subject.add(new Book("Poems", "Robert Lee", 20.3));

        List<Book> actual = subject.sortByName();

        assertThat(actual).hasSize(5);

        assertThat(actual.get(0).name).isEqualTo("History");
        assertThat(actual.get(0).author).isEqualTo("Viktor");
        assertThat(actual.get(0).price).isEqualTo(5.55);

        assertThat(actual.get(1).name).isEqualTo("IT");
        assertThat(actual.get(1).author).isEqualTo("Amit");
        assertThat(actual.get(1).price).isEqualTo(5.55);

        assertThat(actual.get(2).name).isEqualTo("Math");
        assertThat(actual.get(2).author).isEqualTo("Tom");
        assertThat(actual.get(2).price).isEqualTo(8.67);

        assertThat(actual.get(3).name).isEqualTo("Poems");
        assertThat(actual.get(3).author).isEqualTo("Taras");
        assertThat(actual.get(3).price).isEqualTo(10.55);

        assertThat(actual.get(4).name).isEqualTo("Poems");
        assertThat(actual.get(4).author).isEqualTo("Robert Lee");
        assertThat(actual.get(4).price).isEqualTo(20.3);


    }

    @Test
    public void sortByPriceFromLowToHigt_whenRepeatRecordExists_containsSortRecords() {
        StoreBook subject = new StoreBook();

        subject.add(new Book("History", "Viktor", 5.55));
        subject.add(new Book("Math", "Tom", 8.67));
        subject.add(new Book("Poems", "Taras", 10.55));
        subject.add(new Book("IT", "Amit", 5.55));

        List<Book> actual = subject.sortByPriceFromLowToHigh();

        assertThat(actual).hasSize(4);

        assertThat(actual.get(0).name).isEqualTo("History");
        assertThat(actual.get(0).author).isEqualTo("Viktor");
        assertThat(actual.get(0).price).isEqualTo(5.55);

        assertThat(actual.get(1).name).isEqualTo("IT");
        assertThat(actual.get(1).author).isEqualTo("Amit");
        assertThat(actual.get(1).price).isEqualTo(5.55);

        assertThat(actual.get(2).name).isEqualTo("Math");
        assertThat(actual.get(2).author).isEqualTo("Tom");
        assertThat(actual.get(2).price).isEqualTo(8.67);

        assertThat(actual.get(3).name).isEqualTo("Poems");
        assertThat(actual.get(3).author).isEqualTo("Taras");
        assertThat(actual.get(3).price).isEqualTo(10.55);
    }

    @Test
    public void sortByPriceFromHigtToLow_whenRepeatRecordExists_containsSortRecords() {
        StoreBook subject = new StoreBook();

        subject.add(new Book("History", "Viktor", 5.55));
        subject.add(new Book("Math", "Tom", 8.67));
        subject.add(new Book("Poems", "Taras", 10.55));
        subject.add(new Book("IT", "Amit", 60.5));
        subject.add(new Book("Art", "David Bay", 5.55));

        List<Book> actual = subject.sortByPriceFromHighToLow();

        assertThat(actual).hasSize(5);

        assertThat(actual.get(0).name).isEqualTo("IT");
        assertThat(actual.get(0).author).isEqualTo("Amit");
        assertThat(actual.get(0).price).isEqualTo(60.5);

        assertThat(actual.get(1).name).isEqualTo("Poems");
        assertThat(actual.get(1).author).isEqualTo("Taras");
        assertThat(actual.get(1).price).isEqualTo(10.55);

        assertThat(actual.get(2).name).isEqualTo("Math");
        assertThat(actual.get(2).author).isEqualTo("Tom");
        assertThat(actual.get(2).price).isEqualTo(8.67);

        assertThat(actual.get(3).name).isEqualTo("History");
        assertThat(actual.get(3).author).isEqualTo("Viktor");
        assertThat(actual.get(3).price).isEqualTo(5.55);

        assertThat(actual.get(4).name).isEqualTo("Art");
        assertThat(actual.get(4).author).isEqualTo("David Bay");
        assertThat(actual.get(4).price).isEqualTo(5.55);
    }

    @Test
    public void firstLastName_whenThreeRecordExists_containsThreeRecords() {
       // StoreBook subject = new StoreBook();
        Authors subject = new Authors();

        subject.addAuthorFirstLastName(buildAuthor("Ion", "Tsay"));
        subject.addAuthorFirstLastName(buildAuthor("Tom", "Bayts"));
        subject.addAuthorFirstLastName(buildAuthor("Kim", "Lee"));

        List<Authors> actual = subject.getAuthorsFirstLastName();

        assertThat(actual).hasSize(3);

        assertThat(actual.get(0).firstName.equals("Ion"));
        assertThat(actual.get(0).lastName.equals("Tsay"));
        assertThat(actual.get(1).firstName.equals("Tom"));
        assertThat(actual.get(1).lastName.equals("Bayts"));
        assertThat(actual.get(2).firstName.equals("Kim"));
        assertThat(actual.get(2).lastName.equals("Lee"));
    }

    private Authors buildAuthor(String firstName, String lastName) {
        Authors authors = new Authors();
        authors.firstName = firstName;
        authors.lastName = lastName;

        return authors;
    }

}
