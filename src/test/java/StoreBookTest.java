import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StoreBookTest {

    @Test
    public void add_whenSimpleStoreBook_works() {
        StoreBook subject = new StoreBook();

        subject.add(new Books("Math" , "Tim", 2.99));
    }

    @Test
    public  void  add_whenOneRecordExists_returnOneRecord(){
        StoreBook subject = new StoreBook();

        subject.add(new Books("Math", "Tim", 2.99));
        subject.add(new Books("Physics", "Nuton", 8.55));

        Books[] actual = subject.getInfo();

        assertThat(actual).hasSize(2);

        assertThat(actual[0].name).isEqualTo("Math");
        assertThat(actual[0].author).isEqualTo("Tim");
        assertThat(actual[0].price).isEqualTo(2.99);

        assertThat(actual[1].name).isEqualTo("Physics");
        assertThat(actual[1].author).isEqualTo("Nuton");
        assertThat(actual[1].price).isEqualTo(8.55);
    }

    @Test
    public void removeBook_whenOneRecordExists_containsZeroRecords() {
        StoreBook subject = new StoreBook();

        subject.add(new Books("History", "Viktor", 5.55 ));

        subject.removeBook(0);

        Books[] actual = subject.getInfo();

        assertThat(actual).hasSize(0);
    }


}
