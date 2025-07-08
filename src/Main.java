import java.util.*;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        Book paperBook = new PaperBook(2020, 120.0, "ISBN-001", "George Orwell", "1984", 1);
        Book ebook = new EBook(2022, 80.0, "ISBN-002", "Yuval Noah Harari", "Sapiens", "PDF");
        Book demoBook = new DemoBook(1995, 0.0, "ISBN-003", "Unknown", "Ancient Scroll");

        inventory.addBook(paperBook);
        inventory.addBook(ebook);
        inventory.addBook(demoBook);

        System.out.println("\n-----------------------------\n");

        // Test buying a paper book
        try {
            inventory.buyBook("ISBN-001", 2, "123 Nile St.", "alice@example.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n-----------------------------\n");

        // Test buying an ebook
        try {
            inventory.buyBook("ISBN-002", 1, null, "bob@example.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n-----------------------------\n");

        // Test trying to buy a showcase book
        try {
            inventory.buyBook("ISBN-003", 1, null, "charlie@example.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n-----------------------------\n");

        // Test trying to buy a book that doesn’t exist
        try {
            inventory.buyBook("ISBN-999", 1, "anywhere", "dana@example.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n-----------------------------\n");

        // Test trying to buy paper book that was already bought
        try {
            inventory.buyBook("ISBN-001", 2, "123 Nile St.", "alice@example.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n-----------------------------\n");

        Book book1 = new PaperBook(2010, 90.0, "OLD-001", "Old Author", "Legacy Code", 3);
        Book book2 = new PaperBook(2020, 110.0, "NEW-001", "Modern Author", "Clean Architecture", 5);
        Book book3 = new EBook(2012, 70.0, "OLD-002", "Someone Else", "Old PDF", "EPUB");
        Book book4 = new DemoBook(2025, 0.0, "NEW-002", "Nobody", "Historic Relic");

        inventory.addBook(book1);
        inventory.addBook(book2);
        inventory.addBook(book3);
        inventory.addBook(book4);

        System.out.println("\n--- Removing books older than 10 years ---");
        List<Book> removed = inventory.removeremoveOutdatedBooks(10);

        System.out.println("\nSummary of removed books:");
        for (Book b : removed) {
            System.out.println("- " + b.getTitle() + " (" + b.getYear() + ")");
        }

        System.out.println("\n--- Try buying removed book (should fail) ---");
        try {
            inventory.buyBook("OLD-001", 1, "Cairo", "user@example.com");
        } catch (Exception e) {
            System.out.println("Expected Error: " + e.getMessage());
        }
    }
}
