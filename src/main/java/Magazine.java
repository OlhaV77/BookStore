import java.util.Date;

public class Magazine extends ReadingMaterial {
    // Magazine number
    // NO ISBN!

    public int magazineNumber;

    Magazine(String name, double price, Date dataPublished, int magazineNumber) {
        super(name, price, dataPublished);
        this.magazineNumber = magazineNumber;
    }

}
