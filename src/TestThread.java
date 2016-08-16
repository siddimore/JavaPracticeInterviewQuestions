/**
 * Created by MoreFamily on 3/9/2016.
 */
public class TestThread implements Runnable{

    private Thread t;
    private String threadName;

    TestThread(String name)
    {
        threadName = name;
        System.out.println("Thread:" + threadName);
    }

    @Override
    public void run()
    {
        System.out.println("Thread:" + threadName);
        try
        {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(50);
            }
        }
        catch(InterruptedException ex)
        {
            System.out.println("Thread " +  threadName + " interrupted.");
            ex.printStackTrace();
        }
    }
}
