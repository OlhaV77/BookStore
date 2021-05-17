import java.util.Comparator;

public class PriceToHighToLowComparator implements Comparator<Book> {

    @Override
    public int compare(Book book1, Book book2) {
        if(book1.price == book2.price) {
            return 0;
        }
        else  if(book1.price > book2.price){
            return -1;
        }
        else {
            return 1;
        }
    }
}
