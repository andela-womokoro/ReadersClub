
package readersClub;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wil
 */
public class BookTest {

    /**
     * Test of setNoOfCopies method, of class Book.
     */
    @Test
    public void testSetNoOfCopies() {
        System.out.println("setNoOfCopies");
        Book instance = new Book("Alice in Wonderland", "233524", "Lewis Carol");
        assertTrue(instance.setNoOfCopies(1));
    }
}
