package readersClub;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wil
 */
public class ClubTest {

    public Members member;

    @Before
    public void setUp() {
        member = new Staff("Wil", "Male", 22, true);
    }

    @After
    public void tearDown() throws Exception {
        member = null;
    }

    /**
     * Test of borrowBooks method, of class Club.
     */
    @Test
    public void testBorrowBooks() {
        System.out.println("borrowBook");
        int expResult = 0;
        int result = Club.borrowBooks();
        assertEquals(expResult, result);
    }

    /**
     * Test of createBook method, of class Club.
     */
    @Test
    public void testCreateBook() {
        System.out.println("createBook");
        assertNotNull(Club.createBook("title", "isbn", "author"));
    }

    /**
     * Test of createMember method, of class Club.
     */
    @Test
    public void testCreateMember() {
        System.out.println("createMember");
        String name = "";
        String sex = "";
        int age = 0;
        assertTrue(Club.createMember(name, sex, age, true) instanceof Members);
    }

    /**
     * Test of logBookRequest method, of class Club.
     */
    @Test
    public void testLogBookRequest() {
        System.out.println("logBookRequest");
        boolean expResult = true;
        boolean result = Club.logBookRequest(member, "some title");
        assertEquals(expResult, result);
    }

    /**
     * Test of getAvailableCopiesCount method, of class Club.
     */
    @Test
    public void testGetAvailableCopiesCount() {
        System.out.println("getAvailableCopiesCount");
        String bookTitle = "Bla bla bla";
        int expResult = 0;
        int result = Club.getAvailableCopiesCount(bookTitle);
        assertEquals(expResult, result);
    }
}
