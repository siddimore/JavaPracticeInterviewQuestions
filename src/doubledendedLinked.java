import sun.invoke.empty.Empty;

import java.util.Hashtable;
import java.util.Map;


/**
 * Created by MoreFamily on 4/1/2016.
 */
public class doubledendedLinked {

    doubleNode head;
    int size;
    int numOfElements = 0;
    static final int MAX_Size = 50;

    doubledendedLinked(int size)
    {
        this.size = size;
    }

    public void insert(int val) throws IndexOutOfBoundsException
    {
        if(head == null)
        {
            head = new doubleNode(val);
            ++numOfElements;
        }
        else  if(numOfElements > MAX_Size)
        {
            throw new IndexOutOfBoundsException("Cannot be greater than Max Size: " + Integer.toString(MAX_Size) + Integer.toString(numOfElements));
        }
        else
        {
            doubleNode temp = head;

            while(temp.getNext() != null)
            {
                temp = temp.getNext();
            }

            temp.setNext(new doubleNode(val));
            ++ numOfElements;
        }
    }

     static class mapDemo{
         Map<String, String> m = new Hashtable<>();

         void addElementToMap(String Key, String Value)
        {
            synchronized (mapDemo.class) {
                m.put(Key, Value);
            }
            //m.put(Key, Value);
        }

         String retrieveValue(String Key)
        {
            synchronized (mapDemo.class) {
                return m.get(Key);
            }
        }
    }

    public int delete(int val) throws Exception
    {
        doubleNode temp = head;
        int retVal = 0;

        while(temp.getNext() != null)
        {
            if(temp.getData() == val)
            {
                retVal = temp.getData();
                break;
            }
        }

        if(retVal == 0)
        {
            throw new Exception("Value not found");
        }
        else
        return temp.getData();
    }

    public static void main(String[] args)
    {
//        doubledendedLinked dL = new doubledendedLinked(20);
//        try {
//            for (int i = 0; i < 100; i++) {
//                dL.insert(i);
//            }
//        }catch(IndexOutOfBoundsException ex)
//        {
//            ex.printStackTrace();
//        }
        doubledendedLinked.mapDemo map = new doubledendedLinked.mapDemo();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i < 50; i++)
                {
                    System.out.println("Adding Key: " + Integer.toString(i));
                    map.addElementToMap("Key" + Integer.toString(i), "Value" + Integer.toString(i));
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i < 50; i++)
                {
                    //mapDemo.addElementToMap("Key" + Integer.toString(i), "Value" + Integer.toString(i));
                    System.out.println(map.retrieveValue("Key" + Integer.toString(i)));
                }
            }
        });

        t1.start();
        t2.start();

//        try {
//            t1.join();
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


    }



}



