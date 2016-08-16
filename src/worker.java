/**
 * Created by MoreFamily on 3/10/2016.
 */
public class worker implements Runnable{
    @Override
    public void run()
    {
        for(int i =0; i < 5; i++)
        {
            try {
                Thread.sleep(300);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
