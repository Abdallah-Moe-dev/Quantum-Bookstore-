public class EBook extends Book{

    private String fileType;

    public EBook(int year, double price, String isbn, String author, String title, String fileType) {
        super(year, price, isbn, author, title);
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }

    public boolean isAvailable() {
        return true; // since it is an EBook that exist online then there are unlimited number of it
    }

    public void purchase(int quantity, String email, String address) {
        System.out.println("EBook sent to this email:" + email);
    }
}
