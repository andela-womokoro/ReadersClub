
package readersClub;

/**
 *
 * @author Wilson Omokoro
 */
public class Book {
    
    public String title;
    public String isbn;
    public String author;
    public int noOfCopies;
    public boolean isAvailable;
    
    public Book(String title, String isbn, String author) {
        System.out.print("Creating a book \""+ title+"\" for the Readers' club... ");
        Club.pauseProg(2);
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.isAvailable = true;
        System.out.print("Done.\n");
    }
    
    public boolean setNoOfCopies(int copies){
       this.noOfCopies = copies; 
       
       return this.noOfCopies == copies;
    }
}
