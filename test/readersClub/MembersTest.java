
package readersClub;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wil
 */
public class MembersTest {
    String name;
    String sex;
    int age;
    MembersImpl instance;
    
    @Before
    public void setUp() {
        name = "Wil";
        sex = "Male";
        age = 25;
        instance = new MembersImpl(name, sex, age);
    }

    @After
    public void tearDown() throws Exception {
        instance = null;
    }

    /**
     * Test of getName method, of class Members.
     */
    @Test
    public void testGetName() {
        String expResult = name;
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAge method, of class Members.
     */
    @Test
    public void testGetAge() {
        int expResult = age;
        int result = instance.getAge();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSex method, of class Members.
     */
    @Test
    public void testGetSex() {
        String expResult = sex;
        String result = instance.getSex();
        assertEquals(expResult, result);
    }
    

    public class MembersImpl extends Members {

        public MembersImpl(String name, String sex, int age) {
            super(name, sex, age);
        }
    }
}
