package readersClub;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wil
 */
public class StaffTest {

    public Staff instance;

    @Before
    public void setUp() {
        instance = new Staff("Wil", "Male", 22, true);
    }

    @After
    public void tearDown() throws Exception {
        instance = null;
    }

    /**
     * Test of requestForBook method, of class Staff.
     */
    @Test
    public void testRequestForBook() {
        System.out.println("requestForBook");
        boolean requestGranted = instance.requestForBook();
        assertTrue(requestGranted);
    }

    /**
     * Test of getSalary method, of class Staff.
     */
    @Test
    public void testGetSalary() {
        System.out.println("getSalary");
        double expResult = 0.0;
        double result = instance.getSalary();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setWorkHours method, of class Staff.
     */
    @Test
    public void testSetWorkHours() {
        System.out.println("setWorkHours");
        boolean result = instance.setWorkHours(1120);
        assertTrue(result);
    }
}
