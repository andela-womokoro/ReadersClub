
package readersClub;

import java.util.Objects;
import java.util.Random;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 * @author Wilson Omokoro
 */
public class Club {
    
    public static PriorityQueue<String> staffList = new PriorityQueue();
    public static PriorityQueue<String> studentsList = new PriorityQueue();
    public static ArrayList books = new ArrayList();
    
    public static void main(String[] args){
        
        //create some books
        createBook("Frankinstein", "06672679", "Mary Shelley");
        createBook("Spectre", "7665923", "Ian Fleming");
        createBook("Havoc Junction", "9008765", "Joe Donnelly");
        createBook("Finders Keepers", "0087765", "Steven King");
        
        //create some enthusiastic club members. Some are staff, some are student
        createMember("Christina Sass", "Female", 29, true);
        createMember("Harry Smith", "Male", 17, false);
        createMember("Jane Doe", "Female", 16, false);
        createMember("Dipo Isola", "Male", 18, false);
        createMember("Tosin Adesanya", "Male", 27, true);
        createMember("Florence Okosun", "Female", 26, true);
        createMember("Jeremy Johnson", "Male", 32, true);
        
        // display staff and students' list
        System.out.println("Staff Queue >>> "+staffList);
        System.out.println("Students' Queue >>> "+studentsList);
        
        // display books
        System.out.println("All Books:");
        for(int i=0; i<books.size(); i++){
            Book b = (Book)books.get(i);
            System.out.println(b.title+". (available: "+b.isAvailable+")");
        }
    }
    
    public static boolean createBook(String title, String isbn, String author){
        Book book = new Book(title, isbn, author);
        Random r = new Random();
        int copies = r.nextInt(2) + 1;
        book.setNoOfCopies(copies);
        
        for(int i=0; i<copies; i++){
            books.add(book);
        }
        
        return Objects.nonNull(book);
    }
    
    public static boolean createMember(String name, String sex, int age, boolean isStaff){
        
        if(isStaff){
            Staff member = new Staff(name, sex, age, isStaff);
            staffList.add(member.name);
            
            return Objects.nonNull(member);
        } else {
            Student member = new Student(name, sex, age, isStaff);
            studentsList.add(member.name);
            
            return Objects.nonNull(member);
        }
    }
    
    public static boolean borrowBook(Members member, String bookTitle){
        //check if a copy of the book is available
        //check member's rank
        //check member position in queue
  
        return false;
    }
    
    /**
     * utility method to pause the program for a specified no of seconds during execution
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
