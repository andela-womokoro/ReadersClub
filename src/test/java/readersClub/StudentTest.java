package readersClub;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wil
 */
public class StudentTest {

    public Student instance;

    public StudentTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new Student("Mary", "Female", 15, false);
    }

    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of getSubjectOfInterest method, of class Student.
     */
    @Test
    public void testGetSubjectOfInterest() {
        System.out.println("getSubjectOfInterest");
        String subject = "Politics";
        String expResult = subject;
        instance.setSubjectOfInterest(subject);
        String result = instance.getSubjectOfInterest();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSubjectOfInterest method, of class Student.
     */
    @Test
    public void testSetSubjectOfInterest() {
        System.out.println("setSubjectOfInterest");
        boolean result = instance.setSubjectOfInterest("Some subject...");
        assertTrue(result);
    }

    /**
     * Test of requestForBook method, of class Student.
     */
    @Test
    public void testRequestForBook() {
        System.out.println("requestForBook");
        boolean requestGranted = instance.requestForBook("Some  book title");
        assertTrue(requestGranted);
    }
}
