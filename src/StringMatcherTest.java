/**
 * Created by MoreFamily on 4/1/2016.
 */

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
public class StringMatcherTest {
    private StringMatcher m;

    @Before
    public void setup()
    {
        m = new StringMatcher();
    }

    @Test
    public void testIsTrue()
    {
        assertTrue(m.isTrue("true"));
        assertFalse(m.isTrue("true2"));
        assertFalse(m.isTrue("True"));
    }

    @Test
    public void testIsTrueV2()
    {
        assertTrue(m.isTrueVersion2("true"));
        assertFalse(m.isTrueVersion2("true2"));
        assertTrue(m.isTrueVersion2("True"));;
    }

    @Test
    public void testLessThenThreeHundred() {
        assertTrue(m.isLessThenThreeHundred("288"));
        assertFalse(m.isLessThenThreeHundred("3288"));
        assertFalse(m.isLessThenThreeHundred("328 8"));
        assertTrue(m.isLessThenThreeHundred("1"));
        assertTrue(m.isLessThenThreeHundred("99"));
        assertFalse(m.isLessThenThreeHundred("300"));
    }


}
