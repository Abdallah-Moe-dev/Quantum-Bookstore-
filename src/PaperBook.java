public class PaperBook extends Book{
    private int stock;

    public PaperBook(int year, double price, String isbn, String author, String title, int stock) {
        super(year, price, isbn, author, title);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void addToStock(int stock) {
        this.stock += stock;
    }

    public boolean isAvailable() {
        return stock > 0;
    }

    public void purchase(int quantity, String email, String address) {
        if(quantity > stock)
            throw new IllegalArgumentException("Error: Not enough stock in the store");
        stock -= quantity;
        System.out.println("Paper book shipped to:" + address);
    }
}
