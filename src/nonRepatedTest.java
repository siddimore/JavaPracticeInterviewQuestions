/**
 * Created by MoreFamily on 4/2/2016.
 */


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class nonRepatedTest {


    private firstNonRepeatedCharacter m;

    @Before
    public void setup()
    {
        m = new firstNonRepeatedCharacter("abc");
    }

    @Test
    public void testNonRepatedChar()
    {
        m.parseString();
        try {
            assertEquals(m.getNonRepeatedChar(), 'a');
            assertNotEquals(m.getNonRepeatedChar(), 'b');
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRepatedChar()
    {
        m.setInputString("aabc");
        m.parseString();
        try {

            assertEquals(m.getNonRepeatedChar(), 'b');
            assertNotEquals(m.getNonRepeatedChar(), 'c');
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
