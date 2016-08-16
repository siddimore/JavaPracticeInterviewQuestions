/**
 * Created by MoreFamily on 4/17/2016.
 */


import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class ControllerTest {

    private StudentController sC;

    @Before
    public void setUp(){
        sC = new StudentController(null, null);
    }

    @Test
    public void testNull()
    {
        assertNotNull(sC);
    }

    @Test
    public void testNullModelView()
    {
        try {
            assertNull(sC.getStudentName());
            assert false;
        }catch(Exception ex){
           // ex.printStackTrace();
            assert true;
        }
    }

    @Test
    public void testSetName(){
        student model = new student();
        model.setName("Sid");
        sC.setModel(model);
        assertNotNull(sC.getStudentName());
        assertEquals("Sid", sC.getStudentName());
        String uuid = UUID.randomUUID().toString();
        model.setName(uuid);
        assertEquals(uuid,sC.getStudentName());
    }

    @Test
    public void testNullName(){
        student model = new student();
        studentview v = new studentview();

        model.setName(null);
        sC.setModel(model);
        //assertNull(sC.getStudentName());
        try{
            v.printStudentDetails(sC.getStudentName(), sC.getStudentRollNo());
            assert false;
        }
        catch(Exception ex){
            //ex.printStackTrace();
            assert true;
        }

//        assertEquals("Sid", sC.getStudentName());
//        String uuid = UUID.randomUUID().toString();
//        model.setName(uuid);
//        assertEquals(uuid,sC.getStudentName());
    }//    @Test
//    public void testSetNullName(){
//        student model = new student();
//        model.setName("Sid");
//        sC.setModel(model);
//        assertNotNull(sC.getStudentName());
//        assertEquals("Sid", sC.getStudentName());
//    }



    @After
    public void tearDown()throws Exception{
        sC = null;
    }

}
