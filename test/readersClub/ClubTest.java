/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class ClubTest {

    public ClubTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of borrowBook method, of class Club.
     */
    @Test
    public void testBorrowBook() {
        System.out.println("borrowBook");
        Staff member = new Staff("John Doe", "Male", 23);
        boolean result = Club.borrowBook(member);
        assertTrue(result);
    }

    /**
     * Test of createBook method, of class Club.
     */
    @Test
    public void testCreateBook() {
        System.out.println("createBook");
        boolean expResult = false;
        boolean result = Club.createBook();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Club.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Club.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        boolean expResult = false;
        boolean result = Club.createMember(name, sex, age);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pauseProg method, of class Club.
     */
    @Test
    public void testPauseProg() {
        System.out.println("pauseProg");
        int secs = 0;
        Club.pauseProg(secs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
