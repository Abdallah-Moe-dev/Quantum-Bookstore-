
public class DemoBook extends Book {

    public DemoBook(int year, double price, String isbn, String author, String title) {
        super(year, price, isbn, author, title);
    }

    public boolean isAvailable() {
        return false;
    }

    public void purchase(int quantity, String email, String address) {
        throw new UnsupportedOperationException("Error: This is a Showcase book, and is not for sale.");
    }
}
