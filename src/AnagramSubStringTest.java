import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Created by MoreFamily on 5/4/2016.
 */
public class AnagramSubStringTest {

    private AnagramSubString aS;

    @Before
    public void setUp(){
        aS = new AnagramSubString();
    }

    @Test
    public void testNull()
    {
        assertNotNull(aS);
    }

    @Test
    public void testCheckAnagramSubStringTrue(){

        AnagramSubString.permuteString("aaba");
        boolean bReturn = AnagramSubString.anagramStringExist("AAABABAA");
        assertTrue(bReturn);
    }


    @Test
    public void testCheckAnagramSubStringFalse(){

        AnagramSubString.permuteString("aaba");
        boolean bReturn = AnagramSubString.anagramStringExist("ABC");
        assertFalse(bReturn);
    }

    @Test
    public void testCheckAnagramSubStringEmptyString(){

        try {
            AnagramSubString.permuteString("");
            boolean bReturn = AnagramSubString.anagramStringExist("ABC");
        }
        catch(Exception ex)
        {
            assertTrue(ex instanceof NullPointerException);
        }
    }

    @Test
    public void testCheckAnagramSubStringNullInputString(){

        try {
            AnagramSubString.permuteString(null);
            boolean bReturn = AnagramSubString.anagramStringExist("ABC");
        }
        catch(Exception ex)
        {
            assertTrue(ex instanceof NullPointerException);
        }
    }

    @Test
    public void testCheckAnagramSubStringNullCompareString(){

        try {
            AnagramSubString.permuteString("aaba");
            boolean bReturn = AnagramSubString.anagramStringExist(null);
        }
        catch(Exception ex)
        {
            assertTrue(ex instanceof NullPointerException);
        }
    }

    @After
    public void tearDown()throws Exception{
        aS = null;
    }

}
