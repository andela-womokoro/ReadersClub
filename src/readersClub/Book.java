
package readersClub;

/**
 *
 * @author Wilson Omokoro
 */
public class Book {
    
    public String title;
    public String isbn;
    public String author;
    public String category;
    int noOfCopies;
    
    public Book(String title, String isbn, String author) {
        System.out.println("Creating book...");
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }
}
