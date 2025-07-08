
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
    }
}
