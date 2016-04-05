
package readersClub;

import java.util.Objects;
import java.util.Iterator;
import java.util.Random;
import java.util.HashMap;
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
    public static HashMap<String, ArrayList> bookRequests = new HashMap();
    
    public static void main(String[] args){
        
        //create some books
        createBook("Frankinstein", "06672679", "Mary Shelley");
        createBook("Spectre", "7665923", "Ian Fleming");
        createBook("Havoc Junction", "9008765", "Joe Donnelly");
        createBook("Finders Keepers", "0087765", "Steven King");
        
        //create some enthusiastic club members. Some are staff, some are student
        Staff m1 = (Staff) createMember("Christina Sass", "Female", 29, true);
        Student m2 = (Student) createMember("Harry Smith", "Male", 17, false);
        Student m3 = (Student) createMember("Jane Doe", "Female", 16, false);
        Student m4 = (Student) createMember("Dipo Isola", "Male", 18, false);
        Staff m5 = (Staff) createMember("Tosin Adesanya", "Male", 27, true);
        Staff m6 = (Staff) createMember("Florence Okosun", "Female", 26, true);
        Staff m7 = (Staff) createMember("Jeremy Johnson", "Male", 32, true);
        
        // display staff and students' list
        System.out.println("Staff Queue >>> "+staffList);
        System.out.println("Students' Queue >>> "+studentsList);
        
        // display books
        System.out.println("\nBooks' status before being borrowed:");
        for(int i=0; i<books.size(); i++){
            Book b = (Book)books.get(i);
            System.out.println(b.title+". (available: "+b.isAvailable+")");
        }
        
        // some members will request to borrow  books
        System.out.println("");
        m3.requestForBook("Spectre");
        m4.requestForBook("Spectre");
        m1.requestForBook("Spectre");
        
        //display book requests log
        /*System.out.println("\nBook requests:");
        for(String key : bookRequests.keySet()) {
            System.out.println(key + " : " + bookRequests.get(key));
        }
        */
        /*ddddd
        ArrayList al = bookRequests.get("Spectre");
        for(int i=0; i<al.size(); i++){
            Members m = (Members)al.get(i);
            System.out.println(m.name+", Staff: "+m.isStaff);
        }
        */
        
        //borrow books to members who requested for them
        borrowBook();
        
        // display books
        System.out.println("\nBooks' status after being borrowed:");
        for(int i=0; i<books.size(); i++){
            Book b = (Book)books.get(i);
            System.out.println(b.title+". (available: "+b.isAvailable+")");
        }
    }
    
    public static boolean createBook(String title, String isbn, String author){
        Book book = null;
        int copies = new Random().nextInt(2) + 1;
        
        for(int i=0; i<copies; i++){
            book = new Book(title, isbn, author);
            book.setNoOfCopies(copies);
            books.add(book);
        }
        
        return Objects.nonNull(book);
    }
    
    public static Members createMember(String name, String sex, int age, boolean isStaff){
        Members member;
        
        if(isStaff){
            member = new Staff(name, sex, age, isStaff);
            staffList.add(member.name);
        } else {
            member = new Student(name, sex, age, isStaff);
            studentsList.add(member.name);
        }
        
        return member;
    }
    
    public static boolean logBookRequest(Members member, String bookTitle){
        System.out.println(member.name+ " has requested to borrow a copy of \""+bookTitle+"\"");
        ArrayList requesters;
        
        if(bookRequests.containsKey(bookTitle)){
            requesters = (ArrayList)bookRequests.get(bookTitle);
        } else {
            requesters = new ArrayList();
        }
        
        requesters.add(member);
        bookRequests.put(bookTitle, requesters);
        
        return true;
    }
    
    public static boolean borrowBook(){
        //iterate through all book requests
        for(String key : bookRequests.keySet()) {
            String bookTitle = key;
            System.out.println("\nProcessing request(s) for \""+bookTitle + "\"...");
            
            //check if more than one person is requesting for the book
            ArrayList requesters = bookRequests.get(bookTitle);
            int noOfPeopleRequesting = requesters.size();
            System.out.println(noOfPeopleRequesting+" person(s) requested for \""+bookTitle+"\".");
        
            //iterate through books collection to see how many copies of the requested book are available
            int bookCopiesAvailable = 0;
            for(int i=0; i<books.size(); i++){
                Book b = (Book)books.get(i);
                if(b.title.equalsIgnoreCase(bookTitle) && b.isAvailable){
                    bookCopiesAvailable++;
                }
            }
            
            System.out.println(bookCopiesAvailable +" copies of \""+bookTitle+"\" are available.");
            
            //iterate through members' queues; staff queue first, then students' queue
            for(int g=0; g<=1; g++)
            {
                Iterator it;
                if(g == 0){
                    it = staffList.iterator();
                } 
                else {
                    it = studentsList.iterator();
                }

                String nameInQueue;
                while(it.hasNext()){
                    nameInQueue = (String) it.next();
                    for(int h=0; h<noOfPeopleRequesting; h++){
                        Members m = (Members)requesters.get(h);
                        if(m.name.equalsIgnoreCase(nameInQueue)){
                            for(int i=0; i<books.size(); i++){
                                Book b = (Book)books.get(i);
                                if(b.title.equalsIgnoreCase(bookTitle) && b.isAvailable){
                                    System.out.println("Borrowed a copy of \""+bookTitle+"\" to "+m.name);
                                    b.isAvailable = false;
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }
        return false;
    }
}
