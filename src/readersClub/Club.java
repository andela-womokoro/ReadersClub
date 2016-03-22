
package readersClub;

/**
 *
 * @author Wilson Omokoro
 */
public class Club {
    
//    staffList;
//    studentsList;
//    books
    
    public static void main(String[] args){
        
        //create some books
        Book book1 = new Book("Alice in Wonderland","3772819", "Lewis Carol");
        
        
        //create club members
        Staff member1 = new Staff("Harry Smith", "Male", 27);
        
    }
    
    public static boolean createBook(String title, String isbn, String author){
        return false;
    }
    
    public static boolean createMember(String name, String sex, int age){
        return false;
    }
    
    public static boolean borrowBook(Members member, Book book){
        return false;
    }
    
    /**
     * utility method to pause the program for specified no of seconds during execution
     * @param secs 
     */
    public static void pauseProg(int secs){
        try{
            Thread.sleep(secs * 1000);
        }
        catch(InterruptedException ie){
           System.out.println(ie.toString());
        }
    }
}
