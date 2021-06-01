import java.util.Comparator;

public class PriceToHighToLowComparator implements Comparator<ReadingMaterial> {

    @Override
    public int compare(ReadingMaterial book1, ReadingMaterial book2) {
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
