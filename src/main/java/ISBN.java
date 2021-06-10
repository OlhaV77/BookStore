

public class ISBN {
    String isbn;
    String number;

    public ISBN(String isbn, String number) {
        this.isbn = isbn;
        this.number = number;
    }

    @Override
    public String toString() {
        return isbn + " "
                + number;
    }
}
