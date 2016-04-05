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

    /**
     * Execution starting point of the reader's club program.
     * @param args 
     */
    public static void main(String[] args) {
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
        System.out.println("Staff Queue >>> " + staffList);
        System.out.println("Students' Queue >>> " + studentsList);

        // display books
        System.out.println("\nBooks' status before being borrowed:");
        displayBooks();

        // some members will request for books
        System.out.println("");
        m3.requestForBook("Spectre");
        m4.requestForBook("Spectre");
        m1.requestForBook("Spectre");
        m6.requestForBook("Havoc Junction");
        m5.requestForBook("Havoc Junction");
        m2.requestForBook("Havoc Junction");
        m1.requestForBook("Havoc Junction");

        //borrow books to members who requested for them
        borrowBook();

        // display books
        System.out.println("\nBooks' status after being borrowed:");
        displayBooks();
    }

    /**
     * This method is used to create books for the reader's club.
     * @param title
     * @param isbn
     * @param author
     * @return 
     */
    public static boolean createBook(String title, String isbn, String author) {
        Book book = null;
        int copies = new Random().nextInt(3) + 1;

        for (int i = 0; i < copies; i++) {
            book = new Book(title, isbn, author);
            book.setNoOfCopies(copies);
            books.add(book);
        }

        return Objects.nonNull(book);
    }

    /**
     * This method simply displays all the existing books and their current state
     */
    public static void displayBooks() {
        for (int i = 0; i < books.size(); i++) {
            Book b = (Book) books.get(i);
            System.out.println(b.title + ". (available: " + b.isAvailable + ")");
        }
    }

    /**
     * This method is used to create the two categories of members of the readers club; staff and students
     * @param name
     * @param sex
     * @param age
     * @param isStaff
     * @return 
     */
    public static Members createMember(String name, String sex, int age, boolean isStaff) {
        Members member;

        if (isStaff) {
            member = new Staff(name, sex, age, isStaff);
            staffList.add(member.name);
        } else {
            member = new Student(name, sex, age, isStaff);
            studentsList.add(member.name);
        }

        return member;
    }

    /**
     * When members request to borrow books, this method logs the members requests
     * @param member
     * @param bookTitle
     * @return 
     */
    public static boolean logBookRequest(Members member, String bookTitle) {
        System.out.println(member.name + " has requested to borrow a copy of \"" + bookTitle + "\"");
        ArrayList requesters;

        if (bookRequests.containsKey(bookTitle)) {
            requesters = (ArrayList) bookRequests.get(bookTitle);
        } else {
            requesters = new ArrayList();
        }

        requesters.add(member);
        bookRequests.put(bookTitle, requesters);

        return true;
    }

    /**
     * This method handles the actual process of borrowing books to members based on rank and position in queue.
     * @return 
     */
    public static boolean borrowBook() {
        //Next for loop iterates through all book requests. Book requests are handled one after the other
        for (String key : bookRequests.keySet()) {
            String bookTitle = key;
            System.out.println("\nProcessing request(s) for \"" + bookTitle + "\"...");

            ArrayList requesters = bookRequests.get(bookTitle);
            int noOfPeopleRequesting = requesters.size();

            System.out.println(noOfPeopleRequesting + " person(s) requested for \"" + bookTitle + "\".");
            System.out.println(getAvailableCopiesCount(bookTitle) + " copies of \"" + bookTitle + "\" are available.");
 
            /*
            Next for loop performs 2 iterations to iterate through both members' queues;
            first iteration covers the staff queue, and next iteration covers the students' queue
            */
            for (int g = 0; g <= 1; g++) {
                Iterator it;
                if (g == 0) {
                    it = staffList.iterator();
                } else {
                    it = studentsList.iterator();
                }

                /*
                Next while loop checks the names of members who made a request against the names of each member on
                the current queue
                */
                String nameInQueue;
                while (it.hasNext()) {
                    nameInQueue = (String) it.next();
                    /*
                    Next for loop checks if the current member extracted in the previous line is among 
                    members who made a request for the book
                    */
                    for (int h = 0; h < noOfPeopleRequesting; h++) {
                        Members m = (Members) requesters.get(h);
                        if (m.name.equalsIgnoreCase(nameInQueue)) {
                            /*
                            Next for loop searches the club's book collection for the requested book.
                            If the book is found and a copy is available, it is borrowed to the current member.
                            */
                            for (int i = 0; i < books.size(); i++) {
                                Book b = (Book) books.get(i);
                                if (b.title.equalsIgnoreCase(bookTitle) && b.isAvailable) {
                                    System.out.println("Borrowed a copy of \"" + bookTitle + "\" to " + m.name);
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

    /**
     * This method simply returns the number of copies of a particular book that are still available
     * @param bookTitle
     * @return 
     */
    public static int getAvailableCopiesCount(String bookTitle) {
        //iterate through books collection to see how many copies of the requested book are available
        int copiesAvailable = 0;
        for (int i = 0; i < books.size(); i++) {
            Book b = (Book) books.get(i);
            if (b.title.equalsIgnoreCase(bookTitle) && b.isAvailable) {
                copiesAvailable++;
            }
        }

        return copiesAvailable;
    }
}
