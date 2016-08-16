/**
 * Created by MoreFamily on 4/15/2016.
 */


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerTest {

    //private ProducerThread pThread;
    //private ConsumerThread cThread;
    private static List<Integer> tQ;
    private static final int MAX_CAPACITY = 5;
    public static void main(String[] args){

        ProducerThread pThread;
        ConsumerThread cThread;
        tQ = new ArrayList<>();

        pThread = new ProducerThread(tQ, MAX_CAPACITY);
        cThread = new ConsumerThread(tQ);

        Thread pT = new Thread(pThread);
        Thread cT = new Thread(cThread);

        pT.start();
        cT.start();
    }

//    @Before
//    public void setup(){
//        pThread = new ProducerThread(tQ, MAX_CAPACITY);
//        cThread = new ConsumerThread(tQ);
//    }
//
//    @Test
//    public void runThread(){
//        Thread pT = new Thread(pThread);
//        Thread cT = new Thread(cThread);
//
//        pT.start();
//        cT.start();
//    }

}
