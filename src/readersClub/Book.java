
package readersClub;

/**
 *
 * @author Wilson Omokoro
 */
public class Book {
    
    public String title;
    public String isbn;
    public String author;
    int noOfCopies;
    
    public Book(String title, String isbn, String author) {
        System.out.println("Creating a book...");
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }
    
    public boolean setNoOfCopies(int copies){
       this.noOfCopies = copies; 
       
       return this.noOfCopies == copies;
    }
}
