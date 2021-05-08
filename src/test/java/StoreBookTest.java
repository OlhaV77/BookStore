import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StoreBookTest {

    @Test
    public void add_whenSimpleStoreBook_works() {
        StoreBook subject = new StoreBook ();

        subject.add (new Book ("Math", "Tim", 2.99));
    }

    @Test
    public void add_whenOneRecordExists_returnOneRecord() {
        StoreBook subject = new StoreBook ();

        subject.add (new Book ("Math", "Tom", 2.99));
        subject.add (new Book ("Physics", "Nuton", 8.55));

        List<Book> actual = subject.getAllBooks ();

        assertThat (actual).hasSize (2);

        assertThat (actual.get (0).name).isEqualTo ("Math");
        assertThat (actual.get (0).author).isEqualTo ("Tom");
        assertThat (actual.get (0).price).isEqualTo (2.99);

        assertThat (actual.get (1).name).isEqualTo ("Physics");
        assertThat (actual.get (1).author).isEqualTo ("Nuton");
        assertThat (actual.get (1).price).isEqualTo (8.55);
    }

    @Test
    public void removeBook_whenOneRecordExists_containsZeroRecords() {
        StoreBook subject = new StoreBook ();

        subject.add (new Book ("History", "Viktor", 5.55));

        subject.removeBookByTheName ("History");

        List<Book> actual = subject.getAllBooks ();

        assertThat (actual).hasSize (0);
    }


    @Test
    public void removeBook_whenTwoRecordExists_containsZeroRecords() {
        StoreBook subject = new StoreBook ();

        subject.add (new Book ("History", "Viktor", 5.55));
        subject.add (new Book ("Math", "Tom", 8.67));

        subject.removeBookByTheName ("History");

        List<Book> actual = (List<Book>) subject.getAllBooks ();

        assertThat (actual).hasSize (1);

        assertThat (actual.get (0).name).isEqualTo ("Math");
        assertThat (actual.get (0).author).isEqualTo ("Tom");
        assertThat (actual.get (0).price).isEqualTo (8.67);
    }

    @Test
    public void removeBook_whenOnTwoRecordExists_containsZeroRecords() {
        StoreBook subject = new StoreBook ();

        subject.add (new Book ("History", "Viktor", 5.55));
        subject.add (new Book ("Math", "Tom", 8.67));
        subject.add (new Book ("Poems", "Taras", 10.55));


        subject.removeBookByTheAuthor ("Tom");
        subject.removeBookByTheAuthor ("Taras");

        List<Book> actual = subject.getAllBooks ();

        assertThat (actual).hasSize (1);

        assertThat (actual.get (0).name).isEqualTo ("History");
        assertThat (actual.get (0).author).isEqualTo ("Viktor");
        assertThat (actual.get (0).price).isEqualTo (5.55);
    }

    @Test
    public void findByPrice_whenOneRecordExists_containsZeroRecords() {
        StoreBook subject = new StoreBook ();

        subject.add (new Book ("History", "Viktor", 5.55));
        subject.add (new Book ("Math", "Tom", 8.67));
        subject.add (new Book ("Poems", "Taras", 10.55));

        List<Book> actual = subject.findByPrice (5.55);

        assertThat (actual).hasSize (1);

        assertThat (actual.get (0).name).isEqualTo ("History");
        assertThat (actual.get (0).author).isEqualTo ("Viktor");
        assertThat (actual.get (0).price).isEqualTo (5.55);
    }

    @Test
    public void findByPrice_whenRepeatRecordExists_containsZeroRecords() {
        StoreBook subject = new StoreBook ();

        subject.add (new Book ("History", "Viktor", 5.55));
        subject.add (new Book ("Math", "Tom", 8.67));
        subject.add (new Book ("Poems", "Taras", 10.55));
        subject.add (new Book ("IT", "Smit", 5.55));

        List<Book> actual = subject.findByPrice (5.55);

        assertThat (actual).hasSize (2);

        assertThat(actual.get(0).name).isEqualTo ("History");
        assertThat(actual.get(0).author).isEqualTo ("Viktor");
        assertThat(actual.get(0).price).isEqualTo (5.55);

        assertThat (actual.get(1).name).isEqualTo ("IT");
        assertThat (actual.get(1).author).isEqualTo ("Smit");
        assertThat (actual.get(1).price).isEqualTo (5.55);

    }

    @Test
    public void findByPrice_whenTwoRecordExists_containsZeroRecords() {
        StoreBook subject = new StoreBook ();

        subject.add (new Book ("History", "Viktor", 5.55));
        subject.add (new Book ("Math", "Tom", 8.67));
        subject.add (new Book ("Art of war", "Tsu", 5.55));
        subject.add (new Book ("Poems", "Taras", 10.55));

        List<Book> actual = subject.findByPrice (5.55);

        assertThat (actual).hasSize (2);

        assertThat (actual.get (0).name).isEqualTo ("History");
        assertThat (actual.get (0).author).isEqualTo ("Viktor");
        assertThat (actual.get (0).price).isEqualTo (5.55);

        assertThat (actual.get (1).name).isEqualTo ("Art of war");
        assertThat (actual.get (1).author).isEqualTo ("Tsu");
        assertThat (actual.get (1).price).isEqualTo (5.55);
    }

    @Test
    public void findByPrice_whenThreeRecordExists_containsZeroRecords() {
        StoreBook subject = new StoreBook ();

        subject.add (new Book ("History", "Viktor", 5.55));
        subject.add (new Book ("Math", "Tom", 8.67));
        subject.add (new Book ("Poems", "Taras", 10.55));

        List<Book>actual = subject.findByPrice (10.55);

        assertThat (actual).hasSize (1);

        assertThat (actual.get (0).name).isEqualTo ("Poems");
        assertThat (actual.get (0).author).isEqualTo ("Taras");
        assertThat (actual.get (0).price).isEqualTo (10.55);

    }


    @Test
    public void findByAuthor_whenOneRecordExists_containsZeroRecords() {
        StoreBook subject = new StoreBook ();

        subject.add (new Book ("History", "Viktor", 5.55));
        subject.add (new Book ("Math", "Tom", 8.67));
        subject.add (new Book ("Poems", "Taras", 10.55));

       List<Book>actual =  subject.findByAuthor ("Taras");

       assertThat (actual).hasSize (1);

        assertThat (actual.get (0).name).isEqualTo ("Poems");
        assertThat (actual.get (0).author).isEqualTo ("Taras");
        assertThat (actual.get (0).price).isEqualTo (10.55);
    }


    @Test
    public void findByAuthor_whenTwoRecordExists_containsZeroRecords() {
        StoreBook subject = new StoreBook ();

        subject.add (new Book ("History", "Viktor", 5.55));
        subject.add (new Book ("Art of war", "Tsu", 45.0));
        subject.add (new Book ("Math", "Tom", 8.67));
        subject.add (new Book ("Poems", "Taras", 10.55));
        subject.add (new Book ("Art", "Tsu", 20.5));

        List<Book>actual = subject.findByAuthor ("Tsu");

        assertThat (actual).hasSize (2);

        assertThat (subject.findByAuthor ("Tsu").get (0).name).isEqualTo ("Art of war");
        assertThat (actual.get (0).author).isEqualTo ("Tsu");
        assertThat (actual.get (0).price).isEqualTo (45.0);

        assertThat (actual.get (1).name).isEqualTo ("Art");
        assertThat (actual.get (1).author).isEqualTo ("Tsu");
        assertThat (actual.get (1).price).isEqualTo (20.5);
    }


}
