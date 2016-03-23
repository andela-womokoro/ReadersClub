
package readersClub;

import java.util.Objects;

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
        createBook("Alice in Wonderland", "3772819", "Lewis Carol");
        createBook("Frankinstein", "06672679", "Mary Shelley");
        createBook("Spectre", "7665923", "Ian Fleming");
        createBook("Havoc Junction", "9008765", "Joe Donnelly");
        createBook("Finders Keepers", "0087765", "Steven King");
        
        //create some enthusiastic club members
        createMember("Christina Sass", "Female", 29);
        createMember("Harry Smith", "Male", 17);
        createMember("Jane Doe", "Female", 16);
        createMember("Dipo Isola", "Male", 18);
        createMember("Tosin Adesanya", "Male", 27);
        createMember("Florence Okosun", "Female", 26);
        createMember("Jeremy Johnson", "Male", 32);
    }
    
    public static boolean createBook(String title, String isbn, String author){
        Book book = new Book(title, isbn, author);
        
        return Objects.nonNull(book);
    }
    
    public static boolean createMember(String name, String sex, int age){
        Staff member = new Staff(name, sex, age);
        
        return Objects.nonNull(member);
    }
    
    public static boolean borrowBook(Members member, Book book){
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
