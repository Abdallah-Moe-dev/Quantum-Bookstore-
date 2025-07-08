
public abstract class Book {
    private final int year;
    private final String isbn;
    protected String author;
    protected String title;
    protected double price;

    public Book(int year, double price, String isbn, String author, String title) {
        this.year = year;
        this.price = price;
        this.isbn = isbn;
        this.author = author;
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public abstract boolean isAvailable();
    public abstract void purchase(int quantity, String email, String address);
}
