import java.util.*;

public class Inventory {

    private Map<String, Book> inventory = new HashMap<>();

    public void addBook(Book book){
        inventory.put(book.getIsbn(), book);
        if(book instanceof PaperBook)
            ((PaperBook) book).addToStock(1);
        System.out.println(book.getTitle() + " is newly added to the inventory");
    }

    public Book getBook(String isbn){
        return inventory.get(isbn);
    }

    public void buyBook(String isbn, int quantity, String address, String email){
        if(!inventory.containsKey(isbn))
            throw new IllegalArgumentException("Book not found.");

        Book book = inventory.get(isbn);
        // note: momkn replace by 1 isAvaliable()
//        if(book instanceof PaperBook){
//            if(!book.isAvailable()) throw new IllegalStateException("Quantum Bookstore: Book not available for purchase.");
//        }
//        else if(book instanceof DemoBook){
//            throw new UnsupportedOperationException("Error: This is a Showcase book, and is not for sale.");
//        }

        if(!book.isAvailable()) throw new IllegalStateException("Quantum Bookstore: Book not available for purchase.");

        double cost = quantity * book.getPrice();
        book.purchase(quantity, email, address);
        System.out.println("Quantum Bookstore: Paid amount $" + cost);

    }

    public List<Book> removeremoveOutdatedBooks(int maxAge){
        int currYear = Calendar.getInstance().get(Calendar.YEAR);
        List<Book> removedBooks = new ArrayList<>();

        Iterator<Map.Entry<String, Book>> iterator = inventory.entrySet().iterator();
        while (iterator.hasNext()){
            Book book = iterator.next().getValue();
            if(currYear - book.getYear() > maxAge){
                removedBooks.add(book);
                iterator.remove();
                System.out.println("Quantum book store: Removed outdated book " + book.getTitle() + " from year " + book.getYear());
            }
        }
        return removedBooks;
    }

}
